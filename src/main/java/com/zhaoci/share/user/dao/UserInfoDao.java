package com.zhaoci.share.user.dao;

import java.util.List;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.UserInfo;

public interface UserInfoDao extends IMybatisBaseDao<UserInfo> {
    
    void batchUpdate(List<UserInfo> userInfoList);
}