package com.zhaoci.share.timeline.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.timeline.po.Timeline;

import java.util.List;


public interface TimelineDao extends IMybatisBaseDao<Timeline> {
    
    void batchUpdate(List<Timeline> timelineList);
}