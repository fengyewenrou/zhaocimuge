package com.zhaoci.share.story.po;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String customerId;

	/**  */
	private Integer taleId;

	/**  */
	private String comment;

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

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}

	public void setTaleId(Integer taleId) {
		this.taleId = taleId;
	}
	
	public Integer getTaleId() {
		return this.taleId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
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