package com.zhaoci.share.user.dao;

import java.util.List;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.user.po.InviteCode;

public interface InviteCodeDao extends IMybatisBaseDao<InviteCode> {
    
    void batchUpdate(List<InviteCode> inviteCodeList);
}