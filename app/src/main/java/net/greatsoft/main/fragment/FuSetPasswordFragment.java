package net.greatsoft.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuLoginRegistActivity;
import net.greatsoft.main.activity.FuMainActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;

/**
 * Created by sunguodong on 2017/5/4.
 */

public class FuSetPasswordFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_SET_PASSWORD, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }

    public static final int EVENT_SURE = 1;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

            switch (event) {
                case EVENT_SURE:
                    Bundle bundle = (Bundle) object;
                    String newpassword = bundle.getString("new_password");
                    String oldpassword = bundle.getString("old_password");
                    setPassword(newpassword, oldpassword);
                    break;
            }
        }
    }

    public void setPassword(String newpassword, String oldpassword) {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .setPassword(getCallBackInstance(), newpassword, oldpassword, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), "修改密码失败", Toast.LENGTH_LONG);
                    break;
                case MyTask.SET_PASSWORD:
                    ToastUtil.showToast(getContext(), "修改密码成功，请重新登录", Toast.LENGTH_LONG);
                    Intent intent = new Intent(getContext(), FuLoginRegistActivity.class);
                    startActivity(intent);
                    ((FuMainActivity) getActivity()).finish();

//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Thread.sleep(2000);
//                                System.exit(0);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();

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
                case MyTask.SET_PASSWORD:
                    message.what = taskId;
                    message.sendToTarget();
                    break;
            }
        } else {
            Message error = Message.obtain(mHandler);
            error.what = MyTask.ERROR;
            error.sendToTarget();
        }
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
