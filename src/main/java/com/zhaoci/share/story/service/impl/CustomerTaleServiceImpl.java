package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.CustomerTaleDao;
import com.zhaoci.share.story.po.CustomerTale;
import com.zhaoci.share.story.service.CustomerTaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("customerTale")
public class CustomerTaleServiceImpl implements CustomerTaleService {
	@Resource(name="customerTaleDao")
	private CustomerTaleDao customerTaleDao;
	
	@Override
	public List<CustomerTale> selectList(CustomerTale customerTale) {
		return customerTaleDao.selectList(customerTale);
	}

	@Override
	public Page<CustomerTale> queryListPage(Page<CustomerTale> page) {
	    page.setResultList(customerTaleDao.queryListPage(page));
		return page;
	}
	
	@Override
	public CustomerTale queryById(Integer id) {
		return customerTaleDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(CustomerTale customerTale) {
		customerTaleDao.insert(customerTale);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		customerTaleDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(CustomerTale customerTale) {
		customerTaleDao.update(customerTale);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<CustomerTale> customerTaleList) {
		customerTaleDao.batchUpdate(customerTaleList);
	}
}