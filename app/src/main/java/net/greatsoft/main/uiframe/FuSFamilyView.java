package net.greatsoft.main.uiframe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.fragment.FuSFamilyFragment;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 16/10/12.
 */

public class FuSFamilyView extends FuUiFrameModel implements View.OnClickListener {
    ExpandableListView elv_family;
    ExpandableAdapter ea;
    List<FamilyInfo> familyInfoList;    //人员列表
    private int page;

    public FuSFamilyView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }



    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_s_member_view, null);
    }

    @Override
    protected void initFuData() {
        dataChange();
    }


    public void dataChange(){
        int limi = page * PAGE_SIZE;
        familyInfoList = sqlHelper.getFamilyInfoDao().queryBuilder().offset(0).limit(limi).list();
        ea.notifyDataSetChanged();
    }


    public void setError() {
    }

    @Override
    protected void initWidget() {

        TextView fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("家庭");
        page = 1;

        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setText("新增");
        fu_title_right_btn.setOnClickListener(this);

        elv_family = (ExpandableListView) mFuView.findViewById(R.id.elv_person);

        ea = new ExpandableAdapter(mContext);
        elv_family.setAdapter(ea);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuSFamilyFragment.EVENT_FAMILY_ADD, null);
                break;
//            case R.id.btn_text:
//                Bundle bundle_personinfo = new Bundle();
//                bundle_personinfo.putSerializable("FamilyInfoId",v.getTag().toString());
//                mEventCallBack.EventClick(FuSFamilyFragment.EVENT_FAMILY_EDIT, bundle_personinfo);
//                break;


//            case R.id.sb_info:
//                Bundle bundle_familyInfo = new Bundle();
//                bundle_familyInfo.putSerializable("FamilyInfoId",v.getTag().toString());
//                mEventCallBack.EventClick(FuSFamilyFragment.EVENT_FAMILY_EDIT, bundle_familyInfo);
//                break;
//            case R.id.sb_mess:
//                Bundle bundle_family_add_person = new Bundle();
//                bundle_family_add_person.putSerializable("FamilyInfoId",v.getTag().toString());
//                mEventCallBack.EventClick(FuSFamilyFragment.EVENT_FAMILY_ADD_PERSON, bundle_family_add_person);
//                break;

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
            return familyInfoList == null ? 0 : familyInfoList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return familyInfoList.get(groupPosition);
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
                convertView = inflater.inflate(R.layout.fu_family_down_group_item, parent, false);
            }

            FuTextView tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
            FuTextView tv_telNo = (FuTextView) convertView.findViewById(R.id.tv_telNo);
            FuTextView tv_fixedPhones = (FuTextView) convertView.findViewById(R.id.tv_fixedPhones);
            LinearLayout ll_type = (LinearLayout) convertView.findViewById(R.id.ll_type);

            tv_name.setText(familyInfoList.get(groupPosition).getHouseholder());
            tv_telNo.setText(familyInfoList.get(groupPosition).getTelNo());

//            setTextType(familyInfoList.get(groupPosition), ll_type);

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_family_down_child_item, parent, false);
            }
//            SecButton sb_info = (SecButton)convertView.findViewById(R.id.sb_info);
//            sb_info.setText("档案");
//            sb_info.setTag(familyInfoList.get(groupPosition).getFamilyInfoId());
//            sb_info.setOnClickListener(FuSFamilyView.this);
//
//
//            SecButton sb_mess = (SecButton)convertView.findViewById(R.id.sb_mess);
//            sb_mess.setText("新增人员");
//            sb_mess.setTag(familyInfoList.get(groupPosition).getFamilyInfoId());
//            sb_mess.setOnClickListener(FuSFamilyView.this);

//            sb_info.setOnClickListener(FuSFamilyView.this);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
