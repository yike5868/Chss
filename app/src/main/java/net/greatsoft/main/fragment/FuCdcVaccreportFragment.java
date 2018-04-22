package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.vaccine.CdcVaccreport;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuCdcVaccreportView;

import java.text.SimpleDateFormat;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/12/28
 * Time: 10:52
 * progject: Chss
 * Describe： 预防接种卡
 */

public class FuCdcVaccreportFragment extends FragmentParent {

    CdcVaccreport mVaccreport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CDCVACC_REPORT, getActivity(),
                new OnEventClick());

        setData();

       return mModel.getFuView();
    }

    public static final int EVENT_SAVE_CDCVACC_REPORT = 145;//保存预防接种卡

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_CDCVACC_REPORT:
                    saveData();
                    break;
            }
        }
    }

    public void initData(Bundle bundle){

        mVaccreport = new CdcVaccreport();
        mVaccreport.setPersonInfoId(bundle.getString("personInfoId"));
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
        mVaccreport.setName(personInfo.getName());
        mVaccreport.setSexCode(personInfo.getSexValue());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        mVaccreport.setBirthDate(format.format(personInfo.getBirthday()));

    }

    public void setData() {
        ((FuCdcVaccreportView) mModel).setData(mVaccreport);
    }

    public void saveData() {
        if (((FuCdcVaccreportView) mModel).saveData(mVaccreport))
            saveCdcVaccreport();
    }

    private void saveCdcVaccreport() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .saveCdcVaccreport(getCallBackInstance(), mVaccreport, getContext());

        excuteNetTask(lTask, false);
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_CDCVACC_REPORT:
                    ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_LONG);
//                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
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
                case MyTask.SAVE_CDCVACC_REPORT:
                    message.what = taskId;
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

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
