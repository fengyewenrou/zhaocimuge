package com.zhaoci.share.story.tale.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.tale.po.Tale;

import java.util.List;

public interface TaleService {

	List<Tale> selectList(Tale tale);
	
	Page<Tale> queryListPage(Page<Tale> page);
	
	Tale queryById(Integer id);
	
	void add(Tale tale);

	void delete(Integer id);
	
	void update(Tale tale);
	
	void batchUpdate(List<Tale> taleList);
}