package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.TaleType;

import java.util.List;

public interface TaleTypeDao extends IMybatisBaseDao<TaleType> {
    
    void batchUpdate(List<TaleType> taleTypeList);
}