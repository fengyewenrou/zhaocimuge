package com.zhaoci.share.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.service.InviteCodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoci.share.user.dao.InviteCodeDao;
import com.zhaoci.share.user.po.InviteCode;

@DataSource(DataSourceEnum.MASTER)
@Service("inviteCode")
public class InviteCodeServiceImpl implements InviteCodeService {
	@Resource(name="inviteCodeDao")
	private InviteCodeDao inviteCodeDao;
	
	@Override
	public List<InviteCode> selectList(InviteCode inviteCode) {
		return inviteCodeDao.selectList(inviteCode);
	}

	@Override
	public Page<InviteCode> queryListPage(Page<InviteCode> page) {
	    page.setResultList(inviteCodeDao.queryListPage(page));
		return page;
	}
	
	@Override
	public InviteCode queryById(Integer id) {
		return inviteCodeDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(InviteCode inviteCode) {
		inviteCodeDao.insert(inviteCode);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		inviteCodeDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(InviteCode inviteCode) {
		inviteCodeDao.update(inviteCode);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<InviteCode> inviteCodeList) {
		inviteCodeDao.batchUpdate(inviteCodeList);
	}
}