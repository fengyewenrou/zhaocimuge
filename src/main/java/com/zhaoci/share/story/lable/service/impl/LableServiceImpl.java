package com.zhaoci.share.story.lable.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.lable.dao.LableDao;
import com.zhaoci.share.story.lable.po.Lable;
import com.zhaoci.share.story.lable.service.LableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("lable")
public class LableServiceImpl implements LableService {
	@Resource(name="lableDao")
	private LableDao lableDao;
	
	@Override
	public List<Lable> selectList(Lable lable) {
		return lableDao.selectList(lable);
	}

	@Override
	public Page<Lable> queryListPage(Page<Lable> page) {
	    page.setResultList(lableDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Lable queryById(Integer id) {
		return lableDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Lable lable) {
		lableDao.insert(lable);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		lableDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Lable lable) {
		lableDao.update(lable);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Lable> lableList) {
		lableDao.batchUpdate(lableList);
	}
}