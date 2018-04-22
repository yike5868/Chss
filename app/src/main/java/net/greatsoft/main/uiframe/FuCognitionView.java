package net.greatsoft.main.uiframe;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.old.ElderCognition;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuCognitionFragment;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuRadioButton;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/26.
 * 老年人认知问题
 */

public class FuCognitionView extends FuUiFrameModel implements View.OnClickListener {

    FuEditText et_name; //姓名
    FuEditText et_sexCode; //性别
    FuTextView tv_age; //年龄
    LinearLayout ll_educationCode; //文化程度
    FuEditText et_diseaseHisory; //既往病史
    FuEditText et_directiveRecord1; //星期几
    LinearLayout ll_directiveScore1; //星期几
    FuEditText et_directiveRecord2; //几号
    LinearLayout ll_directiveScore2; //几号
    FuEditText ey_directiveRecord3; //几月
    LinearLayout ll_directiveScore3; //几月
    FuEditText et_directiveRecord4; //什么季节
    LinearLayout ll_directiveScore4; //什么季节
    FuEditText et_directiveRecord5; //哪一年
    LinearLayout ll_directiveScore5; //哪一年
    FuEditText et_directiveRecord6; //省市
    LinearLayout ll_directiveScore6; //省市
    FuEditText et_directiveRecord7; //区县
    LinearLayout ll_directiveScore7; //区县
    FuEditText et_directiveRecord8; //街道或乡
    LinearLayout ll_directiveScore8; //街道或乡
    FuEditText et_directiveRecord9; //什么地方
    LinearLayout ll_directiveScore9; //什么地方
    FuEditText et_directiveRecord10; //第几层楼
    LinearLayout ll_directiveScore10; //第几层楼
    FuEditText et_memoryRecord1; //皮球
    LinearLayout ll_memoryScore1; //皮球
    FuEditText et_memoryRecord2; //国旗
    LinearLayout ll_memoryScore2; //国旗
    FuEditText et_memoryRecord3; //树木
    LinearLayout ll_memoryScore3; //树木
    FuEditText et_countRecord1; //100-7
    LinearLayout ll_countScore1; //100-7
    FuEditText et_countRecord2; //-7
    LinearLayout ll_countScore2; //-7
    FuEditText et_countRecord3; //-7
    LinearLayout ll_countScore3; //-7
    FuEditText et_countRecord4; //-7
    LinearLayout ll_countScore4; //-7
    FuEditText et_countRecord5; //-7
    LinearLayout ll_countScore5; //-7
    FuEditText et_recollectRecord1; //皮球
    LinearLayout ll_recollectScore1; //皮球
    FuEditText et_recollectRecord2; //国旗
    LinearLayout ll_recollectScore2; //国旗
    FuEditText et_recollectRecord3; //树木
    LinearLayout ll_recollectScore3; //树木
    FuEditText et_namingQuestion1; //命名能力1
    FuEditText et_namingRecord1; //命名能力1
    LinearLayout ll_namingScore1; //命名能力1
    FuEditText et_namingQuestion2; //命名能力2
    FuEditText et_namingRecord2; //命名能力2
    LinearLayout ll_namingScore2; //命名能力2
    FuEditText et_languageQuestion; //复述能力
    FuEditText et_languageRecord; //复述能力
    LinearLayout ll_languageScore; //复述能力
    FuEditText et_threestepQuestion1; //三步命令1
    FuEditText et_threestepRecord1; //三步命令1
    LinearLayout ll_threestepScore1; //三步命令1
    FuEditText et_threestepQuestion2; //三步命令2
    FuEditText et_threestepRecord2; //三步命令2
    LinearLayout ll_threestepScore2; //三步命令2
    FuEditText et_threestepQuestion3; //三步命令3
    FuEditText et_threestepRecord3; //三步命令3
    LinearLayout ll_threestepScore3; //三步命令3
    FuEditText et_readQuestion; //阅读能力
    FuEditText et_readRecord; //阅读能力
    LinearLayout ll_readScore; //阅读能力
    FuEditText et_writeQuestion; //书写能力
    FuEditText et_writeRecord; //书写能力
    LinearLayout ll_writeScore; //书写能力
    FuEditText et_structureRecord; //结构能力
    LinearLayout ll_structureScore; //结构能力
    FuEditText et_totalScore; //总分

    FuEditText et_assessDate; //评定时间

    int total = 30; // 预定总分

    TextView fu_title_center;
    Button fu_title_right_btn;


    public FuCognitionView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cognitive_view, null);

    }

    @Override
    protected void initFuData() {

        initCheckBoxSimple("CULTUREDEGREE", ll_educationCode, 4); //文化程度
        initOldCognitiveRadios(ll_directiveScore1);
        initOldCognitiveRadios(ll_directiveScore2);
        initOldCognitiveRadios(ll_directiveScore3);
        initOldCognitiveRadios(ll_directiveScore4);
        initOldCognitiveRadios(ll_directiveScore5);
        initOldCognitiveRadios(ll_directiveScore6);
        initOldCognitiveRadios(ll_directiveScore7);
        initOldCognitiveRadios(ll_directiveScore8);
        initOldCognitiveRadios(ll_directiveScore9);
        initOldCognitiveRadios(ll_directiveScore10);
        initOldCognitiveRadios(ll_memoryScore1);
        initOldCognitiveRadios(ll_memoryScore2);
        initOldCognitiveRadios(ll_memoryScore3);
        initOldCognitiveRadios(ll_countScore1);
        initOldCognitiveRadios(ll_countScore2);
        initOldCognitiveRadios(ll_countScore3);
        initOldCognitiveRadios(ll_countScore4);
        initOldCognitiveRadios(ll_countScore5);
        initOldCognitiveRadios(ll_recollectScore1);
        initOldCognitiveRadios(ll_recollectScore2);
        initOldCognitiveRadios(ll_recollectScore3);
        initOldCognitiveRadios(ll_namingScore1);
        initOldCognitiveRadios(ll_namingScore2);
        initOldCognitiveRadios(ll_languageScore);
        initOldCognitiveRadios(ll_threestepScore1);
        initOldCognitiveRadios(ll_threestepScore2);
        initOldCognitiveRadios(ll_threestepScore3);
        initOldCognitiveRadios(ll_readScore);
        initOldCognitiveRadios(ll_writeScore);
        initOldCognitiveRadios(ll_structureScore);

    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("老年人认知功能随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(ElderCognition elderCognition, PersonInfo personInfo) {

        et_sexCode.setText(personInfo.getSexValue());
        tv_age.setAge(personInfo.getBirthday());

        if (elderCognition == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        List<PersonDisease> disease = personInfo.getPersonDisease();
        for (int i = 0; i < disease.size(); i++) {
            String name = disease.get(i).getDiseaseName();
            builder.append(name);
        }
        et_diseaseHisory.setText(builder.toString());
        et_name.setText(elderCognition.getName());


        setCheckBoxSelect(elderCognition.getEducationCode(), ll_educationCode);
        et_diseaseHisory.setText(elderCognition.getDiseaseHistory());

        et_directiveRecord1.setText(elderCognition.getDirectiveRecord1());
        setRadioSelectVal(ll_directiveScore1, elderCognition.getDirectiveScore1());
        et_directiveRecord2.setText(elderCognition.getDirectiveRecord2());
        setRadioSelectVal(ll_directiveScore2, elderCognition.getDirectiveScore2());
        ey_directiveRecord3.setText(elderCognition.getDirectiveRecord3());
        setRadioSelectVal(ll_directiveScore3, elderCognition.getDirectiveScore3());
        et_directiveRecord4.setText(elderCognition.getDirectiveRecord4());
        setRadioSelectVal(ll_directiveScore4, elderCognition.getDirectiveScore4());
        et_directiveRecord5.setText(elderCognition.getDirectiveRecord5());
        setRadioSelectVal(ll_directiveScore5, elderCognition.getDirectiveScore5());
        et_directiveRecord6.setText(elderCognition.getDirectiveRecord6());
        setRadioSelectVal(ll_directiveScore6, elderCognition.getDirectiveScore6());
        et_directiveRecord7.setText(elderCognition.getDirectiveRecord7());
        setRadioSelectVal(ll_directiveScore7, elderCognition.getDirectiveScore7());
        et_directiveRecord8.setText(elderCognition.getDirectiveRecord8());
        setRadioSelectVal(ll_directiveScore8, elderCognition.getDirectiveScore8());
        et_directiveRecord9.setText(elderCognition.getDirectiveRecord9());
        setRadioSelectVal(ll_directiveScore9, elderCognition.getDirectiveScore9());
        et_directiveRecord10.setText(elderCognition.getDirectiveRecord10());
        setRadioSelectVal(ll_directiveScore10, elderCognition.getDirectiveScore10());

        et_memoryRecord1.setText(elderCognition.getMemoryRecord1());
        setRadioSelectVal(ll_memoryScore1, elderCognition.getMemoryScore1());
        et_memoryRecord2.setText(elderCognition.getMemoryRecord2());
        setRadioSelectVal(ll_memoryScore2, elderCognition.getMemoryScore2());
        et_memoryRecord3.setText(elderCognition.getMemoryRecord3());
        setRadioSelectVal(ll_memoryScore3, elderCognition.getMemoryScore3());

        et_countRecord1.setText(elderCognition.getCountRecord1());
        setRadioSelectVal(ll_countScore1, elderCognition.getCountScore1());
        et_countRecord2.setText(elderCognition.getCountRecord2());
        setRadioSelectVal(ll_countScore2, elderCognition.getCountScore2());
        et_countRecord3.setText(elderCognition.getCountRecord3());
        setRadioSelectVal(ll_countScore3, elderCognition.getCountScore3());
        et_countRecord4.setText(elderCognition.getCountRecord4());
        setRadioSelectVal(ll_countScore4, elderCognition.getCountScore4());
        et_countRecord5.setText(elderCognition.getCountRecord5());
        setRadioSelectVal(ll_countScore5, elderCognition.getCountScore5());

        et_recollectRecord1.setText(elderCognition.getRecollectRecord1());
        setRadioSelectVal(ll_recollectScore1, elderCognition.getRecollectScore1());
        et_recollectRecord2.setText(elderCognition.getRecollectRecord2());
        setRadioSelectVal(ll_recollectScore2, elderCognition.getRecollectScore2());
        et_recollectRecord3.setText(elderCognition.getRecollectRecord3());
        setRadioSelectVal(ll_recollectScore3, elderCognition.getRecollectScore3());

        et_namingRecord1.setText(elderCognition.getNamingRecord1());
        et_namingQuestion1.setText(elderCognition.getNamingQuestion1());
        setRadioSelectVal(ll_namingScore1, elderCognition.getNamingScore1());
        et_namingRecord2.setText(elderCognition.getNamingRecord2());
        et_namingQuestion2.setText(elderCognition.getNamingQuestion2());
        setRadioSelectVal(ll_namingScore2, elderCognition.getNamingScore2());

        et_languageRecord.setText(elderCognition.getLanguageRecord());
        et_languageQuestion.setText(elderCognition.getLanguageQuestion());
        setRadioSelectVal(ll_languageScore, elderCognition.getLanguageScore());

        et_threestepRecord1.setText(elderCognition.getThreestepRecord1());
        et_threestepQuestion1.setText(elderCognition.getThreestepQuestion1());
        setRadioSelectVal(ll_threestepScore1, elderCognition.getThreestepScore1());
        et_threestepRecord2.setText(elderCognition.getThreestepRecord2());
        et_threestepQuestion2.setText(elderCognition.getThreestepQuestion2());
        setRadioSelectVal(ll_threestepScore2, elderCognition.getThreestepScore2());
        et_threestepRecord3.setText(elderCognition.getThreestepRecord3());
        et_threestepQuestion3.setText(elderCognition.getThreestepQuestion3());
        setRadioSelectVal(ll_threestepScore3, elderCognition.getThreestepScore3());

        et_readRecord.setText(elderCognition.getReadRecord());
        et_readQuestion.setText(elderCognition.getReadQuestion());
        setRadioSelectVal(ll_readScore, elderCognition.getReadScore());

        et_writeRecord.setText(elderCognition.getWriteRecord());
        et_writeQuestion.setText(elderCognition.getWriteQuestion());
        setRadioSelectVal(ll_writeScore, elderCognition.getWriteScore());

        et_structureRecord.setText(elderCognition.getStructureRecord());
        setRadioSelectVal(ll_structureScore, elderCognition.getStructureScore());

//        et_totalScore.setText(elderCognition.getTotalScore());
        et_assessDate.setText(elderCognition.getAssessDate());

    }

    public void saveData(ElderCognition elderCognition) {

        elderCognition.setName(et_name.getString());
//        elderCognition.setSexCode(et_sexCode.getString());
//        elderCognition.setAge(tv_age.getag);
        elderCognition.setEducationCode(getCheckBoxSimpleCode(ll_educationCode));
        elderCognition.setDiseaseHistory(et_diseaseHisory.getString());
        elderCognition.setDirectiveRecord1(et_directiveRecord1.getString());
        elderCognition.setDirectiveScore1(getCheckBOxSelectSimpleCode(ll_directiveScore1));
        elderCognition.setDirectiveRecord2(et_directiveRecord2.getString());
        elderCognition.setDirectiveScore2(getCheckBOxSelectSimpleCode(ll_directiveScore2));
        elderCognition.setDirectiveRecord3(ey_directiveRecord3.getString());
        elderCognition.setDirectiveScore3(getCheckBOxSelectSimpleCode(ll_directiveScore3));
        elderCognition.setDirectiveRecord4(et_directiveRecord4.getString());
        elderCognition.setDirectiveScore4(getCheckBOxSelectSimpleCode(ll_directiveScore4));
        elderCognition.setDirectiveRecord5(et_directiveRecord5.getString());
        elderCognition.setDirectiveScore5(getCheckBOxSelectSimpleCode(ll_directiveScore5));
        elderCognition.setDirectiveRecord6(et_directiveRecord6.getString());
        elderCognition.setDirectiveScore6(getCheckBOxSelectSimpleCode(ll_directiveScore6));
        elderCognition.setDirectiveRecord7(et_directiveRecord7.getString());
        elderCognition.setDirectiveScore7(getCheckBOxSelectSimpleCode(ll_directiveScore7));
        elderCognition.setDirectiveRecord8(et_directiveRecord8.getString());
        elderCognition.setDirectiveScore8(getCheckBOxSelectSimpleCode(ll_directiveScore8));
        elderCognition.setDirectiveRecord9(et_directiveRecord9.getString());
        elderCognition.setDirectiveScore9(getCheckBOxSelectSimpleCode(ll_directiveScore9));
        elderCognition.setDirectiveRecord10(et_directiveRecord10.getString());
        elderCognition.setDirectiveScore10(getCheckBOxSelectSimpleCode(ll_directiveScore10));
        elderCognition.setMemoryRecord1(et_memoryRecord1.getString());
        elderCognition.setMemoryScore1(getCheckBOxSelectSimpleCode(ll_memoryScore1));
        elderCognition.setMemoryRecord2(et_memoryRecord2.getString());
        elderCognition.setMemoryScore2(getCheckBOxSelectSimpleCode(ll_memoryScore2));
        elderCognition.setMemoryRecord3(et_memoryRecord3.getString());
        elderCognition.setMemoryScore3(getCheckBOxSelectSimpleCode(ll_memoryScore3));
        elderCognition.setCountRecord1(et_countRecord1.getString());
        elderCognition.setCountScore1(getCheckBOxSelectSimpleCode(ll_countScore1));
        elderCognition.setCountRecord2(et_countRecord2.getString());
        elderCognition.setCountScore2(getCheckBOxSelectSimpleCode(ll_countScore2));
        elderCognition.setCountRecord3(et_countRecord3.getString());
        elderCognition.setCountScore3(getCheckBOxSelectSimpleCode(ll_countScore3));
        elderCognition.setCountRecord4(et_countRecord4.getString());
        elderCognition.setCountScore4(getCheckBOxSelectSimpleCode(ll_countScore4));
        elderCognition.setCountRecord5(et_countRecord5.getString());
        elderCognition.setCountScore5(getCheckBOxSelectSimpleCode(ll_countScore5));
        elderCognition.setRecollectRecord1(et_recollectRecord1.getString());
        elderCognition.setRecollectScore1(getCheckBOxSelectSimpleCode(ll_recollectScore1));
        elderCognition.setRecollectRecord2(et_recollectRecord2.getString());
        elderCognition.setRecollectScore2(getCheckBOxSelectSimpleCode(ll_recollectScore2));
        elderCognition.setRecollectRecord3(et_recollectRecord3.getString());
        elderCognition.setRecollectScore3(getCheckBOxSelectSimpleCode(ll_recollectScore3));
        elderCognition.setNamingRecord1(et_namingRecord1.getString());
        elderCognition.setNamingScore1(getCheckBOxSelectSimpleCode(ll_namingScore1));
        elderCognition.setNamingQuestion1(et_namingQuestion1.getString());
        elderCognition.setNamingRecord2(et_namingRecord2.getString());
        elderCognition.setNamingScore2(getCheckBOxSelectSimpleCode(ll_namingScore2));
        elderCognition.setNamingQuestion2(et_namingQuestion2.getString());
        elderCognition.setLanguageRecord(et_languageRecord.getString());
        elderCognition.setLanguageScore(getCheckBOxSelectSimpleCode(ll_languageScore));
        elderCognition.setLanguageQuestion(et_languageQuestion.getString());
        elderCognition.setThreestepRecord1(et_threestepRecord1.getString());
        elderCognition.setThreestepScore1(getCheckBOxSelectSimpleCode(ll_threestepScore1));
        elderCognition.setThreestepQuestion1(et_threestepQuestion1.getString());
        elderCognition.setThreestepRecord2(et_threestepRecord2.getString());
        elderCognition.setThreestepScore2(getCheckBOxSelectSimpleCode(ll_threestepScore2));
        elderCognition.setThreestepQuestion2(et_threestepQuestion2.getString());
        elderCognition.setThreestepRecord3(et_threestepRecord3.getString());
        elderCognition.setThreestepScore3(getCheckBOxSelectSimpleCode(ll_threestepScore3));
        elderCognition.setThreestepQuestion3(et_threestepQuestion3.getString());
        elderCognition.setReadRecord(et_readRecord.getString());
        elderCognition.setReadScore(getCheckBOxSelectSimpleCode(ll_readScore));
        elderCognition.setReadQuestion(et_readQuestion.getString());
        elderCognition.setWriteRecord(et_writeRecord.getString());
        elderCognition.setWriteScore(getCheckBOxSelectSimpleCode(ll_writeScore));
        elderCognition.setWriteQuestion(et_writeQuestion.getString());
        elderCognition.setStructureRecord(et_structureRecord.getString());
        elderCognition.setStructureScore(getCheckBOxSelectSimpleCode(ll_structureScore));
        elderCognition.setTotalScore(et_totalScore.getString());
        elderCognition.setAssessDate(et_assessDate.getDate());

    }

    private void findView() {

        et_name = (FuEditText) mFuView.findViewById(R.id.et_name); //姓名
        et_sexCode = (FuEditText) mFuView.findViewById(R.id.et_sexCode); //性别
        tv_age = (FuTextView) mFuView.findViewById(R.id.tv_age); //年龄
        ll_educationCode = (LinearLayout) mFuView.findViewById(R.id.ll_educationCode); //文化程度
        et_diseaseHisory = (FuEditText) mFuView.findViewById(R.id.et_diseaseHistory); //既往病史
        et_directiveRecord1 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord1); //星期几
        ll_directiveScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore1); //星期几
        et_directiveRecord2 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord2); //几号
        ll_directiveScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore2); //几号
        ey_directiveRecord3 = (FuEditText) mFuView.findViewById(R.id.ey_directiveRecord3); //几月
        ll_directiveScore3 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore3); //几月
        et_directiveRecord4 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord4); //什么季节
        ll_directiveScore4 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore4); //什么季节
        et_directiveRecord5 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord5); //哪一年
        ll_directiveScore5 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore5); //哪一年
        et_directiveRecord6 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord6); //省市
        ll_directiveScore6 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore6); //省市
        et_directiveRecord7 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord7); //区县
        ll_directiveScore7 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore7); //区县
        et_directiveRecord8 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord8); //街道或乡
        ll_directiveScore8 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore8); //街道或乡
        et_directiveRecord9 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord9); //什么地方
        ll_directiveScore9 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore9); //什么地方
        et_directiveRecord10 = (FuEditText) mFuView.findViewById(R.id.et_directiveRecord10); //第几层楼
        ll_directiveScore10 = (LinearLayout) mFuView.findViewById(R.id.ll_directiveScore10); //第几层楼
        et_memoryRecord1 = (FuEditText) mFuView.findViewById(R.id.et_memoryRecord1); //皮球
        ll_memoryScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_memoryScore1); //皮球
        et_memoryRecord2 = (FuEditText) mFuView.findViewById(R.id.et_memoryRecord2); //国旗
        ll_memoryScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_memoryScore2); //国旗
        et_memoryRecord3 = (FuEditText) mFuView.findViewById(R.id.et_memoryRecord3); //树木
        ll_memoryScore3 = (LinearLayout) mFuView.findViewById(R.id.ll_memoryScore3); //树木
        et_countRecord1 = (FuEditText) mFuView.findViewById(R.id.et_countRecord1); //100-7
        ll_countScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_countScore1); //100-7
        et_countRecord2 = (FuEditText) mFuView.findViewById(R.id.et_countRecord2); //-7
        ll_countScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_countScore2); //-7
        et_countRecord3 = (FuEditText) mFuView.findViewById(R.id.et_countRecord3); //-7
        ll_countScore3 = (LinearLayout) mFuView.findViewById(R.id.ll_countScore3); //-7
        et_countRecord4 = (FuEditText) mFuView.findViewById(R.id.et_countRecord4); //-7
        ll_countScore4 = (LinearLayout) mFuView.findViewById(R.id.ll_countScore4); //-7
        et_countRecord5 = (FuEditText) mFuView.findViewById(R.id.et_countRecord5); //-7
        ll_countScore5 = (LinearLayout) mFuView.findViewById(R.id.ll_countScore5); //-7
        et_recollectRecord1 = (FuEditText) mFuView.findViewById(R.id.et_recollectRecord1); //皮球
        ll_recollectScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_recollectScore1); //皮球
        et_recollectRecord2 = (FuEditText) mFuView.findViewById(R.id.et_recollectRecord2); //国旗
        ll_recollectScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_recollectScore2); //国旗
        et_recollectRecord3 = (FuEditText) mFuView.findViewById(R.id.et_recollectRecord3); //树木
        ll_recollectScore3 = (LinearLayout) mFuView.findViewById(R.id.ll_recollectScore3); //树木
        et_namingQuestion1 = (FuEditText) mFuView.findViewById(R.id.et_namingQuestion1); //命名能力1
        et_namingRecord1 = (FuEditText) mFuView.findViewById(R.id.et_namingRecord1); //命名能力1
        ll_namingScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_namingScore1); //命名能力1
        et_namingQuestion2 = (FuEditText) mFuView.findViewById(R.id.et_namingQuestion2); //命名能力2
        et_namingRecord2 = (FuEditText) mFuView.findViewById(R.id.et_namingRecord2); //命名能力2
        ll_namingScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_namingScore2); //命名能力2
        et_languageQuestion = (FuEditText) mFuView.findViewById(R.id.et_languageQuestion); //复述能力
        et_languageRecord = (FuEditText) mFuView.findViewById(R.id.et_languageRecord); //复述能力
        ll_languageScore = (LinearLayout) mFuView.findViewById(R.id.ll_languageScore); //复述能力
        et_threestepQuestion1 = (FuEditText) mFuView.findViewById(R.id.et_threestepQuestion1); //三步命令1
        et_threestepRecord1 = (FuEditText) mFuView.findViewById(R.id.et_threestepRecord1); //三步命令1
        ll_threestepScore1 = (LinearLayout) mFuView.findViewById(R.id.ll_threestepScore1); //三步命令1
        et_threestepQuestion2 = (FuEditText) mFuView.findViewById(R.id.et_threestepQuestion2); //三步命令2
        et_threestepRecord2 = (FuEditText) mFuView.findViewById(R.id.et_threestepRecord2); //三步命令2
        ll_threestepScore2 = (LinearLayout) mFuView.findViewById(R.id.ll_threestepScore2); //三步命令2
        et_threestepQuestion3 = (FuEditText) mFuView.findViewById(R.id.et_threestepQuestion3); //三步命令3
        et_threestepRecord3 = (FuEditText) mFuView.findViewById(R.id.et_threestepRecord3); //三步命令3
        ll_threestepScore3 = (LinearLayout) mFuView.findViewById(R.id.ll_threestepScore3); //三步命令3
        et_readQuestion = (FuEditText) mFuView.findViewById(R.id.et_readQuestion); //阅读能力
        et_readRecord = (FuEditText) mFuView.findViewById(R.id.et_readRecord); //阅读能力
        ll_readScore = (LinearLayout) mFuView.findViewById(R.id.ll_readScore); //阅读能力
        et_writeQuestion = (FuEditText) mFuView.findViewById(R.id.et_writeQuestion); //书写能力
        et_writeRecord = (FuEditText) mFuView.findViewById(R.id.et_writeRecord); //书写能力
        ll_writeScore = (LinearLayout) mFuView.findViewById(R.id.ll_writeScore); //书写能力
        et_structureRecord = (FuEditText) mFuView.findViewById(R.id.et_structureRecord); //结构能力
        ll_structureScore = (LinearLayout) mFuView.findViewById(R.id.ll_structureScore); //结构能力
        et_totalScore = (FuEditText) mFuView.findViewById(R.id.et_totalScore); //总分
        et_assessDate = (FuEditText) mFuView.findViewById(R.id.et_assessDate); //评定时间
        et_assessDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_assessDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
            }
        });
//        et_createTime.setText(((FuContentActivity) mContext).getSystemTime());
        et_totalScore.setText(30 + "");
    }


    // 初始化radio
    private void initOldCognitiveRadios(final LinearLayout ll) {

        if (ll != null) {
            for (int i = 0; i < 2; i++) {
                FuRadioButton rb = (FuRadioButton) LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
//                rb.setButtonDrawable(R.drawable.radiobutton);
                rb.setTextColor(Color.BLACK);
                rb.setTextSize(14f);
                rb.setText(i + "");
                rb.setTag(i + "");
                rb.setGravity(Gravity.CENTER);
                ll.addView(rb);

                if (i == 1) {
                    rb.setChecked(true);
                }

                rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        if (isChecked) {
                            for (int j = 0; j < ll.getChildCount(); j++) {
                                View v = ll.getChildAt(j);
                                if (v instanceof RadioButton) {
                                    if (!buttonView.getTag().equals(v.getTag())) {
                                        ((RadioButton) v).setChecked(false);
                                    }
                                    if (buttonView.getTag().equals(v.getTag())
                                            && buttonView.getTag().toString()
                                            .equals("0")) {
                                        total--;
                                        et_totalScore.setText((total < 0 ? 0
                                                : total) + "");
                                    }
                                    if (buttonView.getTag().equals(v.getTag())
                                            && buttonView.getTag().toString()
                                            .equals("1")) {
                                        total++;
                                        et_totalScore
                                                .setText((total > 30 ? 30
                                                        : total) + "");
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

    }

    /**
     * 设置单选
     *
     * @param ll
     * @param code
     */
    private void setRadioSelectVal(LinearLayout ll, String code) {
        if (code == null)
            return;
        if (ll != null) {
            for (int i = 0; i < ll.getChildCount(); i++) {
                View v = ll.getChildAt(i);
                if (v instanceof RadioButton) {
                    String tag = (String) v.getTag();
                    if (code.equals(tag)) {
                        ((CompoundButton) v).setChecked(true);
                        break;
                    }
                } else if (v instanceof LinearLayout) {
                    setRadioSelectVal((LinearLayout) v, code);
                }
            }
        }
    }

    /**
     * 获取选择框值（选择框-单选）--嵌套1层
     **/
    private String getCheckBOxSelectSimpleCode(LinearLayout para1) {
        String backstr = "";
        for (int i = 0; i < para1.getChildCount(); i++) {
            View v = para1.getChildAt(i);
            if (v instanceof RadioButton) {
                if (((CompoundButton) v).isChecked()) {
                    backstr = ((CompoundButton) v).getTag().toString();
                }
            } else if (v instanceof LinearLayout) {
                for (int j = 0; j < ((LinearLayout) v).getChildCount(); j++) {
                    View w = ((LinearLayout) v).getChildAt(j);
                    if (w instanceof RadioButton) {
                        if (((CompoundButton) w).isChecked()) {
                            backstr = ((CompoundButton) w).getTag().toString();
                        }
                    }
                }
            }
        }
        return backstr;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuCognitionFragment.EVENT_SAVE_COGNITION, null);
                break;
        }
    }
}
