package com.zhaoci.share.story.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.story.dao.CommentDao;
import com.zhaoci.share.story.po.Comment;
import com.zhaoci.share.story.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataSource(DataSourceEnum.MASTER)
@Service("comment")
public class CommentServiceImpl implements CommentService {
	@Resource(name="commentDao")
	private CommentDao commentDao;
	
	@Override
	public List<Comment> selectList(Comment comment) {
		return commentDao.selectList(comment);
	}

	@Override
	public Page<Comment> queryListPage(Page<Comment> page) {
	    page.setResultList(commentDao.queryListPage(page));
		return page;
	}
	
	@Override
	public Comment queryById(Integer id) {
		return commentDao.queryById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void add(Comment comment) {
		commentDao.insert(comment);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void delete(Integer id) {
		commentDao.delete(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void update(Comment comment) {
		commentDao.update(comment);
	}

  @Override
  @Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void batchUpdate(List<Comment> commentList) {
		commentDao.batchUpdate(commentList);
	}
}