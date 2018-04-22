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

import com.alibaba.fastjson.JSONArray;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.PersonInfoRsp;
import net.greatsoft.main.tool.ImageCondense;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuFamilyMemberView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhanglin on 2016/11/8.
 * 家庭成员列表
 */

public class FuFamilyMemberFragment extends FragmentParent {

    String familyInfoId;

    List<PersonInfo> personInfoList;
    Object object;
    int event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_FAMILY_MEMBER, getActivity(),
                new OnEventClick());
        setData();
        return mModel.getFuView();
    }

    public static final int EVENT_PATIENT_INFO = 1; //进入
    public static final int EVENT_PATIENT_ADD = 2;//新增人员
    public static final int EVENT_PATIENT_INTO = 3;//迁入人员

    public static final int EVENT_PATIENT_DELETE = 4;//删除人员
    public static final int EVENT_PATIENT_EDIT = 5;//编辑人员
    public static final int EVENT_PATIENT_LATTERLY = 6;//迁出人员

    public static final int EVENT_FAMILY_EDIT = 7;//编辑家庭

    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            FuFamilyMemberFragment.this.object = object;
            FuFamilyMemberFragment.this.event = event;
            switch (event) {
                case EVENT_PATIENT_INFO:


//                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_PATIENT_INFO, (Bundle) object);

                    ((FuContentActivity) getActivity()).replaceFragment(FuUiFrameManager.FU_MEMBER_ADD, (Bundle) object);

                    break;
                case EVENT_PATIENT_ADD:
                    if (isCan_pic()) {
                        takePic();
                    } else {
                        Bundle b = new Bundle();
                        b.putString("familyInfoId", familyInfoId);
                        ((FuContentActivity) getActivity()).replaceFragment(
                                FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, b);
                    }
                    break;
                case EVENT_PATIENT_EDIT:

                    Bundle bundle_member = new Bundle();
                    bundle_member.putString("familyInfoId", familyInfoId);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, bundle_member);

                    break;

                case EVENT_FAMILY_EDIT:

                    Bundle bundle = new Bundle();
                    bundle.putString("familyInfoId", familyInfoId);

                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_FAMILY_ADD, bundle);


                    break;
            }

        }

    }

    public void intentData(Bundle bundle) {
        if (bundle == null) {

        } else {
            familyInfoId = bundle.getString("familyInfoId");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        setData();
    }

    public void setData() {

        Map<String, Object> param = new HashMap<>();
        param.put("familyInfoId", familyInfoId);

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findAllPersonInfo(getCallBackInstance(), 1, 10, param, getContext());

        excuteNetTask(lTask, false);

    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.FIND_PERSON_LIST:
                    PersonInfoRsp personInfoRsp = (PersonInfoRsp) msg.obj;
                    ((FuFamilyMemberView) mModel).setData(personInfoRsp.getRows());
                    break;
                case Constant.LOGIN_ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;
            }
        }
    };

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {
        Message message = Message.obtain(mHandler);
        message.what = taskId;

        if (Constant.NET_SUCCESS.equals(rspObj.getCode())) {
            PersonInfoRsp personInfoRsp = JSONArray.parseObject(rspObj.getResult(), PersonInfoRsp.class);
            message.obj = personInfoRsp;
        } else {
            message.what = Constant.LOGIN_ERROR;
            message.obj = rspObj.getMessage();
        }
        message.sendToTarget();
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {

                case TAKE_CAM:

                    if(isTailor())
                        cutP();
                    else goNext();
                    break;
                case ACTION_GET_CONTENT:

                    goNext();
                    break;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

   public void goNext(){
       Bundle b = new Bundle();
       SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
       int fileSize = spf.getInt("fileZipCapicity", 0);
       if (fileSize != 0){
           if(isTailor()){
//                fileTemp.delete();
               ImageCondense.scal(cutTemp.getAbsolutePath(), fileSize);
               b.putSerializable("file", cutTemp);
           }else{
               ImageCondense.scal(fileTemp.getAbsolutePath(), fileSize);
               b.putSerializable("file", fileTemp);
           }
       }
       b.putString("familyInfoId", familyInfoId);
       ((FuContentActivity) getActivity()).replaceFragment(
               FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, b);
   }

}
