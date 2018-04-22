package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.helper.FamilyCredentialDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class FuFamilyAdd03View extends FuUiFrameModel implements View.OnClickListener {


    FuListView lv_card;//证件

    FuTextView tv_orgName;  //建档机构
    FuTextView tv_creator;  //建档人
    FuTextView tv_createTime;   //建档时间

    List<FamilyCredential> list_familyCredential; //家庭有效证件列表

    List<Checks> list_credentialType;//证件类型列表

    CredentialAdapter credentialAdapter; // 证件

    Spinner sp_credentialType;   //证件下拉

    FuEditText et_credentialNo;     //证件号

    Button btn_add;

    FamilyInfo mFamilyInfo;


    public FuFamilyAdd03View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Checks checks = (Checks) sp_credentialType.getSelectedItem();
                FamilyCredential familyCredential = new FamilyCredential();
                familyCredential.setCredentialTypeCode(checks.getCode());
                familyCredential.setCredentialTypeValue(checks.getValue());
                familyCredential.setCredentialNo(et_credentialNo.getString());
//                familyCredential.setFamilyInfoId(mFamilyInfo.getFamilyInfoId());
                list_familyCredential.add(familyCredential);
                credentialAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_family_add_03_view, null);

        list_familyCredential = new ArrayList<>();
    }

    public void setData(FamilyInfo familyInfo, RoomAll roomAll) {

        mFamilyInfo = familyInfo;

        list_familyCredential = sqlHelper.getFamilyCredentialDao().queryBuilder().where(FamilyCredentialDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).list();
        credentialAdapter.notifyDataSetChanged();


        tv_orgName.setText(familyInfo.getOrgName());  //建档机构
        tv_creator.setText(familyInfo.getCreator());  //建档人
        tv_createTime.setText(familyInfo.getCreateTime());   //建档时间

    }

    public void saveData(FamilyInfo familyInfo) {

        //证件

        familyInfo.setFamilyCredential(list_familyCredential);


        familyInfo.setOrgName(tv_orgName.getText().toString().trim());  //建档机构
        familyInfo.setCreator(tv_creator.getText().toString().trim());  //建档人
//         familyInfo.setcreattv_createTime;   //建档时间

    }

    @Override
    protected void initFuData() {

        credentialAdapter = new CredentialAdapter(mContext);
        lv_card.setAdapter(credentialAdapter);

        list_credentialType = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("familyIdType")).list();
        ArrayAdapter<?> adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                list_credentialType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_credentialType.setAdapter(adapter);

    }

    @Override
    protected void initWidget() {
        findView();
    }


    private void findView() {
        lv_card = (FuListView) mFuView.findViewById(R.id.lv_card);//证件类型

        sp_credentialType = (Spinner) mFuView.findViewById(R.id.sp_credentialType);

        et_credentialNo = (FuEditText) mFuView.findViewById(R.id.et_credentialNo);

        btn_add = (Button) mFuView.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        tv_orgName = (FuTextView) mFuView.findViewById(R.id.tv_orgName);  //建档机构
        tv_creator = (FuTextView) mFuView.findViewById(R.id.tv_creator);  //建档人
        tv_createTime = (FuTextView) mFuView.findViewById(R.id.tv_createTime);   //建档时间
    }

    class CredentialAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public CredentialAdapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_familyCredential == null ? 0 : list_familyCredential.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            CredentialAdapter.HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_card_item, null);
                holder = new CredentialAdapter.HealthExamInhosHolder();
                holder.tv_type = (FuTextView) convertView.findViewById(R.id.tv_type);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (CredentialAdapter.HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_type.setText(list_familyCredential.get(position).getCredentialTypeValue());
            holder.tv_num.setText(list_familyCredential.get(position).getCredentialNo());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(list_familyCredential.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_familyCredential.remove(position);
                    credentialAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_type;       //接种日期
            FuTextView tv_num;      //接种机构
            FuTextView tv_delete;             // 删除
        }

    }
}
