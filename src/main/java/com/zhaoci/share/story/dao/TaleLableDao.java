package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.TaleLable;

import java.util.List;


public interface TaleLableDao extends IMybatisBaseDao<TaleLable> {
    
    void batchUpdate(List<TaleLable> taleLableList);
}