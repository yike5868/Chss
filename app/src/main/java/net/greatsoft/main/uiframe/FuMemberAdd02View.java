package net.greatsoft.main.uiframe;

import android.content.Context;
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

import java.util.List;


/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/18
 * Time: 15:58
 * progject: Chss_FollowUp
 * Describe：入户随访-新增成员-户籍信息
 */

public class FuMemberAdd02View extends FuUiFrameModel implements View.OnClickListener {

    LinearLayout ll_residenceType;  //常住类型
    LinearLayout ll_householdType;  //户籍类型
    Spinner sp_nationality;   //民族
    LinearLayout ll_aboCode;    //血型
    LinearLayout ll_rhCode;   //RH阴性
    LinearLayout ll_educationCode;  //文化程度
    LinearLayout ll_occupation; //职业
    LinearLayout ll_marriage;   //婚姻状况

    PersonInfo mPersonInfo; //个人信息 为了保存证件类型

    public FuMemberAdd02View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_member_add02_view, null);
    }

    public void setData(PersonInfo personInfo) {
        mPersonInfo = personInfo;

        setCheckBoxSelect(personInfo.getResidenceTypeCode(), ll_residenceType);  //常住类型
        setCheckBoxSelect(personInfo.getHouseholdTypeCode(), ll_householdType);  //户籍类型
        setSpinnerSelected("CV9500.53", personInfo.getNationalityCode(), sp_nationality);  //民族
        setCheckBoxSelect(personInfo.getAboCode(), ll_aboCode);    //血型
        setCheckBoxSelect(personInfo.getRhCode(),ll_rhCode);
        setCheckBoxSelect(personInfo.getEducationCode(), ll_educationCode);  //文化程度
        setCheckBoxSelect(personInfo.getOccupationCode(), ll_occupation); //职业
        setCheckBoxSelect(personInfo.getMarriageCode(), ll_marriage);   //婚姻状况
    }

    public void saveData(PersonInfo personInfo) {

        personInfo.setResidenceTypeCode(getCheckBoxSimpleCode(ll_residenceType));  //常住类型
        personInfo.setHouseholdTypeCode(getCheckBoxSimpleCode(ll_householdType));  //户籍类型
        Checks c = (Checks) sp_nationality.getSelectedItem();
        personInfo.setNationalityCode(c.getCode());//民族
        personInfo.setNationalityValue(c.getValue());
        personInfo.setAboCode(getCheckBoxSimpleCode(ll_aboCode));    //血型
        personInfo.setRhCode(getCheckBoxSimpleCode(ll_rhCode));
        personInfo.setEducationCode(getCheckBoxSimpleCode(ll_educationCode));  //文化程度
        personInfo.setOccupationCode(getCheckBoxSimpleCode(ll_occupation)); //职业
        personInfo.setMarriageCode(getCheckBoxSimpleCode(ll_marriage));   //婚姻状况
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        findView();

        // 民族
        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CV9500.53")).orderAsc(ChecksDao.Properties.Code).list();
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_nationality.setAdapter(adapter);

        // 常住类型
        initCheckBoxSimple("HOUSEFLAG", ll_residenceType, 0);
        // 户籍类型
        initCheckBoxSimple("DOMICILE_TYPE", ll_householdType, 0);
        // 血型
        initCheckBoxSimple("CV5103.02ABO", ll_aboCode, 5);
        // RH阴性
        initCheckBoxSimple("RHNEGATIVE", ll_rhCode, 2);
        // 文化程度
        initCheckBoxSimple("CULTUREDEGREE", ll_educationCode, 2);
        // 职业
        initCheckBoxSimple("MEMBERPROFESSION", ll_occupation, 1);
        // 婚姻
        initCheckBoxSimple("MARRIAGESTATUS", ll_marriage, 3);

    }

    public void findView() {
        ll_residenceType = (LinearLayout) mFuView.findViewById(R.id.ll_residenceType);  //常住类型
        ll_householdType = (LinearLayout) mFuView.findViewById(R.id.ll_householdType);  //户籍类型
        sp_nationality = (Spinner) mFuView.findViewById(R.id.sp_nationality);   //民族
        ll_aboCode = (LinearLayout) mFuView.findViewById(R.id.ll_aboCode);    //血型
        ll_rhCode = (LinearLayout) mFuView.findViewById(R.id.ll_RHCode);
        ll_educationCode = (LinearLayout) mFuView.findViewById(R.id.ll_educationCode);  //文化程度
        ll_occupation = (LinearLayout) mFuView.findViewById(R.id.ll_occupation); //职业
        ll_marriage = (LinearLayout) mFuView.findViewById(R.id.ll_marriage);   //婚姻状况
    }
}
