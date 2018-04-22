package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuDiaHY04View extends FuUiFrameModel implements View.OnClickListener {

    LinearLayout ll_drugComplianceCode; //服药依从性         共
    FuTextView tv_o_drugCompliance;       //上次服药依从性      共
    LinearLayout ll_drugAdverseCode;    //服药不良反应        共
    FuTextView tv_o_drugAdverseCode;      //上次服药不良反应    共
    LinearLayout ll_hypogReactCode;     //低血糖反应代码       糖
    FuTextView tv_o_hypogReactCode;        //上次低血糖反应代码   糖
    LinearLayout ll_pofdaCode;           //足背动脉搏动       糖
    FuTextView tv_pofdaCode;               //上次足背动脉搏动     糖
    LinearLayout ll_followupClassifyCode;//此次随访分类       共
    FuTextView tv_o_followupClassifyCode;     //上次此次随访分类  共
    CheckBox cb_isReferralCode;             //是否转诊         共
    FuEditText et_referralReason;             //转诊原因          共
    FuEditText et_refertoOrgName;            //转诊机构      共
    FuEditText et_nextFollowupDate;           //下次随访日期    共
    Spinner sp_followupDoctor;              //本次随访医生    共


    FuTextView tv_num;                        //二维码编号     共
    Button btn_scan;                        //扫描二维码按钮   共
    Button btn_next;                        //完成

    public FuDiaHY04View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.diahy_fragment04, null);
    }

    public void setData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup,
                        HyperFollowup oHyperFollowup, DiabetesFollowup oDiabetesFollowup) {

        setCheckBoxTwoSelect(hyperFollowup.getDrugComplianceCode(), diabetesFollowup.getDrugComplianceCode(), ll_drugComplianceCode); //服药依从性 共
         tv_o_drugCompliance.setText(oHyperFollowup.getDrugComplianceCode(),oDiabetesFollowup.getDrugComplianceCode());       //上次服药依从性      共
        setCheckBoxTwoSelect(hyperFollowup.getDrugAdverseCode(),diabetesFollowup.getDrugAdverseCode(),ll_drugAdverseCode);    //服药不良反应        共
         tv_o_drugAdverseCode.setText(oHyperFollowup.getDrugAdverseDesc(),oDiabetesFollowup.getDrugAdverseDesc());      //上次服药不良反应    共
         setCheckBoxSelect(diabetesFollowup.getHypogReactCode(),ll_hypogReactCode);     //低血糖反应代码       糖
         tv_o_hypogReactCode.setText(oDiabetesFollowup.getHypogReactCode());        //上次低血糖反应代码   糖
         setCheckBoxSelect(diabetesFollowup.getPofdaCode(),ll_pofdaCode);           //足背动脉搏动       糖
         tv_pofdaCode.setText(oDiabetesFollowup.getPofdaCode());               //上次足背动脉搏动     糖
        setCheckBoxTwoSelect(hyperFollowup.getFollowupClassifyCode(),diabetesFollowup.getFollowupClassifyCode(),ll_followupClassifyCode);//此次随访分类       共
         tv_o_followupClassifyCode.setText(oHyperFollowup.getFollowupClassifyCode(),oDiabetesFollowup.getFollowupClassifyCode());     //上次此次随访分类  共
      //   cb_isReferralCode.setChecked();             //是否转诊         共
         et_referralReason.setText(hyperFollowup.getReferralReason(),diabetesFollowup.getReferralReason());             //转诊原因          共
        et_refertoOrgName.setText(hyperFollowup.getRefertoOrgName(),diabetesFollowup.getRefertoOrgName());            //转诊机构      共
         et_nextFollowupDate.setText(hyperFollowup.getNextFollowupDate(),diabetesFollowup.getFollowupDate());           //下次随访日期    共
//         sp_followupDoctor;              //本次随访医生    共


    }

    public void saveData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup) {

         hyperFollowup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode)); //服药依从性         共
         hyperFollowup.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode));    //服药不良反应        共
         hyperFollowup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//此次随访分类       共
//         cb_isReferralCode;             //是否转诊         共
         hyperFollowup.setReferralReason(et_referralReason.getString());             //转诊原因          共
         hyperFollowup.setRefertoOrgName(et_refertoOrgName.getString());            //转诊机构      共
         hyperFollowup.setNextFollowupDate(et_nextFollowupDate.getDate());           //下次随访日期    共


        diabetesFollowup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode)); //服药依从性         共
        diabetesFollowup.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode));    //服药不良反应        共
        diabetesFollowup.setHypogReactCode(getCheckBoxSimpleCode(ll_hypogReactCode));     //低血糖反应代码       糖
        diabetesFollowup.setPofdaCode(getCheckBoxSimpleCode(ll_pofdaCode));           //足背动脉搏动       糖
        diabetesFollowup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//此次随访分类       共
//         cb_isReferralCode;             //是否转诊         共
        diabetesFollowup.setReferralReason(et_referralReason.getString());             //转诊原因          共
        diabetesFollowup.setRefertoOrgName(et_refertoOrgName.getString());            //转诊机构      共
        diabetesFollowup.setNextFollowupDate(et_nextFollowupDate.getDate());           //下次随访日期    共
//         sp_followupDoctor;              //本次随访医生    共
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        findView();
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugComplianceCode,0);
        initCheckBoxSimple("YES_NO_CODE", ll_drugAdverseCode,0);
        initCheckBoxSimple("HYPOGLYCEMIA", ll_hypogReactCode,0);
        initCheckBoxSimple("VISIT_ASSORT", ll_followupClassifyCode, 0);
        initCheckBoxSimple("FOOT_DORSUMARTERY", ll_pofdaCode,0);
    }

    public void findView() {
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode);//服药依从性
        tv_o_drugCompliance = (FuTextView) mFuView.findViewById(R.id.tv_o_drugCompliance);       //上次服药依从性
        ll_drugAdverseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugAdverseCode);    //服药不良反应
        tv_o_drugAdverseCode = (FuTextView) mFuView.findViewById(R.id.tv_o_drugAdverseCode);      //上次服药不良反应
        ll_hypogReactCode = (LinearLayout) mFuView.findViewById(R.id.ll_hypogReactCode);     //低血糖反应代码
        tv_o_hypogReactCode = (FuTextView) mFuView.findViewById(R.id.tv_o_hypogReactCode);        //上次低血糖反应代码
        ll_pofdaCode = (LinearLayout) mFuView.findViewById(R.id.ll_pofdaCode);           //足背动脉搏动
        tv_pofdaCode = (FuTextView) mFuView.findViewById(R.id.tv_pofdaCode);               //上次足背动脉搏动
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode);//此次随访分类
        tv_o_followupClassifyCode = (FuTextView) mFuView.findViewById(R.id.tv_o_followupClassifyCode);     //上次此次随访分类
        cb_isReferralCode = (CheckBox) mFuView.findViewById(R.id.cb_isReferralCode);             //是否转诊
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason);             //转诊原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName);            //转诊机构
        et_nextFollowupDate = (FuEditText) mFuView.findViewById(R.id.et_nextFollowupDate);           //下次随访日期
        sp_followupDoctor = (Spinner) mFuView.findViewById(R.id.sp_followupDoctor);              //本次随访医生
        tv_num = (FuTextView) mFuView.findViewById(R.id.tv_num);                        //二维码编号
        btn_scan = (Button) mFuView.findViewById(R.id.btn_scan);                        //扫描二维码按钮
        btn_next = (Button) mFuView.findViewById(R.id.btn_next);                        //完成

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}
