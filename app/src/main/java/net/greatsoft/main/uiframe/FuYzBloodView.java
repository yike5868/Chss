package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuYzBloodView extends FuUiFrameModel implements View.OnClickListener {

    public FuYzBloodView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_yz_blood_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError(){
    }
    @Override
    protected void initWidget() {
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
   
}
