package net.greatsoft.main.uiframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuWebViewFragment;
import net.greatsoft.main.tool.ToolUtil;

public class FuWebView extends FuUiFrameModel implements OnClickListener {

	public FuWebView(Context cxt, FuEventCallBack callBack) {
		super(cxt, callBack);
	}

	@Override
	protected void createFuLayout() {

		mFuView = LayoutInflater.from(mContext).inflate(
				R.layout.fu_webview_content, null);
	}

	private WebView mWebView;

	@Override
	protected void initFuData() {

		initTitle();

		mWebView = (WebView) mFuView.findViewById(R.id.webView);
		mWebView.setWebViewClient(new CustomWebViewClient());
	}

	@Override
	protected void initWidget() {

	}

	/**
	 * 初始化title
	 */
	public void initTitle() {

		Button jkx_title_left_btn = (Button) mFuView
				.findViewById(R.id.fu_title_left_btn);
		jkx_title_left_btn.setVisibility(View.VISIBLE);
		jkx_title_left_btn.setOnClickListener(this);

	}

	public void initData(String title, String url) {

		TextView jkx_title_center = (TextView) mFuView
				.findViewById(R.id.fu_title_center);
		jkx_title_center.setText(title);

		if (url != null && url.trim().length() > 0) {

			mWebView.loadUrl(url);
		}

	}
	
	
	public void checkViewDraw(Handler handler) {

		ToolUtil.chechLoadOver(mFuView.findViewById(R.id.fu_title_left_btn),
				handler);
	}

	private class CustomWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);

			ToolUtil.showPopWindowLoading(mContext);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);

			ToolUtil.hidePopLoading();
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.fu_title_left_btn:

			mEventCallBack.EventClick(FuWebViewFragment.EVENT_BACK, null);
			
			break;

		}

	}

}
