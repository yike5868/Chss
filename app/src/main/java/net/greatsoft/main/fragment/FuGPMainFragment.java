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
 * Created by zhanglin on 2016/11/10.
 */

public class FuGPMainFragment extends FragmentParent {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_GP_MAIN, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }
    public static final int EVENT_APPOINTMENT = 0;//电话随访
    public static final int EVENT_GP_FOLLOW = 1; //随访
    public static final int EVENT_GP_STATTISTICS = 2;//统计


    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_APPOINTMENT:
                    break;
                case EVENT_GP_FOLLOW:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_GP_FOLLOW, null);
                    break;
                case EVENT_GP_STATTISTICS:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_GP_STATISTICS, null);
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
