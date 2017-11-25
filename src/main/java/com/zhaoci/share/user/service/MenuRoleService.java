package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.po.MenuRole;
import com.zhaoci.share.user.po.SysRoles;

import java.util.List;

public interface MenuRoleService {

	List<MenuRole> selectList(MenuRole menuRole);
	
	Page<MenuRole> queryListPage(Page<MenuRole> page);
	
	MenuRole queryById(Integer id);

	void add(MenuRole menuRole);

	void delete(Integer id);
	
	void update(MenuRole menuRole);
	
	void batchUpdate(List<MenuRole> menuRoleList);
	void updateRoleV2(List<Menu> menuList, List<String> checkedMenuCodeArray, SysRoles roles);

	List<Menu> menuJoinMenuRole(MenuRole menuRole);

	List<Menu> menuJoinMenuRole2(MenuRole menuRole);
	List<Menu> menuJoinMenuRole3(MenuRole menuRole);
	List<Menu> menuJoinMenuRole4(MenuRole menuRole);
}