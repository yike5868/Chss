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
import net.greatsoft.main.db.po.child.ChildHealthExam;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuChildHealthExam03View;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/12.
 */

public class FuChildHealthExam03Fragment extends FragmentParent {
    ChildHealthExam childHealthExam;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CHILD_HEALTH_EXAM_03, getActivity(),
                new OnEventClick());

        ((FuChildHealthExam03View) mModel).setData(childHealthExam);
        return mModel.getFuView();
    }

    public static final int EVENT_SAVE_HEALTH = 1;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_HEALTH:
                    saveHealthExam();
                    break;
            }
        }
    }

    public void saveHealthExam() {

        if (!((FuChildHealthExam03View) mModel).saveData(childHealthExam))
            return;

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveChildHealthExam(getCallBackInstance(), childHealthExam, getContext());

        excuteNetTask(lTask, false);
    }

    public void initData(Bundle bundle) {
        childHealthExam = new ChildHealthExam();
        childHealthExam.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        childHealthExam.setNewbornName(personInfo.getName());
        file = (File) bundle.getSerializable("file");
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_CHILD_HEALTH_EXAM:
                    savePics(childHealthExam.getChildHealthExamId(), Constant.SERVICE_ITEM_2006, file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;

            }
        }
    };

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {
        if (rspObj == null || rspObj.getCode() == null) {
            Message message = Message.obtain(mHandler);
            message.what = NET_ERROR;
            message.obj = "网络连接失败";
            message.sendToTarget();
            return;
        }
        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            switch (taskId) {
                case MyTask.SAVE_CHILD_HEALTH_EXAM:
                    Message messageSavePerson = Message.obtain(mHandler);
                    messageSavePerson.what = taskId;
                    childHealthExam = JSON.parseObject(rspObj.getResult(), ChildHealthExam.class);
                    messageSavePerson.sendToTarget();

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
