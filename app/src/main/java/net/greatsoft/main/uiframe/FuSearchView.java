package net.greatsoft.main.uiframe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuListFragment;
import net.greatsoft.main.fragment.FuSearchFragment;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.IdCardValidator;
import net.greatsoft.main.tool.StringUtils;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuImageView;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.ImageTextButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/25.
 */

public class FuSearchView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemClickListener {

    MyAdapter myAdapter;

    LinearLayout ll_main;
    LinearLayout ll_search;

    List<PersonInfo> personInfoList;
    List<FamilyInfo> familyInfoList;
    ListView lv_search;

    private int pageNo = 1;
    private int pageSize = 10;

    private int listType;

    FuTextView jkx_title_center;//标题

    private Dialog bottomDialog; //底层弹出框
    private View inflate;

    ImageTextButton itb_hyper; //高血压
    ImageTextButton itb_diabetes;//糖尿病
    ImageTextButton itb_exam;//体检
    ImageTextButton itb_smi;//精神病
    ImageTextButton itb_selfcare;//老年人自理能力
    ImageTextButton itb_cognition;//老年人认知功能
    ImageTextButton itb_depressed;//老年人抑郁
    ImageTextButton itb_edit;//编辑
    ImageTextButton itb_delete;//删除

    ImageTextButton itb_child_health_1;//新生儿
    ImageTextButton itb_child_health_2;//1-8月
    ImageTextButton itb_child_health_3;//12-30个月
    ImageTextButton itb_child_health_4;//3-6岁

    ImageTextButton itb_maternal_1;//第一次产前随访
    ImageTextButton itb_maternal_2;//2-5次
    ImageTextButton itb_maternal_3;//产后访视
    ImageTextButton itb_maternal_4;//产后42天访视

    ImageView iv_back;
    FuEditText et_search;
    ImageView iv_delete;
    FuButton btn_search;

    public FuSearchView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_search_view, null);
    }

    @Override
    protected void initFuData() {
        familyInfoList = new ArrayList<>();
        personInfoList = new ArrayList<>();
    }

    /**
     * 添加家庭
     *
     * @param familyInfoList
     */
    public void setFamilyInfoList(List<FamilyInfo> familyInfoList) {
        this.familyInfoList.addAll(familyInfoList);
        myAdapter.notifyDataSetChanged();
        if (familyInfoList.size() < 1) {
            ToastUtil.showToast(mContext, "查不到家庭", Toast.LENGTH_SHORT);
        }
    }

    /**
     * 添加人员
     *
     * @param personInfoList
     */
    public void setPersonInfoList(List<PersonInfo> personInfoList) {
        this.personInfoList.addAll(personInfoList);
        myAdapter.notifyDataSetChanged();
        if (personInfoList.size() < 1) {
            ToastUtil.showToast(mContext, "查不到此人", Toast.LENGTH_SHORT);
        }
    }

    public void setData(int _listType) {
        listType = _listType;
        makeBottomDialog();
    }


    @Override
    protected void initWidget() {

        jkx_title_center = (FuTextView) mFuView
                .findViewById(R.id.fu_title_center);

        ll_main = (LinearLayout) mFuView.findViewById(R.id.ll_main);
        ll_search = (LinearLayout) mFuView.findViewById(R.id.ll_search);


        lv_search = (ListView) mFuView.findViewById(R.id.lv_search);
        myAdapter = new MyAdapter(mContext);
        lv_search.setAdapter(myAdapter);
        lv_search.setOnItemClickListener(this);


        iv_back = (ImageView) mFuView.findViewById(R.id.iv_back);
        et_search = (FuEditText) mFuView.findViewById(R.id.et_search);
        iv_delete = (ImageView) mFuView.findViewById(R.id.iv_delete);
        btn_search = (FuButton) mFuView.findViewById(R.id.btn_search);

        iv_back.setOnClickListener(this);
        iv_delete.setOnClickListener(this);
        btn_search.setOnClickListener(this);

//        initExpandableListView();

    }


    public void makeBottomDialog() {
        bottomDialog = new Dialog(mContext, R.style.ActionSheetDialogStyle);

        inflate = LayoutInflater.from(mContext).inflate(R.layout.bottom_dialog_layout, null);

        itb_hyper = (ImageTextButton) inflate.findViewById(R.id.itb_hyper); //高血压
        itb_diabetes = (ImageTextButton) inflate.findViewById(R.id.itb_diabetes);//糖尿病
        itb_exam = (ImageTextButton) inflate.findViewById(R.id.itb_exam);//体检
        itb_smi = (ImageTextButton) inflate.findViewById(R.id.itb_smi);//精神病
        itb_selfcare = (ImageTextButton) inflate.findViewById(R.id.itb_selfcare);//老年人自理能力
        itb_cognition = (ImageTextButton) inflate.findViewById(R.id.itb_cognition);//老年人认知功能
        itb_depressed = (ImageTextButton) inflate.findViewById(R.id.itb_depressed);//老年人抑郁
        itb_edit = (ImageTextButton) inflate.findViewById(R.id.itb_edit);//编辑
        itb_delete = (ImageTextButton) inflate.findViewById(R.id.itb_delete);//删除

        itb_child_health_1 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_1);//新生儿
        itb_child_health_2 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_2);//1-8月
        itb_child_health_3 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_3);//12-30个月
        itb_child_health_4 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_4);//3-6岁

        itb_maternal_1 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_1);//第一次产前随访
        itb_maternal_2 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_2);//2-5次
        itb_maternal_3 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_3);//产后访视
        itb_maternal_4 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_4);//产后42天访视


        itb_hyper.setOnClickListener(this); //高血压
        itb_diabetes.setOnClickListener(this);//糖尿病
        itb_exam.setOnClickListener(this);//体检
        itb_smi.setOnClickListener(this);//精神病
        itb_selfcare.setOnClickListener(this);//老年人自理能力
        itb_cognition.setOnClickListener(this);//老年人认知功能
        itb_depressed.setOnClickListener(this);//老年人抑郁

        itb_child_health_1.setOnClickListener(this);//新生儿
        itb_child_health_2.setOnClickListener(this);//1-8月
        itb_child_health_3.setOnClickListener(this);//12-30个月
        itb_child_health_4.setOnClickListener(this);//3-6岁

        itb_maternal_1.setOnClickListener(this);//第一次产前随访
        itb_maternal_2.setOnClickListener(this);//2-5次
        itb_maternal_3.setOnClickListener(this);//产后访视
        itb_maternal_4.setOnClickListener(this);//产后42天访视

        itb_edit.setOnClickListener(this);//编辑
        itb_delete.setOnClickListener(this);//删除

        switch (listType) {
            case FuListFragment.EVENT_FAMILY:
                //家庭没有弹出框
                break;
            //人员
            case FuListFragment.EVENT_PERSON:
                itb_edit.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
//                itb_delete.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_HYPER:
                itb_hyper.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_DIABETES:
                itb_diabetes.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_COGNITION:
                itb_cognition.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_SMI:
                itb_smi.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CHILD:
                itb_child_health_1.setVisibility(View.VISIBLE);
                itb_child_health_2.setVisibility(View.VISIBLE);
                itb_child_health_3.setVisibility(View.VISIBLE);
                itb_child_health_4.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_MATERNAL:
                itb_maternal_1.setVisibility(View.VISIBLE);
                itb_maternal_2.setVisibility(View.VISIBLE);
                itb_maternal_3.setVisibility(View.VISIBLE);
                itb_maternal_4.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
        }
        bottomDialog.setContentView(inflate);
        Window dialogWindow = bottomDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.y = 20;
        dialogWindow.setAttributes(lp);

    }

    public void getData() {
        Bundle bundle = new Bundle();
        HashMap<String, Object> hashMap = new HashMap<>();

        String body = et_search.getText().toString().trim();

        if (body == null || "".equals(body)) {
            ToastUtil.showToast(mContext, "请输入查询条件", Toast.LENGTH_SHORT);
            return;
        }

        familyInfoList.clear();
        personInfoList.clear();

        if (IdCardValidator.isValidatedAllIdcard(body)) {
            hashMap.put("idNo", body);
        } else if (StringUtils.isNum(body) && body.length() == 17) {
            hashMap.put("personInfoNo", body);
        } else {
            if (listType == FuListFragment.EVENT_FAMILY) {
                hashMap.put("householder", body);
            } else {
                hashMap.put("name", body);
            }
        }

        switch (listType) {

            case FuListFragment.EVENT_PERSON:
                break;
            case FuListFragment.EVENT_FAMILY:
                break;
            case FuListFragment.EVENT_SMI:
                hashMap.put("isPhychosis", 1);
                break;
            case FuListFragment.EVENT_COGNITION:
                hashMap.put("isOld", 1);
                break;
            case FuListFragment.EVENT_HYPER:
                hashMap.put("isHyper", 1);
                break;
            case FuListFragment.EVENT_DIABETES:
                hashMap.put("isDiabetes", 1);
                break;
            case FuListFragment.EVENT_CHILD:
                hashMap.put("isChildren", 1);
                break;
            case FuListFragment.EVENT_MATERNAL:
                hashMap.put("isMaternal",1);
                hashMap.put("isWomen", 1);
                break;
        }
        bundle.putInt("pageNo", pageNo);
        bundle.putInt("pageSize", pageSize);
        hashMap.put("districtId", TaskManager.getInstace().getDistrictId(mContext));
        hashMap.put("districtLevel", TaskManager.getInstace().getDistrictLev(mContext));
        bundle.putSerializable("param", hashMap);

        mEventCallBack.EventClick(FuListFragment.EVENT_GET_DATA, bundle);

    }

    public void showBottomDialog(int position) {

        int tag = position;
//        personInfoName = personInfoList.get(position).getName();


        itb_hyper.setTag(tag); //高血压
        itb_diabetes.setTag(tag);//糖尿病
        itb_exam.setTag(tag);//体检
        itb_smi.setTag(tag);//精神病
        itb_selfcare.setTag(tag);//老年人自理能力
        itb_cognition.setTag(tag);//老年人认知功能
        itb_depressed.setTag(tag);//老年人抑郁
        itb_edit.setTag(tag);


        itb_child_health_1.setTag(tag);//新生儿
        itb_child_health_2.setTag(tag);//1-8月
        itb_child_health_3.setTag(tag);//12-30个月
        itb_child_health_4.setTag(tag);//3-6岁


        bottomDialog.show();

    }


    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        if (v.getTag() == null) {

        } else {
            int pon = Integer.parseInt(v.getTag().toString());

            bundle.putString("personInfoId", personInfoList.get(pon).getPersonInfoId());
            bundle.putString("personInfoName", personInfoList.get(pon).getName());
            bundle.putSerializable("personInfo", personInfoList.get(pon));
        }
        if (bottomDialog != null && bottomDialog.isShowing())
            bottomDialog.dismiss();
        switch (v.getId()) {
            case R.id.itb_hyper:
                mEventCallBack.EventClick(FuListFragment.EVENT_HYPER, bundle);
                break;
            case R.id.itb_diabetes:
                mEventCallBack.EventClick(FuListFragment.EVENT_DIABETES, bundle);
                break;
            case R.id.itb_exam:
                mEventCallBack.EventClick(FuListFragment.EVENT_EXAM, bundle);
                break;
            case R.id.itb_smi:
                mEventCallBack.EventClick(FuListFragment.EVENT_SMI, bundle);
                break;
            case R.id.itb_selfcare:
                mEventCallBack.EventClick(FuListFragment.EVENT_SELFCARE, bundle);
                break;
            case R.id.itb_cognition:
                mEventCallBack.EventClick(FuListFragment.EVENT_COGNITION, bundle);
                break;
            case R.id.itb_depressed:
                mEventCallBack.EventClick(FuListFragment.EVENT_DEPRESSED, bundle);
                break;

            case R.id.iv_back:
                mEventCallBack.EventClick(FuSearchFragment.EVENT_BACK, null);
                break;
            case R.id.iv_delete:
                et_search.setText("");
                break;
            case R.id.btn_search:
                getData();
                break;

            case R.id.itb_edit:
                mEventCallBack.EventClick(FuListFragment.EVENT_PERSON_ADD, bundle);
                break;

            case R.id.itb_child_health_1:
                mEventCallBack.EventClick(FuListFragment.EVNET_CHILD_HOME_VISIT, bundle);
                break;
            case R.id.itb_child_health_2:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_02, bundle);
                break;
            case R.id.itb_child_health_3:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_03, bundle);
                break;
            case R.id.itb_child_health_4:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_04, bundle);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (listType == FuListFragment.EVENT_FAMILY) {
            Bundle bundle = new Bundle();
            bundle.putString("familyInfoId", familyInfoList.get(position).getFamilyInfoId());
            mEventCallBack.EventClick(FuListFragment.EVENT_FAMILY, bundle);
        } else {
            showBottomDialog(position);
        }
    }


    class MyAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {

            if (listType == FuListFragment.EVENT_FAMILY)
                return familyInfoList == null ? 0 : familyInfoList.size();
            else
                return personInfoList == null ? 0 : personInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_list_view_group_item,
                        null);
                holder = new Holder();
                holder.tv_num_sex = (FuTextView) convertView.findViewById(R.id.tv_num_sex);
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_age = (FuTextView) convertView.findViewById(R.id.tv_age);
                holder.tv_id = (FuTextView) convertView.findViewById(R.id.tv_id);
                holder.tv_address = (FuTextView) convertView.findViewById(R.id.tv_address);
//                holder.iv_right = (FuImageView) convertView.findViewById(R.id.iv_right);
                convertView.setTag(holder);

            } else {
                holder = (Holder) convertView.getTag();
            }

            if (listType == FuListFragment.EVENT_FAMILY) {
                holder.tv_name.setText(familyInfoList.get(position).getHouseholder());
                holder.tv_num_sex.setText(familyInfoList.get(position).getFamilySize());
                holder.tv_id.setText("户口本编号：" + familyInfoList.get(position).getHouseholderIdNo());
                holder.tv_address.setText("地址：" + familyInfoList.get(position).getAddress());
            } else {
                holder.tv_name.setText(personInfoList.get(position).getName());
                holder.tv_num_sex.setText(personInfoList.get(position).getSexValue());
                holder.tv_age.setAge(personInfoList.get(position).getBirthday());
                holder.tv_id.setText("身份证号: " + personInfoList.get(position).getIdNo());
                holder.tv_address.setText("地址: " + personInfoList.get(position).getAddress());
            }
            return convertView;
        }

        class Holder {
            FuTextView tv_name;
            FuTextView tv_num_sex;
            FuTextView tv_age;
            FuTextView tv_id;
            FuTextView tv_address;
            FuImageView iv_right;
        }
    }


}
