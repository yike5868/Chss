package net.greatsoft.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.activity.FuInitNavActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.uiframe.FuGuideView;

public class FuGuideFragment extends FragmentParent {

	private boolean mFlag; // true 表示来自初始化进入，false表示来自更多进入

	public void intentData(Bundle bundle) {

		if (bundle == null) {
			return;
		}

		mFlag = bundle.getBoolean("Flag", false);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (mFlag) {
			return;
		}

		Bundle lBundle = ((FuContentActivity) getActivity()).getIntentBundle();

		if (lBundle == null) {
			return;
		}

		mFlag = lBundle.getBoolean("Flag", false);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
				.getApplication()).getFuUiFrameManager();

		mModel = lFuUiFrameManager.createFuModel(FuUiFrameManager.FU_GUIDE,
				getActivity(), new EventCallBack());

		return mModel.getFuView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		((FuGuideView) mModel).setFlag(mFlag);
	}

	public static final int EVENT_LOGIN_PAGE = 1; // 登录页

	public static final int EVENT_MORE_PAGE = 2; // 更多页

	class EventCallBack implements FuEventCallBack {

		@Override
		public void EventClick(int event, Object object) {

			switch (event) {
			case EVENT_LOGIN_PAGE:
				((FuInitNavActivity) getActivity()).goToLoginPage();
				break;
			case EVENT_MORE_PAGE:

				((FuContentActivity) getActivity()).goToPrePage();

				break;
			}

		}
	}

	@Override
	protected void loadDataChild(int taskId, FuResponse rspObj) {
	}

	@Override
	protected void netErrorChild(int taskId, String msg) {
	}

	@Override
	protected void cancelChild(int taskId) {
	}

}
