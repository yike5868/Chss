package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisInfo;
import net.greatsoft.main.fragment.FuTuberculosisInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Date: 2017/03/24
 * Time: 10:33
 * progject: Chss
 * Describe： 肺结核专档
 */

public class FuTuberculosisInfoView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_commitDate;//结核病确诊日期
    FuEditText et_phone;//联系方式
    FuEditText et_familyname;//患者家属姓名
    Spinner sp_familyrelation;//与患者关系
    FuEditText et_famliyphone;//患者家属联系电话
    FuEditText et_commitDoctor;//结核病定点医疗机构医生
    FuEditText et_commitOrg;//结核病定点医疗机构

    TextView fu_title_center;
    Button fu_title_right_btn;

    PersonInfo mPersonInfo;


    public FuTuberculosisInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_commitDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuTuberculosisInfoFragment.EVENT_SAVE_TUBERCULOSIS_INFO, null);
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_tuberculosisinfo_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

        findView();

        //与户主关系
        List list = sqlHelper.getChecksByTerm("relation");
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_familyrelation.setAdapter(adapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("肺结核专档");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(PersonInfo personInfo) {

        tv_name.setText(personInfo.getName());//姓名
        tv_sex.setText(personInfo.getSexValue());//性别

        mPersonInfo = personInfo;
    }

    public boolean saveData(TuberculosisInfo tuberculosisInfo) {

        if ("".equals(tv_commitDate.getText())) {
            ToastUtil.showToast(mContext, "请填写确诊日期", Toast.LENGTH_LONG);
            return false;
        }

        tuberculosisInfo.setCommitDate(tv_commitDate.getDate());//结核病确诊日期
        tuberculosisInfo.setPhone(et_phone.getString());//联系方式
        tuberculosisInfo.setFamilyname(et_familyname.getString());//患者家属姓名
        Checks checks = (Checks) sp_familyrelation.getSelectedItem();//与户主关系
        tuberculosisInfo.setFamilyrelation(checks.getCode());
        tuberculosisInfo.setFamliyphone(et_famliyphone.getString());//患者家属联系电话
        tuberculosisInfo.setCommitDoctor(et_commitDoctor.getString());//结核病定点医疗机构医生
        tuberculosisInfo.setCommitOrg(et_commitOrg.getString());//结核病定点医疗机构

        tuberculosisInfo.setTuberculosisInfoNo(mPersonInfo.getPersonInfoNo());

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_commitDate = (FuTextView) mFuView.findViewById(R.id.tv_commitDate);//结核病确诊日期
        tv_commitDate.setOnClickListener(this);
        et_phone = (FuEditText) mFuView.findViewById(R.id.et_phone);//联系方式
        et_familyname = (FuEditText) mFuView.findViewById(R.id.et_familyname);//患者家属姓名
        sp_familyrelation = (Spinner) mFuView.findViewById(R.id.sp_familyrelation);//与患者关系
        et_famliyphone = (FuEditText) mFuView.findViewById(R.id.et_famliyphone);//患者家属联系电话
        et_commitDoctor = (FuEditText) mFuView.findViewById(R.id.et_commitDoctor);//结核病定点医疗机构医生
        et_commitOrg = (FuEditText) mFuView.findViewById(R.id.et_commitOrg);//结核病定点医疗机构

    }
}
