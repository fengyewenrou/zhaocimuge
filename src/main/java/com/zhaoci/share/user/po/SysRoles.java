package com.zhaoci.share.user.po;

import java.io.Serializable;

public class SysRoles implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private String roleId;

	/**  */
	private String roleName;

	/**  */
	private String roleDesc;

	/**  */
	private Integer enabled;

	/**  */
	private Integer issys;
	private String userId;

	/** 所属的子系统，比如平台里面包括10个系统，分别为成本、作业、集输等。 */
	private String module;
	private String authorityId;
	private String authorityName;
	private String authorityDesc;



	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setIssys(Integer issys) {
		this.issys = issys;
	}

	public Integer getIssys() {
		return this.issys;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModule() {
		return this.module;
	}

}