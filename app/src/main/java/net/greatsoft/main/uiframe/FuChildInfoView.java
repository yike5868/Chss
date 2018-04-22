package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.child.ChildInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuChildInfoFragment;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/21
 * Time: 15:08
 * progject: Chss
 * Describe： 儿童专档(花名册)
 */

public class FuChildInfoView extends FuUiFrameModel implements View.OnClickListener, View.OnTouchListener {

    FuTextView tv_newbornName;//姓名
    FuTextView tV_newbornSexCode;//性别
    FuTextView tv_newbornBirthDate;//出生日期
    FuTextView tv_newbornIdNo;//身份证号
    FuEditText et_presentAddrProvince;//家庭住址
    LinearLayout ll_childrenBookIsBuild;//是否建立儿童保健手册
    LinearLayout ll_isWeakChildren;//是否体弱儿
    FuTextView tv_childrenBookBuildDate;//建册时间
    FuEditText et_birthGestWeeks;//出生孕周
    FuEditText et_birthGestDays;//出生孕天
    LinearLayout ll_motherHdcpCode;//母亲妊娠期患病情况
    FuEditText et_deliveryOrgName;//助产机构名称
    LinearLayout ll_chushengqingkuang;//出生情况
    LinearLayout ll_asphyxiaCode;//新生儿窒息
    LinearLayout ll_suffocationType;//新生儿窒息 严重情况
    LinearLayout ll_malformCode;//是否畸形
    LinearLayout ll_closeCaseCode;//手工结案
    FuEditText et_closeCaseReason;//手工结案原因
    FuEditText et_fatherName;//父亲
    FuEditText et_fatherTelNo;//联系电话
    FuEditText et_fatherWorkUnit;//工作单位
    FuEditText et_motherName;//母亲
    FuEditText et_motherTelNo;//联系电话
    FuEditText et_motherWorkUnit;//工作单位
    FuEditText et_guardian;//其他监护人
    Spinner sp_guardianRelation;//监护人关系
    FuEditText et_guardianTelNo;//联系电话
    FuEditText et_guardianWorkUnit;//工作单位
    FuEditText et_guardianAddress;//联系地址
    FuEditText et_respondent;//被调查人
    FuTextView tv_investigateDate;//被调查时间

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<String> faterList;//父亲集合
    List<String> motherList;//母亲集合

    ListPopupWindow fatherLpw;
    ListPopupWindow motherLpw;

    public FuChildInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_childinfo_view, null);

        faterList = new ArrayList<>();
        motherList = new ArrayList<>();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_investigateDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_childrenBookBuildDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChildInfoFragment.EVENT_SAVE_CHILD_INFO, null);
                break;
        }
    }

    @Override
    protected void initFuData() {

        // 出生情况
        initCheckBoxMany("bornStatus", ll_chushengqingkuang, 4, true);
        initCheckBoxSimple("build", ll_childrenBookIsBuild, 2);//是否建立儿童保健手册
        initCheckBoxSimple("build", ll_isWeakChildren, 2);//是否体弱儿童
        initCheckBoxMany("pregnantDisease", ll_motherHdcpCode, 3);//母亲妊娠期患病情况
        initCheckBoxSimple("asphyxia", ll_asphyxiaCode, 2);//新生儿窒息
        initCheckBoxSimple("CHOKEDEGREE", ll_suffocationType, 3);//新生儿窒息严重情况
        initCheckBoxSimple("malformCode", ll_malformCode, 2);//是否畸形
        initCheckBoxSimple("closeCaseCode", ll_closeCaseCode, 2);//是否畸形

        //监护人关系
        List<Checks> relations = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CHILDREN_GUARDIAN")).list();
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                relations);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_guardianRelation.setAdapter(adapter2);

    }

    public void setData(PersonInfo personInfo) {
        tv_newbornName.setText(personInfo.getName());//姓名
        tV_newbornSexCode.setText(personInfo.getSexValue());//性别
        tv_newbornBirthDate.setText(personInfo.getBirthday());//出生日期
        tv_newbornIdNo.setText(personInfo.getIdNo());//身份证号
    }

    public void setFatherList(List<PersonInfo> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                faterList.add(list.get(i).getName());
            }
        }

        //父亲
        fatherLpw = new ListPopupWindow(mContext);
        fatherLpw.setAdapter(new ArrayAdapter<String>(mContext,
                android.R.layout.simple_list_item_1, faterList));
        fatherLpw.setAnchorView(et_fatherName);
        fatherLpw.setModal(true);
        fatherLpw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_fatherName.setText(faterList.get(position));
                fatherLpw.dismiss();
            }
        });

    }

    public void setMotherList(List<PersonInfo> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                motherList.add(list.get(i).getName());
            }
        }
        //母亲
        motherLpw = new ListPopupWindow(mContext);
        motherLpw.setAdapter(new ArrayAdapter<String>(mContext,
                android.R.layout.simple_list_item_1, motherList));
        motherLpw.setAnchorView(et_motherName);
        motherLpw.setModal(true);
        motherLpw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_motherName.setText(motherList.get(position));
                motherLpw.dismiss();
            }
        });

    }

    public boolean saveData(ChildInfo childInfo) {


        if (getCheckBoxSimpleCode(ll_childrenBookIsBuild) != null && !"".equals(getCheckBoxSimpleCode(ll_childrenBookIsBuild)))
            childInfo.setChildrenBookIsBuild(Integer.parseInt(getCheckBoxSimpleCode(ll_childrenBookIsBuild)));//是否建立儿童保健手册
        if (getCheckBoxSimpleCode(ll_isWeakChildren) != null && !"".equals(getCheckBoxSimpleCode(ll_isWeakChildren)))
            childInfo.setIsWeakChildren(Integer.parseInt(getCheckBoxSimpleCode(ll_isWeakChildren)));//是否体弱儿
        childInfo.setChildrenBookBuildDate(tv_childrenBookBuildDate.getDate());//建册时间
        childInfo.setBirthGestWeeks(et_birthGestWeeks.getInt());//出生孕周
        childInfo.setBirthGestDays(et_birthGestDays.getInt());//出生孕天
        saveCheckBoxMany(null, childInfo.getRecordChoice(), ll_motherHdcpCode); //母亲妊娠期患病情况
        childInfo.setDeliveryOrgName(et_deliveryOrgName.getString());//助产机构名称
        saveCheckBoxMany(null, childInfo.getRecordChoice(), ll_chushengqingkuang);//出生情况
        childInfo.setAsphyxiaCode(getCheckBoxSimpleCode(ll_asphyxiaCode));//新生儿窒息
        childInfo.setSuffocationType(getCheckBoxSimpleCode(ll_suffocationType));//新生儿窒息 严重情况
        childInfo.setMalformCode(getCheckBoxSimpleCode(ll_malformCode));//是否畸形
        childInfo.setCloseCaseCode(getCheckBoxSimpleCode(ll_closeCaseCode));//手工结案
        childInfo.setCloseCaseReason(et_closeCaseReason.getString());//手工结案原因
        childInfo.setFatherName(et_fatherName.getString());//父亲姓名
        childInfo.setFatherTelNo(et_fatherTelNo.getString());//联系电话
        childInfo.setFatherWorkUnit(et_fatherWorkUnit.getString());//工作单位
        childInfo.setMotherName(et_motherName.getString());//母亲姓名
        childInfo.setMotherTelNo(et_motherTelNo.getString());//联系电话
        childInfo.setMotherWorkUnit(et_motherWorkUnit.getString());//工作单位
        childInfo.setGuardian(et_guardian.getString());//其他监护人
        Checks checks = (Checks) sp_guardianRelation.getSelectedItem();
        childInfo.setGuardianRelation(checks.getValue());//监护人关系
        childInfo.setGuardianTelNo(et_guardianTelNo.getString());//联系电话
        childInfo.setGuardianWorkUnit(et_guardianWorkUnit.getString());//工作单位
        childInfo.setGuardianAddress(et_guardianAddress.getString());//联系地址
        childInfo.setRespondent(et_respondent.getString());//被调查人
        childInfo.setInvestigateDate(tv_investigateDate.getDate());//被调查时间

        return true;
    }

    @Override
    protected void initWidget() {
        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("儿童花名册");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_newbornName = (FuTextView) mFuView.findViewById(R.id.tv_newbornName);//姓名
        tV_newbornSexCode = (FuTextView) mFuView.findViewById(R.id.tV_newbornSexCode);//性别
        tv_newbornBirthDate = (FuTextView) mFuView.findViewById(R.id.tv_newbornBirthDate);//出生日期
        tv_newbornIdNo = (FuTextView) mFuView.findViewById(R.id.tv_newbornIdNo);//身份证号
        et_presentAddrProvince = (FuEditText) mFuView.findViewById(R.id.et_presentAddrProvince);//家庭住址
        ll_childrenBookIsBuild = (LinearLayout) mFuView.findViewById(R.id.ll_childrenBookIsBuild);//是否建立儿童保健手册
        ll_isWeakChildren = (LinearLayout) mFuView.findViewById(R.id.ll_isWeakChildren);//是否体弱儿
        tv_childrenBookBuildDate = (FuTextView) mFuView.findViewById(R.id.tv_childrenBookBuildDate);//建册时间
        tv_childrenBookBuildDate.setOnClickListener(this);
        et_birthGestWeeks = (FuEditText) mFuView.findViewById(R.id.et_birthGestWeeks);//出生孕周
        et_birthGestDays = (FuEditText) mFuView.findViewById(R.id.et_birthGestDays);//出生孕天
        ll_motherHdcpCode = (LinearLayout) mFuView.findViewById(R.id.ll_motherHdcpCode);//母亲妊娠期患病情况
        et_deliveryOrgName = (FuEditText) mFuView.findViewById(R.id.et_deliveryOrgName);//助产机构名称
        ll_chushengqingkuang = (LinearLayout) mFuView.findViewById(R.id.ll_chushengqingkuang);//出生情况
        ll_asphyxiaCode = (LinearLayout) mFuView.findViewById(R.id.ll_asphyxiaCode);//新生儿窒息
        ll_suffocationType = (LinearLayout) mFuView.findViewById(R.id.ll_suffocationType);//新生儿窒息 严重情况
        ll_malformCode = (LinearLayout) mFuView.findViewById(R.id.ll_malformCode);//是否畸形
        ll_closeCaseCode = (LinearLayout) mFuView.findViewById(R.id.ll_closeCaseCode);//手工结案
        et_closeCaseReason = (FuEditText) mFuView.findViewById(R.id.et_closeCaseReason);//手工结案原因
        et_fatherName = (FuEditText) mFuView.findViewById(R.id.et_fatherName);//父亲
        et_fatherName.setOnTouchListener(this);
        et_fatherTelNo = (FuEditText) mFuView.findViewById(R.id.et_fatherTelNo);//联系电话
        et_fatherWorkUnit = (FuEditText) mFuView.findViewById(R.id.et_fatherWorkUnit);//工作单位
        et_motherName = (FuEditText) mFuView.findViewById(R.id.et_motherName);//母亲
        et_motherName.setOnTouchListener(this);
        et_motherTelNo = (FuEditText) mFuView.findViewById(R.id.et_motherTelNo);//联系电话
        et_motherWorkUnit = (FuEditText) mFuView.findViewById(R.id.et_motherWorkUnit);//工作单位
        et_guardian = (FuEditText) mFuView.findViewById(R.id.et_guardian);//其他监护人
        sp_guardianRelation = (Spinner) mFuView.findViewById(R.id.sp_guardianRelation);//监护人关系
        et_guardianTelNo = (FuEditText) mFuView.findViewById(R.id.et_guardianTelNo);//联系电话
        et_guardianWorkUnit = (FuEditText) mFuView.findViewById(R.id.et_guardianWorkUnit);//工作单位
        et_guardianAddress = (FuEditText) mFuView.findViewById(R.id.et_guardianAddress);//联系地址
        et_respondent = (FuEditText) mFuView.findViewById(R.id.et_respondent);//被调查人
        tv_investigateDate = (FuTextView) mFuView.findViewById(R.id.tv_investigateDate);//被调查时间
        tv_investigateDate.setOnClickListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_RIGHT = 2;
        switch (v.getId()) {
            case R.id.et_fatherName:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getX() >= (v.getWidth() - ((EditText) v)
                            .getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        fatherLpw.show();
                        return true;
                    }
                }
                break;
            case R.id.et_motherName:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getX() >= (v.getWidth() - ((EditText) v)
                            .getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        motherLpw.show();
                        return true;
                    }
                }
                break;
        }
        return false;
    }

}
