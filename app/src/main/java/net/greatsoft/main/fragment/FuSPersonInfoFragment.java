package net.greatsoft.main.fragment;

import android.content.Intent;
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
import net.greatsoft.main.uiframe.FuSPersonInfoView;

import java.util.ArrayList;

/**
 * Created by zhanglin on 16/8/13.
 */

public class FuSPersonInfoFragment extends FragmentParent{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_S_MEMBER, getActivity(),new OnEventClick());

        return mModel.getFuView();
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("hidden",hidden+"");
        if(!hidden)
            ((FuSPersonInfoView)mModel).dataChange();
        super.onHiddenChanged(hidden);
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
    public static final int EVENT_PERSON_ADD = 1;  //新增人员
    public static final int EVENT_PERSON_EDIT = 2; //修改人员
    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_PERSON_ADD:


                    ArrayList cls_exam  = new ArrayList();
                    cls_exam.add(FuMemberAdd01Fragment.class);
                    cls_exam.add(FuMemberAdd02Fragment.class);
                    cls_exam.add(FuMemberAdd03Fragment.class);
                    cls_exam.add(FuMemberAdd04Fragment.class);


                    String[] titles_exam = new String[]{"第一页","第二页","第三页","第四页"};
                    Bundle bundle_family = new Bundle();
                    bundle_family.putSerializable("classes",cls_exam);
                    bundle_family.putStringArray("titles",titles_exam);
                    bundle_family.putString("title","新增人员");
                    bundle_family.putInt("type", FuUiFrameManager.FU_MEMBER_ADD);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle_family);


//                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_MEMBER_ADD, null);
                    break;
                case EVENT_PERSON_EDIT:
                    Bundle bundle = (Bundle)object;
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_MEMBER_ADD, bundle);
                    break;
            }
        }

    }
}
