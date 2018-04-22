package net.greatsoft.main.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuInitNavActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.BannerNameData;
import net.greatsoft.main.db.DataSaveManager;
import net.greatsoft.main.db.SaveTask;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.rsp.obj.FuUpdateAppResponse;
import net.greatsoft.main.tool.SIMCardInfo;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;


@SuppressLint("HandlerLeak")
public class FuWelcomeFragment extends FragmentParent {

	private final int BEGIN_NET = 0; // 开始版本信息网络请求
	private final int SUCCESS_NET = 100; // 网络成功
	private final int ERROR_NET = 500; // 网络错误

	Handler mHandler = new Handler() {

		public void handleMessage(Message msg) {

			switch (msg.what) {
			case BEGIN_NET:

				getChecks();


//				createVersionInfoNetTask();
				break;
			case SUCCESS_NET:
//				isUpDataVersion((FuUpdateAppResponse) msg.obj);
				break;
			case ERROR_NET:

				ToastUtil.showToast(getActivity(), (String) msg.obj,
						Toast.LENGTH_LONG);
				((FuInitNavActivity) getActivity()).finishApp();
				break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("activity","FuWelcomeFragment");
		FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
				.getApplication()).getFuUiFrameManager();

		mModel = lFuUiFrameManager.createFuModel(
				FuUiFrameManager.FU_WELCOME, getActivity(),
				new EventCallBack());

		return mModel.getFuView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mHandler.sendEmptyMessageDelayed(BEGIN_NET, 3000);
	}

	public static final int EVENT_DOWNLOAD_NOW = 1; // 立即下载
	public static final int EVENT_NOT_UPDATA = 2; // 暂不更新
	public static final int EVENT_APP_FINISH = 3; // 退出程序
	public static final int EVENT_DOWNLOAD_IMPORT = 4; // 重要下载

	class EventCallBack implements FuEventCallBack {

		@Override
		public void EventClick(int event, Object object) {

			switch (event) {
			case EVENT_DOWNLOAD_NOW:

				((FuInitNavActivity) getActivity()).startDownloadService(1,
						(String) object);
				ToastUtil
						.showToast(getActivity(), "正在后台下载", Toast.LENGTH_SHORT);
				jumpPage();
				break;
			case EVENT_NOT_UPDATA:

				jumpPage();
				break;
			case EVENT_DOWNLOAD_IMPORT:

				((FuInitNavActivity) getActivity()).startDownloadService(1,
						(String) object);
				ToastUtil
						.showToast(getActivity(), "正在后台下载", Toast.LENGTH_SHORT);
				((FuInitNavActivity) getActivity()).finishApp();
				break;
			case EVENT_APP_FINISH:

				((FuInitNavActivity) getActivity()).finishApp();
				break;
			}
		}
	}
//
//	public void createVersionInfoNetTask() {
//
//		String lChannel = ((FuApp) getActivity().getApplication())
//				.getChannelValue();
//
//		FuUpdateAppRequest lRequest = new FuUpdateAppRequest();
//		lRequest.setmType("1");
//		lRequest.setAV_CHANNEL(lChannel);
//
//		MyTask lTask = TaskManager.getInstace(getActivity()).getUpdateApp(
//				getCallBackInstance(), lRequest);
//
//		excuteNetTask(lTask, true);
//	}

	/**
	 * 判断是否更新
	 */
	public void isUpDataVersion() {

//		if (data == null || data.getmAvVersion() == null) {
//			saveImageBannerUrl("NO#NO#NO");
//			jumpPage();
//			return;
//		}

//		int newVerCode = Integer.parseInt(data.getmAvVersion()); // 检测是否有新的安装包更新
//		int oldVerCode = getVerCode();
//		if (newVerCode > oldVerCode) {
//			int lAvIsMajor = Integer.parseInt(data.getmAvIsMajor());
//			openDownLoadDialog(data.getmAvUrl(), data.getmAvText(), lAvIsMajor);
//			return;
//		}

		// -----------存储最新的轮播图资源
//		saveImageBannerUrl(data.getAV_RESOURCE() == null ? "NO#NO#NO" : data
//				.getAV_RESOURCE());
		// ------------------------------------------

		jumpPage();
	}

	private boolean getChecks(){


		if (Build.VERSION.SDK_INT >= 23) {
			int checkCallPhonePermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);
			if(checkCallPhonePermission != PackageManager.PERMISSION_GRANTED){
				FuWelcomeFragment.this.requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE
                ,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_EXTERNAL_STORAGE},111);
				return false;

//                Manifest.permission_group.STORAGE,
//                        Manifest.permission_group.CAMERA,Manifest.permission_group.CONTACTS,Manifest.permission_group.PHONE
			}else{
				//上面已经写好的拨号方法
//				callDirectly(mobile);
				ALocalSqlHelper ash = new ALocalSqlHelper(getContext());
				ash.write();
			}
		} else {
			//上面已经写好的拨号方法
//			callDirectly(mobile);
			ALocalSqlHelper ash = new ALocalSqlHelper(getContext());
			ash.write();
		}
        isUpDataVersion();
		return true;

	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case 111:
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// Permission Granted
//					callDirectly(mobile);
                    Toast.makeText(getContext(), "请稍等！", Toast.LENGTH_SHORT)
                            .show();
					ALocalSqlHelper ash = new ALocalSqlHelper(getContext());
					ash.write();
                    isUpDataVersion();

				} else {
					// Permission Denied
					Toast.makeText(getContext(), "请在设置中获取权限！", Toast.LENGTH_SHORT)
							.show();
				}
				break;
			default:
				super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}

	private void saveImageBannerUrl(String bannerImageUrl) {

		BannerNameData lNameData = new BannerNameData();
		lNameData.setBANNER_URL(bannerImageUrl);

		SaveTask saveTask = new SaveTask();
		saveTask.setmTaskKey(SaveTask.KEY_BANNER);
		saveTask.setmData(lNameData);

		DataSaveManager.getInstance(getActivity()).addSaveTask(saveTask);
	}

	/**
	 * 弹出更新Dialog
	 */
//	private void openDownLoadDialog(String url, String avText, int flag) {
//
//		boolean lUpdate = ((FuInitNavActivity) getActivity())
//				.isWorkedDownloadService();
//
//		switch (flag) {
//		case 1: // 强制更新
//
//			if (lUpdate) {
//				ToastUtil.showToast(getActivity(), "重大更新！正在下载更新包",
//						Toast.LENGTH_LONG);
//				((FuInitNavActivity) getActivity()).finishApp();
//			} else {
//				((FuWelcomeView) mModel).openImportantDownLoadDialog(url,
//						avText);
//			}
//			break;
//		case 2:// 非强制更新
//
//			if (lUpdate) {
//
//				jumpPage();
//			} else {
//				((FuWelcomeView) mModel).openDownLoadDialog(url, avText);
//			}
//			break;
//		}
//	}

	/**
	 * 跳转页面
	 */
	public void jumpPage() {

//		VersionData versionData = (VersionData) DataSaveManager.getInstance(
//				getActivity()).getSaveData(SaveTask.KEY_VERSION);
//
//		if (getVerCode() != versionData.getmVersion()) {
//
//			VersionData data = new VersionData();
//			data.setmVersion(getVerCode());
//
//			SaveTask saveTask = new SaveTask();
//			saveTask.setmTaskKey(SaveTask.KEY_VERSION);
//			saveTask.setmData(data);
//
//			DataSaveManager.getInstance(getActivity()).addSaveTask(saveTask);
//
//			Bundle bundle = new Bundle();
//			bundle.putBoolean("Flag", true);
//
//			((FuInitNavActivity) getActivity()).replaceFragment(
//					FuUiFrameManager.FU_GUIDE, bundle);
//		} else {

			((FuInitNavActivity) getActivity()).goToLoginPage();
//		}

	}

	/**
	 * 获取版本号
	 */
	public int getVerCode() {

		int verCode = -1;
		try {
			verCode = getActivity().getPackageManager().getPackageInfo(
					"com.original.client", 0).versionCode;
		} catch (NameNotFoundException e) {
			verCode = -1;
		}
		return verCode;
	}

	/**
	 * 获得版本名称
	 */
	public String getVerName() {
		String verName = "";
		try {
			verName = getActivity().getPackageManager().getPackageInfo(
					"net.greatsoft.followup", 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return verName;
	}

	@Override
	protected void loadDataChild(int taskId, FuResponse rspObj) {
		Message message = Message.obtain(mHandler);
		message.what = SUCCESS_NET;
		message.obj = rspObj;
		message.sendToTarget();
	}

	@Override
	protected void netErrorChild(int taskId, String msg) {
		Message message = Message.obtain(mHandler);
		message.what = ERROR_NET;
		message.obj = msg;
		message.sendToTarget();
	}

	@Override
	protected void cancelChild(int taskId) {
	}
}
