package com.zhaoci.share.user.dao;


import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.po.MenuRole;

import java.util.List;

public interface MenuRoleDao extends IMybatisBaseDao<MenuRole> {
    
    void batchUpdate(List<MenuRole> menuRoleList);

    List<Menu> menuJoinMenuRole(MenuRole menuRole);

    List<Menu> menuJoinMenuRole2(MenuRole menuRole);
    List<Menu> menuJoinMenuRole3(MenuRole menuRole);
    List<Menu> menuJoinMenuRole4(MenuRole menuRole);
}