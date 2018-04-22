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
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuDiabetesView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 2016/11/26.
 * 糖尿病随访
 */

public class FuDiabetesFragment extends FragmentParent {

    private String diabetesFollowupId;
    DiabetesFollowup mDiabetesFollowup;
    String personInfoName;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DIABETES, getActivity(),
                new OnEventClick());
        createData();
        setData();
        return mModel.getFuView();
    }


    private void createData() {


        if (diabetesFollowupId == null) {
            mDiabetesFollowup = new DiabetesFollowup();
            diabetesFollowupId = UUID.randomUUID().toString();
            mDiabetesFollowup.setDiabetesFollowupId(diabetesFollowupId);
            mDiabetesFollowup.setPersonInfoId(personInfoId);
        }

    }

    public static final int EVENT_SAVE_DIABETES = 777;//保存高血压随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_DIABETES:
                    saveData();
                    break;
            }
        }
    }

    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("1");
        ((FuDiabetesView) mModel).setMedicine(sickMedicineList);
        ((FuDiabetesView) mModel).setData(mDiabetesFollowup,personInfoName);
    }

    public void saveData() {

        if (((FuDiabetesView) mModel).saveData(mDiabetesFollowup))
            saveDiabetesFollowup();
    }

    public void saveDiabetesFollowup() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveDiabetesFollowup(getCallBackInstance(), mDiabetesFollowup, getContext());

        excuteNetTask(lTask, false);
    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        personInfoName = bundle.getString("personInfoName","");
        diabetesFollowupId = bundle.getString("diabetesFollowupId", null);
        file = (File) bundle.getSerializable("file");
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_DIABETES_FOLLOWUP:
                    savePics(mDiabetesFollowup.getDiabetesFollowupId(),Constant.SERVICE_ITEM_5002,file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case MyTask.FIND_SICK_CHOICE_MEDICINE:
                    MedicineListRsp medicineListRsp = (MedicineListRsp) msg.obj;
                    ((FuDiabetesView) mModel).setMedicine(medicineListRsp.getData().getDiabetes());
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
        if (taskId == MyTask.FIND_SICK_CHOICE_MEDICINE) {
            MedicineListRsp medicineListRsp = (MedicineListRsp) rspObj;
            message.what = taskId;
            message.obj = medicineListRsp;
            message.sendToTarget();
            return;
        }

        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            switch (taskId) {
                case MyTask.SAVE_DIABETES_FOLLOWUP:
                    Message messageRoom = Message.obtain(mHandler);
                    messageRoom.what = taskId;
                    mDiabetesFollowup = JSON.parseObject(rspObj.getResult(), DiabetesFollowup.class);
                    messageRoom.sendToTarget();
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
