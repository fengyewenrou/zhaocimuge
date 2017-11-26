package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.StoryTypeDao;
import com.zhaoci.share.story.po.StoryType;
import com.zhaoci.share.story.service.StoryTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("storyType")
public class StoryTypeServiceImpl implements StoryTypeService {
	@Resource(name="storyTypeDao")
	private StoryTypeDao storyTypeDao;
	
	@Override
	public List<StoryType> selectList(StoryType storyType) {
		return storyTypeDao.selectList(storyType);
	}

	@Override
	public Page<StoryType> queryListPage(Page<StoryType> page) {
	    page.setResultList(storyTypeDao.queryListPage(page));
		return page;
	}
	
	@Override
	public StoryType queryById(Integer id) {
		return storyTypeDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(StoryType storyType) {
		storyTypeDao.insert(storyType);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		storyTypeDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(StoryType storyType) {
		storyTypeDao.update(storyType);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<StoryType> storyTypeList) {
		storyTypeDao.batchUpdate(storyTypeList);
	}
}