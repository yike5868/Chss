package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.person.PersonInfo;

/**
 * Created by zhanglin on 2017/4/6.
 */

public class ReadCardFragment extends FragmentParent {
    int eventClass;
    Bundle bundle;
    PersonInfo personInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_READ_CARD, getActivity(), new OnEventClick());

        return mModel.getFuView();
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

    public void initData(Bundle bundle) {
        ReadCardFragment.this.bundle = bundle;
        eventClass = bundle.getInt("class");
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
    }

    public static final int EVENT_GO = 1;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_GO:
                    String[] ss = (String[]) object;
//                    if(personInfo!=null){
//                        if(personInfo.getIdNo()!=null&&personInfo.getIdNo().equals(ss[5]));{
//                            ToastUtil.showToast(getContext(),"身份证号不一致！", Toast.LENGTH_LONG);
//                            return;
//                        }
//                    }

                    bundle.putStringArray("decodeInfo", ss);
                    if (bundle.getInt("type") == FuUiFrameManager.FU_S_EXAM) {
                        ((FuContentActivity) getActivity()).replaceFragment(
                                FuUiFrameManager.FU_CHANGE_ID, eventClass, bundle);
                    } else
                        ((FuContentActivity) getActivity()).replaceFragment(
                                FuUiFrameManager.FU_CONTENT_ID, eventClass, bundle);
                    break;
            }

        }

    }
}
