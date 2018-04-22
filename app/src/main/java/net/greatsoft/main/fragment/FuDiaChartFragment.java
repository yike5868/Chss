package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.uiframe.FuDiaChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/9.
 */

public class FuDiaChartFragment extends FragmentParent {
    List<DiabetesFollowup> diabetesFollowupList;  //糖尿病
    List<Float> v_dia; //糖尿病

    List<HyperFollowup> hyperFollowupList;//高血压

    List<Float> sbplist;//收缩压
    List<Float> dbplist;//舒张压

    int chartType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_DIA_CHART, getActivity(),
                null);
        setData();
        return mModel.getFuView();
    }

    public void initData(Bundle bundle) {
        personInfoId = bundle.getString("personInfoId");
        chartType = bundle.getInt("type");
    }

    public void setData() {
        switch (chartType) {
            case FuUiFrameManager.FU_HYPER_CHART:
                setHyData();
                ((FuDiaChartView) mModel).setHyData(sbplist, dbplist);
                break;
            case FuUiFrameManager.FU_DIA_CHART:
                setDiaData();
                ((FuDiaChartView) mModel).setDiaData(v_dia);
                break;
        }
    }

    public void setDiaData() {
        diabetesFollowupList = sqlHelper.getDiabetesFollowupByPersonInfoId(personInfoId);
        v_dia = new ArrayList<>();
        for (int i = 0; i < diabetesFollowupList.size(); i++) {
            v_dia.add(Float.parseFloat(diabetesFollowupList.get(i).getFbg().toString()));
        }

    }

    public void setHyData() {
        hyperFollowupList = sqlHelper.getHyperFollowupListByPersonInfoId(personInfoId);
        dbplist = new ArrayList<>();
        sbplist = new ArrayList<>();
        for (int i = 0; i < hyperFollowupList.size(); i++) {
            dbplist.add(Float.parseFloat(hyperFollowupList.get(i).getDbp().toString()));
            sbplist.add(Float.parseFloat(hyperFollowupList.get(i).getSbp().toString()));
        }

    }


    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
