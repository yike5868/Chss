package net.greatsoft.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.umeng.analytics.MobclickAgent;

import net.greatsoft.main.EventAction;
import net.greatsoft.main.R;
import net.greatsoft.main.control.fragment.CustomFragmentManager;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.fragment.FuListFragment;
import net.greatsoft.main.net.NetManager;
import net.greatsoft.main.tool.ToolUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FuContentActivity extends FuParentActivity {

    private CustomFragmentManager mManager;

    public static final String FRAGMENT_ACTION_KEY = "FragmentActionKey";
    public static final String INTENT_BUNDLE = "intent_bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fu_public_no_bottom);

        mManager = CustomFragmentManager.getInstance(this);

        mManager.initFragmentManager(CustomFragmentManager.CONTENT,
                getSupportFragmentManager());

        mManager.addFragment(R.id.fu_fragment_contain, getFragmentId());

        getScreenSizeOfDevice();

    }

    public void replaceFragment(int FragmentId, Bundle bundle) {

        mManager.replaceFragment(R.id.fu_fragment_contain, FragmentId, bundle);

    }

    public void replaceFragment(int ViewActId, int FragmentId, Bundle bundle) {

        switch (ViewActId) {
            case FuUiFrameManager.FU_MAIN_ID:
                mManager.replaceFragment(R.id.fu_fragment_contain, FragmentId,
                        bundle);
                break;
            case FuUiFrameManager.FU_CONTENT_ID:
                mManager.replaceFragment(R.id.fu_fragment_contain, FragmentId,
                        bundle);
                break;
            case FuUiFrameManager.FU_CHANGE_ID:
                Intent intent2 = new Intent(this, FuChangeActivity.class);
                intent2.putExtra(FuChangeActivity.INTENT_BUNDLE, bundle);
                startActivity(intent2);
                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mManager.initFragmentManager(CustomFragmentManager.CONTENT,
                getSupportFragmentManager());

        MobclickAgent.onResume(this);//友盟统计需要
    }

    @Override
    protected void onPause() {
        super.onPause();

        MobclickAgent.onPause(this);//友盟统计需要

    }

    /**
     * 获取FragmentId(用与在不同的切换activity的入口之间传递fragmentID)
     */
    public int getFragmentId() {

        return getIntent().getIntExtra(FRAGMENT_ACTION_KEY, 0);
    }

    /**
     * 获取 返回上一级页面所携带的数据
     */
    public Bundle getIntentBundle() {

        return getIntent().getBundleExtra(INTENT_BUNDLE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventAction.REGISTER_NUMBER = null;
    }

    /**
     * 清除该视图下的所有frament
     */
    public void clearFragmentAll() {

        mManager.clearBackFragmentAll(CustomFragmentManager.CONTENT);
    }

    /**
     * 除了当前显示的 fragment,清除该视图下剩余的全部
     */
    public void clearFragmentNoCur() {

        mManager.clearBackFragment(CustomFragmentManager.CONTENT);
    }

    /**
     * 除了当前显示的 fragment和第一个fragment,清除该视图下剩余的全部
     */
    public void clearFragmentNoCurAndFirst() {

        mManager.clearBackFragmentTopAndBottom(CustomFragmentManager.CONTENT);
    }

    /**
     * 返回上一级页面
     */
    public void goToPrePage() {

        boolean isBack = mManager.gotoBackFragment(
                CustomFragmentManager.CONTENT, R.id.fu_fragment_contain);

        if (!isBack) {
            finish();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            boolean lShow = ToolUtil.hidePopLoading();

            if (lShow) {

                NetManager manager = NetManager.getInstance(this);
                manager.cnacelAllNetTask();

            } else {

                Fragment f =  mManager.mCurrentFragment(FuUiFrameManager.FU_LIST_VIEW);
                if(f instanceof FuListFragment){
                   if(((FuListFragment)f).goBack()){
                       return true;
                   }
                }


                boolean isBack = mManager.gotoBackFragment(
                        CustomFragmentManager.CONTENT,
                        R.id.fu_fragment_contain);

                if (!isBack) {
                    finish();
                }

            }
        }

        return false;

    }


    public String dataToString(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(data);
    }


}
