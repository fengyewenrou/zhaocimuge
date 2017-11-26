package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.TaleLable;

import java.util.List;

public interface TaleLableService {

	List<TaleLable> selectList(TaleLable taleLable);
	
	Page<TaleLable> queryListPage(Page<TaleLable> page);
	
	TaleLable queryById(Integer id);
	
	void add(TaleLable taleLable);

	void delete(Integer id);
	
	void update(TaleLable taleLable);
	
	void batchUpdate(List<TaleLable> taleLableList);
}