package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;


/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/17
 * Time: 16:49
 * progject: Chss_FollowUp
 * Describe： 入户随访个人历史记录
 */

public class FuPersonHistoryFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_PERSON_HISTORY, getActivity(),
                new OnEventClick());

        return mModel.getFuView();
    }

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

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
