package com.zhaoci.share.user.service.impl;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.dao.SysUsersRolesDao;
import com.zhaoci.share.user.po.SysUsersRoles;
import com.zhaoci.share.user.service.SysUsersRolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DataSource(DataSourceEnum.MASTER)
@Service("sysUsersRoles")
public class SysUsersRolesServiceImpl implements SysUsersRolesService {
	@Resource(name="sysUsersRolesDao")
	private SysUsersRolesDao sysUsersRolesDao;
	
	@Override
	public List<SysUsersRoles> selectList(SysUsersRoles sysUsersRoles) {
		return sysUsersRolesDao.selectList(sysUsersRoles);
	}

	@Override
	public Page<SysUsersRoles> queryListPage(Page<SysUsersRoles> page) {
	    page.setResultList(sysUsersRolesDao.queryListPage(page));
		return page;
	}
	
	@Override
	public SysUsersRoles queryById(Integer id) {
		return sysUsersRolesDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(SysUsersRoles sysUsersRoles) {
		sysUsersRolesDao.insert(sysUsersRoles);
	}
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		sysUsersRolesDao.delete(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void del(String id) {
		sysUsersRolesDao.del(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void del2(String id) {
		sysUsersRolesDao.del2(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(SysUsersRoles sysUsersRoles) {
		sysUsersRolesDao.update(sysUsersRoles);
	}

  @Override
  @Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<SysUsersRoles> sysUsersRolesList) {
		sysUsersRolesDao.batchUpdate(sysUsersRolesList);
	}
}