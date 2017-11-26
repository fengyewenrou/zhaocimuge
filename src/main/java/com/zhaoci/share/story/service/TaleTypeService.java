package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.TaleType;

import java.util.List;

public interface TaleTypeService {

	List<TaleType> selectList(TaleType taleType);
	
	Page<TaleType> queryListPage(Page<TaleType> page);
	
	TaleType queryById(Integer id);
	
	void add(TaleType taleType);

	void delete(Integer id);
	
	void update(TaleType taleType);
	
	void batchUpdate(List<TaleType> taleTypeList);
}