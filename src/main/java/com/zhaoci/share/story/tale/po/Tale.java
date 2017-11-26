package com.zhaoci.share.story.tale.po;

import java.io.Serializable;

public class Tale implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/** 标题 */
	private String title;

	/** 标签 */
	private String label;

	/** 内容 */
	private String content;

	/** 图片 */
	private String image;

	/** 创建时间 */
	private String createDate;

	/** 修改时间 */
	private String updateDate;

	/** 作者 */
	private String writer;

	/** 分类 */
	private String assortment;

	/** 备注 */
	private String remarks;

	/** 用户id */
	private String customerId;

	/**  */
	private String reserve01;

	/**  */
	private String reserve02;

	/**  */
	private String reserve03;

	/**  */
	private String reserve04;

	/**  */
	private String reserve05;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return this.image;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriter() {
		return this.writer;
	}

	public void setAssortment(String assortment) {
		this.assortment = assortment;
	}
	
	public String getAssortment() {
		return this.assortment;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return this.customerId;
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

	public void setReserve03(String reserve03) {
		this.reserve03 = reserve03;
	}
	
	public String getReserve03() {
		return this.reserve03;
	}

	public void setReserve04(String reserve04) {
		this.reserve04 = reserve04;
	}
	
	public String getReserve04() {
		return this.reserve04;
	}

	public void setReserve05(String reserve05) {
		this.reserve05 = reserve05;
	}
	
	public String getReserve05() {
		return this.reserve05;
	}

}