package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.FuUserInfo;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rsp.FamilyInfoRsp;
import net.greatsoft.main.rsp.PersonInfoRsp;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuSearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglin on 2016/11/25.
 */

public class FuSearchFragment extends FragmentParent {

    private int listType;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(FuUiFrameManager.FU_SEARCH,
                getActivity(), new OnEventClick());

        setData();
        return mModel.getFuView();
    }

    public void initData(Bundle bundle) {
//        Bundle lBundle = ((FuContentActivity) getActivity()).getIntentBundle();
        listType = bundle.getInt("listType");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setData() {
        ((FuSearchView) mModel).setData(listType);
    }



    public static final int EVENT_BACK = 12;//返回



    // family/findFamilyList/{pageNo}/{pageSize}，Map<String,Object> param


    public void findFamilyList(int pageNo, int pageSize, Map<String, Object> param) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findFamilyList(getCallBackInstance(), pageNo, pageSize, param, getContext());

        excuteNetTask(lTask, false);
    }

    public void findPersonInfoList(int pageNo, int pageSize, Map<String, Object> param) {

        MyTask lTask = TaskManager.getInstace(getActivity())
                .findAllPersonInfo(getCallBackInstance(), pageNo, pageSize, param, getContext());

        excuteNetTask(lTask, false);
    }


    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {
            switch (event) {

                case FuListFragment.EVENT_CHILD_HEALTH_EXAM_02:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_02, (Bundle) object);
                    break;
                case FuListFragment.EVENT_CHILD_HEALTH_EXAM_03:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_03, (Bundle) object);
                    break;
                case FuListFragment.EVENT_CHILD_HEALTH_EXAM_04:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HEALTH_EXAM_04, (Bundle) object);
                    break;
                case FuListFragment.EVNET_CHILD_HOME_VISIT:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_CHILD_HOME_VISIT, (Bundle) object);
                    break;
                case FuListFragment.EVENT_HYPER:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_HYPER, (Bundle) object);
                    break;
                case FuListFragment.EVENT_DIABETES:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_DIABETES, (Bundle) object);
                    break;
                case FuListFragment.EVENT_EXAM:
                    ArrayList cls_exam = new ArrayList();
                    cls_exam.add(FuExam01Fragment.class);
                    cls_exam.add(FuExam02Fragment.class);
                    cls_exam.add(FuExam03Fragment.class);
                    cls_exam.add(FuExam04Fragment.class);
                    String[] titles_exam = new String[]{"第一页", "第二页", "第三页", "第四页"};
                    Bundle bundle_exam = (Bundle) object;
                    bundle_exam.putSerializable("classes", cls_exam);
                    bundle_exam.putStringArray("titles", titles_exam);
                    bundle_exam.putString("title", "体检");
                    bundle_exam.putInt("type", FuUiFrameManager.FU_S_EXAM);
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CHANGE_ID, 0, bundle_exam);
                    break;
                case FuListFragment.EVENT_SMI:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SMI, (Bundle) object);
                    break;
                case FuListFragment.EVENT_SELFCARE:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_SELFCARE, (Bundle) object);
                    break;
                case FuListFragment.EVENT_COGNITION:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_COGNITION, (Bundle) object);
                    break;
                case FuListFragment.EVENT_DEPRESSED:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_DEPRESSED, (Bundle) object);
                    break;
                case FuListFragment.EVENT_FAMILY:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_FAMILY_MEMBER, (Bundle) object);
                    break;
                case FuListFragment.EVENT_FAMILY_ADD:
                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_FAMILY_ADD, (Bundle) object);

                    break;
                case FuListFragment.EVENT_PERSON_ADD:

                    ((FuContentActivity) getActivity()).replaceFragment(
                            FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBER_ADD, (Bundle) object);


                    break;

                case FuListFragment.EVENT_GET_DATA:
                    Bundle bundle = (Bundle) object;
                    HashMap<String, Object> map = (HashMap<String, Object>) bundle.getSerializable("param");
                    FuApp app = (FuApp) getActivity().getApplication();
                    FuUserInfo userInfo = app.getFuUserInfo();
//                    map.put("districtId",userInfo.getDistrictId());
//                    map.put("districtLevel",userInfo.getDistrictLevel());
                    switch (listType) {

                        case FuListFragment.EVENT_FAMILY:
                            findFamilyList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                            break;
                        case FuListFragment.EVENT_SMI:
                        case FuListFragment.EVENT_DIABETES:
                        case FuListFragment.EVENT_HYPER:
                        case FuListFragment.EVENT_COGNITION:
                        case FuListFragment.EVENT_PERSON:
                        case FuListFragment.EVENT_CHILD:
                        case FuListFragment.EVENT_MATERNAL:
                            findPersonInfoList(bundle.getInt("pageNo"), bundle.getInt("pageSize"), map);
                            break;
                    }

                    break;

                case EVENT_BACK:
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
            }
        }
    }

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            ToolUtil.hidePopLoading();
            switch (msg.what) {
                case MyTask.FIND_FAMILY_LIST:
                    FamilyInfoRsp familyInfoRsp = (FamilyInfoRsp) msg.obj;
                    ((FuSearchView) mModel).setFamilyInfoList(familyInfoRsp.getRows());
                    break;
                case MyTask.FIND_PERSON_LIST:

                    if(msg == null){
                        ToastUtil.showToast(getContext(),"无返回数据！", Toast.LENGTH_LONG);
                        return;
                    }

                    PersonInfoRsp personInfoRsp = (PersonInfoRsp) msg.obj;
                    if(personInfoRsp == null ||personInfoRsp.getRows() == null){
                        ToastUtil.showToast(getContext(),"查询不到此人！", Toast.LENGTH_LONG);
                        return;
                    }
                    ((FuSearchView) mModel).setPersonInfoList(personInfoRsp.getRows());
                    break;
            }
        }
    };

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

        Message message = Message.obtain(mHandler);
        message.what = taskId;

        switch (taskId) {
            case MyTask.FIND_FAMILY_LIST:
                FamilyInfoRsp familyInfoRsp = JSONArray.parseObject(rspObj.getResult(), FamilyInfoRsp.class);
                message.obj = familyInfoRsp;
                break;
            case MyTask.FIND_PERSON_LIST:
                PersonInfoRsp personInfoRsp = JSONArray.parseObject(rspObj.getResult(), PersonInfoRsp.class);
                message.obj = personInfoRsp;
                break;
        }

        message.sendToTarget();
    }

    @Override
    protected void netErrorChild(int taskId, String msg) {
        Log.e("fulistFragment", "netErrorChild");
    }

    @Override
    protected void cancelChild(int taskId) {
        Log.e("fulistFragment", "cancelChild");
    }


}
