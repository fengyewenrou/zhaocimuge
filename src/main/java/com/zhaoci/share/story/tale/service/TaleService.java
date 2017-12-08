package com.zhaoci.share.story.tale.service;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.tale.po.Tale;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface TaleService {

	List<Tale> selectList(Tale tale);
	
	Page<Tale> queryListPage(Page<Tale> page);
	Page<Tale> queryListPage2(Page<Tale> page);


	Tale queryById(Integer id);
	Map<String,Object> queryById2(Integer id);
	List<Tale> todatRecommend(String date);
	void add(Tale tale);

	void delete(Integer id);
	
	void update(Tale tale);
	void insertTale(Tale tale);
	void batchUpdate(List<Tale> taleList);
}