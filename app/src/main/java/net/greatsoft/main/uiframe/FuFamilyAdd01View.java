package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.tool.StringUtils;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.adapter.SpinnerAdapter;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class FuFamilyAdd01View extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner sp_committee;//村居委会
    Spinner sp_residential;   //小区
    Spinner sp_building;  //楼栋
    Spinner sp_unit;      //单元
    Spinner sp_roomNumber;   // 房间号
    FuEditText et_householdNo;  //户口本号
    FuEditText et_householder;  //户主姓名
    FuEditText et_householderIdNo;  //户主身份证
    FuEditText et_telNo;    //联系电话
    Spinner sp_respDoctor;    //  责任医生
    FuEditText et_address;      //家庭地址
    LinearLayout ll_householdProperty;     //户属性
    LinearLayout ll_householdType;  //户籍类型

    List<SpinnerItem> districtsList;//地区

    List<SpinnerItem> subdistrictsList;//小区

    List<SpinnerItem> buildingsList;  //楼

    List<SpinnerItem> unitList;//单元

    List<SpinnerItem> roomList;//房间

    SpinnerAdapter saSubdistricts;//小区
    SpinnerAdapter saBuilding;//楼
    SpinnerAdapter saUnit;//单元
    SpinnerAdapter saRoom;//房间

    public FuFamilyAdd01View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_family_add_01_view, null);
    }

    @Override
    protected void initFuData() {
        districtsList = sqlHelper.getDistricts();
        SpinnerAdapter adapter = new SpinnerAdapter(mContext, districtsList);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_committee.setAdapter(adapter);
        sp_committee.setOnItemSelectedListener(FuFamilyAdd01View.this);

        initCheckBoxMany("householdProperty", ll_householdProperty, 3, true); //户属性
        initCheckBoxSimple("DOMICILE_TYPE", ll_householdType, 0);//户籍类型

    }

    @Override
    protected void initWidget() {
        findView();

    }

    private void findView() {
        sp_committee = (Spinner) mFuView.findViewById(R.id.sp_committee);//居委会
        sp_residential = (Spinner) mFuView.findViewById(R.id.sp_residential);   //小区
        sp_building = (Spinner) mFuView.findViewById(R.id.sp_building);  //楼栋
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit);      //单元
        sp_roomNumber = (Spinner) mFuView.findViewById(R.id.sp_roomNumber);   // 房间号
        et_householdNo = (FuEditText) mFuView.findViewById(R.id.et_householdNo);  //户口本号
        et_householder = (FuEditText) mFuView.findViewById(R.id.et_householder);  //户主姓名
        et_householderIdNo = (FuEditText) mFuView.findViewById(R.id.et_householderIdNo);  //户主身份证
        et_telNo = (FuEditText) mFuView.findViewById(R.id.et_telNo);    //联系电话
        sp_respDoctor = (Spinner) mFuView.findViewById(R.id.sp_respDoctor);    //  责任医生
        et_address = (FuEditText) mFuView.findViewById(R.id.et_address);      //家庭地址
        ll_householdProperty = (LinearLayout) mFuView.findViewById(R.id.ll_householdProperty);     //户属性
        ll_householdType = (LinearLayout) mFuView.findViewById(R.id.ll_householdType);  //户籍类型

    }

    public void saveData(FamilyInfo familyInfo) {
//         sp_committee;  //村居委会
//         sp_residential;   //小区
//         sp_building;  //楼栋
//         sp_unit;      //单元
//         sp_roomNumber;   // 房间号

        familyInfo.setCommittee(StringUtils.getStringId(sp_committee));
        familyInfo.setResidential(StringUtils.getStringId(sp_residential));
        familyInfo.setBuilding(StringUtils.getStringId(sp_building));
        familyInfo.setUnit(StringUtils.getStringName(sp_unit));
        familyInfo.setRoomNumber(StringUtils.getStringId(sp_roomNumber));

        familyInfo.setHouseholdNo(et_householdNo.getString());  //户口本号
        familyInfo.setHouseholder(et_householder.getString());  //户主姓名
        familyInfo.setHouseholderIdNo(et_householderIdNo.getString());  //户主身份证
        familyInfo.setTelNo(et_telNo.getString());    //联系电话
//         sp_respDoctor;    //  责任医生
        familyInfo.setAddress(et_address.getString());      //家庭地址
        saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_householdProperty);     //户属性
        familyInfo.getFamilyEconomic().setHouseholdTypeCode(getCheckBoxSimpleCode(ll_householdType));  //户籍类型
        familyInfo.getFamilyEconomic().setHouseholdTypeName(getCheckBoxSimpleString(ll_householdType));//户籍类型中文值
    }


    public void setData(FamilyInfo familyInfo,  RoomAll roomAll) {
//济南的不用入户随访
//        if (roomAll == null) {
//
//        } else {
////            sp_committee.setOnItemSelectedListener(null);
////            sp_residential.setOnItemSelectedListener(null);
////            sp_building.setOnItemSelectedListener(null);
////            sp_unit.setOnItemSelectedListener(null);
////            sp_roomNumber.setOnItemSelectedListener(null);
//
////            setRoom(roomAll);
//
//            sp_committee.setOnItemSelectedListener(this);
//            sp_residential.setOnItemSelectedListener(this);
//            sp_building.setOnItemSelectedListener(this);
//            sp_unit.setOnItemSelectedListener(this);
//            sp_roomNumber.setOnItemSelectedListener(this);
//        }

        sp_committee.setOnItemSelectedListener(this);
        sp_residential.setOnItemSelectedListener(this);
        sp_building.setOnItemSelectedListener(this);
        sp_unit.setOnItemSelectedListener(this);
        sp_roomNumber.setOnItemSelectedListener(this);

//        mFamilyInfo = familyInfo;
        et_householdNo.setText(familyInfo.getHouseholdNo());  //户口本号
        et_householder.setText(familyInfo.getHouseholder());  //户主姓名
        et_householderIdNo.setText(familyInfo.getHouseholderIdNo());  //户主身份证
        et_telNo.setText(familyInfo.getTelNo());    //联系电话
//         sp_respDoctor;    //  责任医生
        et_address.setText(familyInfo.getAddress());      //家庭地址
        setCheckBoxSelect("householdProperty", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_householdProperty);     //户属性
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getHouseholdTypeCode(), ll_householdType);  //户籍类型
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_committee:
                if (saSubdistricts != null)
                    saSubdistricts.clearn();
                if (saBuilding != null)
                    saBuilding.clearn();
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();

                initSubDistricts(districtsList.get(position).getId());

                break;
            case R.id.sp_residential:
                if (saBuilding != null)
                    saBuilding.clearn();
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();
                initBuildings(subdistrictsList.get(position).getId());

                break;
            case R.id.sp_building:
                if (saUnit != null)
                    saUnit.clearn();
                if (saRoom != null)
                    saRoom.clearn();
                initUnit(buildingsList.get(position).getId());
                break;
            case R.id.sp_unit:
                if (saRoom != null)
                    saRoom.clearn();
                initRoom(unitList.get(position).getId(), unitList.get(position).getValue());
                break;
            case R.id.sp_roomNumber:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * 加载小区
     *
     * @param districtId
     */
    private void initSubDistricts(String districtId) {
        subdistrictsList = sqlHelper.getSubdistricts(districtId);

        if (saSubdistricts == null) {
            saSubdistricts = new SpinnerAdapter(mContext,
                    subdistrictsList);
            sp_residential.setAdapter(saSubdistricts);
            saSubdistricts.notifyDataSetChanged();
            sp_residential.setOnItemSelectedListener(FuFamilyAdd01View.this);
        } else {
            saSubdistricts.setDataChanged(subdistrictsList);
        }
    }

    /**
     * 加载楼栋
     */
    private void initBuildings(String subDistrictsId) {
        buildingsList = sqlHelper.getBuildings(subDistrictsId);

        if (saBuilding == null) {
            saBuilding = new SpinnerAdapter(mContext,
                    buildingsList);
            sp_building.setAdapter(saBuilding);
            saBuilding.notifyDataSetChanged();
            sp_building.setOnItemSelectedListener(FuFamilyAdd01View.this);
        } else {
            saBuilding.setDataChanged(buildingsList);
        }

    }

    /**
     * 加载单元
     */
    private void initUnit(String buildingId) {
        unitList = sqlHelper.getUnit(buildingId);

        if (saUnit == null) {
            saUnit = new SpinnerAdapter(mContext,
                    unitList);
            sp_unit.setAdapter(saUnit);
            saUnit.notifyDataSetChanged();
            sp_unit.setOnItemSelectedListener(FuFamilyAdd01View.this);
        } else {
            saUnit.setDataChanged(unitList);
        }
    }

    /**
     * 加载房间
     */
    private void initRoom(String buildingId, String unitNo) {
        roomList = sqlHelper.getRoom(buildingId, unitNo);

        if (saRoom == null) {
            saRoom = new SpinnerAdapter(mContext,
                    roomList);

            sp_roomNumber.setAdapter(saRoom);
            saRoom.notifyDataSetChanged();
            sp_roomNumber.setOnItemSelectedListener(FuFamilyAdd01View.this);
        } else {
            saRoom.setDataChanged(roomList);
        }
    }

    /**
     * 设置房间
     */

    public void setRoom(RoomAll room) {
        if (room == null) {
            return;
        }

        if (districtsList == null)
            return;

        for (int i = 0; i < districtsList.size(); i++) {
            if (districtsList.get(i).getId().equals(room.getDistrictId())) {
                sp_committee.setSelection(i);
                break;
            }
        }
        initSubDistricts(room.getDistrictId());
        for (int i = 0; i < subdistrictsList.size(); i++) {
            if (subdistrictsList.get(i).getId().equals(room.getSubDistrictId())) {
                sp_residential.setSelection(i);
                break;
            }
        }
        initBuildings(room.getSubDistrictId());
        for (int i = 0; i < buildingsList.size(); i++) {
            if (buildingsList.get(i).getId().equals(room.getBuildingId())) {
                sp_building.setSelection(i);
                break;
            }
        }
        initUnit(room.getBuildingId());
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i).getValue().equals(room.getUnitNo())) {
                sp_unit.setSelection(i);
                break;
            }
        }

        initRoom(room.getBuildingId(), room.getUnitNo());
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getValue().equals(room.getRoomNum())) {
                sp_roomNumber.setSelection(i);
                break;
            }
        }
    }
}
