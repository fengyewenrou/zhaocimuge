package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.SysUsers;

import java.util.List;

public interface SysUsersService {

	List<SysUsers> selectList(SysUsers sysUsers);
	
	Page<SysUsers> queryListPage(Page<SysUsers> page);
	
	SysUsers queryById(String id);

	void add(SysUsers sysUsers);

	void delete(String id);
	
	void update(SysUsers sysUsers);
	
	void batchUpdate(List<SysUsers> sysUsersList);
	
	List<SysUsers> queryUserRoleByAccount(String userAccount);
	
	List<SysUsers> queryUserByRole(String roleId);
}