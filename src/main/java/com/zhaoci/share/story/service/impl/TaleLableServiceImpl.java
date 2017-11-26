package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.TaleLableDao;
import com.zhaoci.share.story.po.TaleLable;
import com.zhaoci.share.story.service.TaleLableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("taleLable")
public class TaleLableServiceImpl implements TaleLableService {
	@Resource(name="taleLableDao")
	private TaleLableDao taleLableDao;
	
	@Override
	public List<TaleLable> selectList(TaleLable taleLable) {
		return taleLableDao.selectList(taleLable);
	}

	@Override
	public Page<TaleLable> queryListPage(Page<TaleLable> page) {
	    page.setResultList(taleLableDao.queryListPage(page));
		return page;
	}
	
	@Override
	public TaleLable queryById(Integer id) {
		return taleLableDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(TaleLable taleLable) {
		taleLableDao.insert(taleLable);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		taleLableDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(TaleLable taleLable) {
		taleLableDao.update(taleLable);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<TaleLable> taleLableList) {
		taleLableDao.batchUpdate(taleLableList);
	}
}