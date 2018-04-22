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

/**
 * Created by zhanglin on 2016/10/31.
 */

public class FuSYzFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_S_YZ, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }

    public static final int EVENT_LIST = 1; //档案
    public static final int EVENT_BLOOD = 2; //档案
    public static final int EVENT_SUGAR = 3; //档案

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_LIST:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_YZ_LIST, null);
                    break;
                case EVENT_BLOOD:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_YZ_BLOOD, null);
                    break;
                case EVENT_SUGAR:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_YZ_SUGAR, null);
                    break;
            }
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

}
