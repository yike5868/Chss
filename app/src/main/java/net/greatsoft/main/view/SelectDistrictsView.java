package net.greatsoft.main.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.R;
import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.tool.ToastUtil;

import java.util.List;

/**
 * Created by zhanglin on 2016/11/1.
 */

public class SelectDistrictsView extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    List<SpinnerItem> districtsListMain;  //地区
    List<SpinnerItem> subdistrictsList; // 小区
    List<SpinnerItem> buildingsListSec;  //楼

    List<SpinnerItem> unitList;//单元

    RoomAll roomAll;//完整地址


    MainAdapter mainAdapter;
    SecAdapter secAdapter;
    BuildingAdapter buildingAdapter;
    UnitAdapter unitAdapter;

    Button btn_1;
    Button btn_2;
    Button btn_3;

    SelectDistrictsInterface selectDistrictsInterface;

    private PopupWindow popupwindow_main;
    private PopupWindow popupwindow_sec;
    private PopupWindow popupWindow_third;
    protected ALocalSqlHelper sqlHelper;

    private Context mContext;
    private View mView;

    String buildingName;//选择的楼栋

    public SelectDistrictsView(Context context) {

        super(context);
        mContext = context;
        initView();
    }

    public SelectDistrictsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public SelectDistrictsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }


    public void initView() {
//        View lViewMain = LayoutInflater.from(mContext).inflate(
//                R.layout.view_select_districts_main, null);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sqlHelper = ((FuApp) mContext.getApplicationContext()).getSqlHelper();

        mView = inflater.inflate(R.layout.view_select_districts, this);
        btn_1 = (FuButton) mView.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = (FuButton) mView.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = (FuButton) mView.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);

        initData();
    }

    public void initData() {

        roomAll = (RoomAll) DataSaveManager.getInstance(mContext).getSaveData(SaveTask.KEY_DISTRICTS);
        initMainData();
        if (roomAll.getDistrictId() == null) {
            return;
        } else {
            btn_1.setText(roomAll.getDistrictName());
            btn_2.setText(roomAll.getSubDistrictName());
            btn_3.setText(roomAll.getBuildingName() + roomAll.getUnitNo());
            initSecData(roomAll.getDistrictId());
            initThirdData(roomAll.getSubDistrictId());
            initUnitData(roomAll.getBuildingId());

            initSec();
            initThird();
        }
    }

    //加载第一级菜单data
    public void initMainData() {
        districtsListMain = sqlHelper.getDistricts();
    }

    //加载第二级菜单data
    private void initSecData(String districtId) {

        subdistrictsList = sqlHelper.getSubdistricts(districtId);
    }

    //加载第三级菜单data
    private void initThirdData(String buildingId) {
        buildingsListSec = sqlHelper.getBuildings(buildingId);

        if (buildingsListSec.size() > 0) {
            roomAll.setBuildingId(buildingsListSec.get(0).getId());
            initUnitData(buildingsListSec.get(0).getId());
            buildingName = buildingsListSec.get(0).getValue();
        }

    }

    private void initUnitData(String buildingId) {
        unitList = sqlHelper.getUnit(buildingId);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                if (popupwindow_main != null && popupwindow_main.isShowing()) {
                    popupwindow_main.dismiss();
                    return;
                } else {
                    initMain();
                    popupwindow_main.showAsDropDown(v);
                }
                break;
            case R.id.btn_2:

                if (popupwindow_main != null && popupwindow_main.isShowing()) {
                    popupwindow_main.dismiss();
                }

                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                }

                if (popupwindow_sec != null && popupwindow_sec.isShowing()) {
                    popupwindow_sec.dismiss();
                } else {
                    if (popupwindow_sec == null) {
                        ToastUtil.showToast(mContext, "请选择地区", Toast.LENGTH_LONG);
                    } else {
                        initSec();
                        popupwindow_sec.showAsDropDown(btn_2);
                    }
                }

                break;
            case R.id.btn_3:

                if (popupwindow_sec != null && popupwindow_sec.isShowing()) {
                    popupwindow_sec.dismiss();
                }
                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                }
                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                } else {
                    if (popupWindow_third == null) {
                        ToastUtil.showToast(mContext, "请选择小区", Toast.LENGTH_LONG);
                    } else {
                        popupWindow_third.showAsDropDown(btn_3);
                    }
                }
                break;
        }
    }

    //加载一级菜单
    private void initMain() {
        View customView = LayoutInflater.from(mContext).inflate(
                R.layout.view_select_districts_main, null);

        ListView lv_main = (ListView) customView.findViewById(R.id.lv_main);
        mainAdapter = new MainAdapter(mContext);
        lv_main.setAdapter(mainAdapter);
        lv_main.setOnItemClickListener(this);

        // 创建PopupWindow实例,200,150分别是宽度和高度
        popupwindow_main = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]
//        popupwindow_main.setAnimationStyle(R.style.AnimationFade);
        popupwindow_main.setFocusable(true);
        // 自定义view添加触摸事件
        customView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupwindow_main != null && popupwindow_main.isShowing()) {
                    popupwindow_main.dismiss();
                    popupwindow_main = null;
                }
                return false;
            }
        });
    }

    //加载二级菜单
    private void initSec() {
        View customView = LayoutInflater.from(mContext).inflate(
                R.layout.view_select_districts_sec, null);

        ListView lv_main = (ListView) customView.findViewById(R.id.lv_xq);
        secAdapter = new SecAdapter(mContext);
        lv_main.setAdapter(secAdapter);
        lv_main.setOnItemClickListener(this);

        // 创建PopupWindow实例,200,150分别是宽度和高度
        popupwindow_sec = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]
//        popupwindow_sec.setAnimationStyle(R.style.AnimationFade);
        popupwindow_sec.setFocusable(true);
        // 自定义view添加触摸事件
        customView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupwindow_sec != null && popupwindow_sec.isShowing()) {
                    popupwindow_sec.dismiss();
                    popupwindow_sec = null;
                }
                return false;
            }
        });
    }

    //加载三级菜单
    private void initThird() {
        View customView = LayoutInflater.from(mContext).inflate(
                R.layout.view_select_districts_third, null);

        GridView gv_building = (GridView) customView.findViewById(R.id.gv_building);
        buildingAdapter = new BuildingAdapter(mContext);
        gv_building.setAdapter(buildingAdapter);
        gv_building.setOnItemClickListener(this);


        GridView gv_unit = (GridView) customView.findViewById(R.id.gv_unit);
        unitAdapter = new UnitAdapter(mContext);
        gv_unit.setAdapter(unitAdapter);

        gv_unit.setOnItemClickListener(this);

        // 创建PopupWindow实例,200,150分别是宽度和高度
        popupWindow_third = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]
//        popupwindow_sec.setAnimationStyle(R.style.AnimationFade);
        popupWindow_third.setFocusable(true);
        // 自定义view添加触摸事件
        customView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                    popupWindow_third = null;
                }
                return false;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv_main:
                initSec();
                btn_1.setText(districtsListMain.get(position).getValue());
                popupwindow_main.dismiss();

                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                }

                if (popupwindow_sec != null && popupwindow_sec.isShowing()) {
                    popupwindow_sec.dismiss();
                    return;
                } else {
                    roomAll.setDistrictId(districtsListMain.get(position).getId());
                    roomAll.setDistrictName(districtsListMain.get(position).getValue());
                    initSecData(districtsListMain.get(position).getId());
                    popupwindow_sec.showAsDropDown(btn_2);
                }
                break;


            case R.id.lv_xq:
                initThird();
                btn_2.setText(subdistrictsList.get(position).getValue());
                popupwindow_sec.dismiss();
                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                }
                if (popupWindow_third != null && popupWindow_third.isShowing()) {
                    popupWindow_third.dismiss();
                    return;
                } else {
                    roomAll.setSubDistrictId(subdistrictsList.get(position).getId());
                    roomAll.setSubDistrictName(subdistrictsList.get(position).getValue());
                    initThirdData(subdistrictsList.get(position).getId());
                    popupWindow_third.showAsDropDown(btn_2);
                }

                break;

            case R.id.gv_building:
                buildingName = buildingsListSec.get(position).getValue();
                roomAll.setBuildingId(buildingsListSec.get(position).getId());

                initUnitData(buildingsListSec.get(position).getId());
                unitAdapter.notifyDataSetChanged();
                break;

            case R.id.gv_unit:
                btn_3.setText(buildingName + unitList.get(position).getValue());
                roomAll.setBuildingName(buildingName);
                popupWindow_third.dismiss();
                if (selectDistrictsInterface != null) {

                    roomAll.setUnitNo(unitList.get(position).getValue());
                    selectDistrictsInterface.EventUnit(roomAll);
                }

                SaveTask saveTask = new SaveTask();
                saveTask.setmTaskKey(SaveTask.KEY_DISTRICTS);
                saveTask.setmData(roomAll);
                DataSaveManager.getInstance(mContext).addSaveTask(saveTask);
                break;
        }
    }

    public void setSelectDistrictsInterface(SelectDistrictsInterface selectDistrictsInterface) {
        this.selectDistrictsInterface = selectDistrictsInterface;
    }

    class MainAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MainAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return districtsListMain == null ? 0 : districtsListMain.size();
        }

        @Override
        public Object getItem(int position) {
            return districtsListMain.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.view_select_districts_main_item, parent, false);
            }

            TextView tv_districts_main = (TextView) convertView.findViewById(R.id.tv_districts_main);
            tv_districts_main.setText(districtsListMain.get(position).getValue());

            return convertView;
        }
    }

    class SecAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public SecAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return subdistrictsList == null ? 0 : subdistrictsList.size();
        }

        @Override
        public Object getItem(int position) {
            return subdistrictsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.view_select_districts_main_item, parent, false);
            }

            TextView tv_districts_main = (TextView) convertView.findViewById(R.id.tv_districts_main);
            tv_districts_main.setText(subdistrictsList.get(position).getValue());

            return convertView;
        }
    }

    class BuildingAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public BuildingAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return buildingsListSec == null ? 0 : buildingsListSec.size();
        }

        @Override
        public Object getItem(int position) {
            return buildingsListSec.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.view_select_districts_third_item, parent, false);
            }

            FuTextView tv_building = (FuTextView) convertView.findViewById(R.id.tv_building);
            tv_building.setText(buildingsListSec.get(position).getValue());

            return convertView;
        }
    }

    class UnitAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public UnitAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return unitList == null ? 0 : unitList.size();
        }

        @Override
        public Object getItem(int position) {
            return unitList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.view_select_districts_third_item, parent, false);
            }

            FuTextView tv_building = (FuTextView) convertView.findViewById(R.id.tv_building);
            tv_building.setText(unitList.get(position).getValue());

            return convertView;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (popupwindow_main != null && popupwindow_main.isShowing())
                popupwindow_main.dismiss();

            if (popupwindow_sec != null && popupwindow_sec.isShowing())
                popupwindow_sec.dismiss();

            if (popupWindow_third != null && popupWindow_third.isShowing())
                popupWindow_third.dismiss();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
