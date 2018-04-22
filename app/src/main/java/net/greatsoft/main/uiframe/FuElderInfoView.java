package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.old.ElderInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuElderInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Date: 2017/03/20
 * Time: 13:19
 * progject: Chss
 * Describe： 老年人花名册(专档)
 */

public class FuElderInfoView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_birthDate;//出生日期
    FuTextView tv_hunyin;//婚姻状况
    FuTextView tv_gudingTel;//固定电话
    FuTextView tv_yidongTel;//移动电话
    FuTextView tv_adress;//家庭地址
    LinearLayout ll_maintenanceModeCode;//赡养方式
    FuTextView tv_manageDate;//纳入管理日期
    FuEditText et_guardianName;//监护人姓名
    Spinner sp_guardianRelationCode;//与本人关系
    FuEditText et_guardianTelNo;//固定电话
    FuEditText et_guardianMobile;//移动电话
    FuEditText et_remarks;//备注
    FuEditText et_informant;//被调查者
    FuTextView tv_investigatorDate;//调查时间

    TextView fu_title_center;
    Button fu_title_right_btn;

    public FuElderInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_elderinfo_view, null);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_investigatorDate:
                ((FuContentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_manageDate:
                ((FuContentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuElderInfoFragment.EVENT_SAVE_ELDERINFO, null);
                break;
        }

    }

    public void setData(PersonInfo personInfo) {

        tv_name.setText(personInfo.getName());//姓名
        tv_sex.setText(personInfo.getSexValue());//性别
        tv_birthDate.setText(personInfo.getBirthday());//出生日期

        List<Checks> checksList = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("MARRIAGESTATUS"), ChecksDao.Properties.Code.eq(personInfo.getMarriageCode())).list();
        if (!checksList.isEmpty()) {
            tv_hunyin.setText(checksList.get(0).getValue());//婚姻状况
        }
        tv_gudingTel.setText(personInfo.getFixedPhones());//固定电话
        tv_yidongTel.setText(personInfo.getTelNo());//移动电话
        tv_adress.setText(personInfo.getAddress());//家庭地址

    }

    public boolean saveData(ElderInfo elderInfo) {

        if ("".equals(tv_manageDate.getText())) {
            ToastUtil.showToast(mContext, "请输入纳入管理日期", Toast.LENGTH_LONG);
            return false;
        }

        elderInfo.setMaintenanceModeCode(getCheckBoxSimpleCode(ll_maintenanceModeCode));//赡养方式
        elderInfo.setManageDate(tv_manageDate.getDate());//纳入管理日期
        elderInfo.setGuardianName(et_guardianName.getString());//监护人姓名
        Checks checks = (Checks) sp_guardianRelationCode.getSelectedItem();
        elderInfo.setGuardianRelationCode(checks.getCode());  //与户主关系
        elderInfo.setGuardianTelNo(et_guardianTelNo.getString());//固定电话
        elderInfo.setGuardianMobile(et_guardianMobile.getString());//移动电话
        elderInfo.setRemarks(et_remarks.getString());//备注
        elderInfo.setInformant(et_informant.getString());//被调查者
        elderInfo.setInvestigatorDate(tv_investigatorDate.getDate());//调查时间

        return true;
    }

    @Override
    protected void initFuData() {

        initCheckBoxSimple("maintenanceModeCode", ll_maintenanceModeCode, 3);

    }

    @Override
    protected void initWidget() {
        findView();

        //与户主关系
        List list = sqlHelper.getChecksByTerm("relation");
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_guardianRelationCode.setAdapter(adapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("老年人花名册");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate);//出生日期
        tv_hunyin = (FuTextView) mFuView.findViewById(R.id.tv_hunyin);//婚姻状况
        tv_gudingTel = (FuTextView) mFuView.findViewById(R.id.tv_gudingTel);//固定电话
        tv_yidongTel = (FuTextView) mFuView.findViewById(R.id.tv_yidongTel);//移动电话
        tv_adress = (FuTextView) mFuView.findViewById(R.id.tv_adress);//家庭地址
        ll_maintenanceModeCode = (LinearLayout) mFuView.findViewById(R.id.ll_maintenanceModeCode);//赡养方式
        tv_manageDate = (FuTextView) mFuView.findViewById(R.id.tv_manageDate);//纳入管理日期
        tv_manageDate.setOnClickListener(this);
        et_guardianName = (FuEditText) mFuView.findViewById(R.id.et_guardianName);//监护人姓名
        sp_guardianRelationCode = (Spinner) mFuView.findViewById(R.id.sp_guardianRelationCode);//与本人关系
        et_guardianTelNo = (FuEditText) mFuView.findViewById(R.id.et_guardianTelNo);//固定电话
        et_guardianMobile = (FuEditText) mFuView.findViewById(R.id.et_guardianMobile);//移动电话
        et_remarks = (FuEditText) mFuView.findViewById(R.id.et_remarks);//备注
        et_informant = (FuEditText) mFuView.findViewById(R.id.et_informant);//被调查者
        tv_investigatorDate = (FuTextView) mFuView.findViewById(R.id.tv_investigatorDate);//调查时间
        tv_investigatorDate.setOnClickListener(this);

    }
}
