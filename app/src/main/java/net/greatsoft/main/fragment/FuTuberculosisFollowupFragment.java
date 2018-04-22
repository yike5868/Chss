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
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFollowup;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuTuberculosisFollowupView;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/23.
 */

public class FuTuberculosisFollowupFragment extends FragmentParent {

    TuberculosisFollowup tuberculosisFollowup;
    TuberculosisInfo mTuberculosisInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    public static final int SAVE_TUBERCULOSIS_FOLLOWUP = 1;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case SAVE_TUBERCULOSIS_FOLLOWUP:
                    saveData();
                    break;
            }
        }
    }

    public void initData(Bundle bundle) {
        tuberculosisFollowup = new TuberculosisFollowup();
        mTuberculosisInfo = (TuberculosisInfo) bundle.getSerializable("tuberculosisInfo");
        tuberculosisFollowup.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        tuberculosisFollowup.setName(personInfo.getName());
        tuberculosisFollowup.setTuberculosisFollowupNo(personInfo.getPersonInfoNo());
        file = (File) bundle.getSerializable("file");
    }

    public void setData() {
        ((FuTuberculosisFollowupView) mModel).setData(tuberculosisFollowup);
    }

    public void saveData() {
        if (((FuTuberculosisFollowupView) mModel).saveData(tuberculosisFollowup, mTuberculosisInfo)) {
            saveTuberculosisFollowup();
//            updateTuberculosisInfo();
        }
    }

    private void updateTuberculosisInfo() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .updateTuberculosisFollowup(getCallBackInstance(), mTuberculosisInfo, getContext());

        excuteNetTask(lTask, false);
    }

    public void saveTuberculosisFollowup() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveTuberculosisFollowup(getCallBackInstance(), tuberculosisFollowup, mTuberculosisInfo, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.UPDATE_TUBERCULOSIS_INFO:
                case MyTask.SAVE_TUBERCULOSIS_FOLLOWUP:
                    savePics(tuberculosisFollowup.getTuberculosisFollowupId(), Constant.SERVICE_ITEM_5006, file);
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
                case MyTask.SAVE_TUBERCULOSIS_FOLLOWUP:
                    message.what = taskId;
                    tuberculosisFollowup = JSON.parseObject(rspObj.getResult(), TuberculosisFollowup.class);
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
