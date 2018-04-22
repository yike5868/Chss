package net.greatsoft.main.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.umeng.analytics.MobclickAgent;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.R;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.po.AndroidFileRecord;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.NetCallBack;
import net.greatsoft.main.net.NetManager;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/4.
 */
public class FuChangeActivity extends FuParentActivity implements FragmentSave, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    public static final String INTENT_BUNDLE = "intent_bundle";
    private List<FragmentParent> mFragmentList = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;

    private ViewPager mPageVp;

    private static final int NET_ERROR = 500;

    //选择页面的标题text
    RadioGroup rg_switch;
    private String[] titles;  //标题
    private RadioButton[] rb_list; //设置选择的title

    String personInfoId;
    String personInfoName;

    /**
     * 照相相关
     */

    File file;

    /**
     * 公共相关
     */
    ALocalSqlHelper sqlHelper;
    private int type;
    /**
     * 人员相关
     */
    private PersonInfo personInfo;//个人信息

    /**
     * 体检相关
     */
    private HealthExam healthExam;  //体检信息


    Button fu_title_right_btn;//保存按钮


    RoomAll roomAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fu_change_activity);

        getScreenSizeOfDevice();

        findById();

        sqlHelper = ((FuApp) getApplication()).getSqlHelper();

        Bundle bundle = getIntent().getBundleExtra(INTENT_BUNDLE);
        titles = bundle.getStringArray("titles");   //副标题
        String title = bundle.getString("title");   //主标题
        type = bundle.getInt("type");
        file = (File) bundle.getSerializable("file");
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

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);//友盟统计需要
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);//友盟统计需要
    }

    public void getData(Bundle bundle) {
        switch (type) {
            //体检
            case FuUiFrameManager.FU_S_EXAM:
                getExams(bundle);
                break;

        }
    }


    /**
     * 体检相关
     */
    private void getExams(Bundle bundle) {

        //只做保存作用
        personInfoId = bundle.getString("personInfoId");
        personInfoName = bundle.getString("personInfoName");
        personInfo = (PersonInfo) bundle.getSerializable("personInfo");
//        FamilyInfo familyInfo = sqlHelper.getFamilyInfoByFamilyInfoId(personInfo.getFamilyInfoId());
        healthExam = new HealthExam();
//        healthExam.setRespDoctorId(familyInfo.getRespDoctorId());
        healthExam.setName(personInfoName);
//            healthExam.setHealthExamId(UUID.randomUUID().toString());

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
//                FuChangeActivity.this.finish();
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
        }
        return false;
    }

    /**
     * 保存体检
     *
     * @return
     */
    public boolean saveExam() {

        for (int i = 0; i < mFragmentList.size(); i++) {
            FragmentSave fs = (FragmentSave) mFragmentList.get(i);
            if (!fs.saveData())
                return false;

        }

        sqlHelper.insertHealthExam(healthExam);

        MyTask lTask = TaskManager.getInstace(FuChangeActivity.this)
                .saveExam(new mNetCallBack(), healthExam, FuChangeActivity.this);

        excuteNetTask(lTask, false);

        return true;
    }

    public void excuteNetTask(final MyTask lTask, boolean animRefresh) {

        if (!animRefresh) {

            ToolUtil.showPopWindowLoading(FuChangeActivity.this);
        }

        Runnable netRunnable = new Runnable() {

            @Override
            public void run() {

                NetManager manager = NetManager.getInstance(FuChangeActivity.this);
                manager.addNetTask(lTask);
                manager.excuteNetTask(lTask);

            }
        };

        mHandler.post(netRunnable);

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case NET_ERROR:
                    ToastUtil.showToast(FuChangeActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.SAVE_HEALTH_EXAM:
                    savePics(healthExam.getHealthExamId(), Constant.SERVICE_ITEM_1004, file);
//                    ToastUtil.showToast(FuChangeActivity.this, "保存成功!", Toast.LENGTH_SHORT);
//                    FuChangeActivity.this.finish();
                    break;
                case MyTask.UP_LOAD_FILE:
                    ToastUtil.showToast(FuChangeActivity.this, "保存成功!", Toast.LENGTH_LONG);
                    FuChangeActivity.this.finish();
                    break;
            }
        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            int i = Integer.parseInt(buttonView.getTag().toString());
            mPageVp.setCurrentItem(i);
        }
    }

    class mNetCallBack implements NetCallBack {

        @Override
        public void cancel(int taskId) {
            Log.e("ddddd", "eeeeeeeeee");
        }

        @Override
        public void loadData(int taskId, FuResponse rspObj) {
            Message fmg = Message.obtain(mHandler);

            if (rspObj == null || rspObj.getCode() == null) {
                fmg.what = NET_ERROR;
                if (rspObj.getMessage() == null) {
                    fmg.obj = "网络连接错误";
                }
                fmg.sendToTarget();
                return;
            } else if (!"0".equals(rspObj.getCode())) {
                fmg.what = NET_ERROR;
                fmg.obj = rspObj.getMessage();
                fmg.sendToTarget();
                return;
            }

            switch (taskId) {
                case MyTask.SAVE_HEALTH_EXAM:
                    fmg.what = taskId;
                    healthExam = JSON.parseObject(rspObj.getResult(), HealthExam.class);
                    fmg.sendToTarget();
                    break;

                case MyTask.UP_LOAD_FILE:
                    fmg.what = taskId;
                    fmg.sendToTarget();
                    return;
            }
        }

        @Override
        public void netError(int taskId, String msg) {
            Message fmg = Message.obtain(mHandler);
            fmg.what = NET_ERROR;
            if (msg == null) {
                fmg.obj = "网络连接错误";
            } else {
                fmg.obj = msg;
            }
            fmg.sendToTarget();
        }
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
            rb.setOnCheckedChangeListener(this);
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
//        fu_title_right_btn.setVisibility(View.VISIBLE);
    }

    public void savePics(String fuId, String fuType, File file) {

        if (isCan_pic()) {
            AndroidFileRecord androidFileRecord = new AndroidFileRecord();
            androidFileRecord.setReferenceKey(fuId);
            androidFileRecord.setServiceItemId(fuType);

            File[] files = new File[1];
            files[0] = file;
            MyTask lTask = TaskManager.getInstace(FuChangeActivity.this)
                    .savePics(new mNetCallBack(), androidFileRecord, FuChangeActivity.this, files);

            excuteNetTask(lTask, false);
        } else {
            ToastUtil.showToast(FuChangeActivity.this, "保存成功!", Toast.LENGTH_LONG);
//            ((FuContentActivity) getActivity()).goToPrePage();
            FuChangeActivity.this.finish();
        }
    }
    /**
     * 是否拍照
     */
    public boolean isCan_pic() {
        SharedPreferences spf=getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        int dd  = spf.getInt("isTakePhoto",0);
        if(0==dd){
            return false;
        }else{
            return true;
        }
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
}

