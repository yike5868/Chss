package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * 修改个人信息
 * Created by zhanglin on 16/8/3.
 */
public class FuModifyPersonalInfomationView extends FuUiFrameModel implements View.OnClickListener {

    public FuModifyPersonalInfomationView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_modify_personal_information, null);
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
        jkx_title_center.setText(mContext.getResources().getText(R.string.modify_personal));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
   
}
