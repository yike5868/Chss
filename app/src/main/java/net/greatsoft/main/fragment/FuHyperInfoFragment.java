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
import net.greatsoft.main.db.po.hyperinfo.HyperInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuHyperInfoView;

import java.io.File;
import java.util.List;

/**
 * Date: 2017/03/09
 * Time: 10:04
 * progject: Chss
 * Describe： 高血压专档
 */

public class FuHyperInfoFragment extends FragmentParent {
    HyperInfo hyperInfo;
    PersonInfo personInfo;
    File file;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_HYPER_INFO, getActivity(),
                new OnEventClick());

        createData();
        findPersonInfoByPersonInfoId();
        return mModel.getFuView();
    }
    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        file = (File) bundle.getSerializable("file");
    }
    public void setData() {
        List<SickMedicine> sickMedicineList = sqlHelper.getSickMedicine("2");
        ((FuHyperInfoView) mModel).setMedicine(sickMedicineList);
        ((FuHyperInfoView) mModel).setData(personInfo);
    }
    public void createData() {

        if (hyperInfo == null) {
            hyperInfo = new HyperInfo();
            hyperInfo.setPersonInfoId(personInfoId);
        }
        /**
         * 只写保存不写展示
         */

    }

    public void findPersonInfoByPersonInfoId() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    public static final int EVENT_SAVE_HYPER_INFO = 1;//保存高血压专档

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_SAVE_HYPER_INFO:
                    saveData();
                    break;
            }
        }
    }

    public void saveData() {


        if (((FuHyperInfoView) mModel).saveData(hyperInfo))
            saveHyperFollowInfo();

//        sqlHelper.getHyperFollowupDao().queryBuilder().where(HyperFollowupDao.Properties.HyperFollowupId.eq(mHyperFollowup.getHyperFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getHyperFollowupDrugDao().queryBuilder().where(HyperFollowupDrugDao.Properties.HyperFollowupId.eq(mHyperFollowup.getHyperFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();
//
//        sqlHelper.getHyperFollowupDao().insert(mHyperFollowup);
//        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
//        sqlHelper.getHyperFollowupDrugDao().insertInTx(list_hyperFollowDrug);


    }

    public void saveHyperFollowInfo() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveHyperFollowInfo(getCallBackInstance(), hyperInfo, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_HYPER_INFO:
                    savePics(hyperInfo.getHyperInfoId(), Constant.SERVICE_ITEM_5010,file);
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
                case MyTask.SAVE_HYPER_INFO:
                    message.what = taskId;
                    hyperInfo = JSON.parseObject(rspObj.getResult(), HyperInfo.class);
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
