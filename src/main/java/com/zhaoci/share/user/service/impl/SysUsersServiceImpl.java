package com.zhaoci.share.user.service.impl;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.dao.SysUsersDao;
import com.zhaoci.share.user.po.SysUsers;
import com.zhaoci.share.user.service.SysUsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DataSource(DataSourceEnum.MASTER)
@Service("sysUsersService")
public class SysUsersServiceImpl implements SysUsersService {
	@Resource(name="sysUsersDao")
	private SysUsersDao sysUsersDao;
	
	@Override
	public List<SysUsers> selectList(SysUsers sysUsers) {
		return sysUsersDao.selectList(sysUsers);
	}

	@Override
	public List<SysUsers> queryUserRoleByAccount(String userAccount){
		return sysUsersDao.queryUserRoleByAccount(userAccount);
	}
	@Override
	public List<SysUsers> queryUserByRole(String roleId){
		return sysUsersDao.queryUserByRole(roleId);
	}
	@Override
	public Page<SysUsers> queryListPage(Page<SysUsers> page) {
	    page.setResultList(sysUsersDao.queryListPage(page));
		return page;
	}
	
	@Override
	public SysUsers queryById(String id) {
		return sysUsersDao.queryById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(SysUsers sysUsers) {
		sysUsersDao.insert(sysUsers);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(String id) {
		sysUsersDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(SysUsers sysUsers) {
		sysUsersDao.update(sysUsers);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<SysUsers> sysUsersList) {
		sysUsersDao.batchUpdate(sysUsersList);
	}
  

}