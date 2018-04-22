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
import net.greatsoft.main.db.po.maternal.MaternalFollowup;
import net.greatsoft.main.db.po.maternal.MaternalRegister;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuMaternalFollowupView;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/15.
 */

public class FuMaternalFollowupFragment extends FragmentParent {

    MaternalFollowup maternalFollowup;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(FuUiFrameManager.FU_MATERNAL_FOLLOW_UP,
                getActivity(), new EventCallBack());
        ((FuMaternalFollowupView) mModel).setData(maternalFollowup);
        return mModel.getFuView();
    }



    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_MATERNAL_FOLLOWUP:
                    savePics(maternalFollowup.getMaternalFollowupId(), Constant.SERVICE_ITEM_3002, file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;

            }
        }
    };
    //MaternalFollowup
    public static final int EVENT_SAVE_MATERNAL_FOLLOWUP = 1;//保存

    class EventCallBack implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_SAVE_MATERNAL_FOLLOWUP:
                    saveMaternalFirstFollowup();
                    break;
            }
        }
    }

    public void saveMaternalFirstFollowup() {

        if (!((FuMaternalFollowupView) mModel).saveData(maternalFollowup))
            return;


        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveMaternalFollowup(getCallBackInstance(), maternalFollowup, getContext());

        excuteNetTask(lTask, false);
    }



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
                case MyTask.SAVE_MATERNAL_FOLLOWUP:
                    Message messageSavePerson = Message.obtain(mHandler);
                    messageSavePerson.what = taskId;
                    maternalFollowup = JSON.parseObject(rspObj.getResult(), MaternalFollowup.class);
                    messageSavePerson.sendToTarget();

                    break;
            }
        }else {
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
        maternalFollowup = new MaternalFollowup();
        maternalFollowup.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        MaternalRegister maternalRegister =(MaternalRegister) bundle.getSerializable("maternalRegister");
        maternalFollowup.setMaternalRegisterId(maternalRegister.getMaternalRegisterId());
        maternalFollowup.setName(personInfo.getName());
        file = (File) bundle.getSerializable("file");
    }
}
