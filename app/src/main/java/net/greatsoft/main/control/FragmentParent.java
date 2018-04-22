package net.greatsoft.main.control;

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
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.EventAction;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuChangeActivity;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.po.AndroidFileRecord;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.NetCallBack;
import net.greatsoft.main.net.NetManager;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuUiFrameModel;

import java.io.File;
import java.util.UUID;

public abstract class FragmentParent extends Fragment {

    protected FuUiFrameModel mModel;

    protected String PAGE_SIZE = "10"; // 加载条数
    /**
     * 体检相关
     */
    protected HealthExam healthExam;    //体检信息


    public static final int TAKE_CAM = 999;//拍照
    public static final int ACTION_GET_CONTENT = 998;//剪切
    public File fileTemp;//拍照临时
    public File cutTemp;//剪切临时
    public Uri u;
//    String fuId;
//    String fuType;

    File file;

    /**
     * 高血压相关
     */
    protected HyperFollowup hyperFollowup;    //高血压随访信息
    protected HyperFollowup oHyperFollowup;   //上次高血压随访信息
    /**
     * 糖尿病相关
     */
    protected DiabetesFollowup diabetesFollowup;//糖尿病随访
    protected DiabetesFollowup oDiabetesFollowup;//上次糖尿病随访

    /**
     * 新增个人相关
     */
    protected PersonInfo personInfo;

    protected String personInfoId;


    /**
     * 数据库
     */
    protected ALocalSqlHelper sqlHelper;

    /**
     * 家庭相关
     */

    protected FamilyInfo familyInfo;
    protected RoomAll roomAll;  //入户随访 新增家庭 房间信息

    protected int type;//分类
    Activity activity;//主页面


//	FragmentParent(){
////
//		sqlHelper = (FuApp)(getActivity().getApplication()).sql
//	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqlHelper = ((FuApp) getActivity().getApplication()).getSqlHelper();
        activity = getActivity();
        if (activity instanceof FuChangeActivity) {
            type = ((FuChangeActivity) activity).getType();
            getData();
        }

    }

    public void getData() {
        switch (type) {
            //体检
            case FuUiFrameManager.FU_S_EXAM:
                //体检相关
                healthExam = ((FuChangeActivity) activity).getHealthExam();
                personInfo = ((FuChangeActivity) activity).getPersonInfo();
                break;
            //高血压 糖尿病 随访
//            case FuUiFrameManager.FU_S_LGT:
//                hyperFollowup = ((FuChangeActivity) activity).getHyperFollowup();
//                oHyperFollowup = ((FuChangeActivity) activity).getoHyperFollowup();
//                diabetesFollowup = ((FuChangeActivity) activity).getDiabetesFollowup();
//                oDiabetesFollowup = ((FuChangeActivity) activity).getoDiabetesFollowup();
//                break;
//            //增加家庭
//            case FuUiFrameManager.FU_FAMILY_ADD:
//                familyInfo = ((FuChangeActivity) activity).getFamilyInfo();
//                roomAll = ((FuChangeActivity) activity).getRoomAll();
//                break;
//            //增加人员
//            case FuUiFrameManager.FU_MEMBER_ADD:
//
//                personInfo = ((FuChangeActivity)activity).getPersonInfo();
//                personInfoId = ((FuChangeActivity)activity).getPersonInfoId();
//
//                break;
        }
    }

    public ALocalSqlHelper getSqlHelper() {
        if (sqlHelper == null)
            sqlHelper = ((FuApp) getActivity().getApplication()).getSqlHelper();
//			sqlHelper = new ALocalSqlHelper(getContext());
        return sqlHelper;
    }

    protected abstract void loadDataChild(int taskId, FuResponse rspObj); //

    protected abstract void netErrorChild(int taskId, String msg); //

    protected abstract void cancelChild(int taskId); //

    protected mNetCallBack mNetBaseCallBack;

    public final int NET_ERROR = 500; // 网络错误

    public mNetCallBack getCallBackInstance() {

        if (mNetBaseCallBack == null) {
            mNetBaseCallBack = new mNetCallBack();
        }

        return mNetBaseCallBack;
    }


    @Override
    public void onPause() {
        super.onPause();


        EventAction.CURRENT_FRAGMENT_INDEX--;


    }

    @Override
    public void onResume() {
        super.onResume();


        EventAction.CURRENT_FRAGMENT_INDEX++;
    }

    class mNetCallBack implements NetCallBack {

        @Override
        public void cancel(int taskId) {
            Log.e("mNet", mModel.getClass().getName());
            if (taskId == MyTask.UP_LOAD_FILE) {
                ToolUtil.hidePopLoading();
                ToastUtil.showToast(getContext(), "已取消!", Toast.LENGTH_LONG);
//                ((FuContentActivity) getActivity()).goToPrePage();
                return;
            }
            cancelChild(taskId);
        }

        @Override
        public void loadData(int taskId, FuResponse rspObj) {

            if (taskId == MyTask.UP_LOAD_FILE) {
                Message error = Message.obtain(parentHandler);
                error.what = MyTask.UP_LOAD_FILE;
                error.obj = rspObj.getMessage();
                error.sendToTarget();
                return;
            }

            Log.e("mNet", mModel.getClass().getName());
            loadDataChild(taskId, rspObj);
        }

        @Override
        public void netError(int taskId, String msg) {
            Log.e("mNet", mModel.getClass().getName());

            if (taskId == MyTask.UP_LOAD_FILE) {
                ToastUtil.showToast(getContext(), "保存失败!" + msg, Toast.LENGTH_LONG);
//                ((FuContentActivity) getActivity()).goToPrePage();
                return;
            }

            netErrorChild(taskId, msg);
        }
    }

    private Handler parentHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {

                case MyTask.ERROR:
                    ToastUtil.showToast(getContext(), msg.obj.toString(), Toast.LENGTH_LONG);
                    break;

                case MyTask.UP_LOAD_FILE:

                    File dir = new File(Constant.PIC_DIR);
                    File[] pics = dir.listFiles();
                    for (int i = 0; i < pics.length; i++) {
                        pics[i].delete();
                    }

                    ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_LONG);
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;

            }
        }
    };


    public void excuteNetTask(final MyTask lTask, boolean animRefresh) {

        if (!animRefresh) {

            ToolUtil.showPopWindowLoading(getActivity());
        }

        Runnable netRunnable = new Runnable() {

            @Override
            public void run() {

                NetManager manager = NetManager.getInstance(getActivity());
                manager.addNetTask(lTask);
                manager.excuteNetTask(lTask);

            }
        };

        parentHandler.post(netRunnable);

    }

    public void savePics(String fuId, String fuType, File file) {

        if (isCan_pic()) {
            AndroidFileRecord androidFileRecord = new AndroidFileRecord();
            androidFileRecord.setReferenceKey(fuId);
            androidFileRecord.setServiceItemId(fuType);

            File[] files = new File[1];
            files[0] = file;
            if (fuType == Constant.SERVICE_ITEM_1009) {
                MyTask lTask = TaskManager.getInstace(getActivity())
                        .savePersonInfoPics(getCallBackInstance(), androidFileRecord, getContext(), files);
                excuteNetTask(lTask, false);
            } else{
                MyTask lTask = TaskManager.getInstace(getActivity())
                        .savePics(getCallBackInstance(), androidFileRecord, getContext(), files);
                excuteNetTask(lTask, false);
            }

        } else {
            ToastUtil.showToast(getContext(), "保存成功!", Toast.LENGTH_LONG);
            ((FuContentActivity) getActivity()).goToPrePage();
        }
    }

    public void cutP() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        //可以选择图片类型，如果是*表明所有类型的图片
        intent.setDataAndType(u, "image/*");
        intent.putExtra("scale", true);
        File dir = new File(Constant.PIC_DIR);
        String pic_name = UUID.randomUUID().toString();
        intent.putExtra("return-data", true);
        pic_name += ".png";
        cutTemp = new File(dir, pic_name);
        Uri u1 = Uri.fromFile(cutTemp);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, u1);
        startActivityForResult(intent, ACTION_GET_CONTENT);
    }

    /**
     * 拍照
     */
    public void takePic() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
                File dir = new File(Constant.PIC_DIR);
                if (!dir.exists()) dir.mkdirs();
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                String pic_name = UUID.randomUUID().toString();
                pic_name += ".png";
                fileTemp = new File(dir, pic_name);
                u = Uri.fromFile(fileTemp);
//                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, TAKE_CAM);
            } catch (ActivityNotFoundException e) {
                ToastUtil.showToast(getContext(), "没有找到储存目录", Toast.LENGTH_LONG);
            }
        } else {
            ToastUtil.showToast(getContext(), "没有储存卡", Toast.LENGTH_LONG);
        }
    }

    /**
     * 是否拍照
     */
    public boolean isCan_pic() {
        SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        int dd = spf.getInt("isTakePhoto", 0);
        if (0 == dd) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否蓝牙
     */
    public boolean isBlueTooth() {
        SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        int dd = spf.getInt("isBluetooth", 0);
        if (0 == dd) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否裁剪
     *
     * @return
     */
    public boolean isTailor() {
        SharedPreferences spf = getContext().getSharedPreferences("AccessToken", Context.MODE_PRIVATE);
        int dd = spf.getInt("isTailor", 0);
        if (0 == dd) {
            return false;
        } else {
            return true;
        }
    }
}
