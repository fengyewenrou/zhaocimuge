package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.CustomerCollection;

import java.util.List;

public interface CustomerCollectionService {

	List<CustomerCollection> selectList(CustomerCollection customerCollection);
	
	Page<CustomerCollection> queryListPage(Page<CustomerCollection> page);
	
	CustomerCollection queryById(Integer id);
	
	void add(CustomerCollection customerCollection);

	void delete(Integer id);
	
	void update(CustomerCollection customerCollection);
	
	void batchUpdate(List<CustomerCollection> customerCollectionList);
}