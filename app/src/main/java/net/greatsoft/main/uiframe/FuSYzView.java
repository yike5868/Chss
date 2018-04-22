package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuSYzFragment;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;

/**
 * Created by zhanglin on 2016/10/31.
 */

public class FuSYzView extends FuUiFrameModel implements View.OnClickListener {

    FuButton btn_list;//档案
    FuButton btn_blood;//血压
    FuButton btn_sugar;//血糖

    public FuSYzView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_s_yz_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        btn_list = (FuButton)mFuView.findViewById(R.id.btn_list);
        btn_blood = (FuButton)mFuView.findViewById(R.id.btn_blood);
        btn_sugar = (FuButton)mFuView.findViewById(R.id.btn_sugar);

        btn_list.setOnClickListener(this);
        btn_blood.setOnClickListener(this);
        btn_sugar.setOnClickListener(this);

        FuTextView fu_title_center = (FuTextView)mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("义诊");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_list:
                mEventCallBack.EventClick(
                        FuSYzFragment.EVENT_LIST, null);
                break;
            case R.id.btn_blood:
                mEventCallBack.EventClick(
                        FuSYzFragment.EVENT_BLOOD, null);
                break;
            case R.id.btn_sugar:
                mEventCallBack.EventClick(
                        FuSYzFragment.EVENT_SUGAR, null);
                break;
        }
    }
}
