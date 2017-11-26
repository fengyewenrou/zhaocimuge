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
	private  String createDate;

	/**  */
	private String updateDate;

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

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


}