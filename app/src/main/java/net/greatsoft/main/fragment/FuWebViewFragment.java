package net.greatsoft.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuWebView;


public class FuWebViewFragment extends FragmentParent {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		Bundle lBundle = ((FuContentActivity) getActivity()).getIntentBundle();

		if (lBundle == null) {
			return;
		}

		mTitle = lBundle.getString("title");
		mUrl = lBundle.getString("url");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
				.getApplication()).getFuUiFrameManager();

		mModel = lFuUiFrameManager.createFuModel(
				FuUiFrameManager.FU_WEBVIEW, getActivity(),
				new EventCallBack());

		return mModel.getFuView();
	}

	public static final int EVENT_BACK = 1; // 返回上一级页面

	class EventCallBack implements FuEventCallBack {

		@Override
		public void EventClick(int event, Object object) {

			switch (event) {
			case EVENT_BACK:
				((FuContentActivity) getActivity()).goToPrePage();
				break;
			}
		}

	}

	private String mTitle; // 标题
	private String mUrl; // 加载的地址

	public void intentData(Bundle bundle) {

		if (bundle == null) {
			return;
		}

		mTitle = bundle.getString("title");
		mUrl = bundle.getString("url");

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (mUrl != null) {

			((FuWebView) mModel).checkViewDraw(mHandler);

		}
	}

	Handler mHandler = new Handler() {

		public void handleMessage(android.os.Message msg) {

			switch (msg.what) {
			case ToolUtil.DRAW_OVER:

				((FuWebView) mModel).initData(mTitle, mUrl);
				
				mUrl = null;
				mTitle = null;

				break;

			}
		};
	};

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
