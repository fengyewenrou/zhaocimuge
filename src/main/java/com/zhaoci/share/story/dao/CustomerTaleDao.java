package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.CustomerTale;

import java.util.List;


public interface CustomerTaleDao extends IMybatisBaseDao<CustomerTale> {
    
    void batchUpdate(List<CustomerTale> customerTaleList);
}