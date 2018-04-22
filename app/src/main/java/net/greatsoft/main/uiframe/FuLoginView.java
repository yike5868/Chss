package net.greatsoft.main.uiframe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.LoginData;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.fragment.FuLoginFragment;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rqt.obj.FuLoginAppRequest;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.Tool;

@SuppressLint("InflateParams")
public class FuLoginView extends FuUiFrameModel implements OnClickListener {

    private EditText mAccount;
    private EditText mPassword;
    private CheckBox mRemember;

    private EditText edit_address;//地址


    public FuLoginView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_login_view, null);
    }

    @Override
    protected void initFuData() {
        initTitle();
        findView();

    }

    @Override
    protected void initWidget() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_entry:
                getLoginRequest();
//			mEventCallBack.EventClick(FuLoginFragment.EVENT_MAIN,null);
                break;
            case R.id.login_find_password:
                mEventCallBack.EventClick(
                        FuLoginFragment.EVENT_LOGIN_FIND_PASSWORD, null);
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack
                        .EventClick(FuLoginFragment.EVENT_LOGIN_REGIST, null);
                break;
        }

    }


    /**
     * 生成登录请求的任务事件
     */
    public void getLoginRequest() {

        String lAccount = mAccount.getText().toString().trim();

        rememberPassword();

        if (null == lAccount || lAccount.length() == 0) {
            ToastUtil.showToast(mContext, "用户名不能为空", Toast.LENGTH_SHORT);
            return;
        }

        String lPassword = mPassword.getText().toString().trim();
        if (null == lPassword || lPassword.length() == 0) {
            ToastUtil.showToast(mContext, "密码不能为空", Toast.LENGTH_SHORT);
            return;
        }
        String baseUrl = edit_address.getText().toString().trim();
        if (null == baseUrl || baseUrl.length() == 0) {
            ToastUtil.showToast(mContext, "地址不能为空", Toast.LENGTH_SHORT);
            return;
        }


//		String lPasswordMD5 = Tool.encryption2(lPassword);

        FuLoginAppRequest lRequest = new FuLoginAppRequest(lAccount, lPassword);
        lRequest.setmAccount(lAccount);
        lRequest.setmPasswordMD5(lPassword);

        lRequest.setmDevcieType("1"); // 1代表Android

        // 原获取设备ID
        TelephonyManager telephonyManager = (TelephonyManager) mContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        String lDeviceID = telephonyManager.getDeviceId();
        lRequest.setmDevcieID(lDeviceID);

        mEventCallBack.EventClick(FuLoginFragment.EVENT_LOGIN_ENTRY, lRequest);
    }

    public void setAccountAndPasswordValue(String account, String password, String baseUrl) {
        mAccount.setText(account.trim());
        mPassword.setText(password.trim());
        if (baseUrl.trim() == null || "".equals(baseUrl.trim())) {

        } else {
            edit_address.setText(baseUrl.trim());
        }
    }

    /**
     * 发现View 给Button设置监听事件
     */
    public void findView() {
        mAccount = (EditText) mFuView.findViewById(R.id.edit_account);
        mPassword = (EditText) mFuView.findViewById(R.id.edit_password);
        edit_address = (EditText) mFuView.findViewById(R.id.edit_address);
        mRemember = (CheckBox) mFuView
                .findViewById(R.id.login_remember_passwords);
        Button login_entry = (Button) mFuView.findViewById(R.id.login_entry);
        TextView login_find_password = (TextView) mFuView
                .findViewById(R.id.login_find_password);
        login_entry.setOnClickListener(this);
        login_find_password.setOnClickListener(this);
    }

    /**
     * 初始化title
     */
    @SuppressLint("NewApi")
    public void initTitle() {
        TextView fu_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        fu_title_center.setText("登录");
        Button fu_title_right_btn = (Button) mFuView
                .findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    public void initData() {
        LoginData loginData = (LoginData) DataSaveManager.getInstance(mContext)
                .getSaveData(SaveTask.KEY_LOGIN);
        String lUserName = loginData.getmUserName();


        if (lUserName != null && lUserName.length() > 0) {
            mAccount.setText(lUserName.trim());
            mAccount.setSelection(mAccount.length());
        }
        if (loginData.getBaseUrl() == null || "".equals(loginData.getBaseUrl())) {
        } else
            edit_address.setText(loginData.getBaseUrl());
        mPassword.setText(loginData.getmPassword());
        mRemember.setChecked(loginData.ismCheckRemeber());
    }

    public void rememberPassword() {

        LoginData loginData = new LoginData();
        loginData.setmUserName(mAccount.getText().toString().trim());
        loginData.setmCheckRemeber(mRemember.isChecked());
        if (mRemember.isChecked()) {
            loginData.setmPassword(mPassword.getText().toString().trim());
        } else {
            loginData.setmPassword(null);
        }
        loginData.setBaseUrl(edit_address.getText().toString().trim());
        SaveTask saveTask = new SaveTask();
        saveTask.setmTaskKey(SaveTask.KEY_LOGIN);
        saveTask.setmData(loginData);
        DataSaveManager.getInstance(mContext).addSaveTask(saveTask);
    }
}
