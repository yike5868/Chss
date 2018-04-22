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
import net.greatsoft.main.db.po.smi.SmiInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuSmiInfoView;

import java.io.File;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/12/21
 * Time: 10:37
 * progject: Chss
 * Describe： 重性精神病个人信息补充表
 */

public class FuSmiInfoFragment extends FragmentParent {

    SmiInfo smiInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_SMI_INFO, getActivity(),
                new OnEventClick());
        setData();

        return mModel.getFuView();
    }

    public static final int EVENT_SAVE_SMI_INFO = 1;//保存高血压随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_SMI_INFO:
                    saveData();
                    break;
            }
        }
    }

    private void saveData() {
        if (((FuSmiInfoView) mModel).saveData(smiInfo)) {
            saveDiabetesFollowup();
        }
    }

    public void saveDiabetesFollowup() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveSmiInfo(getCallBackInstance(), smiInfo, getContext());

        excuteNetTask(lTask, false);
    }

    private void setData() {
        ((FuSmiInfoView) mModel).setData(smiInfo);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_SMI_INFO:
                    savePics(smiInfo.getSmiInfoId(), Constant.SERVICE_ITEM_5014, file);
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
                case MyTask.SAVE_SMI_INFO:
                    message.what = taskId;
                    smiInfo = JSON.parseObject(rspObj.getResult(), SmiInfo.class);
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

    public void initData(Bundle bundle) {
        smiInfo = new SmiInfo();
        smiInfo.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo)bundle.getSerializable("personInfo");
        smiInfo.setName(personInfo.getName());
        file = (File) bundle.getSerializable("file");
    }
}
