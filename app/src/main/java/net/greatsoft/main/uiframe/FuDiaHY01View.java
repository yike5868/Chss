package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

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
public class FuDiaHY01View extends FuUiFrameModel implements View.OnClickListener {


    CheckBox cb_hyperSymptom;           //高血压无症状
    LinearLayout ll_hyperSymptom;       //高血压症状
    CheckBox cb_diabetesSymptom;        //糖尿病无症状
    LinearLayout ll_diabetesSymptom;    //糖尿病症状

    FuEditText et_dailySmoking;           //日吸烟量           共
    FuEditText et_aimDailySmoking;        //日吸烟量1          共
    FuTextView tv_o_dailySmoking;         //上次日吸烟量        共
    FuTextView tv_o_aimDailySmoking;      //上次日吸烟量1       共
    FuEditText et_dailyDrinking;          //日饮酒量           共
    FuEditText et_aimDailyDrinking;       //日饮酒量1          共
    FuTextView tv_o_dailyDrinking;        //上次日饮酒量        共
    FuTextView tv_o_aimDailyDrinking;     //上次日饮酒量1       共
    FuEditText et_exerciseDurationWeeks;  //运动 周 次         共
    FuEditText et_exerciseDurationMins;   //运动 分钟次         共
    FuEditText et_aimDurationWeeks;       // 运动 周次 1       共
    FuEditText et_aimExerciseMins;        //运动 分钟次 1      共
    FuTextView tv_o_exerciseDurationWeeks;//上次运动周次        共
    FuTextView tv_o_exerciseDurationMins; //上次运动分次        共
    FuTextView tv_o_aimDurationWeeks;     //上次运动周次1       共
    FuTextView tv_o_aimExerciseMins;      //上次运动分次1       共
    LinearLayout ll_saltTakenLevel;     //摄盐量            高
    FuTextView tv_o_saltTakenLevel;       //上次摄盐量         高
    LinearLayout ll_aimSalttakenLevel;  //摄盐量             高
    FuTextView tv_o_aimSalttakenLevel;    //上次摄盐量         高
    FuEditText et_dailyStaple;            //主食             糖
    FuEditText et_aimDailyStaple;         //主食1            糖
    FuTextView tv_o_dailyStaple;          //上次主食          糖
    FuTextView tv_o_aimDailyStaple;       //上次主食1         糖
    LinearLayout ll_psyAdjustResult;    //心理调整          共
    FuTextView tv_o_psyAdjustResult;      //上次心理调整       共
    LinearLayout ll_complianceResult;   //遵医行为          共
    FuTextView tv_o_complianceResult;     //上次遵医行为        共
    Button btn_next;                    //下一步


    public FuDiaHY01View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.diahy_fragment01, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    public void setData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup,
                        HyperFollowup oHyperFollowup, DiabetesFollowup oDiabetesFollowup){
        setCheckBoxSelect("hyperSymptom",hyperFollowup.getHyperFollowupId(),ll_hyperSymptom); //症状
        setCheckBoxSelect("diabetesSymptom",diabetesFollowup.getDiabetesFollowupId(),ll_diabetesSymptom); //症状

        et_dailySmoking.setText(hyperFollowup.getDailySmoking(),diabetesFollowup.getDailySmoking());           //日吸烟量           共
        et_aimDailySmoking.setText(hyperFollowup.getAimDailySmoking(),diabetesFollowup.getAimDailySmoking());        //日吸烟量1          共
        tv_o_dailySmoking.setText(oHyperFollowup.getDailySmoking(),oDiabetesFollowup.getDailySmoking());         //上次日吸烟量        共
        tv_o_aimDailySmoking.setText(oHyperFollowup.getAimDailySmoking(),oDiabetesFollowup.getAimDailySmoking());      //上次日吸烟量1       共
        et_dailyDrinking.setText(hyperFollowup.getDailyDrinking(),diabetesFollowup.getDailyDrinking());          //日饮酒量           共
        et_aimDailyDrinking.setText(hyperFollowup.getAimDailyDrinking(),diabetesFollowup.getAimDailyDrinking());       //日饮酒量1          共
        tv_o_dailyDrinking.setText(oHyperFollowup.getDailyDrinking(),oDiabetesFollowup.getDailyDrinking());        //上次日饮酒量        共
        tv_o_aimDailyDrinking.setText(oHyperFollowup.getAimDailyDrinking(),oDiabetesFollowup.getAimDailyDrinking());     //上次日饮酒量1       共
        et_exerciseDurationWeeks.setText(hyperFollowup.getExerciseDurationWeeks(),diabetesFollowup.getExerciseFreqCode());  //运动 周 次         共
        et_exerciseDurationMins.setText(hyperFollowup.getExerciseDurationMins(),diabetesFollowup.getExerciseDurationMins());   //运动 分钟次         共
        et_aimDurationWeeks.setText(hyperFollowup.getAimDurationWeeks(),diabetesFollowup.getAimExerciseFreqCode());       // 运动 周次 1       共
        et_aimExerciseMins.setText(hyperFollowup.getAimExerciseMins(),diabetesFollowup.getAimExerciseMins());        //运动 分钟次 1      共
        tv_o_exerciseDurationWeeks.setText(oHyperFollowup.getExerciseDurationWeeks(),oDiabetesFollowup.getExerciseFreqCode());//上次运动周次        共
        tv_o_exerciseDurationMins.setText(oHyperFollowup.getExerciseDurationMins(),oDiabetesFollowup.getExerciseDurationMins()); //上次运动分次        共
        tv_o_aimDurationWeeks.setText(oHyperFollowup.getAimDurationWeeks(),oDiabetesFollowup.getAimExerciseFreqCode());     //上次运动周次1       共
        tv_o_aimExerciseMins.setText(oHyperFollowup.getAimExerciseMins(),oDiabetesFollowup.getAimExerciseMins());      //上次运动分次1       共

        setCheckBoxSelect(hyperFollowup.getSaltTakenLevelCode(),ll_saltTakenLevel);     //摄盐量            高
        tv_o_saltTakenLevel.setText(oHyperFollowup.getSaltTakenLevelCode());       //上次摄盐量         高
        setCheckBoxSelect(hyperFollowup.getAimSalttakenLevelCode(),ll_aimSalttakenLevel);  //摄盐量             高
        tv_o_aimSalttakenLevel.setText(oHyperFollowup.getAimSalttakenLevelCode());    //上次摄盐量         高

        et_dailyStaple.setText(diabetesFollowup.getDailyStaple());            //主食             糖
        et_aimDailyStaple.setText(diabetesFollowup.getAimDailyStaple());         //主食1            糖
          tv_o_dailyStaple.setText(oDiabetesFollowup.getDailyStaple());          //上次主食          糖
        tv_o_aimDailyStaple.setText(oDiabetesFollowup.getAimDailyStaple());       //上次主食1         糖
        setCheckBoxTwoSelect(hyperFollowup.getPsyAdjustResultCode(),diabetesFollowup.getPsyAdjustResultCode(),ll_psyAdjustResult);    //心理调整          共
        tv_o_psyAdjustResult.setText(oHyperFollowup.getPsyAdjustResultCode(),oDiabetesFollowup.getPsyAdjustResultCode());      //上次心理调整       共
        setCheckBoxTwoSelect(hyperFollowup.getComplianceResultCode(),diabetesFollowup.getComplianceResultCode(),ll_complianceResult);   //遵医行为          共
        tv_o_complianceResult.setText(oHyperFollowup.getComplianceResultCode(),oDiabetesFollowup.getComplianceResultCode());     //上次遵医行为        共


    }
    public void saveData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup){


        saveCheckBoxMany(hyperFollowup.getHyperFollowupId(),hyperFollowup.getRecordChoice(),ll_hyperSymptom);//症状
        saveCheckBoxMany(diabetesFollowup.getDiabetesFollowupId(),hyperFollowup.getRecordChoice(),ll_diabetesSymptom);

        hyperFollowup.setDailySmoking(et_dailySmoking.getInt());           //日吸烟量           共
        hyperFollowup.setAimDailySmoking(et_aimDailySmoking.getInt());        //日吸烟量1          共
        hyperFollowup.setDailyDrinking(et_dailyDrinking.getInt());          //日饮酒量           共
        hyperFollowup.setAimDailyDrinking(et_aimDailyDrinking.getInt());       //日饮酒量1          共
        hyperFollowup.setExerciseDurationWeeks(et_exerciseDurationWeeks.getInt());  //运动 周 次         共
        hyperFollowup.setExerciseDurationMins(et_exerciseDurationMins.getInt());   //运动 分钟次         共
        hyperFollowup.setAimDurationWeeks(et_aimDurationWeeks.getInt());       // 运动 周次 1       共
        hyperFollowup.setAimExerciseMins(et_aimExerciseMins.getInt());        //运动 分钟次 1      共
        hyperFollowup.setSaltTakenLevelCode(getCheckBoxSimpleCode(ll_saltTakenLevel));     //摄盐量            高
        hyperFollowup.setAimSalttakenLevelCode(getCheckBoxSimpleCode(ll_aimSalttakenLevel));  //摄盐量             高
        hyperFollowup.setPsyAdjustResultCode(getCheckBoxSimpleCode(ll_psyAdjustResult));    //心理调整          共
        hyperFollowup.setComplianceResultCode(getCheckBoxSimpleCode(ll_complianceResult));   //遵医行为          共

        diabetesFollowup.setDailyStaple(et_dailyStaple.getInt());            //主食             糖
        diabetesFollowup.setAimDailyStaple(et_aimDailyStaple.getInt());         //主食1            糖
        diabetesFollowup.setDailySmoking(et_dailySmoking.getInt());           //日吸烟量           共
        diabetesFollowup.setAimDailySmoking(et_aimDailySmoking.getInt());        //日吸烟量1          共
        diabetesFollowup.setDailyDrinking(et_dailyDrinking.getInt());          //日饮酒量           共
        diabetesFollowup.setAimDailyDrinking(et_aimDailyDrinking.getInt());       //日饮酒量1          共
        diabetesFollowup.setExerciseFreqCode(et_exerciseDurationWeeks.getString());  //运动 周 次         共
        diabetesFollowup.setExerciseDurationMins(et_exerciseDurationMins.getInt());   //运动 分钟次         共
        diabetesFollowup.setAimExerciseFreqCode(et_aimDurationWeeks.getString());       // 运动 周次 1       共
        diabetesFollowup.setAimExerciseMins(et_aimExerciseMins.getInt());        //运动 分钟次 1      共
        diabetesFollowup.setPsyAdjustResultCode(getCheckBoxSimpleCode(ll_psyAdjustResult));    //心理调整          共
        diabetesFollowup.setComplianceResultCode(getCheckBoxSimpleCode(ll_complianceResult));   //遵医行为          共

    }


    @Override
    protected void initWidget() {
        findView();
        initCheckBoxMany("hyperSymptom", ll_hyperSymptom, 4, true, true);       //高血压症状
        initCheckBoxMany("diabetesSymptom", ll_diabetesSymptom, 4, true, true); //糖尿病症状

        initCheckBoxSimple("CHOKEDEGREE", ll_saltTakenLevel,false);
        initCheckBoxSimple("CHOKEDEGREE", ll_aimSalttakenLevel,false);
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_psyAdjustResult,false);
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_complianceResult,false);
    }

    public void findView() {
        cb_hyperSymptom= (CheckBox) mFuView.findViewById(R.id.cb_hyperSymptom);                  //高血压无症状
        ll_hyperSymptom= (LinearLayout) mFuView.findViewById(R.id.ll_hyperSymptom);      //高血压症状
        cb_diabetesSymptom= (CheckBox) mFuView.findViewById(R.id.cb_diabetesSymptom);                  //糖尿病无症状
        ll_diabetesSymptom= (LinearLayout) mFuView.findViewById(R.id.ll_diabetesSymptom);      //糖尿病症状
        et_dailySmoking= (FuEditText) mFuView.findViewById(R.id.et_dailySmoking);              //日吸烟量
        et_aimDailySmoking= (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking);             //日吸烟量1
        tv_o_dailySmoking= (FuTextView)mFuView.findViewById(R.id.tv_o_dailySmoking);            //上次日吸烟量
        tv_o_aimDailySmoking= (FuTextView)mFuView.findViewById(R.id.tv_o_aimDailySmoking);           //上次日吸烟量1
        et_dailyDrinking= (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking);              //日饮酒量
        et_aimDailyDrinking= (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking);             //日饮酒量1
        tv_o_dailyDrinking= (FuTextView)mFuView.findViewById(R.id.tv_o_dailyDrinking);            //上次日饮酒量
        tv_o_aimDailyDrinking= (FuTextView)mFuView.findViewById(R.id.tv_o_aimDailyDrinking);           //上次日饮酒量1
        et_exerciseDurationWeeks= (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationWeeks);    //运动 周 次
        et_exerciseDurationMins= (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins);       //运动 分钟次
        et_aimDurationWeeks= (FuEditText) mFuView.findViewById(R.id.et_aimDurationWeeks);       // 运动 周次 1
        et_aimExerciseMins= (FuEditText) mFuView.findViewById(R.id.et_aimExerciseMins);        //运动 分钟次 1
        tv_o_exerciseDurationWeeks= (FuTextView)mFuView.findViewById(R.id.tv_o_exerciseDurationWeeks);  //上次运动周次
        tv_o_exerciseDurationMins= (FuTextView)mFuView.findViewById(R.id.tv_o_exerciseDurationMins);     //上次运动分次
        tv_o_aimDurationWeeks= (FuTextView)mFuView.findViewById(R.id.tv_o_aimDurationWeeks); //上次运动周次1
        tv_o_aimExerciseMins= (FuTextView)mFuView.findViewById(R.id.tv_o_aimExerciseMins);    //上次运动分次1
        ll_aimSalttakenLevel= (LinearLayout) mFuView.findViewById(R.id.ll_aimSalttakenLevel);        //摄盐量
        tv_o_aimSalttakenLevel= (FuTextView)mFuView.findViewById(R.id.tv_o_aimSalttakenLevel);                 //上次摄盐量
        ll_saltTakenLevel= (LinearLayout) mFuView.findViewById(R.id.ll_saltTakenLevel);       //摄盐量
        tv_o_saltTakenLevel= (FuTextView)mFuView.findViewById(R.id.tv_o_saltTakenLevel);                //上次摄盐量
        et_dailyStaple= (FuEditText) mFuView.findViewById(R.id.et_dailyStaple);              //主食
        et_aimDailyStaple= (FuEditText) mFuView.findViewById(R.id.et_aimDailyStaple);             //主食1
        tv_o_dailyStaple= (FuTextView)mFuView.findViewById(R.id.tv_o_dailyStaple);            //上次主食
        tv_o_aimDailyStaple= (FuTextView)mFuView.findViewById(R.id.tv_o_aimDailyStaple);           //上次主食1
        ll_psyAdjustResult= (LinearLayout) mFuView.findViewById(R.id.ll_psyAdjustResult);       //心理调整
        tv_o_psyAdjustResult= (FuTextView)mFuView.findViewById(R.id.tv_o_psyAdjustResult);         //上次心理调整
        ll_complianceResult= (LinearLayout) mFuView.findViewById(R.id.ll_complianceResult);              //遵医行为
        tv_o_complianceResult= (FuTextView)mFuView.findViewById(R.id.tv_o_complianceResult);                //上次遵医行为
        btn_next= (Button) mFuView.findViewById(R.id.btn_next);                    //下一步

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}
