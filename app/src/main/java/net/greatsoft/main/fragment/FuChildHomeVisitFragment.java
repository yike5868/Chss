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
import net.greatsoft.main.db.po.child.ChildHomeVisit;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuChildHomeVisitView;

import java.io.File;

/**
 * Created by zhanglin on 2016/12/12.
 */

public class FuChildHomeVisitFragment extends FragmentParent {

    ChildHomeVisit childHomeVisit;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CHILD_HOME_VISIT, getActivity(),
                new OnEventClick());

        ((FuChildHomeVisitView) mModel).setData(childHomeVisit,personInfo);
        return mModel.getFuView();
    }

    public void saveChildHomeVisit() {

        if (!((FuChildHomeVisitView) mModel).saveData(childHomeVisit))
            return;


        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveChildHomeVisit(getCallBackInstance(), childHomeVisit, getContext());

        excuteNetTask(lTask, false);
    }


    public static final int EVENT_SAVE_CHILD_HOME_VISIT = 1;//保存新生儿访视

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CHILD_HOME_VISIT:
                    saveChildHomeVisit();
                    break;
            }
        }
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_CHILD_HOME_VISIT:
                    savePics(childHomeVisit.getChildHomeVisitId(), Constant.SERVICE_ITEM_2004, file);
                    break;

            }
        }
    };

    public void initData(Bundle bundle) {

        childHomeVisit = new ChildHomeVisit();
        childHomeVisit.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        childHomeVisit.setNewbornName(personInfo.getName());
        file = (File) bundle.getSerializable("file");
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
                case MyTask.SAVE_CHILD_HOME_VISIT:
                    Message messageSavePerson = Message.obtain(mHandler);
                    messageSavePerson.what = taskId;
                    childHomeVisit = JSON.parseObject(rspObj.getResult(), ChildHomeVisit.class);
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
