package com.zhaoci.share.user.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.SysRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysRolesDao extends IMybatisBaseDao<SysRoles> {
    
    void batchUpdate(List<SysRoles> sysRolesList);
    List<SysRoles> queryList(@Param("roleId") String roleId, @Param("userId") String userId);
    List<SysRoles> queryListRoles(Map<String, Object> map);
    List<SysRoles> queryListRoles2(Map<String, Object> map);
    List<SysRoles> selectListRoles(String userId);
}