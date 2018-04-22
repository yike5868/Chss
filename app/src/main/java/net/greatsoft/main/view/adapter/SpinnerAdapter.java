package net.greatsoft.main.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.greatsoft.main.R;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/18.
 */

public class SpinnerAdapter extends BaseAdapter {


    List<SpinnerItem> spinnerItemList;

    private Context context;

    private LayoutInflater inflater;

    public SpinnerAdapter(Context mContext, List<SpinnerItem> spinnerItems) {
        this.spinnerItemList = spinnerItems;
        this.context = mContext;
        inflater = ((Activity) context).getLayoutInflater();
    }

    public void setDataChanged(List<SpinnerItem> spinnerItemList) {
        this.spinnerItemList = spinnerItemList;
        notifyDataSetChanged();
    }

    public void clearn() {
        this.spinnerItemList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return spinnerItemList == null ? 0 : spinnerItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_item, parent, false);
        }
        FuTextView tv_spinner_item = (FuTextView) convertView.findViewById(R.id.tv_spinner_item);
        tv_spinner_item.setText(spinnerItemList.get(position).getValue());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_drop_item, parent, false);
        }
        FuTextView tv_spinner_drop_item = (FuTextView) convertView.findViewById(R.id.tv_spinner_drop_item);
        tv_spinner_drop_item.setText(spinnerItemList.get(position).getValue());

        return convertView;
    }
}