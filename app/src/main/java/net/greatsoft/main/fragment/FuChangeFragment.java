package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.NetCallBack;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuChangeView;
import net.greatsoft.main.uiframe.FuPatientInfoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/16.
 */

public class FuChangeFragment extends FragmentParent {
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private String[] titles;  //标题
    private String title;//标题
    ArrayList<Class> alClasses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CHANGE, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    public void setData(){

        for (int i = 0; i < alClasses.size(); i++) {
            try {
                FragmentParent fp = (FragmentParent) alClasses.get(i).newInstance();
                mFragments.add(fp);
            } catch (java.lang.InstantiationException e1) {

            } catch (IllegalAccessException e1) {

            }
        }

        setAdapter();
        ((FuChangeView)mModel).setData(mAdapter,titles,title);
    }

    public void initData(Bundle bundle){

        if(bundle == null){

        }else{
            alClasses = (ArrayList) bundle.getSerializable("classes");
            personInfoId = bundle.getString("personInfoId");
            titles = bundle.getStringArray("titles");
            title = bundle.getString("title");
        }

    }


    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }

    private void setAdapter(){

        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };

    }

    public static final int EVENT_FIND_VACCINE_TWO_LIST = 1;//获取预防接种列表

    public static final int EVENT_SAVE_EXAM = 2;//保存体检

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_FIND_VACCINE_TWO_LIST:
                    break;
                case EVENT_SAVE_EXAM:
                    saveExam();
                    break;
            }
        }

    }


    /**
     * 保存体检
     *
     * @return
     */
    public boolean saveExam() {

        for (int i = 0; i < mFragments.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragments.get(i);
            if(!fs.saveData())
                return false;

        }

        sqlHelper.insertHealthExam(healthExam);

        MyTask lTask = TaskManager.getInstace(getContext())
                .saveExam(new mNetCallBack(), healthExam, getContext());

        excuteNetTask(lTask, false);

        return true;
    }
    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_HEALTH_EXAM:
                    ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_SHORT);
                    break;
            }
        }
    };
    class mNetCallBack implements NetCallBack {

        @Override
        public void cancel(int taskId) {
            Log.e("ddddd", "eeeeeeeeee");
        }

        @Override
        public void loadData(int taskId, FuResponse rspObj) {
            Message fmg = Message.obtain(mHandler);

            if (rspObj == null || rspObj.getCode() == null) {
                fmg.what = NET_ERROR;
                if (rspObj.getMessage() == null) {
                    fmg.obj = "网络连接错误";
                }
                fmg.sendToTarget();
                return;
            } else if (!"0".equals(rspObj.getCode())) {
                fmg.what = NET_ERROR;
                fmg.obj = rspObj.getMessage();
                fmg.sendToTarget();
                return;
            }

            switch (taskId) {
                case MyTask.SAVE_HEALTH_EXAM:
                    fmg.what = taskId;
                    fmg.sendToTarget();
                    break;
            }
        }

        @Override
        public void netError(int taskId, String msg) {
            Message fmg = Message.obtain(mHandler);
            fmg.what = NET_ERROR;
            if (msg == null) {
                fmg.obj = "网络连接错误";
            } else {
                fmg.obj = msg;
            }
            fmg.sendToTarget();
        }
    }
}
