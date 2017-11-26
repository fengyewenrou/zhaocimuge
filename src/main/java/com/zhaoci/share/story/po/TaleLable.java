package com.zhaoci.share.story.po;

import java.io.Serializable;

public class TaleLable implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private Integer taleId;

	/**  */
	private Integer lableId;

	/**  */
	private String isUsed;

	/**  */
	private java.util.Date createDate;

	/**  */
	private java.util.Date updateDate;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setTaleId(Integer taleId) {
		this.taleId = taleId;
	}
	
	public Integer getTaleId() {
		return this.taleId;
	}

	public void setLableId(Integer lableId) {
		this.lableId = lableId;
	}
	
	public Integer getLableId() {
		return this.lableId;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	public String getIsUsed() {
		return this.isUsed;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

}