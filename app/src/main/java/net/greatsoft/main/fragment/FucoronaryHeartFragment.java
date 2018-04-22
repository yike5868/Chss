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
import net.greatsoft.main.db.po.corconaryHeart.CoronaryHeartDiseaseFollowup;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuCoronaryHeartView;
import net.greatsoft.main.uiframe.FuDiabetesView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Date: 2017/03/03
 * Time: 17:01
 * progject: Chss
 * Describe： 冠心病随访
 */

public class FucoronaryHeartFragment extends FragmentParent {

    String chdFollowupId;
    String personInfoName;
    CoronaryHeartDiseaseFollowup mCoronaryHeartDiseaseFollowup;
    File file;
    private String personInfoNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CORONARYHEART_FOLLOWUP, getActivity(),
                new OnEventClick());
        creatData();
        setData();

        return mModel.getFuView();
    }

    private void setData() {
        List<SickMedicine> medicine = sqlHelper.getSickMedicine("5");
        ((FuCoronaryHeartView) mModel).setMedicine(medicine);
        ((FuCoronaryHeartView) mModel).setData(mCoronaryHeartDiseaseFollowup,personInfoName);

    }

    private void creatData() {
        if (chdFollowupId == null) {
            mCoronaryHeartDiseaseFollowup = new CoronaryHeartDiseaseFollowup();
            chdFollowupId = UUID.randomUUID().toString();
            mCoronaryHeartDiseaseFollowup.setChdFollowupId(chdFollowupId);
            mCoronaryHeartDiseaseFollowup.setPersonInfoId(personInfoId);
        }
    }

    public static final int EVENT_SAVE_CORONARYHEART = 740;//保存冠心病随访

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CORONARYHEART:
                    saveData();
                    break;
            }
        }
    }

    private void saveData() {
        if (((FuCoronaryHeartView) mModel).saveData(mCoronaryHeartDiseaseFollowup)) {
            mCoronaryHeartDiseaseFollowup.setChdFollowupNo(personInfoNo);
            saveCoronaryHeart();
        }
    }

    public void saveCoronaryHeart() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveCoronaryHeartFollowup(getCallBackInstance(), mCoronaryHeartDiseaseFollowup, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_CORONARYHEART_FOLLOWUP:
                    savePics(mCoronaryHeartDiseaseFollowup.getChdFollowupId(), Constant.SERVICE_ITEM_5021,file);
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
                case MyTask.SAVE_CORONARYHEART_FOLLOWUP:
                    Message messageRoom = Message.obtain(mHandler);
                    messageRoom.what = taskId;
                    mCoronaryHeartDiseaseFollowup = JSON.parseObject(rspObj.getResult(), CoronaryHeartDiseaseFollowup.class);
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
        chdFollowupId = bundle.getString("chdFollowupId", null);
        personInfoNo = bundle.getString("personInfoNo");
        file = (File) bundle.getSerializable("file");
    }
}
