package com.zhaoci.share.story.tale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoci.share.story.tale.dao.TaleDao;
import com.zhaoci.share.story.tale.po.Tale;
import com.zhaoci.share.story.tale.service.TaleService;

@DataSource(DataSourceEnum.MASTER)
@Service("tale")
public class TaleServiceImpl implements TaleService {
	@Resource(name="taleDao")
	private TaleDao taleDao;
	
	@Override
	public List<Tale> selectList(Tale tale) {
		return taleDao.selectList(tale);
	}

	@Override
	public Page<Tale> queryListPage(Page<Tale> page) {
	    page.setResultList(taleDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Tale queryById(Integer id) {
		return taleDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Tale tale) {
		taleDao.insert(tale);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		taleDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Tale tale) {
		taleDao.update(tale);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Tale> taleList) {
		taleDao.batchUpdate(taleList);
	}
}