package net.greatsoft.main.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.maternal.MaternalRegister;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.FamilyInfoRsp;
import net.greatsoft.main.rsp.PersonInfoRsp;
import net.greatsoft.main.tool.ImageCondense;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglin on 2016/11/25.
 */

public class FuListFragment extends FragmentParent {

    private int listType;

    private Bundle maternalBundle;//孕产妇 所需

    private Bundle tuberculosis; // 肺结核随访 所需

    public static final int EVENT_CANNOTGO = 911;//已结束治疗


//    File file;


    int event;
    Object object;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(FuUiFrameManager.FU_LIST_VIEW,
                getActivity(), new OnEventClick());
        initData();
        setData();
//        find();
        ((FuListView) mModel).getData();

        return mModel.getFuView();
    }

    private View.OnKeyListener backListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK
                    && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (((FuListView) mModel).goBack())
                    return true;
            }
            return false;
        }
    };

    public void initData() {
        Bundle lBundle = ((FuContentActivity) getActivity()).getIntentBundle();
        listType = lBundle.getInt("listType");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setData() {
        ((FuListView) mModel).setData(listType);
    }


    public static final int EVENT_HYPER = 0;//高血压

    public static final int EVENT_DIABETES = 1; //糖尿病
    public static final int EVENT_EXAM = 2; //体检
    public static final int EVENT_SMI = 3;  //精神病
    public static final int EVENT_SMI_INFO = 28;//精神病补充信息
    public static final int EVENT_SELFCARE = 4;//老年人自理能力
    public static final int EVENT_COGNITION = 5;    //老年人认知功能
    public static final int EVENT_DEPRESSED = 6;    //老年人抑郁
    public static final int EVENT_ELDER_TCM = 29;//老年人中医药
    public static final int EVENT_CHILD = 20;    //儿童
    public static final int EVENT_MATERNAL = 25;//妇女

    public static final int EVENT_VACCINE = 33;    //儿童 接种
    public static final int EVENT_DISABILITY = 46;    //残疾人

    public static final int EVENT_TUBERCULOSIS = 30;//肺结核
    public static final int EVENT_CORONARYHEART = 35;//冠心病
    public static final int EVENT_CEREBRALAPOPLEXY = 36;//脑卒中

    public static final int EVENT_CHILD_HEALTH_EXAM_02 = 22;//儿童随访其他
    public static final int EVENT_CHILD_HEALTH_EXAM_03 = 23;//儿童随访其他
    public static final int EVENT_CHILD_HEALTH_EXAM_04 = 24;//儿童随访其他
    public static final int EVNET_CHILD_HOME_VISIT = 21;//儿童家庭访视

    public static final int EVENT_MATERNAL_FIRST_FOLLOW_UP = 25;//第一次产前随访
    public static final int EVENT_MATERNAL_FOLLOW_UP = 26;//2-5次产前随访
    public static final int EVENT_MATERNAL_POSTPARTUM_FOLLOWUP = 27;//产后检查


    public static final int EVENT_TUBERCULOSIS_FIRST_FOLLOWUP = 31;//肺结核
    public static final int EVENT_TUBERCULOSIS_FOLLOWUP = 32;


    public static final int EVENT_CDCVACCREPORT = 33;//预防接种卡
    public static final int EVENT_CDCVACCREPORT_VACCINATE = 34;//预防接种记录

    public static final int EVENT_HYPER_INFO = 37;//高血压专档
    public static final int EVENT_CORONARYHEART_INFO = 40;//冠心病专档
    public static final int EVENT_MATERNAL_REGISTER = 51;//孕产登记
    public static final int EVENT_CEREBRAL_INFO = 41;//脑卒中专档
    public static final int EVENT_DISABILITY_HEAR = 45;//听力言语残疾随访
    public static final int EVENT_DISABILITY_INTELLIGENCE = 46;//智力残疾随访
    public static final int EVENT_DISABILITY_LIMB = 47;//肢体残疾随访
    public static final int EVENT_DISABILITY_VISUAL = 48;//视力残疾随访
    public static final int EVENT_CHILD_INFO = 44;//儿童专档
    public static final int EVENT_TUBERCULOSIS_INFO = 42;//肺结核专档
    public static final int EVENT_DIABETES_INFO = 38;//糖尿病专档
    public static final int EVENT_ELDER_INFO = 39;//老年人花名册

    public static final int EVENT_PERSON = 7;//人员
    public static final int EVENT_FAMILY = 8;//查看家庭人员
    public static final int EVENT_FAMILY_ADD = 9;//新增家庭
    public static final int EVENT_PERSON_ADD = 10;//新增人员

    public static final int EVENT_GET_DATA = 11;//加载，更多

    public static final int EVENT_SEARCH = 12;//搜索


    // family/findFamilyList/{pageNo}/{pageSize}，Map<String,Object> param


    public void findFamilyList(int pageNo, int pageSize, Map<String, Object> param) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findFamilyList(getCallBackInstance(), pageNo, pageSize, param, getContext());

        excuteNetTask(lTask, false);
    }

    public void findPersonInfoList(int pageNo, int pageSize, Map<String, Object> param) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findAllPersonInfo(getCallBackInstance(), pageNo, pageSize, param, getContext());

        excuteNetTask(lTask, false);
    }

    public void findLastMaternalRegister(int type, Bundle bundle) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findLastMaternalRegister(getCallBackInstance(), bundle.getString("personInfoId"), getContext(), type);

        excuteNetTask(lTask, false);
    }

    public void findLastTuberCulosisRegister(int type, Bundle bundle) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findLastTuberCulosisRegister(getCallBackInstance(), bundle.getString("personInfoId"), getContext(), type);

        excuteNetTask(lTask, false);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case TAKE_CAM:

                    if(isTailor())
                        cutP();
                    else goNext();
                    break;
                case ACTION_GET_CONTENT:

                    goNext();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void goNext(){

        Bundle b = (Bundle) object;
        SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        int fileSize = spf.getInt("fileZipCapicity", 0);
        if (fileSize != 0){
            if(isTailor()){
                ImageCondense.scal(cutTemp.getAbsolutePath(), fileSize);
                b.putSerializable("file", cutTemp);
            }else{
                ImageCondense.scal(fileTemp.getAbsolutePath(), fileSize);
                b.putSerializable("file", fileTemp);
            }
        }
        doEvnet();
    }


    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            FuListFragment.this.event = event;
            FuListFragment.this.object = object;
//            takePic();
//            return;
            if (event == EVENT_GET_DATA) {
                Bundle bundle = (Bundle) object;
                HashMap<String, Object> map = (HashMap<String, Object>) bundle.getSerializable("param");
                switch (listType) {
                    case FuListFragment.EVENT_FAMILY:
                        findFamilyList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                        return;
                    case FuListFragment.EVENT_CHILD:
                    case FuListFragment.EVENT_SMI:
                    case FuListFragment.EVENT_DIABETES:
                    case FuListFragment.EVENT_HYPER:
                    case FuListFragment.EVENT_COGNITION:
                    case FuListFragment.EVENT_PERSON:
                    case FuListFragment.EVENT_MATERNAL:
                    case FuListFragment.EVENT_TUBERCULOSIS:
                    case FuListFragment.EVENT_CORONARYHEART:
                    case FuListFragment.EVENT_CEREBRALAPOPLEXY:
                    case FuListFragment.EVENT_DISABILITY:
                        findPersonInfoList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                        return;
                }
            } else if (isCan_pic()) {
                if (event == FuListFragment.EVENT_PERSON || event == FuListFragment.EVENT_FAMILY_ADD
                        || event == FuListFragment.EVENT_FAMILY) {
                    doEvnet();
                } else
                    takePic();
                return;
            }

            doEvnet();
        }
    }


    public void doEvnet() {
        /**
         * 是否进入蓝牙
         */
        if(isBlueTooth()){
            Bundle bundle = (Bundle)object;
            boolean needBlue = false;
            switch (event){
                case EVENT_PERSON_ADD:
                    needBlue = true;
                    bundle.putInt("class",FuUiFrameManager.FU_MEMBER_ADD);
                    break;
                case EVENT_EXAM:
                    needBlue = true;
                    ArrayList cls_exam = new ArrayList();
                    cls_exam.add(FuExam01Fragment.class);
                    cls_exam.add(FuExam02Fragment.class);
                    cls_exam.add(FuExam03Fragment.class);
                    cls_exam.add(FuExam04Fragment.class);
                    String[] titles_exam = new String[]{"第一页", "第二页", "第三页", "第四页"};
                    bundle.putSerializable("classes", cls_exam);
                    bundle.putStringArray("titles", titles_exam);
                    bundle.putString("title", "体检");
                    bundle.putInt("type", FuUiFrameManager.FU_S_EXAM);
                    bundle.putInt("class",FuUiFrameManager.FU_EXAM_ID);
                    break;
                case EVENT_HYPER_INFO:
                    needBlue = true;
                    bundle.putInt("class",FuUiFrameManager.FU_HYPER_INFO);
                    break;
                case EVENT_HYPER:
                    needBlue = true;
                    bundle.putInt("class",FuUiFrameManager.FU_HYPER);
                    break;
                case EVENT_DIABETES:
                    needBlue = true;
                    bundle.putInt("class",FuUiFrameManager.FU_DIABETES);
                    break;
                case EVENT_DIABETES_INFO:
                    needBlue = true;
                    bundle.putInt("class",FuUiFrameManager.FU_DIABETES_INFO);
                    break;
            }
            if(needBlue){
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_READ_CARD, bundle);
                return;
            }

        }
        switch (event) {
            case EVENT_CHILD_HEALTH_EXAM_02:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_02, (Bundle) object);
                break;
            case EVENT_CHILD_HEALTH_EXAM_03:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_03, (Bundle) object);
                break;
            case EVENT_CHILD_HEALTH_EXAM_04:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_04, (Bundle) object);
                break;
            case EVNET_CHILD_HOME_VISIT:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HOME_VISIT, (Bundle) object);
                break;
            case EVENT_HYPER:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_HYPER, (Bundle) object);
                break;
            case EVENT_HYPER_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_HYPER_INFO, (Bundle) object);
                break;
            case EVENT_CORONARYHEART_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CONARANYHEART_INFO, (Bundle) object);
                break;
            case EVENT_MATERNAL_REGISTER:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_REGISTER, (Bundle) object);
                break;
            case EVENT_CEREBRAL_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CEREBRAL_INFO, (Bundle) object);
                break;
            case EVENT_CHILD_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_INFO, (Bundle) object);
                break;
            case EVENT_TUBERCULOSIS_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_TUBERCULOSIS_INFO, (Bundle) object);
                break;
            case EVENT_DIABETES_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_DIABETES_INFO, (Bundle) object);
                break;
            case EVENT_ELDER_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_ELDERINFO, (Bundle) object);
                break;

            case EVENT_DIABETES:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_DIABETES, (Bundle) object);
                break;
            case EVENT_EXAM:
                ArrayList cls_exam = new ArrayList();
                cls_exam.add(FuExam01Fragment.class);
                cls_exam.add(FuExam02Fragment.class);
                cls_exam.add(FuExam03Fragment.class);
                cls_exam.add(FuExam04Fragment.class);
                String[] titles_exam = new String[]{"第一页", "第二页", "第三页", "第四页"};
                Bundle bundle_exam = (Bundle) object;
                bundle_exam.putSerializable("classes", cls_exam);
                bundle_exam.putStringArray("titles", titles_exam);
                bundle_exam.putString("title", "体检");
                bundle_exam.putInt("type", FuUiFrameManager.FU_S_EXAM);
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CHANGE_ID, 0, bundle_exam);
                break;
            case EVENT_SMI:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SMI, (Bundle) object);
                break;
            case EVENT_SMI_INFO:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SMI_INFO, (Bundle) object);
                break;
            case EVENT_SELFCARE:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SELFCARE, (Bundle) object);
                break;
            case EVENT_COGNITION:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_COGNITION, (Bundle) object);
                break;
            case EVENT_ELDER_TCM:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_ELDER_TCM, (Bundle) object);
                break;

            case EVENT_DEPRESSED:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_DEPRESSED, (Bundle) object);
                break;
            case EVENT_FAMILY:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_FAMILY_MEMBER, (Bundle) object);
                break;
            case EVENT_FAMILY_ADD:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_FAMILY_ADD, (Bundle) object);

                break;
            case EVENT_PERSON_ADD:

                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, (Bundle) object);

                break;

            case EVENT_PERSON:

                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, (Bundle) object);

                break;
            case EVENT_TUBERCULOSIS_FIRST_FOLLOWUP:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_TUBERCULOSIS_FIRST_FOLLOWUP, (Bundle) object);

                break;
            case EVENT_TUBERCULOSIS_FOLLOWUP:

                tuberculosis = ((Bundle) object);
                findLastTuberCulosisRegister(FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP, (Bundle) object);
                break;
            case EVENT_CORONARYHEART://冠心病
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_CORONARYHEART_FOLLOWUP, (Bundle) object);
                break;
            case EVENT_CEREBRALAPOPLEXY://脑卒中
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_CEREBRALAPOPLEXY_FOLLOWUP, (Bundle) object);
                break;
            case EVENT_DISABILITY_HEAR://听力言语残疾随访
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_DISABILITY_HEAR, (Bundle) object);
                break;
            case EVENT_DISABILITY_INTELLIGENCE://智力残疾随访
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_DISABILITY_INTELLIGENCE, (Bundle) object);
                break;
            case EVENT_DISABILITY_LIMB://z肢体残疾随访
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_DISABILITY_LIMB, (Bundle) object);
                break;
            case EVENT_DISABILITY_VISUAL://视力残疾随访
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_DISABILITY_VISUAL, (Bundle) object);
                break;
            case EVENT_GET_DATA:
                Bundle bundle = (Bundle) object;
                HashMap<String, Object> map = (HashMap<String, Object>) bundle.getSerializable("param");
                switch (listType) {
                    case FuListFragment.EVENT_FAMILY:
                        findFamilyList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                        break;
                    case FuListFragment.EVENT_CHILD:
                    case FuListFragment.EVENT_SMI:
                    case FuListFragment.EVENT_DIABETES:
                    case FuListFragment.EVENT_HYPER:
                    case FuListFragment.EVENT_COGNITION:
                    case FuListFragment.EVENT_PERSON:
                    case FuListFragment.EVENT_MATERNAL:
                    case FuListFragment.EVENT_TUBERCULOSIS:
                    case FuListFragment.EVENT_VACCINE:
                    case FuListFragment.EVENT_DISABILITY:
                        findPersonInfoList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                        break;
                }
                break;
            case EVENT_SEARCH:
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SEARCH, (Bundle) object);
                break;

            case EVENT_MATERNAL_FIRST_FOLLOW_UP://第一次产前随访

                maternalBundle = (Bundle) object;
                findLastMaternalRegister(FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP, (Bundle) object);
                break;
            case EVENT_MATERNAL_FOLLOW_UP://2-5次产前随访
                maternalBundle = (Bundle) object;
                findLastMaternalRegister(FuUiFrameManager.FU_MATERNAL_FOLLOW_UP, (Bundle) object);

                break;
            case EVENT_MATERNAL_POSTPARTUM_FOLLOWUP://产后检查
                maternalBundle = (Bundle) object;
                findLastMaternalRegister(FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP, (Bundle) object);
                break;

            case EVENT_CDCVACCREPORT://预防接种卡
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CDCVACC_REPORT, (Bundle) object);

                break;
            case EVENT_CDCVACCREPORT_VACCINATE://预防接种记录


                ArrayList cls_cdc = new ArrayList();
                cls_cdc.add(FuCdcHasFragment.class);
                cls_cdc.add(FuCdcNoFragment.class);
                String[] titles_cdc = new String[]{"已接种", "未接种"};
                Bundle bundle_cdc = (Bundle) object;
                bundle_cdc.putSerializable("classes", cls_cdc);
                bundle_cdc.putStringArray("titles", titles_cdc);
                bundle_cdc.putString("title", "接种记录");
                bundle_cdc.putInt("type", FuUiFrameManager.FU_CDCVACCREPORT_VACCINATE);
                ((FuContentActivity) getActivity()).replaceFragment(
                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHANGE, bundle_cdc);


//                    ((FuContentActivity) getActivity()).replaceFragment(
//                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_PATIENT_INFO, (Bundle) object);

                break;
        }
    }


    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.FIND_FAMILY_LIST:
                    FamilyInfoRsp familyInfoRsp = (FamilyInfoRsp) msg.obj;
                    ((FuListView) mModel).setFamilyInfoList(familyInfoRsp.getRows());
                    break;
                case MyTask.FIND_PERSON_LIST:
                    PersonInfoRsp personInfoRsp = (PersonInfoRsp) msg.obj;
                    ((FuListView) mModel).setPersonInfoList(personInfoRsp.getRows());
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), "连接失败，无返回数据！", Toast.LENGTH_LONG);
                    break;
                case FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP://第一次产前随访

                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP, maternalBundle);
                    break;
                case FuUiFrameManager.FU_MATERNAL_FOLLOW_UP://2-5次产前随访
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_FOLLOW_UP, maternalBundle);
                    break;
                case FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP://产后检查
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP, maternalBundle);
                    break;

                case FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP://肺结核患者随访
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP, tuberculosis);
                    break;
                case EVENT_CANNOTGO:
                    ToastUtil.showToast(getContext(), "患者已结束治疗", Toast.LENGTH_LONG);
                    break;
            }
        }
    };

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

        Message message = Message.obtain(mHandler);
        message.what = taskId;

        if (rspObj == null || rspObj.getResult() == null) {
            message.what = NET_ERROR;
            message.obj = "无数据";
            message.sendToTarget();
            return;
        }

        switch (taskId) {
            case MyTask.FIND_FAMILY_LIST:
                FamilyInfoRsp familyInfoRsp = JSONArray.parseObject(rspObj.getResult(), FamilyInfoRsp.class);
                message.obj = familyInfoRsp;
                break;
            case MyTask.FIND_PERSON_LIST:
                PersonInfoRsp personInfoRsp = JSONArray.parseObject(rspObj.getResult(), PersonInfoRsp.class);
                message.obj = personInfoRsp;
                break;

            case FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP://第一次产前随访

                MaternalRegister maternalRegister = JSONObject.parseObject(rspObj.getResult(), MaternalRegister.class);
                Log.e("ddd", rspObj.getResult());
                maternalBundle.putSerializable("maternalRegister", maternalRegister);
                message.what = FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP;

                break;
            case FuUiFrameManager.FU_MATERNAL_FOLLOW_UP://2-5次产前随访

                MaternalRegister maternalRegister2 = JSONObject.parseObject(rspObj.getResult(), MaternalRegister.class);
                Log.e("ddd", rspObj.getResult());
                maternalBundle.putSerializable("maternalRegister", maternalRegister2);
                message.what = FuUiFrameManager.FU_MATERNAL_FOLLOW_UP;
//                ((FuContentActivity) getActivity()).replaceFragment(
//                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_FOLLOW_UP, (Bundle) object);
                break;
            case FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP://产后检查

                MaternalRegister maternalRegister3 = JSONObject.parseObject(rspObj.getResult(), MaternalRegister.class);
                Log.e("ddd", rspObj.getResult());
                maternalBundle.putSerializable("maternalRegister", maternalRegister3);
                message.what = FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP;
//                ((FuContentActivity) getActivity()).replaceFragment(
//                        FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP, (Bundle) object);
                break;

            case FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP://第一次产前随访

                TuberculosisInfo tuberculosisInfo = JSONObject.parseObject(rspObj.getResult(), TuberculosisInfo.class);
                if (tuberculosisInfo.getStopTreatmentDate() != null) {
                    message.what = EVENT_CANNOTGO;
                } else {
                    tuberculosis.putSerializable("tuberculosisInfo", tuberculosisInfo);
                    message.what = FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP;
                }
                break;
        }

        message.sendToTarget();
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {
        Log.e("fulistFragment", "netErrorChild");
        Message message = Message.obtain(mHandler);
        message.what = NET_ERROR;
        message.sendToTarget();
    }

    @Override
    protected void cancelChild(int taskId) {
        Log.e("fulistFragment", "cancelChild");
    }

    public boolean goBack() {
        return ((FuListView) mModel).goBack();
    }
}
