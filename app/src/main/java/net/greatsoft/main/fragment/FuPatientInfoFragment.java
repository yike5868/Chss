package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.uiframe.FuPatientInfoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/16.
 */

public class FuPatientInfoFragment extends FragmentParent {
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_PATIENT_INFO, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    public void setData(){

        FuDiaChartFragment diaChartFragment = new FuDiaChartFragment();
        Bundle diabundle = new Bundle();
        diabundle.putInt("type",FuUiFrameManager.FU_DIA_CHART);
        diabundle.putString("personInfoId",personInfoId);
        diaChartFragment.initData(diabundle);

        FuDiaChartFragment hyChartFragment = new FuDiaChartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("personInfoId",personInfoId);
        bundle.putInt("type",FuUiFrameManager.FU_HYPER_CHART);
        hyChartFragment.initData(bundle);

//        FuHyperChartFragment fuHyperChartFragment = new FuHyperChartFragment();
        FuRecordsFragment fuRecordsFragment = new FuRecordsFragment();
        mFragments.add(diaChartFragment);
        mFragments.add(hyChartFragment);

//        mFragments.add(fuHyperChartFragment);
        mFragments.add(fuRecordsFragment);
        setAdapter();
//        personInfo = getSqlHelper().getPersonInfo(personInfoId);
        ((FuPatientInfoView)mModel).setData(mAdapter,personInfo);
    }

    public void intentData(Bundle bundle){

        if(bundle == null){

        }else{
            personInfoId = bundle.getString("personInfoId");
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

    private void setAdapter(){

        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        
    }
    public static final int EVENT_RHSF = 1; //入户随访  高血压 糖尿病共性页面
    public static final int EVENT_MODIFY_PERSONAL = 2; //修改个人信息
    public static final int EVENT_EXAM = 3;     //小体检
    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_RHSF:
                    ArrayList cls  = new ArrayList();

                    cls.add(FuDiaHY01Fragment.class);
                    cls.add(FuDiaHY02Fragment.class);
                    cls.add(FuDiaHY03Fragment.class);
                    cls.add(FuDiaHY04Fragment.class);

                    String[] titles = new String[]{"症状","数据","用药","信息"};
                    Bundle bundle = new Bundle();
                    bundle.putString("title","高、糖随访");
                    bundle.putSerializable("classes",cls);
                    bundle.putStringArray("titles",titles);
                    bundle.putString("personInfoId",personInfoId);
                    bundle.putInt("type",FuUiFrameManager.FU_S_LGT);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle);
                    break;
                case EVENT_MODIFY_PERSONAL:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_MODIFY_PERSONAL, null);
                    break;
                case EVENT_EXAM:
                    ArrayList cls_exam  = new ArrayList();
                    cls_exam.add(FuExam01Fragment.class);
                    cls_exam.add(FuExam02Fragment.class);
                    cls_exam.add(FuExam03Fragment.class);
                    cls_exam.add(FuExam04Fragment.class);
                    String[] titles_exam = new String[]{"第一页","第二页","第三页","第四页"};
                    Bundle bundle_exam = new Bundle();
                    bundle_exam.putSerializable("classes",cls_exam);
                    bundle_exam.putStringArray("titles",titles_exam);
                    bundle_exam.putString("personInfoId",personInfoId);
                    bundle_exam.putString("title","体检");
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle_exam);
                    break;
            }
        }

    }
}
