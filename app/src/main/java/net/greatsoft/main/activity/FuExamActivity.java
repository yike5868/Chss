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
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.helper.HealthExamDao;
import net.greatsoft.main.db.helper.RecordChoiceDao;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.RecordChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 16/8/4.
 */
public class FuExamActivity extends FuParentActivity implements FragmentSave,View.OnClickListener{

    public static final String INTENT_BUNDLE = "intent_bundle";
    private List<FragmentParent> mFragmentList = new ArrayList<FragmentParent>();
    private FragmentAdapter mFragmentAdapter;
    private TextView fu_title_center;

    private ViewPager mPageVp;
    ALocalSqlHelper sqlHelper;

    private HealthExam healthExam;  //体检信息

    private ArrayList<RecordChoice> list_recordChoice;//多选框

    HealthExamDao healthExamDao;//体检dao

    RecordChoiceDao recordChoiceDao; //多选框dao


    //选择页面的标题text
    RadioGroup rg_switch;
    private String[] titles;  //标题
    private RadioButton[] rb_list; //设置选择的title

    Button fu_title_right_btn;//保存按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fu_change_activity);
        findById();

        sqlHelper = ((FuApp)getApplication()).getSqlHelper();

        //获取dao
        healthExamDao = sqlHelper.getHealthExamDao();
        recordChoiceDao = sqlHelper.getRecordChoiceDao();

        //只做保存作用
        list_recordChoice = new ArrayList<>();

        //后期需要删除  改成正式的
        List healthExams = healthExamDao.queryBuilder().build().list();
        if(healthExams == null || healthExams.size()<1){
            healthExam = new HealthExam();
            healthExam.setHealthExamId(UUID.randomUUID().toString());
        }else{
            healthExam =(HealthExam)healthExams.get(healthExams.size()-1);
        }
        Bundle bundle = getIntent().getBundleExtra(INTENT_BUNDLE);

        fu_title_center = (TextView)findViewById(R.id.fu_title_center);
        fu_title_center.setText(bundle.getString("title"));
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button)findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");

        fu_title_right_btn.setOnClickListener(this);

        titles = bundle.getStringArray("titles");
//        Class<FragmentParent>[] cls = (Class<FragmentParent>[]) bundle.getSerializable("classes");
        ArrayList<Class> cls = (ArrayList) bundle.getSerializable("classes");

        for (int i = 0; i < cls.size(); i++) {
            try {
                FragmentParent fp = (FragmentParent)cls.get(i).newInstance();
                mFragmentList.add(fp);
            } catch (InstantiationException e1) {

            } catch (IllegalAccessException e1) {

            }
        }
        init();
    }

    private void findById() {
        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
        rg_switch = (RadioGroup)this.findViewById(R.id.rg_switch);
    }

    private void init() {


        rb_list = new RadioButton[titles.length];
        LayoutInflater inflater =  getLayoutInflater();
        for (int i = 0;i<titles.length;i++){
            // R
            RadioButton rb = (RadioButton) inflater.inflate(R.layout.fu_change_title_radiobutton,null);
            rb_list[i] = rb;
            rb.setText(titles[i]);
            rb.setButtonDrawable(null);
            rb.setTag(i);
            if(i==0) {
                rb.setChecked(true);
                rb.setBackgroundResource(R.drawable.change_title_left);
            }
            else if(i==titles.length-1)
                rb.setBackgroundResource(R.drawable.change_title_right);
            else
                rb.setBackgroundResource(R.drawable.change_title_center);
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

                if(position == mFragmentList.size()-1)
                    fu_title_right_btn.setVisibility(View.VISIBLE);
                else
                    fu_title_right_btn.setVisibility(View.GONE);

                for (int i = 0 ;i<rb_list.length ;i++){
                    rb_list[i].setChecked(false);
                }
                rb_list[position].setChecked(true);
            }
        });
    }

    @Override
    public boolean saveData() {
        for (int i = 0;i<mFragmentList.size();i++){
            FragmentSave fs = (FragmentSave)mFragmentList.get(i);
            fs.saveData();

        }
        healthExamDao = sqlHelper.getHealthExamDao();
        healthExamDao.insertOrReplace(healthExam);
        recordChoiceDao.queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(healthExam.getHealthExamId())).buildDelete().executeDeleteWithoutDetachingEntities();
        recordChoiceDao.insertInTx(list_recordChoice);
        FuExamActivity.this.finish();
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fu_title_right_btn:
                saveData();
                break;
        }
    }

    public HealthExam getHealthExam() {
        return healthExam;
    }
    public ArrayList<RecordChoice> getList_recordChoice() {
        return list_recordChoice;
    }
    public void setHealthExam(HealthExam healthExam) {
        this.healthExam = healthExam;
    }

}

