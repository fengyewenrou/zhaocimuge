package com.zhaoci.share.user.po;

import java.io.Serializable;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/** 菜单编号  */
	private String menuCode;

	/** 菜单名称  */
	private String menuName;

	/** 菜单图标  */
	private String icon;

	/** 层级 */
	private String levels;

	/** 地址 */
	private String urls;

	/** 排序 */
	private String sort;

	/** 备注 */
	private String memo;

	/** 父节点 */
	private String parentCode;

	/** 是否节点 */
	private String isLeaf;

	/** 是否可用 */
	private String isUsed;

	/** 角色权限  */
	private String rolePower;

	private MenuRole menuRole;

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

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getLevels() {
		return this.levels;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getUrls() {
		return this.urls;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return this.sort;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getIsUsed() {
		return this.isUsed;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public String getRolePower() {
		return this.rolePower;
	}

	public MenuRole getMenuRole() {
		return menuRole;
	}

	public void setMenuRole(MenuRole menuRole) {
		this.menuRole = menuRole;
	}
}