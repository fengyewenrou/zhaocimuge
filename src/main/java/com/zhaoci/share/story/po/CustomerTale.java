package com.zhaoci.share.story.po;

import java.io.Serializable;

public class CustomerTale implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String customerId;

	/**  */
	private Integer taleId;

	/** 类型，1喜欢 2收藏 */
	private String type;

	/**  */
	private String isUsed;

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

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	public String getIsUsed() {
		return this.isUsed;
	}

}