package com.zhaoci.share.story.tale.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.main.MainController;
import com.zhaoci.share.story.tale.po.Tale;

public interface TaleDao extends IMybatisBaseDao<Tale> {
    
    void batchUpdate(List<Tale> taleList);
    List<Tale> queryListPage2(Page<Tale> page);
    Map<String,Object> queryById2(Integer id);
    List<Tale> todatRecommend(String date);
}