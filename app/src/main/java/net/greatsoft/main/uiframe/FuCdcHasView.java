package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 2016/12/28.
 */

public class FuCdcHasView extends FuUiFrameModel implements View.OnClickListener  {

    public FuCdcHasView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cdc_has_view, null);

    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

    }
}
