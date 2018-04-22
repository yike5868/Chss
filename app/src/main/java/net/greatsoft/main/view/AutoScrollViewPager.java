package net.greatsoft.main.view;

import java.lang.reflect.Field;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.Scroller;
/**
 * 自动轮播
 * @author 张林
 *
 */
public class AutoScrollViewPager extends ViewPager {

	public static final int DEFAULT_INTERVAL = 8000;
	public static final int SCROLL_WHAT = -1;

	private double autoScrollFactor = 8.0;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
			case SCROLL_WHAT:
				int nextItem = getCurrentItem();
				setCurrentItem(++nextItem, true);
				mHandler.sendEmptyMessageDelayed(SCROLL_WHAT, DEFAULT_INTERVAL
						+ scroller.getDuration());
			}
		}

	};

	public AutoScrollViewPager(Context paramContext) {
		super(paramContext);
		setViewPagerScroller();
	}

	public AutoScrollViewPager(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		setViewPagerScroller();
	}

	/**
	 * start auto scroll, first scroll delay time
	 */
	public void startAutoScroll() {
		mHandler.sendEmptyMessageDelayed(SCROLL_WHAT, DEFAULT_INTERVAL);
	}

	/**
	 * stop auto scroll
	 */
	public void stopAutoScroll() {
		mHandler.removeMessages(SCROLL_WHAT);
	}

	/**
	 * set ViewPager scroll to change animation duration when sliding
	 */
	private void setViewPagerScroller() {
		try {
			Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
			scrollerField.setAccessible(true);
			Field interpolatorField = ViewPager.class
					.getDeclaredField("sInterpolator");
			interpolatorField.setAccessible(true);

			scroller = new CustomDurationScroller(getContext(),
					(Interpolator) interpolatorField.get(null));
			scrollerField.set(this, scroller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CustomDurationScroller scroller = null;

	private class CustomDurationScroller extends Scroller {

		public CustomDurationScroller(Context context) {
			super(context);
		}

		public CustomDurationScroller(Context context, Interpolator interpolator) {
			super(context, interpolator);
		}

		@Override
		public void startScroll(int startX, int startY, int dx, int dy,
				int duration) {
			super.startScroll(startX, startY, dx, dy,
					(int) (duration * autoScrollFactor));
		}
	}

}
