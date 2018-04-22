// Copyright (C) 2012-2013 UUZZ All rights reserved
package net.greatsoft.main.net;

import android.util.Log;

import com.alibaba.fastjson.JSON;

import net.greatsoft.main.Constant;
import net.greatsoft.main.control.HttpConstansType;
import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.tool.encrypt.AES;
import net.greatsoft.main.tool.encrypt.AESKeyUtils;
import net.greatsoft.main.tool.encrypt.RSA;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import static okhttp3.RequestBody.create;

public class MyTask {

    public static final int DOWNLOAD_FILE = 100;
    public static final int UPLOAD_FILE = 101;

    public static final int UPDATE_APP = 103;
    public static final int LOGIN_APP = 104;
    public static final int REGIST_APP = 105;
    public static final int VALIDATE_CODE = 106;
    public static final int FIND_PASSWORD = 107;
    public static final int ACCESS_USER_INFO = 116;

    public static final int ERROR = 2;

    public static final int SAVE_FAMILY = 117;    //上传家庭

    public static final int SAVE_SMI_FOLLOWUP = 139;    //上传精神病随访

    public static final int SAVE_SMI_INFO = 153;//上传精神病补充表

    public static final int UPDATE_FAMILY_INFO = 126;//更新家庭

    public static final int FIND_FAMILY_LIST = 123;//获取家庭

    public static final int FIND_FAMILY = 125;//获取单个家庭

    public static final int FIND_PERSON_LIST = 124;//获取人员

    public static final int FIND_PERSON = 128;//获取单个人员
    public static final int FIND_FATHERLIST = 129;//获取家庭父亲集合
    public static final int FIND_MOTHERLIST = 130;//获取家庭母亲集合

    public static final int FIND_LAST_MATERNAL_REGISTER = 150;//获取单个孕产妇

    public static final int SAVE_ELDER_COGNITION = 140;//保存老年人认知

    public static final int SAVE_ELDER_TCM_HEALTH = 154;//保存老年人中医药

    public static final int SAVE_TUBERCULOSIS_FIRST_FOLLOWUP = 155;//保存肺结核第一次

    public static final int SAVE_TUBERCULOSIS_FOLLOWUP = 156;//保存肺结核随访

    public static final int UPDATE_TUBERCULOSIS_INFO = 159;//更新肺结核基本信息

    public static final int SAVE_CDCVACC_REPORT = 165;//保存肺结核第一次

    public static final int SAVE_ELDER_SELFCARE_ABILITY = 151;//老年人自理能力

    public static final int FIND_SICK_CHOICE_MEDICINE = 188; //获取药品

    public static final int SAVE_PERSON = 129;//保存人员

    public static final int SAVE_HEALTH_EXAM = 136;//保存体检

    public static final int SAVE_CHILD_HOME_VISIT = 141;//保存新生儿访视

    public static final int SAVE_CHILD_HEALTH_EXAM = 145;//保存 儿童健康检查

    public static final int SAVE_MATERNAL_FIRST_FOLLOWUP = 146;//保存妇女第一次产前随访

    public static final int SAVE_MATERNAL_FOLLOWUP = 147;//保存妇女第2-5次产前随访
    //    maternalFollowup/saveMaternalFollowup
    public static final int SAVE_MATERNAL_FOLLOWUP_AFTER = 148;//保存产后随访

    public static final int SAVE_POSTPARTUM_HEALTHEXAM = 149;//保存产后42天随访

    public static final int SAVE_CORONARYHEART_FOLLOWUP = 152;//保存冠心病随访
    public static final int SAVE_CEREBRALAPOPLEXY_FOLLOWUP = 153;//保存脑卒中随访

    public static final int UPDATE_PERSONINFO = 132;//更新人员

    public static final int SAVE_HYPER_FOLLOWUP = 130; //保存高血压随访
    public static final int SET_PASSWORD = 199; //修改密码

    public static final int SAVE_HYPER_INFO = 161;//保存高血压专档
    public static final int SAVE_DISABILITY_HEAR = 171;//保存听力言语残疾随访
    public static final int SAVE_DISABILITY_LIMB = 173;//保存肢体残疾随访
    public static final int SAVE_DISABILITY_INTELLIGENCE = 172;//保存智力残疾随访
    public static final int SAVE_DISABILITY_VISUAL = 174;//保存视力残疾随访
    public static final int SAVE_CHILD_INFO = 168;//保存儿童专档
    public static final int SAVE_CORONARY_INFO = 165;//保存冠心病专档
    public static final int SAVE_TUBERCULOSIS_INFO = 167;//保存肺结核专档
    public static final int SAVE_CEREBRAL_INFO = 166;//保存脑卒中专档
    public static final int SAVE_ELDER_INFO = 163;//保存老年人花名册

    public static final int SAVE_DIABETES_FOLLOWUP = 131;
    public static final int SAVE_DIABETES_INFO = 162;//保存糖尿病专档
    public static final int SAVE_MATERNAL_REGISTER = 163;//保存孕产登记
    public static final int FIND_ORG_JURISDICTION = 118; //获取地区列表

    public static final int FIND_EMPS = 134;//获取医生

    public static final int GET_OPEN_PLAT_FORM_HOST = 135;//获取地址

    public static final int GET_AUTHORIZATION = 181;// 获取授权信息

    public static final int GET_AUTHORIZATION2 = 182;// 获取授权信息

    public static final int FIND_ANDROID_VERSON = 132; //获取地区列表

    public static final int GET_TOKEN = 133; //获取地区列表

    public static final int GET_SESSION = 138; //获取当前用户信息

    public static final int GET_IS_BLUE = 175;//获取是否蓝牙身份证

    public static final int GET_DICTS = 142;//获取字典版本

    public static final int GET_TERMS = 143;//获取字典

    public static final int GET_SUBDISTRICT = 119; //获取地区列表
    public static final int GET_BUILDING = 120; //获取楼栋列表
    public static final int GET_UNIT = 121;//获取单元信息
    public static final int GET_ROOM = 122;//获取房间信息

    public static final int UP_LOAD_FILE = 157;//上传图片
    public static final int UP_LOAD_PERSONINFO_FILE = 158;//上传人员图片


    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_PUT = "PUT";

    public int mTaskId; // 任务标志位

    public String mUrl; // 网络请求的地址

    public boolean mIsEncryption; // 是否加密解密

    public NetCallBack mCallBack; // 回调接口

    public Entry mRequestData; // 请求数据的对象

    public String method;//请求方式

    public File[] files;//需要上传的文件

    //	public List<Object> mRequestList;//请求数据的列表
    public Map<String, Object> paramMap; //请求数据的列表

    public HashMap<String, String> mRequestHeader; // 请求数据的请求头

//	public boolean post_get = true;//post true  get false

    public Handler handler;//uihandler

    private String aesKey;

    protected String stringOfPostBody(Object object) {

        String jsonStr = JSON.toJSONString(object);
        jsonStr = jsonStr.replaceAll("chdSymptoms2", "chdSymptoms");
        jsonStr = jsonStr.replaceAll("manageGroup2", "manageGroup");
        if (Constant.isEncrypt) {
            //AES加密
            aesKey = AESKeyUtils.getKey();
            byte[] data = jsonStr.getBytes();
            String encrypt_data = AES.encryptToBase64(jsonStr, aesKey);
            //RSA加密
            try {
                String encrypt_key = RSA.encrypt(aesKey, Constant.PUBLIC_KEY);
                HashMap<String, String> strHashMap = new HashMap<>();
                strHashMap.put("data", encrypt_data);
                strHashMap.put("encryptKey", encrypt_key);
                String json = JSON.toJSONString(strHashMap);
                return URLEncoder.encode(json, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("WTRequest", "Something is wrong with RSA");
            }
        } else {
            Log.e("aaaaaaa",jsonStr);
            return jsonStr;
        }


        return null;
    }


    public Request getFileRequest() {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (paramMap != null)
            for (String key : paramMap.keySet()) {
                builder.addFormDataPart(key, paramMap.get(key).toString());
            }
        if (files != null)
            for (int i = 0; i < files.length; i++) {
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"" + files[i].getName() + "\""),
                        RequestBody.create(MediaType.parse("image/png"), files[i]));
            }
//        builder.addPart(stringOfPostBody(mRequestData));
//        RequestBody body1 = create(HttpConstansType.MEDIA_TYPE_JSON, stringOfPostBody(mRequestData));
//        builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"androidFileRecord\";"),body1);
        builder.addFormDataPart("androidFileRecord", stringOfPostBody(mRequestData));

        RequestBody body = builder.build();

        return new Request.Builder().url(mUrl).addHeader("access_token", mRequestHeader.get("access_token")).addHeader("Content-Type", "application/json").addHeader("charset", "UTF-8").post(body).build();

    }


    public Request buildRequest() {

        if (mTaskId == UP_LOAD_FILE || mTaskId == UP_LOAD_PERSONINFO_FILE) {
            return getFileRequest();
        }

        RequestBody body = create(HttpConstansType.MEDIA_TYPE_JSON, stringOfPostBody(mRequestData));

        if (paramMap != null) {

            body = create(HttpConstansType.MEDIA_TYPE_JSON, stringOfPostBody(paramMap));
        }

        Request request;
        if (method == METHOD_GET)
            request = new Request.Builder().url(mUrl)
                    .addHeader("access_token", mRequestHeader.get("access_token"))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "UTF-8").method(method, null).build();
        else
            request = new Request.Builder().url(mUrl)
                    .addHeader("access_token", mRequestHeader.get("access_token"))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "UTF-8").method(method, body).build();


//		if(post_get) {
//			request = new Request.Builder().url(mUrl)
//					.addHeader("access_token", TaskManager.access_token)
//					.addHeader("Content-Type", "application/json")
//					.addHeader("charset", "UTF-8").post(body).build();
//		}else {
//			request = new Request.Builder()
//					.url(mUrl)
//					.addHeader("access_token",  TaskManager.access_token)
//					.addHeader("Content-Type", "application/json")
//					.addHeader("charset", "UTF-8")
//					.build();
//		}
        return request;
    }

    public String getAesKey() {
        return aesKey;
    }

}
