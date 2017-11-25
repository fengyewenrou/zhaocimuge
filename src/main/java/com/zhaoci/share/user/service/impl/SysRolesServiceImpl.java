package com.zhaoci.share.user.service.impl;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.dao.SysRolesDao;
import com.zhaoci.share.user.po.SysRoles;
import com.zhaoci.share.user.service.SysRolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@DataSource(DataSourceEnum.MASTER)
@Service("sysRolesService")
public class SysRolesServiceImpl implements SysRolesService {
	@Resource(name="sysRolesDao")
	private SysRolesDao sysRolesDao;
	
	@Override
	public List<SysRoles> selectList(SysRoles sysRoles) {
		return sysRolesDao.selectList(sysRoles);
	}

	@Override
	public Page<SysRoles> queryListPage(Page<SysRoles> page) {
	    page.setResultList(sysRolesDao.queryListPage(page));
		return page;
	}
	
	@Override
	public SysRoles queryById(String id) {
		return sysRolesDao.queryById(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(SysRoles sysRoles) {
		sysRolesDao.insert(sysRoles);
	}
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(String id) {
		sysRolesDao.delete(id);
	}
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(SysRoles sysRoles) {
		sysRolesDao.update(sysRoles);
	}

  @Override
  @Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<SysRoles> sysRolesList) {
		sysRolesDao.batchUpdate(sysRolesList);
	}

	@Override
	public List<SysRoles> queryList(String roleId,String userId) {
		return sysRolesDao.queryList(roleId,userId);
	}

	@Override
	public List<SysRoles> queryListRoles(Map<String,Object> map) {
		return sysRolesDao.queryListRoles(map);
	}

	@Override
	public List<SysRoles> selectListRoles(String userId) {
		return sysRolesDao.selectListRoles(userId);
	}

	@Override
	public List<SysRoles> queryListRoles2( Map<String,Object> map) {
		return sysRolesDao.queryListRoles2(map);
	}
}