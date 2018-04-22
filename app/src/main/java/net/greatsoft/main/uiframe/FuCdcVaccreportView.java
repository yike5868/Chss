package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.vaccine.CdcVaccreport;
import net.greatsoft.main.fragment.FuCdcVaccreportFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/12/28
 * Time: 10:55
 * progject: Chss
 * Describe： 预防接种卡
 */

public class FuCdcVaccreportView extends FuUiFrameModel implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    FuTextView tv_name; //姓名
    FuTextView tv_sexCode; //性别
    FuEditText et_cdcVaccreportNo; //接种证号
    FuTextView tv_birthDate; //出生日期
    FuEditText et_guardianName; //监护人姓名
    Spinner sp_guardianRelationCode; //与儿童关系
    FuEditText et_familyTelNo; //联系电话
    FuEditText et_presentAddr; //家庭现住址
    FuCheckBox cb_isSame; //户籍住址
    FuEditText et_registerAddrProvince; //户籍住址
    FuTextView tv_moveInDate; //迁入时间
    FuTextView tv_moveOutDate; //迁出时间
    FuEditText et_moveOutReason; //迁出原因
    FuEditText et_vaccinateContraindication; //接种禁忌
    FuEditText et_infectionHistory; //传染病史

    TextView fu_title_center;
    Button fu_title_right_btn;

    public FuCdcVaccreportView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuCdcVaccreportFragment.EVENT_SAVE_CDCVACC_REPORT, null);
                break;
            case R.id.tv_moveInDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_moveOutDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
        }

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cdcvacc_rerport_view, null);

    }

    @Override
    protected void initFuData() {

        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("childRelation")).orderAsc(ChecksDao.Properties.Code).list();
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_guardianRelationCode.setAdapter(adapter);

    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("预防接种卡");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(CdcVaccreport cdcVaccreport) {
        tv_name.setText(cdcVaccreport.getName());//姓名
        tv_sexCode.setText(cdcVaccreport.getSexCode());//性别
        tv_birthDate.setText(cdcVaccreport.getBirthDate());//出生日期
    }

    public boolean saveData(CdcVaccreport cdcVaccreport) {

        if ("".equals(et_cdcVaccreportNo.getString())) {
            ToastUtil.showToast(mContext, "请输入接种证号", Toast.LENGTH_LONG);
            return false;
        }
        cdcVaccreport.setCdcVaccreportNo(et_cdcVaccreportNo.getString());//接种证号
        cdcVaccreport.setGuardianName(et_guardianName.getString()); //监护人姓名
        Checks checks = (Checks) sp_guardianRelationCode.getSelectedItem();
        cdcVaccreport.setGuardianRelationCode(checks.getCode());//与儿童关系
        cdcVaccreport.setFamilyTelNo(et_familyTelNo.getString());//联系电话
        cdcVaccreport.setPresentAddr(et_presentAddr.getString());//家庭现住址
        cdcVaccreport.setRegisterAddrProvince(et_registerAddrProvince.getString()); //户籍住址
        cdcVaccreport.setMoveInDate(tv_moveInDate.getDate());//迁入时间
        cdcVaccreport.setMoveOutDate(tv_moveOutDate.getDate());//迁出时间
        cdcVaccreport.setMoveOutReason(et_moveOutReason.getString());//迁出原因
        cdcVaccreport.setVaccinateContraindication(et_vaccinateContraindication.getString());//接种禁忌
        cdcVaccreport.setInfectionHistory(et_infectionHistory.getString());//传染病史
        cdcVaccreport.setSexCode("");
        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_sexCode = (FuTextView) mFuView.findViewById(R.id.tv_sexCode); //性别
        et_cdcVaccreportNo = (FuEditText) mFuView.findViewById(R.id.et_cdcVaccreportNo); //接种证号
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate); //出生日期
        et_guardianName = (FuEditText) mFuView.findViewById(R.id.et_guardianName); //监护人姓名
        sp_guardianRelationCode = (Spinner) mFuView.findViewById(R.id.sp_guardianRelationCode); //与儿童关系
        et_familyTelNo = (FuEditText) mFuView.findViewById(R.id.et_familyTelNo); //联系电话
        et_presentAddr = (FuEditText) mFuView.findViewById(R.id.et_presentAddr); //家庭现住址
        cb_isSame = (FuCheckBox) mFuView.findViewById(R.id.cb_isSame); //户籍住址
        cb_isSame.setOnCheckedChangeListener(this);
        et_registerAddrProvince = (FuEditText) mFuView.findViewById(R.id.et_registerAddrProvince); //户籍住址
        tv_moveInDate = (FuTextView) mFuView.findViewById(R.id.tv_moveInDate); //迁入时间
        tv_moveInDate.setOnClickListener(this);
        tv_moveOutDate = (FuTextView) mFuView.findViewById(R.id.tv_moveOutDate); //迁出时间
        tv_moveOutDate.setOnClickListener(this);
        et_moveOutReason = (FuEditText) mFuView.findViewById(R.id.et_moveOutReason); //迁出原因
        et_vaccinateContraindication = (FuEditText) mFuView.findViewById(R.id.et_vaccinateContraindication); //接种禁忌
        et_infectionHistory = (FuEditText) mFuView.findViewById(R.id.et_infectionHistory); //传染病史

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            et_registerAddrProvince.setText(et_presentAddr.getText() != null ? et_presentAddr.getText() : "");
        } else {
            et_registerAddrProvince.setText("");
        }
    }
}
