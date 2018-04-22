// Copyright (C) 2012-2013 UUZZ All rights reserved
package net.greatsoft.main.view;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.greatsoft.main.R;


@SuppressLint("HandlerLeak")
public class DragListView extends ListView implements OnScrollListener,
		OnClickListener {

	// 下来更新枚举�?��状�?
	private enum DListViewState {
		LV_NORMAL, // 普�?状�?
		LV_PULL_REFRESH, // 下拉状�?
		LV_RELEASE_REFRESH, // 松开可刷新状�?
		LV_LOADING; // 加载状�?
	}

	// 加载更多枚举�?��状�?
	private enum DListViewLoadingMore {
		LV_NORMAL, // 普�?状�?
		LV_LOADING, // 加载状�?
		LV_PULL_REFRESH, // 上拉状�?
		LV_RELEASE_REFRESH, // 松开可刷新状�?
		LV_OVER, // 结束状�?
	}

	private View mHeadView;// 头部headView
	private TextView mRefreshTextview; // 刷新msg（mHeadView�?
	private ImageView mArrowImageView;// 下拉图标（mHeadView�?
	private ProgressBar mHeadProgressBar;// 刷新进度体（mHeadView�?

	private int mHeadViewHeight;// headView的高（mHeadView�?

	private LinearLayout mContentGroupHead;
	private LinearLayout mContentGroupFooter;

	private TextView mNoContentHead;
	private TextView mNoContentFooter;
	private TextView mNoContentFoot;
	private View mFootView;// 尾部mFootView
	private ProgressBar mHeadProgressBarFoot;// 加载更多进度体（mFootView�?

	private int mFootViewHeight;// mFootView的高（mFootView�?

	private Animation animation, reverseAnimation;// 旋转动画,旋转动画之后旋转动画.

	private int mFirstItemIndex = -1;// 当前视图能看到的第一个项的索�?

	private int mLastItemIndex = -1;// 当前视图能看到的�?���?��项的索引

	private int mCountItem = -1; // 列表项的总数

	private boolean mIsRecord = false; // 用于保证startY的�?在一个完整的touch事件中只被记录一�?

	private boolean mIsRecordDown = false; // 与mIsRecord功能相似,仅仅用于区分向上或�?向下�?

	private int mStartY, mMoveY;// 按下是的y坐标,move时的y坐标

	private DListViewState mlistViewState = DListViewState.LV_NORMAL;// 更新默认状�?

	private DListViewLoadingMore loadingMoreState = DListViewLoadingMore.LV_NORMAL;// 加载更多默认状�?.

	private final static int RATIO = 2;// 手势下拉距离�?

	private boolean mBack = false;// headView是否返回.

	private boolean mBackMore = false;// footView是否返回.

	private OnRefreshLoadingMoreListener onRefreshLoadingMoreListener;// 下拉刷新接口（自定义,用于回调控制进度�?

	private boolean isScroller = true;// 是否屏蔽ListView滑动
	private TextView mArrowTipTimer;

	public DragListView(Context context) {
		super(context, null);
		initDragListView(context);
	}

	public DragListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initDragListView(context);
	}

	public DragListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initDragListView(context);
	}

	// ----------------------------------------------------

	// 注入下拉刷新接口
	public void setOnRefreshListener(
			OnRefreshLoadingMoreListener onRefreshLoadingMoreListener) {
		this.onRefreshLoadingMoreListener = onRefreshLoadingMoreListener;
	}

	/***
	 * 初始化ListView
	 */
	public void initDragListView(Context context) {

		initHeadView(context);// 初始化该head.

		initLoadMoreView(context);// 初始化footer

		setOnScrollListener(this);// ListView滚动监听
	}

	private int lLimitPage = 22; // 限制分页的条目的时机

	private boolean mEnableResher = true; // 是否允许下拉刷新，默认为允许

	public void setLimitPage(String limit) {
		lLimitPage = Integer.parseInt(limit);
	}

	public void setEnableRefresh(boolean enable) {

		mEnableResher = enable;
	}

	public int getLimitPage() {
		return lLimitPage;
	}

	/***
	 * 初始话头部HeadView
	 * 
	 * @param context
	 *            上下
	 *            上次更新时间
	 */
	public void initHeadView(Context context) {

		mHeadView = LayoutInflater.from(context).inflate(R.layout.drag_header,
				null);

		mContentGroupHead = (LinearLayout) mHeadView
				.findViewById(R.id.uz_have_content);
		mNoContentHead = (TextView) mHeadView.findViewById(R.id.uz_no_content);

		mArrowImageView = (ImageView) mHeadView
				.findViewById(R.id.head_arrowImageView);
		mArrowImageView.setMinimumWidth(60);
		mArrowTipTimer = (TextView) mHeadView.findViewById(R.id.head_tipsTimer);
		mHeadProgressBar = (ProgressBar) mHeadView
				.findViewById(R.id.head_progressBar);

		mRefreshTextview = (TextView) mHeadView
				.findViewById(R.id.head_tipsTextView);
		measureView(mHeadView);
		// 获取宽和�?
		mHeadViewHeight = mHeadView.getMeasuredHeight();

		addHeaderView(mHeadView, null, false);// 将初始好的ListView add进拖拽ListView
		// 在这里我们要将此headView设置到顶部不显示位置.
		mHeadView.setPadding(0, -1 * mHeadViewHeight, 0, 0);

		initAnimation();// 初始化动�?
		refreshTime();

	}

	/***
	 * 初始化底部加载更多控�?
	 */
	private void initLoadMoreView(Context context) {

		mFootView = LayoutInflater.from(context).inflate(R.layout.drag_footer,
				null);

		mHeadProgressBarFoot = (ProgressBar) mFootView
				.findViewById(R.id.head_progressBar);

		mNoContentFoot = (TextView) mFootView
				.findViewById(R.id.foot_no_content);

		// measureView(mFootView);
		// 获取宽和�?
		mFootViewHeight = mFootView.getMeasuredHeight();

		addFooterView(mFootView, null, false);

	}

	/***
	 * 初始化动�?
	 */
	private void initAnimation() {
		// 旋转动画
		animation = new RotateAnimation(0, -180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		animation.setInterpolator(new LinearInterpolator());// �??
		animation.setDuration(250);
		animation.setFillAfter(true);// 停留在最后状�?
		// 反向旋转动画
		reverseAnimation = new RotateAnimation(-180, 0,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		reverseAnimation.setInterpolator(new LinearInterpolator());
		reverseAnimation.setDuration(250);
		reverseAnimation.setFillAfter(true);
	}

	/***
	 * 作用：测�?headView的宽和高.
	 * 
	 * @param child
	 */
	@SuppressWarnings("deprecation")
	private void measureView(View child) {
		ViewGroup.LayoutParams p = child.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int lpHeight = p.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
					MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
					MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	// ----------------------------------------------

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		// 按下
		case MotionEvent.ACTION_DOWN:
			doActionDown(ev);
			// doActionDown_More(ev);
			break;
		// 移动
		case MotionEvent.ACTION_MOVE:
			doActionMove(ev);
			// doActionMove_More(ev);
			break;
		// 抬起
		case MotionEvent.ACTION_UP:
			doActionUp(ev);
			// doActionUp_More(ev);
			break;
		default:
			break;
		}
		/***
		 * 如果是ListView本身的拉�?那么返回true,这样ListView不可以拖�?
		 * 如果不是ListView的拉�?那么调用父类方法,这样就可以上拉执�?
		 */
		if (isScroller) {
			return super.onTouchEvent(ev);
		} else {
			return true;
		}
	}

	/***
	 * 摁下操作
	 * 
	 * 作用：获取摁下是的y坐标
	 * 
	 * @param event
	 */
	void doActionDown(MotionEvent event) {
		if (mIsRecord == false && mFirstItemIndex == 0 && mEnableResher) {
			mStartY = (int) event.getY();
			mIsRecord = true;
		}
	}

	void doActionDown_More(MotionEvent event) {

		if (mIsRecordDown == false
				&& (mLastItemIndex == mCountItem && mCountItem >= lLimitPage)) {
			mStartY = (int) event.getY();
			mIsRecordDown = true;
		}
	}

	/***
	 * 拖拽移动操作
	 * 
	 * @param event
	 */
	void doActionMove(MotionEvent event) {
		mMoveY = (int) event.getY();// 获取实时滑动y坐标
		// �?��是否是一次touch事件.
		if (mIsRecord == false && mFirstItemIndex == 0 && mEnableResher) {
			mStartY = (int) event.getY();
			mIsRecord = true;
		}
		/***
		 * 如果touch关闭或�?正处于Loading状�?的话 return.
		 */
		if (mIsRecord == false || mlistViewState == DListViewState.LV_LOADING) {
			return;
		}
		// headview移动距离为y移动的一�?（比较友好）
		int offset = (mMoveY - mStartY) / RATIO;

		switch (mlistViewState) {
		case LV_NORMAL: {
			// 如果<0,则意味着上滑�?
			if (offset > 0) {
				mContentGroupHead.setVisibility(View.VISIBLE);
				mNoContentHead.setVisibility(View.GONE);
				mHeadView.setPadding(0, offset - mHeadViewHeight, 0, 0);
				switchViewState(DListViewState.LV_PULL_REFRESH);// 下拉状�?
			}
		}
			break;
		case LV_PULL_REFRESH: {
			setSelection(0);// 时时保持在顶�?
			// 设置headView的padding属�?.
			mHeadView.setPadding(0, offset - mHeadViewHeight, 0, 0);
			if (offset < 0) {
				/***
				 * 要明白为�?��isScroller = false;
				 */
				isScroller = false;
				switchViewState(DListViewState.LV_NORMAL);// 普�?状�?
			} else if (offset > mHeadViewHeight) {// 如果下拉的offset超过headView的高度则要执行刷�?
				switchViewState(DListViewState.LV_RELEASE_REFRESH);// 更新为可刷新的下拉状�?
			}
		}
			break;
		// 可刷新状�?
		case LV_RELEASE_REFRESH: {
			setSelection(0);// 时时保持在顶�?
			// 设置headView的padding属�?.
			mHeadView.setPadding(0, offset - mHeadViewHeight, 0, 0);
			// 下拉offset>0,但是没有超过headView的高�?那么要goback 原装.
			if (offset >= 0 && offset <= mHeadViewHeight) {
				mBack = true;
				switchViewState(DListViewState.LV_PULL_REFRESH);
			} else if (offset < 0) {
				switchViewState(DListViewState.LV_NORMAL);
			}
		}
			break;
		default:
			return;
		}
	}

	void doActionMove_More(MotionEvent event) {
		mMoveY = (int) event.getY();// 获取实时滑动y坐标
		// �?��是否是一次touch事件.
		if (mIsRecordDown == false
				&& (mLastItemIndex == mCountItem && mCountItem >= lLimitPage)) {
			mStartY = (int) event.getY();
			mIsRecordDown = true;
		}
		/***
		 * 如果touch关闭或�?正处于Loading状�?的话 return.
		 */
		if (mIsRecordDown == false
				|| loadingMoreState == DListViewLoadingMore.LV_LOADING) {
			return;
		}
		// 计算偏移�?
		int offset = (mMoveY - mStartY) / RATIO;

		switch (loadingMoreState) {
		case LV_NORMAL: {
			// 如果<0,则意味着下滑动开�?
			if (offset < 0) {

				mContentGroupFooter.setVisibility(View.VISIBLE);
				mNoContentFooter.setVisibility(View.GONE);

				mFootView.setPadding(0, -(offset - mFootViewHeight), 0, 0);
				updateLoadMoreViewState(DListViewLoadingMore.LV_PULL_REFRESH);// 下拉状�?
			}
		}
			break;
		case LV_PULL_REFRESH: {
			setSelection(mLastItemIndex);// 时时保持在顶�?
			// 设置headView的padding属�?.
			mFootView.setPadding(0, -(offset - mFootViewHeight), 0, 0);
			if (offset > 0) {
				/***
				 * 要明白为�?��isScroller = false;
				 */
				isScroller = false;
				updateLoadMoreViewState(DListViewLoadingMore.LV_NORMAL);// 普�?状�?
			} else if ((-offset) > mFootViewHeight) {// 如果下拉的offset超过FootView的高度则要执行刷�?
				updateLoadMoreViewState(DListViewLoadingMore.LV_RELEASE_REFRESH);// 更新为可刷新的下拉状�?
			}
		}
			break;
		// 可刷新状�?
		case LV_RELEASE_REFRESH: {
			setSelection(mLastItemIndex);// 时时保持在顶�?
			// 设置headView的padding属�?.
			mFootView.setPadding(0, -(offset - mFootViewHeight), 0, 0);

			// 下拉offset>0,但是没有超过headView的高�?那么要goback 原装.
			if (offset <= 0 && (-offset) <= mFootViewHeight) {
				mBackMore = true;
				updateLoadMoreViewState(DListViewLoadingMore.LV_PULL_REFRESH);
			} else if (offset > 0) {
				updateLoadMoreViewState(DListViewLoadingMore.LV_NORMAL);
			}
		}
			break;
		default:
			return;
		}

	}

	/***
	 * 手势抬起操作
	 * 
	 * @param event
	 */
	@SuppressWarnings("incomplete-switch")
	public void doActionUp(MotionEvent event) {
		mIsRecord = false;// 此时的touch事件完毕,要关�?
		isScroller = true;// ListView可以Scrooler滑动.
		mBack = false;
		// 如果下拉状�?处于loading状�?.
		if (mlistViewState == DListViewState.LV_LOADING) {
			return;
		}
		// 处理相应状�?.
		switch (mlistViewState) {
		// 普�?状�?
		case LV_NORMAL:
			break;
		// 下拉状�?
		case LV_PULL_REFRESH:
			mHeadView.setPadding(0, -1 * mHeadViewHeight, 0, 0);
			switchViewState(DListViewState.LV_NORMAL);
			break;
		// 刷新状�?
		case LV_RELEASE_REFRESH:
			mHeadView.setPadding(0, 0, 0, 0);
			switchViewState(DListViewState.LV_LOADING);
			onRefresh();// 下拉刷新
			break;
		}

	}

	@SuppressWarnings("incomplete-switch")
	void doActionUp_More(MotionEvent event) {

		mIsRecordDown = false;// 此时的touch事件完毕,要关�?
		isScroller = true;// ListView可以Scrooler滑动.
		mBackMore = false;
		// 如果下拉状�?处于loading状�?.
		if (loadingMoreState == DListViewLoadingMore.LV_LOADING) {
			return;
		}
		// 处理相应状�?.
		switch (loadingMoreState) {
		// 普�?状�?
		case LV_NORMAL:
			mFootView.setPadding(0, -1 * mFootViewHeight, 0, 0);
			break;
		// 下拉状�?
		case LV_PULL_REFRESH:
			mFootView.setPadding(0, -1 * mFootViewHeight, 0, 0);
			updateLoadMoreViewState(DListViewLoadingMore.LV_NORMAL);
			break;
		// 刷新状�?
		case LV_RELEASE_REFRESH:
			mFootView.setPadding(0, 0, 0, 0);
			updateLoadMoreViewState(DListViewLoadingMore.LV_LOADING);
			onLoadMore();// 更多
			break;
		}

	}

	// 切换headview视图
	private void switchViewState(DListViewState state) {

		switch (state) {
		// 普�?状�?
		case LV_NORMAL: {
			mArrowImageView.clearAnimation();// 清除动画
			mArrowImageView.setImageResource(R.mipmap.ic_refrash_up);

		}
			break;
		// 下拉状�?
		case LV_PULL_REFRESH: {

			mHeadProgressBar.setVisibility(View.GONE);// 隐藏进度�?
			mArrowImageView.setVisibility(View.VISIBLE);// 下拉图标
			mRefreshTextview.setText("下拉刷新");
			mArrowImageView.clearAnimation();// 清除动画

			// 是有可刷新状态（LV_RELEASE_REFRESH）转为这个状态才执行,其实就是你下拉后在上拉会执行.
			if (mBack) {
				mBack = false;
				mArrowImageView.clearAnimation();// 清除动画
				mArrowImageView.startAnimation(reverseAnimation);// 启动反转动画
			}

		}
			break;
		// 松开刷新状�?
		case LV_RELEASE_REFRESH: {

			mHeadProgressBar.setVisibility(View.GONE);// 隐藏进度�?
			mArrowImageView.setVisibility(View.VISIBLE);// 显示下拉图标
			mRefreshTextview.setText("松开立即刷新");
			mArrowImageView.clearAnimation();// 清除动画
			mArrowImageView.startAnimation(animation);// 启动动画

		}
			break;
		// 加载状�?
		case LV_LOADING: {

			mHeadProgressBar.setVisibility(View.VISIBLE);
			mArrowImageView.clearAnimation();
			mArrowImageView.setVisibility(View.GONE);
			mRefreshTextview.setText("刷新中......");

		}
			break;
		default:
			return;
		}
		// 切记不要忘记时时更新状�?.
		mlistViewState = state;

	}

	/***
	 * 下拉刷新
	 */
	private void onRefresh() {
		if (onRefreshLoadingMoreListener != null) {
			onRefreshLoadingMoreListener.onRefresh();
		}
	}

	// 上拉加载更多
	int mLong = 0;

	private void onLoadMore() {

		if (onRefreshLoadingMoreListener != null) {
			onRefreshLoadingMoreListener.onLoadMore();
			mLong = getAdapter().getCount();
		}
	}

	private final int NO_DATA_VISIBLE = 1;
	private final int ANIMI_DISAPEAER = 2;

	private final int NO_DATA_VISIBLE_MORE = 3;
	private final int ANIMI_DISAPEAER_MORE = 4;

	Handler mHandler = new Handler() {

		public void handleMessage(android.os.Message msg) {

			switch (msg.what) {
			case NO_DATA_VISIBLE:

				mContentGroupHead.setVisibility(View.GONE);
				mNoContentHead.setVisibility(View.VISIBLE);

				mHeadView.invalidate();

				break;
			case ANIMI_DISAPEAER:

				mHeadView.setPadding(0, -1 * mHeadViewHeight, 0, 0);// 回归.
				switchViewState(DListViewState.LV_NORMAL);//

				break;
			case NO_DATA_VISIBLE_MORE:

				mContentGroupFooter.setVisibility(View.GONE);
				mNoContentFooter.setVisibility(View.VISIBLE);

				mFootView.invalidate();
				break;
			case ANIMI_DISAPEAER_MORE:

				updateLoadMoreViewState(DListViewLoadingMore.LV_RELEASE_REFRESH);

				break;

			}

		};
	};

	private final int DELAY_TIMER = 500; // 无数据显示内容延迟的时间

	/***
	 * 下拉刷新完毕
	 */
	public void onRefreshComplete(boolean isHavaeData) {

		refreshTime();

		if (isHavaeData) {
			updateLoadMoreViewState(DListViewLoadingMore.LV_NORMAL);
			mHandler.sendEmptyMessage(ANIMI_DISAPEAER);
			return;
		}

		mHandler.sendEmptyMessage(NO_DATA_VISIBLE);

		TimerTask mTask_newsImg = new TimerTask() {
			@Override
			public void run() {

				mHandler.sendEmptyMessage(ANIMI_DISAPEAER);
			}
		};

		Timer timer = new Timer();
		timer.schedule(mTask_newsImg, DELAY_TIMER);

	}

	/***
	 * 点击加载更多
	 * 
	 * @param isHavaeData
	 *            数据是否已全部加载完�?
	 */
	public void onLoadMoreComplete(boolean isHavaeData) {

		if (mLong == getAdapter().getCount()) {
			updateLoadMoreViewState(DListViewLoadingMore.LV_OVER);
		} else {
			mHandler.sendEmptyMessage(ANIMI_DISAPEAER_MORE);
		}

	}

	// 更新Footview视图
	private void updateLoadMoreViewState(DListViewLoadingMore state) {
		switch (state) {
		case LV_NORMAL: // 初始化
			mNoContentFoot.setVisibility(View.GONE);
			mHeadProgressBarFoot.setVisibility(View.GONE);
			break;
		case LV_RELEASE_REFRESH: // 初始化
			mNoContentFoot.setVisibility(View.GONE);
			mHeadProgressBarFoot.setVisibility(View.VISIBLE);
			break;
		case LV_LOADING: // 加载中
			mNoContentFoot.setVisibility(View.GONE);
			mHeadProgressBarFoot.setVisibility(View.VISIBLE);
			onLoadMore();// 更多
			break;
		case LV_OVER: // 加载中
			mHeadProgressBarFoot.setVisibility(View.GONE);
			mNoContentFoot.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
		loadingMoreState = state;
	}

	@Override
	public void onClick(View v) {

		// 防止重复点击
		if (onRefreshLoadingMoreListener != null
				&& loadingMoreState == DListViewLoadingMore.LV_NORMAL) {
			// updateLoadMoreViewState(DListViewLoadingMore.LV_LOADING);
			onRefreshLoadingMoreListener.onLoadMore();// 对外提供方法加载更多.
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {

		mFirstItemIndex = firstVisibleItem;
		mLastItemIndex = firstVisibleItem + visibleItemCount;
		mCountItem = totalItemCount;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

		switch (scrollState) {
		case SCROLL_STATE_IDLE:
			move_More();
			break;
		}
	}

	private void move_More() {

		if (mLastItemIndex != mCountItem || mCountItem < lLimitPage) {
			return;
		}
		switch (loadingMoreState) {
		case LV_NORMAL:
			Log.d("00", "LV_NORMAL");
			updateLoadMoreViewState(DListViewLoadingMore.LV_RELEASE_REFRESH);
			break;
		case LV_RELEASE_REFRESH:
			Log.d("00", "LV_RELEASE_REFRESH");
			updateLoadMoreViewState(DListViewLoadingMore.LV_LOADING);
			break;
		default:
			break;
		}

	}

	/***
	 * 自定义回调接口
	 */
	public interface OnRefreshLoadingMoreListener {
		/***
		 * // 下拉刷新执行
		 */
		void onRefresh();

		/***
		 * 点击加载更多
		 */
		void onLoadMore();
	}

	/**
	 * 刷新本地时间
	 */
	public void refreshTime() {
		Time t = new Time();
		t.setToNow(); // 取得系统时间�?
		int month = t.month + 1;
		String mMonth = String.valueOf(month);
		int date = t.monthDay;
		String mDate = String.valueOf(date);
		int hour = t.hour;
		String mHour = String.valueOf(hour);
		int minute = t.minute;
		String mMinute = String.valueOf(minute);
		int second = t.second;
		String mSecond = String.valueOf(second);
		if (month < 10) {
			mMonth = "0" + month;
		}
		if (date < 10) {
			mDate = "0" + date;
		}
		if (hour < 10) {
			mHour = "0" + hour;
		}
		if (minute < 10) {
			mMinute = "0" + minute;
		}
		if (second < 10) {
			mSecond = "0" + second;
		}
		mArrowTipTimer.setText("上次刷新:" + " " + mMonth + "-" + mDate + " "
				+ mHour + ":" + mMinute + ":" + mSecond);

	}
}
