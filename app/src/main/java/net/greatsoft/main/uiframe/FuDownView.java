package net.greatsoft.main.uiframe;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.fragment.FuDownFragment;
import net.greatsoft.main.view.tree.Node;
import net.greatsoft.main.view.tree.SimpleTreeAdapter;
import net.greatsoft.main.view.tree.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuDownView extends FuUiFrameModel implements View.OnClickListener {
    ListView lv_tree;
    List<Districts> districtsList;
    public FuDownView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_down_view, null);
    }

    @Override
    protected void initFuData() {

        districtsList = sqlHelper.getDistrictsAll();
        SimpleTreeAdapter simpleTreeAdapter = null;
        try {
            simpleTreeAdapter = new SimpleTreeAdapter<Districts>(lv_tree, mContext, districtsList, 1);
            simpleTreeAdapter.setOnTreeNodeClickListener(onTreeNodeClickListener);

        } catch (Exception e) {
            e.printStackTrace();
        }
        lv_tree.setAdapter(simpleTreeAdapter);
    }
    /**
     * 多级菜单的点击事件监听
     */
    TreeListViewAdapter.OnTreeNodeClickListener onTreeNodeClickListener = new TreeListViewAdapter.OnTreeNodeClickListener() {
        @Override
        public void onClick(Node node, int position) {
            if (node.isLeaf()) {

            }
        }
    };

    public void setError(){
    }
    @Override
    protected void initWidget() {
        lv_tree =(ListView)mFuView.findViewById(R.id.lv_tree);
//        TextView fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
//        fu_title_center.setText("下载");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
