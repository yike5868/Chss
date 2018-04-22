package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.view.FuEditText;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuExam03View extends FuUiFrameModel implements View.OnClickListener {

    FuEditText et_hgb;                //血红蛋白
    FuEditText et_wbc;                //白细胞
    FuEditText et_plt;                //血小板
    FuEditText et_cbcOthers;          //其他
    FuEditText et_proQuanTestValue;   //尿蛋白
    FuEditText et_gluQuanTestValue;   //尿糖
    FuEditText et_ketQualResultValue; //尿酮体
    FuEditText et_uobTestResultValue; //尿潜血
    FuEditText et_urineOthers;        //尿常规--其他
    FuEditText et_fbgMmol;            //空腹血糖
    FuEditText et_fbgMg;
    FuEditText et_pbgMmol;            //餐后血糖
    FuEditText et_pbgMg;
    LinearLayout ll_ecgAbnorm;      //心电图
    FuEditText et_urineMalb;        //尿微量白蛋白
    LinearLayout ll_fob;            //大便潜血
    FuEditText et_ghb;                //糖化血红蛋白
    LinearLayout ll_hbsagTestResult;//乙型肝炎表面抗原
    FuEditText et_sgpt;               //血清谷丙转氨酶
    FuEditText et_ast;                //血清谷草转氨酶
    FuEditText et_alb;                //白蛋白
    FuEditText et_tbi;                //总胆红素
    FuEditText et_dbil;               //结合胆红素
    FuEditText et_scr;                //血清肌酐
    FuEditText et_bun;                //血尿素氮
    FuEditText et_bloodK;             //血钾浓度
    FuEditText et_bloodNa;            //血钠浓度
    FuEditText et_tcho;               //总胆固醇
    FuEditText et_tg;                 //甘油三酯
    FuEditText et_ldlc;               //血清低密度脂蛋白胆固醇
    FuEditText et_hdlc;               //血清高密度脂蛋白胆固醇
    LinearLayout ll_xrayChest;      //胸部X线片
    LinearLayout ll_bscanAbdomen;   //腹部B超
    LinearLayout ll_bscanOthers;    //B超--其他
    LinearLayout ll_cps;            //宫颈涂片
    FuEditText et_otherAssistExam;    //辅助检查--其他
//    LinearLayout ll_gentleQuality;  //平和质
//    LinearLayout ll_qiDeficiency;   //气虚质
//    LinearLayout ll_yangDeficiency; //阳虚质
//    LinearLayout ll_yinDeficiency;  //阴虚质
//    LinearLayout ll_phlegmWet;      //痰湿质
//    LinearLayout ll_dampHeat;       //湿热质
//    LinearLayout ll_bloodStasis;    //血瘀质
//    LinearLayout ll_qiDepression;   //气郁质
//    LinearLayout ll_specialDiathsis;//特秉质

    public FuExam03View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_exam03_jn_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError(){
    }
    @Override
    protected void initWidget() {
        findView();
        // 心电图
        initCheckBoxSimple("CV9600.02", ll_ecgAbnorm,0,false,true,false);
        // 大便潜血*
        initCheckBoxSimple("CV9500.230", ll_fob,0,false,false,false);
        // 乙型肝炎表面抗原*
        initCheckBoxSimple("CV9500.230", ll_hbsagTestResult,0,false,false,false);
        // 胸部X线片*FuEditText
        initCheckBoxSimple("CV9600.02", ll_xrayChest,0,false,true,false);
        // B超*FuEditText
        initCheckBoxSimple("CV9600.02", ll_bscanAbdomen,0,false,true,false);
        // B超*其他
        initCheckBoxSimple("CV9600.02", ll_bscanOthers,0,false,true,false);
         // 宫颈涂片*FuEditText
        initCheckBoxSimple("CV9600.02", ll_cps,0,false,true,false);
//        // 平和质
//        initCheckBoxSimple("GENTLEPHYSIQUE", ll_gentleQuality,0,false,false,false);
//        // 气虚质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_qiDeficiency,0,false,false,false);
//        // 阳虚质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_yangDeficiency,0,false,false,false);
//        // 阴虚质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_yinDeficiency,0,false,false,false);
//        // 痰湿质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_phlegmWet,0,false,false,false);
//        // 湿热质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_dampHeat,0,false,false,false);
//        // 血瘀质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_bloodStasis,0,false,false,false);
//        // 气郁质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_qiDepression,0,false,false,false);
//        // 特秉质
//        initCheckBoxSimple("DEFICIENCYPHYSIQUE", ll_specialDiathsis,0,false,false,false);

    }
    public boolean saveData(HealthExam healthExam){

        healthExam.setHgb(et_hgb.getInt());              //血红蛋白
        healthExam.setWbc(et_wbc.getDouble());                //白细胞
        healthExam.setPlt(et_plt.getInt());                //血小板
        healthExam.setCbcOthers(et_cbcOthers.getString());          //其他

        healthExam.setProQualResultCode(et_proQuanTestValue.getString());   //尿蛋白
        healthExam.setGluQualResultCode(et_gluQuanTestValue.getString());   //尿糖
        healthExam.setKetQualResultCode(et_ketQualResultValue.getString()); //尿酮体
        healthExam.setUobTestResultCode(et_uobTestResultValue.getString()); //尿潜血
        healthExam.setUrineOthers(et_urineOthers.getString());        //尿常规--其他


        healthExam.setFbgMmol(et_fbgMmol.getDouble());            //空腹血糖
        healthExam.setFbgMg(et_fbgMg.getDouble());
        healthExam.setPbgMmol(et_pbgMmol.getDouble());            //餐后血糖
        healthExam.setPbgMg(et_pbgMg.getDouble());
        healthExam.setEcgAbnormCode(getCheckBoxSimpleCode(ll_ecgAbnorm));      //心电图
        healthExam.setEcgAbnormDesc(getString(ll_ecgAbnorm));
        healthExam.setUrineMalb(et_urineMalb.getDouble());
        healthExam.setFobCode(getCheckBoxSimpleCode(ll_fob));            //大便潜血
        healthExam.setGhb(et_ghb.getDouble());                //糖化血红蛋白
        healthExam.setHbsagTestResultCode(getCheckBoxSimpleCode(ll_hbsagTestResult));//乙型肝炎表面抗原
        healthExam.setSgpt(et_sgpt.getInt());               //血清谷丙转氨酶
        healthExam.setAst(et_ast.getInt());                //血清谷草转氨酶
        healthExam.setAlb(et_alb.getInt());                //白蛋白
        healthExam.setTbi(et_tbi.getDouble());                //总胆红素
        healthExam.setDbil(et_dbil.getDouble());               //结合胆红素
        healthExam.setScr(et_scr.getDouble());                //血清肌酐
        healthExam.setBun(et_bun.getDouble());                //血尿素氮
        healthExam.setBloodK(et_bloodK.getDouble());             //血钾浓度
        healthExam.setBloodNa(et_bloodNa.getInt());            //血钠浓度
        healthExam.setTcho(et_tcho.getDouble());               //总胆固醇
        healthExam.setTg(et_tg.getDouble());                 //甘油三酯
        healthExam.setLdlc(et_ldlc.getDouble());               //血清低密度脂蛋白胆固醇
        healthExam.setHdlc(et_hdlc.getDouble());               //血清高密度脂蛋白胆固醇
        healthExam.setXrayChestCode(getCheckBoxSimpleCode(ll_xrayChest));      //胸部X线片
        healthExam.setXrayChestAbnormDesc(getString(ll_xrayChest));
        healthExam.setBscanAbdomenCode(getCheckBoxSimpleCode(ll_bscanAbdomen));   //腹部B超
        healthExam.setBscanAbdomenAbnormDesc(getString(ll_bscanAbdomen));
        healthExam.setBscanOthersCode(getCheckBoxSimpleCode(ll_bscanOthers));    //B超--其他
        healthExam.setBscanOthersAbnormDesc(getString(ll_bscanOthers));
        healthExam.setCpsCode(getCheckBoxSimpleCode(ll_cps));            //宫颈涂片
        healthExam.setCpsAbnormDesc(getString(ll_cps));
        healthExam.setOtherAssistExam(et_otherAssistExam.getString());    //辅助检查--其他
//        healthExam.setGentleQualityCode(getCheckBoxSimpleCode(ll_gentleQuality));  //平和质
//        healthExam.setQiDeficiencyCode(getCheckBoxSimpleCode(ll_qiDeficiency));   //气虚质
//        healthExam.setYangDeficiencyCode(getCheckBoxSimpleCode(ll_yangDeficiency)); //阳虚质
//        healthExam.setYinDeficiencyCode(getCheckBoxSimpleCode(ll_yinDeficiency));  //阴虚质
//        healthExam.setPhlegmWetCode(getCheckBoxSimpleCode(ll_phlegmWet));      //痰湿质
//        healthExam.setDampHeatCode(getCheckBoxSimpleCode(ll_dampHeat));       //湿热质
//        healthExam.setBloodStasisCode(getCheckBoxSimpleCode(ll_bloodStasis));    //血瘀质
//        healthExam.setQiDepressionCode(getCheckBoxSimpleCode(ll_qiDepression));   //气郁质
//        healthExam.setSpecialDiathsisCode(getCheckBoxSimpleCode(ll_specialDiathsis));//特秉质
        return true;
    }
    public void setData(HealthExam healthExam){
        et_hgb.setText(healthExam.getHgb());                //血红蛋白
        et_wbc.setText(healthExam.getWbc());                //白细胞
        et_plt.setText(healthExam.getPlt());                //血小板
        et_cbcOthers.setText(healthExam.getCbcOthers());          //其他
        et_proQuanTestValue.setText(healthExam.getProQuanTestValue());   //尿蛋白
        et_gluQuanTestValue.setText(healthExam.getGluQuanTestValue());   //尿糖
        et_ketQualResultValue.setText(healthExam.getKetQualResultValue()); //尿酮体
        et_uobTestResultValue.setText(healthExam.getUobTestResultValue()); //尿潜血
        et_urineOthers.setText(healthExam.getUrineOthers());        //尿常规--其他
        et_fbgMmol.setText(healthExam.getFbgMmol());            //空腹血糖
        et_fbgMg.setText(healthExam.getFbgMg());
        et_pbgMmol.setText(healthExam.getPbgMmol());            //餐后血糖
        et_pbgMg.setText(healthExam.getPbgMg());
        setCheckBoxSelect(healthExam.getEcgAbnormCode(),ll_ecgAbnorm);      //心电图
        setText(healthExam.getEcgAbnormDesc(),ll_ecgAbnorm);
        et_urineMalb.setText(healthExam.getUrineMalb());
        setCheckBoxSelect(healthExam.getFobCode(),ll_fob);            //大便潜血
        et_ghb.setText(healthExam.getGhb());                //糖化血红蛋白
        setCheckBoxSelect(healthExam.getHbsagTestResultCode(),ll_hbsagTestResult);//乙型肝炎表面抗原
        et_sgpt.setText(healthExam.getSgpt());               //血清谷丙转氨酶
        et_ast.setText(healthExam.getAst());                //血清谷草转氨酶
        et_alb.setText(healthExam.getAlb());                //白蛋白
        et_tbi.setText(healthExam.getTbi());                //总胆红素
        et_dbil.setText(healthExam.getDbil());               //结合胆红素
        et_scr.setText(healthExam.getScr());                //血清肌酐
        et_bun.setText(healthExam.getBun());                //血尿素氮
        et_bloodK.setText(healthExam.getBloodK());             //血钾浓度
        et_bloodNa.setText(healthExam.getBloodNa());            //血钠浓度
        et_tcho.setText(healthExam.getTcho());               //总胆固醇
        et_tg.setText(healthExam.getTg());                 //甘油三酯
        et_ldlc.setText(healthExam.getLdlc());               //血清低密度脂蛋白胆固醇
        et_hdlc.setText(healthExam.getHdlc());               //血清高密度脂蛋白胆固醇
        setCheckBoxSelect(healthExam.getXrayChestCode(),ll_xrayChest);      //胸部X线片
        setText(healthExam.getXrayChestAbnormDesc(),ll_xrayChest);
        setCheckBoxSelect(healthExam.getBscanAbdomenCode(),ll_bscanAbdomen);   //腹部B超
        setText(healthExam.getBscanAbdomenAbnormDesc(),ll_bscanAbdomen);
        setCheckBoxSelect(healthExam.getBscanOthersCode(),ll_bscanOthers);    //B超--其他
        setText(healthExam.getBscanOthersAbnormDesc(),ll_bscanOthers);
        setCheckBoxSelect(healthExam.getCpsCode(),ll_cps);            //宫颈涂片
        setText(healthExam.getCpsAbnormDesc(),ll_cps);
        et_otherAssistExam.setText(healthExam.getOtherAssistExam());    //辅助检查--其他
//        setCheckBoxSelect(healthExam.getGentleQualityCode(),ll_gentleQuality);  //平和质
//        setCheckBoxSelect(healthExam.getQiDeficiencyCode(),ll_qiDeficiency);   //气虚质
//        setCheckBoxSelect(healthExam.getYangDeficiencyCode(),ll_yangDeficiency); //阳虚质
//        setCheckBoxSelect(healthExam.getYinDeficiencyCode(),ll_yinDeficiency);  //阴虚质
//        setCheckBoxSelect(healthExam.getPhlegmWetCode(),ll_phlegmWet);      //痰湿质
//        setCheckBoxSelect(healthExam.getDampHeatCode(),ll_dampHeat);       //湿热质
//        setCheckBoxSelect(healthExam.getBloodStasisCode(),ll_bloodStasis);    //血瘀质
//        setCheckBoxSelect(healthExam.getQiDepressionCode(),ll_qiDepression);   //气郁质
//        setCheckBoxSelect(healthExam.getSpecialDiathsisCode(),ll_specialDiathsis);//特秉质
    }
    private void findView(){
        et_hgb= (FuEditText)mFuView.findViewById(R.id.et_hgb);                //血红蛋白
        et_wbc= (FuEditText)mFuView.findViewById(R.id.et_wbc);                //白细胞
        et_plt= (FuEditText)mFuView.findViewById(R.id.et_plt);                //血小板
        et_cbcOthers= (FuEditText)mFuView.findViewById(R.id.et_cbcOthers);          //其他
        et_proQuanTestValue= (FuEditText)mFuView.findViewById(R.id.et_proQuanTestValue);   //尿蛋白
        et_gluQuanTestValue= (FuEditText)mFuView.findViewById(R.id.et_gluQuanTestValue);   //尿糖
        et_ketQualResultValue= (FuEditText)mFuView.findViewById(R.id.et_ketQualResultValue); //尿酮体
        et_uobTestResultValue= (FuEditText)mFuView.findViewById(R.id.et_uobTestResultValue); //尿潜血
        et_urineOthers= (FuEditText)mFuView.findViewById(R.id.et_urineOthers);        //尿常规--其他
        et_fbgMmol= (FuEditText)mFuView.findViewById(R.id.et_fbgMmol);            //空腹血糖
        et_fbgMg= (FuEditText)mFuView.findViewById(R.id.et_fbgMg);
        et_pbgMmol= (FuEditText)mFuView.findViewById(R.id.et_pbgMmol);            //餐后血糖
        et_pbgMg= (FuEditText)mFuView.findViewById(R.id.et_pbgMg);
        ll_ecgAbnorm= (LinearLayout) mFuView.findViewById(R.id.ll_ecgAbnorm);      //心电图
        et_urineMalb = (FuEditText)mFuView.findViewById(R.id.et_urineMalb);     //尿微量白蛋白
        ll_fob= (LinearLayout) mFuView.findViewById(R.id.ll_fob);            //大便潜血
        et_ghb= (FuEditText)mFuView.findViewById(R.id.et_ghb);                //糖化血红蛋白
        ll_hbsagTestResult= (LinearLayout) mFuView.findViewById(R.id.ll_hbsagTestResult);//乙型肝炎表面抗原
        et_sgpt= (FuEditText)mFuView.findViewById(R.id.et_sgpt);               //血清谷丙转氨酶
        et_ast= (FuEditText)mFuView.findViewById(R.id.et_ast);                //血清谷草转氨酶
        et_alb= (FuEditText)mFuView.findViewById(R.id.et_alb);                //白蛋白
        et_tbi= (FuEditText)mFuView.findViewById(R.id.et_tbi);                //总胆红素
        et_dbil= (FuEditText)mFuView.findViewById(R.id.et_dbil);               //结合胆红素
        et_scr= (FuEditText)mFuView.findViewById(R.id.et_scr);                //血清肌酐
        et_bun= (FuEditText)mFuView.findViewById(R.id.et_bun);                //血尿素氮
        et_bloodK= (FuEditText)mFuView.findViewById(R.id.et_bloodK);             //血钾浓度
        et_bloodNa= (FuEditText)mFuView.findViewById(R.id.et_bloodNa);            //血钠浓度
        et_tcho= (FuEditText)mFuView.findViewById(R.id.et_tcho);               //总胆固醇
        et_tg= (FuEditText)mFuView.findViewById(R.id.et_tg);                 //甘油三酯
        et_ldlc= (FuEditText)mFuView.findViewById(R.id.et_ldlc);               //血清低密度脂蛋白胆固醇
        et_hdlc= (FuEditText)mFuView.findViewById(R.id.et_hdlc);               //血清高密度脂蛋白胆固醇
        ll_xrayChest= (LinearLayout) mFuView.findViewById(R.id.ll_xrayChest);      //胸部X线片
        ll_bscanAbdomen= (LinearLayout) mFuView.findViewById(R.id.ll_bscanAbdomen);   //腹部B超
        ll_bscanOthers= (LinearLayout) mFuView.findViewById(R.id.ll_bscanOthers);    //B超--其他
        ll_cps = (LinearLayout)mFuView.findViewById(R.id.ll_cps);   //宫颈涂片 其他
        et_otherAssistExam= (FuEditText)mFuView.findViewById(R.id.et_otherAssistExam);    //辅助检查--其他
//        ll_gentleQuality= (LinearLayout) mFuView.findViewById(R.id.ll_gentleQuality);  //平和质
//        ll_qiDeficiency= (LinearLayout) mFuView.findViewById(R.id.ll_qiDeficiency);   //气虚质
//        ll_yangDeficiency= (LinearLayout) mFuView.findViewById(R.id.ll_yangDeficiency); //阳虚质
//        ll_yinDeficiency= (LinearLayout) mFuView.findViewById(R.id.ll_yinDeficiency);  //阴虚质
//        ll_phlegmWet= (LinearLayout) mFuView.findViewById(R.id.ll_phlegmWet);      //痰湿质
//        ll_dampHeat= (LinearLayout) mFuView.findViewById(R.id.ll_dampHeat);       //湿热质
//        ll_bloodStasis= (LinearLayout) mFuView.findViewById(R.id.ll_bloodStasis);    //血瘀质
//        ll_qiDepression= (LinearLayout) mFuView.findViewById(R.id.ll_qiDepression);   //气郁质
//        ll_specialDiathsis= (LinearLayout) mFuView.findViewById(R.id.ll_specialDiathsis);//特秉质
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
   
}
