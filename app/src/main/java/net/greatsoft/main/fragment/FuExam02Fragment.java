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
import net.greatsoft.main.uiframe.FuExam02View;

/**
 * Created by zhanglin on 16/8/16.
 */

public class FuExam02Fragment extends FragmentParent implements FragmentSave ,java.io.Serializable {
    private static final long serialVersionUID = 2L;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_EXAM_02, getActivity(),
                new OnEventClick());
        if(healthExam!=null){
            setData();
        }
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

        return ((FuExam02View)mModel).saveData(healthExam);
    }

    public boolean setData(){
        ((FuExam02View)mModel).setData(healthExam,personInfo);

        return true;
    }

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
        }

    }
}
