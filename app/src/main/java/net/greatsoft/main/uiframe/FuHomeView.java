package net.greatsoft.main.uiframe;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Colors;
import net.greatsoft.main.fragment.FuHomeFragment;
import net.greatsoft.main.fragment.FuListFragment;
import net.greatsoft.main.view.FuImageView;
import net.greatsoft.main.view.FuTextView;

public class FuHomeView extends FuUiFrameModel implements OnClickListener, AdapterView.OnItemClickListener {


    private GridView gv_main;

    //新疆
    private static String[] xj_home_items = new String[]{"入户随访", "列表", "义诊", "家庭", "人员", "失联", "上传", "下载", "帮助", "设置"};
    //济南
    private static String[] jn_home_items = new String[]{"家庭档案", "成员档案", "高血压患者服务", "2型糖尿病患者服务", "老年人健康管理服务", "严重精神障碍患者服务", "0-6岁儿童健康管理服务", "孕产妇服务", "肺结核患者服务", "冠心病患者服务", "脑卒中患者服务","残疾人健康管理服务"};

    private static Integer[] jn_icon_items = new Integer[]{R.mipmap.index_01, R.mipmap.index_02, R.mipmap.index_03, R.mipmap.index_04, R.mipmap.index_05, R.mipmap.index_07, R.mipmap.index_08, R.mipmap.index_09, R.mipmap.index_11, R.mipmap.guanxinbing_06, R.mipmap.naocu_03,R.mipmap.can_03};

    private static Integer[] xj_icon_items = new Integer[]{R.mipmap.index_01, R.mipmap.index_02, R.mipmap.index_03, R.mipmap.index_04, R.mipmap.index_05, R.mipmap.index_07, R.mipmap.index_08, R.mipmap.index_09, R.mipmap.index_11, R.mipmap.index_10};


    private static String[] home_items;//展示的items
    private static Integer[] icon_items;//


    public FuHomeView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);

    }

    private static final int XINJIANG = 1;  //新疆
    private static final int JINAN = 2;     //济南


    private static int LOCALITY = JINAN;


    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_home_view, null);
    }

    @Override
    protected void initFuData() {
        Colors colors = new Colors();
        colors.setColor("#aaaaaa");
        colors.setSatic("1");
        colors.setType("高血压");
        colors.setIsDefault("1");
        sqlHelper.getColorsDao().insertInTx(colors);

    }

    @Override
    protected void initWidget() {
        initTitle();

        if (LOCALITY == XINJIANG) {
            home_items = xj_home_items;
            icon_items = xj_icon_items;
        } else if (LOCALITY == JINAN) {
            home_items = jn_home_items;
            icon_items = jn_icon_items;
        }
        gv_main = (GridView) mFuView.findViewById(R.id.gv_main);
        HomeAdapter ha = new HomeAdapter(mContext);
        gv_main.setAdapter(ha);
        gv_main.setOnItemClickListener(this);
    }

    /**
     * 初始化title
     */
    public void initTitle() {
        TextView jkx_title_center = (TextView) mFuView
                .findViewById(R.id.fu_title_center);
        jkx_title_center.setText(mContext.getResources().getText(R.string.main_title));
        FuImageView fu_iv_title_right_btn4 = (FuImageView) mFuView
                .findViewById(R.id.fu_iv_title_right_btn4);
        fu_iv_title_right_btn4.setVisibility(View.VISIBLE);
        fu_iv_title_right_btn4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_iv_title_right_btn4:
                mEventCallBack.EventClick(FuHomeFragment.EVENT_SYSTEM_SET, null);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        if (LOCALITY == JINAN) {
            switch (position) {
                case 0:
                    bundle.putInt("listType", FuListFragment.EVENT_FAMILY);
                    break;
                case 1:
                    bundle.putInt("listType", FuListFragment.EVENT_PERSON);
                    break;
                case 2:
                    bundle.putInt("listType", FuListFragment.EVENT_HYPER);
                    break;
                case 3:
                    bundle.putInt("listType", FuListFragment.EVENT_DIABETES);
                    break;
                case 4:
                    bundle.putInt("listType", FuListFragment.EVENT_COGNITION);
                    break;
                case 5:
                    bundle.putInt("listType", FuListFragment.EVENT_SMI);
                    break;
                case 6:
                    bundle.putInt("listType", FuListFragment.EVENT_CHILD);
                    break;
                case 7:
                    bundle.putInt("listType", FuListFragment.EVENT_MATERNAL);
                    break;

                case 8:
                    bundle.putInt("listType", FuListFragment.EVENT_TUBERCULOSIS);
                    break;

                case 9:
                    bundle.putInt("listType", FuListFragment.EVENT_CORONARYHEART);
                    break;

                case 10:
                    bundle.putInt("listType", FuListFragment.EVENT_CEREBRALAPOPLEXY);
                    break;

                case 11:
                    bundle.putInt("listType", FuListFragment.EVENT_DISABILITY);
                    break;

                case 12:
                    bundle.putInt("listType", FuListFragment.EVENT_VACCINE);
                    break;
            }
            mEventCallBack.EventClick(
                    FuHomeFragment.EVENT_LIST, bundle);
        } else if (LOCALITY == XINJIANG) {

            switch (position) {
                case 0:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_RHSF, null);
                    break;
                case 1:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_LGT, null);
                    break;
                case 2:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_YZ, null);
                    break;
                case 3:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_FAMILY, null);
                    break;
                case 4:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_MEMBER, null);
                    break;
                case 5:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_SL, null);
                    break;
                case 6:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_UPLOAD, null);
                    break;
                case 7:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_DOWNLOAD, null);
                    break;
                case 8:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_DOWNLOAD, null);
                    break;
                case 9:
                    mEventCallBack.EventClick(
                            FuHomeFragment.EVENT_SET, null);
                    break;


            }
        }
    }

    class HomeAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public HomeAdapter(Context mContext) {
            this.context = mContext;
            inflater = ((Activity) context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return home_items.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_home_jn_item, parent, false);
                holder = new Holder();
                holder.tv_title = (FuTextView) convertView.findViewById(R.id.tv_title);
                holder.iv_main = (FuImageView) convertView.findViewById(R.id.iv_main);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }
            holder.tv_title.setText(home_items[position]);
            holder.iv_main.setImageResource(icon_items[position]);
            return convertView;
        }

        class Holder {
            FuTextView tv_title;
            FuImageView iv_main;
        }
    }
}
