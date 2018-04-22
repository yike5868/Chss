package net.greatsoft.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import net.greatsoft.main.control.FragmentParent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/4.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    List<FragmentParent> fragmentList = new ArrayList<FragmentParent>();
    FragmentManager mManager;
    public FragmentAdapter(FragmentManager fm, List<FragmentParent> fragmentList) {
        super(fm);
        mManager = fm;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = fragmentList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("id",""+position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment)super.instantiateItem(container,position);
        mManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
        Fragment fragment = fragmentList.get(position);
        mManager.beginTransaction().hide(fragment).commit();
    }

}