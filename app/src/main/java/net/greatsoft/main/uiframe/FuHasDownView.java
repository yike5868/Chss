package net.greatsoft.main.uiframe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.districts.Districts;

import java.util.ArrayList;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuHasDownView extends FuUiFrameModel implements View.OnClickListener {
    ExpandableListView elv_down;    //二级列表
    ArrayList<Districts> groupList;     //父类列表

    ExpandableAdapter ead;  //适配器

    public FuHasDownView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_down_view, null);
    }

    @Override
    protected void initFuData() {
//        ead = new ExpandableAdapter(mContext);
//        elv_down.setAdapter(ead);
    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
//        elv_down = (ExpandableListView) mFuView.findViewById(R.id.elv_down);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    public class ExpandableAdapter extends BaseExpandableListAdapter {
        private Context context;
        private LayoutInflater inflater;

        public ExpandableAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getGroupCount() {
            return groupList == null ? 0 : groupList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_down_has_group_item, parent, false);
            }
            TextView tv_group_item = (TextView) convertView.findViewById(R.id.tv_group_item);
            tv_group_item.setText(groupList.get(groupPosition).getDistrictName());
            TextView tv_group_right = (TextView) convertView.findViewById(R.id.tv_group_right);
            tv_group_right.setText("V 1.5 ");
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_down_has_child_item, parent, false);
            }
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
