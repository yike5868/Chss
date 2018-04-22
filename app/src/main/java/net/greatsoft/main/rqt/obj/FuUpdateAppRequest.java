package net.greatsoft.main.rqt.obj;


import net.greatsoft.main.db.po.Entry;

public class FuUpdateAppRequest extends Entry {

	private String mType; // 1:居民A 2:居民I 3:监管A 4:监管I 5:医生A 6:医生I

	private String AV_CHANNEL; //渠道号

	public String getAV_CHANNEL() {
		return AV_CHANNEL;
	}

	public void setAV_CHANNEL(String aV_CHANNEL) {
		AV_CHANNEL = aV_CHANNEL;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

}
