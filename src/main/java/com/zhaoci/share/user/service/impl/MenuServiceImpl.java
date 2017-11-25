package com.zhaoci.share.user.service.impl;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.dao.MenuDao;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DataSource(DataSourceEnum.MASTER)
@Service("menu")
public class MenuServiceImpl implements MenuService {
	@Resource(name="menuDao")
	private MenuDao menuDao;

	@Override
	public List<Menu> queryByPower(Menu menu){
		return menuDao.queryByPower(menu);
	}
	
	@Override
	public List<Menu> selectList(Menu menu) {
		return menuDao.selectList(menu);
	}

	@Override
	public Page<Menu> queryListPage(Page<Menu> page) {
	    page.setResultList(menuDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Menu queryById(Integer id) {
		return menuDao.queryById(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Menu menu) {
		menuDao.insert(menu);
	}
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		menuDao.delete(id);
	}
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Menu menu) {
		menuDao.update(menu);
	}

  @Override
  @Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Menu> menuList) {
		menuDao.batchUpdate(menuList);
	}

	@Override
	public Integer queryBySort() {
		return menuDao.queryBySort();
	}

	@Override
	public Integer querySunBySort(String parentCode) {
		return menuDao.querySunBySort(parentCode);
	}
}