package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.CustomerCollection;

import java.util.List;


public interface CustomerCollectionDao extends IMybatisBaseDao<CustomerCollection> {
    
    void batchUpdate(List<CustomerCollection> customerCollectionList);
}