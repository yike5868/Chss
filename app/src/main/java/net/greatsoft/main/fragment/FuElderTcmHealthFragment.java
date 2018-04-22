package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.old.ElderTcmHealth;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuElderTcmHealthView;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/21.
 * 老年人中医药健康管理
 */

public class FuElderTcmHealthFragment extends FragmentParent {

    ElderTcmHealth elderTcmHealth;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_ELDER_TCM, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    private void saveData() {
        if (((FuElderTcmHealthView) mModel).saveData(elderTcmHealth))
            saveElderTcmHealth();
    }

    private void setData() {
        ((FuElderTcmHealthView) mModel).setData(elderTcmHealth);
    }

    /**
     * elderInfo//saveElderCognition
     */

    public void saveElderTcmHealth() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveElderTcmHealth(getCallBackInstance(), elderTcmHealth, getContext());

        excuteNetTask(lTask, false);
    }


    public void initData(Bundle bundle) {
        elderTcmHealth = new ElderTcmHealth();
        elderTcmHealth.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        elderTcmHealth.setName(personInfo.getName());
        file = (File) bundle.getSerializable("file");
    }

    public static final int EVENT_SAVE_ELDER_TCM_HEALTH = 999;//老年人中医药

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_ELDER_TCM_HEALTH:
                    saveData();
                    break;
            }
        }
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_ELDER_TCM_HEALTH:
                    savePics(elderTcmHealth.getElderTcmHealthId(), Constant.SERVICE_ITEM_4004, file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
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
                case MyTask.SAVE_ELDER_TCM_HEALTH:
                    message.what = taskId;
                    elderTcmHealth = JSON.parseObject(rspObj.getResult(), ElderTcmHealth.class);
                    message.sendToTarget();
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
