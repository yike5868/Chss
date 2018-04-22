package net.greatsoft.main.net;


import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.Dicts;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.Term;
import net.greatsoft.main.rsp.DictsRsp;
import net.greatsoft.main.rsp.EmpsRsp;
import net.greatsoft.main.rsp.FindCurrentUserDistrictsRsp;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.rsp.SessionRsp;
import net.greatsoft.main.rsp.TermsRsp;
import net.greatsoft.main.rsp.TokenRsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhanglin on 16/8/1.
 */
public class NetConn {

    public static final int SUCCESSFUL = 100;
    public static final int EXCEPTION = 208; // 未知的异常


    Context mContext;
    String data;

    NetConn(Context mContext) {
        this.mContext = mContext;
    }

    OkHttpClient client;

    public FuResponse httpPost(MyTask task) throws IOException, ClassNotFoundException {
//        OkHttpClient.Builder httpbuild = new OkHttpClient.Builder();
        client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = task.buildRequest();


        Response response = client.newCall(request).execute();
        FuResponse fuResponseBase = null;
        if (response.isSuccessful()) {
            data = response.body().string();

//            JSONObject jsonObject = JSONObject.parseObject(data);
//
//            String code = jsonObject.getString("code");
//            String message = jsonObject.getString("message");
//            String result = jsonObject.getString("result");



//            String data = jsonObject.getString("data");
//
//            String s = AES.decryptFromBase64(data,task.getAesKey());
//
//            String requestClassName = task.getClass().getName();
//            String responseClassName = requestClassName.replaceFirst("Request", "Response").replace(".rqt.",".rsp.");
//
//            Class responseClass = Class.forName(responseClassName);
            Log.e("response", data);


            if (task.mTaskId == MyTask.FIND_SICK_CHOICE_MEDICINE) {
                MedicineListRsp medicineListRsp = JSON.parseObject(data, MedicineListRsp.class);
                return medicineListRsp;
            }

            if (task.mTaskId == MyTask.GET_TOKEN) {
                TokenRsp tokenRsp = JSONObject.parseObject(data, TokenRsp.class);
                return tokenRsp;
            }

            if (task.mTaskId == MyTask.GET_SESSION) {
                SessionRsp sessionRsp = JSONObject.parseObject(data, SessionRsp.class);
                return sessionRsp;
            }

            if (task.mTaskId == MyTask.FIND_EMPS) {
                List<Emp> empsRsp = JSONArray.parseArray(data, Emp.class);
                List<Emp> empsRsp2 = new ArrayList<>();
                for (int i = 0; i < empsRsp.size(); i++) {
                    if (empsRsp.get(i).getEmp_status() != null && !empsRsp.get(i).getEmp_status().equals("")) {
                        if ("1".equals(empsRsp.get(i).getIs_gw()) && ("1".equals(empsRsp.get(i).getEmp_property()) || "0".equals(empsRsp.get(i).getEmp_property())) && "1".equals(empsRsp.get(i).getEmp_status()))
                            empsRsp2.add(empsRsp.get(i));
                    } else {
                        if ("1".equals(empsRsp.get(i).getIs_gw()) && ("1".equals(empsRsp.get(i).getEmp_property()) || "0".equals(empsRsp.get(i).getEmp_property())))
                            empsRsp2.add(empsRsp.get(i));
                    }

//                    if (item.hasOwnProperty('emp_status')) {
//                        return (item.is_gw === 1 && (item.emp_property === 1 || item.emp_property === 0) && item.emp_status === '1')
//                    } else {
//                        return (item.is_gw === 1 && (item.emp_property === 1 || item.emp_property === 0))
//                    }
                }

                EmpsRsp em = new EmpsRsp();
                em.setEmpList(empsRsp2);
                return em;
            }

            if (task.mTaskId == MyTask.GET_DICTS) {

                List<Dicts> dictsList = JSONArray.parseArray(data, Dicts.class);
                DictsRsp dictsRsp = new DictsRsp();
                dictsRsp.setDictsList(dictsList);
                return dictsRsp;
            }

            if (task.mTaskId == MyTask.GET_TERMS) {
                Log.e("ddd", data);
                List<Term> termList = JSONArray.parseArray(data, Term.class);
                TermsRsp termsRsp = new TermsRsp();
                termsRsp.setTerms(termList);
                return termsRsp;
            }

            if(task.mTaskId == MyTask.FIND_ORG_JURISDICTION){
                FindCurrentUserDistrictsRsp findCurrentUserDistrictsRsp = JSONObject.parseObject(data,FindCurrentUserDistrictsRsp.class);
                return findCurrentUserDistrictsRsp;
            }

            if (task.mTaskId == MyTask.SET_PASSWORD && response.code() == 200) {
                FuResponse fuResponse = new FuResponse("修改密码成功","0");
                return fuResponse;
            }


            fuResponseBase = JSON.parseObject(data, FuResponse.class);


            return fuResponseBase;
        } else {
            if (task.mTaskId == MyTask.SET_PASSWORD) {
                FuResponse fuResponse = new FuResponse("修改密码失败","1");
                return fuResponse;
            }
            return null;
//            throw new IOException("Unexpected code " + response);
        }
    }

}