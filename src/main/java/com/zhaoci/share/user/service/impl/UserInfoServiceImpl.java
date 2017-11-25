package com.zhaoci.share.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoci.share.user.dao.UserInfoDao;
import com.zhaoci.share.user.po.UserInfo;
import com.zhaoci.share.user.service.UserInfoService;
import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;

@DataSource(DataSourceEnum.MASTER)
@Service("userInfo")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource(name="userInfoDao")
	private UserInfoDao userInfoDao;
	
	@Override
	public List<UserInfo> selectList(UserInfo userInfo) {
		return userInfoDao.selectList(userInfo);
	}

	@Override
	public Page<UserInfo> queryListPage(Page<UserInfo> page) {
	    page.setResultList(userInfoDao.queryListPage(page));
		return page;
	}
	
	@Override
	public UserInfo queryById(Integer id) {
		return userInfoDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(UserInfo userInfo) {
		userInfoDao.insert(userInfo);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		userInfoDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(UserInfo userInfo) {
		userInfoDao.update(userInfo);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<UserInfo> userInfoList) {
		userInfoDao.batchUpdate(userInfoList);
	}
}