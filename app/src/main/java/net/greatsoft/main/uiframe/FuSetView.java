package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuSetFragment;
import net.greatsoft.main.view.FuTextView;

/**
 * Created by sunguodong on 2017/5/4.
 */

public class FuSetView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_setPassword;//修改密码
    FuTextView tv_exit;//注销

    public FuSetView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_set_view, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_setPassword:
                mEventCallBack.EventClick(FuSetFragment.EVENT_SETPASSWORD,null);
                break;
            case R.id.tv_exit:
                mEventCallBack.EventClick(FuSetFragment.EVENT_EXIT,null);
                break;
        }
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        tv_setPassword = (FuTextView) mFuView.findViewById(R.id.tv_setPassword);//修改密码
        tv_setPassword.setOnClickListener(this);
        tv_exit = (FuTextView) mFuView.findViewById(R.id.tv_exit);//退出
        tv_exit.setOnClickListener(this);

        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText("设置");
    }
}
