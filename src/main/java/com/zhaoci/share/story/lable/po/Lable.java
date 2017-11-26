package com.zhaoci.share.story.lable.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class Lable implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/** 标签 */
	private String lable;

	/**  */
	private String createDate;

	/** 是否可用，1是0否 */
	private String isUsed;

	/**  */
	private String reserve01;

	/**  */
	private String reserve02;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}
	
	public String getLable() {
		return this.lable;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	public String getIsUsed() {
		return this.isUsed;
	}

	public void setReserve01(String reserve01) {
		this.reserve01 = reserve01;
	}
	
	public String getReserve01() {
		return this.reserve01;
	}

	public void setReserve02(String reserve02) {
		this.reserve02 = reserve02;
	}
	
	public String getReserve02() {
		return this.reserve02;
	}

}