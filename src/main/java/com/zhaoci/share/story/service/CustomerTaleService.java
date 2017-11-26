package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.CustomerTale;

import java.util.List;

public interface CustomerTaleService {

	List<CustomerTale> selectList(CustomerTale customerTale);
	
	Page<CustomerTale> queryListPage(Page<CustomerTale> page);
	
	CustomerTale queryById(Integer id);
	
	void add(CustomerTale customerTale);

	void delete(Integer id);
	
	void update(CustomerTale customerTale);
	
	void batchUpdate(List<CustomerTale> customerTaleList);
}