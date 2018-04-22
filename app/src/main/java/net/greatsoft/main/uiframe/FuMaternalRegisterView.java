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
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.maternal.MaternalRegister;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuMaternalRegisterFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/04/05
 * Time: 13:11
 * progject: Chss
 * Describe： 孕产登记
 */

public class FuMaternalRegisterView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener {

    FuTextView tv_name;//姓名
    FuTextView tv_birthDate;//出生日期
    FuTextView tv_nation;//民族
    LinearLayout ll_xueli;//学历
    FuEditText et_workUnit;//工作单位
    LinearLayout ll_zhiye;//职业
    FuEditText et_husbandName;//丈夫姓名
    FuEditText et_husbandUnit;//工作单位
    FuEditText et_husbandTelNo;//电话
    FuEditText et_address;//住址
    FuEditText et_mensesPeriod;//月经周期
    Spinner sp_mensesMeasure;//量
    FuTextView tv_mensesLastDate;//末次月经
    FuTextView tv_expectedChildBirthday;//预产期
    FuEditText et_childrenCount;//现有子女数
    FuTextView tv_buildingManualDate;//建册时间
    LinearLayout ll_buildingManualCode;//是否建立《孕产妇保健手册》
    LinearLayout ll_yunchanshi;//孕产史
    FuEditText et_spontaneousAbortionCount;//自然产次
    FuEditText et_artificialAbortionCount;//人工流产
    FuEditText et_drugAbortionCount;//药物流产
    LinearLayout ll_jiwangshi;//既往史
    LinearLayout ll_jiazushi;//家族史
    LinearLayout ll_renshen;//本次妊娠情况
    LinearLayout ll_pregnancyInplan;//计划内妊娠
    FuTextView tv_pregnancyLasttime;//前次妊娠
    FuEditText et_gravidity;//孕次
    FuEditText et_parity;//产次
    FuEditText et_sbp;//收缩压
    FuEditText et_dbp;//舒张压
    FuEditText et_weight;//体重
    FuEditText et_height;//身高
    FuEditText et_bmi;//体质指数
    FuEditText et_remark;//备注
    LinearLayout ll_closeCaseCode;//手工结案
    FuEditText et_closeCaseReason;//原因

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<String> faterList;//父亲集合
    ListPopupWindow fatherLpw;

    public FuMaternalRegisterView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_maternal_register_view, null);

        faterList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_mensesLastDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_expectedChildBirthday:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_buildingManualDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_pregnancyLasttime:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMaternalRegisterFragment.EVENT_SAVE_MATERNAL_REGISTER, null);
                break;

        }
    }

    @Override
    protected void initFuData() {

        List<Checks> num = new ArrayList<>();
        num.add(new Checks(null, "大", "大", null, null, null));
        num.add(new Checks(null, "中", "中", null, null, null));
        num.add(new Checks(null, "小", "小", null, null, null));
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                num);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_mensesMeasure.setAdapter(adapter2);

        initCheckBoxSimple("MEMBERPROFESSION", ll_zhiye, 1);// 职业
        setRadioOrCheckBoxEnabel(ll_zhiye);
        initCheckBoxSimple("CULTUREDEGREE", ll_xueli, 3);// 文化程度
        setRadioOrCheckBoxEnabel(ll_xueli);
        initCheckBoxSimple("build", ll_buildingManualCode, 2);//是否建立《孕产妇保健手册》
        initCheckBoxMany("pregnantHistory", ll_yunchanshi, 3, false, true);//孕产史
        initCheckBoxMany("registerPastHistory", ll_jiwangshi, 3, false, true);//既往史
        initCheckBoxMany("registerFamilyHistory", ll_jiazushi, 4, false, true);//家族史
        initCheckBoxMany("gestationStatus", ll_renshen, 4, false, true);//本次妊娠情况
        initCheckBoxSimple("build", ll_pregnancyInplan, 2);//计划内妊娠
        initCheckBoxSimple("build", ll_closeCaseCode, 2);//手工结案

    }

    public void setData(PersonInfo personInfo) {
        tv_name.setText(personInfo.getName());//姓名
        tv_birthDate.setText(personInfo.getBirthday());//出生日期
        tv_nation.setText(personInfo.getNationalityValue());//民族
        setCheckBoxSelect(personInfo.getEducationCode(), ll_xueli);//学历
        setCheckBoxSelect( personInfo.getOccupationCode(), ll_zhiye);//职业
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
        fatherLpw.setAnchorView(et_husbandName);
        fatherLpw.setModal(true);
        fatherLpw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_husbandName.setText(faterList.get(position));
                fatherLpw.dismiss();
            }
        });

    }

    public boolean saveData(MaternalRegister maternalRegister) {

        if ("".equals(tv_mensesLastDate.getText())) {
            ToastUtil.showToast(mContext, "请输入末次月经时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_buildingManualDate.getText())) {
            ToastUtil.showToast(mContext, "请输入建册时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_buildingManualCode))) {
            ToastUtil.showToast(mContext, "请选择是否建立《孕产妇保健手册》", Toast.LENGTH_LONG);
            return false;
        }

        maternalRegister.setWorkUnit(et_workUnit.getString());//工作单位
        maternalRegister.setHusbandName(et_husbandName.getString());//丈夫姓名
        maternalRegister.setHusbandUnit(et_husbandUnit.getString());//工作单位
        maternalRegister.setHusbandTelNo(et_husbandTelNo.getString());//电话
        maternalRegister.setAddress(et_address.getString());//住址
        maternalRegister.setMensesPeriod(et_mensesPeriod.getInt());//月经周期
        Checks checks = (Checks) sp_mensesMeasure.getSelectedItem();// 量
        maternalRegister.setMensesMeasure(checks.getValue());
        maternalRegister.setMensesLastDate(tv_mensesLastDate.getDate());//末次月经
        maternalRegister.setExpectedChildBirthday(tv_expectedChildBirthday.getDate());//预产期
        maternalRegister.setChildrenCount(et_childrenCount.getInt());//现有子女数
        maternalRegister.setBuildingManualDate(tv_buildingManualDate.getDate());//建册时间
        maternalRegister.setBuildingManualCode(getCheckBoxSimpleCode(ll_buildingManualCode));//是否建立《孕产妇保健手册》
        saveCheckBoxMany(null, maternalRegister.getRecordChoice(), ll_yunchanshi);//孕产史
        maternalRegister.setSpontaneousAbortionCount(et_spontaneousAbortionCount.getInt());//自然产次
        maternalRegister.setArtificialAbortionCount(et_artificialAbortionCount.getInt());//人工流产
        maternalRegister.setDrugAbortionCount(et_drugAbortionCount.getInt());//药物流产
        saveCheckBoxMany(null, maternalRegister.getRecordChoice(), ll_jiwangshi);//既往史
        saveCheckBoxMany(null, maternalRegister.getRecordChoice(), ll_jiazushi);//家族史
        saveCheckBoxMany(null, maternalRegister.getRecordChoice(), ll_renshen);//本次妊娠情况
        maternalRegister.setPregnancyInplan(getCheckBoxSimpleCode(ll_pregnancyInplan));//计划内妊娠
        maternalRegister.setPregnancyLasttime(tv_pregnancyLasttime.getDate());//前次妊娠
        maternalRegister.setGravidity(et_gravidity.getInt());//孕次
        maternalRegister.setParity(et_parity.getInt());//产次
        maternalRegister.setSbp(et_sbp.getInt());//收缩压
        maternalRegister.setDbp(et_dbp.getInt());//舒张压
        maternalRegister.setWeight(et_weight.getDouble());//体重
        maternalRegister.setHeight(et_height.getDouble());//身高
        maternalRegister.setBmi(et_bmi.getDouble());//体质指数
        maternalRegister.setRemark(et_remark.getString());//备注
        maternalRegister.setCloseCaseCode(getCheckBoxSimpleCode(ll_closeCaseCode));//手工结案
        maternalRegister.setCloseCaseReason(et_closeCaseReason.getString());//原因

        return true;
    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("孕产登记");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate);//出生日期
        tv_nation = (FuTextView) mFuView.findViewById(R.id.tv_nation);//民族
        ll_xueli = (LinearLayout) mFuView.findViewById(R.id.ll_xueli);//学历
        et_workUnit = (FuEditText) mFuView.findViewById(R.id.et_workUnit);//工作单位
        ll_zhiye = (LinearLayout) mFuView.findViewById(R.id.ll_zhiye);//职业
        et_husbandName = (FuEditText) mFuView.findViewById(R.id.et_husbandName);//丈夫姓名
        et_husbandName.setOnTouchListener(this);
        et_husbandUnit = (FuEditText) mFuView.findViewById(R.id.et_husbandUnit);//工作单位
        et_husbandTelNo = (FuEditText) mFuView.findViewById(R.id.et_husbandTelNo);//电话
        et_address = (FuEditText) mFuView.findViewById(R.id.et_address);//住址
        et_mensesPeriod = (FuEditText) mFuView.findViewById(R.id.et_mensesPeriod);//月经周期
        sp_mensesMeasure = (Spinner) mFuView.findViewById(R.id.sp_mensesMeasure);//量
        tv_mensesLastDate = (FuTextView) mFuView.findViewById(R.id.tv_mensesLastDate);//末次月经
        tv_mensesLastDate.setOnClickListener(this);
        tv_expectedChildBirthday = (FuTextView) mFuView.findViewById(R.id.tv_expectedChildBirthday);//预产期
        tv_expectedChildBirthday.setOnClickListener(this);
        et_childrenCount = (FuEditText) mFuView.findViewById(R.id.et_childrenCount);//现有子女数
        tv_buildingManualDate = (FuTextView) mFuView.findViewById(R.id.tv_buildingManualDate);//建册时间
        tv_buildingManualDate.setOnClickListener(this);
        ll_buildingManualCode = (LinearLayout) mFuView.findViewById(R.id.ll_buildingManualCode);//是否建立《孕产妇保健手册》
        ll_yunchanshi = (LinearLayout) mFuView.findViewById(R.id.ll_yunchanshi);//孕产史
        et_spontaneousAbortionCount = (FuEditText) mFuView.findViewById(R.id.et_spontaneousAbortionCount);//自然产次
        et_artificialAbortionCount = (FuEditText) mFuView.findViewById(R.id.et_artificialAbortionCount);//人工流产
        et_drugAbortionCount = (FuEditText) mFuView.findViewById(R.id.et_drugAbortionCount);//药物流产
        ll_jiwangshi = (LinearLayout) mFuView.findViewById(R.id.ll_jiwangshi);//既往史
        ll_jiazushi = (LinearLayout) mFuView.findViewById(R.id.ll_jiazushi);//家族史
        ll_renshen = (LinearLayout) mFuView.findViewById(R.id.ll_renshen);//本次妊娠情况
        ll_pregnancyInplan = (LinearLayout) mFuView.findViewById(R.id.ll_pregnancyInplan);//计划内妊娠
        tv_pregnancyLasttime = (FuTextView) mFuView.findViewById(R.id.tv_pregnancyLasttime);//前次妊娠
        tv_pregnancyLasttime.setOnClickListener(this);
        et_gravidity = (FuEditText) mFuView.findViewById(R.id.et_gravidity);//孕次
        et_parity = (FuEditText) mFuView.findViewById(R.id.et_parity);//产次
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//收缩压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//舒张压
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//体质指数
        et_remark = (FuEditText) mFuView.findViewById(R.id.et_remark);//备注
        ll_closeCaseCode = (LinearLayout) mFuView.findViewById(R.id.ll_closeCaseCode);//手工结案
        et_closeCaseReason = (FuEditText) mFuView.findViewById(R.id.et_closeCaseReason);//原因

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.et_height:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
            case R.id.et_weight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final int DRAWABLE_RIGHT = 2;
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getX() >= (v.getWidth() - ((EditText) v)
                    .getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                fatherLpw.show();
                return true;
            }
        }

        return false;
    }
}
