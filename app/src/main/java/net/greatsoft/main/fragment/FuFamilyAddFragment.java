package net.greatsoft.main.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.districts.Buildings;
import net.greatsoft.main.db.po.districts.Room;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.districts.Subdistricts;
import net.greatsoft.main.db.po.districts.Unit;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.obj.FamilyRsp;
import net.greatsoft.main.tool.ImageCondense;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuFamilyAddView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 16/9/1.
 */

public class FuFamilyAddFragment extends FragmentParent {
    private String familyInfoId;
    FamilyInfo familyInfo;

    RoomAll roomAll = new RoomAll();
    File file;

    public boolean save_update = true;//新增true 更新false

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_FAMILY_ADD, getActivity(),
                new OnEventClick());


        if (familyInfoId == null) {
            familyInfo = new FamilyInfo();
            save_update = true;
            setnull();

        } else {
            save_update = false;
            findFamilyByFaimlyInfoId();
        }


        return mModel.getFuView();
    }

    public void findFamilyByFaimlyInfoId() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findFamilyInfoById(getCallBackInstance(), familyInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    public void intentData(Bundle bundle) {

        if (bundle == null) {
            String id = UUID.randomUUID().toString();
            familyInfo = new FamilyInfo();
            familyInfo.setFamilyInfoId(id);
        } else {
            if (bundle.getSerializable("room") != null) {
                roomAll = (RoomAll) bundle.getSerializable("room");
                String id = UUID.randomUUID().toString();
                familyInfo = new FamilyInfo();
                familyInfo.setFamilyInfoId(id);
            } else {
                familyInfoId = bundle.getString("familyInfoId");
            }
        }

    }

    public static final int EVENT_SAVE_FAMILY = 1;//保存家庭

    public static final int EVENT_GET_SUBDISTRICT = 2;//获取小区

    public static final int EVENT_GET_BUILDING = 3;//获取楼栋信息

    public static final int EVENT_GET_UNIT = 4;//获取单元

    public static final int EVENT_GET_ROOM = 5;//获取房间

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_FAMILY:
                    saveData();
//                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case EVENT_GET_SUBDISTRICT:
                    MyTask lTask = TaskManager.getInstace(getActivity())
                            .getSubDistrict(getCallBackInstance(), object.toString(), getContext());

                    excuteNetTask(lTask, false);
                    break;
                case EVENT_GET_BUILDING:

                    MyTask getBuildingTask = TaskManager.getInstace(getActivity())
                            .getBuilding(getCallBackInstance(), object.toString(), getContext());

                    excuteNetTask(getBuildingTask, false);
                    break;
                case EVENT_GET_UNIT:
                    MyTask getUnitTask = TaskManager.getInstace(getActivity())
                            .getUnit(getCallBackInstance(), object.toString(), getContext());

                    excuteNetTask(getUnitTask, false);

                    break;
                case EVENT_GET_ROOM:
                    MyTask getRoomTask = TaskManager.getInstace(getActivity())
                            .getRoom(getCallBackInstance(), object.toString(), getContext());

                    excuteNetTask(getRoomTask, false);
                    break;
            }
        }
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {

            switch (msg.what) {
                case MyTask.UPDATE_FAMILY_INFO:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case MyTask.SAVE_FAMILY:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);

                    if (isCan_pic()) {
                        takePic();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("familyInfo", familyInfo);
                        bundle.putSerializable("roomAll",roomAll);
                        ((FuContentActivity) getActivity()).replaceFragment(
                                FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, bundle);
                        ((FuContentActivity) getActivity()).clearFragmentNoCurAndFirst();
                    }

                    break;
                case MyTask.GET_SUBDISTRICT:
                    ((FuFamilyAddView) mModel).setSubdistricts((List<SpinnerItem>) msg.obj);
                    break;
                case MyTask.GET_BUILDING:
                    ((FuFamilyAddView) mModel).setBuildings((List<SpinnerItem>) msg.obj);
                    break;
                case MyTask.GET_UNIT:
                    ((FuFamilyAddView) mModel).setUnit((List<SpinnerItem>) msg.obj);
                    break;
                case MyTask.GET_ROOM:
                    ((FuFamilyAddView) mModel).setRoom((List<SpinnerItem>) msg.obj);
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.FIND_FAMILY:
                    FamilyRsp rsp = (FamilyRsp) msg.obj;
                    setData(rsp);
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
    }


    public void saveFamilyInfo() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .upDataFamilyInfo(getCallBackInstance(), familyInfo, getContext());

        excuteNetTask(lTask, false);

    }

    public void updateFamilyInfo() {
        MyTask lTask = TaskManager.getInstace(getActivity())
                .updateFamilyInfo(getCallBackInstance(), familyInfo, getContext());

        excuteNetTask(lTask, false);
    }


    public void setData(FamilyRsp rsp) {
        ((FuFamilyAddView) mModel).setData(rsp.getFamilyInfo(), rsp.getDistrict(), roomAll, save_update);


    }

    public void setnull() {
        ((FuFamilyAddView) mModel).setData(familyInfo, null, null, save_update);


    }

    public void saveData() {
        if (((FuFamilyAddView) mModel).saveData(familyInfo,roomAll)) {
            if (save_update)
                saveFamilyInfo();
            else
                updateFamilyInfo();
        }


//        sqlHelper.getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getFamilyEconomicDao().queryBuilder().where(FamilyEconomicDao.Properties.FamilyEconomicId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//
//        sqlHelper.getFamilyInfoDao().insert(familyInfo);
//        sqlHelper.getFamilyEconomicDao().insert(familyEconomic);
//        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
//        sqlHelper.getFamilyCredentialDao().insertInTx(mList_familyCredential);


    }

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

        ToolUtil.hidePopLoading();
        if (rspObj == null || rspObj.getCode() == null) {
            Message message = Message.obtain(mHandler);
            message.what = NET_ERROR;
            message.obj = "网络连接失败,请重新登录!";
            message.sendToTarget();
            return;
        }
        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            switch (taskId) {
                case MyTask.SAVE_FAMILY:
                    Message fmg = Message.obtain(mHandler);
                    fmg.what = taskId;
                    fmg.obj = rspObj.getMessage();
                    familyInfo = (FamilyInfo) JSONObject.parseObject(rspObj.getResult(), FamilyInfo.class);
                    fmg.sendToTarget();
                    break;
                case MyTask.GET_SUBDISTRICT:
                    List<Subdistricts> subdistrictsList = JSON.parseArray(rspObj.getResult(), Subdistricts.class);
                    List<SpinnerItem> spinnerItemList = new ArrayList<>();

                    SpinnerItem item = new SpinnerItem("", "");
                    spinnerItemList.add(item);

                    for (Subdistricts sub : subdistrictsList) {
                        item = new SpinnerItem(sub.getSubDistrictId(), sub.getSubDistrictName());
                        spinnerItemList.add(item);
                    }

                    Message message = Message.obtain(mHandler);
                    message.what = taskId;
                    message.obj = spinnerItemList;
                    message.sendToTarget();
                    break;
                case MyTask.GET_BUILDING:
                    List<Buildings> buildingsList = JSONArray.parseArray(rspObj.getResult(), Buildings.class);
                    List<SpinnerItem> buildingItemList = new ArrayList<>();
                    SpinnerItem item_building = new SpinnerItem("", "");
                    buildingItemList.add(item_building);

                    for (Buildings buildings : buildingsList) {
                        item_building = new SpinnerItem(buildings.getBuildingId(), buildings.getBuildingName());
                        buildingItemList.add(item_building);
                    }
                    Message messagebuilding = Message.obtain(mHandler);
                    messagebuilding.what = taskId;
                    messagebuilding.obj = buildingItemList;
                    messagebuilding.sendToTarget();

                    break;

                case MyTask.GET_UNIT:
                    List<Unit> unitList = JSONArray.parseArray(rspObj.getResult(), Unit.class);
                    List<SpinnerItem> unitItemList = new ArrayList<>();
                    SpinnerItem item_unit = new SpinnerItem("", "");
                    unitItemList.add(item_unit);

                    for (Unit unit : unitList) {
                        item_unit = new SpinnerItem(unit.getBuildingUnitNo(), unit.getBuildingUnitName());
                        unitItemList.add(item_unit);
                    }
                    Message messageUnit = Message.obtain(mHandler);
                    messageUnit.what = taskId;
                    messageUnit.obj = unitItemList;
                    messageUnit.sendToTarget();

                    break;
                case MyTask.GET_ROOM:
                    List<Room> roomList = JSONArray.parseArray(rspObj.getResult(), Room.class);
                    List<SpinnerItem> roomItemList = new ArrayList<>();
                    SpinnerItem item_room = new SpinnerItem("", "");
                    roomItemList.add(item_room);

                    for (Room room : roomList) {
                        item_room = new SpinnerItem(room.getRoomNumberId(), room.getRoomNumberNo());
                        roomItemList.add(item_room);
                    }
                    Message messageRoom = Message.obtain(mHandler);
                    messageRoom.what = taskId;
                    messageRoom.obj = roomItemList;
                    messageRoom.sendToTarget();

                    break;
                case MyTask.FIND_FAMILY:


                    FamilyRsp familyRsp = JSON.parseObject(rspObj.getResult(), FamilyRsp.class);


                    familyInfo = familyRsp.getFamilyInfo();
                    Message messagefamily = Message.obtain(mHandler);
                    messagefamily.obj = familyRsp;
                    messagefamily.what = taskId;
                    messagefamily.sendToTarget();
                    break;

                case MyTask.UPDATE_FAMILY_INFO:
                    Message mely = Message.obtain(mHandler);
                    mely.what = taskId;
                    mely.obj = rspObj.getMessage();
                    mely.sendToTarget();
                    break;
            }

        } else {
            Message error = Message.obtain(mHandler);
            error.what = MyTask.ERROR;
            error.obj = rspObj.getMessage();
            error.sendToTarget();
        }
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {
        Message message = Message.obtain(mHandler);
        message.what = NET_ERROR;
        message.obj = msg;
        message.sendToTarget();
    }

    @Override
    protected void cancelChild(int taskId) {
        Message message = Message.obtain(mHandler);
        message.what = NET_ERROR;
        message.obj = "取消访问";
        message.sendToTarget();
    }

    public void takePic() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
                File dir = new File(Constant.PIC_DIR);
                if (!dir.exists()) dir.mkdirs();
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String pic_name = UUID.randomUUID().toString();
                pic_name += ".png";
                file = new File(dir, pic_name);
                Uri u = Uri.fromFile(file);
                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, TAKE_CAM);
            } catch (ActivityNotFoundException e) {
                ToastUtil.showToast(getContext(), "没有找到储存目录", Toast.LENGTH_LONG);
            }
        } else {
            ToastUtil.showToast(getContext(), "没有储存卡", Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case TAKE_CAM:

                    Bundle b = new Bundle();
                    SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
                    int fileSize = spf.getInt("fileZipCapicity", 100);
                    if (fileSize != 0)
                        ImageCondense.scal(file.getAbsolutePath(), fileSize);

                    b.putSerializable("file", file);

//                    Bundle bundle_person = new Bundle();


                    b.putString("familyInfoId", familyInfoId);
                    b.putSerializable("familyInfo", familyInfo);
                    b.putSerializable("roomAll",roomAll);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, b);
                    ((FuContentActivity) getActivity()).clearFragmentNoCurAndFirst();
//                    savePics();

                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
