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
import net.greatsoft.main.db.po.old.ElderCognition;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuCognitionView;

import java.io.File;

/**
 * Created by zhanglin on 2016/11/26.
 * 老年人认知功能
 */

public class FuCognitionFragment extends FragmentParent {

    ElderCognition mElderCognition;
    String personInfoName;
    private PersonInfo mPersonInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_COGNITION, getActivity(),
                new OnEventClick());

        createData();
        setData();

        return mModel.getFuView();
    }

    private void createData() {

        mElderCognition = new ElderCognition();
        mElderCognition.setPersonInfoId(personInfoId);
        mElderCognition.setName(personInfoName);

    }

    public static final int EVENT_SAVE_COGNITION = 999;//老年人认知功能随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_COGNITION:
                    saveData();
                    break;
            }
        }
    }

    private void setData() {
        ((FuCognitionView) mModel).setData(mElderCognition, mPersonInfo);
    }

    public void saveData() {
        ((FuCognitionView) mModel).saveData(mElderCognition);
        saveElderCognition();
    }

    /**
     * elderInfo//saveElderCognition
     */

    public void saveElderCognition() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveElderCognition(getCallBackInstance(), mElderCognition, getContext());

        excuteNetTask(lTask, false);
    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        personInfoName = bundle.getString("personInfoName");
        mPersonInfo = ((PersonInfo) bundle.getSerializable("personInfo"));
        file = (File) bundle.getSerializable("file");
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_ELDER_COGNITION:
                    savePics(mElderCognition.getElderCognitionId(), Constant.SERVICE_ITEM_4003, file);
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
                case MyTask.SAVE_ELDER_COGNITION:
                    message.what = taskId;
                    mElderCognition = JSON.parseObject(rspObj.getResult(), ElderCognition.class);
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
