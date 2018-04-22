package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.helper.PersonCredentialDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.fragment.FuMemberAddFragment;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/21
 * Time: 09:10
 * progject: Chss_FollowUp
 * Describe：入户随访-新增家庭成员-生活环境
 */

public class FuMemberAdd04View extends FuUiFrameModel implements View.OnClickListener {

    LinearLayout ll_kitchenExhaust; //厨房排风设施
    LinearLayout ll_fuelType;   //燃料类型
    LinearLayout ll_drinkWater; //饮水
    LinearLayout ll_toilet; //厕所
    LinearLayout ll_livestockFence; //禽畜栏

    FuListView lv_card;//证件

    List<PersonCredential> list_personCredential;

    CredentialAdapter credentialAdapter;

    Spinner sp_credentialType;//证件类型
    FuEditText et_credentialNo;//证件号码
    FuButton btn_addCredential;//增加证件


    FuTextView tv_orgCode;  //建档机构
    FuTextView tv_creator;  //建档人
    FuTextView tv_createTime;   //建档时间

    PersonInfo mPersonInfo; //个人信息 为了保存证件类型

    public FuMemberAdd04View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_member_add04_view, null);

        list_personCredential = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMemberAddFragment.EVENT_SAVE_PERSON, null);
                break;
            case R.id.et_confirmDate11:
            case R.id.et_confirmDate12:
            case R.id.et_confirmDate21:
            case R.id.et_confirmDate22:
            case R.id.et_confirmDate31:
            case R.id.et_confirmDate32:

            case R.id.tv_birthday:
            case R.id.tv_paperArchiveDate:
                setDate(v);
                break;
            /**
             * 增加证件
             */
            case R.id.btn_addCredential:
                addCredential();
                break;
        }

    }

    /**
     * 增加证件
     */
    public void addCredential() {
        PersonCredential personCredential = new PersonCredential();
        personCredential.setPersonInfoId(mPersonInfo.getPersonInfoId());
        personCredential.setCredentialNo(et_credentialNo.getText().toString());
        Checks checks = (Checks) sp_credentialType.getSelectedItem();
        personCredential.setCredentialTypeCode(checks.getCode());
        personCredential.setCredentialTypeValue(checks.getValue());
        list_personCredential.add(personCredential);
        credentialAdapter.notifyDataSetChanged();
    }

    public void saveData(PersonInfo personInfo) {

        personInfo.setKitchenExhaustCode(getCheckBoxSimpleCode(ll_kitchenExhaust)); //厨房排风设施
        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_fuelType);   //燃料类型
        saveCheckBoxMany(personInfo.getPersonInfoId(), personInfo.getRecordChoice(), ll_drinkWater); //饮水
        //厕所
        personInfo.setToiletCode(getCheckBoxSimpleCode(ll_toilet));
        //禽畜栏
        personInfo.setLivestockFenceCode(getCheckBoxSimpleCode(ll_livestockFence));

        list_personCredential.addAll(this.list_personCredential);

        personInfo.setOrgCode(tv_orgCode.getText().toString());  //建档机构
        personInfo.setCreator(tv_creator.getText().toString());  //建档人
        personInfo.setCreator(tv_createTime.getText().toString());   //建档时间

    }

    public void setData(PersonInfo personInfo) {
        mPersonInfo = personInfo;
        setCheckBoxSelect(personInfo.getKitchenExhaustCode(), ll_kitchenExhaust); //厨房排风设施
        setCheckBoxSelect("fuelType", personInfo.getPersonInfoId(), ll_fuelType); //燃料类型
        setCheckBoxSelect("drinkWater", personInfo.getPersonInfoId(), ll_drinkWater); //饮水
        setCheckBoxSelect(personInfo.getToiletCode(), ll_toilet); //厕所
        setCheckBoxSelect(personInfo.getLivestockFenceCode(), ll_livestockFence); //禽畜栏

        list_personCredential = sqlHelper.getPersonCredentialDao().queryBuilder().where(PersonCredentialDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).list();
        credentialAdapter.notifyDataSetChanged();
        tv_orgCode.setText(personInfo.getOrgCode());  //建档机构
        tv_creator.setText(personInfo.getCreator());  //建档人
        tv_createTime.setText(personInfo.getCreateTime());   //建档时间

    }

    @Override
    protected void initFuData() {

    }

    @Override
    protected void initWidget() {
        findView();

        // 厨房排风设施
        initCheckBoxSimple("PERSON_KITCHEN_AIR", ll_kitchenExhaust, 3);
        // 燃料类型
        initCheckBoxMany("fuelType", ll_fuelType, 3, false, false);
        // 饮水
        initCheckBoxMany("drinkWater", ll_drinkWater, 2, false, false);
        // 厕所
        initCheckBoxSimple("TOILET", ll_toilet, 0);
        // 禽畜栏
        initCheckBoxSimple("PERSON_LIVESTOCK", ll_livestockFence, 0);

        // 证件类型
        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("CV0100.03")).orderAsc(ChecksDao.Properties.Code).list();
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_credentialType.setAdapter(adapter);

        credentialAdapter = new CredentialAdapter(mContext);
        lv_card.setAdapter(credentialAdapter);
    }

    private void findView() {

        ll_kitchenExhaust = (LinearLayout) mFuView.findViewById(R.id.ll_kitchenExhaust); //厨房排风设施
        ll_fuelType = (LinearLayout) mFuView.findViewById(R.id.ll_fuelType);   //燃料类型
        ll_drinkWater = (LinearLayout) mFuView.findViewById(R.id.ll_drinkWater); //饮水
        ll_toilet = (LinearLayout) mFuView.findViewById(R.id.ll_toilet); //厕所
        ll_livestockFence = (LinearLayout) mFuView.findViewById(R.id.ll_livestockFence); //禽畜栏

        sp_credentialType = (Spinner) mFuView.findViewById(R.id.sp_credentialType);//证件类型
        et_credentialNo = (FuEditText) mFuView.findViewById(R.id.et_credentialNo);//证件号码
        btn_addCredential = (FuButton) mFuView.findViewById(R.id.btn_addCredential);//增加证件
        btn_addCredential.setOnClickListener(this);

        tv_orgCode = (FuTextView) mFuView.findViewById(R.id.tv_orgCode);  //建档机构
        tv_creator = (FuTextView) mFuView.findViewById(R.id.tv_creator);  //建档人
        tv_createTime = (FuTextView) mFuView.findViewById(R.id.tv_createTime);   //建档时间

        lv_card = (FuListView) mFuView.findViewById(R.id.lv_card);//证件

    }

    class CredentialAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public CredentialAdapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_personCredential == null ? 0 : list_personCredential.size();
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
            holder.tv_type.setText(list_personCredential.get(position).getCredentialTypeValue());
            holder.tv_num.setText(list_personCredential.get(position).getCredentialNo());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(list_personCredential.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_personCredential.remove(position);
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
