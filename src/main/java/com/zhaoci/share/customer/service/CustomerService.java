package com.zhaoci.share.customer.service;

import com.zhaoci.share.customer.po.Customer;

import java.util.List;
import java.util.Map;

import com.zhaoci.framework.base.page.Page;

public interface CustomerService {

	List<Customer> selectList(Customer customer);
	
	Page<Customer> queryListPage(Page<Customer> page);
	
	Customer queryById(Integer id);
	
	void add(Customer customer);

	void delete(Integer id);
	
	void update(Customer customer);
	
	void batchUpdate(List<Customer> customerList);
	List<Customer> queryListByExcel(Map<String,String> map);
}