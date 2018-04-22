package net.greatsoft.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuLoginRegistActivity;
import net.greatsoft.main.activity.FuMainActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;

/**
 * Created by sunguodong on 2017/5/4.
 */

public class FuSetFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_SET, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }


    public static final int EVENT_SETPASSWORD = 1;
    public static final int EVENT_EXIT = 2;

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

            switch (event) {

                case EVENT_SETPASSWORD:

                    ((FuMainActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_MAIN_ID, FuUiFrameManager.FU_SET_PASSWORD, null);
                    break;
                case EVENT_EXIT:
//                    System.exit(0);
                    Intent intent = new Intent(getContext(), FuLoginRegistActivity.class);
                    startActivity(intent);
                    ((FuMainActivity) getActivity()).finish();
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
