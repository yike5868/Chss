package net.greatsoft.main.net;


import net.greatsoft.main.control.FuResponse;

public interface NetCallBack {

	void cancel(int taskId);

	void loadData(int taskId, FuResponse rspObj);

	void netError(int taskId, String msg);
}
