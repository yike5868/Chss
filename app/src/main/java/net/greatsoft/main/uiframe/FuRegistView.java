package net.greatsoft.main.uiframe;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuRegistFragment;
import net.greatsoft.main.rqt.obj.FuRegistAppRequest;
import net.greatsoft.main.tool.IdCardValidator;
import net.greatsoft.main.tool.PhoneValidator;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.Tool;


public class FuRegistView extends FuUiFrameModel implements OnClickListener {

	private EditText mRealName;
	private EditText mIdNumber;
	private EditText mPassword;
	private EditText mAgainPassword;
	private EditText mPhone;
	private EditText mValidateCode;
	private CheckBox mAgreeTerms;
	private Button mGetValidateCode;

	public FuRegistView(Context cxt, FuEventCallBack callBack) {
		super(cxt, callBack);
	}

	@Override
	protected void createFuLayout() {
		mFuView = LayoutInflater.from(mContext).inflate(
				R.layout.fu_regist_view, null);
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
		case R.id.btn_getValidateCode:
			getValidateCodeRequest();
			break;
		case R.id.reg_btn_register:
			getRegistRequest();
			break;
		case R.id.reg_agree_terms_textview:
			mEventCallBack.EventClick(
					FuRegistFragment.EVENT_REGIST_READ_TERMS, null);
			break;
		case R.id.fu_title_left_btn:
			mEventCallBack.EventClick(FuRegistFragment.EVENT_BACK, null);
			break;
		}

	}

	public void getValidateCodeRequest() {
		String lPhone = mPhone.getText().toString().trim();
		String errorMsg = PhoneValidator.validate(lPhone);
		if (null != errorMsg) {
			ToastUtil.showToast(mContext, errorMsg, Toast.LENGTH_SHORT);
			return;
		}
		String lRandomNumber = Tool.GetRandomNumber(3);
		mValidateCode.setHint("序号 :" + lRandomNumber);
		mGetValidateCode.setClickable(false);

	}

	public void getRegistRequest() {
		String lRealName = mRealName.getText().toString().trim();
		if (null == lRealName || lRealName.length() == 0) {
			ToastUtil.showToast(mContext, "用户名不能为空", Toast.LENGTH_SHORT);
			return;
		}
		String lIdNumber = mIdNumber.getText().toString().trim();
		if (null == lIdNumber || lIdNumber.length() == 0) {
			ToastUtil.showToast(mContext, "身份证号不能为空", Toast.LENGTH_SHORT);
			return;
		}
		
		boolean flag = new IdCardValidator().isValidatedAllIdcard(lIdNumber);
		
		if (!flag) {
			ToastUtil.showToast(mContext, "身份证号码格式有误", Toast.LENGTH_SHORT);
			return;
		}

		String lPassword = mPassword.getText().toString().trim();
		if (null == lPassword || lPassword.length() == 0) {
			ToastUtil.showToast(mContext, "密码不能为空", Toast.LENGTH_SHORT);
			return;
		}
		String lAgainPassword = mAgainPassword.getText().toString().trim();
		if (!lPassword.equals(lAgainPassword)) {
			ToastUtil.showToast(mContext, "两次密码不一致", Toast.LENGTH_SHORT);
			return;
		}
		String errorMsg = PhoneValidator.validate(mPhone.getText().toString()
				.trim());
		if (null != errorMsg) {
			ToastUtil.showToast(mContext, errorMsg, Toast.LENGTH_SHORT);
			return;
		}

		String lValidateCode = mValidateCode.getText().toString().trim();
		if (null == lValidateCode || lValidateCode.length() == 0) {
			ToastUtil.showToast(mContext, "验证码不能为空", Toast.LENGTH_SHORT);
			return;
		}
		boolean lIsAgreeTerms = mAgreeTerms.isChecked();
		if (!lIsAgreeTerms) {
			ToastUtil.showToast(mContext, "请同意条款", Toast.LENGTH_SHORT);
			return;
		}
		FuRegistAppRequest lRequest = new FuRegistAppRequest();
		lRequest.setmRealName(lRealName);
		lRequest.setmIdNumber(lIdNumber);
		lRequest.setmPasswordMD5(Tool.encryption2(lAgainPassword));
		lRequest.setmPhone(mPhone.getText().toString().trim());
		lRequest.setmValidateCode(lValidateCode);

		mEventCallBack.EventClick(FuRegistFragment.EVENT_REGIST_REGIST,
				lRequest);

	}

	public void setForResultValue() {
		Map<String, String> lValue = new HashMap<String, String>();

		lValue.put("Account", mPhone.getText().toString().trim());
		lValue.put("Password", mPassword.getText().toString().trim());
		mEventCallBack.EventClick(
				FuRegistFragment.EVENT_REGIST_REGIST_SUCCESS, lValue);
	}

	public void setValidateCodeText(String str) {
		mGetValidateCode.setText(str);
	}

	public void resetGetValidateCodeButton() {
		mValidateCode.setHint("regist_verification_code");
		mGetValidateCode.setText("regist_get_verification_code");
		mGetValidateCode.setClickable(true);
	}

	/**
	 * 发现View 给Button设置监听事件
	 */
	public void findView() {
		mRealName = (EditText) mFuView.findViewById(R.id.reg_realName);
		mIdNumber = (EditText) mFuView.findViewById(R.id.reg_idnumber);
		mPassword = (EditText) mFuView.findViewById(R.id.reg_password);
		mAgainPassword = (EditText) mFuView
				.findViewById(R.id.reg_again_password);
		mPhone = (EditText) mFuView.findViewById(R.id.reg_phone);
		mValidateCode = (EditText) mFuView
				.findViewById(R.id.reg_verification_code);
		mAgreeTerms = (CheckBox) mFuView.findViewById(R.id.reg_agree_terms);
		TextView reg_agree_terms_textview = (TextView) mFuView
				.findViewById(R.id.reg_agree_terms_textview);
		mGetValidateCode = (Button) mFuView
				.findViewById(R.id.btn_getValidateCode);
		Button reg_btn_register = (Button) mFuView
				.findViewById(R.id.reg_btn_register);
		reg_agree_terms_textview.setOnClickListener(this);
		mGetValidateCode.setOnClickListener(this);
		reg_btn_register.setOnClickListener(this);
	}

	/**
	 * 初始化title
	 */
	public void initTitle() {
		Button jkx_title_left_btn = (Button) mFuView
				.findViewById(R.id.fu_title_left_btn);
		jkx_title_left_btn.setVisibility(View.VISIBLE);
		jkx_title_left_btn.setOnClickListener(this);
		jkx_title_left_btn.setBackgroundResource(R.mipmap.bt_public_delete);
		TextView jkx_title_center = (TextView) mFuView
				.findViewById(R.id.fu_title_center);
		jkx_title_center.setText("regist_title");
	}

}
