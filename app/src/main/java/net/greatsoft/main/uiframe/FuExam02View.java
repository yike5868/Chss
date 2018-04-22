package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuExam02View extends FuUiFrameModel implements View.OnClickListener {

    LinearLayout ll_lipExamResult;              //口唇
    FuCheckBox cb_dentitionType;                  //齿列类别
    FuCheckBox cb_LosetTeeth;                     //缺齿
    FuCheckBox cb_allLoseTeeth;                   //全口
    FuEditText et_loseUlTeethNum;                 //左上
    FuEditText et_loseBlTeethNum;                 //左下
    FuEditText et_loseUrTeethNum;                 //右上
    FuEditText et_loseBrTeethNum;                 //右下
    FuCheckBox cb_isDecayedTooth;                 //龋齿
    FuEditText et_decayedUlToothNum;              //左上
    FuEditText et_decayedBlToothNum;              //左下
    FuEditText et_decayedUrToothNum;              //右上
    FuEditText et_decayedBrToothNum;              //右下
    FuCheckBox cb_isFalseTeeth;                   //义齿
    FuCheckBox cb_allFalseTeeth;                  //全口
    FuEditText et_falseUlTeethNum;                //左上
    FuEditText et_falseBlTeethNum;                //左下
    FuEditText et_falseUrTeethNum;                //右上
    FuEditText et_falseBrTeethNum;                //右下
    LinearLayout ll_pharynxExamResult;          //咽部
    FuEditText et_leftOriginalEyesight;           //左眼
    FuEditText et_rightOriginalEyesight;          //右眼
    FuEditText et_leftCorrectEyesight;            //矫正 左眼
    FuEditText et_rightCorrectEyesight;           //矫正 右眼
    LinearLayout ll_hearingCode;                //听力
    LinearLayout ll_movementFunctionCode;       //运动功能
    LinearLayout ll_eyegroundCode;              //眼底
    LinearLayout ll_skin;                       //皮肤
    LinearLayout ll_scleral;                    //巩膜
    LinearLayout ll_lymph;                      //淋巴结
    LinearLayout ll_barrelChest;                //桶状胸
    LinearLayout ll_lungSound;                  //呼吸音
    LinearLayout ll_lungRale;                   //罗音
    FuEditText et_heartRate;                      //心率
    LinearLayout ll_heartRhythmType;            //心律
    LinearLayout ll_heartMurmur;                //杂音
    LinearLayout ll_abdominalTend;              //触痛 压痛
    LinearLayout ll_abdominalMass;              //包块
    LinearLayout ll_hepatauxe;                  //肝大
    LinearLayout ll_splenomegaly;               //脾大
    LinearLayout ll_abdominalDullness;          //移动性浊音
    LinearLayout ll_eole;                       //下肢水肿
    LinearLayout ll_pofda;                      //足背动脉搏动
    LinearLayout ll_dre;                        //肛门指诊
    LinearLayout ll_breast;                     //乳腺
    LinearLayout ll_vulva;                      //外阴
    LinearLayout ll_vagina;                     //阴道
    LinearLayout ll_cervix;                     //宫颈
    LinearLayout ll_corpusuteri;                //宫体
    LinearLayout ll_adnexa;                     //附件
    FuEditText et_otherHealthExamResult;                //查体--其他

    LinearLayout ll_women;//妇女相关

    public FuExam02View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_exam02_jn_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        findView();
        //口唇
        initCheckBoxSimple("LIP", ll_lipExamResult, 0, false, false, false);
        //咽部
        initCheckBoxSimple("PHARYNX", ll_pharynxExamResult, 0, false, false, false);
        //听力
        initCheckBoxSimple("AUDITION", ll_hearingCode, 0, false, false, false);
        //运动功能
        initCheckBoxSimple("SPORTFUNCTION", ll_movementFunctionCode, 0, false, false, false);
        //眼底
        initCheckBoxSimple("CV9600.02", ll_eyegroundCode, 0, false, true, false);
        //皮肤
        initCheckBoxSimple("TV_1", ll_skin, 5, false, true, false);
        //巩膜
        initCheckBoxSimple("SCLERA", ll_scleral, 0, false, true, false);
        //淋巴结
        initCheckBoxSimple("TV_2", ll_lymph, 0, false, true, false);
        //桶状胸
        initCheckBoxSimple("YES_OR_NOT", ll_barrelChest, 0, false, false, false);
        //呼吸音
        initCheckBoxSimple("CV9600.03", ll_lungSound, 0, false, true, false);
        //罗音
        initCheckBoxSimple("RALE", ll_lungRale, 0, false, true, false);
        //心律
        initCheckBoxSimple("HEARTRATE", ll_heartRhythmType, 0, false, false, false);
        //杂音
        initCheckBoxSimple("YES_NO_CODE", ll_heartMurmur, 0, false, true, false);
        //触痛 压痛
        initCheckBoxSimple("YES_NO_CODE", ll_abdominalTend, 0, false, true, false);
        // 包块
        initCheckBoxSimple("YES_NO_CODE", ll_abdominalMass, 0, false, true, false);
        // 肝大
        initCheckBoxSimple("YES_NO_CODE", ll_hepatauxe, 0, false, true, false);
        // 脾大
        initCheckBoxSimple("YES_NO_CODE", ll_splenomegaly, 0, false, true, false);
        // 移动性浊音
        initCheckBoxSimple("YES_NO_CODE", ll_abdominalDullness, 0, false, true, false);
        // 下肢水肿
        initCheckBoxSimple("EDEMALOWEREXTREMITY", ll_eole, 0, false, false, false);
        // 足背动脉搏动
        initCheckBoxSimple("FOOTARTERIOPALMUS", ll_pofda, 3, false, false, false);
        // 肛门指诊*
        initCheckBoxSimple("ANUSTACTUS", ll_dre, 4, false, true, false);
        // 乳腺*
        initCheckBoxMany("breast", ll_breast, 3, false, true);
        // 外阴
        initCheckBoxSimple("EXCEPTION_CODE", ll_vulva, 0, false, true, false);
        // 阴道
        initCheckBoxSimple("EXCEPTION_CODE", ll_vagina, 0, false, true, false);
        // 宫颈
        initCheckBoxSimple("EXCEPTION_CODE", ll_cervix, 0, false, true, false);
        // 宫体
        initCheckBoxSimple("EXCEPTION_CODE", ll_corpusuteri, 0, false, true, false);
        // 附件
        initCheckBoxSimple("EXCEPTION_CODE", ll_adnexa, 0, false, true, false);

    }

    public boolean saveData(HealthExam healthExam) {
        healthExam.setLipExamResultCode(getCheckBoxSimpleCode(ll_lipExamResult));              //口唇
        healthExam.setDentitionTypeCode(cb_dentitionType.isChecked() ? "1" : "0");                  //齿列类别
        healthExam.setIsLosetTeeth(cb_LosetTeeth.isChecked() ? 1 : 0);                     //缺齿
        healthExam.setAllLoseTeeth(cb_allLoseTeeth.isChecked() ? 1 : 0);                   //全口
        healthExam.setLoseUlTeethNum(et_loseUlTeethNum.getInt());                 //左上
        healthExam.setLoseBlTeethNum(et_loseUrTeethNum.getInt());                 //右上
        healthExam.setLoseUrTeethNum(et_loseBlTeethNum.getInt());                 //左下
        healthExam.setLoseBrTeethNum(et_loseBrTeethNum.getInt());                 //右下
        healthExam.setIsDecayedTooth(cb_isDecayedTooth.isChecked() ? 1 : 0);                 //龋齿
        healthExam.setDecayedUlToothNum(et_decayedUlToothNum.getInt());              //左上
        healthExam.setDecayedBlToothNum(et_decayedUrToothNum.getInt());              //右上
        healthExam.setDecayedUrToothNum(et_decayedBlToothNum.getInt());              //左下
        healthExam.setDecayedBrToothNum(et_decayedBrToothNum.getInt());              //右下
        healthExam.setIsFalseTeeth(cb_isFalseTeeth.isChecked() ? 1 : 0);                   //义齿
        healthExam.setAllFalseTeeth(cb_allFalseTeeth.isChecked() ? 1 : 0);                  //全口
        healthExam.setFalseUlTeethNum(et_falseUlTeethNum.getInt());                //左上
        healthExam.setFalseBlTeethNum(et_falseBlTeethNum.getInt());                //左下
        healthExam.setFalseUrTeethNum(et_falseUrTeethNum.getInt());                //右上
        healthExam.setFalseBrTeethNum(et_falseBrTeethNum.getInt());                //右下
        healthExam.setPharynxExamResultCode(getCheckBoxSimpleCode(ll_pharynxExamResult));          //咽部
        healthExam.setLeftOriginalEyesight(et_leftOriginalEyesight.getDouble());           //左眼
        healthExam.setRightOriginalEyesight(et_rightOriginalEyesight.getDouble());          //右眼
        healthExam.setLeftCorrectEyesight(et_leftCorrectEyesight.getDouble());            //矫正 左眼
        healthExam.setRightCorrectEyesight(et_rightCorrectEyesight.getDouble());           //矫正 右眼
        healthExam.setHearingCode(getCheckBoxSimpleCode(ll_hearingCode));                //听力
        healthExam.setMovementFunctionCode(getCheckBoxSimpleCode(ll_movementFunctionCode));       //运动功能
        healthExam.setEyegroundCode(getCheckBoxSimpleCode(ll_eyegroundCode));              //眼底
        healthExam.setEyegroundAbnormDesc(getString(ll_eyegroundCode));
        healthExam.setSkinCode(getCheckBoxSimpleCode(ll_skin));                       //皮肤
        healthExam.setSkinOthersDesc(getString(ll_skin));
        healthExam.setScleralCode(getCheckBoxSimpleCode(ll_scleral));                    //巩膜
        healthExam.setScleralOthersDesc(getString(ll_scleral));
        healthExam.setLymphCode(getCheckBoxSimpleCode(ll_lymph));                      //淋巴结
        healthExam.setLymphOthersDesc(getString(ll_lymph));
        healthExam.setBarrelChestCode(getCheckBoxSimpleCode(ll_barrelChest));                //桶状胸
        healthExam.setLungSoundCode(getCheckBoxSimpleCode(ll_lungSound));                  //呼吸音
        healthExam.setLungSoundAbnormDesc(getString(ll_lungSound));
        healthExam.setLungRaleCode(getCheckBoxSimpleCode(ll_lungRale));                   //罗音
        healthExam.setLungRaleOthersDesc(getString(ll_lungRale));
        healthExam.setHeartRate(et_heartRate.getInt());                      //心率
        healthExam.setHeartRhythmTypeCode(getCheckBoxSimpleCode(ll_heartRhythmType));            //心律
        healthExam.setHeartMurmurCode(getCheckBoxSimpleCode(ll_heartMurmur));                //杂音
        healthExam.setHeartMurmurDesc(getString(ll_heartMurmur));
        healthExam.setAbdominalTendCode(getCheckBoxSimpleCode(ll_abdominalTend));              //触痛 压痛
        healthExam.setHasAbdominalTendDesc(getString(ll_abdominalTend));
        healthExam.setAbdominalMassCode(getCheckBoxSimpleCode(ll_abdominalMass));              //包块
        healthExam.setHasAbdominalMassDesc(getString(ll_abdominalMass));
        healthExam.setHepatauxeCode(getCheckBoxSimpleCode(ll_hepatauxe));                  //肝大
        healthExam.setHasHepatauxeDesc(getString(ll_hepatauxe));
        healthExam.setSplenomegalyCode(getCheckBoxSimpleCode(ll_splenomegaly));               //脾大
        healthExam.setHasSplenomegalyDesc(getString(ll_splenomegaly));
        healthExam.setAbdominalDullnessCode(getCheckBoxSimpleCode(ll_abdominalDullness));          //移动性浊音
        healthExam.setHasAbdominalDullnessDesc(getString(ll_abdominalDullness));

        healthExam.setEoleCode(getCheckBoxSimpleCode(ll_eole));                       //下肢水肿

        healthExam.setPofdaCode(getCheckBoxSimpleCode(ll_pofda));                      //足背动脉搏动
        healthExam.setDreCode(getCheckBoxSimpleCode(ll_dre));                        //肛门指诊
        healthExam.setDreOthersDesc(getString(ll_dre));
        saveCheckBoxMany(healthExam.getHealthExamId(), healthExam.getRecordChoice(), ll_breast);//乳腺
        healthExam.setVulvaCode(getCheckBoxSimpleCode(ll_vulva));                      //外阴
        healthExam.setVulvaAbnormDesc(getString(ll_vulva));
        healthExam.setVaginaCode(getCheckBoxSimpleCode(ll_vagina));                     //阴道
        healthExam.setVaginaAbnormDesc(getString(ll_vagina));
        healthExam.setCervixCode(getCheckBoxSimpleCode(ll_cervix));                     //宫颈
        healthExam.setCervixAbnormDesc(getString(ll_cervix));
        healthExam.setCorpusuteriCode(getCheckBoxSimpleCode(ll_corpusuteri));                //宫体
        healthExam.setCorpusuteriAbnormDesc(getString(ll_corpusuteri));
        healthExam.setAdnexaCode(getCheckBoxSimpleCode(ll_adnexa));                     //附件
        healthExam.setAdnexaAbnormDesc(getString(ll_adnexa));
        healthExam.setOtherHealthExamResult(et_otherHealthExamResult.getString());                //查体--其他
        return true;
    }

    public boolean setData(HealthExam healthExam, PersonInfo personInfo) {

        if (personInfo.getSexCode() != null && "2".equals(personInfo.getSexCode())) {
            ll_women.setVisibility(View.VISIBLE);
        } else
            ll_women.setVisibility(View.GONE);

        setCheckBoxSelect(healthExam.getLipExamResultCode(), ll_lipExamResult);              //口唇
        cb_dentitionType.setChecked("1", healthExam.getDentitionTypeCode());                  //齿列类别
        cb_LosetTeeth.setChecked(1, healthExam.getIsLosetTeeth());                     //缺齿
        cb_allLoseTeeth.setChecked(1, healthExam.getAllLoseTeeth());                   //全口
        et_loseUlTeethNum.setText(healthExam.getLoseUlTeethNum());                 //左上
        et_loseBlTeethNum.setText(healthExam.getLoseBlTeethNum());                 //左下
        et_loseUrTeethNum.setText(healthExam.getLoseUrTeethNum());                 //右上
        et_loseBrTeethNum.setText(healthExam.getLoseBrTeethNum());                 //右下
        cb_isDecayedTooth.setChecked(1, healthExam.getIsDecayedTooth());                 //龋齿
        et_decayedUlToothNum.setText(healthExam.getDecayedUlToothNum());              //左上
        et_decayedBlToothNum.setText(healthExam.getDecayedBlToothNum());              //左下
        et_decayedUrToothNum.setText(healthExam.getDecayedUrToothNum());              //右上
        et_decayedBrToothNum.setText(healthExam.getDecayedBrToothNum());              //右下
        cb_isFalseTeeth.setChecked(1, healthExam.getIsFalseTeeth());                   //义齿
        cb_allFalseTeeth.setChecked(1, healthExam.getAllFalseTeeth());                  //全口
        et_falseUlTeethNum.setText(healthExam.getFalseUlTeethNum());                //左上
        et_falseBlTeethNum.setText(healthExam.getFalseBlTeethNum());                //左下
        et_falseUrTeethNum.setText(healthExam.getFalseUrTeethNum());                //右上
        et_falseBrTeethNum.setText(healthExam.getFalseBrTeethNum());                //右下
        setCheckBoxSelect(healthExam.getPharynxExamResultCode(), ll_pharynxExamResult);          //咽部
        et_leftOriginalEyesight.setText(healthExam.getLeftOriginalEyesight());           //左眼
        et_rightOriginalEyesight.setText(healthExam.getRightOriginalEyesight());          //右眼
        et_leftCorrectEyesight.setText(healthExam.getLeftCorrectEyesight());            //矫正 左眼
        et_rightCorrectEyesight.setText(healthExam.getRightCorrectEyesight());           //矫正 右眼
        setCheckBoxSelect(healthExam.getHearingCode(), ll_hearingCode);                //听力
        setCheckBoxSelect(healthExam.getMovementFunctionCode(), ll_movementFunctionCode);       //运动功能
        setCheckBoxSelect(healthExam.getEyegroundCode(), ll_eyegroundCode);              //眼底
        setText(healthExam.getEyegroundAbnormDesc(), ll_eyegroundCode);
        setCheckBoxSelect(healthExam.getSkinCode(), ll_skin);                       //皮肤
        setText(healthExam.getSkinOthersDesc(), ll_skin);
        setCheckBoxSelect(healthExam.getScleralCode(), ll_scleral);                    //巩膜
        setText(healthExam.getScleralOthersDesc(), ll_scleral);
        setCheckBoxSelect(healthExam.getLymphCode(), ll_lymph);                      //淋巴结
        setText(healthExam.getLymphOthersDesc(), ll_lymph);
        setCheckBoxSelect(healthExam.getBarrelChestCode(), ll_barrelChest);                //桶状胸
        setText(healthExam.getBarrelChestCode(), ll_barrelChest);
        setCheckBoxSelect(healthExam.getLungSoundCode(), ll_lungSound);                  //呼吸音
        setText(healthExam.getLungSoundAbnormDesc(), ll_lungSound);
        setCheckBoxSelect(healthExam.getLungRaleCode(), ll_lungRale);                   //罗音
        setText(healthExam.getLungRaleOthersDesc(), ll_lungRale);
        et_heartRate.setText(healthExam.getHeartRate());                      //心率
        setCheckBoxSelect(healthExam.getHeartRhythmTypeCode(), ll_heartRhythmType);            //心律
        setCheckBoxSelect(healthExam.getHeartMurmurCode(), ll_heartMurmur);                //杂音
        setText(healthExam.getHeartMurmurDesc(), ll_heartMurmur);
        setCheckBoxSelect(healthExam.getAbdominalTendCode(), ll_abdominalTend);              //触痛 压痛
        setText(healthExam.getHasAbdominalTendDesc(), ll_abdominalTend);
        setCheckBoxSelect(healthExam.getAbdominalMassCode(), ll_abdominalMass);              //包块
        setText(healthExam.getHasAbdominalMassDesc(), ll_abdominalMass);
        setCheckBoxSelect(healthExam.getHepatauxeCode(), ll_hepatauxe);                  //肝大
        setText(healthExam.getHasHepatauxeDesc(), ll_hepatauxe);
        setCheckBoxSelect(healthExam.getSplenomegalyCode(), ll_splenomegaly);               //脾大
        setText(healthExam.getHasSplenomegalyDesc(), ll_splenomegaly);
        setCheckBoxSelect(healthExam.getAbdominalDullnessCode(), ll_abdominalDullness);          //移动性浊音
        setText(healthExam.getHasAbdominalDullnessDesc(), ll_abdominalDullness);
        setCheckBoxSelect(healthExam.getEoleCode(), ll_eole);                       //下肢水肿
        setCheckBoxSelect(healthExam.getPofdaCode(), ll_pofda);                      //足背动脉搏动
        setCheckBoxSelect(healthExam.getDreCode(), ll_dre);                        //肛门指诊
        setText(healthExam.getDreOthersDesc(), ll_dre);

//        setCheckBoxSelect("breast",healthExam.getHealthExamId(),ll_breast);                     //乳腺
        setCheckBoxSelect("breast", healthExam.getRecordChoice(), ll_breast);                     //乳腺

        setCheckBoxSelect(healthExam.getVulvaCode(), ll_vulva);                      //外阴
        setText(healthExam.getVulvaAbnormDesc(), ll_vulva);
        setCheckBoxSelect(healthExam.getVaginaCode(), ll_vagina);                     //阴道
        setText(healthExam.getVaginaAbnormDesc(), ll_vagina);
        setCheckBoxSelect(healthExam.getCervixCode(), ll_cervix);                     //宫颈
        setText(healthExam.getCervixAbnormDesc(), ll_cervix);
        setCheckBoxSelect(healthExam.getCorpusuteriCode(), ll_corpusuteri);                //宫体
        setText(healthExam.getCorpusuteriAbnormDesc(), ll_corpusuteri);
        setCheckBoxSelect(healthExam.getAdnexaCode(), ll_adnexa);                     //附件
        setText(healthExam.getAdnexaAbnormDesc(), ll_adnexa);
        et_otherHealthExamResult.setText(healthExam.getOtherHealthExamResult());                //查体--其他
        return true;
    }

    private void findView() {
        ll_lipExamResult = (LinearLayout) mFuView.findViewById(R.id.ll_lipExamResult);              //口唇
        cb_dentitionType = (FuCheckBox) mFuView.findViewById(R.id.cb_dentitionType);                  //齿列类别
        cb_LosetTeeth = (FuCheckBox) mFuView.findViewById(R.id.cb_LosetTeeth);                     //缺齿
        cb_allLoseTeeth = (FuCheckBox) mFuView.findViewById(R.id.cb_allLoseTeeth);                   //全口
        et_loseUlTeethNum = (FuEditText) mFuView.findViewById(R.id.et_loseUlTeethNum);                 //左上
        et_loseBlTeethNum = (FuEditText) mFuView.findViewById(R.id.et_loseBlTeethNum);                 //左下
        et_loseUrTeethNum = (FuEditText) mFuView.findViewById(R.id.et_loseUrTeethNum);                 //右上
        et_loseBrTeethNum = (FuEditText) mFuView.findViewById(R.id.et_loseBrTeethNum);                 //右下
        cb_isDecayedTooth = (FuCheckBox) mFuView.findViewById(R.id.cb_isDecayedTooth);                 //龋齿
        et_decayedUlToothNum = (FuEditText) mFuView.findViewById(R.id.et_decayedUlToothNum);              //左上
        et_decayedBlToothNum = (FuEditText) mFuView.findViewById(R.id.et_decayedBlToothNum);              //左下
        et_decayedUrToothNum = (FuEditText) mFuView.findViewById(R.id.et_decayedUrToothNum);              //右上
        et_decayedBrToothNum = (FuEditText) mFuView.findViewById(R.id.et_decayedBrToothNum);              //右下
        cb_isFalseTeeth = (FuCheckBox) mFuView.findViewById(R.id.cb_isFalseTeeth);                   //义齿
        cb_allFalseTeeth = (FuCheckBox) mFuView.findViewById(R.id.cb_allFalseTeeth);                  //全口
        et_falseUlTeethNum = (FuEditText) mFuView.findViewById(R.id.et_falseUlTeethNum);                //左上
        et_falseBlTeethNum = (FuEditText) mFuView.findViewById(R.id.et_falseBlTeethNum);                //左下
        et_falseUrTeethNum = (FuEditText) mFuView.findViewById(R.id.et_falseUrTeethNum);                //右上
        et_falseBrTeethNum = (FuEditText) mFuView.findViewById(R.id.et_falseBrTeethNum);                //右下
        ll_pharynxExamResult = (LinearLayout) mFuView.findViewById(R.id.ll_pharynxExamResult);          //咽部
        et_leftOriginalEyesight = (FuEditText) mFuView.findViewById(R.id.et_leftOriginalEyesight);           //左眼
        et_rightOriginalEyesight = (FuEditText) mFuView.findViewById(R.id.et_rightOriginalEyesight);          //右眼
        et_leftCorrectEyesight = (FuEditText) mFuView.findViewById(R.id.et_leftCorrectEyesight);            //矫正 左眼
        et_rightCorrectEyesight = (FuEditText) mFuView.findViewById(R.id.et_rightCorrectEyesight);           //矫正 右眼
        ll_hearingCode = (LinearLayout) mFuView.findViewById(R.id.ll_hearingCode);                //听力
        ll_movementFunctionCode = (LinearLayout) mFuView.findViewById(R.id.ll_movementFunctionCode);       //运动功能
        ll_eyegroundCode = (LinearLayout) mFuView.findViewById(R.id.ll_eyegroundCode);              //眼底
        ll_skin = (LinearLayout) mFuView.findViewById(R.id.ll_skin);                       //皮肤
        ll_scleral = (LinearLayout) mFuView.findViewById(R.id.ll_scleral);                    //巩膜
        ll_lymph = (LinearLayout) mFuView.findViewById(R.id.ll_lymph);                      //淋巴结
        ll_barrelChest = (LinearLayout) mFuView.findViewById(R.id.ll_barrelChest);                //桶状胸
        ll_lungSound = (LinearLayout) mFuView.findViewById(R.id.ll_lungSound);                  //呼吸音
        ll_lungRale = (LinearLayout) mFuView.findViewById(R.id.ll_lungRale);                   //罗音
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate);                      //心率
        ll_heartRhythmType = (LinearLayout) mFuView.findViewById(R.id.ll_heartRhythmType);            //心律
        ll_heartMurmur = (LinearLayout) mFuView.findViewById(R.id.ll_heartMurmur);                //杂音
        ll_abdominalTend = (LinearLayout) mFuView.findViewById(R.id.ll_abdominalTend);              //触痛 压痛
        ll_abdominalMass = (LinearLayout) mFuView.findViewById(R.id.ll_abdominalMass);              //包块
        ll_hepatauxe = (LinearLayout) mFuView.findViewById(R.id.ll_hepatauxe);                  //肝大
        ll_splenomegaly = (LinearLayout) mFuView.findViewById(R.id.ll_splenomegaly);               //脾大
        ll_abdominalDullness = (LinearLayout) mFuView.findViewById(R.id.ll_abdominalDullness);          //移动性浊音
        ll_eole = (LinearLayout) mFuView.findViewById(R.id.ll_eole);                       //下肢水肿
        ll_pofda = (LinearLayout) mFuView.findViewById(R.id.ll_pofda);                      //足背动脉搏动
        ll_dre = (LinearLayout) mFuView.findViewById(R.id.ll_dre);                        //肛门指诊
        ll_breast = (LinearLayout) mFuView.findViewById(R.id.ll_breast);                 //乳腺
        ll_vulva = (LinearLayout) mFuView.findViewById(R.id.ll_vulva);                      //外阴
        ll_vagina = (LinearLayout) mFuView.findViewById(R.id.ll_vagina);                     //阴道
        ll_cervix = (LinearLayout) mFuView.findViewById(R.id.ll_cervix);                     //宫颈
        ll_corpusuteri = (LinearLayout) mFuView.findViewById(R.id.ll_corpusuteri);                //宫体
        ll_adnexa = (LinearLayout) mFuView.findViewById(R.id.ll_adnexa);                     //附件
        et_otherHealthExamResult = (FuEditText) mFuView.findViewById(R.id.et_otherHealthExamResult);  //其他查体              //妇科--其他

        ll_women = (LinearLayout) mFuView.findViewById(R.id.ll_women);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}
