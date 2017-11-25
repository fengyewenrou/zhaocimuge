package com.zhaoci.share.timeline.po;

import java.io.Serializable;

public class Timeline implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String title;

	/**  */
	private String content;

	/**  */
	private java.util.Date createTime;

	/**  */
	private String icon;
	private long timeDifference;
	private long timeDifference2;

	public long getTimeDifference2() {
		return timeDifference2;
	}

	public void setTimeDifference2(long timeDifference2) {
		this.timeDifference2 = timeDifference2;
	}

	public long getTimeDifference() {
		return timeDifference;
	}

	public void setTimeDifference(long timeDifference) {
		this.timeDifference = timeDifference;
	}

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

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return this.icon;
	}

}