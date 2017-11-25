package com.zhaoci.share.user.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.po.Menu;

import java.util.List;

public interface MenuService {
	List<Menu> queryByPower(Menu menu);

	List<Menu> selectList(Menu menu);
	
	Page<Menu> queryListPage(Page<Menu> page);
	
	Menu queryById(Integer id);

	void add(Menu menu);

	void delete(Integer id);
	
	void update(Menu menu);
	
	void batchUpdate(List<Menu> menuList);
	Integer queryBySort();
	Integer querySunBySort(String parentCode);
}