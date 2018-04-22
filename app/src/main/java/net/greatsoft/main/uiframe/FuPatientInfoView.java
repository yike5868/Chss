package net.greatsoft.main.uiframe;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuPatientInfoFragment;
import net.greatsoft.main.view.CircleButton;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;


/**
 * Created by zhanglin on 16/8/3.
 */
public class FuPatientInfoView extends FuUiFrameModel implements View.OnClickListener {

    ViewPager view_pager;
    FragmentPagerAdapter mFragmentPagerAdapter;
    FuButton btn_hd;//高血压 糖尿病
    FuButton btn_exam; //体检

    CircleButton cb_relation;//与户主关系
    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_age;//年龄
    FuTextView tv_telNo;//电话
    FuTextView tv_address;//地址
    FuTextView tv_fu_time;//上次随访时间
    FuTextView tv_fu_doctor;//随访医生



    public FuPatientInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_patient_info_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText(mContext.getResources().getText(R.string.member_info));
        view_pager = (ViewPager)mFuView.findViewById(R.id.view_pager);
        btn_hd = (FuButton)mFuView.findViewById(R.id.btn_hd);
        btn_hd.setOnClickListener(this);
        btn_exam = (FuButton)mFuView.findViewById(R.id.btn_exam);
        btn_exam.setOnClickListener(this);


         cb_relation = (CircleButton)mFuView.findViewById(R.id.cb_relation);//与户主关系
         tv_name = (FuTextView)mFuView.findViewById(R.id.tv_name);//姓名
         tv_sex= (FuTextView)mFuView.findViewById(R.id.tv_sex);//性别
         tv_age= (FuTextView)mFuView.findViewById(R.id.tv_age);//年龄
         tv_telNo= (FuTextView)mFuView.findViewById(R.id.tv_telNo);//电话
         tv_address= (FuTextView)mFuView.findViewById(R.id.tv_address);//地址
         tv_fu_time= (FuTextView)mFuView.findViewById(R.id.tv_fu_time);//上次随访时间
         tv_fu_doctor= (FuTextView)mFuView.findViewById(R.id.tv_fu_doctor);//随访医生
    }


    public void setData(FragmentPagerAdapter fragmentPagerAdapter, PersonInfo personInfo){
        mFragmentPagerAdapter = fragmentPagerAdapter;
        view_pager.setAdapter(mFragmentPagerAdapter);

//        tv_name.setText(personInfo.getName());
//        tv_sex.setText(personInfo.getSexValue());
//        tv_age.setAge(personInfo.getBirthday());
//        tv_telNo.setText(personInfo.getTelNo());
//        tv_address.setText(personInfo.getAddress());


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_hd:

                mEventCallBack.EventClick(FuPatientInfoFragment.EVENT_RHSF, null);
                break;
            case R.id.btn_exam:
                mEventCallBack.EventClick(FuPatientInfoFragment.EVENT_EXAM,null);
                break;

//            case R.id.btn_add_hy:
//                mEventCallBack.EventClick(FuPatientInfoFragment.EVENT_RHSF, null);
//                break;
//            case R.id.tv_modify_personal:
//                mEventCallBack.EventClick(FuPatientInfoFragment.EVENT_MODIFY_PERSONAL,null);
//                break;
//            case R.id.btn_add_tj:
//                mEventCallBack.EventClick(FuPatientInfoFragment.EVENT_EXAM,null);
//                break;
        }
    }



}
