package com.zhaoci.share.timeline.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.timeline.po.Timeline;

import java.util.List;

public interface TimelineService {

	List<Timeline> selectList(Timeline timeline);
	
	Page<Timeline> queryListPage(Page<Timeline> page);
	
	Timeline queryById(Integer id);
	
	void add(Timeline timeline);

	void delete(Integer id);
	
	void update(Timeline timeline);
	
	void batchUpdate(List<Timeline> timelineList);
}