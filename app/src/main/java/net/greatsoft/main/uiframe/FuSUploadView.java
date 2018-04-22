package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuSUploadView extends FuUiFrameModel implements View.OnClickListener {

    public FuSUploadView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_s_upload_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError(){
    }
    @Override
    protected void initWidget() {
        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText(mContext.getResources().getText(R.string.main_upload));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
   
}
