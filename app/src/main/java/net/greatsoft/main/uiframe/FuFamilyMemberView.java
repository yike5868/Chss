package net.greatsoft.main.uiframe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuFamilyMemberFragment;
import net.greatsoft.main.view.CircleButton;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.ImageTextButton;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/8.
 */

public class FuFamilyMemberView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

    ListView lv_member;
    MemberAdapter memberAdapter;
    List<PersonInfo> personInfoList;

    ImageTextButton btn_member_add;
    FuButton btn_into;
    FuButton btn_mark;
    ImageTextButton btn_edit_family;



    public FuFamilyMemberView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_family_member_view, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //新增人员
            case R.id.btn_member_add:

                mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_PATIENT_ADD, null);
                break;
            //迁入人员
            case R.id.btn_into:

                mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_PATIENT_INTO, null);
                break;
            //标记家庭
            case R.id.btn_mark:
                mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_PATIENT_ADD, null);
                break;
            //修改人员
            case R.id.btn_edit:
                mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_PATIENT_EDIT, v.getTag());
                break;
            //迁出人员
            case R.id.btn_latterly:

                break;
            //删除人员
            case R.id.btn_delete:

                break;
            case R.id.btn_edit_family:
                mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_FAMILY_EDIT, null);
                break;
        }
    }


    @Override
    protected void initFuData() {

    }

    public void setData(List<PersonInfo> mPersonList) {
        personInfoList = mPersonList;
        memberAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initWidget() {
        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("家庭成员");
        lv_member = (ListView) mFuView.findViewById(R.id.lv_member);
        memberAdapter = new MemberAdapter(mContext);
        lv_member.setAdapter(memberAdapter);
        lv_member.setOnItemClickListener(this);
//        lv_member.setOnItemLongClickListener(this);

        btn_member_add = (ImageTextButton) mFuView.findViewById(R.id.btn_member_add);
        btn_into = (FuButton) mFuView.findViewById(R.id.btn_into);
        btn_into.setVisibility(View.GONE);
        btn_mark = (FuButton) mFuView.findViewById(R.id.btn_mark);
        btn_edit_family = (ImageTextButton)mFuView.findViewById(R.id.btn_edit_family);

        btn_member_add.setOnClickListener(this);
        btn_into.setOnClickListener(this);
        btn_mark.setOnClickListener(this);
        btn_edit_family.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putString("personInfoId", personInfoList.get(position).getPersonInfoId());
        mEventCallBack.EventClick(FuFamilyMemberFragment.EVENT_PATIENT_INFO, bundle);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        LinearLayout ll_zt = (LinearLayout)view.findViewById(R.id.ll_zt);
        ll_zt.setVisibility(View.VISIBLE);
        return true;
    }


    class MemberAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MemberAdapter(Context context) {

            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return personInfoList == null ? 0 : personInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return personInfoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Items items;
            if (convertView == null) {
                items = new Items();
                convertView = inflater.inflate(R.layout.fu_family_member_item, null);
                items.cb_relation = (CircleButton)convertView.findViewById(R.id.cb_relation);
                items.tv_name = (FuTextView)convertView.findViewById(R.id.tv_name);
                items.tv_sex = (FuTextView)convertView.findViewById(R.id.tv_sex);
                items.tv_age = (FuTextView)convertView.findViewById(R.id.tv_age);
                items.tv_telNo = (FuTextView)convertView.findViewById(R.id.tv_telNo);
                items.tv_last_date = (FuTextView)convertView.findViewById(R.id.tv_last_date);
                items.btn_delete = (FuButton)convertView.findViewById(R.id.btn_delete);
                items.btn_edit = (FuButton)convertView.findViewById(R.id.btn_edit);
                items.btn_latterly = (FuButton)convertView.findViewById(R.id.btn_latterly);

                items.btn_latterly.setOnClickListener(FuFamilyMemberView.this);
                items.btn_delete.setOnClickListener(FuFamilyMemberView.this);
                items.btn_edit.setOnClickListener(FuFamilyMemberView.this);
                convertView.setTag(items);
            }else{
                items =(Items)convertView.getTag();
            }
            items.cb_relation.setText(personInfoList.get(position).getRelationValue());
//            items.cb_relation.setText(personInfoList.get(position).getRelationValue());
            items.tv_name.setText(personInfoList.get(position).getName());
            items.tv_sex.setText(personInfoList.get(position).getSexValue());
            items.tv_age.setText(personInfoList.get(position).getBirthday());
            items.tv_telNo.setText(personInfoList.get(position).getIdNo());
            items.btn_edit.setTag(personInfoList.get(position).getPersonInfoId());
            items.btn_delete.setTag(personInfoList.get(position).getPersonInfoId());
            items.btn_latterly.setTag(personInfoList.get(position).getPersonInfoId());
            //最后一次随访时间
//            items.tv_last_date.setText();
                return convertView;
        }

        class Items {
            CircleButton cb_relation;//与户主关系
            FuTextView tv_name;//姓名
            FuTextView tv_sex;//性别
            FuTextView tv_age;//年龄
            FuTextView tv_telNo;//电话
            FuTextView tv_last_date;//上次随访时间
            FuButton btn_edit; //编辑个人
            FuButton btn_latterly;//迁出个人
            FuButton btn_delete;//删除
        }

    }
}
