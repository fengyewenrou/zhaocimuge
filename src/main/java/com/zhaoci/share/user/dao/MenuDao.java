package com.zhaoci.share.user.dao;


import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.Menu;

import java.util.List;

public interface MenuDao extends IMybatisBaseDao<Menu> {
    
    void batchUpdate(List<Menu> menuList);
    
    List<Menu> queryByPower(Menu menu);
    Integer queryBySort();
    Integer querySunBySort(String parentCode);
}