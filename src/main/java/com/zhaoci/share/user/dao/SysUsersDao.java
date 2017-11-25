package com.zhaoci.share.user.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.SysUsers;

import java.util.List;

public interface SysUsersDao extends IMybatisBaseDao<SysUsers> {
    
    void batchUpdate(List<SysUsers> sysUsersList);
    
    List<SysUsers> queryUserRoleByAccount(String userAccount);
    
    List<SysUsers> queryUserByRole(String roleId);
}