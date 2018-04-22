package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/17
 * Time: 16:57
 * progject: Chss_FollowUp
 * Describe： 入户随访个人历史记录VIew
 */

public class FuPersonHistoryView extends FuUiFrameModel implements View.OnClickListener {

    public FuPersonHistoryView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_person_history_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

    }
}
