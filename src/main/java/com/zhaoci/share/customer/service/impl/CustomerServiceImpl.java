package com.zhaoci.share.customer.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoci.share.customer.dao.CustomerDao;
import com.zhaoci.share.customer.po.Customer;
import com.zhaoci.share.customer.service.CustomerService;
import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;

@DataSource(DataSourceEnum.MASTER)
@Service("customer")
public class CustomerServiceImpl implements CustomerService {
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> selectList(Customer customer) {
		return customerDao.selectList(customer);
	}

	@Override
	public Page<Customer> queryListPage(Page<Customer> page) {
	    page.setResultList(customerDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Customer queryById(Integer id) {
		return customerDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Customer customer) {
		customerDao.insert(customer);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		customerDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Customer customer) {
		customerDao.update(customer);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Customer> customerList) {
		customerDao.batchUpdate(customerList);
	}

	@Override
	public List<Customer> queryListByExcel(Map<String, String> map) {
		return customerDao.queryListByExcel(map);
	}
}