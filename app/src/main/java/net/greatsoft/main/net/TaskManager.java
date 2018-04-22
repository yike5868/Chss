// Copyright (C) 2012-2013 UUZZ All rights reserved
package net.greatsoft.main.net;

import android.content.Context;
import android.content.SharedPreferences;

import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.LoginData;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.db.po.Entry;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TaskManager {

    /**
     * 测试
     */
//	public static final String ROOT_URL = "http://112.126.66.123:8082/jkxopenapi/resident";
    public static final String HTTP = "http://";

//	public static String ROOT_URL = "192.168.1.17:8082/ph-s-report/";

    /**
     * 平台内容
     */

    public static String pt_url = "";

    public static String pt_url2 = "";


    private static String access_token = "";


    private static String con_drl = "";//管辖地区

    private static String districtId = "";//区划登记
    private static String districtLev = "";//区划登记


    public String getCon_drl(Context context) {
        SharedPreferences preferences1 = context.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        String mcon_drl = preferences1.getString("con_drl", "");
        return mcon_drl;
    }

    public String getDistrictId(Context context) {
        SharedPreferences preferences1 = context.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        String mcon_drl = preferences1.getString("districtId", "");
        return mcon_drl;
    }

    public String getDistrictLev(Context context) {
        SharedPreferences preferences1 = context.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        String mcon_drl = preferences1.getString("districtLev", "");
        return mcon_drl;
    }

    public String getEmpId(Context context) {
        SharedPreferences preferences1 = context.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        String emp_id = preferences1.getString("emp_id", "");
        return emp_id;
    }


    /**
     * 获取字典版本信息
     * /pos/dicts
     */
    public static final String FIND_DICTS = "/pos/dicts";

    /**
     * 获取字典
     * /pos/dicts/terms
     */
    public static final String GET_TERMS = "/pos/dicts/terms";

    /**
     * 获取所有医生
     * /pos/emps
     */
    public static final String FIND_EMPS = "/pos/emps";

    /**
     * 获取Session
     * /pos/sessions
     */
//    public static final String GET_SESSION = "/pos/emp/relationInfo";
    public static final String GET_SESSION = "/pos/sessions";
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 公卫内容
     * android/getOpenplatformHost
     */
    public static final String GET_OPEN_PLAT_FORM_HOST = "/android/getOpenplatformHost";
    /**
     * 获取授权接口
     */

    public static final String GET_AUTHORIZATION = "/android/loginAuthorized";

    /**
     * 保存家庭
     */
    public static final String SAVE_FAMILY_INFO = "/family/saveFamilyInfo";
    /**
     * 保存精神病
     * /smiFollowup/saveSmiFollowup
     */
    public static final String SAVE_SMI_FOLLOWUP = "/smiFollowup/saveSmiFollowup";


    /**
     * 精神病补充表
     * smiInfo/saveSmiInfo
     */

    public static final String SAVE_SMI_INFO = "/smiInfo/saveSmiInfo";


    /**
     * 更新家庭
     * family/updateFamilyInfo
     */
    public static final String UPDATE_FAMILY_INFO = "/family/updateFamilyInfo";

    /**
     * 获取家庭
     * family/findFamilyList/{pageNo}/{pageSize}，Map<String,Object> param
     */
    public static final String FIND_FAMILY_LIST = "/family/findFamilyList/";

    /**
     * 获取单个家庭
     * family/findFamilyInfoById/{familyInfoId}
     */
    public static final String FIND_FAMILY = "/family/findFamilyInfoById/";

    /**
     * 获取人员
     * person/findAllPersonInfo/{pageNo}/{pageSize}，Map<String,Object> param
     */
    public static final String FIND_ALL_PERSONINFO = "/person/findAllPersonInfo/";
    /**
     * 保存人员
     * person/savePersonInfo，PersonInfo
     */
    public static final String SAVE_PERSONINFO = "/person/savePersonInfo";
    /**
     * 保存体检
     * healthExam/saveHealthExam
     */
    public static final String SAVE_HEALTH_EXAM = "/healthExam/saveHealthExam";
    /**
     * 保存第一次产前随访
     * maternal/saveMaternalFirstFollowup
     */

    public static final String SAVE_MATERNAL_FIRST_FOLLOWUP = "/maternal/saveMaternalFirstFollowup";

    /**
     * 保存第2-5次产前随访
     * maternal/saveMaternalFollowup
     */
    public static final String SAVE_MATERNAL_FOLLOWUP = "/maternal/saveMaternalFollowup";

    /**
     * 产后随访
     * SAVE_MATERNAL_FOLLOWUP_AFTER
     */
    public static final String SAVE_MATERNAL_FOLLOWUP_AFTER = "/maternalFollowup/saveMaternalFollowup";
    /**
     * 产后42天
     * maternalFollowup/savePostpartumHealthExam
     */
    public static final String SAVE_POSTPARTUM_HEALTHEXAM = "/maternalFollowup/savePostpartumHealthExam";

    /**
     * 保存新生儿访视
     * childHomeVisit/saveChildHomeVisit
     */
    public static final String SAVE_CHILD_HOME_VISIT = "/childHomeVisit/saveChildHomeVisit";

    /**
     * 保存儿童健康检查
     * childHealthExam/saveChildHealthExam
     * saveChildHealthExam
     */
    public static final String SAVE_CHILD_HEALTH_EXAM = "/childHealthExam/saveChildHealthExam";

    /**
     * 更新人员
     * person/updatePersonInfo，PersonInfo
     */
    public static final String UPDATE_PERSONINFO = "/person/updatePersonInfo";
    /**
     * 获取单个人员
     * findPersonInfoByPersonInfoId
     */
    public static final String FIND_PERSONINFO = "/person/findPersonInfoByPersonInfoId/";
    /**
     * 获取单个人员
     * childInfo/findFatherOrMotherByPersonInfoIdAndSexCode/{personInfoId}/{sexCode}
     */
    public static final String FIND_FATHERORMOTHERLIST = "/childInfo/findFatherOrMotherByPersonInfoIdAndSexCode/";

    /**
     * 获取单个孕妇信息
     * maternal/findLastMaternalRegister/{personInfoId}
     */
    public static final String FIND_LAST_MATERNAL_REGISTER = "/maternal/findLastMaternalRegister/";

    /**
     * 获取单个肺结核患者
     * tuberculosis/findTuberculosisInfoByPersonInfoId/{personInfoId}
     */
    public static final String FIND_LAST_TUBERCULOSIS_REGISTER = "/tuberculosis/findTuberculosisInfoByPersonInfoId/";

    /**
     * 保存老年人认知
     * elderInfo//saveElderCognition
     */
    public static final String SAVE_ELDER_COGNITION = "/elderInfo/saveElderCognition/";

    /**
     * 保存老年人中医药
     * elderTcmHealth/saveElderTcmHealth
     */
    public static final String SAVE_ELDER_TCM_HEALTH = "/elderTcmHealth/saveElderTcmHealth";

    /**
     * 获取药品
     * sickMedicine/findSickChoiceMedicine
     */
    public static final String FIND_SICK_CHOICE_MEDICINE = "/sickMedicine/findSickChoiceMedicine";
    /**
     * 保存高血压随访
     * saveHyperFollowup
     */
    public static final String SAVE_HYPER_FOLLOWUP = "/hyperFollowup/saveHyperFollowup";
    /**
     * 修改密码
     * /pos/emp/password
     */
    public static final String SET_PASSWORD = "/pos/emp/password";
    /**
     * 保存高血压专档
     * /hyperInfo/saveHyperInfo
     */
    public static final String SAVE_HYPER_INFO = "/hyperInfo/saveHyperInfo";
    /**
     * 保存听力言语残疾随访
     * /disabilityHearing/saveDisabilityHearing
     */
    public static final String SAVE_DISABILITY_HEAR = "/disabilityHearing/saveDisabilityHearing";
    /**
     * 保存肢体残疾随访
     * /disabilityLimb/saveDisabilityLimb
     */
    public static final String SAVE_DISABILITY_LIMB = "/disabilityLimb/saveDisabilityLimb";
    /**
     * 保存智力残疾随访
     * /disabilityIntelligence/saveDisabilityIntelligence
     */
    public static final String SAVE_DISABILITY_INTELLIGENCE = "/disabilityIntelligence/saveDisabilityIntelligence";
    /**
     * 保存视力残疾随访
     * /disabilityVisual/saveDisabilityVisual
     */
    public static final String SAVE_DISABILITY_VISUAL = "/disabilityVisual/saveDisabilityVisual";
    /**
     * 保存儿童专档
     * /childInfo/saveChildInfo
     */
    public static final String SAVE_CHILD_INFO = "/childInfo/saveChildInfo";

    /**
     * 保存冠心病专档
     * /coronaryHeartDiseaseInfo/saveCoronaryHeartDiseaseInfo
     */
    public static final String SAVE_CORONARYHEART_INFO = "/coronaryHeartDiseaseInfo/saveCoronaryHeartDiseaseInfo";

    /**
     * 保存脑卒中专档
     * /cerebralApoplexyInfo/saveCerebralApoplexyInfo
     */
    public static final String SAVE_CEREBRAL_INFO = "/cerebralApoplexyInfo/saveCerebralApoplexyInfo";
    /**
     * 保存肺结核专档
     * /tuberculosis/saveTuberculosisInfo
     */
    public static final String SAVE_TUBERCULOSIS_INFO = "/tuberculosis/saveTuberculosisInfo";

    /**
     * 保存老年人花名册
     * /elderInfo/saveElderInfo
     */
    public static final String SAVE_Elder_INFO = "/elderInfo/saveElderInfo";

    /**
     * 保存老年人自理能力评估
     * elderInfo/saveElderSelfcareAbility
     */

    public static final String SAVE_ELDER_SELFCARE_ABILITY = "/elderInfo/saveElderSelfcareAbility";

    /**
     * 保存糖尿病
     * diabetesFollowup/saveDiabetesFollowup
     */
    public static final String SAVE_DIABETES_FOLLOWUP = "/diabetesFollowup/saveDiabetesFollowup";
    /**
     * 保存糖尿病专档
     * diabetesInfo/saveDiabetesInfo
     */
    public static final String SAVE_DIABETES_INFO = "/diabetesInfo/saveDiabetesInfo";
    /**
     * 保存孕产登记
     * maternal/saveMaternalRegister
     */
    public static final String SAVE_MATERNAL_REGISTER = "/maternal/saveMaternalRegister";
    /**
     * 保存冠心病
     * coronaryHeartFollowup/saveCoronaryHeartFollowup
     */
    public static final String SAVE_CORONARYHEART_FOLLOWUP = "/coronaryHeartDiseaseFollowup/saveCoronaryHeartDiseaseFollowup";

    /**
     * 保存脑卒中
     * coronaryHeartFollowup/saveCoronaryHeartFollowup
     */
    public static final String SAVE_CEREBRALAPOPLEXY = "/cerebralApoplexyFollowup/saveCerebralApoplexyFollowup";

    /**
     * 保存肺结核第一次
     * tuberculosis/saveTuberculosisFirstFollowup
     */
    public static final String SAVE_TUBERCULOSIS_FIRST_FOLLOWUP = "/tuberculosis/saveTuberculosisFirstFollowup";

    /**
     * 保存肺结核随访
     * tuberculosis/saveTuberculosisFollowup
     */
    public static final String SAVE_TUBERCULOSIS_FOLLOWUP = "/tuberculosis/saveTuberculosisFollowup";

    /**
     * 更新肺结核基本信息
     * tuberculosis/updateTuberculosisInfo
     */
    public static final String UPDATE_TUBERCULOSIS_INFO = "tuberculosis/updateTuberculosisInfo";

    /**
     * 保存预防接种卡
     * cdcvaccreport/saveCdcVaccreport
     */
    public static final String SAVE_CDCVACC_REPORT = "/vaccreport/saveCdcVaccreport";

    /**
     * 保存图片
     */
    public static final String SAVE_PICS = "/android/saveAndroidFileRecord";
    /**
     * 保存人员图片
     * /fileUpload/singleFileUploadForAndroid
     */
    public static final String SAVE_PERSONIFO_PICS = "/fileUpload/singleFileUploadForAndroid";
    /**
     * 获得地区
     */
    public static final String FIND_ORG_JURISDICTION = "/jurisdiction/findOrgJurisdiction/";

    /**
     * 获取全部地区小区
     * /android/findOrgJurisdiction/
     */
    public static final String ANDROID_FIND_ORG_JURISDICTION = "/android/findOrgJurisdiction/";

    /**
     * 获取地区
     * findCurrentUserDistricts
     */
    public static final String FIND_CURRENT_USER_DISTRICTS = "/jurisdiction/findCurrentUserDistricts";
    /**
     * 升级
     * android/findAndroidVersionLog
     */
    public static final String FIND_ANDROID_VERSON = "/android/findAndroidVersionLog";

    /**
     * 获取登录token
     * GET
     * <p>
     * "http://192.168.1.175:9098?grant_type=password&unique_id=zhangzhaoning&key=123456"
     */
    public static final String GET_TOKEN = "/pos/token?grant_type=password";
    /**
     * 获得小区
     * {districtId}
     */
    public static final String GET_SUBDISTRICT = "/system/getSubDistrict/";

    /**
     * 获取楼栋
     * system/getBuilding/
     */
    public static final String GET_BUILDING = "/system/getBuilding/";

    /**
     * 获取单元
     * system/getBuildingUnit/{buildingId}
     */
    public static final String GET_UNIT = "/system/getBuildingUnit/";
    /**
     * 根据token获取是否蓝牙
     */
    public static final String GET_IS_BLUE = "/android/getIsBluetooth";
    /**
     * 获取房间
     * system/getRoomNumberByBuilingUnitNo/{buildingId}/{buildingUnitNo}
     */
    public static final String GET_ROOM = "/system/getRoomNumberByBuilingUnitNo/";

    // ----------------------------------

    private static TaskManager mTaskManager;

//    private static String SESSION_ID;

    public static TaskManager getInstace(Context context) {

        if (mTaskManager == null) {
            mTaskManager = new TaskManager();
        }

//		if (SESSION_ID == null) {
//
//			FuApp app = (FuApp) ((Activity) context).getApplication();
//
//			FuUserInfo lUser = app.getFuUserInfo();
//			SESSION_ID = lUser.SESSION_ID;
//		}

        return mTaskManager;
    }

    public static TaskManager getInstace() {

        if (mTaskManager == null) {
            mTaskManager = new TaskManager();
        }

        return mTaskManager;
    }

    /**
     * 获取 公卫地址
     *
     * @param context
     * @return
     */
    public String getBaseUr(Context context) {
        LoginData loginData = (LoginData) DataSaveManager.getInstance(context)
                .getSaveData(SaveTask.KEY_LOGIN);
        String baseUrl = loginData.getBaseUrl();
        baseUrl += "/ph-s-report";
        return baseUrl;
    }

    /**
     * 获取 token
     *
     * @param context
     * @return
     */
    public String getAccess_token(Context context) {
        SharedPreferences preferences1 = context.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        String access_token = preferences1.getString("access_token", "");
        return access_token;
    }

    /**
     * 获取header
     */

    public HashMap<String, String> getHearder(Context mContext) {
        HashMap<String, String> lHttpHeader = new HashMap<String, String>();
        String token = getAccess_token(mContext);
        lHttpHeader.put("access_token", token);
        return lHttpHeader;
    }


//    /**
//     * 获取当前用户的信息的地址
//     * @param context
//     * @return
//     */
//    public String getPTUrl (Context context){
//        LoginData loginData = (LoginData) DataSaveManager.getInstance(context)
//                .getSaveData(SaveTask.KEY_PT);
//        String baseUrl = loginData.getPtBaseUrl();
//        return "http://192.168.1.175:9098";
//    }
//
//    /**
//     * 获取当前所有随访医生的地址
//     */
//
//    public String getPT2Url(Context context){
//        LoginData loginData = (LoginData) DataSaveManager.getInstance(context)
//                .getSaveData(SaveTask.KEY_PT2);
//        String baseUrl = loginData.getPtBaseUrl2();
//        return "http://192.168.1.175:9098";
//    }


    /**
     * 更版本
     */
    public MyTask getUpdateApp(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        HashMap<String, String> lHttpHeader = new HashMap<String, String>();
        task.mUrl = HTTP + getBaseUr(mContext);
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.UPDATE_APP;
        lHttpHeader.put("ACTION", "V01");
        task.mRequestData = base;
        task.mRequestHeader = lHttpHeader;
        return task;
    }

    public MyTask getDownLoadApp(NetCallBack mCallBack, String url,
                                 DownLoadFile file) {
        FuDownLoadFileTask task = new FuDownLoadFileTask();
        task.mUrl = url;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.DOWNLOAD_FILE;
        task.mLoadFile = file;
        return task;

    }

    /**
     * 登录
     */
    public MyTask getLoginApp(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        HashMap<String, String> lHttpHeader = new HashMap<String, String>();
        task.mUrl = HTTP + getBaseUr(mContext);
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.LOGIN_APP;
        task.mRequestData = base;
        task.mRequestHeader = lHttpHeader;
        return task;
    }

    /**
     * 上传家庭
     */
    public MyTask upDataFamilyInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_FAMILY_INFO;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.SAVE_FAMILY;
        task.mRequestData = base;
        task.method = MyTask.METHOD_POST;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }

    /**
     * 上传精神病随访
     * saveSmiInfo
     * smiInfo/saveSmiInfo
     */
    public MyTask saveSmiFollowUp(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_SMI_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.SAVE_SMI_FOLLOWUP;
        task.mRequestData = base;
        task.method = MyTask.METHOD_POST;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }

    /**
     * 上传精神病补充表
     * SAVE_SMI_INFO
     */
    public MyTask saveSmiInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_SMI_INFO;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.SAVE_SMI_INFO;
        task.mRequestData = base;
        task.method = MyTask.METHOD_POST;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }

    /**
     * 更新
     * family/updateFamilyInfo，FamilyInfo
     */
    public MyTask updateFamilyInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + UPDATE_FAMILY_INFO;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.UPDATE_FAMILY_INFO;
        task.method = MyTask.METHOD_PUT;
        task.mRequestData = base;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }


    /**
     * 获取家庭
     * family/findFamilyList/{pageNo}/{pageSize}，Map<String,Object> param
     */

    public MyTask findFamilyList(NetCallBack mCallBack, int pageNo, int pageSize, Map<String, Object> param, Context mContext) {

        MyTask task = new MyTask();

        task.mUrl = HTTP + getBaseUr(mContext) + FIND_FAMILY_LIST + pageNo + "/" + pageSize;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.paramMap = param;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.FIND_FAMILY_LIST;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取单个家庭
     * family/findFamilyInfoById/{familyInfoId}
     */
    public MyTask findFamilyInfoById(NetCallBack mCallBack, String familyInfoId, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_FAMILY + familyInfoId;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_FAMILY;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }


    /**
     * 获取人员
     * person/findAllPersonInfo/{pageNo}/{pageSize}，Map<String,Object> param
     */
    public MyTask findAllPersonInfo(NetCallBack mCallBack, int pageNo, int pageSize, Map<String, Object> param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_ALL_PERSONINFO + pageNo + "/" + pageSize;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.paramMap = param;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.FIND_PERSON_LIST;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取单个人员
     * person/findPersonInfoByPersonInfoId/{personInfoId}
     */
    public MyTask findPersonInfoByPersonInfoId(NetCallBack mCallBack, String personInfoId, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_PERSONINFO + personInfoId;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_PERSON;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取家庭父亲集合
     * childInfo/findFatherOrMotherByPersonInfoIdAndSexCode/{personInfoId}/{sexCode}
     */
    public MyTask findFaterhListByPersonInfoId(NetCallBack mCallBack, String personInfoId, String sexCode, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_FATHERORMOTHERLIST + personInfoId + "/" + sexCode;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_FATHERLIST;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取家庭母亲集合
     * childInfo/findFatherOrMotherByPersonInfoIdAndSexCode/{personInfoId}/{sexCode}
     */
    public MyTask findMotherListByPersonInfoId(NetCallBack mCallBack, String personInfoId, String sexCode, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_FATHERORMOTHERLIST + personInfoId + "/" + sexCode;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_MOTHERLIST;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }


    /**
     * 获取单个孕产妇
     * maternal/findLastMaternalRegister/{personInfoId}
     */
    public MyTask findLastMaternalRegister(NetCallBack mCallBack, String personInfoId, Context mContext, int type) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_LAST_MATERNAL_REGISTER + personInfoId;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = type;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取单个肺结核患者
     * tuberculosis//findTuberculosisInfoByTuberculosisInfoId/
     */
    public MyTask findLastTuberCulosisRegister(NetCallBack mCallBack, String personInfoId, Context mContext, int type) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_LAST_TUBERCULOSIS_REGISTER + personInfoId;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = type;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 老年人认知
     * saveElderCognition
     */

    public MyTask saveElderCognition(NetCallBack mCallBack, Entry elderCognition, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_ELDER_COGNITION;
        task.mCallBack = mCallBack;
        task.mRequestData = elderCognition;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_ELDER_COGNITION;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 老年人中医药
     * elderTcmHealth/saveElderTcmHealth
     */

    public MyTask saveElderTcmHealth(NetCallBack mCallBack, Entry elderCognition, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_ELDER_TCM_HEALTH;
        task.mCallBack = mCallBack;
        task.mRequestData = elderCognition;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_ELDER_TCM_HEALTH;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取药品
     * sickMedicine/findSickChoiceMedicine
     */
    public MyTask findSickChoiceMedicine(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_SICK_CHOICE_MEDICINE;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_SICK_CHOICE_MEDICINE;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存人员
     * person/savePersonInfo，PersonInfo
     */
    public MyTask savePersonInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_PERSONINFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_PERSON;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存体检
     * person/savePersonInfo，PersonInfo
     */
    public MyTask saveExam(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_HEALTH_EXAM;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_HEALTH_EXAM;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存妇女第一次产前随访
     * maternal/saveMaternalFirstFollowup
     */
    public MyTask saveMaternalFirstFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_MATERNAL_FIRST_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_MATERNAL_FIRST_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存妇女第2-5次产前随访
     * maternal/saveMaternalFollowup
     */
    public MyTask saveMaternalFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_MATERNAL_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_MATERNAL_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 产后随访
     * maternalFollowup/saveMaternalFollowup
     */
    public MyTask saveMaternalFollowupAfter(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_MATERNAL_FOLLOWUP_AFTER;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_MATERNAL_FOLLOWUP_AFTER;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 产后42天随访
     * maternalFollowup/savePostpartumHealthExam
     */

    public MyTask savePostpartumHealthExam(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_POSTPARTUM_HEALTHEXAM;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_POSTPARTUM_HEALTHEXAM;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }


    /**
     * 保存新生儿访视
     * childHomeVisit/saveChildHomeVisit
     */
    public MyTask saveChildHomeVisit(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CHILD_HOME_VISIT;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CHILD_HOME_VISIT;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存儿童健康检查
     * childHealthExam/saveChildHealthExam
     */
    public MyTask saveChildHealthExam(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CHILD_HEALTH_EXAM;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CHILD_HEALTH_EXAM;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 更新人员
     * person/updatePersonInfo，PersonInfo
     */
    public MyTask updatePersonInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + UPDATE_PERSONINFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_PUT;
        task.mTaskId = MyTask.UPDATE_PERSONINFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存老年人自理能力
     * elderInfo/saveElderSelfcareAbility
     */
    public MyTask saveElderSelfcareAbility(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_ELDER_SELFCARE_ABILITY;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_ELDER_SELFCARE_ABILITY;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 修改密码
     * /pos/emp/password
     */
    public MyTask setPassword(NetCallBack mCallBack, String newpassword, String oldpassword, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url + SET_PASSWORD + "?old_password=" + oldpassword + "&new_password=" + newpassword;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_PUT;
        task.mTaskId = MyTask.SET_PASSWORD;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存高血压随访
     * hyperFollowup/saveHyperFollowup
     */
    public MyTask saveHyperFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_HYPER_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_HYPER_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存高血压专档
     * /hyperInfo/saveHyperInfo
     */
    public MyTask saveHyperFollowInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_HYPER_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_HYPER_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存听力言语残疾随访
     */
    public MyTask saveDisabilityHear(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DISABILITY_HEAR;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DISABILITY_HEAR;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存视力随访
     */
    public MyTask saveDisabilityVisual(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DISABILITY_VISUAL;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DISABILITY_VISUAL;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }


    /**
     * 保存肢体残疾随访
     */
    public MyTask saveDisabilityLimb(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DISABILITY_LIMB;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DISABILITY_LIMB;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存智力残疾随访
     */
    public MyTask saveDisabilityIntelligence(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DISABILITY_INTELLIGENCE;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DISABILITY_INTELLIGENCE;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存儿童专档
     * /childInfo/saveChildInfo
     */
    public MyTask saveChildInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CHILD_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CHILD_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存冠心病专档
     * /coronaryHeartInfo/saveCoronaryHeartInfo
     */
    public MyTask saveCoronaryHeartInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CORONARYHEART_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CORONARY_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存脑卒中专档
     */
    public MyTask saveCerebralInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CEREBRAL_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CEREBRAL_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存肺结核专档
     */
    public MyTask saveTuberculosisInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_TUBERCULOSIS_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_TUBERCULOSIS_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存老年人花名册
     * /elderInfo/saveElderInfo
     */
    public MyTask saveElderInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_Elder_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_ELDER_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存糖尿病
     * diabetesFollowup/saveDiabetesFollowup
     */
    public MyTask saveDiabetesFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DIABETES_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DIABETES_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存糖尿病
     * diabetesFollowup/saveDiabetesFollowup
     */
    public MyTask saveDiabetesInfo(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_DIABETES_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_DIABETES_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存孕产登记
     * maternal/saveMaternalRegister
     */
    public MyTask saveMaternalRegister(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_MATERNAL_REGISTER;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_MATERNAL_REGISTER;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存冠心病
     * coronaryHeartFollowup/saveDiabetesFollowup
     */
    public MyTask saveCoronaryHeartFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CORONARYHEART_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CORONARYHEART_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存脑卒中
     * coronaryHeartFollowup/saveDiabetesFollowup
     */
    public MyTask saveCerebralApoplexy(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CEREBRALAPOPLEXY;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CEREBRALAPOPLEXY_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存肺结核第一次
     * tuberculosis/saveTuberculosisFirstFollowup
     */
    public MyTask saveTuberculosisFirstFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_TUBERCULOSIS_FIRST_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_TUBERCULOSIS_FIRST_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存肺结核随访
     * tuberculosis/saveTuberculosisFollowup
     */
    public MyTask saveTuberculosisFollowup(NetCallBack mCallBack, Entry base, Entry base1, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_TUBERCULOSIS_FOLLOWUP;
        task.mCallBack = mCallBack;
        task.paramMap = new HashMap<>();
        task.paramMap.put("tuberculosisFollowup", base);
        task.paramMap.put("tuberculosisInfo", base1);
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_TUBERCULOSIS_FOLLOWUP;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 更新肺结核基本信息
     * tuberculosis/updateTuberculosisInfo
     */
    public MyTask updateTuberculosisFollowup(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + UPDATE_TUBERCULOSIS_INFO;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_PUT;
        task.mTaskId = MyTask.UPDATE_TUBERCULOSIS_INFO;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存预防接种卡
     * cdcvaccreport/saveCdcVaccreport
     */
    public MyTask saveCdcVaccreport(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_CDCVACC_REPORT;
        task.mCallBack = mCallBack;
        task.mRequestData = base;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.SAVE_CDCVACC_REPORT;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存图片
     * tuberculosis/saveTuberculosisFollowup
     */
    public MyTask savePics(NetCallBack mCallBack, Entry base, Context mContext, File[] files) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_PICS;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mRequestData = base;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.UP_LOAD_FILE;
        task.files = files;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 保存家庭成员图片
     * fileUpload/singleFileUploadForAndroid
     */
    public MyTask savePersonInfoPics(NetCallBack mCallBack, Entry base, Context mContext, File[] files) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + SAVE_PERSONIFO_PICS;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mRequestData = base;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.UP_LOAD_PERSONINFO_FILE;
        task.files = files;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取地区列表
     * jurisdiction/findOrgJurisdiction/
     */

    public MyTask findOrgJurisdiction(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_CURRENT_USER_DISTRICTS + "?pos_id=" + getCon_drl(mContext) + "&emp_id=" + getEmpId(mContext);
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_ORG_JURISDICTION;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取所有医生列表
     */

    public MyTask findEmps(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url2 + FIND_EMPS + "?pos_id=" + getCon_drl(mContext) + "&dept_id=";
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.FIND_EMPS;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取平台地址
     * android/getOpenplatformHost
     */

    public MyTask getOpenplatformHost(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_OPEN_PLAT_FORM_HOST;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_OPEN_PLAT_FORM_HOST;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取授权
     * getAuthorization
     */

    public MyTask getAuthorization(NetCallBack mCallBack, Map param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_AUTHORIZATION;
        task.mCallBack = mCallBack;
        task.paramMap = param;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.GET_AUTHORIZATION;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取授权
     * getAuthorization
     */

    public MyTask getAuthorization2(NetCallBack mCallBack, String type, String phoneNum, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_AUTHORIZATION + "/" + type + "/" + phoneNum;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_AUTHORIZATION2;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取地区列表
     * FIND_ANDROID_VERSON
     */

    public MyTask findAndroidVersionLog(NetCallBack mCallBack, Map param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + FIND_ANDROID_VERSON;
        task.mCallBack = mCallBack;
        task.paramMap = param;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_POST;
        task.mTaskId = MyTask.FIND_ANDROID_VERSON;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 登录获取token
     * /pos/token
     */
    public MyTask getToken(NetCallBack mCallBack, String accont, String password, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url + GET_TOKEN + "&user_xid=" + accont + "&user_key=" + password;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_TOKEN;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 获取地区列表
     * system/getSubDistrict/{districtId}
     */

    public MyTask getSubDistrict(NetCallBack mCallBack, String param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_SUBDISTRICT + param;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_SUBDISTRICT;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 楼栋
     * system/getBuilding/{subDistrictId}
     */

    public MyTask getBuilding(NetCallBack mCallBack, String param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_BUILDING + param;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_BUILDING;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 单元
     * system/getBuildingUnit/{buildingId}
     */

    public MyTask getUnit(NetCallBack mCallBack, String param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_UNIT + param;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_UNIT;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 单元
     * system/getBuildingUnit/{buildingId}
     */

    public MyTask getRoom(NetCallBack mCallBack, String param, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_ROOM + param;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_ROOM;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 注册
     */
    public MyTask getRegistApp(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext);
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.REGIST_APP;
        task.mRequestData = base;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }

    /**
     * 找回密码
     */
    public MyTask getFindPasswordApp(NetCallBack mCallBack, Entry base, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext);
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.mTaskId = MyTask.FIND_PASSWORD;
        task.mRequestData = base;
        task.mRequestHeader = getHearder(mContext);
        return task;
    }

    /**
     * 获取用户信息
     */
//    public MyTask getUserInfoApp(NetCallBack mCallBack, Entry base, Context mContext) {
//
//        MyTask task = new MyTask();
//        HashMap<String, String> lHttpHeader = new HashMap<String, String>();
//        task.mUrl = HTTP + getBaseUr(mContext);
//        task.mCallBack = mCallBack;
//        task.mIsEncryption = false;
//        task.mTaskId = MyTask.ACCESS_USER_INFO;
//        lHttpHeader.put("SESSION_ID", SESSION_ID);
//        task.mRequestData = base;
//        task.mRequestHeader = lHttpHeader;
//        return task;
//    }

    /**
     * 根据token 获取session 用户的所有信息
     */

    public MyTask getSession(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url + GET_SESSION;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_SESSION;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 根据token 获取session 用户的所有信息
     */

    public MyTask getIsBluetooth(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = HTTP + getBaseUr(mContext) + GET_IS_BLUE;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_IS_BLUE;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 根据token 获取字典版本
     * getDicts
     */

    public MyTask getDicts(NetCallBack mCallBack, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url2 + FIND_DICTS;
        task.mCallBack = mCallBack;
        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_DICTS;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }

    /**
     * 根据token 获取职业
     * occupation
     * <p>
     * /pos/dicts/terms
     */

    public MyTask getOccupation(NetCallBack mCallBack, String verson, String code, Context mContext) {

        MyTask task = new MyTask();
        task.mUrl = pt_url2 + GET_TERMS + "?dict_code=" + code + "&dict_version=" + verson;
        task.mCallBack = mCallBack;

        task.mIsEncryption = false;
        task.method = MyTask.METHOD_GET;
        task.mTaskId = MyTask.GET_TERMS;
        task.mRequestHeader = getHearder(mContext);

        return task;
    }
}
