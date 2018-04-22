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
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuHyperView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 2016/11/26.
 */

public class FuHyperFragment extends FragmentParent {

    private String hyperFollowupId;
    HyperFollowup mHyperFollowup;

    String personInfoName;
    File file;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_HYPER, getActivity(),
                new OnEventClick());
        createData();

        setData();
//        findSickChoiceMedicine();
        return mModel.getFuView();
    }

//    public void findSickChoiceMedicine() {
//
//        MyTask lTask = TaskManager.getInstace(getActivity())
//                .findSickChoiceMedicine(getCallBackInstance(), getContext());
//
//        excuteNetTask(lTask, false);
//    }

    public static final int EVENT_SAVE_HYPER = 666;//保存高血压随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_HYPER:
                    saveData();
                    break;
            }
        }
    }

    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("2");
        ((FuHyperView) mModel).setMedicine(sickMedicineList);
        ((FuHyperView) mModel).setData(mHyperFollowup, personInfoName);
    }

    public void saveData() {


        if (((FuHyperView) mModel).saveData(mHyperFollowup))
            saveHyperFollowup();

//        sqlHelper.getHyperFollowupDao().queryBuilder().where(HyperFollowupDao.Properties.HyperFollowupId.eq(mHyperFollowup.getHyperFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getHyperFollowupDrugDao().queryBuilder().where(HyperFollowupDrugDao.Properties.HyperFollowupId.eq(mHyperFollowup.getHyperFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();
//
//        sqlHelper.getHyperFollowupDao().insert(mHyperFollowup);
//        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
//        sqlHelper.getHyperFollowupDrugDao().insertInTx(list_hyperFollowDrug);


    }

    public void createData() {

        if (hyperFollowupId == null) {
            mHyperFollowup = new HyperFollowup();
            hyperFollowupId = UUID.randomUUID().toString();
            mHyperFollowup.setHyperFollowupId(hyperFollowupId);
            mHyperFollowup.setPersonInfoId(personInfoId);
        }
        /**
         * 只写保存不写展示
         */
//        else {
//            mHyperFollowup = sqlHelper.getHyperFollowupByHyperFollowupId(hyperFollowupId);
//        }
    }

    public void saveHyperFollowup() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveHyperFollowup(getCallBackInstance(), mHyperFollowup, getContext());

        excuteNetTask(lTask, false);
    }

    public void initData(Bundle bundle) {

        personInfoId = bundle.getString("personInfoId");

        personInfoName = bundle.getString("personInfoName", "");

        hyperFollowupId = bundle.getString("hyperFollowupId", null);
        file = (File) bundle.getSerializable("file");
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_HYPER_FOLLOWUP:
                    savePics(mHyperFollowup.getHyperFollowupId(),Constant.SERVICE_ITEM_5001,file);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case MyTask.FIND_SICK_CHOICE_MEDICINE:
                    MedicineListRsp medicineListRsp = (MedicineListRsp) msg.obj;
                    ((FuHyperView) mModel).setMedicine(medicineListRsp.getData().getHyper());
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
                case MyTask.SAVE_HYPER_FOLLOWUP:
                    message.what = taskId;
                    mHyperFollowup = JSON.parseObject(rspObj.getResult(), HyperFollowup.class);
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



}
