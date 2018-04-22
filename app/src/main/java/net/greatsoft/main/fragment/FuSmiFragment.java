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
import net.greatsoft.main.db.po.smi.SmiFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuHyperView;
import net.greatsoft.main.uiframe.FuSmiView;

import java.io.File;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/26.
 * 重性精神病随访
 */

public class FuSmiFragment extends FragmentParent {

    private String smiFollowupId;
    SmiFollowup mSmiFollowup;
    private String personInfoName;
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_SMI, getActivity(),
                new OnEventClick());

        creataData();
        setData();
//        findSickChoiceMedicine();
        return mModel.getFuView();
    }

    public void findSickChoiceMedicine() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findSickChoiceMedicine(getCallBackInstance(), getContext());

        excuteNetTask(lTask, false);
    }

    private void creataData() {

        if (smiFollowupId == null) {
            mSmiFollowup = new SmiFollowup();
            mSmiFollowup.setSmiFollowupId(smiFollowupId);
            mSmiFollowup.setPersonInfoId(personInfoId);
            mSmiFollowup.setName(personInfoName);
        }
    }

    public static final int EVENT_SAVE_SMI = 888;//重性精神病

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_SMI:
                    saveData();
//                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
            }
        }
    }

    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("3");
        ((FuSmiView) mModel).setMedicine(sickMedicineList);
        ((FuSmiView) mModel).setData(mSmiFollowup);
    }

    public void saveData() {
        if (((FuSmiView) mModel).saveData(mSmiFollowup))
            saveSmiInfo();
    }


    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        personInfoName = bundle.getString("personInfoName");
        smiFollowupId = bundle.getString("smiFollowupId", null);
        file = (File) bundle.getSerializable("file");
    }

    /**
     * smiInfo/saveSmiInfo
     */
    public void saveSmiInfo() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveSmiFollowUp(getCallBackInstance(), mSmiFollowup, getContext());

        excuteNetTask(lTask, false);

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_SMI_FOLLOWUP:
                    savePics(mSmiFollowup.getSmiFollowupId(), Constant.SERVICE_ITEM_5004, file);
                    break;
                case MyTask.FIND_SICK_CHOICE_MEDICINE:
                    MedicineListRsp medicineListRsp = (MedicineListRsp) msg.obj;
                    ((FuSmiView) mModel).setMedicine(medicineListRsp.getData().getSmi());
                    break;
                case MyTask.ERROR:
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
                case MyTask.SAVE_SMI_FOLLOWUP:
                    message.what = taskId;
                    mSmiFollowup = JSON.parseObject(rspObj.getResult(), SmiFollowup.class);
                    message.sendToTarget();
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
}
