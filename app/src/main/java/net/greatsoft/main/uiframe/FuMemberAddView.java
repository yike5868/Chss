package net.greatsoft.main.uiframe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.fragment.FuMemberAddFragment;
import net.greatsoft.main.tool.IdCardValidator;
import net.greatsoft.main.tool.IdcardInfoExtractor;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.adapter.SpinnerAdapter;
import net.greatsoft.main.view.tree.Node;
import net.greatsoft.main.view.tree.SimpleTreeAdapter;
import net.greatsoft.main.view.tree.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/9/1.
 */

public class FuMemberAddView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    FuButton btn_committee;
    Spinner sp_residential;   //小区
    Spinner sp_building;  //楼栋
    Spinner sp_unit;      //单元
    Spinner sp_roomNumber;   // 房间号

    private boolean canTouch = false;

    FuEditText et_name; //姓名
    FuEditText et_formerName; //曾用名
    FuEditText et_idNo; //身份证号
    FuTextView tv_birthday; //出生日期
    LinearLayout ll_sex;    //性别
    FuEditText et_address;  //家庭地址
    FuEditText et_householdAddress; //户籍地址
    FuEditText et_telNo;    //本人电话
    FuEditText et_fixedPhones;  //固定电话
    Spinner sp_relation;  //与户主关系
    FuEditText et_contactName;  //联系人姓名
    FuEditText et_contactTelNo;    //联系人电话
    FuEditText et_workUnit; //工作单位
    FuTextView tv_paperArchiveDate; //纸质档案建档时间
    FuEditText et_paperCardNum; //纸质档案编号
    LinearLayout ll_residenceType;  //常住类型
    LinearLayout ll_householdType;  //户籍类型
    Spinner sp_nationality;   //民族
    LinearLayout ll_aboCode;    //血型
    LinearLayout ll_RHCode;    //RH阴性
    LinearLayout ll_educationCode;  //文化程度
    LinearLayout ll_occupation; //职业
    LinearLayout ll_marriage;   //婚姻状况
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


    LinearLayout ll_familyDiseaseHistoryFather; //父亲
    LinearLayout ll_familyDiseaseHistoryMother; //母亲
    LinearLayout ll_familyDiseaseHistorySiblings;   //兄弟姐妹
    LinearLayout ll_familyDiseaseHistoryChildren;   //子女


    LinearLayout ll_geneticDiseaseHistory;  //遗传病史
    LinearLayout ll_disability; //残疾情况
    LinearLayout ll_kitchenExhaust; //厨房排风设施
    LinearLayout ll_fuelType;   //燃料类型
    LinearLayout ll_drinkWater; //饮水
    LinearLayout ll_toilet; //厕所
    LinearLayout ll_livestockFence; //禽畜栏

    FuListView lv_card;//证件


    CredentialAdapter credentialAdapter;

    Spinner sp_credentialType;//证件类型
    FuEditText et_credentialNo;//证件号码
    FuButton btn_addCredential;//增加证件


    FuTextView tv_orgCode;  //建档机构
    FuTextView tv_creator;  //建档人
    FuTextView tv_createTime;   //建档时间

    PersonInfo mPersonInfo; //个人信息 为了保存证件类型


    List<Districts> districtsList;//村居委会

    SpinnerAdapter saSubdistricts;//小区
    SpinnerAdapter saBuilding;//楼

    ListView lv_tree; //下拉
    SimpleTreeAdapter simpleTreeAdapter;

    boolean save_update;

    private View inflate;
    private PopupWindow popupWindow;

    public FuMemberAddView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_member_add_jn_view, null);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMemberAddFragment.EVENT_SAVE_PERSON, null);
                break;
            case R.id.tv_birthday:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(),"year-month-day");;
                break;
            case R.id.tv_paperArchiveDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(),"year-month-day");;
                break;
            /**
             * 增加证件
             */
            case R.id.btn_addCredential:
                addCredential();
                et_credentialNo.setText("");//点击完成置空et
                break;
            case R.id.btn_committee:
                canTouch = true;
                makeBottomDialog(v);
                break;
            case R.id.tv_delete:
                if("delete".equals(v.getTag().toString())){
                    ToastUtil.showToast(mContext,"此记录不能删除",Toast.LENGTH_SHORT);
                    return;
                }
                int position = Integer.parseInt(v.getTag().toString());
                mPersonInfo.getPersonCredential().remove(position);
                credentialAdapter.notifyDataSetChanged();
                break;
        }
    }

    public void makeBottomDialog(View d) {

        districtsList = sqlHelper.getDistrictsAll();

        inflate = LayoutInflater.from(mContext).inflate(R.layout.tree_view, null);


        if (popupWindow == null) {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.tree_view, null);
            lv_tree = (ListView) inflate.findViewById(R.id.lv_tree);
            makeTreeView();
//            id_tree.setOnItemClickListener(FuFamilyAddView.this);


            popupWindow = new PopupWindow(inflate, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }

        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        //过期 后期需要修改
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.showAsDropDown(d, 0, 0);


    }

    public void makeTreeView() {

        try {
            simpleTreeAdapter = new SimpleTreeAdapter<Districts>(lv_tree, mContext, districtsList, 10);
            simpleTreeAdapter.setOnTreeNodeClickListener(onTreeNodeClickListener);

        } catch (Exception e) {
            e.printStackTrace();
        }
        lv_tree.setAdapter(simpleTreeAdapter);
    }

    /**
     * 多级菜单的点击事件监听
     */
    TreeListViewAdapter.OnTreeNodeClickListener onTreeNodeClickListener = new TreeListViewAdapter.OnTreeNodeClickListener() {
        @Override
        public void onClick(Node node, int position) {
            if (node.isLeaf()) {
                if (popupWindow != null && popupWindow.isShowing())
                    popupWindow.dismiss();
                List<Node> nodes = simpleTreeAdapter.getNodes();//重新获取当前显示的Node
                btn_committee.setText(nodes.get(position).getName());
                btn_committee.setTag(nodes.get(position).getId());
                setAddress();
                if (saSubdistricts != null)
                    saSubdistricts.clearn();
                if (saBuilding != null)
                    saBuilding.clearn();

                mEventCallBack.EventClick(FuMemberAddFragment.EVENT_GET_SUBDISTRICT, nodes.get(position).getId());
            }
        }
    };

    /**
     * 增加证件
     */
    public void addCredential() {
        PersonCredential personCredential = new PersonCredential();
        if (save_update) {
            personCredential.setPersonInfoId(null);
        } else {
            personCredential.setPersonInfoId(mPersonInfo.getPersonInfoId());
        }
        personCredential.setCredentialNo(et_credentialNo.getString());
        Checks checks = (Checks) sp_credentialType.getSelectedItem();
        personCredential.setCredentialTypeCode(checks.getCode());
        personCredential.setCredentialTypeValue(checks.getValue());
        mPersonInfo.getPersonCredential().add(personCredential);
        credentialAdapter.notifyDataSetChanged();
    }

    public void setData(PersonInfo personInfo, boolean save_update) {
        mPersonInfo = personInfo;
        List<PersonCredential> personCredentials = new ArrayList<>();

        for (int i = 0; i < personInfo.getPersonCredential().size(); i++) {

//            Checks checks = (Checks) sp_credentialType.getSelectedItem();

            PersonCredential personCredential = new PersonCredential();
            personCredential.setCredentialTypeCode(personInfo.getPersonCredential().get(i).getCredentialTypeCode());
            String vule = sqlHelper.getChecksValueByCode(personInfo.getPersonCredential().get(i).getCredentialTypeCode(), "id_type");
            personCredential.setCredentialTypeValue(vule);
            personCredential.setCredentialNo(personInfo.getPersonCredential().get(i).getCredentialNo());

            personCredential.setPersonCredentialId(null);
            personCredentials.add(personCredential);

        }
        mPersonInfo.setPersonCredential(personCredentials);


        this.save_update = save_update;

        btn_committee.setText(personInfo.getCommitteeCN());
        btn_committee.setTag(personInfo.getCommittee());


        if (personInfo.getResidential() != null) {
            List<SpinnerItem> subdistrictsList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem(personInfo.getResidential(), personInfo.getResidentialCN());
            subdistrictsList.add(si);
            setSubdistricts(subdistrictsList);

        }
        if (personInfo.getBuilding() != null) {
            List<SpinnerItem> buildingList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem(personInfo.getBuilding(), personInfo.getBuildingCN());
            buildingList.add(si);

            setBuildings(buildingList);

        }

        et_name.setText(personInfo.getName()); //姓名
        et_formerName.setText(personInfo.getFormerName()); //曾用名
        et_idNo.setText(personInfo.getIdNo()); //身份证号
        tv_birthday.setText(personInfo.getBirthday()); //出生日期
        setCheckBoxSelect(personInfo.getSexCode(), ll_sex);    //性别
        et_address.setText(personInfo.getAddress());  //家庭地址
        et_householdAddress.setText(personInfo.getHouseholdAddress()); //户籍地址
        et_telNo.setText(personInfo.getTelNo());    //本人电话
        et_fixedPhones.setText(personInfo.getFixedPhones());  //固定电话

//        setSpinnerSelectedByTerm("CV0218.01", personInfo.getRelationCode(), sp_relation); //与户主关系
        setSpinnerSelectedByTerm("relation", personInfo.getRelationCode(), sp_relation); //与户主关系

        et_contactName.setText(personInfo.getContactName());  //联系人姓名
        //联系人电话
        et_contactTelNo.setText(personInfo.getContactTelNo());

        et_workUnit.setText(personInfo.getWorkUnit()); //工作单位
        tv_paperArchiveDate.setText(personInfo.getPaperArchiveDate()); //纸质档案建档时间
        et_paperCardNum.setText(personInfo.getPaperCardNum()); //纸质档案编号
        setCheckBoxSelect(personInfo.getResidenceTypeCode(), ll_residenceType);  //常住类型
        setCheckBoxSelect(personInfo.getHouseholdTypeCode(), ll_householdType);  //户籍类型
//        setSpinnerSelectedByTerm("CV9500.53", personInfo.getNationalityCode(), sp_nationality);  //民族
        setSpinnerSelectedByTerm("nation", personInfo.getNationalityCode(), sp_nationality);  //民族
        setCheckBoxSelect(personInfo.getAboCode(), ll_aboCode);    //血型
        setCheckBoxSelect(personInfo.getRhCode(), ll_RHCode);//RH阴性
        setCheckBoxSelect(personInfo.getEducationCode(), ll_educationCode);  //文化程度
        setCheckBoxSelect(personInfo.getOccupationCode(), ll_occupation); //职业
        setCheckBoxSelect(personInfo.getMarriageCode(), ll_marriage);   //婚姻状况
        setCheckBoxSelect("medicalPayWay", personInfo.getRecordChoice(), ll_medicalPayWay);
        setCheckBoxSelect("drugAllergy", personInfo.getRecordChoice(), ll_drugAllergy);    //药物过敏史
        setCheckBoxSelect("exposureHistory", personInfo.getRecordChoice(), ll_exposureHistory);    //暴露史
//         setCheckBoxSelect("",personInfo.getPersonInfoId(),ll_personDisease);  //疾病

        setPersonDisease(personInfo.getPersonDisease(), "1", cb_personDisease_1, null, null);
        setPersonDisease(personInfo.getPersonDisease(), "2", cb_personDisease_2, null, et_personDisease_date_2);
        setPersonDisease(personInfo.getPersonDisease(), "3", cb_personDisease_3, null, et_personDisease_date_3);
        setPersonDisease(personInfo.getPersonDisease(), "4", cb_personDisease_4, null, et_personDisease_date_4);
        setPersonDisease(personInfo.getPersonDisease(), "5", cb_personDisease_5, null, et_personDisease_date_5);
        setPersonDisease(personInfo.getPersonDisease(), "6", cb_personDisease_6, et_personDisease_name_6, et_personDisease_date_6);
        setPersonDisease(personInfo.getPersonDisease(), "7", cb_personDisease_7, null, et_personDisease_date_7);
        setPersonDisease(personInfo.getPersonDisease(), "8", cb_personDisease_8, null, et_personDisease_date_8);
        setPersonDisease(personInfo.getPersonDisease(), "9", cb_personDisease_9, null, et_personDisease_date_9);
        setPersonDisease(personInfo.getPersonDisease(), "10", cb_personDisease_10, null, et_personDisease_date_10);
        setPersonDisease(personInfo.getPersonDisease(), "11", cb_personDisease_11, null, et_personDisease_date_11);
        setPersonDisease(personInfo.getPersonDisease(), "12", cb_personDisease_12, et_personDisease_name_12, et_personDisease_date_12);
        setPersonDisease(personInfo.getPersonDisease(), "13", cb_personDisease_13, et_personDisease_name_13, et_personDisease_date_13);
//        setPersonDisease(personInfo.getPersonInfoId(),"2",cb_personDisease_2,null,et_personDisease_date_2);

        /**
         * 全部不要sql  从personinFO 里面调取
         */
        List<PersonPastHistory> history = personInfo.getPersonPastHistory();

        for (int i = 0; i < history.size(); i++) {
            if ("1".equals(history.get(i).getHistoryType())) {
                if (1 == history.get(i).getOrderNo()) {
                    setPersonPastHistory(history.get(i), rb_choiceStatus11, rb_choiceStatus12, et_historyName11, et_confirmDate11);
                } else
                    setPersonPastHistory(history.get(i), rb_choiceStatus11, rb_choiceStatus12, et_historyName12, et_confirmDate12);
            }
            if ("2".equals(history.get(i).getHistoryType())) {
                if (1 == history.get(i).getOrderNo()) {
                    setPersonPastHistory(history.get(i), rb_choiceStatus21, rb_choiceStatus22, et_historyName21, et_confirmDate21);
                } else
                    setPersonPastHistory(history.get(i), rb_choiceStatus21, rb_choiceStatus22, et_historyName22, et_confirmDate22);
            }
            if ("3".equals(history.get(i).getHistoryType())) {
                if (1 == history.get(i).getOrderNo()) {
                    setPersonPastHistory(history.get(i), rb_choiceStatus31, rb_choiceStatus32, et_historyName31, et_confirmDate31);
                } else
                    setPersonPastHistory(history.get(i), rb_choiceStatus31, rb_choiceStatus32, et_historyName32, et_confirmDate32);
            }
        }
//        setPersonPastHistory(personInfo.getPersonPastHistory(), rb_choiceStatus11, rb_choiceStatus12, et_historyName11, et_confirmDate11, et_historyName12, et_confirmDate12);
//
//        list1 = sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).where(PersonPastHistoryDao.Properties.HistoryType.eq("2")).list();
//        setPersonPastHistory(list1, rb_choiceStatus21, rb_choiceStatus22, et_historyName21, et_confirmDate21, et_historyName22, et_confirmDate22);
//
//        list1 = sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).where(PersonPastHistoryDao.Properties.HistoryType.eq("3")).list();
//        setPersonPastHistory(list1, rb_choiceStatus31, rb_choiceStatus32, et_historyName31, et_confirmDate31, et_historyName32, et_confirmDate32);

        setCheckBoxSelect("familyDiseaseHistoryFather", personInfo.getRecordChoice(), ll_familyDiseaseHistoryFather); //父亲
        setCheckBoxSelect("familyDiseaseHistoryMother", personInfo.getRecordChoice(), ll_familyDiseaseHistoryMother); //母亲
        setCheckBoxSelect("familyDiseaseHistorySiblings", personInfo.getRecordChoice(), ll_familyDiseaseHistorySiblings);   //兄弟姐妹
        setCheckBoxSelect("familyDiseaseHistoryChildren", personInfo.getRecordChoice(), ll_familyDiseaseHistoryChildren);   //子女


        setRadioButtonSelect(personInfo.getGeneticDiseaseHistoryCode(), personInfo.getGeneticDiseaseHistoryName(), ll_geneticDiseaseHistory);  //遗传病史

        setCheckBoxSelect("disability", personInfo.getRecordChoice(), ll_disability); //残疾情况
        setCheckBoxSelect(personInfo.getKitchenExhaustCode(), ll_kitchenExhaust); //厨房排风设施
        setCheckBoxSelect("fuelType", personInfo.getRecordChoice(), ll_fuelType); //燃料类型
        setCheckBoxSelect("drinkWater", personInfo.getRecordChoice(), ll_drinkWater); //饮水
        setCheckBoxSelect(personInfo.getToiletCode(), ll_toilet); //厕所
        setCheckBoxSelect(personInfo.getLivestockFenceCode(), ll_livestockFence); //禽畜栏

        credentialAdapter.notifyDataSetChanged();
        tv_orgCode.setText(personInfo.getOrgCode());  //建档机构
        tv_creator.setText(personInfo.getCreator());  //建档人
        tv_createTime.setText(personInfo.getCreateTime());   //建档时间


        ScrollView sc_main = (ScrollView)mFuView.findViewById(R.id.sc_main);
        sc_main.scrollTo(0,0);
    }

    public boolean saveData(PersonInfo personInfo) {

        personInfo.getPersonDisease().clear();
        personInfo.getPersonPastHistory().clear();
//        personInfo.getPersonCredential().clear();
        personInfo.getRecordChoice().clear();

        if(btn_committee.getTag()==null||"".equals(btn_committee.getTag().toString())){
            ToastUtil.showToast(mContext, "请选择村居委会！", Toast.LENGTH_LONG);
            return false;
        }

        if ("".equals(et_name.getString())) {
            ToastUtil.showToast(mContext, "请输入姓名", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_birthday.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择出生日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_sex))) {
            ToastUtil.showToast(mContext, "请选择性别", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_residenceType))) {
            ToastUtil.showToast(mContext, "请选择长住类型", Toast.LENGTH_LONG);
            return false;
        }

        if ("".equals(getCheckBoxSimpleCode(ll_aboCode))) {
            ToastUtil.showToast(mContext, "请选择血型", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_educationCode))) {
            ToastUtil.showToast(mContext, "请选择文化程度", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_marriage))) {
            ToastUtil.showToast(mContext, "请选择婚姻状况", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;

        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_medicalPayWay); //医疗费用支付方式
        List<RecordChoice> choice = personInfo.getRecordChoice();
        for (int i = 0; i < choice.size(); i++) {
            if ("medicalPayWay".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择医疗费用支付方式", Toast.LENGTH_LONG);
            return false;
        }
        flag = true;
        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_drugAllergy);//药物过敏史

        choice = personInfo.getRecordChoice();
        for (int i = 0; i < choice.size(); i++) {
            if ("drugAllergy".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择药物过敏史", Toast.LENGTH_LONG);
            return false;
        }

        if ("".equals(getCheckBoxSimpleCode(ll_geneticDiseaseHistory))) {
            ToastUtil.showToast(mContext, "请选择遗传病史", Toast.LENGTH_LONG);
            return false;
        }

        flag = true;
        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_disability);//残疾情况
        choice = personInfo.getRecordChoice();
        for (int i = 0; i < choice.size(); i++) {
            if ("disability".equals(choice.get(i).getCodeType())) {
                if (choice.get(i).getCode().equals("2"))
                    personInfo.setIsDisabilityEyesight(1);
                if (choice.get(i).getCode().equals("3"))
                    personInfo.setIsDisabilityHearing(1);
                if (choice.get(i).getCode().equals("4"))
                    personInfo.setIsDisabilityLanguage(1);
                if (choice.get(i).getCode().equals("5"))
                    personInfo.setIsDisabilityLimbs(1);
                if (choice.get(i).getCode().equals("6"))
                    personInfo.setIsDisabilityBrain(1);
                if (choice.get(i).getCode().equals("7"))
                    personInfo.setIsDisabilityMind(1);
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择残疾情况", Toast.LENGTH_LONG);
            return false;
        }

        personInfo.setCommittee(btn_committee.getTag().toString());
        if (sp_residential.getSelectedItem() != null)
            personInfo.setResidential(((SpinnerItem) sp_residential.getSelectedItem()).getId());
        if (sp_building.getSelectedItem() != null)
            personInfo.setBuilding(((SpinnerItem) sp_building.getSelectedItem()).getId());

        personInfo.setName(et_name.getString()); //姓名
        personInfo.setFormerName(et_formerName.getString()); //曾用名
        personInfo.setIdNo(et_idNo.getString()); //身份证号
        personInfo.setBirthday(tv_birthday.getDate()); //出生日期
        personInfo.setSexCode(getCheckBoxSimpleCode(ll_sex));    //性别
        personInfo.setSexValue(getCheckBoxSimpleString(ll_sex));
        personInfo.setAddress(et_address.getString());  //家庭地址
        personInfo.setHouseholdAddress(et_householdAddress.getString()); //户籍地址
        personInfo.setTelNo(et_telNo.getString());    //本人电话
        personInfo.setFixedPhones(et_fixedPhones.getString());  //固定电话

        Checks checks = (Checks) sp_relation.getSelectedItem();
        personInfo.setRelationCode(checks.getCode());  //与户主关系
        personInfo.setRelationValue(checks.getValue());
        personInfo.setContactName(et_contactName.getString());  //联系人姓名
        personInfo.setContactTelNo(et_contactTelNo.getString());    //联系人电话
        personInfo.setWorkUnit(et_workUnit.getString()); //工作单位
        personInfo.setPaperArchiveDate(tv_paperArchiveDate.getDate()); //纸质档案建档时间
        personInfo.setPaperCardNum(et_paperCardNum.getString()); //纸质档案编号
        personInfo.setResidenceTypeCode(getCheckBoxSimpleCode(ll_residenceType));  //常住类型
        personInfo.setHouseholdTypeCode(getCheckBoxSimpleCode(ll_householdType));  //户籍类型
        Checks c = (Checks) sp_nationality.getSelectedItem();
        personInfo.setNationalityCode(c.getCode());//民族
        personInfo.setNationalityValue(c.getValue());
        personInfo.setAboCode(getCheckBoxSimpleCode(ll_aboCode));    //血型
        personInfo.setRhCode(getCheckBoxSimpleCode(ll_RHCode));
        personInfo.setEducationCode(getCheckBoxSimpleCode(ll_educationCode));  //文化程度
        personInfo.setOccupationCode(getCheckBoxSimpleCode(ll_occupation)); //职业
        personInfo.setMarriageCode(getCheckBoxSimpleCode(ll_marriage));   //婚姻状况

        if (save_update) {
//            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_medicalPayWay); //医疗费用支付方式
//            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_drugAllergy);    //药物过敏史
            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_exposureHistory);    //暴露史
        } else {
//            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_medicalPayWay); //医疗费用支付方式
//            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_drugAllergy);    //药物过敏史
            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_exposureHistory);    //暴露史
        }

//        saveCheckBoxMany(personInfo.getPersonInfoId(),list_recordChoice,ll_personDisease);  //疾病


        if (!cb_personDisease_1.isChecked()) {

            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_2, et_personDisease_date_2, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_3, et_personDisease_date_3, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_4, et_personDisease_date_4, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_5, et_personDisease_date_5, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_6, et_personDisease_date_6, et_personDisease_name_6);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_7, et_personDisease_date_7, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_8, et_personDisease_date_8, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_9, et_personDisease_date_9, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_10, et_personDisease_date_10, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_11, et_personDisease_date_11, null);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_12, et_personDisease_date_12, et_personDisease_name_12);
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_13, et_personDisease_date_13, et_personDisease_name_13);

        } else {
            getPersonDisease(null, personInfo.getPersonDisease(), cb_personDisease_1, null, null);
        }


        if (!getPersonPastHistory(null, personInfo.getPersonPastHistory(), "1", rb_choiceStatus11, rb_choiceStatus12, et_historyName11, et_confirmDate11, et_historyName12, et_confirmDate12)) //手术
            return false;
        if (!getPersonPastHistory(null, personInfo.getPersonPastHistory(), "2", rb_choiceStatus21, rb_choiceStatus22, et_historyName21, et_confirmDate21, et_historyName22, et_confirmDate22)) {//外伤
            return false;
        }
        if (!getPersonPastHistory(null, personInfo.getPersonPastHistory(), "3", rb_choiceStatus31, rb_choiceStatus32, et_historyName31, et_confirmDate31, et_historyName32, et_confirmDate32)) //输血
            return false;


        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_familyDiseaseHistoryFather); //父亲
        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_familyDiseaseHistoryMother); //母亲
        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_familyDiseaseHistorySiblings);   //兄弟姐妹
        saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_familyDiseaseHistoryChildren);   //子女


        personInfo.setGeneticDiseaseHistoryCode(getCheckBoxSimpleCode(ll_geneticDiseaseHistory));  //遗传病史
        personInfo.setGeneticDiseaseHistoryName(getLinearLayoutString(ll_geneticDiseaseHistory));

//        if (save_update) {
//            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_disability); //残疾情况
//        } else
//            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_disability); //残疾情况

        personInfo.setKitchenExhaustCode(getCheckBoxSimpleCode(ll_kitchenExhaust)); //厨房排风设施

        if (save_update) {
            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_fuelType);   //燃料类型
            saveCheckBoxMany(null, personInfo.getRecordChoice(), ll_drinkWater); //饮水
        } else {
            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_fuelType);   //燃料类型
            saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_drinkWater); //饮水
        }

//        mPersonInfo.getPersonCredential().clear();
        /**
         * 这个地方是保存personcredential  找到这个数据然后保存
         */
//        mPersonInfo.getPersonCredential().addAll()
        //厕所
        personInfo.setToiletCode(getCheckBoxSimpleCode(ll_toilet));
        //禽畜栏
        personInfo.setLivestockFenceCode(getCheckBoxSimpleCode(ll_livestockFence));
        personInfo.setOrgCode(tv_orgCode.getText().toString());  //建档机构
        personInfo.setCreator(tv_creator.getText().toString());  //建档人
        personInfo.setCreateTime(tv_createTime.getDate());   //建档时间

        if (save_update) {
            personInfo.setPersonInfoId(null);
        }

        return true;
    }


    @Override
    protected void initFuData() {

    }


    @Override
    protected void initWidget() {
        findView();


        // 民族
//        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CV9500.53")).orderAsc(ChecksDao.Properties.Code).list();
        List list = sqlHelper.getChecksByTerm("nation");
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_nationality.setAdapter(adapter);

        //与户主关系

//        list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CV0218.01")).orderAsc(ChecksDao.Properties.Code).list();
       list = sqlHelper.getChecksByTerm("relation");
        adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_relation.setAdapter(adapter);

        // 证件类型
//        list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("idType")).orderAsc(ChecksDao.Properties.Code).list();
        list = sqlHelper.getChecksByTerm("id_type");
        adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_credentialType.setAdapter(adapter);
        // 常住类型
        initCheckBoxSimple("HOUSEFLAG", ll_residenceType, 0);
        // 户籍类型
        initCheckBoxSimple("DOMICILE_TYPE", ll_householdType, 0);
        // 血型
        initCheckBoxSimple("aboCode", ll_aboCode, 5);
        // RH阴性
        initCheckBoxSimple("RHNEGATIVE", ll_RHCode, 3);
        // 文化程度
        initCheckBoxSimple("CULTUREDEGREE", ll_educationCode, 3);
        // 职业
        initCheckBoxSimple("MEMBERPROFESSION", ll_occupation, 1);
        // 婚姻
        initCheckBoxSimple("MARRIAGESTATUS", ll_marriage, 5);

        // 医疗费用
        initCheckBoxMany("medicalPayWay", ll_medicalPayWay, 2, false, true);
        // 药物过敏史
        initCheckBoxMany("drugAllergy", ll_drugAllergy, 5, false, true);
        // 暴露史
        initCheckBoxMany("exposureHistory", ll_exposureHistory, 4, false, false);
        //疾病类型
//        initCheckBoxMany("familyDiseaseHistoryFather", ll_familyDisease, 5, true, true);

//        // 家族史父亲
        initCheckBoxMany("familyDiseaseHistoryFather", ll_familyDiseaseHistoryFather, 3, true, true);
        // 家族史母亲
        initCheckBoxMany("familyDiseaseHistoryMother", ll_familyDiseaseHistoryMother, 3, true, true);
        // 家族史兄弟姐妹
        initCheckBoxMany("familyDiseaseHistorySiblings", ll_familyDiseaseHistorySiblings, 3, true, true);
        // 家族史子女
        initCheckBoxMany("familyDiseaseHistoryChildren", ll_familyDiseaseHistoryChildren, 3, true, true);


        // 遗传病史
        initCheckBoxSimple("YES_NO_CODE", ll_geneticDiseaseHistory, 2, false, true);
        // addEditText(ll_heredityDisease, 100, 100);
        // 残疾情况
        initCheckBoxMany("disability", ll_disability, 5, false, true);

        // 厨房排风设施
        initCheckBoxSimple("PERSON_KITCHEN_AIR", ll_kitchenExhaust, 4);
        // 燃料类型
        initCheckBoxMany("fuelType", ll_fuelType, 6, false, false);
        // 饮水
        initCheckBoxMany("drinkWater", ll_drinkWater, 4, false, false);
        // 厕所
        initCheckBoxSimple("TOILET", ll_toilet, 4);
        // 禽畜栏
        initCheckBoxSimple("PERSON_LIVESTOCK", ll_livestockFence, 4);

        // 性别代码
        initCheckBoxSimple("CV9500.48", ll_sex, 0);

        credentialAdapter = new CredentialAdapter(mContext);
        lv_card.setAdapter(credentialAdapter);

        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("新增人员");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void findView() {
        btn_committee = (FuButton) mFuView.findViewById(R.id.btn_committee);
        btn_committee.setOnClickListener(this);

//        sp_committee = (Spinner)mFuView.findViewById(R.id.sp_committee);//居委会
        sp_residential = (Spinner) mFuView.findViewById(R.id.sp_residential);   //小区


        sp_building = (Spinner) mFuView.findViewById(R.id.sp_building);  //楼栋

        setListener();

        et_name = (FuEditText) mFuView.findViewById(R.id.et_name); //姓名
        et_formerName = (FuEditText) mFuView.findViewById(R.id.et_formerName); //曾用名
        et_idNo = (FuEditText) mFuView.findViewById(R.id.et_idNo); //身份证号
        et_idNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                IdcardInfoExtractor idcardInfo = null;
                if(s.toString().trim().length()==15){
                    if(IdCardValidator.is15Idcard(s.toString())){
                        idcardInfo  =new IdcardInfoExtractor(s.toString().trim());
                    }
                }else if(s.toString().trim().length()==18){
                    if(IdCardValidator.isIdcard(s.toString())){
                        idcardInfo  =new IdcardInfoExtractor(s.toString().trim());
                    }
                }
                if(idcardInfo!=null){
                    tv_birthday.setText(idcardInfo.getBirthday());
                    setCheckBoxSelect(idcardInfo.getGender(), ll_sex);
                }
            }
        });
        tv_birthday = (FuTextView) mFuView.findViewById(R.id.tv_birthday); //出生日期
        tv_birthday.setOnClickListener(this);
        ll_sex = (LinearLayout) mFuView.findViewById(R.id.ll_sex);    //性别
        et_address = (FuEditText) mFuView.findViewById(R.id.et_address);  //家庭地址
        et_householdAddress = (FuEditText) mFuView.findViewById(R.id.et_householdAddress); //户籍地址
        et_telNo = (FuEditText) mFuView.findViewById(R.id.et_telNo);    //本人电话
        et_fixedPhones = (FuEditText) mFuView.findViewById(R.id.et_fixedPhones);  //固定电话
        sp_relation = (Spinner) mFuView.findViewById(R.id.sp_relation);  //与户主关系
        et_contactName = (FuEditText) mFuView.findViewById(R.id.et_contactName);  //联系人姓名
        et_contactTelNo = (FuEditText) mFuView.findViewById(R.id.et_contactTelNo);    //联系人电话
        et_workUnit = (FuEditText) mFuView.findViewById(R.id.et_workUnit); //工作单位
        tv_paperArchiveDate = (FuTextView) mFuView.findViewById(R.id.tv_paperArchiveDate); //纸质档案建档时间
        tv_paperArchiveDate.setOnClickListener(this);
        et_paperCardNum = (FuEditText) mFuView.findViewById(R.id.et_paperCardNum); //纸质档案编号
        ll_residenceType = (LinearLayout) mFuView.findViewById(R.id.ll_residenceType);  //常住类型
        ll_householdType = (LinearLayout) mFuView.findViewById(R.id.ll_householdType);  //户籍类型
        sp_nationality = (Spinner) mFuView.findViewById(R.id.sp_nationality);   //民族
        ll_aboCode = (LinearLayout) mFuView.findViewById(R.id.ll_aboCode);    //血型
        ll_RHCode = (LinearLayout) mFuView.findViewById(R.id.ll_RHCode);    //RH血型
        ll_educationCode = (LinearLayout) mFuView.findViewById(R.id.ll_educationCode);  //文化程度
        ll_occupation = (LinearLayout) mFuView.findViewById(R.id.ll_occupation); //职业
        ll_marriage = (LinearLayout) mFuView.findViewById(R.id.ll_marriage);   //婚姻状况
        ll_medicalPayWay = (LinearLayout) mFuView.findViewById(R.id.ll_medicalPayWay);  //医疗费用支付方式
        ll_drugAllergy = (LinearLayout) mFuView.findViewById(R.id.ll_drugAllergy);    //药物过敏史
        ll_exposureHistory = (LinearLayout) mFuView.findViewById(R.id.ll_exposureHistory);    //暴露史
        ll_personDisease = (LinearLayout) mFuView.findViewById(R.id.ll_personDisease);  //疾病

        //手术
        rb_choiceStatus11 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus11);
        rb_choiceStatus12 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus12);
        et_historyName11 = (FuEditText) mFuView.findViewById(R.id.et_historyName11);
        et_confirmDate11 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate11);
        et_historyName12 = (FuEditText) mFuView.findViewById(R.id.et_historyName12);
        et_confirmDate12 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate12);
        //外伤
        rb_choiceStatus21 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus21);
        rb_choiceStatus22 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus22);
        et_historyName21 = (FuEditText) mFuView.findViewById(R.id.et_historyName21);
        et_confirmDate21 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate21);
        et_historyName22 = (FuEditText) mFuView.findViewById(R.id.et_historyName22);
        et_confirmDate22 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate22);
        //输血
        rb_choiceStatus31 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus31);
        rb_choiceStatus32 = (RadioButton) mFuView.findViewById(R.id.rb_choiceStatus32);
        et_historyName31 = (FuEditText) mFuView.findViewById(R.id.et_historyName31);
        et_confirmDate31 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate31);
        et_historyName32 = (FuEditText) mFuView.findViewById(R.id.et_historyName32);
        et_confirmDate32 = (FuEditText) mFuView.findViewById(R.id.et_confirmDate32);

        ll_familyDiseaseHistoryFather = (LinearLayout) mFuView.findViewById(R.id.ll_familyDiseaseHistoryFather); //父亲
        ll_familyDiseaseHistoryMother = (LinearLayout) mFuView.findViewById(R.id.ll_familyDiseaseHistoryMother); //母亲
        ll_familyDiseaseHistorySiblings = (LinearLayout) mFuView.findViewById(R.id.ll_familyDiseaseHistorySiblings);   //兄弟姐妹
        ll_familyDiseaseHistoryChildren = (LinearLayout) mFuView.findViewById(R.id.ll_familyDiseaseHistoryChildren);   //子女


        ll_geneticDiseaseHistory = (LinearLayout) mFuView.findViewById(R.id.ll_geneticDiseaseHistory);  //遗传病史
        ll_disability = (LinearLayout) mFuView.findViewById(R.id.ll_disability); //残疾情况
        ll_kitchenExhaust = (LinearLayout) mFuView.findViewById(R.id.ll_kitchenExhaust); //厨房排风设施
        ll_fuelType = (LinearLayout) mFuView.findViewById(R.id.ll_fuelType);   //燃料类型
        ll_drinkWater = (LinearLayout) mFuView.findViewById(R.id.ll_drinkWater); //饮水
        ll_toilet = (LinearLayout) mFuView.findViewById(R.id.ll_toilet); //厕所
        ll_livestockFence = (LinearLayout) mFuView.findViewById(R.id.ll_livestockFence); //禽畜栏

        sp_credentialType = (Spinner) mFuView.findViewById(R.id.sp_credentialType);//证件类型
        et_credentialNo = (FuEditText) mFuView.findViewById(R.id.et_credentialNo);//证件号码
        btn_addCredential = (FuButton) mFuView.findViewById(R.id.btn_addCredential);//增加证件
        btn_addCredential.setOnClickListener(this);

        tv_orgCode = (FuTextView) mFuView.findViewById(R.id.tv_orgCode);  //建档机构
        tv_creator = (FuTextView) mFuView.findViewById(R.id.tv_creator);  //建档人
        tv_createTime = (FuTextView) mFuView.findViewById(R.id.tv_createTime);   //建档时间
        tv_createTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(tv_createTime)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
            }
        });

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

        lv_card = (FuListView) mFuView.findViewById(R.id.lv_card);//证件
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_residential:
                if (!canTouch) {
                    return;
                }
                String subId = ((SpinnerItem) sp_residential.getSelectedItem()).getId();
                setAddress();
                if (saBuilding != null)
                    saBuilding.clearn();

                if (subId == null || "".equals(subId))
                    return;
                mEventCallBack.EventClick(FuMemberAddFragment.EVENT_GET_BUILDING, subId);

                break;
            case R.id.sp_building:
                if (!canTouch) {
                    return;
                }
                setAddress();

                String buildingId = ((SpinnerItem) sp_building.getSelectedItem()).getId();
                if (buildingId == null || "".equals(buildingId))
                    return;
                break;
        }
    }

    public void setSubdistricts(List<SpinnerItem> subdistrictsList) {

        if (saSubdistricts == null) {
            saSubdistricts = new SpinnerAdapter(mContext, subdistrictsList);
            sp_residential.setAdapter(saSubdistricts);
            saSubdistricts.notifyDataSetChanged();
        } else {
            saSubdistricts.setDataChanged(subdistrictsList);
        }
    }

    public void setBuildings(List<SpinnerItem> subBuildings) {

        if (saBuilding == null) {
            saBuilding = new SpinnerAdapter(mContext, subBuildings);
            sp_building.setAdapter(saBuilding);
            saBuilding.notifyDataSetChanged();
        } else {
            saBuilding.setDataChanged(subBuildings);
        }
    }

    public void setAddress() {
        String committee = btn_committee.getText().toString();
        String sub = sp_residential.getSelectedItem() == null ? "" : ((SpinnerItem) sp_residential.getSelectedItem()).getValue();
        String build = sp_building.getSelectedItem() == null ? "" : ((SpinnerItem) sp_building.getSelectedItem()).getValue();

        et_address.setText(committee + sub + build);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class CredentialAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public CredentialAdapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mPersonInfo == null || mPersonInfo.getPersonCredential() == null ? 0 : mPersonInfo.getPersonCredential().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_card_item, null);
                holder = new HealthExamInhosHolder();
                holder.tv_type = (FuTextView) convertView.findViewById(R.id.tv_type);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_type.setText(mPersonInfo.getPersonCredential().get(position).getCredentialTypeValue());
            holder.tv_num.setText(mPersonInfo.getPersonCredential().get(position).getCredentialNo());
            holder.tv_delete.setText("删除");


            if ("18".equals(mPersonInfo.getPersonCredential().get(position).getCredentialTypeCode()) || "19".equals(mPersonInfo.getPersonCredential().get(position).getCredentialTypeCode())) {
                holder.tv_delete.setTextColor(Color.GRAY);
                holder.tv_delete.setTag("delete");
            }else{
                holder.tv_delete.setTextColor(Color.BLACK);
                holder.tv_delete.setTag(position);
            }

            holder.tv_delete.setOnClickListener(FuMemberAddView.this);
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_type;       //接种日期
            FuTextView tv_num;      //接种机构
            FuTextView tv_delete;             // 删除
        }

    }

    public void setListener() {
        sp_residential.setOnItemSelectedListener(this);
        sp_building.setOnItemSelectedListener(this);
    }


}
