package com.zhaoci.share.customer.dao;

import java.util.List;
import java.util.Map;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.customer.po.Customer;

public interface CustomerDao extends IMybatisBaseDao<Customer> {
    
    void batchUpdate(List<Customer> customerList);
    List<Customer> queryListByExcel(Map<String,String> map);
}