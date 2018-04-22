package net.greatsoft.main.uiframe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.fragment.FuFamilyAddFragment;
import net.greatsoft.main.rsp.obj.DistrictsRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.adapter.SpinnerAdapter;
import net.greatsoft.main.view.tree.Node;
import net.greatsoft.main.view.tree.SimpleTreeAdapter;
import net.greatsoft.main.view.tree.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/9/1.
 */

public class FuFamilyAddView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //    Spinner sp_committee;//村居委会
    FuButton btn_committee;
    Spinner sp_residential;   //小区
    Spinner sp_building;  //楼栋
    Spinner sp_unit;      //单元
    Spinner sp_roomNumber;   // 房间号

    private boolean canTouch = false;

    FuEditText et_householdNo;  //户口本号
    FuEditText et_householder;  //户主姓名
    FuEditText et_householderIdNo;  //户主身份证
    FuEditText et_telNo;    //联系电话
    Spinner sp_respDoctor;    //  责任医生
    FuEditText et_address;      //家庭地址
    LinearLayout ll_householdProperty;     //户属性
    LinearLayout ll_householdType;  //户籍类型
    FuEditText et_dwellingArea; //居住面积
    FuEditText et_dwellingAreaPer;  //人均居住面积
    LinearLayout ll_houseType;  //房屋类型
    LinearLayout ll_kitchenUseMode; //使用方式
    LinearLayout ll_kitchenExhaust; //排风设备
    LinearLayout ll_familyDrinkWater;   //饮水
    LinearLayout ll_fuelType;   //燃料
    LinearLayout ll_sanitaryToilet; //卫生厕所
    LinearLayout ll_noSanitaryToilet;   //非卫生厕所
    LinearLayout ll_livestockFence; //禽畜栏
    LinearLayout ll_garbageDisposal;    //垃圾处理
    LinearLayout ll_householdAppliance; //家用电器
    LinearLayout ll_transport;  //交通工具

    FuListView lv_card;//证件

    FuTextView tv_orgName;  //建档机构
    FuTextView tv_creator;  //建档人
    FuTextView tv_createTime;   //建档时间

    List<FamilyCredential> list_familyCredential;

    List<Checks> list_credentialType;//证件类型列表

    CredentialAdapter credentialAdapter; // 证件

    Spinner sp_credentialType;   //证件下拉

    FuEditText et_credentialNo;     //证件号

    Button btn_add;

    FamilyInfo mFamilyInfo;

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<Emp> empList;


    ArrayAdapter adapter;

    ListView lv_tree; //下拉
    SimpleTreeAdapter simpleTreeAdapter;
    private View inflate;
    private PopupWindow popupWindow;


    List<Districts> districtsList;//村居委会

    SpinnerAdapter saSubdistricts;//小区
    SpinnerAdapter saBuilding;//楼
    SpinnerAdapter saUnit;//单元
    SpinnerAdapter saRoom;//房间

    boolean save_update;

    public FuFamilyAddView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_family_add_jn_view, null);
        list_familyCredential = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add:

                Checks checks = (Checks) sp_credentialType.getSelectedItem();
                if(checks.getCode().equals("3")){
                    ToastUtil.showToast(mContext,"家庭档案标识符为系统生成，不允许添加，修改，删除",Toast.LENGTH_LONG);
                    return;
                }
                FamilyCredential familyCredential = new FamilyCredential();
                familyCredential.setCredentialTypeCode(checks.getCode());
                familyCredential.setCredentialTypeValue(checks.getValue());
                familyCredential.setCredentialNo(et_credentialNo.getString());
                et_credentialNo.setText("");//点击完成后将et置空
                if (save_update) {
                    familyCredential.setFamilyInfoId(null);
                } else
                    familyCredential.setFamilyInfoId(mFamilyInfo.getFamilyInfoId());
                list_familyCredential.add(familyCredential);
                credentialAdapter.notifyDataSetChanged();
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuFamilyAddFragment.EVENT_SAVE_FAMILY, null);
                break;
            case R.id.btn_committee:
                canTouch = true;
                makeBottomDialog(v);
                break;
            case R.id.tv_delete:

                if("delete".equals(v.getTag().toString())){
                    ToastUtil.showToast(mContext,"本记录由系统自动生成,不可删除",Toast.LENGTH_SHORT);
                    return;
                }

                int i = Integer.parseInt(v.getTag().toString());
                list_familyCredential.remove(i);
                credentialAdapter.notifyDataSetChanged();

                break;
        }

    }

    public void makeBottomDialog(View d) {

        districtsList = sqlHelper.getDistrictsAll();

        inflate = LayoutInflater.from(mContext).inflate(R.layout.tree_view, null);


        if (popupWindow == null) {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.tree_view, null);
            lv_tree = (ListView) inflate.findViewById(R.id.lv_tree);
            makeTreeView();
//            id_tree.setOnItemClickListener(FuFamilyAddView.this);


            popupWindow = new PopupWindow(inflate, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }

        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        //过期 后期需要修改
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.showAsDropDown(d, 0, 0);


    }


    public void makeTreeView() {

        try {
            simpleTreeAdapter = new SimpleTreeAdapter<Districts>(lv_tree, mContext, districtsList, 10);
            simpleTreeAdapter.setOnTreeNodeClickListener(onTreeNodeClickListener);

        } catch (Exception e) {
            e.printStackTrace();
        }
        lv_tree.setAdapter(simpleTreeAdapter);
    }

    public void setSubdistricts(List<SpinnerItem> subdistrictsList) {

        if (saSubdistricts == null) {
            saSubdistricts = new SpinnerAdapter(mContext, subdistrictsList);
            sp_residential.setAdapter(saSubdistricts);
            saSubdistricts.notifyDataSetChanged();
        } else {
            saSubdistricts.setDataChanged(subdistrictsList);
        }
    }

    public void setBuildings(List<SpinnerItem> subBuildings) {

        if (saBuilding == null) {
            saBuilding = new SpinnerAdapter(mContext, subBuildings);
            sp_building.setAdapter(saBuilding);
            saBuilding.notifyDataSetChanged();
        } else {
            saBuilding.setDataChanged(subBuildings);
        }
    }

    public void setUnit(List<SpinnerItem> subUnit) {

        if (saUnit == null) {
            saUnit = new SpinnerAdapter(mContext, subUnit);
            sp_unit.setAdapter(saUnit);
            saUnit.notifyDataSetChanged();
        } else {
            saUnit.setDataChanged(subUnit);
        }
    }

    public void setRoom(List<SpinnerItem> subRoom) {

        if (saRoom == null) {
            saRoom = new SpinnerAdapter(mContext, subRoom);
            sp_roomNumber.setAdapter(saRoom);
            saRoom.notifyDataSetChanged();
        } else {
            saRoom.setDataChanged(subRoom);
        }
    }

    public void setAddress() {
        String committee = btn_committee.getText().toString();
        String sub = sp_residential.getSelectedItem() == null ? "" : ((SpinnerItem) sp_residential.getSelectedItem()).getValue();
        String build = sp_building.getSelectedItem() == null ? "" : ((SpinnerItem) sp_building.getSelectedItem()).getValue();
        String unit = sp_unit.getSelectedItem() == null ? "" : ((SpinnerItem) sp_unit.getSelectedItem()).getValue();
        String room = sp_roomNumber.getSelectedItem() == null ? "" : ((SpinnerItem) sp_roomNumber.getSelectedItem()).getValue();
        et_address.setText(committee + sub + build + unit + room);
    }


    public void setListener() {
        sp_residential.setOnItemSelectedListener(this);
        sp_building.setOnItemSelectedListener(this);
        sp_unit.setOnItemSelectedListener(this);
        sp_roomNumber.setOnItemSelectedListener(this);

    }


    /**
     * @param familyInfo
     * @param roomAll
     */
    public void setData(FamilyInfo familyInfo, DistrictsRsp districtsRsp, RoomAll roomAll, boolean save_update) {
        mFamilyInfo = familyInfo;
        this.save_update = save_update;
        if (roomAll == null) {

        } else {

        }


        if (familyInfo.getResidential() != null && districtsRsp.getSubDistrict() != null && districtsRsp.getSubDistrict().size() > 0) {
            List<SpinnerItem> subdistrictsList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem("", "");
            subdistrictsList.add(si);
            int postion = 0;
            for (int i = 0; i < districtsRsp.getSubDistrict().size(); i++) {
                si = new SpinnerItem();
                si.setId(districtsRsp.getSubDistrict().get(i).getSubDistrictId());
                si.setValue(districtsRsp.getSubDistrict().get(i).getSubDistrictName());
                subdistrictsList.add(si);
                if (familyInfo.getResidential().equals(si.getId()))
                    postion = i + 1;
            }
            setSubdistricts(subdistrictsList);
            sp_residential.setSelection(postion, true);

        }
        if (familyInfo.getBuilding() != null && districtsRsp.getBuilding() != null && districtsRsp.getBuilding().size() > 0) {
            List<SpinnerItem> buildingList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem("", "");
            buildingList.add(si);
            int postion = 0;
            for (int i = 0; i < districtsRsp.getBuilding().size(); i++) {
                si = new SpinnerItem();
                si.setId(districtsRsp.getBuilding().get(i).getBuildingId());
                si.setValue(districtsRsp.getBuilding().get(i).getBuildingName());
                buildingList.add(si);
                if (familyInfo.getBuilding().equals(si.getId()))
                    postion = i + 1;
            }
            setBuildings(buildingList);
            sp_building.setSelection(postion, true);

        }

        if (familyInfo.getUnit() != null && districtsRsp.getUnit() != null && districtsRsp.getUnit().size() > 0) {
            List<SpinnerItem> unitList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem("", "");
            unitList.add(si);
            int postion = 0;
            for (int i = 0; i < districtsRsp.getUnit().size(); i++) {
                si = new SpinnerItem();
                si.setId(districtsRsp.getUnit().get(i).getBuildingUnitNo());
                si.setValue(districtsRsp.getUnit().get(i).getBuildingUnitName());
                unitList.add(si);
                if (familyInfo.getUnit().equals(si.getId()))
                    postion = i + 1;
            }
            setUnit(unitList);
            sp_unit.setSelection(postion, true);
        }

        if (familyInfo.getRoomNumber() != null && districtsRsp.getRoomNumber() != null && districtsRsp.getRoomNumber().size() > 0) {
            List<SpinnerItem> roomList = new ArrayList<>();
            SpinnerItem si;
            si = new SpinnerItem("", "");
            roomList.add(si);
            int postion = 0;
            for (int i = 0; i < districtsRsp.getRoomNumber().size(); i++) {
                si = new SpinnerItem();
                si.setId(districtsRsp.getRoomNumber().get(i).getRoomNumberId());
                si.setValue(districtsRsp.getRoomNumber().get(i).getRoomNumberNo());
                roomList.add(si);
                if (familyInfo.getRoomNumber().equals(si.getValue()))
                    postion = i + 1;
            }
            setRoom(roomList);

            sp_roomNumber.setSelection(postion, true);
        }


        if (familyInfo.getHouseholder() == null) {
            return;
        }

        btn_committee.setText(sqlHelper.getDistrictsName(familyInfo.getCommittee()));

        btn_committee.setTag(familyInfo.getCommittee());


        et_householdNo.setText(familyInfo.getHouseholdNo());  //户口本号
        et_householder.setText(familyInfo.getHouseholder());  //户主姓名
        et_householderIdNo.setText(familyInfo.getHouseholderIdNo());  //户主身份证
        et_telNo.setText(familyInfo.getTelNo());    //联系电话

        if (familyInfo.getRespDoctorId() != null) {
            for (int i = 0; i < empList.size(); i++) {
                if (familyInfo.getRespDoctorId().equals(empList.get(i).getEmp_id())) {
                    sp_respDoctor.setSelection(i);
                    break;
                }
            }
        }

//         sp_respDoctor;    //  责任医生
        et_address.setText(familyInfo.getAddress());      //家庭地址
//        setCheckBoxSelect("householdProperty", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_householdProperty);     //户属性
        setCheckBoxSelect("householdProperty", familyInfo.getRecordChoice(), ll_householdProperty);     //户属性
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getHouseholdTypeCode(), ll_householdType);  //户籍类型
        et_dwellingArea.setText(familyInfo.getFamilyEconomic().getDwellingArea()); //居住面积
        et_dwellingAreaPer.setText(familyInfo.getFamilyEconomic().getDwellingAreaPer());  //人均居住面积
        setRadioButtonSelect(familyInfo.getFamilyEconomic().getHouseTypeCode(),familyInfo.getFamilyEconomic().getHouseTypeName(), ll_houseType);  //房屋类型
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getKitchenUseModeCode(), ll_kitchenUseMode); //使用方式
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getKitchenExhaustCode(), ll_kitchenExhaust); //排风设备
//        setCheckBoxSelect("familyDrinkWater", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_familyDrinkWater);   //饮水
        setCheckBoxSelect("familyDrinkWater", familyInfo.getRecordChoice(), ll_familyDrinkWater);   //饮水
//        setCheckBoxSelect("fuelType", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_fuelType);   //燃料
        setCheckBoxSelect("fuelType", familyInfo.getRecordChoice(), ll_fuelType);   //燃料
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getSanitaryToiletCode(), ll_sanitaryToilet); //卫生厕所
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getNoSanitaryToiletCode(), ll_noSanitaryToilet);   //非卫生厕所
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getLivestockFenceCode(), ll_livestockFence); //禽畜栏
        setRadioButtonSelect(familyInfo.getFamilyEconomic().getGarbageDisposalCode(), familyInfo.getFamilyEconomic().getGarbageDisposalName(), ll_garbageDisposal);    //垃圾处理
//        setCheckBoxSelect("householdAppliance", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_householdAppliance); //家用电器
        setCheckBoxSelect("householdAppliance", familyInfo.getRecordChoice(), ll_householdAppliance); //家用电器
        setCheckBoxSelect("transport", familyInfo.getRecordChoice(), ll_transport);  //交通工具

//         lv_card;//证件

//        list_familyCredential = sqlHelper.getFamilyCredentialDao().queryBuilder().where(FamilyCredentialDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).list();
//        list_familyCredential = familyInfo.getFamilyCredential();
        for (int i = 0; i < familyInfo.getFamilyCredential().size(); i++) {

//            Checks checks = (Checks) sp_credentialType.getSelectedItem();

            FamilyCredential familyCredential = new FamilyCredential();
            familyCredential.setCredentialTypeCode(familyInfo.getFamilyCredential().get(i).getCredentialTypeCode());
            String vule = sqlHelper.getChecksValueByCode(familyInfo.getFamilyCredential().get(i).getCredentialTypeCode(), "family_id_type");
            familyCredential.setCredentialTypeValue(vule);
            familyCredential.setCredentialNo(familyInfo.getFamilyCredential().get(i).getCredentialNo());
//            if (save_update) {
            familyCredential.setFamilyInfoId(null);
//            }else
//                familyCredential.setFamilyInfoId(mFamilyInfo.getFamilyInfoId());
            list_familyCredential.add(familyCredential);

        }

        credentialAdapter.notifyDataSetChanged();


        tv_orgName.setText(familyInfo.getOrgName());  //建档机构
        tv_creator.setText(familyInfo.getCreator());  //建档人
        tv_createTime.setText(familyInfo.getCreateTime());   //建档时间

        ScrollView sc_main = (ScrollView)mFuView.findViewById(R.id.sc_main);
        sc_main.scrollTo(0,0);
//        setListener();
    }


    public boolean saveData(FamilyInfo familyInfo,RoomAll roomAll) {
//         sp_committee;  //村居委会
//         sp_residential;   //小区
//         sp_building;  //楼栋
//         sp_unit;      //单元
//         sp_roomNumber;   // 房间号
        if ("".equals(et_householder.getString())) {
            ToastUtil.showToast(mContext, "请输入户主姓名！", Toast.LENGTH_LONG);
            return false;
        }

        if(btn_committee.getTag()==null||"".equals(btn_committee.getTag().toString())){
            ToastUtil.showToast(mContext, "请选择村居委会！", Toast.LENGTH_LONG);
            return false;
        }

        familyInfo.getRecordChoice().clear();
        familyInfo.setCommittee(btn_committee.getTag().toString());
        roomAll.setDistrictId(btn_committee.getTag().toString());
        roomAll.setDistrictName(btn_committee.getText().toString().trim());
        if (sp_residential.getSelectedItem() != null) {
            familyInfo.setResidential(((SpinnerItem) sp_residential.getSelectedItem()).getId());
            roomAll.setSubDistrictId(((SpinnerItem) sp_residential.getSelectedItem()).getId());
            roomAll.setSubDistrictName(((SpinnerItem) sp_residential.getSelectedItem()).getValue());
        }
        if (sp_building.getSelectedItem() != null) {
            familyInfo.setBuilding(((SpinnerItem) sp_building.getSelectedItem()).getId());
            roomAll.setBuildingId(((SpinnerItem) sp_building.getSelectedItem()).getId());
            roomAll.setBuildingName(((SpinnerItem) sp_building.getSelectedItem()).getValue());
        }
        if (sp_unit.getSelectedItem() != null)
            familyInfo.setUnit(((SpinnerItem) sp_unit.getSelectedItem()).getId());
        if (sp_roomNumber.getSelectedItem() != null)
            familyInfo.setRoomNumber(((SpinnerItem) sp_roomNumber.getSelectedItem()).getValue());

        familyInfo.setHouseholdNo(et_householdNo.getString());  //户口本号
        familyInfo.setHouseholder(et_householder.getString());  //户主姓名
        familyInfo.setHouseholderIdNo(et_householderIdNo.getString());  //户主身份证
        familyInfo.setTelNo(et_telNo.getString());    //联系电话
//         sp_respDoctor;    //  责任医生
        Emp emp = (Emp) sp_respDoctor.getSelectedItem();
        if (emp != null) {
            familyInfo.setRespDoctorId(emp.getEmp_id());
            familyInfo.setRespDoctorName(emp.getEmp_name());
        }
        familyInfo.setAddress(et_address.getString());      //家庭地址

        if (save_update) {
            saveCheckBoxMany(null, familyInfo.getRecordChoice(), ll_householdProperty);     //户属性
        } else
            saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_householdProperty); //户属性

        familyInfo.getFamilyEconomic().setHouseholdTypeCode(getCheckBoxSimpleCode(ll_householdType));  //户籍类型
        familyInfo.getFamilyEconomic().setHouseholdTypeName(getCheckBoxSimpleString(ll_householdType));//户籍类型中文值
        familyInfo.getFamilyEconomic().setDwellingArea(et_dwellingArea.getDouble()); //居住面积
        familyInfo.getFamilyEconomic().setDwellingAreaPer(et_dwellingAreaPer.getDouble());  //人均居住面积
        familyInfo.getFamilyEconomic().setHouseTypeCode(getCheckBoxSimpleCode(ll_houseType));  //房屋类型
        familyInfo.getFamilyEconomic().setHouseTypeName(getString(ll_houseType));
        familyInfo.getFamilyEconomic().setKitchenUseModeCode(getCheckBoxSimpleCode(ll_kitchenUseMode)); //使用方式
        familyInfo.getFamilyEconomic().setKitchenExhaustCode(getCheckBoxSimpleCode(ll_kitchenExhaust));//排风设备
        if (save_update) {
            saveCheckBoxMany(null, familyInfo.getRecordChoice(), ll_familyDrinkWater);   //饮水
            saveCheckBoxMany(null, familyInfo.getRecordChoice(), ll_fuelType);   //燃料
        } else {
            saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_familyDrinkWater);   //饮水
            saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_fuelType);   //燃料
        }

        familyInfo.getFamilyEconomic().setSanitaryToiletCode(getCheckBoxSimpleCode(ll_sanitaryToilet)); //卫生厕所
        familyInfo.getFamilyEconomic().setNoSanitaryToiletCode(getCheckBoxSimpleCode(ll_noSanitaryToilet)); //非卫生厕所
        familyInfo.getFamilyEconomic().setLivestockFenceCode(getCheckBoxSimpleCode(ll_livestockFence)); //禽畜栏
        familyInfo.getFamilyEconomic().setGarbageDisposalCode(getCheckBoxSimpleCode(ll_garbageDisposal));   //垃圾处理
        familyInfo.getFamilyEconomic().setGarbageDisposalName(getString(ll_garbageDisposal));

        if (save_update) {
            saveCheckBoxMany(null, familyInfo.getRecordChoice(), ll_householdAppliance); //家用电器
            saveCheckBoxMany(null, familyInfo.getRecordChoice(), ll_transport);  //交通工具
        } else {
            saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_householdAppliance); //家用电器
            saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_transport);  //交通工具
        }

        //证件
        familyInfo.setFamilyCredential(list_familyCredential);

        familyInfo.setOrgName(tv_orgName.getText().toString().trim());  //建档机构
        familyInfo.setCreator(tv_creator.getText().toString().trim());  //建档人
        familyInfo.setCreateTime(tv_createTime.getDate());   //建档时间

        if (save_update) {
            familyInfo.getFamilyEconomic().setFamilyEconomicId(null);
        }

        return true;

    }


    @Override
    protected void initFuData() {

        initCheckBoxMany("householdProperty", ll_householdProperty, 3, false,true); //户属性
        initCheckBoxSimple("DOMICILE_TYPE", ll_householdType, 0);//户籍类型
        initCheckBoxSimple("houseTypeCode", ll_houseType, 5, true,true);//房屋类型
        initCheckBoxSimple("CV9500.13", ll_kitchenUseMode, 0);//使用方式
        initCheckBoxSimple("CV9500.14", ll_kitchenExhaust, 0);//排风设备

        initCheckBoxMany("familyDrinkWater", ll_familyDrinkWater,4, false,true);//饮水

        initCheckBoxMany("fuelType", ll_fuelType, 4, false,true);//燃料
        initCheckBoxSimple("CV9500.17", ll_sanitaryToilet, 3);//卫生厕所
        initCheckBoxSimple("CV9500.18", ll_noSanitaryToilet, 3); //非卫生厕所
        initCheckBoxSimple("CV9500.20", ll_livestockFence, 0);//禽畜栏
        initCheckBoxSimple("CV9500.19", ll_garbageDisposal, 0, false, true);//垃圾处理
        initCheckBoxMany("householdAppliance", ll_householdAppliance, 3, true);//家用电器
        initCheckBoxMany("transport", ll_transport, 3, false,true);//交通工具

        credentialAdapter = new CredentialAdapter(mContext);
        lv_card.setAdapter(credentialAdapter);

//        list_credentialType = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("familyIdType")).list();
        list_credentialType = sqlHelper.getChecksByTerm("family_id_type");
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                list_credentialType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_credentialType.setAdapter(adapter);


        empList = sqlHelper.getDoctors();
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_respDoctor.setAdapter(adapter);


    }


    /**
     * 多级菜单的点击事件监听
     */
    TreeListViewAdapter.OnTreeNodeClickListener onTreeNodeClickListener = new TreeListViewAdapter.OnTreeNodeClickListener() {
        @Override
        public void onClick(Node node, int position) {
            if (node.isLeaf()) {
                if (popupWindow != null && popupWindow.isShowing())
                    popupWindow.dismiss();
                List<Node> nodes = simpleTreeAdapter.getNodes();
                btn_committee.setText(nodes.get(position).getName());
                btn_committee.setTag(nodes.get(position).getId());
                setAddress();
                if (saSubdistricts != null)
                    saSubdistricts.clearn();
                if (saBuilding != null)
                    saBuilding.clearn();
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();

                mEventCallBack.EventClick(FuFamilyAddFragment.EVENT_GET_SUBDISTRICT, nodes.get(position).getId());
            }
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_residential:
                if (!canTouch) {
                    return;
                }
                String subId = ((SpinnerItem) sp_residential.getSelectedItem()).getId();
                setAddress();
                if (saBuilding != null)
                    saBuilding.clearn();
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();

                if (subId == null || "".equals(subId))
                    return;
                mEventCallBack.EventClick(FuFamilyAddFragment.EVENT_GET_BUILDING, subId);

                break;
            case R.id.sp_building:
                if (!canTouch) {
                    return;
                }
                setAddress();
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();

                String buildingId = ((SpinnerItem) sp_building.getSelectedItem()).getId();
                if (buildingId == null || "".equals(buildingId))
                    return;
                mEventCallBack.EventClick(FuFamilyAddFragment.EVENT_GET_UNIT, buildingId);

                break;
            case R.id.sp_unit:
                if (!canTouch) {
                    return;
                }
                setAddress();
                if (saRoom != null)
                    saRoom.clearn();
                String unitId = ((SpinnerItem) sp_unit.getSelectedItem()).getId();
                String buildingId2 = ((SpinnerItem) sp_building.getSelectedItem()).getId();
                if (unitId == null || "".equals(unitId))
                    return;
                mEventCallBack.EventClick(FuFamilyAddFragment.EVENT_GET_ROOM, buildingId2 + "/" + unitId);
                break;
            case R.id.sp_roomNumber:
                if (!canTouch) {
                    return;
                }
                setAddress();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * 证件类型
     */
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
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_card_item, null);
                holder = new HealthExamInhosHolder();
                holder.tv_type = (FuTextView) convertView.findViewById(R.id.tv_type);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_type.setText(list_familyCredential.get(position).getCredentialTypeValue());
            holder.tv_num.setText(list_familyCredential.get(position).getCredentialNo());
            holder.tv_delete.setText("删除");


            if("3".equals(list_familyCredential.get(position).getCredentialTypeCode())){
                holder.tv_delete.setTextColor(Color.GRAY);
                holder.tv_delete.setTag("delete");
            }else{
                holder.tv_delete.setTextColor(Color.BLACK);
                holder.tv_delete.setTag(position);
            }

            holder.tv_delete.setOnClickListener(FuFamilyAddView.this);


            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_type;       //接种日期
            FuTextView tv_num;      //接种机构
            FuTextView tv_delete;             // 删除
        }

    }

    public void findView() {
        btn_committee = (FuButton) mFuView.findViewById(R.id.btn_committee);
        btn_committee.setOnClickListener(this);

//        sp_committee = (Spinner)mFuView.findViewById(R.id.sp_committee);//居委会
        sp_residential = (Spinner) mFuView.findViewById(R.id.sp_residential);   //小区


        sp_building = (Spinner) mFuView.findViewById(R.id.sp_building);  //楼栋

        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit);      //单元

        sp_roomNumber = (Spinner) mFuView.findViewById(R.id.sp_roomNumber);   // 房间号

        setListener();
        et_householdNo = (FuEditText) mFuView.findViewById(R.id.et_householdNo);  //户口本号
        et_householder = (FuEditText) mFuView.findViewById(R.id.et_householder);  //户主姓名
        et_householderIdNo = (FuEditText) mFuView.findViewById(R.id.et_householderIdNo);  //户主身份证
        et_telNo = (FuEditText) mFuView.findViewById(R.id.et_telNo);    //联系电话
        sp_respDoctor = (Spinner) mFuView.findViewById(R.id.sp_respDoctor);    //  责任医生
        et_address = (FuEditText) mFuView.findViewById(R.id.et_address);      //家庭地址
        ll_householdProperty = (LinearLayout) mFuView.findViewById(R.id.ll_householdProperty);     //户属性
        ll_householdType = (LinearLayout) mFuView.findViewById(R.id.ll_householdType);  //户籍类型
        et_dwellingArea = (FuEditText) mFuView.findViewById(R.id.et_dwellingArea); //居住面积
        et_dwellingAreaPer = (FuEditText) mFuView.findViewById(R.id.et_dwellingAreaPer);  //人均居住面积
        ll_houseType = (LinearLayout) mFuView.findViewById(R.id.ll_houseType);  //房屋类型
        ll_kitchenUseMode = (LinearLayout) mFuView.findViewById(R.id.ll_kitchenUseMode); //使用方式
        ll_kitchenExhaust = (LinearLayout) mFuView.findViewById(R.id.ll_kitchenExhaust); //排风设备
        ll_familyDrinkWater = (LinearLayout) mFuView.findViewById(R.id.ll_familyDrinkWater);   //饮水
        ll_fuelType = (LinearLayout) mFuView.findViewById(R.id.ll_fuelType);   //燃料
        ll_sanitaryToilet = (LinearLayout) mFuView.findViewById(R.id.ll_sanitaryToilet); //卫生厕所
        ll_noSanitaryToilet = (LinearLayout) mFuView.findViewById(R.id.ll_noSanitaryToilet);   //非卫生厕所
        ll_livestockFence = (LinearLayout) mFuView.findViewById(R.id.ll_livestockFence); //禽畜栏
        ll_garbageDisposal = (LinearLayout) mFuView.findViewById(R.id.ll_garbageDisposal);    //垃圾处理
        ll_householdAppliance = (LinearLayout) mFuView.findViewById(R.id.ll_householdAppliance); //家用电器
        ll_transport = (LinearLayout) mFuView.findViewById(R.id.ll_transport);  //交通工具
        lv_card = (FuListView) mFuView.findViewById(R.id.lv_card);//证件类型

        sp_credentialType = (Spinner) mFuView.findViewById(R.id.sp_credentialType);

        et_credentialNo = (FuEditText) mFuView.findViewById(R.id.et_credentialNo);

        btn_add = (Button) mFuView.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        tv_orgName = (FuTextView) mFuView.findViewById(R.id.tv_orgName);  //建档机构
        tv_creator = (FuTextView) mFuView.findViewById(R.id.tv_creator);  //建档人
        tv_createTime = (FuTextView) mFuView.findViewById(R.id.tv_createTime);   //建档时间
        tv_createTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(tv_createTime)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(),"year-month-day");
            }
        });
    }

    @Override
    protected void initWidget() {
        findView();
        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("新增家庭");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }
}
