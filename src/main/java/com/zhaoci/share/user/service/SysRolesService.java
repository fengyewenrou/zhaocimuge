package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.SysRoles;

import java.util.List;
import java.util.Map;

public interface SysRolesService {

	List<SysRoles> selectList(SysRoles sysRoles);
	
	Page<SysRoles> queryListPage(Page<SysRoles> page);
	
	SysRoles queryById(String id);

	void add(SysRoles sysRoles);

	void delete(String id);
	
	void update(SysRoles sysRoles);
	
	void batchUpdate(List<SysRoles> sysRolesList);
	List<SysRoles> queryList(String roleId, String userId);
	List<SysRoles> queryListRoles(Map<String, Object> map);
	List<SysRoles> selectListRoles(String userId);
	List<SysRoles> queryListRoles2(Map<String, Object> map);
}