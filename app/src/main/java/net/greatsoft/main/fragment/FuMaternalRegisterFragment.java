package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.maternal.MaternalRegister;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuMaternalRegisterView;

import java.io.File;
import java.util.List;

/**
 * Date: 2017/04/05
 * Time: 13:10
 * progject: Chss
 * Describe： 孕产登记
 */

public class FuMaternalRegisterFragment extends FragmentParent {

    MaternalRegister maternalRegister;
    PersonInfo personInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_MATERNAL_REGISTER, getActivity(),
                new OnEventClick());
        createData();
        findPersonInfoByPersonInfoId();
        return mModel.getFuView();
    }

    private void createData() {
        if (maternalRegister == null) {
            maternalRegister = new MaternalRegister();
            maternalRegister.setPersonInfoId(personInfoId);
        }

    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        file = (File) bundle.getSerializable("file");
    }

    public void findPersonInfoByPersonInfoId() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    private void findFatherListByPersonInfoId() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .findFaterhListByPersonInfoId(getCallBackInstance(), personInfoId, "1", getContext());

        excuteNetTask(lTask, true);
    }

    public static final int EVENT_SAVE_MATERNAL_REGISTER = 776;//保存孕产妇专档

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_MATERNAL_REGISTER:
                    saveData();
                    break;
            }
        }
    }

    public void setData() {
        ((FuMaternalRegisterView) mModel).setData(personInfo);
    }

    public void saveData() {

        if (((FuMaternalRegisterView) mModel).saveData(maternalRegister))
            saveMaternalRegister();
    }

    private void saveMaternalRegister() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveMaternalRegister(getCallBackInstance(), maternalRegister, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_MATERNAL_REGISTER:
                    savePics(maternalRegister.getMaternalRegisterId(), Constant.SERVICE_ITEM_3005, file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.FIND_PERSON:
                    setData();
                    findFatherListByPersonInfoId();
                    break;
                case MyTask.FIND_FATHERLIST:
                    List<PersonInfo> fahterList = (List<PersonInfo>) msg.obj;
                    ((FuMaternalRegisterView) mModel).setFatherList(fahterList);
                    break;

            }
        }
    };

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {
        Message message = Message.obtain(mHandler);
        if (rspObj == null || rspObj.getCode() == null) {

            message.what = NET_ERROR;
            message.obj = "网络连接失败";
            message.sendToTarget();
            return;
        }

        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            switch (taskId) {
                case MyTask.SAVE_MATERNAL_REGISTER:
                    message.what = taskId;
                    maternalRegister = JSON.parseObject(rspObj.getResult(), MaternalRegister.class);
                    message.sendToTarget();
                    break;
                case MyTask.FIND_PERSON:
                    personInfo = JSONObject.parseObject(rspObj.getResult(), PersonInfo.class);

                    Message messagePerson = Message.obtain(mHandler);
                    messagePerson.what = taskId;
                    messagePerson.sendToTarget();
                    break;
                case MyTask.FIND_FATHERLIST:
                    List<PersonInfo> fatherList = JSONArray.parseArray(rspObj.getResult(), PersonInfo.class);
                    Message fatherMessage = Message.obtain(mHandler);
                    fatherMessage.obj = fatherList;
                    fatherMessage.what = taskId;
                    fatherMessage.sendToTarget();
                    break;
            }
        } else {
            Message error = Message.obtain(mHandler);
            error.what = MyTask.ERROR;
            error.obj = rspObj.getMessage();
            error.sendToTarget();
        }
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
