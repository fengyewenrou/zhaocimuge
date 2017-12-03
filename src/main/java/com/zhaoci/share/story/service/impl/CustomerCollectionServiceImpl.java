package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.CustomerCollectionDao;
import com.zhaoci.share.story.po.CustomerCollection;
import com.zhaoci.share.story.service.CustomerCollectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("customerCollection")
public class CustomerCollectionServiceImpl implements CustomerCollectionService {
	@Resource(name="customerCollectionDao")
	private CustomerCollectionDao customerCollectionDao;
	
	@Override
	public List<CustomerCollection> selectList(CustomerCollection customerCollection) {
		return customerCollectionDao.selectList(customerCollection);
	}

	@Override
	public Page<CustomerCollection> queryListPage(Page<CustomerCollection> page) {
	    page.setResultList(customerCollectionDao.queryListPage(page));
		return page;
	}
	
	@Override
	public CustomerCollection queryById(Integer id) {
		return customerCollectionDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(CustomerCollection customerCollection) {
		customerCollectionDao.insert(customerCollection);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		customerCollectionDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(CustomerCollection customerCollection) {
		customerCollectionDao.update(customerCollection);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<CustomerCollection> customerCollectionList) {
		customerCollectionDao.batchUpdate(customerCollectionList);
	}
}