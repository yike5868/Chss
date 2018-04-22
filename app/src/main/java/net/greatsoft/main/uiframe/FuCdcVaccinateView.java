package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.vaccine.CdcVaccreportVaccinate;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/12/28
 * Time: 11:10
 * progject: Chss
 * Describe：计划内免疫接种
 */

public class FuCdcVaccinateView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    FuTextView tv_vaccineName; //疫苗名称
    FuTextView tv_vaccinateDoses; //针次
    FuTextView tv_vaccinatePlanDate; //预约日期
    FuTextView tv_vaccinateDate; //接种日期
    FuEditText et_measure; //接种剂量
    Spinner sp_vaccinateSiteValue; //接种部位
    Spinner sp_manufacturerId; //生产企业
    Spinner sp_vaccineBatchNo; //疫苗批号
    Spinner sp_vaccinateDoctorName; //接种医生
    FuEditText et_remark; //备注

    public FuCdcVaccinateView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_vaccinateDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cdcvaccinate_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {

        findView();

    }

    public void setData(CdcVaccreportVaccinate cdcVaccreportVaccinate) {

    }

    public boolean saveData(CdcVaccreportVaccinate cdcVaccreportVaccinate) {


        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_vaccineName = (FuTextView) mFuView.findViewById(R.id.tv_vaccineName); //疫苗名称
        tv_vaccinateDoses = (FuTextView) mFuView.findViewById(R.id.tv_vaccinateDoses); //针次
        tv_vaccinatePlanDate = (FuTextView) mFuView.findViewById(R.id.tv_vaccinatePlanDate); //预约日期
        tv_vaccinateDate = (FuTextView) mFuView.findViewById(R.id.tv_vaccinateDate); //接种日期
        tv_vaccinateDate.setOnClickListener(this);
        et_measure = (FuEditText) mFuView.findViewById(R.id.et_measure); //接种剂量
        sp_vaccinateSiteValue = (Spinner) mFuView.findViewById(R.id.sp_vaccinateSiteValue); //接种部位
        sp_manufacturerId = (Spinner) mFuView.findViewById(R.id.sp_manufacturerId); //生产企业
        sp_vaccineBatchNo = (Spinner) mFuView.findViewById(R.id.sp_vaccineBatchNo); //疫苗批号
        sp_vaccinateDoctorName = (Spinner) mFuView.findViewById(R.id.sp_vaccinateDoctorName); //接种医生
        et_remark = (FuEditText) mFuView.findViewById(R.id.et_remark); //备注

    }
}
