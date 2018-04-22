package net.greatsoft.main.fragment;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.greatsoft.main.EventAction;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuLoginRegistActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.net.MyTask;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.rqt.obj.FuRegistAppRequest;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.tool.ToolUtil;
import net.greatsoft.main.uiframe.FuRegistView;


@SuppressLint("HandlerLeak")
public class FuRegistFragment extends FragmentParent {
	private final int ERROR = 2;
	private final int COUNTDOWN = 3;
	private int timeLong = 10;
	private Timer mTimer;
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case MyTask.REGIST_APP:
				ToolUtil.hidePopLoading();
				((FuRegistView) mModel).setForResultValue();
				break;
			case MyTask.VALIDATE_CODE:
				countDown();
				ToolUtil.hidePopLoading();
				break;
			case ERROR:

				ToolUtil.hidePopLoading();

				ToastUtil.showToast(getActivity(), (String) msg.obj,
						Toast.LENGTH_SHORT);

				if (msg.arg1 == MyTask.VALIDATE_CODE) {
					((FuRegistView) mModel).resetGetValidateCodeButton();
				}
				break;
			case COUNTDOWN:
				((FuRegistView) mModel).setValidateCodeText(String
						.valueOf(msg.arg1));
				if (msg.arg1 == 0) {
					if (mTimer != null) {
						mTimer.cancel();
						((FuRegistView) mModel).resetGetValidateCodeButton();
					}
				}
				break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
				.getApplication()).getFuUiFrameManager();

		mModel = lFuUiFrameManager.createFuModel(
				FuUiFrameManager.FU_REGIST, getActivity(),
				new EventCallBack());
		return mModel.getFuView();
	}

	public static final int EVENT_BACK = 1; // 返回上一页

	public static final int EVENT_REGIST_REGIST = 2; // 注册

	public static final int EVENT_REGIST_VCODE = 3; // 注册验证码

	public static final int EVENT_REGIST_READ_TERMS = 4; // 查看服务条款

	public static final int EVENT_REGIST_REGIST_SUCCESS = 5; // 注册成功

	class EventCallBack implements FuEventCallBack {

		@SuppressWarnings("unchecked")
		@Override
		public void EventClick(int event, Object object) {
			switch (event) {
			case EVENT_BACK:

				((FuLoginRegistActivity) getActivity()).goToPrePage();

				break;
			case EVENT_REGIST_READ_TERMS:

				break;
			case EVENT_REGIST_REGIST:
//				FuRegistAppRequest lRequest = (FuRegistAppRequest) object;
//
//				MyTask lTask = TaskManager.getInstace(getActivity()).getRegistApp(
//						getCallBackInstance(), lRequest);
//
//				excuteNetTask(lTask, false);

				break;
			case EVENT_REGIST_REGIST_SUCCESS:

				EventAction.BACK_CACHE_DATA = null;

				EventAction.BACK_CACHE_DATA = (HashMap<String, Object>) object;

				((FuLoginRegistActivity) getActivity()).goToPrePage();

				break;
			}
		}

	}

	/**
	 * 倒计时器
	 */
	public void countDown() {
		timeLong = 120;
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				Message message = Message.obtain(mHandler);
				message.what = COUNTDOWN;
				message.arg1 = timeLong--;
				message.sendToTarget();
			}
		}, 1000, 1000);
	}

	@Override
	protected void loadDataChild(int taskId, FuResponse rspObj) {
		Message message = Message.obtain(mHandler);
		message.what = taskId;
		message.obj = rspObj;
		message.sendToTarget();
	}

	@Override
	protected void netErrorChild(int taskId, String msg) {
		Message message = Message.obtain(mHandler);
		message.what = ERROR;
		message.arg1 = taskId;
		message.obj = msg;
		message.sendToTarget();
	}

	@Override
	protected void cancelChild(int taskId) {
	}
}
