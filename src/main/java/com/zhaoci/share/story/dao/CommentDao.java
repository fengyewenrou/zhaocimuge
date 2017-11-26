package com.zhaoci.share.story.dao;

import com.zhaoci.framework.mybatis.dao.IMybatisBaseDao;
import com.zhaoci.share.story.po.Comment;

import java.util.List;


public interface CommentDao extends IMybatisBaseDao<Comment> {
    
    void batchUpdate(List<Comment> commentList);
}