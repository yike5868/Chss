package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.uiframe.FuSFamilyView;

import java.util.ArrayList;

/**
 * Created by zhanglin on 16/10/12.
 */

public class FuSFamilyFragment extends FragmentParent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_S_FAMILY, getActivity(),new OnEventClick());

        return mModel.getFuView();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("hidden",hidden+"");
        if(!hidden)
            ((FuSFamilyView)mModel).dataChange();
        super.onHiddenChanged(hidden);
    }

    public static final int EVENT_FAMILY_ADD = 1;
    public static final int EVENT_FAMILY_EDIT = 2;
    public static final int EVENT_FAMILY_ADD_PERSON = 3; //从家庭增加人员

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_FAMILY_ADD:

                    ArrayList cls_exam  = new ArrayList();
                    cls_exam.add(FuFamilyAdd01Fragment.class);
                    cls_exam.add(FuFamilyAdd02Fragment.class);
                    cls_exam.add(FuFamilyAdd03Fragment.class);


                    String[] titles_exam = new String[]{"第一页","第二页","第三页"};
                    Bundle bundle_family = new Bundle();
                    bundle_family.putSerializable("classes",cls_exam);
                    bundle_family.putStringArray("titles",titles_exam);
                    bundle_family.putString("title","新增家庭");
                    bundle_family.putInt("type",FuUiFrameManager.FU_FAMILY_ADD);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle_family);
//                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_FAMILY_ADD, null);
                    break;
                case EVENT_FAMILY_EDIT:
                    Bundle bundle = (Bundle)object;
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_FAMILY_ADD, bundle);
                    break;
                case EVENT_FAMILY_ADD_PERSON:
                    Bundle bundle1 = (Bundle)object;
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_FAMILY_ADD, bundle1);
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
