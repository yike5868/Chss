package net.greatsoft.main.uiframe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.LoginData;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.fragment.FuSetPasswordFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;

/**
 * Created by sunguodong on 2017/5/4.
 */

public class FuSetPasswordView extends FuUiFrameModel implements View.OnClickListener {

    FuEditText et_oldPassword;//原密码
    FuEditText et_newPassword1;//新密码
    FuEditText et_newPassword2;//新密码
    FuButton bt_sure;//确认

    public FuSetPasswordView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_setpassword_view, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sure:
                LoginData loginData = (LoginData) DataSaveManager.getInstance(mContext)
                        .getSaveData(SaveTask.KEY_LOGIN);
                String oldPassword = et_oldPassword.getText().toString().trim();
                if (null == oldPassword || oldPassword.length() == 0) {
                    ToastUtil.showToast(mContext, "请输入原密码", Toast.LENGTH_LONG);
                    return;
                }
                if (!oldPassword.equals(loginData.getmPassword())) {
                    ToastUtil.showToast(mContext, "密码错误", Toast.LENGTH_LONG);
                    return;
                }
                String newPassword1 = et_newPassword1.getText().toString().trim();
                if (null == newPassword1 || newPassword1.length() < 4 || newPassword1.length() > 18) {
                    ToastUtil.showToast(mContext, "新密码不能为空且长度必须大于3位小于19位", Toast.LENGTH_LONG);
                    return;
                }
                String newPassword2 = et_newPassword2.getText().toString().trim();
                if (null == newPassword2 || newPassword2.length() < 4 || newPassword2.length() > 18) {
                    ToastUtil.showToast(mContext, "新密码不能为空且长度必须大于3位小于19位", Toast.LENGTH_LONG);
                    return;
                }
                if (!newPassword1.equals(newPassword2)) {
                    ToastUtil.showToast(mContext, "两次输入密码不一致", Toast.LENGTH_LONG);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("new_password",et_newPassword1.getString());
                bundle.putString("old_password",et_oldPassword.getString());
                mEventCallBack.EventClick(FuSetPasswordFragment.EVENT_SURE,bundle);

                break;
        }
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        et_oldPassword = (FuEditText) mFuView.findViewById(R.id.et_oldPassword);//原密码
        et_newPassword1 = (FuEditText) mFuView.findViewById(R.id.et_newPassword1);//新密码
        et_newPassword2 = (FuEditText) mFuView.findViewById(R.id.et_newPassword2);//新密码
        bt_sure = (FuButton) mFuView.findViewById(R.id.bt_sure);//确认
        bt_sure.setOnClickListener(this);

        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText("修改密码");
    }
}
