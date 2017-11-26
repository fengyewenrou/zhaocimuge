package com.zhaoci.share.story.lable.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.lable.po.Lable;

import java.util.List;

public interface LableService {

	List<Lable> selectList(Lable lable);
	
	Page<Lable> queryListPage(Page<Lable> page);
	
	Lable queryById(Integer id);
	
	void add(Lable lable);

	void delete(Integer id);
	
	void update(Lable lable);
	
	void batchUpdate(List<Lable> lableList);
}