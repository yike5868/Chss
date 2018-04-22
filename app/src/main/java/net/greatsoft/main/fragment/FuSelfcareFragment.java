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
import net.greatsoft.main.db.po.old.ElderSelfcareAbility;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuSelfcareView;

import java.io.File;

/**
 * Created by zhanglin on 2016/11/26.
 */

public class FuSelfcareFragment extends FragmentParent {

    ElderSelfcareAbility mSelfcareAbility;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_SELFCARE, getActivity(),
                new OnEventClick());
        return mModel.getFuView();
    }

    public void initData(Bundle bundle) {

        mSelfcareAbility = new ElderSelfcareAbility();
        mSelfcareAbility.setPersonInfoId(bundle.getString("personInfoId"));
        file = (File) bundle.getSerializable("file");
    }

    public static final int EVENT_SAVE_SELFCARE = 178;//老年人认知功能随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_SELFCARE:
                    saveData();
                    break;
            }
        }
    }

    public void saveElderSelfcareAbility() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveElderSelfcareAbility(getCallBackInstance(), mSelfcareAbility, getContext());
        excuteNetTask(lTask, false);
    }


    private void saveData() {

        if (((FuSelfcareView) mModel).saveData(mSelfcareAbility))
            saveElderSelfcareAbility();

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_ELDER_SELFCARE_ABILITY:
                    savePics(mSelfcareAbility.getElderSelfcareAbilityId(), Constant.SERVICE_ITEM_4001, file);
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
                case MyTask.SAVE_ELDER_SELFCARE_ABILITY:
                    Message messageSavePerson = Message.obtain(mHandler);
                    messageSavePerson.what = taskId;
                    mSelfcareAbility = JSON.parseObject(rspObj.getResult(), ElderSelfcareAbility.class);
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
