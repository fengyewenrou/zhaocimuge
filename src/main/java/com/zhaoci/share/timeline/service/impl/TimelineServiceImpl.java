package com.zhaoci.share.timeline.service.impl;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.timeline.dao.TimelineDao;
import com.zhaoci.share.timeline.po.Timeline;
import com.zhaoci.share.timeline.service.TimelineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataSource(DataSourceEnum.MASTER)
@Service("timeline")
public class TimelineServiceImpl implements TimelineService {

	@Resource(name="timelineDao")
	private TimelineDao timelineDao;
	
	@Override
	public List<Timeline> selectList(Timeline timeline) {
		return timelineDao.selectList(timeline);
	}

	@Override
	public Page<Timeline> queryListPage(Page<Timeline> page) {
	    page.setResultList(timelineDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Timeline queryById(Integer id) {
		return timelineDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Timeline timeline) {
		timelineDao.insert(timeline);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		timelineDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Timeline timeline) {
		timelineDao.update(timeline);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Timeline> timelineList) {
		timelineDao.batchUpdate(timelineList);
	}
}