package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.StoryType;

import java.util.List;


public interface StoryTypeDao extends IMybatisBaseDao<StoryType> {
    
    void batchUpdate(List<StoryType> storyTypeList);
}