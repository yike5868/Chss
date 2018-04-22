package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年12月29日 下午2:19:09 
 * @Description: 安卓上传文件记录
 *
 */
@Entity
public class AndroidFileRecord extends Entry {
	/**
	 * 主键
	 */
	private String androidFileRecordId;

	/**
	 * 关联业务表主键
	 */
	private String referenceKey;
	
	/**
	 * 文件记录主键
	 */
	private String attachmentId;
	
	/**
	 * 上传时间
	 */
	private Date uploadDate;
	
	/**
	 * 服务项目ID
	 */
	private String serviceItemId;

	public String getServiceItemId() {
		return this.serviceItemId;
	}

	public void setServiceItemId(String serviceItemId) {
		this.serviceItemId = serviceItemId;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getReferenceKey() {
		return this.referenceKey;
	}

	public void setReferenceKey(String referenceKey) {
		this.referenceKey = referenceKey;
	}

	public String getAndroidFileRecordId() {
		return this.androidFileRecordId;
	}

	public void setAndroidFileRecordId(String androidFileRecordId) {
		this.androidFileRecordId = androidFileRecordId;
	}

	@Generated(hash = 423986504)
	public AndroidFileRecord(String androidFileRecordId, String referenceKey,
			String attachmentId, Date uploadDate, String serviceItemId) {
		this.androidFileRecordId = androidFileRecordId;
		this.referenceKey = referenceKey;
		this.attachmentId = attachmentId;
		this.uploadDate = uploadDate;
		this.serviceItemId = serviceItemId;
	}

	@Generated(hash = 1031776461)
	public AndroidFileRecord() {
	}


}
