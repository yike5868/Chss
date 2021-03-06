package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.uiframe.FuMemberAdd02View;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/18
 * Time: 15:56
 * progject: Chss_FollowUp
 * Describe：入户随访-新增家庭成员-户籍信息
 */

public class FuMemberAdd02Fragment extends FragmentParent implements FragmentSave {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_MEMBERADD_02, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    @Override
    public boolean saveData() {

        ((FuMemberAdd02View) mModel).saveData(personInfo);

        return false;
    }

    public boolean setData() {
        ((FuMemberAdd02View) mModel).setData(personInfo);

        return true;
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
