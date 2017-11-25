package com.zhaoci.share.user.po;

import java.io.Serializable;
import java.util.List;

public class SysUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  */
	private String userId;

	/**  */
	private String userAccount;

	/**  */
	private String userName;

	/** 该密码是经加盐值加密的，格式为password{username}。 比如用户的密码为user，用户名为user，那么通过MD5进行加密的串为： user{user} */
	private String userPassword;

	/**  */
	private String userDesc;

	/**  */
	private Integer enabled;

	/** 是否是超级用户 */
	private Integer issys;

	/** 所在单位 */
	private String userDept;

	/** 经理或主任 */
	private String userDuty;

	/** 该用户所负责的各子系统，可多个，中间用逗号分隔。 */
	private String subSystem;
	private String module;
	private String roleId;
	private String roleName;
	private List<Menu> menuMap;
	private List<SysRoles> sysRolesList;


	private String photo;
	private String sex;
	private String age;
	private String address;
	private String email;
	private String mobile;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<Menu> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(List<Menu> menuMap) {
		this.menuMap = menuMap;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserDesc() {
		return this.userDesc;
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

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getUserDept() {
		return this.userDept;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	public String getUserDuty() {
		return this.userDuty;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public String getSubSystem() {
		return this.subSystem;
	}

	public List<SysRoles> getSysRolesList() {
		return sysRolesList;
	}

	public void setSysRolesList(List<SysRoles> sysRolesList) {
		this.sysRolesList = sysRolesList;
	}

}