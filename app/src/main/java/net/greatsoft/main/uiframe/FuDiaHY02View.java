package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuDiaHY02View extends FuUiFrameModel implements View.OnClickListener {

    FuEditText et_sbp;                //收缩压           共
    FuEditText et_dbp;                //舒张压           共
    FuTextView tv_o_sbp;              //上次收缩压        共
    FuTextView tv_o_dbp;              //上次舒张压        共
    FuEditText et_heartRate;          //心率             高
    FuTextView tv_o_heartRate;        //上次心率          高
    FuEditText et_height;             //身高             共
    FuTextView tv_o_height;           //上次身高          共
    FuEditText et_weight;             //体重             共
    FuTextView tv_o_weight;           //上次体重          共
    FuEditText et_waist;              //腰围             高
    FuTextView tv_o_waist;            //上次腰围          高
    FuEditText et_fbg;                //空腹血糖值         糖
    FuTextView tv_o_fbg;              //上次空腹血糖值     糖
    FuTextView tv_bmi;                //体质指数          共
    FuTextView tv_o_bmi;              //上次体质指数        共
    FuEditText et_ghb;                //糖化血红蛋白值  %    糖
    FuTextView tv_o_ghb;              //上次糖化血红蛋白值 %   糖
    FuTextView tv_ghbDate;            //检查时间          糖
    Button   btn_next;              //下一步
    public FuDiaHY02View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.diahy_fragment02, null);
    }

    @Override
    protected void initFuData() {

    }

    public void setData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup,
                        HyperFollowup oHyperFollowup, DiabetesFollowup oDiabetesFollowup){

         et_sbp.setText(hyperFollowup.getSbp(),diabetesFollowup.getSbp()); //收缩压           共
         et_dbp.setText(hyperFollowup.getDbp(),diabetesFollowup.getDbp());                //舒张压           共
         tv_o_sbp.setText(oHyperFollowup.getSbp(),oDiabetesFollowup.getSbp());              //上次收缩压        共
         tv_o_dbp.setText(oHyperFollowup.getDbp(),oDiabetesFollowup.getDbp());              //上次舒张压        共
         et_heartRate.setText(hyperFollowup.getHeartRate());          //心率             高
         tv_o_heartRate.setText(oHyperFollowup.getHeartRate());        //上次心率          高
         et_height.setText(hyperFollowup.getHeight(),diabetesFollowup.getHeight());             //身高             共
         tv_o_height.setText(oHyperFollowup.getHeight(),oDiabetesFollowup.getHeight());           //上次身高          共
         et_weight.setText(hyperFollowup.getWeight(),diabetesFollowup.getWeight());             //体重             共
         tv_o_weight.setText(oHyperFollowup.getWeight(),oDiabetesFollowup.getWeight());           //上次体重          共
         et_waist.setText(hyperFollowup.getWaist());              //腰围             高
         tv_o_waist.setText(oHyperFollowup.getWaist());            //上次腰围          高
         et_fbg.setText(diabetesFollowup.getFbg());                //空腹血糖值         糖
         tv_o_fbg.setText(oDiabetesFollowup.getFbg());              //上次空腹血糖值     糖
         tv_bmi.setText(hyperFollowup.getBmi(),diabetesFollowup.getBmi());                //体质指数          共
         tv_o_bmi.setText(oHyperFollowup.getBmi(),oDiabetesFollowup.getBmi());              //上次体质指数        共
         et_ghb.setText(diabetesFollowup.getGhb());                //糖化血红蛋白值  %    糖
         tv_o_ghb.setText(oDiabetesFollowup.getGhb());              //上次糖化血红蛋白值 %   糖
         tv_ghbDate.setText(diabetesFollowup.getGhbDate());            //检查时间          糖

    }
    public void saveData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup){
        hyperFollowup.setSbp(et_sbp.getInt());                //收缩压           共
        hyperFollowup.setDbp(et_dbp.getInt());                //舒张压           共
        hyperFollowup.setHeartRate(et_heartRate.getInt());          //心率             高
        hyperFollowup.setHeight(et_height.getDouble());             //身高             共
        hyperFollowup.setWeight(et_weight.getDouble());             //体重             共
        hyperFollowup.setWaist(et_waist.getDouble());              //腰围             高
        hyperFollowup.setBmi(tv_bmi.getDouble());                //体质指数          共

        diabetesFollowup.setSbp(et_sbp.getInt());                //收缩压           共
        diabetesFollowup.setDbp(et_dbp.getInt());                //舒张压           共
        diabetesFollowup.setHeight(et_height.getDouble());             //身高             共
        diabetesFollowup.setWeight(et_weight.getDouble());             //体重             共
        diabetesFollowup.setFbg(et_fbg.getDouble());                //空腹血糖值         糖
        diabetesFollowup.setBmi(tv_bmi.getDouble());                //体质指数          共
        diabetesFollowup.setGhb(et_ghb.getDouble());                //糖化血红蛋白值  %    糖
        diabetesFollowup.setGhbDate(tv_ghbDate.getDate());            //检查时间          糖
    }


    public void setError(){
    }
    @Override
    protected void initWidget() {
        et_sbp= (FuEditText) mFuView.findViewById(R.id.et_sbp);                //收缩压
        et_dbp= (FuEditText) mFuView.findViewById(R.id.et_dbp);                //舒张压
        tv_o_sbp= (FuTextView)mFuView.findViewById(R.id.tv_o_sbp);              //上次收缩压
        tv_o_dbp= (FuTextView)mFuView.findViewById(R.id.tv_o_dbp);              //上次舒张压
        et_heartRate= (FuEditText) mFuView.findViewById(R.id.et_heartRate);          //心率
        tv_o_heartRate= (FuTextView)mFuView.findViewById(R.id.tv_o_heartRate);        //上次心率
        et_height= (FuEditText) mFuView.findViewById(R.id.et_height);             //身高
        tv_o_height= (FuTextView)mFuView.findViewById(R.id.tv_o_height);           //上次身高
        et_weight= (FuEditText) mFuView.findViewById(R.id.et_weight);             //体重
        tv_o_weight= (FuTextView)mFuView.findViewById(R.id.tv_o_weight);           //上次体重
        et_waist= (FuEditText) mFuView.findViewById(R.id.et_waist);              //腰围
        tv_o_waist= (FuTextView)mFuView.findViewById(R.id.tv_o_waist);            //上次腰围
        et_fbg= (FuEditText) mFuView.findViewById(R.id.et_fbg);                //空腹血糖值
        tv_o_fbg= (FuTextView)mFuView.findViewById(R.id.tv_o_fbg);              //上次空腹血糖值
        tv_bmi= (FuTextView)mFuView.findViewById(R.id.tv_bmi);                //体质指数
        tv_o_bmi= (FuTextView)mFuView.findViewById(R.id.tv_o_bmi);              //上次体质指数
        et_ghb= (FuEditText) mFuView.findViewById(R.id.et_ghb);                //糖化血红蛋白质  %
        tv_o_ghb= (FuTextView)mFuView.findViewById(R.id.tv_o_ghb);              //上次糖化血红蛋白质 %
        tv_ghbDate= (FuTextView)mFuView.findViewById(R.id.tv_ghbDate);            //检查时间
        btn_next= (Button) mFuView.findViewById(R.id.btn_next);              //下一步
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
   
}
