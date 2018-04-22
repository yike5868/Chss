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
import net.greatsoft.main.db.po.child.ChildInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuChildInfoView;

import java.io.File;
import java.util.List;

/**
 * Date: 2017/03/21
 * Time: 15:05
 * progject: Chss
 * Describe： 儿童专档(花名册)
 */

public class FuChildInfoFragment extends FragmentParent {

    PersonInfo personInfo;
    File file;
    ChildInfo childInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CHILD_INFO, getActivity(),
                new OnEventClick());

        createData();
        findPersonInfoByPersonInfoId();
        return mModel.getFuView();
    }

    private void findFatherListByPersonInfoId() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .findFaterhListByPersonInfoId(getCallBackInstance(), personInfoId, "1", getContext());

        excuteNetTask(lTask, true);
    }

    private void findMotherListByPersonInfoId() {

        MyTask lTask1 = TaskManager.getInstace(getActivity())
                .findMotherListByPersonInfoId(getCallBackInstance(), personInfoId, "2", getContext());

        excuteNetTask(lTask1, true);
    }


    private void findPersonInfoByPersonInfoId() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    private void createData() {
        if (childInfo == null) {
            childInfo = new ChildInfo();
            childInfo.setPersonInfoId(personInfoId);
        }
    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        file = (File) bundle.getSerializable("file");
    }

    public static final int EVENT_SAVE_CHILD_INFO = 2;//保存儿童花名册

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CHILD_INFO:
                    saveData();
                    break;
            }
        }
    }

    private void setData() {
        ((FuChildInfoView) mModel).setData(personInfo);
    }

    private void saveData() {
        if (((FuChildInfoView) mModel).saveData(childInfo))
            saveChildInfo();
    }

    private void saveChildInfo() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveChildInfo(getCallBackInstance(), childInfo, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_CHILD_INFO:
                    savePics(childInfo.getChildInfoId(), Constant.SERVICE_ITEM_2009, file);
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
                    ((FuChildInfoView) mModel).setFatherList(fahterList);
                    findMotherListByPersonInfoId();
                    break;
                case MyTask.FIND_MOTHERLIST:
                    List<PersonInfo> motherList = (List<PersonInfo>) msg.obj;
                    ((FuChildInfoView) mModel).setMotherList(motherList);
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
                case MyTask.SAVE_CHILD_INFO:
                    message.what = taskId;
                    childInfo = JSON.parseObject(rspObj.getResult(), ChildInfo.class);
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
                case MyTask.FIND_MOTHERLIST:
                    List<PersonInfo> motherList = JSONArray.parseArray(rspObj.getResult(), PersonInfo.class);
                    Message motherMessage = Message.obtain(mHandler);
                    motherMessage.obj = motherList;
                    motherMessage.what = taskId;
                    motherMessage.sendToTarget();
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
        Message message = Message.obtain(mHandler);
        message.what = NET_ERROR;
        message.obj = "网络连接失败";
        message.sendToTarget();
    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
