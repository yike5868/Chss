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
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.uiframe.FuSRhsfView;

import java.util.ArrayList;

/**
 * Created by zhanglin on 16/8/13.
 */

public class FuSRhsfFragment extends FragmentParent{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_S_RHSF, getActivity(),new OnEventClick());

        return mModel.getFuView();
    }
    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }
    public static final int  EVENT_PATIENTINFO = 1;

    public static final int EVENT_FAMILY_ADD = 2;

    public static final int EVENT_FAMILY_MEMBER=3;



    @Override
    public void onResume() {
        super.onResume();

        ((FuSRhsfView)mModel).setDataChange();
    }

    @Override
    protected void cancelChild(int taskId) {

    }
    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_PATIENTINFO:
                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_PATIENT_INFO, null);
                    break;
                case EVENT_FAMILY_MEMBER:

                    Bundle bundleFamilyMember = new Bundle();

                    String familyInfoId = object.toString();
                    bundleFamilyMember.putString("familyInfoId",familyInfoId);
//                    bundle_family_member.putSerializable("family",familyInfo);

                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_FAMILY_MEMBER, bundleFamilyMember);
                    break;
                case EVENT_FAMILY_ADD:
//                    Bundle bundle_room = new Bundle();
                    RoomAll room = (RoomAll)object;
//                    bundle_room.putSerializable("room",room);
//                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_FAMILY_ADD, bundle_room);


                    ArrayList cls_exam  = new ArrayList();
                    cls_exam.add(FuFamilyAdd01Fragment.class);
                    cls_exam.add(FuFamilyAdd02Fragment.class);
                    cls_exam.add(FuFamilyAdd03Fragment.class);


                    String[] titles_exam = new String[]{"第一页","第二页","第三页"};
                    Bundle bundle_family = new Bundle();
                    bundle_family.putSerializable("classes",cls_exam);
                    bundle_family.putStringArray("titles",titles_exam);
                    bundle_family.putString("title","新增家庭");
                    bundle_family.putSerializable("room",room);
                    bundle_family.putInt("type",FuUiFrameManager.FU_FAMILY_ADD);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle_family);

                    break;

            }

        }

    }
}
