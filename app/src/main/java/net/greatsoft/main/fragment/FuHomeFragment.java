package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuMainActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;

import java.util.ArrayList;


public class FuHomeFragment extends FragmentParent {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
				.getApplication()).getFuUiFrameManager();

		mModel = lFuUiFrameManager.createFuModel(
				FuUiFrameManager.FU_MAIN_HOME, getActivity(),
				new OnEventClick());

		return mModel.getFuView();
	}

	@Override
	public void onHiddenChanged(boolean hidden) {

		super.onHiddenChanged(hidden);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
	}


	public static final int EVENT_RHSF = 1;
	public static final int EVENT_LGT = 2;
	public static final int EVENT_EXAM = 3;
	public static final int EVENT_MEMBER = 4;
	public static final int EVENT_YZ = 5;
	public static final int EVENT_SL = 6;
	public static final int EVENT_UPLOAD = 7;
	public static final int EVENT_DOWNLOAD = 8;
	public static final int EVENT_SET = 9;
	public static final int EVENT_FAMILY = 10;

	public static final int EVENT_LIST = 11;
	public static final int EVENT_SYSTEM_SET = 12;




	class OnEventClick implements FuEventCallBack {

		@Override
		public void EventClick(int event, Object object) {

			switch (event) {

				case EVENT_LIST:

					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_LIST_VIEW, (Bundle) object);
					break;

				case EVENT_RHSF:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_S_RHSF, null);
					break;
				case EVENT_SYSTEM_SET:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_MAIN_ID, FuUiFrameManager.FU_SET, null);
					break;
				case EVENT_LGT:

//					((FuMainActivity) getActivity()).replaceFragment(
//							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_GP_MAIN, null);
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_LIST_VIEW, null);



					break;
				case EVENT_EXAM:
//					Class<FragmentParent>[] cls_exam = new Class[]{FuSExamFragment.class,FuSExamFragment.class,FuSExamFragment.class};

					ArrayList<Class> cls_exam = new ArrayList<>();
					cls_exam.add(FuSExamFragment.class);
					cls_exam.add(FuSExamFragment.class);
					cls_exam.add(FuSExamFragment.class);

					String[] titles_exam = new String[]{"8月","9月","10月"};
					Bundle bundle_exam = new Bundle();
					bundle_exam.putString("title","体检");
					bundle_exam.putSerializable("classes",cls_exam);
					bundle_exam.putStringArray("titles",titles_exam);

					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CHANGE_ID, FuUiFrameManager.FU_S_LGT, bundle_exam);
					break;
				case EVENT_MEMBER:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_S_MEMBER, null);
					break;
				case EVENT_YZ:

					((FuMainActivity)getActivity()).replaceFragment(FuUiFrameManager.FU_CONTENT_ID,FuUiFrameManager.FU_S_YZ,null);

//					ArrayList<Class> cls_yz = new ArrayList<>();
//					cls_yz.add(FuYzListFragment.class);
//					cls_yz.add(FuYzBloodFragment.class);
//					cls_yz.add(FuYzSugarFragment.class);
//
//					String[] titles_yz = new String[]{"档案","血压","血糖"};
//					Bundle bundle_yz = new Bundle();
//					bundle_yz.putSerializable("classes",cls_yz);
//					bundle_yz.putStringArray("titles",titles_yz);
//					bundle_yz.putString("title","义诊");
//					((FuMainActivity) getActivity()).replaceFragment(
//							FuUiFrameManager.FU_CHANGE_ID, FuUiFrameManager.FU_DOWN, bundle_yz);
					break;
				case EVENT_SL:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_S_SL, null);
					break;
				case EVENT_UPLOAD:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_S_UPLOAD, null);
					break;
				case EVENT_DOWNLOAD:
//					Class<FragmentParent>[] cls = new Class[]{FuHasDownFragment.class,FuDownFragment.class};

					ArrayList<Class> cls = new ArrayList<>();
					cls.add(FuHasDownFragment.class);
					cls.add(FuDownFragment.class);

					String[] titles = new String[]{"下载管理","地区列表"};
					Bundle bundle = new Bundle();
					bundle.putSerializable("classes",cls);
					bundle.putStringArray("titles",titles);
					bundle.putString("title","下载");
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CHANGE_ID, FuUiFrameManager.FU_DOWN, bundle);
					break;
				case EVENT_SET:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_MEMBERADD_04, null);
					break;
				case EVENT_FAMILY:
					((FuMainActivity) getActivity()).replaceFragment(
							FuUiFrameManager.FU_CONTENT_ID, FuUiFrameManager.FU_S_FAMILY, null);
					break;
			}

		}

	}

	@Override
	protected void loadDataChild(int taskId, FuResponse rspObj) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void cancelChild(int taskId) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void netErrorChild(int taskId, String msg) {
		// TODO Auto-generated method stub

	}
}
