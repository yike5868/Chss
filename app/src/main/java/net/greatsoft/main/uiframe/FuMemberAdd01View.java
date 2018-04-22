package net.greatsoft.main.uiframe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.view.DataPicker.DatePicker;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/18
 * Time: 09:48
 * progject: Chss_FollowUp
 * Describe： 入户随访-新增成员-个人信息
 */

public class FuMemberAdd01View extends FuUiFrameModel implements View.OnClickListener {

    Spinner sp_committee; //村居委会
    Spinner sp_residential;   //小区
    Spinner sp_building;  //楼栋
    FuEditText et_name; //姓名
    FuEditText et_formerName; //曾用名
    FuEditText et_idNo; //身份证号
    FuTextView tv_birthday; //出生日期
    LinearLayout ll_sex;    //性别
    FuEditText et_address;  //家庭地址
    FuEditText et_householdAddress; //户籍地址
    FuEditText et_telNo;    //本人电话
    FuEditText et_fixedPhones;  //固定电话
    Spinner sp_relation;  //与户主关系
    FuEditText et_contactName;  //联系人姓名
    FuEditText et_contactTelNo;    //联系人电话
    FuEditText et_elseContact;    //其他联系人电话
    FuEditText et_workUnit; //工作单位
    FuTextView tv_paperArchiveDate; //纸质档案建档时间
    FuEditText et_paperCardNum; //纸质档案编号

    Date parse;

    boolean flag = true;

    public FuMemberAdd01View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_member_add01_view, null);
    }

    @Override
    public void onClick(View v) {

    }

    public void saveData(PersonInfo personInfo) {

        personInfo.setName(et_name.getString()); //姓名
        personInfo.setFormerName(et_formerName.getString()); //曾用名
        personInfo.setIdNo(et_idNo.getString()); //身份证号
        personInfo.setBirthday(parse); //出生日期
        personInfo.setSexCode(getCheckBoxSimpleCode(ll_sex));    //性别
        personInfo.setSexValue(getCheckBoxSimpleString(ll_sex));
        personInfo.setAddress(et_address.getString());  //家庭地址
        personInfo.setHouseholdAddress(et_householdAddress.getString()); //户籍地址
        personInfo.setTelNo(et_telNo.getString());    //本人电话
        personInfo.setFixedPhones(et_fixedPhones.getString());  //固定电话

        Checks checks = (Checks) sp_relation.getSelectedItem();
        personInfo.setRelationCode(checks.getCode());  //与户主关系
        personInfo.setRelationValue(checks.getValue());
        personInfo.setContactName(et_contactName.getString());  //联系人姓名
        personInfo.setContactTelNo(et_contactTelNo.getString());    //联系人电话
        personInfo.setWorkUnit(et_workUnit.getString()); //工作单位
        personInfo.setPaperArchiveDate(tv_paperArchiveDate.getDate()); //纸质档案建档时间
        personInfo.setPaperCardNum(et_paperCardNum.getString()); //纸质档案编号


    }

    public void setData(PersonInfo personInfo) {
//        mPersonInfo = personInfo;
        et_name.setText(personInfo.getName()); //姓名
        et_formerName.setText(personInfo.getFormerName()); //曾用名
        et_idNo.setText(personInfo.getIdNo()); //身份证号
        tv_birthday.setText(personInfo.getBirthday()); //出生日期
        setCheckBoxSelect(personInfo.getSexCode(), ll_sex);    //性别
        et_address.setText(personInfo.getAddress());  //家庭地址
        et_householdAddress.setText(personInfo.getHouseholdAddress()); //户籍地址
        et_telNo.setText(personInfo.getTelNo());    //本人电话
        et_fixedPhones.setText(personInfo.getFixedPhones());  //固定电话

        setSpinnerSelected("CV0218.01", personInfo.getRelationCode(), sp_relation); //与户主关系
        et_contactName.setText(personInfo.getContactName());  //联系人姓名
        //联系人电话
        et_contactTelNo.setText(personInfo.getContactTelNo());

        et_workUnit.setText(personInfo.getWorkUnit()); //工作单位
        tv_paperArchiveDate.setText(personInfo.getPaperArchiveDate()); //纸质档案建档时间
        et_paperCardNum.setText(personInfo.getPaperCardNum()); //纸质档案编号
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        sp_committee = (Spinner) mFuView.findViewById(R.id.sp_committee); //村居委会
        sp_residential = (Spinner) mFuView.findViewById(R.id.sp_residential);   //小区
        sp_building = (Spinner) mFuView.findViewById(R.id.sp_building);  //楼栋
        et_name = (FuEditText) mFuView.findViewById(R.id.et_name); //姓名
        et_formerName = (FuEditText) mFuView.findViewById(R.id.et_formerName); //曾用名
        et_idNo = (FuEditText) mFuView.findViewById(R.id.et_idNo); //身份证号
        tv_birthday = (FuTextView) mFuView.findViewById(R.id.tv_birthday); //出生日期
        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker picker = new DatePicker((Activity) mContext);
                picker.setRangeStart(1900, 1, 1);
                picker.setRangeEnd(2020, 1, 1);
                picker.setSelectedItem(2000, 1, 1);
                picker.setGravity(Gravity.CENTER);//弹框居中
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        tv_birthday.setText(year + "-" + month + "-" + day);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            parse = dateFormat.parse(year + "-" + month + "-" + day);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
                picker.show();
                picker.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        tv_birthday.setEnabled(true);
                    }
                });
                if (picker.isShowing()) {
                    tv_birthday.setEnabled(false);
                }


            }
        });
        ll_sex = (LinearLayout) mFuView.findViewById(R.id.ll_sex);    //性别
        et_address = (FuEditText) mFuView.findViewById(R.id.et_address);  //家庭地址
        et_householdAddress = (FuEditText) mFuView.findViewById(R.id.et_householdAddress); //户籍地址
        et_telNo = (FuEditText) mFuView.findViewById(R.id.et_telNo);    //本人电话
        et_fixedPhones = (FuEditText) mFuView.findViewById(R.id.et_fixedPhones);  //固定电话
        sp_relation = (Spinner) mFuView.findViewById(R.id.sp_relation);  //与户主关系
        et_contactName = (FuEditText) mFuView.findViewById(R.id.et_contactName);  //联系人姓名
        et_contactTelNo = (FuEditText) mFuView.findViewById(R.id.et_contactTelNo);    //联系人电话
        et_elseContact = (FuEditText) mFuView.findViewById(R.id.et_elseContact);    //其他；联系电话
        et_workUnit = (FuEditText) mFuView.findViewById(R.id.et_workUnit); //工作单位
        tv_paperArchiveDate = (FuTextView) mFuView.findViewById(R.id.tv_paperArchiveDate); //纸质档案建档时间
        tv_paperArchiveDate.setOnClickListener(this);
        et_paperCardNum = (FuEditText) mFuView.findViewById(R.id.et_paperCardNum); //纸质档案编号

        //与户主关系
        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CV0218.01")).orderAsc(ChecksDao.Properties.Code).list();
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_relation.setAdapter(adapter);

        // 性别代码
        initCheckBoxSimple("CV9500.48", ll_sex, 0);

    }
}
