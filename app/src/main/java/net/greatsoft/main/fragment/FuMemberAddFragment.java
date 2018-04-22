package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.districts.Subdistricts;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuMemberAddView;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhanglin on 16/9/1.
 */

public class FuMemberAddFragment extends FragmentParent {

    PersonInfo personInfo = null;
    String personInfoId;
    String familyInfoId;
    boolean save_update = true;//新增true 更新false
    File file;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_MEMBER_ADD, getActivity(),
                new OnEventClick());

        if (!save_update) {

            findPersonInfoByPersonInfoId();
        } else {
            personInfo.setFamilyInfoId(familyInfoId);
            setData();
        }

        return mModel.getFuView();
    }


    //
    public void intentData(Bundle bundle) {
        String[] decodeInfo = null;//身份信息
        if (bundle == null || bundle.getString("personInfoId") == null) {
            if (bundle != null) {
                file = (File) bundle.getSerializable("file");
                familyInfoId = bundle.getString("familyInfoId");
                decodeInfo = bundle.getStringArray("decodeInfo");
            }
            personInfo = new PersonInfo();
            if (decodeInfo != null) {
                Log.e("eeeeeeeeeee", decodeInfo[0] + decodeInfo[1] + decodeInfo[2] + decodeInfo[3] + decodeInfo[4] + decodeInfo[5] + decodeInfo[6]);

                personInfo.setName(decodeInfo[0]);
                personInfo.setIdNo(decodeInfo[5]);
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd ");
                    Date date = sdf.parse(decodeInfo[3]);
                    personInfo.setBirthday(date);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                personInfo.setAddress(decodeInfo[4]);

//                personInfo.setNationalityCode(sqlHelper.getCodeByTerm(decodeInfo[2]+"族"));//民族
//                personInfo.setNationalityValue(decodeInfo[2]);

            }

            save_update = true;
            String id = UUID.randomUUID().toString();

            personInfo.setPersonInfoId(id);
            personInfoId = id;
            if (bundle.getSerializable("familyInfo") != null && !bundle.getSerializable("familyInfo").equals("")) {
                FamilyInfo familyInfo = (FamilyInfo) bundle.getSerializable("familyInfo");
                RoomAll all = (RoomAll) bundle.getSerializable("roomAll");
                familyInfoId = familyInfo.getFamilyInfoId();
                personInfo.setName(familyInfo.getHouseholder());//姓名
                personInfo.setIdNo(familyInfo.getHouseholderIdNo());//身份证
                personInfo.setAddress(familyInfo.getAddress());//家庭地址
                personInfo.setTelNo(familyInfo.getTelNo());//联系电话
                if (all != null && !all.equals("")) {
                    personInfo.setCommittee(all.getDistrictId());
                    personInfo.setCommitteeCN(all.getDistrictName());
                    personInfo.setResidential(all.getSubDistrictId());
                    personInfo.setResidentialCN(all.getSubDistrictName());
                    personInfo.setBuilding(all.getBuildingId());
                    personInfo.setBuildingCN(all.getBuildingName());
                }
            }
        } else {
            personInfoId = bundle.getString("personInfoId");
            save_update = false;
        }
    }

    public void findPersonInfoByPersonInfoId() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findPersonInfoByPersonInfoId(getCallBackInstance(), personInfoId, getContext());

        excuteNetTask(lTask, false);
    }

    public static final int EVENT_SAVE_PERSON = 1;

    public static final int EVENT_GET_SUBDISTRICT = 2;//获取小区

    public static final int EVENT_GET_BUILDING = 3;//获取楼栋信息


    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {
                case EVENT_SAVE_PERSON:
                    saveData();
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
            }
        }

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.SAVE_FAMILY:
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case MyTask.GET_SUBDISTRICT:
                    ((FuMemberAddView) mModel).setSubdistricts((List<SpinnerItem>) msg.obj);
                    break;
                case MyTask.GET_BUILDING:
                    ((FuMemberAddView) mModel).setBuildings((List<SpinnerItem>) msg.obj);
                    break;
                case NET_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_SHORT);
                    break;
                case MyTask.FIND_PERSON:
                    setData();
                    break;
                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
                case MyTask.UPDATE_PERSONINFO:
                    ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_SHORT);
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case MyTask.SAVE_PERSON:
//                    savePics(personInfo.getPersonInfoId(), Constant.SERVICE_ITEM_1009, file);
                    ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_LONG);
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
                case MyTask.UP_LOAD_PERSONINFO_FILE:
                    savePersonInfo();
                    break;

            }
        }
    };

    public void setData() {
        ((FuMemberAddView) mModel).setData(personInfo, save_update);
    }

    public void saveData() {

        if (((FuMemberAddView) mModel).saveData(personInfo)) {
            if (save_update)
                if (isCan_pic())
                    savePics(personInfo.getPersonInfoId(), Constant.SERVICE_ITEM_1009, file);
                else
                    savePersonInfo();
            else
                updatePersonInfo();
        }
    }

    public void savePersonInfo() {
        personInfo.setPersonInfoId(null);
        personInfo.setStatusCode("0");

        MyTask lTask = TaskManager.getInstace(getActivity())
                .savePersonInfo(getCallBackInstance(), personInfo, getContext());

        excuteNetTask(lTask, false);

    }

    public void updatePersonInfo() {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .updatePersonInfo(getCallBackInstance(), personInfo, getContext());

        excuteNetTask(lTask, false);

    }


    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

        if (rspObj == null || rspObj.getCode() == null) {
            Message message = Message.obtain(mHandler);
            message.what = NET_ERROR;
            message.obj = "无返回值网络连接失败" + taskId;
            message.sendToTarget();
            return;
        }
        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            switch (taskId) {
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
                case MyTask.SAVE_PERSON:
                    Message messageSavePerson = Message.obtain(mHandler);
                    messageSavePerson.what = taskId;
                    messageSavePerson.obj = personInfo;
                    messageSavePerson.sendToTarget();

                    break;
                case MyTask.UP_LOAD_PERSONINFO_FILE:
                    String result = rspObj.getResult();
                    result.replace("\\", "/");
                    personInfo.setPhotoUrl(result);
                    Message messageUpPersonPic = Message.obtain(mHandler);
                    messageUpPersonPic.what = taskId;
                    messageUpPersonPic.obj = rspObj.getMessage();
                    messageUpPersonPic.sendToTarget();
                    break;
                case MyTask.FIND_PERSON:
                    personInfo = JSONObject.parseObject(rspObj.getResult(), PersonInfo.class);

                    Message messagePerson = Message.obtain(mHandler);
                    messagePerson.what = taskId;
                    messagePerson.sendToTarget();
                    break;
                case MyTask.UPDATE_PERSONINFO:
                    Message messageUpPerson = Message.obtain(mHandler);
                    messageUpPerson.what = taskId;
                    messageUpPerson.obj = rspObj.getMessage();
                    messageUpPerson.sendToTarget();
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
        message.obj = "错误网络连接失败";
        message.sendToTarget();
    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
