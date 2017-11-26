package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.TaleTypeDao;
import com.zhaoci.share.story.po.TaleType;
import com.zhaoci.share.story.service.TaleTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("taleType")
public class TaleTypeServiceImpl implements TaleTypeService {
	@Resource(name="taleTypeDao")
	private TaleTypeDao taleTypeDao;
	
	@Override
	public List<TaleType> selectList(TaleType taleType) {
		return taleTypeDao.selectList(taleType);
	}

	@Override
	public Page<TaleType> queryListPage(Page<TaleType> page) {
	    page.setResultList(taleTypeDao.queryListPage(page));
		return page;
	}
	
	@Override
	public TaleType queryById(Integer id) {
		return taleTypeDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(TaleType taleType) {
		taleTypeDao.insert(taleType);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		taleTypeDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(TaleType taleType) {
		taleTypeDao.update(taleType);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<TaleType> taleTypeList) {
		taleTypeDao.batchUpdate(taleTypeList);
	}
}