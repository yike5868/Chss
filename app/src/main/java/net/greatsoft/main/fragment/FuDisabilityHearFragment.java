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
import net.greatsoft.main.db.po.disability.DisabilityHearing;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuDisabilityHearView;

import java.io.File;

/**
 * Date: 2017/03/29
 * Time: 14:58
 * progject: Chss
 * Describe： 听力言语残疾
 */

public class FuDisabilityHearFragment extends FragmentParent {

    DisabilityHearing mDisabilityHearing;
    PersonInfo personInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DISABILITY_HEAR, getActivity(),
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
        if (mDisabilityHearing == null) {
            mDisabilityHearing = new DisabilityHearing();
            mDisabilityHearing.setPersonInfoId(personInfoId);
        }
    }

    public static final int EVENT_SAVE_DISABILITY_HEAR = 22;//保存听力言语残疾随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_DISABILITY_HEAR:
                    saveData();
                    break;
            }
        }
    }

    private void setData() {
        ((FuDisabilityHearView) mModel).setData(personInfo);
    }

    private void saveData() {
        if (((FuDisabilityHearView) mModel).saveData(mDisabilityHearing))
            saveDisabilityHear();

    }

    private void saveDisabilityHear() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveDisabilityHear(getCallBackInstance(), mDisabilityHearing, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_DISABILITY_HEAR:
                    savePics(mDisabilityHearing.getDisabilityHearingId(), Constant.SERVICE_ITEM_9001, file);
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
                case MyTask.SAVE_DISABILITY_HEAR:
                    message.what = taskId;
                    mDisabilityHearing = JSON.parseObject(rspObj.getResult(), DisabilityHearing.class);
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
