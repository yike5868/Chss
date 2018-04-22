// Copyright (C) 2012-2013 UUZZ All rights reserved
package net.greatsoft.main.net;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;

import net.greatsoft.main.control.FuRequset;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.family.Family;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.net.NetManager.netOverCallBack;
import net.greatsoft.main.rqt.obj.FuLoginAppRequest;
import net.greatsoft.main.rqt.obj.FuRegistAppRequest;
import net.greatsoft.main.rqt.obj.FuUpdateAppRequest;
import net.greatsoft.main.rsp.obj.FuLoginAppResponse;
import net.greatsoft.main.rsp.obj.FuRegistAppResponse;
import net.greatsoft.main.rsp.obj.FuUpdateAppResponse;

import java.util.HashMap;


/**
 * @类 名: NetTaskThread
 * @类描述: 网络交互线程
 */

public class NetTaskThread implements Runnable {

    private Context mContext;

    private MyTask mTask; // 当前执行的任务

    private netOverCallBack mCallBack;

    private NetConn mConnect; // 网络联网对象

    public NetTaskThread(Context context, MyTask task, netOverCallBack back) {
        mContext = context;
        mTask = task;
        mCallBack = back;
        mCancel = false;
        mConnect = new NetConn(mContext);
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {

        if (!isOpenNetwork()) {
            if (mTask.mCallBack != null) {
                mTask.mCallBack.netError(mTask.mTaskId, "当前无可用网络,请设置网络");
            }
            mCallBack.NetThreadOver(mTask.mTaskId);
            return;
        }

        if (mCancel) {

            if (mTask.mCallBack != null) {
                mTask.mCallBack.cancel(mTask.mTaskId);
            }

            mCallBack.NetThreadOver(mTask.mTaskId);
            return;
        }

        if (mTask.mUrl == null || mTask.mUrl.equals("")) {

            if (mTask.mCallBack != null) {
                mTask.mCallBack.netError(mTask.mTaskId, "网络地址错误");
            }

            mCallBack.NetThreadOver(mTask.mTaskId);

            return;
        }
        FuResponse lRsp = null;
        int lRspState = 0;

        switch (mTask.mTaskId) {
            case MyTask.DOWNLOAD_FILE:

//			try {
//				lRspState = mConnect.downFile(mTask);
//			} catch (Exception e) {
//				lRspState = NetConn.EXCEPTION;
//			}

                break;
            case MyTask.UPLOAD_FILE:

//			try {
//				lRspState = mConnect.httpMultiPart(mTask);
//			} catch (Exception e) {
//				lRspState = NetConnect.EXCEPTION;
//			}

                break;

            default:

                HashMap<String, Object> paramMap = getRequestData(mTask);

                try {
                    lRsp = mConnect.httpPost(mTask);
//				lRsp = mConnect.httpPost(mTask.mRequestData);
                } catch (Exception e) {
                    e.printStackTrace();
//				lRspState = NetConnect.EXCEPTION;
                }

                break;
        }


        if (mCancel) {

            if (mTask.mCallBack != null) {
                mTask.mCallBack.cancel(mTask.mTaskId);
            }

            mCallBack.NetThreadOver(mTask.mTaskId);
            return;
        }


        if (mCancel) {

            if (mTask.mCallBack != null) {
                mTask.mCallBack.cancel(mTask.mTaskId);
            }
            mCallBack.NetThreadOver(mTask.mTaskId);
            return;
        }

        if (mTask.mCallBack != null) {
            mTask.mCallBack.loadData(mTask.mTaskId, lRsp);
        }

        mCallBack.NetThreadOver(mTask.mTaskId);
    }

    /**
     * 解析网络数据
     *
     * @param data 网络返回的数据
     * @return
     */
    private FuResponse parserNetData(String data) {

        if (data == null) {
            return null;
        }

        FuResponse base = null;

        switch (mTask.mTaskId) {

            case MyTask.UPDATE_APP:

                base = parserUpdateAppData(data);

                break;
            case MyTask.LOGIN_APP:
                base = parserLoginData(data);
                break;
            case MyTask.REGIST_APP:
                base = parserRegistData(data);
                break;
            case MyTask.ACCESS_USER_INFO:
                break;

        }

        return base;

    }

    /**
     * 组织请求数据
     *
     * @param task 请求对象
     * @return
     */
    private HashMap<String, Object> getRequestData(MyTask task) {

        HashMap<String, Object> paramMap;

        if (task == null) {

            return null;

        } else {
            paramMap = new HashMap<String, Object>();

            switch (mTask.mTaskId) {

                case MyTask.UPDATE_APP:

                    FuUpdateAppRequest lUpdateApp = (FuUpdateAppRequest) mTask.mRequestData;

                    paramMap.put("AV_TYPE", lUpdateApp
                            .getmType());

                    paramMap.put("AV_CHANNEL", lUpdateApp
                            .getAV_CHANNEL());

                    break;
                case MyTask.LOGIN_APP:
                    FuLoginAppRequest lLoginApp = (FuLoginAppRequest) mTask.mRequestData;

                    paramMap.put("MOBILE", lLoginApp
                            .getmAccount());
                    paramMap.put("PASSWORD", lLoginApp
                            .getmPasswordMD5());

                    paramMap.put("DEVICE_TYPE", lLoginApp
                            .getmDevcieType());
                    paramMap.put("DEVICE_ID", lLoginApp
                            .getmDevcieID());

                    break;
//                case MyTask.REGIST_APP:
//                    FuRegistAppRequest lRegistApp = (FuRegistAppRequest) mTask.mRequestData;
//
//                    paramMap.put("RESIDENT_NAME", lRegistApp
//                            .getmRealName());
//                    paramMap.put("RESIDENT_PASSWD", lRegistApp
//                            .getmPasswordMD5());
//                    paramMap.put("RESIDENT_SFCODE", lRegistApp
//                            .getmIdNumber());
//                    paramMap.put("RESIDENT_MOBILE", lRegistApp
//                            .getmPhone());
//                    paramMap.put("RESIDENT_PROVINCE", "");
//                    paramMap.put("SECURITY_CODE", lRegistApp
//                            .getmValidateCode());
//                    break;
                case MyTask.SAVE_FAMILY:
                    FamilyInfo familyInfo = (FamilyInfo) mTask.mRequestData;
                    paramMap.put("data", com.alibaba.fastjson.JSON.toJSON(familyInfo));
                    break;

            }

        }

        return paramMap;
    }


//    private List<NameValuePair> getRequestData(JkxRequsetBase data) {
//
//        List<NameValuePair> lJect = null;
//
//        if (data == null) {
//
//            return null;
//
//        } else {
//
//            lJect = new ArrayList<NameValuePair>();
//
//            switch (mTask.mTaskId) {
//            }
//        }
//    }



    private boolean mCancel;

    public void cancel() {

        mCancel = true;
    }

    /**
     * 对网络连接状态进行判
     *
     * @return true, 可用 false 不可用
     */
    private boolean isOpenNetwork() {

        ConnectivityManager connManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }

        return false;
    }

	/*----------------------------------解析-------------------------------------*/


    /**
     * 版本信息
     */
    private FuResponse parserUpdateAppData(String data) {
        FuUpdateAppResponse lResponse = new FuUpdateAppResponse();

        try {
            JSONObject lJsonObj = new JSONObject(data);

            if (!lJsonObj.isNull("APP_NAME")) {

                lResponse.setmAppName(lJsonObj.getString("APP_NAME"));
            }
            if (!lJsonObj.isNull("AV_VERSION")) {

                lResponse.setmAvVersion(lJsonObj.getString("AV_VERSION"));
            }
            if (!lJsonObj.isNull("AV_ISMAJOR")) {

                lResponse.setmAvIsMajor(lJsonObj.getString("AV_ISMAJOR"));
            }
            if (!lJsonObj.isNull("AV_URL")) {

                lResponse.setmAvUrl(lJsonObj.getString("AV_URL"));
            }
            if (!lJsonObj.isNull("AV_TEXT")) {

                lResponse.setmAvText(lJsonObj.getString("AV_TEXT"));
            }
            if (!lJsonObj.isNull("AV_CTIME")) {

                lResponse.setmAvCTime(lJsonObj.getString("AV_CTIME"));
            }

            if (!lJsonObj.isNull("AV_RESOURCE")) {

                lResponse.setAV_RESOURCE(lJsonObj.getString("AV_RESOURCE"));
            }

        } catch (JSONException e) {
            lResponse = null;
        }

        return lResponse;
    }

    /**
     * 登录数据解析
     */
    private FuResponse parserLoginData(String data) {

        FuLoginAppResponse loginAppResponse = new FuLoginAppResponse();

        try {

            JSONObject lJsonObj = new JSONObject(data);

            if (!lJsonObj.isNull("SESSION_ID")) {

                loginAppResponse
                        .setmSessionId(lJsonObj.getString("SESSION_ID"));
            }

        } catch (JSONException e) {
            loginAppResponse = null;
        }
        return loginAppResponse;
    }

    /**
     * 注册数据解析
     */
    private FuResponse parserRegistData(String data) {

        FuRegistAppResponse regidtAppResponse = new FuRegistAppResponse();

        try {

            JSONObject lJsonObj = new JSONObject(data);

            if (!lJsonObj.isNull("RESIDENT_ID")) {

                regidtAppResponse.setmResidentId(lJsonObj
                        .getString("RESIDENT_ID"));

            }

        } catch (JSONException e) {
            regidtAppResponse = null;
        }
        return regidtAppResponse;
    }


}
