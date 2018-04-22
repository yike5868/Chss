package net.greatsoft.main.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;

import com.umeng.analytics.MobclickAgent;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.FuUserInfo;
import net.greatsoft.main.R;
import net.greatsoft.main.control.fragment.CustomFragmentManager;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.net.NetManager;
import net.greatsoft.main.tool.ToolUtil;

public class FuLoginRegistActivity extends FragmentActivity {
    private CustomFragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fu_public_no_bottom);

        mManager = CustomFragmentManager.getInstance(this);

        mManager.initFragmentManager(CustomFragmentManager.LOGIN_REGIST,
                getSupportFragmentManager());

        mManager.deleteAllFragment(CustomFragmentManager.LOGIN_REGIST);

        mManager.addFragment(R.id.fu_fragment_contain,
                FuUiFrameManager.FU_LOGIN);

        double device = getScreenSizeOfDevice();
        if (device > 6.5) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    }

    public double getScreenSizeOfDevice() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        double x = Math.pow(point.x / dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        return screenInches;
    }

    public void replaceFragment(int FragmentId, Bundle bundle) {

        mManager.replaceFragment(R.id.fu_fragment_contain, FragmentId, bundle);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        if (mExitApp) {

            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }

    }

    /**
     * 去首页
     */
    public void goToMainPage() {

        SharedPreferences lPreferences = getSharedPreferences(
                Constant.LOGIN_CONFIG, MODE_PRIVATE);

        lPreferences.edit().putBoolean(Constant.IS_LOGIN_RUNNING, true)
                .commit();

        Intent intent = new Intent(this, FuMainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("districtCityCode", "652201");
        bundle.putString("districtCountyCode", "652200");
        bundle.putString("districtId", "ac360609-3bfb-4d18-824b-36489f21c4ec");
        bundle.putInt("districtLevel", 3);
        bundle.putString("districtName", "西河区");
        bundle.putString("orgCode", "457725247");
        bundle.putString("orgId", "0bcfeea9-c7de-43cd-9bd8-7b4d223ac8e1");
        bundle.putString("orgName", "新疆哈密市西河区社区卫生服务中心");
        bundle.putString("userId", "7fbc9378-bab1-478c-b942-fb6bca5af09f");
        bundle.putString("userRealName", "马玉汐");

        FuUserInfo fuUserInfo = new FuUserInfo();

        fuUserInfo.setDistrictCityCode("652201");
        fuUserInfo.setDistrictCountyCode("652200");
        fuUserInfo.setDistrictId("c360609-3bfb-4d18-824b-36489f21c4ec");
        fuUserInfo.setDistrictLevel(3);
        fuUserInfo.setDistrictName("西河区");
        fuUserInfo.setOrgCode("457725247");
        fuUserInfo.setOrgId("0bcfeea9-c7de-43cd-9bd8-7b4d223ac8e1");
        fuUserInfo.setOrgName("新疆哈密市西河区社区卫生服务中心");
        fuUserInfo.setUserId("7fbc9378-bab1-478c-b942-fb6bca5af09f");
        fuUserInfo.setUserRealName("马玉汐");

        ((FuApp) getApplication()).setmFuUserInfo(fuUserInfo);

        intent.putExtras(bundle);
        startActivity(intent);

        finish();
    }

    /**
     * 返回上一级页面
     */
    public void goToPrePage() {

        mManager.gotoBackFragment(CustomFragmentManager.LOGIN_REGIST,
                R.id.fu_fragment_contain);
    }

    private boolean mExitApp; // 是否退出程序

    @Override
    protected void onResume() {
        super.onResume();


        mManager.initFragmentManager(CustomFragmentManager.LOGIN_REGIST,
                getSupportFragmentManager());

        MobclickAgent.onResume(this);//友盟统计需要
    }

    @Override
    protected void onPause() {
        super.onPause();

        MobclickAgent.onPause(this);//友盟统计需要

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            boolean lShow = ToolUtil.hidePopLoading();

            if (lShow) {

                NetManager manager = NetManager.getInstance(this);
                manager.cnacelAllNetTask();

            } else {

                int lCurrentAction = mManager.mcurrentAction();

                if (lCurrentAction == FuUiFrameManager.FU_LOGIN) { // 在登录页点击返回，直接退出程序

                    mExitApp = true;
                    finish();

                    return false;
                }

                goToPrePage();
            }
        }

        return false;
    }

    ;

}
