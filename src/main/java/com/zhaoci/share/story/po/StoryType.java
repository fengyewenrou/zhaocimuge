package com.zhaoci.share.story.po;

import java.io.Serializable;

public class StoryType implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String typeName;

	/**  */
	private String typeDesc;

	/**  */
	private String isUsed;

	/**  */
	private String createDate;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	public String getTypeDesc() {
		return this.typeDesc;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	public String getIsUsed() {
		return this.isUsed;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}