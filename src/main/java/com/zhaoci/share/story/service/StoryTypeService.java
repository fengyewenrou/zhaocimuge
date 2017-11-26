package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.StoryType;

import java.util.List;

public interface StoryTypeService {

	List<StoryType> selectList(StoryType storyType);
	
	Page<StoryType> queryListPage(Page<StoryType> page);
	
	StoryType queryById(Integer id);
	
	void add(StoryType storyType);

	void delete(Integer id);
	
	void update(StoryType storyType);
	
	void batchUpdate(List<StoryType> storyTypeList);
}