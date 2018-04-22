package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.person.Person;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/10.
 */

public class FuGPFollowView extends FuUiFrameModel {

    FuEditText et_search;
    FuButton btn_search;
    ListView lv_person;
    List<Person> personList;
    public FuGPFollowView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_gp_follow_view, null);
    }

    @Override
    protected void initFuData() {
        Person person = new Person();
        person.setName("wang");
        personList = new ArrayList<>();
        personList.add(person);
    }

    @Override
    protected void initWidget() {
        FuTextView fu_title_center =  (FuTextView)mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("随访");
        et_search = (FuEditText)mFuView.findViewById(R.id.et_search);
        btn_search = (FuButton) mFuView.findViewById(R.id.btn_search);
        lv_person = (ListView)mFuView.findViewById(R.id.lv_person);

        MemberAdapter memberAdapter = new MemberAdapter(mContext);
        lv_person.setAdapter(memberAdapter);
    }


    class MemberAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MemberAdapter(Context context) {

            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return personList == null? 0:personList.size();
        }

        @Override
        public Object getItem(int position) {
            return personList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.fu_family_member_item, null);
            FrameLayout fl_main = (FrameLayout)convertView.findViewById(R.id.fl_main);
            fl_main.setVisibility(View.GONE);
            return convertView;
        }
    }
}
