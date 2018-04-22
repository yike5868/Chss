/*
 * $Id: codetemplates.xml 2918 2014-01-22 15:29:26Z hn $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author hn
 * @date 2016年6月20日 下午3:12:47
 * @Description: 既往史-手术、外伤、输血
 * 
 */
@Entity
public class PersonPastHistory extends Entry {

	/**
	 * 个人ID
	 */
	private String personInfoId;

	/**
	 * ID
	 */
	private String personPastHistoryId;

	/**
	 * 内部流水号 每个类型均从1开始，如果为1表示对应前台第一个输入框，为2表示第二个…
	 */
	private Integer orderNo;

	/**
	 * 1手术2外伤3输血
	 */
	private String historyType;

	/**
	 * 选择状态1无2有
	 */
	private String choiceStatus;

	/**
	 * 名称
	 */
	private String historyName;

	/**
	 * 时间
	 */
	private Date confirmDate;

	public Date getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getHistoryName() {
		return this.historyName;
	}

	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}

	public String getChoiceStatus() {
		return this.choiceStatus;
	}

	public void setChoiceStatus(String choiceStatus) {
		this.choiceStatus = choiceStatus;
	}

	public String getHistoryType() {
		return this.historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getPersonPastHistoryId() {
		return this.personPastHistoryId;
	}

	public void setPersonPastHistoryId(String personPastHistoryId) {
		this.personPastHistoryId = personPastHistoryId;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	@Generated(hash = 1715153292)
	public PersonPastHistory(String personInfoId, String personPastHistoryId,
			Integer orderNo, String historyType, String choiceStatus, String historyName,
			Date confirmDate) {
		this.personInfoId = personInfoId;
		this.personPastHistoryId = personPastHistoryId;
		this.orderNo = orderNo;
		this.historyType = historyType;
		this.choiceStatus = choiceStatus;
		this.historyName = historyName;
		this.confirmDate = confirmDate;
	}

	@Generated(hash = 1564272971)
	public PersonPastHistory() {
	}

	


}
