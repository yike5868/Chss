package net.greatsoft.main.uiframe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.LayoutInflater;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/9.
 */

public class FuDiaChartView extends FuUiFrameModel {

    Paint mInfoPaint;

    LineChart lc_dia;

    public FuDiaChartView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
        initData();
    }


    public void initData() {


        mInfoPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInfoPaint.setColor(Color.rgb(247, 189, 51)); // orange
        mInfoPaint.setTextAlign(Paint.Align.CENTER);
        mInfoPaint.setTextSize(Utils.convertDpToPixel(48f));

        lc_dia.setDescription("");
        lc_dia.setTouchEnabled(true);
        lc_dia.setDragEnabled(true);
        lc_dia.setScaleEnabled(true);
        lc_dia.setPinchZoom(true);
        lc_dia.getAxisLeft().setXOffset(20f);
        lc_dia.getAxisRight().setDrawAxisLine(true);
        lc_dia.getAxisRight().setDrawLabels(false);
        lc_dia.getXAxis().setEnabled(false);
        lc_dia.getLegend().setEnabled(false);
        lc_dia.setPaint(mInfoPaint, Chart.PAINT_INFO);
        lc_dia.setNoDataText("无数据");

    }

    public void setDiaData(List<Float> vd) {

        if(vd.size()<1)
            return;

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i= 0;i<vd.size();i++){
            values.add(new Entry(i,vd.get(i)));
        }


        LineDataSet set1;

        if (lc_dia.getData() != null &&
                lc_dia.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lc_dia.getData().getDataSetByIndex(0);
            set1.setValues(values);
            lc_dia.getData().notifyDataChanged();
            lc_dia.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "血糖");
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(20f);
            set1.setDrawFilled(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);
            set1.setFillColor(Color.BLACK);
            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);

            lc_dia.setData(data);
        }
    }

    public void setHyData(List<Float> vsbps,List<Float> vdbps) {

        if(vsbps.size()<1)
            return;

        ArrayList<Entry> sbps = new ArrayList<Entry>();
        ArrayList<Entry> dbps = new ArrayList<Entry>();


        for (int i = 0;i<vsbps.size();i++){
            sbps.add(new Entry(i, vdbps.get(i)));
        }

        for(int i = 0;i<vdbps.size();i++){
            dbps.add(new Entry(i,vdbps.get(i)));
        }

        LineDataSet setsbps;
        LineDataSet setdbps;

        if (lc_dia.getData() != null &&
                lc_dia.getData().getDataSetCount() > 0) {
            setsbps = (LineDataSet) lc_dia.getData().getDataSetByIndex(0);
            setdbps = (LineDataSet) lc_dia.getData().getDataSetByIndex(1);
            setdbps.setValues(dbps);
            setsbps.setValues(sbps);
            lc_dia.getData().notifyDataChanged();
            lc_dia.notifyDataSetChanged();
        } else {
            setsbps = new LineDataSet(sbps, "收缩压");
            setsbps.setColor(Color.BLACK);
            setsbps.setCircleColor(Color.BLACK);
            setsbps.setLineWidth(1f);
            setsbps.setCircleRadius(3f);
            setsbps.setDrawCircleHole(false);
            setsbps.setValueTextSize(20f);
            setsbps.setDrawFilled(false);
            setsbps.setFormLineWidth(1f);
            setsbps.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            setsbps.setFormSize(15.f);
            setsbps.setFillColor(Color.BLACK);


            setdbps = new LineDataSet(dbps, "舒张压");
            setdbps.setColor(Color.BLACK);
            setdbps.setCircleColor(Color.BLACK);
            setdbps.setLineWidth(1f);
            setdbps.setCircleRadius(3f);
            setdbps.setDrawCircleHole(false);
            setdbps.setValueTextSize(20f);
            setdbps.setDrawFilled(false);
            setdbps.setFormLineWidth(1f);
            setdbps.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            setdbps.setFormSize(15.f);
            setdbps.setFillColor(Color.BLACK);

//            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
//            dataSets.add(setsbps);
            LineData data = new LineData(setdbps,setsbps);


            lc_dia.setData(data);
        }
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_dia_chart_view, null);
    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        lc_dia = (LineChart) mFuView.findViewById(R.id.lc_dia);
    }
}
