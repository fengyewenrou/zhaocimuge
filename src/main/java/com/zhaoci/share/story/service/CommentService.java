package com.zhaoci.share.story.service;


import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.po.Comment;

import java.util.List;

public interface CommentService {

	List<Comment> selectList(Comment comment);
	
	Page<Comment> queryListPage(Page<Comment> page);
	
	Comment queryById(Integer id);
	
	void add(Comment comment);

	void delete(Integer id);
	
	void update(Comment comment);
	
	void batchUpdate(List<Comment> commentList);
}