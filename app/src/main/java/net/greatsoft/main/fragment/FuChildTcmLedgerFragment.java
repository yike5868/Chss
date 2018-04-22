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
import net.greatsoft.main.db.po.person.PersonInfo;

/**
 * Created by zhanglin on 2016/12/28.
 */

public class FuChildTcmLedgerFragment extends FragmentParent {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_CHILD_TCM_LEDGER, getActivity(),
                new OnEventClick());


        return mModel.getFuView();
    }
    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

        }
    }
    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
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
