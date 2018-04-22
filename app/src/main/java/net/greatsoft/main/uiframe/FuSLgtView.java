package net.greatsoft.main.uiframe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuSLgtView extends FuUiFrameModel implements View.OnClickListener {

//    ArrayList<PersonInfo> group_person = new ArrayList<>(3);

    ExpandableListView elv_person;
    ExpandableAdapter ela;

    public FuSLgtView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_s_lgt_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError(){
    }
    @Override
    protected void initWidget() {
        elv_person = (ExpandableListView)mFuView.findViewById(R.id.elv_person);
        ela = new ExpandableAdapter(mContext);
        elv_person.setAdapter(ela);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    public  class  ExpandableAdapter extends BaseExpandableListAdapter {
        private Context context;
        private LayoutInflater inflater;
        public ExpandableAdapter (Context mContext){
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }
        @Override
        public int getGroupCount() {
            return 4;
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

            if(convertView == null){
                convertView = inflater.inflate(R.layout.fu_person_down_group_item, parent, false);
            }

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(R.layout.fu_person_down_item, parent, false);
            }
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
   
}
