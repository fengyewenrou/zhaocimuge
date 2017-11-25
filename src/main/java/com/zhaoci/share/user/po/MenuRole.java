package com.zhaoci.share.user.po;

import java.io.Serializable;

public class MenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/** 菜单编号  */
	private String menuCode;

	/** 角色名称 */
	private String roleName;

	/** 角色权限  */
	private String rolePower;

	/** 备注 */
	private String memo;

	/** 是否可用 */
	private String isUsed;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public String getRolePower() {
		return this.rolePower;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getIsUsed() {
		return this.isUsed;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}