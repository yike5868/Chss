package net.greatsoft.main.uiframe;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.PersonPastHistoryDao;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;

import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/18
 * Time: 16:51
 * progject: Chss_FollowUp
 * Describe：入户随访-新增成员-医疗费用支付
 */

public class FuMemberAdd03View extends FuUiFrameModel implements View.OnClickListener {


    LinearLayout ll_medicalPayWay;  //医疗费用支付方式
    LinearLayout ll_drugAllergy;    //药物过敏史
    LinearLayout ll_exposureHistory;    //暴露史
    LinearLayout ll_personDisease;  //疾病

    FuCheckBox cb_personDisease_1; //1 无
    FuCheckBox cb_personDisease_2; //2 高血压
    FuEditText et_personDisease_date_2;//高血压
    FuCheckBox cb_personDisease_3; //3 糖尿病
    FuEditText et_personDisease_date_3;//糖尿病
    FuCheckBox cb_personDisease_4; //4 冠心病
    FuEditText et_personDisease_date_4;
    FuCheckBox cb_personDisease_5; //5 慢性阻塞性肺疾病
    FuEditText et_personDisease_date_5;
    FuCheckBox cb_personDisease_6; //6 恶性肿瘤
    FuEditText et_personDisease_name_6;
    FuEditText et_personDisease_date_6;
    FuCheckBox cb_personDisease_7; //7 脑卒中
    FuEditText et_personDisease_date_7;
    FuCheckBox cb_personDisease_8; //8 严重精神病障碍
    FuEditText et_personDisease_date_8;
    FuCheckBox cb_personDisease_9; //9 结核病
    FuEditText et_personDisease_date_9;
    FuCheckBox cb_personDisease_10; //10 肝炎
    FuEditText et_personDisease_date_10;
    FuCheckBox cb_personDisease_11; //11 其他法定传染病
    FuEditText et_personDisease_date_11;
    FuCheckBox cb_personDisease_12; //12 职业病
    FuEditText et_personDisease_name_12;
    FuEditText et_personDisease_date_12;
    FuCheckBox cb_personDisease_13; //13 其他
    FuEditText et_personDisease_name_13;
    FuEditText et_personDisease_date_13;

    FuEditText ll_familyDiseaseHistoryFather; //父亲
    FuEditText ll_familyDiseaseHistoryMother; //母亲
    FuEditText ll_familyDiseaseHistorySiblings;   //兄弟姐妹
    FuEditText ll_familyDiseaseHistoryChildren;   //子女
    FuEditText ll_familyDiseaseHistoryFatherelse; //父亲其他
    FuEditText ll_familyDiseaseHistoryMotherelse; //母亲其他
    FuEditText ll_familyDiseaseHistorySiblingselse;   //兄弟姐妹其他
    FuEditText ll_familyDiseaseHistoryChildrenelse;   //子女其他
    LinearLayout ll_geneticDiseaseHistory;  //遗传病史
    LinearLayout ll_disability; //残疾情况

    //手术
    RadioButton rb_choiceStatus11;
    RadioButton rb_choiceStatus12;
    FuEditText et_historyName11;
    FuEditText et_confirmDate11;
    FuEditText et_historyName12;
    FuEditText et_confirmDate12;
    //外伤
    RadioButton rb_choiceStatus21;
    RadioButton rb_choiceStatus22;
    FuEditText et_historyName21;
    FuEditText et_confirmDate21;
    FuEditText et_historyName22;
    FuEditText et_confirmDate22;
    //输血
    RadioButton rb_choiceStatus31;
    RadioButton rb_choiceStatus32;
    FuEditText et_historyName31;
    FuEditText et_confirmDate31;
    FuEditText et_historyName32;
    FuEditText et_confirmDate32;

    LinearLayout ll_familyDisease;//疾病类型

    PersonInfo mPersonInfo; //个人信息 为了保存证件类型

    String str;

    public FuMemberAdd03View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void createFuLayout() {

        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_member_add03_view, null);

    }

    public void setData(PersonInfo personInfo) {

        setCheckBoxSelect("medicalPayWay", personInfo.getPersonInfoId(), ll_medicalPayWay);  //医疗费用支付方式
        setCheckBoxSelect("drugAllergy", personInfo.getPersonInfoId(), ll_drugAllergy);    //药物过敏史
        setCheckBoxSelect("exposureHistory", personInfo.getPersonInfoId(), ll_exposureHistory);    //暴露史
//        setCheckBoxSelect("", personInfo.getPersonInfoId(), ll_personDisease);  //疾病

        setPersonDisease(personInfo.getPersonInfoId(), "1", cb_personDisease_1, null, null);
        setPersonDisease(personInfo.getPersonInfoId(), "2", cb_personDisease_2, null, et_personDisease_date_2);
        setPersonDisease(personInfo.getPersonInfoId(), "3", cb_personDisease_3, null, et_personDisease_date_3);
        setPersonDisease(personInfo.getPersonInfoId(), "4", cb_personDisease_4, null, null);
        setPersonDisease(personInfo.getPersonInfoId(), "5", cb_personDisease_5, null, null);
        setPersonDisease(personInfo.getPersonInfoId(), "6", cb_personDisease_6, et_personDisease_name_6, et_personDisease_date_6);
        setPersonDisease(personInfo.getPersonInfoId(), "7", cb_personDisease_7, null, et_personDisease_date_7);
        setPersonDisease(personInfo.getPersonInfoId(), "8", cb_personDisease_8, null, et_personDisease_date_8);
        setPersonDisease(personInfo.getPersonInfoId(), "9", cb_personDisease_9, null, et_personDisease_date_9);
        setPersonDisease(personInfo.getPersonInfoId(), "10", cb_personDisease_10, null, et_personDisease_date_10);
        setPersonDisease(personInfo.getPersonInfoId(), "11", cb_personDisease_11, null, et_personDisease_date_11);
        setPersonDisease(personInfo.getPersonInfoId(), "12", cb_personDisease_12, et_personDisease_name_12, et_personDisease_date_12);
        setPersonDisease(personInfo.getPersonInfoId(), "13", cb_personDisease_13, et_personDisease_name_13, et_personDisease_date_13);
//        setPersonDisease(personInfo.getPersonInfoId(), "2", cb_personDisease_2, null, et_personDisease_date_2);

        List list1 = sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).where(PersonPastHistoryDao.Properties.HistoryType.eq("1")).list();
        setPersonPastHistory(list1, rb_choiceStatus11, rb_choiceStatus12, et_historyName11, et_confirmDate11, et_historyName12, et_confirmDate12);
        list1 = sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).where(PersonPastHistoryDao.Properties.HistoryType.eq("2")).list();
        setPersonPastHistory(list1, rb_choiceStatus21, rb_choiceStatus22, et_historyName21, et_confirmDate21, et_historyName22, et_confirmDate22);
        list1 = sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).where(PersonPastHistoryDao.Properties.HistoryType.eq("3")).list();
        setPersonPastHistory(list1, rb_choiceStatus31, rb_choiceStatus32, et_historyName31, et_confirmDate31, et_historyName32, et_confirmDate32);

//        setCheckBoxSelect("familyDiseaseHistoryFather", personInfo.getPersonInfoId(), ll_familyDiseaseHistoryFather); //父亲
//        setCheckBoxSelect("familyDiseaseHistoryMother", personInfo.getPersonInfoId(), ll_familyDiseaseHistoryMother); //母亲
//        setCheckBoxSelect("familyDiseaseHistorySiblings", personInfo.getPersonInfoId(), ll_familyDiseaseHistorySiblings);   //兄弟姐妹
//        setCheckBoxSelect("familyDiseaseHistoryChildren", personInfo.getPersonInfoId(), ll_familyDiseaseHistoryChildren);   //子女

        setRadioButtonSelect(personInfo.getGeneticDiseaseHistoryCode(), personInfo.getGeneticDiseaseHistoryName(), ll_geneticDiseaseHistory);  //遗传病史

        setCheckBoxSelect("disability", personInfo.getPersonInfoId(), ll_disability); //残疾情况

    }

    public void saveData(PersonInfo personInfo) {




        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_medicalPayWay); //医疗费用支付方式
        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_drugAllergy);    //药物过敏史
        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_exposureHistory);    //暴露史
//        saveCheckBoxMany(personInfo.getPersonInfoId(), list_recordChoice, ll_personDisease);  //疾病

        if (!cb_personDisease_1.isChecked()) {
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_2, et_personDisease_date_2, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_3, et_personDisease_date_3, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_4, et_personDisease_date_4, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_5, et_personDisease_date_5, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_6, et_personDisease_date_6, et_personDisease_name_6);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_7, et_personDisease_date_7, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_8, et_personDisease_date_8, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_9, et_personDisease_date_9, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_10, et_personDisease_date_10, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_11, et_personDisease_date_11, null);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_12, et_personDisease_date_12, et_personDisease_name_12);
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_13, et_personDisease_date_13, et_personDisease_name_13);
        } else {
            getPersonDisease(personInfo.getPersonInfoId(), personInfo.getPersonDisease(), cb_personDisease_1, null, null);

        }


//        RecordChoice recordChoice = new RecordChoice();
//        recordChoice.setTableKey(personInfo.getPersonInfoId());
//        recordChoice.setCode("2");
//        recordChoice.setName("高血压");
//        recordChoice.setCodeType("familyDiseaseHistoryFather");
//        list_recordChoice.add(recordChoice);

        getPersonPastHistory(personInfo.getPersonInfoId(), personInfo.getPersonPastHistory(), "1", rb_choiceStatus11, rb_choiceStatus12, et_historyName11, et_confirmDate11, et_historyName12, et_confirmDate12); //手术
        getPersonPastHistory(personInfo.getPersonInfoId(), personInfo.getPersonPastHistory(), "2", rb_choiceStatus21, rb_choiceStatus22, et_historyName21, et_confirmDate21, et_historyName22, et_confirmDate22); //外伤
        getPersonPastHistory(personInfo.getPersonInfoId(), personInfo.getPersonPastHistory(), "3", rb_choiceStatus31, rb_choiceStatus32, et_historyName31, et_confirmDate31, et_historyName32, et_confirmDate32); //输血

//        saveCheckBoxMany(personInfo.getPersonInfoId(), list_recordChoice, ll_familyDiseaseHistoryFather); //父亲
//        saveCheckBoxMany(personInfo.getPersonInfoId(), list_recordChoice, ll_familyDiseaseHistoryMother); //母亲
//        saveCheckBoxMany(personInfo.getPersonInfoId(), list_recordChoice, ll_familyDiseaseHistorySiblings);   //兄弟姐妹
//        saveCheckBoxMany(personInfo.getPersonInfoId(), list_recordChoice, ll_familyDiseaseHistoryChildren);   //子女


        personInfo.setGeneticDiseaseHistoryCode(getCheckBoxSimpleCode(ll_geneticDiseaseHistory));  //遗传病史
        personInfo.setGeneticDiseaseHistoryName(getLinearLayoutString(ll_geneticDiseaseHistory));
        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_disability); //残疾情况

    }

    public void onEditTextListener(final FuEditText et) {


        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//               String content = s.toString();
//                String[] strings = content.split(",");
//                if (strings.length > 0) {
//                    if (strings[strings.length-1].equals("1")) {
//
//                    } else {
//                        int i = Integer.valueOf(strings[strings.length - 1]);
//                        char[] chars = strings[strings.length - 1].toCharArray();
//                        ToastUtil.showToast(mContext, chars[0]+"", 1);
//                        if (chars.length > 1) {
//                            if (chars[1] > 3) {
//                                ToastUtil.showToast(mContext, "请输入正确数字", 1);
//                            } else {
//                                content += ",";
//                                str = content;
//                            }
//                        }
//                    }
//                }
//                String content = s.toString();
//                if (content.contains(",")) {
//
//                } else {
//                    if (content.length() > 1) {
//                        int i = Integer.parseInt(content);
//                        if (i%10 > 3) {
//                            ToastUtil.showToast(mContext,"请输入正确数字",1);
//
//                        } else {
//                            content += ",";
//                            str = content;
//                        }
//
//                    } else {
//                        int i = Integer.parseInt(content);
//                        if (i != 1) {
//                            content += ",";
//                        }
//                        str = content;
//                    }
//                }
//
//                et.removeTextChangedListener(this);
//                setFuText(et,str);
//                et.setSelection(str.length());
//                et.addTextChangedListener(this);
            }

        });


    }

    public void setFuText(FuEditText et, String s) {
        et.setText(s);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

        findView();

        // 医疗费用
        initCheckBoxMany("medicalPayWay", ll_medicalPayWay, 1, false, true);
        // 药物过敏史
        initCheckBoxMany("drugAllergy", ll_drugAllergy, 3, false, true);
        // 暴露史
        initCheckBoxMany("exposureHistory", ll_exposureHistory, 4, false, false);


        initCheckBoxMany("CV9500.05", ll_familyDisease, 5, true, true);

        // 家族史父亲

//        initCheckBoxMany("familyDiseaseHistoryFather", ll_familyDiseaseHistoryFather, 2, true, true);
        // 家族史母亲
//        initCheckBoxMany("familyDiseaseHistoryMother", ll_familyDiseaseHistoryMother, 2, true, true);
//        // 家族史兄弟姐妹
//        initCheckBoxMany("familyDiseaseHistorySiblings", ll_familyDiseaseHistorySiblings, 2, true, true);
//        // 家族史子女
//        initCheckBoxMany("familyDiseaseHistoryChildren", ll_familyDiseaseHistoryChildren, 2, true, true);
        // 遗传病史
        initCheckBoxSimple("YES_NO_CODE", ll_geneticDiseaseHistory, 2, false, true);
        // addEditText(ll_heredityDisease, 100, 100);
        // 残疾情况
        initCheckBoxMany("disability", ll_disability, 3, false, true);

    }

    private void findView() {

        ll_familyDisease = (LinearLayout) mFuView.findViewById(R.id.ll_familyDisease);

        ll_medicalPayWay = (LinearLayout) mFuView.findViewById(R.id.ll_medicalPayWay);  //医疗费用支付方式
        ll_drugAllergy = (LinearLayout) mFuView.findViewById(R.id.ll_drugAllergy);    //药物过敏史
        ll_exposureHistory = (LinearLayout) mFuView.findViewById(R.id.ll_exposureHistory);    //暴露史
        ll_personDisease = (LinearLayout) mFuView.findViewById(R.id.ll_personDisease);  //疾病

        ll_familyDiseaseHistoryFather = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryFather); //父亲
        onEditTextListener(ll_familyDiseaseHistoryFather);//设置监听

        ll_familyDiseaseHistoryMother = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryMother); //母亲
        ll_familyDiseaseHistorySiblings = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistorySiblings);   //兄弟姐妹
        ll_familyDiseaseHistoryChildren = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryChildren);   //子女
        ll_familyDiseaseHistoryFatherelse = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryFatherelse); //父亲其他
        ll_familyDiseaseHistoryMotherelse = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryMotherelse); //母亲其他
        ll_familyDiseaseHistorySiblingselse = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistorySiblingselse);   //兄弟姐妹其他
        ll_familyDiseaseHistoryChildrenelse = (FuEditText) mFuView.findViewById(R.id.ll_familyDiseaseHistoryChildrenelse);   //子女其他
        ll_geneticDiseaseHistory = (LinearLayout) mFuView.findViewById(R.id.ll_geneticDiseaseHistory);  //遗传病史
        ll_disability = (LinearLayout) mFuView.findViewById(R.id.ll_disability); //残疾情况

        cb_personDisease_1 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_1); //1 无
        cb_personDisease_2 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_2); //2 高血压
        et_personDisease_date_2 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_2);//高血压
        et_personDisease_date_2.setOnClickListener(this);
        cb_personDisease_3 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_3); //3 糖尿病
        et_personDisease_date_3 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_3);//糖尿病
        et_personDisease_date_3.setOnClickListener(this);
        cb_personDisease_4 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_4); //4 冠心病
        et_personDisease_date_4 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_4);
        et_personDisease_date_4.setOnClickListener(this);
        cb_personDisease_5 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_5); //5 慢性阻塞性肺疾病
        et_personDisease_date_5 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_5);
        et_personDisease_date_5.setOnClickListener(this);
        cb_personDisease_6 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_6); //6 恶性肿瘤
        et_personDisease_name_6 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_name_6);
        et_personDisease_date_6 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_6);
        et_personDisease_date_6.setOnClickListener(this);
        cb_personDisease_7 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_7); //7 脑卒中
        et_personDisease_date_7 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_7);
        et_personDisease_date_7.setOnClickListener(this);
        cb_personDisease_8 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_8); //8 严重精神病障碍
        et_personDisease_date_8 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_8);
        et_personDisease_date_8.setOnClickListener(this);
        cb_personDisease_9 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_9); //9 结核病
        et_personDisease_date_9 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_9);
        et_personDisease_date_9.setOnClickListener(this);
        cb_personDisease_10 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_10); //10 肝炎
        et_personDisease_date_10 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_10);
        et_personDisease_date_10.setOnClickListener(this);
        cb_personDisease_11 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_11); //11 其他法定传染病
        et_personDisease_date_11 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_11);
        et_personDisease_date_11.setOnClickListener(this);
        cb_personDisease_12 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_12); //12 职业病
        et_personDisease_name_12 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_name_12);
        et_personDisease_date_12 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_12);
        et_personDisease_date_12.setOnClickListener(this);
        cb_personDisease_13 = (FuCheckBox) mFuView.findViewById(R.id.cb_personDisease_13); //13 其他
        et_personDisease_name_13 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_name_13);
        et_personDisease_date_13 = (FuEditText) mFuView.findViewById(R.id.et_personDisease_date_13);
        et_personDisease_date_13.setOnClickListener(this);

        //手术
        rb_choiceStatus11 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus11);
        rb_choiceStatus12 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus12);
        et_historyName11 = (FuEditText) mFuView.findViewById(R.id.et_historyName11);
        et_confirmDate11 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate11);
        et_confirmDate11.setOnClickListener(this);
        et_historyName12 = (FuEditText) mFuView.findViewById(R.id.et_historyName12);
        et_confirmDate12 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate12);
        et_confirmDate12.setOnClickListener(this);
        //外伤
        rb_choiceStatus21 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus21);
        rb_choiceStatus22 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus22);
        et_historyName21 = (FuEditText) mFuView.findViewById(R.id.et_historyName21);
        et_confirmDate21 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate21);
        et_confirmDate21.setOnClickListener(this);
        et_historyName22 = (FuEditText) mFuView.findViewById(R.id.et_historyName22);
        et_confirmDate22 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate22);
        et_confirmDate22.setOnClickListener(this);
        //输血
        rb_choiceStatus31 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus31);
        rb_choiceStatus32 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus32);
        et_historyName31 = (FuEditText) mFuView.findViewById(R.id.et_historyName31);
        et_confirmDate31 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate31);
        et_confirmDate31.setOnClickListener(this);
        et_historyName32 = (FuEditText) mFuView.findViewById(R.id.et_historyName32);
        et_confirmDate32 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate32);
        et_confirmDate32.setOnClickListener(this);


    }
}
