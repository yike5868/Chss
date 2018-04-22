package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 2016/11/10.
 */

public class FuGPStatisticsView extends FuUiFrameModel  {
    public FuGPStatisticsView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_gp_statistics_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

    }
}
