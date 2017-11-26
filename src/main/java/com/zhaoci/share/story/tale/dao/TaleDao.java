package com.zhaoci.share.story.tale.dao;

import java.util.List;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.tale.po.Tale;

public interface TaleDao extends IMybatisBaseDao<Tale> {
    
    void batchUpdate(List<Tale> taleList);
}