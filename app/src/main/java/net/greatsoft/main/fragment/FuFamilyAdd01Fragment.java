package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.uiframe.FuFamilyAdd01View;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class FuFamilyAdd01Fragment extends FragmentParent  implements FragmentSave {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_FAMILY_01_ADD, getActivity(),
                null);
        setData();
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

    @Override
    public boolean saveData() {

        ((FuFamilyAdd01View)mModel).saveData(familyInfo);

        return false;
    }

    public boolean setData(){
        ((FuFamilyAdd01View)mModel).setData(familyInfo, roomAll);

        return true;
    }

}
