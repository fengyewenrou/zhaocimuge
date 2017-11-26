package com.zhaoci.share.story.lable.dao;


import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.lable.po.Lable;

import java.util.List;

public interface LableDao extends IMybatisBaseDao<Lable> {
    
    void batchUpdate(List<Lable> lableList);
}