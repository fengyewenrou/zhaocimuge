package com.zhaoci.framework.mybatis.dao;

import java.io.Serializable;
import java.util.List;

import com.zhaoci.framework.base.page.Page;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */
public interface IMybatisBaseDao<T extends Serializable> {

	/**
	 * 根据主键ID查询信息
	 * @param id 主键ID
	 * @return
	 */
	T queryById(Serializable id);

	/** 
	 * @param entity
	 * @return
	 */ 
	List<T> selectList(T entity);

	/**
	 * 查询分页列表
	 * @param page 分页参数信息
	 * @return 分页列表
	 */
	List<T> queryListPage(Page<T> page);

	/**
	 * 插入信息
	 * @param entity 插入学生信息
	 * @return
	 */
	int insert(T entity);

	/** 
	 * @param entity
	 * @return
	 */ 
	int update(T entity);

	/** 
	 * @param id
	 * @return
	 */ 
	int delete(Serializable id);

}