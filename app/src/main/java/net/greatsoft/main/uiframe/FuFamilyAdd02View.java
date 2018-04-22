package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.view.FuEditText;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class FuFamilyAdd02View extends FuUiFrameModel implements View.OnClickListener {

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


    public FuFamilyAdd02View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_family_add_02_view, null);
    }

    @Override
    protected void initFuData() {
        initCheckBoxSimple("houseTypeCode", ll_houseType, 0, true);//房屋类型
        initCheckBoxSimple("CV9500.13", ll_kitchenUseMode, 0);//使用方式
        initCheckBoxSimple("CV9500.14", ll_kitchenExhaust, 0);//排风设备
        initCheckBoxMany("familyDrinkWater", ll_familyDrinkWater, 3, true);//饮水
        initCheckBoxMany("fuelType", ll_fuelType, 4, true);//燃料
        initCheckBoxSimple("CV9500.17", ll_sanitaryToilet, 4);//卫生厕所
        initCheckBoxSimple("CV9500.18", ll_noSanitaryToilet, 0); //非卫生厕所
        initCheckBoxSimple("CV9500.20", ll_livestockFence, 0);//禽畜栏
        initCheckBoxSimple("CV9500.19", ll_garbageDisposal, 0, false, true);//垃圾处理
        initCheckBoxMany("householdAppliance", ll_householdAppliance, 3, true);//家用电器
        initCheckBoxMany("transport", ll_transport, 3, true);//交通工具
    }

    @Override
    protected void initWidget() {
        findView();
    }

    private void findView() {
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

    }

    public void saveData(FamilyInfo familyInfo) {

        familyInfo.getFamilyEconomic().setDwellingArea(et_dwellingArea.getDouble()); //居住面积
        familyInfo.getFamilyEconomic().setDwellingAreaPer(et_dwellingAreaPer.getDouble());  //人均居住面积
        familyInfo.getFamilyEconomic().setHouseTypeCode(getCheckBoxSimpleCode(ll_houseType));  //房屋类型
        familyInfo.getFamilyEconomic().setHouseTypeName(getCheckBoxSimpleString(ll_houseType));
        familyInfo.getFamilyEconomic().setKitchenUseModeCode(getCheckBoxSimpleCode(ll_kitchenUseMode)); //使用方式
        familyInfo.getFamilyEconomic().setKitchenExhaustCode(getCheckBoxSimpleCode(ll_kitchenExhaust));
        ; //排风设备
        saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_familyDrinkWater);   //饮水
        saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_fuelType);   //燃料
        familyInfo.getFamilyEconomic().setSanitaryToiletCode(getCheckBoxSimpleCode(ll_sanitaryToilet)); //卫生厕所
        familyInfo.getFamilyEconomic().setNoSanitaryToiletCode(getCheckBoxSimpleCode(ll_noSanitaryToilet));
        ;   //非卫生厕所
        familyInfo.getFamilyEconomic().setLivestockFenceCode(getCheckBoxSimpleCode(ll_livestockFence)); //禽畜栏
        familyInfo.getFamilyEconomic().setGarbageDisposalCode(getCheckBoxSimpleCode(ll_garbageDisposal));   //垃圾处理
        familyInfo.getFamilyEconomic().setGarbageDisposalName(getCheckBoxSimpleString(ll_garbageDisposal));
        saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_householdAppliance); //家用电器
        saveCheckBoxMany(familyInfo.getFamilyEconomic().getFamilyEconomicId(), familyInfo.getRecordChoice(), ll_transport);  //交通工具

    }

    public void setData(FamilyInfo familyInfo, RoomAll roomAll) {

        et_dwellingArea.setText(familyInfo.getFamilyEconomic().getDwellingArea()); //居住面积
        et_dwellingAreaPer.setText(familyInfo.getFamilyEconomic().getDwellingAreaPer());  //人均居住面积
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getHouseholdTypeCode(), ll_houseType);  //房屋类型
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getKitchenUseModeCode(), ll_kitchenUseMode); //使用方式
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getKitchenExhaustCode(), ll_kitchenExhaust); //排风设备
        setCheckBoxSelect("familyDrinkWater", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_familyDrinkWater);   //饮水
        setCheckBoxSelect("fuelType", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_fuelType);   //燃料
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getSanitaryToiletCode(), ll_sanitaryToilet); //卫生厕所
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getNoSanitaryToiletCode(), ll_noSanitaryToilet);   //非卫生厕所
        setCheckBoxSelect(familyInfo.getFamilyEconomic().getLivestockFenceCode(), ll_livestockFence); //禽畜栏
        setRadioButtonSelect(familyInfo.getFamilyEconomic().getGarbageDisposalCode(), familyInfo.getFamilyEconomic().getGarbageDisposalName(), ll_garbageDisposal);    //垃圾处理
        setCheckBoxSelect("householdAppliance", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_householdAppliance); //家用电器
        setCheckBoxSelect("transport", familyInfo.getFamilyEconomic().getFamilyEconomicId(), ll_transport);  //交通工具

    }

}
