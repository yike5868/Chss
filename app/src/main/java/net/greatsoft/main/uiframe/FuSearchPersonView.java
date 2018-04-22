package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 16/9/26.
 */

public class FuSearchPersonView extends FuUiFrameModel implements View.OnClickListener {

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_search_person, null);
    }

    public FuSearchPersonView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

    }
}
