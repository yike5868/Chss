package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuGPMainFragment;
import net.greatsoft.main.view.FuButton;

/**
 * Created by zhanglin on 2016/11/10.
 */

public class FuGPMainView extends FuUiFrameModel implements View.OnClickListener {

    FuButton btn_appointment;//电话预约
    FuButton btn_follow; //随访

    FuButton btn_statistics;//统计


    public FuGPMainView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }
    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_gp_main_view, null);
    }


    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        btn_appointment  = (FuButton)mFuView.findViewById(R.id.btn_appointment);
        btn_follow = (FuButton)mFuView.findViewById(R.id.btn_follow);
        btn_statistics = (FuButton)mFuView.findViewById(R.id.btn_statistics);


        btn_appointment.setOnClickListener(this);
        btn_follow.setOnClickListener(this);
        btn_statistics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_appointment:
                mEventCallBack.EventClick(
                        FuGPMainFragment.EVENT_APPOINTMENT, null);
                break;
            case R.id.btn_follow:
                mEventCallBack.EventClick(
                        FuGPMainFragment.EVENT_GP_FOLLOW, null);
                break;
            case R.id.btn_statistics:
                mEventCallBack.EventClick(
                        FuGPMainFragment.EVENT_GP_STATTISTICS, null);
                break;
        }
    }
}
