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
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.diabetes.DiabetesInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuDiabetesInfoView;

import java.io.File;
import java.util.List;

/**
 * Date: 2017/03/09
 * Time: 16:55
 * progject: Chss
 * Describe： 糖尿病专档
 */

public class FuDiabetesInfoFragment extends FragmentParent {
    DiabetesInfo diabetesInfo;
    PersonInfo personInfo;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DIABETES_INFO, getActivity(),
                new OnEventClick());
        createData();
        findPersonInfoByPersonInfoId();
        return mModel.getFuView();
    }

    public void findPersonInfoByPersonInfoId() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }
    public static final int EVENT_SAVE_DIABETESINFO = 777;//保存糖尿病专档

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_DIABETESINFO:
                    saveData();
                    break;
            }
        }
    }
    private void createData() {
        if(diabetesInfo == null){
            diabetesInfo = new DiabetesInfo();
            diabetesInfo.setPersonInfoId(personInfoId);
        }

    }
    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        file = (File) bundle.getSerializable("file");
    }
    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("1");
        ((FuDiabetesInfoView) mModel).setMedicine(sickMedicineList);
        ((FuDiabetesInfoView) mModel).setData(personInfo);
    }

    public void saveData() {

        if (((FuDiabetesInfoView) mModel).saveData(diabetesInfo))
            saveDiabetesInfo();
    }

    public void saveDiabetesInfo() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveDiabetesInfo(getCallBackInstance(), diabetesInfo, getContext());

        excuteNetTask(lTask, false);
    }


    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_DIABETES_INFO:
                    savePics(diabetesInfo.getDiabetesInfoId(), Constant.SERVICE_ITEM_5011,file);
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
                case MyTask.SAVE_DIABETES_INFO:
                    message.what = taskId;
                    diabetesInfo = JSON.parseObject(rspObj.getResult(), DiabetesInfo.class);
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

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
