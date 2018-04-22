package net.greatsoft.main.uiframe;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FragmentAdapter;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuChangeFragment;
import net.greatsoft.main.fragment.FuPatientInfoFragment;
import net.greatsoft.main.view.CircleButton;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuTextView;


/**
 * Created by zhanglin on 16/8/3.
 */
public class FuChangeView extends FuUiFrameModel implements View.OnClickListener,CompoundButton.OnCheckedChangeListener {

    ViewPager view_pager;
    FragmentPagerAdapter mFragmentPagerAdapter;
    TextView jkx_title_center;
    RadioGroup rg_switch;
    Button fu_title_right_btn;//保存按钮
    public FuChangeView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_change_view, null);
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        jkx_title_center= (TextView) mFuView
                .findViewById(R.id.fu_title_center);

        view_pager = (ViewPager) mFuView.findViewById(R.id.view_pager);
        rg_switch = (RadioGroup) mFuView.findViewById(R.id.rg_switch);

        fu_title_right_btn = (Button)mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setOnClickListener(this);
    }


    public void setData(FragmentPagerAdapter fragmentPagerAdapter, String[] titles,String title) {

        jkx_title_center.setText(title);

        mFragmentPagerAdapter = fragmentPagerAdapter;
        view_pager.setAdapter(mFragmentPagerAdapter);


        final RadioButton[] rb_list = new RadioButton[titles.length];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        for (int i = 0; i < titles.length; i++) {
            RadioButton rb = (RadioButton) inflater.inflate(R.layout.fu_change_title_radiobutton, null);
            rb_list[i] = rb;
            rb.setText(titles[i]);
            rb.setButtonDrawable(null);
            rb.setTag(i);
            rb.setOnCheckedChangeListener(this);
            RadioGroup.LayoutParams txtOneparams = new RadioGroup.LayoutParams(20, 60, 1.0f);
            rb.setLayoutParams(txtOneparams);
            if (i == 0) {
                rb.setChecked(true);
            }
            rg_switch.addView(rb);
        }


        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }

            /**
             * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
             * offsetPixels:当前页面偏移的像素位置
             */
            @Override
            public void onPageScrolled(int position, float offset,
                                       int offsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < rb_list.length; i++) {
                    rb_list[i].setChecked(false);
                }
                rb_list[position].setChecked(true);
            }
        });


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            int i = Integer.parseInt(buttonView.getTag().toString());
            view_pager.setCurrentItem(i);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChangeFragment.EVENT_SAVE_EXAM, null);
                break;
        }
    }


}
