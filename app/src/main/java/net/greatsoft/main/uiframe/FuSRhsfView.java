package net.greatsoft.main.uiframe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.db.po.districts.Room;
import net.greatsoft.main.db.po.districts.RoomAll;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.fragment.FuSRhsfFragment;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.SelectDistrictsInterface;
import net.greatsoft.main.view.SelectDistrictsView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuSRhsfView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {


    List<Room> list_room;
    Button btn_sf;
    GridView gv_room;
    SelectDistrictsView sd; //地区
    RoomAdapter roomAdapter;

    RoomAll mRoomAll;//完整地址

    HashMap<String,FamilyInfo> familyInfoHashMap;//家庭列表

    public FuSRhsfView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_s_rhsf_view, null);

    }

    @Override
    protected void initFuData() {
        familyInfoHashMap = new HashMap<>();
        setRoomAll();
    }


    public void setError() {
    }

    @Override
    protected void initWidget() {


        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText(mContext.getResources().getText(R.string.main_rhsf));

        btn_sf = (Button) mFuView.findViewById(R.id.btn_sf);
        btn_sf.setOnClickListener(this);

        sd = (SelectDistrictsView) mFuView.findViewById(R.id.sd);
        sd.setSelectDistrictsInterface(new getSD());

        gv_room = (GridView) mFuView.findViewById(R.id.gv_room);
        roomAdapter = new RoomAdapter(mContext);
        gv_room.setAdapter(roomAdapter);
        initDistricts();
        gv_room.setOnItemLongClickListener(this);
        gv_room.setOnItemClickListener(this);


    }

    private void initDistricts() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sf:
                mEventCallBack.EventClick(FuSRhsfFragment.EVENT_PATIENTINFO, null);
                break;
            case R.id.btn_create:
                int position = Integer.parseInt(v.getTag().toString());
                mRoomAll.setRoomNum(list_room.get(position).getRoomNumberId());
                mEventCallBack.EventClick(FuSRhsfFragment.EVENT_FAMILY_ADD, mRoomAll);
                break;


        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        LinearLayout ll_zt = (LinearLayout) view.findViewById(R.id.ll_zt);
        ll_zt.setVisibility(View.VISIBLE);

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mEventCallBack.EventClick(FuSRhsfFragment.EVENT_FAMILY_MEMBER, view.findViewById(R.id.tv_name).getTag());
    }

    class RoomAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public RoomAdapter(Context context) {

            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list_room == null ? 0 : list_room.size();
        }

        @Override
        public Object getItem(int position) {
            return list_room.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint({"InflateParams", "NewApi"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Items items;
            if (convertView == null) {
                items = new Items();
                convertView = inflater.inflate(R.layout.xj_build_item, null);
                items.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                items.tv_count = (FuTextView) convertView.findViewById(R.id.tv_count);
                items.tv_time = (FuTextView) convertView.findViewById(R.id.tv_time);
                items.tv_roomnum = (FuTextView) convertView.findViewById(R.id.tv_roomnum);
                items.tv_householder = (FuTextView) convertView.findViewById(R.id.tv_householder);
                items.ll_hyper_main = (LinearLayout)convertView.findViewById(R.id.ll_hyper_main);

                items.ll_hyper = (LinearLayout)convertView.findViewById(R.id.ll_hyper);
                items.ll_diabetes_main = (LinearLayout)convertView.findViewById(R.id.ll_diabetes_main);
                items.ll_diabetes = (LinearLayout)convertView.findViewById(R.id.ll_diabetes);
                items.ll_pregnant_main = (LinearLayout)convertView.findViewById(R.id.ll_pregnant_main);
                items.ll_pregnant = (LinearLayout)convertView.findViewById(R.id.ll_pregnant);
                items.ll_child_main = (LinearLayout)convertView.findViewById(R.id.ll_child_main);
                items.ll_child = (LinearLayout)convertView.findViewById(R.id.ll_child);
                items.iv_family_type = (ImageView) convertView.findViewById(R.id.iv_family_type);
                items.tv_zt = (FuTextView)convertView.findViewById(R.id.tv_zt);
                items.btn_refused = (FuButton)convertView.findViewById(R.id.btn_refused);
                items.btn_no = (FuButton)convertView.findViewById(R.id.btn_no);
                items.btn_create = (FuButton)convertView.findViewById(R.id.btn_create);
                items.ll_zt = (LinearLayout)convertView.findViewById(R.id.ll_zt);
                items.ll_noFamily = (LinearLayout)convertView.findViewById(R.id.ll_noFamily);
                items.ll_main = (LinearLayout)convertView.findViewById(R.id.ll_main);
                convertView.setTag(items);
            }else{
                items =(Items)convertView.getTag();
            }

            items.tv_roomnum.setText(list_room.get(position).getRoomNumberNo());
            FamilyInfo familyInfo = familyInfoHashMap.get(list_room.get(position).getRoomNumberNo());
            if(familyInfo ==null){
                items.ll_noFamily.setVisibility(View.VISIBLE);
                items.ll_zt.setVisibility(View.GONE);
                items.ll_main.setVisibility(View.GONE);
                items.btn_create.setOnClickListener(FuSRhsfView.this);
            }else{
                items.ll_noFamily.setVisibility(View.GONE);
                items.ll_zt.setVisibility(View.GONE);
                items.ll_main.setVisibility(View.VISIBLE);
//                convertView.setTag(FuUiFrameManager.FU_FAMILY_MEMBER,familyInfo.getFamilyInfoId());
                items.tv_name.setText(familyInfo.getHouseholder());
                items.tv_name.setTag(familyInfo.getFamilyInfoId());

            }
            items.btn_create.setTag(position);

            return convertView;
        }

        class Items {
            FuTextView tv_name;//姓名
            FuTextView tv_count;//人数
            FuTextView tv_time;//上次随访时间
            FuTextView tv_roomnum;//房间号
            FuTextView tv_householder;// 业主， 长住  短住
            LinearLayout ll_hyper_main;//高
            LinearLayout ll_hyper;//高 类型
            LinearLayout ll_diabetes_main;//糖
            LinearLayout ll_diabetes;//糖 类型
            LinearLayout ll_pregnant_main;//孕
            LinearLayout ll_pregnant;//孕 类型
            LinearLayout ll_child_main;//儿童
            LinearLayout ll_child; //儿童 类型
            ImageView iv_family_type;//家庭类型
            FuTextView tv_zt;//未随访  已随访 部分随访
            FuButton btn_refused;//拒绝
            FuButton btn_no;//无应答
            FuButton btn_create;//建档
            LinearLayout ll_main;//主要信息
            LinearLayout ll_zt;//无应答 拒绝
            LinearLayout ll_noFamily;//无家庭显示

        }
    }

    public void setDataChange(){
        if(mRoomAll.getDistrictId()==null){
            return;
        }
        Log.e("aaaaaa","setdataChange");
        list_room = sqlHelper.getRoomList(mRoomAll.getBuildingId(),mRoomAll.getUnitNo());


        List<FamilyInfo> familyInfoList = sqlHelper.getFamilyInfoByUnit(mRoomAll.getBuildingId(),mRoomAll.getUnitNo());
        familyInfoHashMap.clear();
        for (int i = 0;i<familyInfoList.size();i++){
            familyInfoHashMap.put(familyInfoList.get(i).getRoomNumber(),familyInfoList.get(i));
        }

        roomAdapter.notifyDataSetChanged();
    }

    public void setRoomAll(){
        mRoomAll = (RoomAll) DataSaveManager.getInstance(mContext).getSaveData(SaveTask.KEY_DISTRICTS);
        if (mRoomAll.getDistrictId() == null)
            return;
        setDataChange();
    }

    class getSD implements SelectDistrictsInterface {

        @Override
        public void EventUnit(RoomAll roomAll) {
            mRoomAll = roomAll;

            FuSRhsfView.this.setDataChange();

        }
    }


}
