package net.greatsoft.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

	private IsShowKeyboardCallBack mCallBack;

	public void isShowKeyboard(IsShowKeyboardCallBack callBack) {
		mCallBack = callBack;
	}

	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (mCallBack == null) {
			return;
		}
		boolean isShowKeyboard = oldh > h;
		mCallBack.onIsShowKeyboard(isShowKeyboard);
	}

	public interface IsShowKeyboardCallBack {

		public void onIsShowKeyboard(boolean isShowKeyboard);

	}

}
