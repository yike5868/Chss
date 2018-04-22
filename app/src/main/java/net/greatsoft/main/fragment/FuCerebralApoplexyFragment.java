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
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuCerebralApoplexyView;
import net.greatsoft.main.uiframe.FuDiabetesView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Date: 2017/03/03
 * Time: 15:05
 * progject: Chss
 * Describe： 脑卒中随访
 */

public class zFuCerebralApoplexyFragment extends FragmentParent{

    String cerebralApoplexyId;
    String personInfoName;
    CerebralApoplexyFollowup mCerebralApoplexyFollowup;
    File file;
    private String personInfoNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CEREBRALAPOPLEXY_FOLLOWUP, getActivity(),
                new OnEventClick());

        creatData();
        setData();

        return mModel.getFuView();
    }

    private void setData() {

        List<SickMedicine> sickMedicines = sqlHelper.getSickMedicine("4");
        ((FuCerebralApoplexyView) mModel).setMedicine(sickMedicines);
        ((FuCerebralApoplexyView) mModel).setData(mCerebralApoplexyFollowup,personInfoName);

    }

    private void creatData() {
        if (cerebralApoplexyId == null) {
            mCerebralApoplexyFollowup = new CerebralApoplexyFollowup();
            cerebralApoplexyId = UUID.randomUUID().toString();
            mCerebralApoplexyFollowup.setCerebralApoplexyFollowupId(cerebralApoplexyId);
            mCerebralApoplexyFollowup.setPersonInfoId(personInfoId);
        }
    }

    public static final int EVENT_SAVE_CEREBRALAPOPLEXY = 741;//保存脑卒中随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CEREBRALAPOPLEXY:
                    saveData();
                    break;
            }
        }
    }

    private void saveData() {
        if (((FuCerebralApoplexyView) mModel).saveData(mCerebralApoplexyFollowup)) {
            mCerebralApoplexyFollowup.setChdFollowupNo(personInfoNo);
            saveCerebralaPoplexy();
        }
    }

    private void saveCerebralaPoplexy() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveCerebralApoplexy(getCallBackInstance(), mCerebralApoplexyFollowup, getContext());

        excuteNetTask(lTask, false);

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_CEREBRALAPOPLEXY_FOLLOWUP:
                    savePics(mCerebralApoplexyFollowup.getCerebralApoplexyFollowupId(), Constant.SERVICE_ITEM_5019,file);
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
                case MyTask.SAVE_CEREBRALAPOPLEXY_FOLLOWUP:
                    Message messageRoom = Message.obtain(mHandler);
                    messageRoom.what = taskId;
                    mCerebralApoplexyFollowup = JSON.parseObject(rspObj.getResult(), CerebralApoplexyFollowup.class);
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

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        personInfoName = bundle.getString("personInfoName","");
        cerebralApoplexyId = bundle.getString("cerebralApoplexyId");
        personInfoNo = bundle.getString("personInfoNo");
        file = (File) bundle.getSerializable("file");
    }
}
