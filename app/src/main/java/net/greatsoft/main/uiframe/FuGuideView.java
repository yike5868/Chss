package net.greatsoft.main.uiframe;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.fragment.FuGuideFragment;

public class FuGuideView extends FuUiFrameModel {


	private List<View> list = null;
	private ImageView[] dots;
	private ViewPager vPager;
	private boolean mFlag;

	public FuGuideView(Context cxt, FuEventCallBack callBack) {
		super(cxt, callBack);
	}

	@Override
	protected void createFuLayout() {
		mFuView = LayoutInflater.from(mContext).inflate(
				R.layout.fu_guide_view, null);
	}

	@Override
	protected void initFuData() {
		findView();
	}

	@Override
	protected void initWidget() {

	}

	public void setFlag(boolean flag) {
		mFlag = flag;
	}

	/**
	 * 发现View 给Button设置监听事件
	 */
	public void findView() {

		vPager = (ViewPager) mFuView.findViewById(R.id.guide_viewPager);
		LinearLayout layout = (LinearLayout) mFuView
				.findViewById(R.id.guide_dots_LinearLayout);
		list = new ArrayList<View>();
		int[] imageId = { R.mipmap.guide1, R.mipmap.guide2,
				R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5 };
		dots = new ImageView[imageId.length];
		for (int i = 0; i < imageId.length; i++) {
			LinearLayout linearLayout = new LinearLayout(mContext);
			linearLayout.setGravity(Gravity.CENTER);
			ImageView imgView = new ImageView(mContext);
			imgView.setScaleType(ImageView.ScaleType.FIT_XY);
			displayFromDrawable(imageId[i],imgView);
			linearLayout.addView(imgView);
			list.add(linearLayout);
			if (i == imageId.length - 1) {
				imgView.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						if (!mFlag) {

							mEventCallBack.EventClick(
									FuGuideFragment.EVENT_MORE_PAGE, null);

							return;
						}
						
						mEventCallBack.EventClick(
								FuGuideFragment.EVENT_LOGIN_PAGE, null);
					}
				});
			}
			/***/
			dots[i] = (ImageView) layout.getChildAt(i);
			dots[i].setEnabled(true);
			dots[i].setTag(i);
			dots[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					vPager.setCurrentItem((Integer) v.getTag());
				}
			});
		}

		dots[0].setEnabled(false);
		vPager.setAdapter(new MyPagerAdapter(list));
		vPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageSelected(int arg0) {
				for (int i = 0; i < dots.length; i++) {
					dots[i].setEnabled(true);
				}
				dots[arg0].setEnabled(false);
			}

		});

	}
	/**
	 * 从drawable中异步加载本地图片
	 *
	 * @param imageId
	 * @param imageView
	 */
	public void displayFromDrawable(int imageId, ImageView imageView) {

		ImageLoader.getInstance().displayImage("drawable://" + imageId,
				imageView);
	}
	class MyPagerAdapter extends PagerAdapter {
		private List<View> list = null;

		public MyPagerAdapter(List<View> list) {
			this.list = list;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));
			return list.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}
	}

}
