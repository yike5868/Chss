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
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFirstFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuTuberculosisFirstFollowupView;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/23.
 */

public class FuTuberculosisFirstFollowupFragment extends FragmentParent {

    TuberculosisFirstFollowup tuberculosisFirstFollowup;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_TUBERCULOSIS_FIRST_FOLLOWUP, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    public static final int SAVE_TUBERCULOSIS_FIRST_FOLLOWUP = 1;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case SAVE_TUBERCULOSIS_FIRST_FOLLOWUP:
                    saveData();
                    break;
            }
        }
    }

    public void initData(Bundle bundle) {
        tuberculosisFirstFollowup = new TuberculosisFirstFollowup();
        tuberculosisFirstFollowup.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        tuberculosisFirstFollowup.setName(personInfo.getName());
        tuberculosisFirstFollowup.setTuberculosisFirstFollowupNo(personInfo.getPersonInfoNo());
        file = (File) bundle.getSerializable("file");
    }

    public void setData() {
        ((FuTuberculosisFirstFollowupView) mModel).setData(tuberculosisFirstFollowup);
    }

    public void saveData() {
        if (((FuTuberculosisFirstFollowupView) mModel).saveData(tuberculosisFirstFollowup))
            saveTuberculosisFirstFollowup();
    }

    public void saveTuberculosisFirstFollowup() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveTuberculosisFirstFollowup(getCallBackInstance(), tuberculosisFirstFollowup, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_TUBERCULOSIS_FIRST_FOLLOWUP:
                    savePics(tuberculosisFirstFollowup.getTuberculosisFirstFollowupId(), Constant.SERVICE_ITEM_5007, file);
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
                case MyTask.SAVE_TUBERCULOSIS_FIRST_FOLLOWUP:
                    message.what = taskId;
                    tuberculosisFirstFollowup = JSON.parseObject(rspObj.getResult(), TuberculosisFirstFollowup.class);
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
