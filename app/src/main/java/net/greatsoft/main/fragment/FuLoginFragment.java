package net.greatsoft.main.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.Constant;
import net.greatsoft.main.EventAction;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.FuUserInfo;
import net.greatsoft.main.activity.FuLoginRegistActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.Dicts;
import net.greatsoft.main.db.po.Term;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rqt.obj.FuLoginAppRequest;
import net.greatsoft.main.rsp.AndroidVerson;
import net.greatsoft.main.rsp.DictsRsp;
import net.greatsoft.main.rsp.EmpsRsp;
import net.greatsoft.main.rsp.FindCurrentUserDistrictsRsp;
import net.greatsoft.main.rsp.MedicineListRsp;
import net.greatsoft.main.rsp.SessionRsp;
import net.greatsoft.main.rsp.TermsRsp;
import net.greatsoft.main.rsp.TokenRsp;
import net.greatsoft.main.rsp.UrlRsp;
import net.greatsoft.main.rsp.obj.FuLoginAppResponse;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuLoginView;
import net.greatsoft.main.view.CustomAlertDialog;
import net.greatsoft.main.view.download.OKClient;
import net.greatsoft.main.view.download.OKDownLoadCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;


@SuppressLint("HandlerLeak")
public class FuLoginFragment extends FragmentParent {

    private final int NET_ERROR = 500; // 网络错误
    private final int DOWN_PROCESS = 600;//下载进度
    private final int GET_ORG = 601;//下载地区
    private final int GET_TOKEN = 602; //获取token
    private final int GET_SESSION = 603;//获取登录信息
    private final int GET_UPLOAD = 604;//获取登录信息

    private final int FIND_SICK_CHOICE_MEDICINE = 610;//下载药品

    private final int GET_IS_BLUE = 611;//获取是否读取蓝牙

    private final int GET_HOST = 605;//获取平台地址

    private final int GET_EMP = 606;//获取所有医生

    private final int GO_MAIN = 607;//去主页

    private final int GET_DICTS = 608; //获取字典版本
    ///occupation
    private final int GET_OCCUPATION = 609;//下载字典

    //authorization
    private final int GET_AUTHORIZATION = 701;//根据品牌型号获取授权


    //与户主关系，民族，家庭证件，人员证件
    private final String[] GET_DICT = new String[]{"relation", "nation", "family_id_type", "id_type", "profession"};
    private int dict_index = 0;

    private final int ERROR = 700;//出现错误信息

    private String phoneNum = "";//手机号


    FuLoginAppRequest lRequest;// 登录所有信息
    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {

            switch (msg.what) {

                case MyTask.FIND_ORG_JURISDICTION:

                    ToolUtil.hidePopLoading();
                    ((FuLoginRegistActivity) getActivity()).goToMainPage();
                    break;

                case GO_MAIN:

                    ToolUtil.hidePopLoading();
                    ((FuLoginRegistActivity) getActivity()).goToMainPage();
                    break;

                case MyTask.LOGIN_APP:

                    FuLoginAppResponse loginAppResponse = (FuLoginAppResponse) msg.obj;

                    FuApp lApp = (FuApp) (getActivity().getApplication());
                    FuUserInfo lAppInfo = lApp.getFuUserInfo();

//				lAppInfo.SESSION_ID = loginAppResponse.getmSessionId();
//                    createAccessUserInfoNetTask();

                    break;
                case MyTask.ACCESS_USER_INFO:

                    ToolUtil.hidePopLoading();
                    ((FuLoginView) mModel).rememberPassword();

                    ((FuLoginRegistActivity) getActivity()).goToMainPage();

                    break;
                case NET_ERROR:

                    ToolUtil.hidePopLoading();

                    ToastUtil.showToast(getActivity(), "网络连接错误！",
                            Toast.LENGTH_LONG);
                    break;
                case MyTask.FIND_EMPS://防止获取不到责任医生
                    ToolUtil.hidePopLoading();

                    ToastUtil.showToast(getActivity(), "无法获取医生人员",
                            Toast.LENGTH_LONG);
                    break;
                case MyTask.FIND_ANDROID_VERSON:
                    AndroidVerson verson = (AndroidVerson) msg.obj;
                    openDownLoadDialog(verson.getUrlStr(), "有重大版本更新！立即下载");
                    break;

                case DOWN_PROCESS:

                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                /**
                 * 下载地区
                 */
                case GET_ORG:
                    findOrgJurisdiction();
                    break;
                /**
                 * 获取token
                 */
                case GET_TOKEN:
                    getToken(lRequest.getmAccount(), lRequest.getmPasswordMD5());
                    break;


                case GET_SESSION:
                    getSession();
                    break;
                case GET_UPLOAD:
                    findAndroidVersionLog();
                    break;
                case GET_HOST:
                    getOpenplatformHost();
                    break;
                case GET_EMP:
                    findEmps();
                    break;
                case GET_DICTS:
                    getDicts();
                    break;
                case GET_OCCUPATION:

                    downOcc();
                    break;

                case ERROR:
                    ToolUtil.hidePopLoading();

                    ToastUtil.showToast(getActivity(), msg.obj.toString(),
                            Toast.LENGTH_SHORT);
                    break;

                case FIND_SICK_CHOICE_MEDICINE:
                    findSickChoiceMedicine();
                    break;

                case GET_AUTHORIZATION:
                    getAuthorization();
                    break;

                case GET_IS_BLUE:
                    getBlueTooth();
                    break;

            }
        }
    };

//    public void showPhone() {
//        final EditText inputServer = new EditText(getContext());
//        inputServer.setInputType(InputType.TYPE_CLASS_NUMBER);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("请输入授权手机号！").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
//                .setNegativeButton("取消", null);
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int which) {
//                ToolUtil.showPopWindowLoading(getContext());
//                phoneNum = inputServer.getText().toString();
//                if (StringUtils.isMobileNO(phoneNum)) {
//
//                    Message message = Message.obtain(mHandler);
//                    message.what = GET_AUTHORIZATION2;
//                    message.sendToTarget();
//                } else {
//                    ToastUtil.showToast(getContext(), "请输入正确的手机号!", Toast.LENGTH_LONG);
//                }
//            }
//        });
//        builder.show();
//    }

    //下载字典
    public void downOcc() {
        if (dict_index >= GET_DICT.length) {
            ToolUtil.hidePopLoading();
            ((FuLoginRegistActivity) getActivity()).goToMainPage();
            return;
        }

        Dicts dicts = sqlHelper.getDicts(GET_DICT[dict_index]);
        Term term = sqlHelper.getTermVersonByCode(GET_DICT[dict_index]);

        if (term == null || !dicts.getDict_version().equals(term.getTerm_version())) {
            getOccupation(dicts.getDict_version(), GET_DICT[dict_index]);
            dict_index++;
        } else {
            dict_index++;
            downOcc();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(FuUiFrameManager.FU_LOGIN,
                getActivity(), new EventCallBack());
        dict_index = 0;
        return mModel.getFuView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((FuLoginView) mModel).initData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (EventAction.BACK_CACHE_DATA == null) {
            return;
        }
        String lAccount = (String) EventAction.BACK_CACHE_DATA.get("Account");
        String lPassword = (String) EventAction.BACK_CACHE_DATA.get("Password");
        String baseUrl = (String) EventAction.BACK_CACHE_DATA.get("BaseUrl");


        EventAction.BACK_CACHE_DATA = null;

        ((FuLoginView) mModel).setAccountAndPasswordValue(lAccount, lPassword, baseUrl);

    }

    /**
     * 根据型号获取授权
     */
    public void getAuthorization() {

        Map<String, Object> map = new HashMap<>();
        map.put("userAccount", lRequest.getmAccount());
        map.put("modelIdentity", Build.MODEL);
        map.put("phoneNumber", phoneNum);


        MyTask lTask = TaskManager.getInstace(getActivity())
                .getAuthorization(getCallBackInstance(), map, getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 下载药品
     */
    public void findSickChoiceMedicine() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findSickChoiceMedicine(getCallBackInstance(), getContext());

        excuteNetTask(lTask, false);
    }

    /**
     * 获取平台地址
     * android/getOpenplatformHost
     */
    public void getOpenplatformHost() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .getOpenplatformHost(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 获取所有医生
     * /pos/emps
     */
    public void findEmps() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findEmps(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 获取地区列表
     */
    public void findOrgJurisdiction() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findOrgJurisdiction(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 获取升级
     * android/findAndroidVersionLog
     */
    public void findAndroidVersionLog() {

        Map<String, Object> map = new HashMap<>();
        map.put("type", "0");

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findAndroidVersionLog(getCallBackInstance(), map, getContext());

        excuteNetTask(lTask, false);
    }

    /**
     * 登录获取token
     */
    public void getToken(String user_xid, String user_key) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .getToken(getCallBackInstance(), user_xid, user_key, getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 根据token 获取 用户基本信息
     * /pos/sessions
     */

    public void getSession() {


        MyTask lTask = TaskManager.getInstace(getActivity())
                .getSession(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 根据token 获取 是否使用蓝牙
     */

    public void getBlueTooth() {


        MyTask lTask = TaskManager.getInstace(getActivity())
                .getIsBluetooth(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 获取字典版本号
     * /pos/dicts
     */

    public void getDicts() {


        MyTask lTask = TaskManager.getInstace(getActivity())
                .getDicts(getCallBackInstance(), getContext());

        excuteNetTask(lTask, true);
    }

    /**
     * 获取职业
     * GET_OCCUPATION
     */
    public void getOccupation(String verson, String code) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .getOccupation(getCallBackInstance(), verson, code, getContext());

        excuteNetTask(lTask, true);
    }


    /**
     * 登录业务流程
     * 获取版本升级信息--首先获取平台地址--获取token--获取授权登录--根据token获取session保存的用户信息--下载地区--下载医生--完成
     */

    public static final int EVENT_LOGIN_ENTRY = 1; // 登录

    public static final int EVENT_LOGIN_FIND_PASSWORD = 2; // 忘记密码

    public static final int EVENT_LOGIN_REGIST = 3; // 注册

    public static final int EVENT_MAIN = 4;//主页面
    AndroidVerson verson;//版本信息

    class EventCallBack implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

            switch (event) {
                case EVENT_LOGIN_ENTRY:
                    lRequest = (FuLoginAppRequest) object;

                    findAndroidVersionLog();
                    break;
                case EVENT_LOGIN_REGIST:
                    ((FuLoginRegistActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_REGIST, null);
                    break;
                case EVENT_LOGIN_FIND_PASSWORD:
                    break;

                case EVENT_MAIN:
                    ToolUtil.hidePopLoading();
                    ((FuLoginRegistActivity) getActivity()).goToMainPage();
                    break;

                case MyTask.FIND_ANDROID_VERSON:
                    ToolUtil.hidePopLoading();
                    openDownLoadDialog("dd", "11");
                    break;
            }
        }
    }


    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

        Message message = Message.obtain(mHandler);


        switch (taskId) {

            case MyTask.FIND_SICK_CHOICE_MEDICINE:

                if (rspObj == null || rspObj.getCode() == null) {
                    message.what = NET_ERROR;
                    message.obj = "下载药品出错，请联系冠新客服人员";
                    message.sendToTarget();
//                    ToastUtil.showToast(getActivity(),"网络连接失败",Toast.LENGTH_LONG);
                    return;
                }

                MedicineListRsp medicineListRsp = (MedicineListRsp) rspObj;
                message.what = GET_EMP;

                sqlHelper.deleteAllSickMedicine();
                if (medicineListRsp.getData().getDiabetes() != null)
                    for (int i = 0; i < medicineListRsp.getData().getDiabetes().size(); i++) {
                        if (medicineListRsp.getData().getDiabetes().get(i) == null)
                            medicineListRsp.getData().getDiabetes().remove(i);
                        else
                            medicineListRsp.getData().getDiabetes().get(i).setType("1");
                    }
                if (medicineListRsp.getData().getHyper() != null)
                    for (int i = 0; i < medicineListRsp.getData().getHyper().size(); i++) {
                        if (medicineListRsp.getData().getHyper().get(i) == null)
                            medicineListRsp.getData().getHyper().remove(i);
                        else
                            medicineListRsp.getData().getHyper().get(i).setType("2");
                    }
                if (medicineListRsp.getData().getSmi() != null)
                    for (int i = 0; i < medicineListRsp.getData().getSmi().size(); i++) {
                        if (medicineListRsp.getData().getSmi().get(i) == null)
                            medicineListRsp.getData().getSmi().remove(i);
                        else
                            medicineListRsp.getData().getSmi().get(i).setType("3");
                    }
                if (medicineListRsp.getData().getCa() != null)
                    for (int i = 0; i < medicineListRsp.getData().getCa().size(); i++) {
                        if (medicineListRsp.getData().getCa().get(i) == null)
                            medicineListRsp.getData().getCa().remove(i);
                        else
                            medicineListRsp.getData().getCa().get(i).setType("4");
                    }
                if (medicineListRsp.getData().getChd() != null)
                    for (int i = 0; i < medicineListRsp.getData().getChd().size(); i++) {
                        if (medicineListRsp.getData().getChd().get(i) == null)
                            medicineListRsp.getData().getChd().remove(i);
                        else
                            medicineListRsp.getData().getChd().get(i).setType("5");
                    }
                sqlHelper.insertSickMedicine(medicineListRsp.getData().getDiabetes());
                sqlHelper.insertSickMedicine(medicineListRsp.getData().getHyper());
                sqlHelper.insertSickMedicine(medicineListRsp.getData().getSmi());
                sqlHelper.insertSickMedicine(medicineListRsp.getData().getCa());
                sqlHelper.insertSickMedicine(medicineListRsp.getData().getChd());


                message.sendToTarget();
                return;


            case MyTask.FIND_ORG_JURISDICTION:
                if (rspObj == null || rspObj.getCode() == null) {
                    message.what = NET_ERROR;
                    message.obj = "地区错误，请联系冠新客服人员";
                    message.sendToTarget();
//                    ToastUtil.showToast(getActivity(),"网络连接失败",Toast.LENGTH_LONG);
                    return;
                }

                if (rspObj == null || rspObj.getCode() == null || "500".equals(rspObj.getCode())) {
                    message.what = NET_ERROR;
                    message.obj = "地区错误，请联系冠新客服人员";
                    message.sendToTarget();
//                    ToastUtil.showToast(getActivity(),"网络连接失败",Toast.LENGTH_LONG);
                    return;
                }

                FindCurrentUserDistrictsRsp rsp = (FindCurrentUserDistrictsRsp) rspObj;
                sqlHelper.deleteAllDistricts();
                sqlHelper.deleteAllSubDistricts();
                sqlHelper.insertAllDistricts(rsp.getData());
//                message.what = FIND_SICK_CHOICE_MEDICINE;
                message.what = GET_IS_BLUE;

                message.sendToTarget();
                break;
            case MyTask.GET_IS_BLUE:
                SharedPreferences spf1 = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed1 = spf1.edit();
                if (rspObj == null) {
                    ed1.putInt("isBluetooth", 0);
                    message.what = FIND_SICK_CHOICE_MEDICINE;
                    message.obj = "获取是否使用蓝牙失败";
                    message.sendToTarget();
                    return;
                }
                if (rspObj.getResult() == null || "".equals(rspObj.getResult())) {
                    ed1.putInt("isBluetooth", 0);
                } else {
                    ed1.putInt("isBluetooth", Integer.parseInt(rspObj.getResult()));
                    Log.e("bluetooth", rspObj.getResult());
                }
                ed1.commit();

                message.what = FIND_SICK_CHOICE_MEDICINE;
                message.sendToTarget();
                break;
            case MyTask.FIND_ANDROID_VERSON:
                if (rspObj == null) {
                    message.what = GET_HOST;
                    message.sendToTarget();
                    break;
                }
                if (!"0".equals(rspObj.getCode())) {
                    message.what = NET_ERROR;
                    message.sendToTarget();
                    message.obj = rspObj.getMessage();
                    break;
                }
                verson = JSONObject.parseObject(rspObj.getResult(), AndroidVerson.class);

                if (verson == null) {
                    verson = new AndroidVerson();
                    verson.setIsTakePhoto(0);
                    verson.setFileZipCapicity(100);
                    verson.setInnerVersion(getVerCode());
                }

                SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = spf.edit();
                ed.putInt("isTakePhoto", verson.getIsTakePhoto() == null ? 0 : verson.getIsTakePhoto());
                ed.putInt("fileZipCapicity", verson.getFileZipCapicity() == null ? 0 : verson.getFileZipCapicity());
                ed.putInt("isTailor", verson.getIsTailor() == null ? 0 : verson.getIsTailor());
//                ed.putInt("isBluetooth", verson.getIsBluetooth() == null ? 0 : verson.getIsBluetooth());
                ed.putInt("isNeedAuthorize", verson.getIsNeedAuthorize() == null ? 0 : verson.getIsNeedAuthorize());
                ed.commit();

                if (verson.getInnerVersion() > getVerCode()) {
                    message.what = taskId;
                    message.obj = verson;
                    message.sendToTarget();
                } else {
                    message.what = GET_HOST;
                    message.sendToTarget();
                }
                break;

            case MyTask.GET_TOKEN:
                if (rspObj == null) {
                    message.what = NET_ERROR;
                    message.obj = "token失败，请联系冠新客服人员";
                    message.sendToTarget();
                    return;
                }

                TokenRsp tokenRsp = (TokenRsp) rspObj;

                if (tokenRsp.getError_description() != null) {
                    message.what = ERROR;
                    message.obj = tokenRsp.getError_description();
                    message.sendToTarget();
                    return;
                }
//                TaskManager.access_token = "8a07c04a1eea4504b1938b6a07689569";

                SharedPreferences preferences = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("access_token", tokenRsp.getAccess_token());
                editor.commit();

                message.what = GET_SESSION;

                message.sendToTarget();
                break;
            case MyTask.GET_AUTHORIZATION:
                if (rspObj == null) {
                    message.what = ERROR;
                    message.obj = "获取授权登录失败，请联系冠新客服人员";
                    message.sendToTarget();
                    return;
                } else if (!"0".equals(rspObj.getCode())) {
                    message.what = ERROR;
                    message.obj = rspObj.getMessage();
                    message.sendToTarget();
                    return;
                }
                message.what = GET_ORG;
                message.sendToTarget();
                break;

            case MyTask.GET_SESSION:

                if (rspObj == null) {
                    message.what = ERROR;
                    message.obj = "Session失败，请联系冠新客服人员";
                    message.sendToTarget();
                    return;
                }
                SessionRsp sessionRsp = (SessionRsp) rspObj;
                sqlHelper.getSessionRspDap().deleteAll();
                sqlHelper.getSessionRspDap().insert(sessionRsp);

                SharedPreferences preferences1 = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = preferences1.edit();

                editor1.putString("con_drl", sessionRsp.getPos_id());
                editor1.putString("districtId", sessionRsp.getDistrict_id());
                editor1.putString("districtLev", sessionRsp.getDistrict_level());
                editor1.putString("emp_id", sessionRsp.getEmp_id());
                editor1.putString("pos_name", sessionRsp.getPos_name());
                editor1.putString("emp_name", sessionRsp.getEmp_name());
                editor1.putString("emp_mobile", sessionRsp.getEmp_mobile());
                phoneNum = sessionRsp.getEmp_mobile();
                editor1.commit();

                if (verson.getIsNeedAuthorize() == null || verson.getIsNeedAuthorize() == 0) {
                    message.what = GET_ORG;
                    message.obj = sessionRsp;
                } else {
                    message.what = GET_AUTHORIZATION;
                }
                message.sendToTarget();
                break;
            case MyTask.GET_OPEN_PLAT_FORM_HOST:
                if (rspObj == null || rspObj.getResult() == null) {
                    message.what = ERROR;
                    message.obj = "地址错误，请联系冠新客服人员";
                    message.sendToTarget();
                    return;
                }
                UrlRsp urlRsp = JSONObject.parseObject(rspObj.getResult(), UrlRsp.class);


                String urlStr = urlRsp.getOpenplatformTokenUrl();

                Matcher m = Pattern.compile("^http://[^/]+").matcher(urlStr);
                while (m.find()) {
                    System.out.println(m.group());
                    TaskManager.pt_url = m.group();
                }

                TaskManager.pt_url2 = urlRsp.getOrgEmpUrl();

                message.what = GET_TOKEN;
                message.sendToTarget();
                break;
            case MyTask.FIND_EMPS:
                if (rspObj == null) {
                    message.what = NET_ERROR;
                    message.sendToTarget();
                    break;
                }
                sqlHelper.getEmpDao().deleteAll();
                EmpsRsp empsRsp = (EmpsRsp) rspObj;
                //防止获取不到责任医生
                if (empsRsp.getEmpList().size() == 0 || empsRsp.getEmpList() == null) {
                    message.what = MyTask.FIND_EMPS;
                    message.sendToTarget();
                    break;
                }
                sqlHelper.getEmpDao().insertInTx(empsRsp.getEmpList());
                message.what = GET_DICTS;
                message.sendToTarget();
                break;

            case MyTask.GET_DICTS:
                if (rspObj == null) {
                    message.what = NET_ERROR;
                    message.sendToTarget();
                    break;
                }
                sqlHelper.getDictsDao().deleteAll();
                DictsRsp dictsRsp = (DictsRsp) rspObj;
                sqlHelper.getDictsDao().insertInTx(dictsRsp.getDictsList());
                message.what = GET_OCCUPATION;
                message.sendToTarget();
                break;
            case MyTask.GET_TERMS:
                if (rspObj == null) {
                    message.what = NET_ERROR;
                    message.sendToTarget();
                    break;
                }
                sqlHelper.deleteTerm(GET_DICT[dict_index - 1]);
                Dicts dicts = sqlHelper.getDicts(GET_DICT[dict_index - 1]);
                TermsRsp termsRsp = (TermsRsp) rspObj;

                for (int i = 0; i < termsRsp.getTerms().size(); i++) {
                    termsRsp.getTerms().get(i).setTerm_version(dicts.getDict_version());
                }


                sqlHelper.getTermDao().insertInTx(termsRsp.getTerms());
                message.what = GET_OCCUPATION;
                message.sendToTarget();
                break;

        }
    }

    public int getVerCode() {

        int verCode = -1;
        try {
            verCode = getActivity().getPackageManager().getPackageInfo(
                    "net.greatsoft.main", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            verCode = -1;
        }
        return verCode;
    }

    public void openDownLoadDialog(final String url, String avText) {

        CustomAlertDialog.show(getContext(), CustomAlertDialog.DOUBLE_BUTTON_HTML_TEXTVIEW,
                (avText == null || avText.trim().length() < 1) ? "有重大版本更新！立即下载" : avText, "提示",
                new String[]{"立即下载", "退出程序"}, new CustomAlertDialog.UzCustomAlertDialogCallBack() {

                    @Override
                    public void onClickConfirm(int type) {

                        download(url);
                    }

                    @Override
                    public void onClickCancel(int type) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);
//                        mEventCallBack.EventClick(JkxWelcomeFragment.EVENT_APP_FINISH, null);
                    }
                });
    }
    /* 下载 */

    private OKClient client = new OKClient(new OkHttpClient());

    public void download(String url) {

        File file = new File(Constant.BASE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File((Constant.DB_APK));
        if (file.exists())
            file.delete();


        client.download(url
                , new File(Constant.DB_APK)
                , false /* 这个参数表示是否断线续传 */
                , new OKDownLoadCallback() {
                    public void onComplete(File file) {
                        ToolUtil.hidePopLoading();
                        openFile(file);
//                        Toast.makeText(MainActivity.this, "over", Toast.LENGTH_SHORT).show();
                    }

                    public void onError(int errCode) {
                        Toast.makeText(getContext(), "请重新下载\nerror : " + errCode, Toast.LENGTH_SHORT).show();
                        ToolUtil.hidePopLoading();
                    }

                    public void onProgress(int current) {
                        Message message = Message.obtain(mHandler);
                        message.what = DOWN_PROCESS;
                        message.obj = "正在下载...." + current;
                        message.sendToTarget();
                    }
                });
    }

    private void openFile(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        startActivity(intent);
    }


    @Override
    protected void netErrorChild(int taskId, String msg) {
        Message message = Message.obtain(mHandler);
        message.what = NET_ERROR;
        message.obj = msg;
        message.sendToTarget();
    }

    @Override
    protected void cancelChild(int taskId) {

    }


}
