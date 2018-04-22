package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuCerebralInfoView;

import java.io.File;
import java.util.List;

/**
 * Date: 2017/03/23
 * Time: 13:53
 * progject: Chss
 * Describe： 脑卒中专档
 */

public class FuCerebralInfoFragment extends FragmentParent {

    CerebralApoplexyInfo cerebralInfo;
    PersonInfo personInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CEREBRAL_INFO, getActivity(),
                new OnEventClick());

        createData();
        findPersonInfoByPersonInfoId();
        return mModel.getFuView();
    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        file = (File) bundle.getSerializable("file");
    }

    private void findPersonInfoByPersonInfoId() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    private void createData() {
        if (cerebralInfo == null) {
            cerebralInfo = new CerebralApoplexyInfo();
            cerebralInfo.setPersonInfoId(personInfoId);
        }
    }

    public static final int EVENT_SAVE_CEREBRAL_INFO = 133;//保存脑卒中专档

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CEREBRAL_INFO:
                    saveData();
                    break;
            }
        }
    }

    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("4");
        ((FuCerebralInfoView) mModel).setMedicine(sickMedicineList);
        ((FuCerebralInfoView) mModel).setData(personInfo);
    }

    private void saveData() {
        if (((FuCerebralInfoView) mModel).saveData(cerebralInfo))
            saveCerebralInfo();
    }

    private void saveCerebralInfo() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveCerebralInfo(getCallBackInstance(), cerebralInfo, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_CEREBRAL_INFO:
                    savePics(cerebralInfo.getCerebralApoplexyInfoId(), Constant.SERVICE_ITEM_5018, file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.FIND_PERSON:
                    setData();
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
                case MyTask.SAVE_CEREBRAL_INFO:
                    message.what = taskId;
                    cerebralInfo = JSON.parseObject(rspObj.getResult(), CerebralApoplexyInfo.class);
                    message.sendToTarget();
                    break;
                case MyTask.FIND_PERSON:
                    personInfo = JSONObject.parseObject(rspObj.getResult(), PersonInfo.class);

                    Message messagePerson = Message.obtain(mHandler);
                    messagePerson.what = taskId;
                    messagePerson.sendToTarget();
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
