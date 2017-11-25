package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.SysUsersRoles;

import java.util.List;

public interface SysUsersRolesService {

	List<SysUsersRoles> selectList(SysUsersRoles sysUsersRoles);
	
	Page<SysUsersRoles> queryListPage(Page<SysUsersRoles> page);
	
	SysUsersRoles queryById(Integer id);
	
	void add(SysUsersRoles sysUsersRoles);

	void delete(Integer id);
	void del(String id);
	void del2(String id);
	void update(SysUsersRoles sysUsersRoles);
	
	void batchUpdate(List<SysUsersRoles> sysUsersRolesList);
}