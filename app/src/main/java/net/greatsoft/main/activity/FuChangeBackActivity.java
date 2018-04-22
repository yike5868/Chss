package net.greatsoft.main.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.R;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.helper.FamilyEconomicDao;
import net.greatsoft.main.db.helper.FamilyInfoDao;
import net.greatsoft.main.db.helper.PersonCredentialDao;
import net.greatsoft.main.db.helper.PersonDiseaseDao;
import net.greatsoft.main.db.helper.PersonInfoDao;
import net.greatsoft.main.db.helper.PersonPastHistoryDao;
import net.greatsoft.main.db.helper.RecordChoiceDao;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.person.Person;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 16/8/4.
 */
public class FuChangeBackActivity extends FuParentActivity implements FragmentSave, View.OnClickListener {

    public static final String INTENT_BUNDLE = "intent_bundle";
    private List<FragmentParent> mFragmentList = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;

    private ViewPager mPageVp;

    //选择页面的标题text
    RadioGroup rg_switch;
    private String[] titles;  //标题
    private RadioButton[] rb_list; //设置选择的title


    /**
     * 公共相关
     */
    ALocalSqlHelper sqlHelper;
    private int type;

    private List<RecordChoice> list_recordChoice;//多选框

    /**
     * 体检相关
     */
    private HealthExam healthExam;  //体检信息



    Button fu_title_right_btn;//保存按钮


    /**
     * 个人相关
     */
    Person person;
    PersonInfo personInfo;
    List<PersonDisease> list_personDisease;
    List<PersonPastHistory> list_personPastHistory;
    List<PersonCredential> list_personCredential;
    String personInfoId;


    /**
     * 高血压 糖尿病 随访相关
     */

    private HyperFollowup hyperFollowup;    //高血压随访信息
    private HyperFollowup oHyperFollowup;   //上次高血压随访信息
    private DiabetesFollowup diabetesFollowup;//糖尿病随访
    private DiabetesFollowup oDiabetesFollowup;//上次糖尿病随访


    /**
     * 家庭相关
     */
    private FamilyInfo familyInfo;
    private FamilyEconomic familyEconomic;//家庭经济状况信息表
    private ArrayList<FamilyCredential> mList_familyCredential;//证件


    RoomAll roomAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fu_change_activity);
        findById();

        sqlHelper = ((FuApp) getApplication()).getSqlHelper();

        Bundle bundle = getIntent().getBundleExtra(INTENT_BUNDLE);
        titles = bundle.getStringArray("titles");   //副标题
        String title = bundle.getString("title");   //主标题
        type = bundle.getInt("type");
        getData(bundle);
        TextView fu_title_center = (TextView) findViewById(R.id.fu_title_center);
        fu_title_center.setText(title);


        ArrayList<Class> cls = (ArrayList) bundle.getSerializable("classes");

        for (int i = 0; i < cls.size(); i++) {
            try {
                FragmentParent fp = (FragmentParent) cls.get(i).newInstance();
                mFragmentList.add(fp);
            } catch (InstantiationException e1) {

            } catch (IllegalAccessException e1) {

            }
        }

        init();

    }

    public void getData(Bundle bundle) {
        switch (type) {
            //体检
            case FuUiFrameManager.FU_S_EXAM:
                getExams(bundle);
                break;
            //高血压 糖尿病 随访
            case FuUiFrameManager.FU_S_LGT:
                getDHY(bundle);
                break;
            //增加家庭
            case FuUiFrameManager.FU_FAMILY_ADD:
                getFamilyAdd(bundle);
                break;
            //增加人员
            case FuUiFrameManager.FU_MEMBER_ADD:
                getMember(bundle);
                break;
        }
    }

    /**
     * 高血压 糖尿病随访
     */

    private void getDHY(Bundle bundle) {

        //只做保存作用
        list_recordChoice = new ArrayList<>();

        oHyperFollowup = new HyperFollowup();
        oDiabetesFollowup = new DiabetesFollowup();

        personInfoId = bundle.getString("personInfoId");


//        hyperFollowup = sqlHelper.getHyperFollowupByPersonInfoId(personInfoId);
        List hyperFollowups = sqlHelper.getHyperFollowupListByPersonInfoId(personInfoId);
        if (hyperFollowups == null || hyperFollowups.size() < 1) {
            hyperFollowup = new HyperFollowup();
            hyperFollowup.setHyperFollowupId(UUID.randomUUID().toString());
        } else {
            hyperFollowup = (HyperFollowup) hyperFollowups.get(hyperFollowups.size() - 1);
        }

        List diabetesFollowups = sqlHelper.getDiabetesFollowupListByPersonInfoId(personInfoId);
        if (diabetesFollowups == null || diabetesFollowups.size() < 1) {
            diabetesFollowup = new DiabetesFollowup();
            diabetesFollowup.setDiabetesFollowupId(UUID.randomUUID().toString());
        } else {
            diabetesFollowup = (DiabetesFollowup) diabetesFollowups.get(hyperFollowups.size() - 1);
        }
    }

    /**
     * 体检相关
     */
    private void getExams(Bundle bundle) {

        //只做保存作用

        personInfoId = bundle.getString("personInfoId");
        //后期需要删除  改成正式的
        List healthExams = sqlHelper.getHealthExamListByPersonInfoId(personInfoId);
        if (healthExams == null || healthExams.size() < 1) {
            healthExam = new HealthExam();
            healthExam.setHealthExamId(UUID.randomUUID().toString());
            list_recordChoice = new ArrayList<>();
        } else {
            healthExam = (HealthExam) healthExams.get(healthExams.size() - 1);
            list_recordChoice = sqlHelper.getRecordChoiceByTableKey(personInfoId);
        }
    }

    /**
     * 家庭相关
     */
    private void getFamilyAdd(Bundle bundle) {
        mList_familyCredential = new ArrayList<>();
        if (bundle == null) {
            String id = UUID.randomUUID().toString();
            familyInfo = new FamilyInfo();
            familyInfo.setFamilyInfoId(id);
            familyEconomic = new FamilyEconomic();
            familyEconomic.setFamilyEconomicId(id);

        } else {
            if (bundle.getSerializable("room") != null) {
                roomAll = (RoomAll) bundle.getSerializable("room");
                String id = UUID.randomUUID().toString();
                familyInfo = new FamilyInfo();
                familyInfo.setFamilyInfoId(id);
                familyEconomic = new FamilyEconomic();
                familyEconomic.setFamilyEconomicId(id);
            } else if (bundle.getString("familyInfoId") != null) {
                String familyInfoId = bundle.getString("familyInfoId");
                familyInfo = sqlHelper.getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfoId)).list().get(0);
                familyEconomic = sqlHelper.getFamilyEconomicByFamilyInfoId(familyInfoId);

            } else {
                String id = UUID.randomUUID().toString();
                familyInfo = new FamilyInfo();
                familyInfo.setFamilyInfoId(id);
                familyEconomic = new FamilyEconomic();
                familyEconomic.setFamilyEconomicId(id);
            }
        }

        list_recordChoice = new ArrayList<>();
    }

    /**
     * 人员相关
     */
    public void getMember(Bundle bundle) {
        if (bundle == null) {
            String id = UUID.randomUUID().toString();
            personInfo = new PersonInfo();
            person = new Person();
            personInfo.setPersonInfoId(id);
            list_recordChoice = new ArrayList<>();
        } else {
            String familyInfoId = bundle.getString("familyInfoId");
            if (familyInfoId == null) {
                personInfoId = bundle.getString("personInfoId");
                if (personInfoId == null) {
                    personInfo = new PersonInfo();
                    personInfo.setFamilyInfoId(familyInfoId);
                    personInfoId = UUID.randomUUID().toString();
                    personInfo.setPersonInfoId(personInfoId);
                    list_recordChoice = new ArrayList<>();
                    list_personDisease = new ArrayList<>();
                    list_personPastHistory = new ArrayList<>();
                    list_personCredential = new ArrayList<>();
                } else {
                    personInfo = sqlHelper.getPersonInfoByPersonInfoId(personInfoId);
                    list_recordChoice = sqlHelper.getRecordChoiceByTableKey(personInfoId);
                    list_personDisease = sqlHelper.getPersonDiseaseByPersonInfoId(personInfoId);
                    list_personPastHistory = sqlHelper.getPersonPastHistoryByPersonInfoId(personInfoId);
                    list_personCredential = sqlHelper.getPersonCredentialByPersonInfoId(personInfoId);
                }
            } else {
                personInfo = new PersonInfo();

                personInfo.setFamilyInfoId(familyInfoId);
                personInfoId = UUID.randomUUID().toString();
                personInfo.setPersonInfoId(personInfoId);


                list_recordChoice = new ArrayList<>();
                list_personDisease = new ArrayList<>();
                list_personPastHistory = new ArrayList<>();
                list_personCredential = new ArrayList<>();
            }

        }

    }


    private void findById() {
        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
        rg_switch = (RadioGroup) this.findViewById(R.id.rg_switch);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                saveData();
                FuChangeBackActivity.this.finish();
                break;
        }
    }


    @Override
    public boolean saveData() {
        switch (type) {
            //体检
            case FuUiFrameManager.FU_S_EXAM:
                saveExam();
                break;
            //高血压 糖尿病 随访
            case FuUiFrameManager.FU_S_LGT:
                saveDHY();
                break;
            //增加家庭
            case FuUiFrameManager.FU_FAMILY_ADD:
                saveFamilyAdd();
                break;
            //增加人员
            case FuUiFrameManager.FU_MEMBER_ADD:
                saveMemberAdd();
                break;
        }
        return false;
    }

    /**
     * 保存体检
     *
     * @return
     */
    public boolean saveExam() {

        list_recordChoice.clear();
        for (int i = 0; i < mFragmentList.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragmentList.get(i);
            fs.saveData();

        }

        sqlHelper.insertHealthExam(healthExam);
        sqlHelper.insertRecordChoiceList(list_recordChoice);
//        recordChoiceDao.queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(healthExam.getHealthExamId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        recordChoiceDao.insertInTx(list_recordChoice);

        return true;
    }

    /**
     * 保存高糖随访
     *
     * @return
     */
    public boolean saveDHY() {

        list_recordChoice.clear();

        for (int i = 0; i < mFragmentList.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragmentList.get(i);
            fs.saveData();
        }
        sqlHelper.insertRecordChoiceList(list_recordChoice);
        sqlHelper.insertHyperFollowup(hyperFollowup);
        sqlHelper.insertDiabetesFollowup(diabetesFollowup);
        return true;
    }

    /**
     * 保存家庭
     *
     * @return
     */
    public boolean saveFamilyAdd() {
        list_recordChoice.clear();
        mList_familyCredential.clear();

        for (int i = 0; i < mFragmentList.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragmentList.get(i);
            fs.saveData();
        }
        sqlHelper.getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getFamilyEconomicDao().queryBuilder().where(FamilyEconomicDao.Properties.FamilyEconomicId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();

        sqlHelper.getFamilyInfoDao().insert(familyInfo);
        sqlHelper.getFamilyEconomicDao().insert(familyEconomic);
        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
        sqlHelper.getFamilyCredentialDao().insertInTx(mList_familyCredential);
        return true;
    }

    public boolean saveMemberAdd() {

        list_recordChoice.clear();
        list_personDisease.clear();
        list_personPastHistory.clear();
        list_personCredential.clear();

        for (int i = 0; i < mFragmentList.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragmentList.get(i);
            fs.saveData();
        }

        sqlHelper.getPersonInfoDao().queryBuilder().where(PersonInfoDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getPersonPastHistoryDao().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getPersonDiseaseDao().queryBuilder().where(PersonDiseaseDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getPersonCredentialDao().queryBuilder().where(PersonCredentialDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getPersonPastHistoryDao().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();


        sqlHelper.getPersonInfoDao().insert(personInfo);
        sqlHelper.getPersonDiseaseDao().insertInTx(list_personDisease);
        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
        sqlHelper.getPersonPastHistoryDao().insertInTx(list_personPastHistory);
        sqlHelper.getPersonCredentialDao().insertInTx(list_personCredential);
        return true;
    }


    private void init() {

        rb_list = new RadioButton[titles.length];
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i < titles.length; i++) {
            RadioButton rb = (RadioButton) inflater.inflate(R.layout.fu_change_title_radiobutton, null);
            rb_list[i] = rb;
            rb.setText(titles[i]);
            rb.setButtonDrawable(null);
            rb.setTag(i);
            RadioGroup.LayoutParams txtOneparams = new RadioGroup.LayoutParams(20, getIntFromDimens(R.dimen.radio_title_height), 1.0f);
            rb.setLayoutParams(txtOneparams);
            if (i == 0) {
                rb.setChecked(true);
            }
            rg_switch.addView(rb);
        }

        mFragmentAdapter = new FragmentAdapter(
                this.getSupportFragmentManager(), mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);

        mPageVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }

            /**
             * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
             * offsetPixels:当前页面偏移的像素位置
             */
            @Override
            public void onPageScrolled(int position, float offset,
                                       int offsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                if (position == mFragmentList.size() - 1)
                    fu_title_right_btn.setVisibility(View.VISIBLE);
                else
                    fu_title_right_btn.setVisibility(View.GONE);

                for (int i = 0; i < rb_list.length; i++) {
                    rb_list[i].setChecked(false);
                }
                rb_list[position].setChecked(true);
            }
        });

        fu_title_right_btn = (Button) findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setOnClickListener(this);
    }


    /**
     * 公共相关
     */

    public List<RecordChoice> getList_recordChoice() {
        return list_recordChoice;
    }

    /**
     * 体检相关
     */
    public HealthExam getHealthExam() {
        return healthExam;
    }

    public void setHealthExam(HealthExam healthExam) {
        this.healthExam = healthExam;
    }

    /**
     * 随访相关
     */
    public HyperFollowup getHyperFollowup() {
        return hyperFollowup;
    }

    public HyperFollowup getoHyperFollowup() {
        return oHyperFollowup;
    }

    public DiabetesFollowup getDiabetesFollowup() {
        return diabetesFollowup;
    }

    public DiabetesFollowup getoDiabetesFollowup() {
        return oDiabetesFollowup;
    }

    /**
     * 家庭相关
     */
    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    public FamilyEconomic getFamilyEconomic() {
        return familyEconomic;
    }

    public void setFamilyEconomic(FamilyEconomic familyEconomic) {
        this.familyEconomic = familyEconomic;
    }

    public ArrayList<FamilyCredential> getmList_familyCredential() {
        return mList_familyCredential;
    }

    public void setmList_familyCredential(ArrayList<FamilyCredential> mList_familyCredential) {
        this.mList_familyCredential = mList_familyCredential;
    }

    public RoomAll getRoomAll() {
        return roomAll;
    }

    public void setRoomAll(RoomAll roomAll) {
        this.roomAll = roomAll;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<PersonDisease> getList_personDisease() {
        return list_personDisease;
    }

    public void setList_personDisease(ArrayList<PersonDisease> list_personDisease) {
        this.list_personDisease = list_personDisease;
    }

    public List<PersonPastHistory> getList_personPastHistory() {
        return list_personPastHistory;
    }

    public void setList_personPastHistory(ArrayList<PersonPastHistory> list_personPastHistory) {
        this.list_personPastHistory = list_personPastHistory;
    }

    public List<PersonCredential> getList_personCredential() {
        return list_personCredential;
    }

    public void setList_personCredential(List<PersonCredential> list_personCredential) {
        this.list_personCredential = list_personCredential;
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

}

