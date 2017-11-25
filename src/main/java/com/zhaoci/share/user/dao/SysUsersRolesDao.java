package com.zhaoci.share.user.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.SysUsersRoles;

import java.util.List;

public interface SysUsersRolesDao extends IMybatisBaseDao<SysUsersRoles> {
    
    void batchUpdate(List<SysUsersRoles> sysUsersRolesList);
    void del(String id);
    void del2(String userId);
}