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
import net.greatsoft.main.db.po.disability.DisabilityVisual;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuDisabilityVisualView;

import java.io.File;

import static net.greatsoft.main.fragment.FuDisabilityHearFragment.EVENT_SAVE_DISABILITY_HEAR;

/**
 * Date: 2017/04/05
 * Time: 09:23
 * progject: Chss
 * Describe： 视力残疾随访
 */

public class FuDisabilityVisualFragment extends FragmentParent {

    DisabilityVisual disabilityVisual;
    PersonInfo personInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DISABILITY_VISUAL, getActivity(),
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
        if (disabilityVisual == null) {
            disabilityVisual = new DisabilityVisual();
            disabilityVisual.setPersonInfoId(personInfoId);
        }
    }

    public static final int EVENT_SAVE_DISABILITY_VISUAL = 23;//保存视力残疾随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_DISABILITY_VISUAL:
                    saveData();
                    break;
            }
        }
    }

    private void setData() {
        ((FuDisabilityVisualView) mModel).setData(personInfo);
    }

    private void saveData() {
        if (((FuDisabilityVisualView) mModel).saveData(disabilityVisual))
            saveDisabilityVisual();

    }

    private void saveDisabilityVisual() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveDisabilityVisual(getCallBackInstance(), disabilityVisual, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_DISABILITY_VISUAL:
                    savePics(disabilityVisual.getDisabilityVisualId(), Constant.SERVICE_ITEM_9004, file);
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
                case MyTask.SAVE_DISABILITY_VISUAL:
                    message.what = taskId;
                    disabilityVisual = JSON.parseObject(rspObj.getResult(), DisabilityVisual.class);
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
