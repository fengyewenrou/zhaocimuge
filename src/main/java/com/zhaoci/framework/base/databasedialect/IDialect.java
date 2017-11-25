package com.zhaoci.framework.base.databasedialect;

import com.zhaoci.framework.base.page.Page;

/**
 * 数据库对象
 * @author fanfuchen
 * @date 2016-1-2
 */ 
public interface IDialect {
	/**
	 * 分页脚本
	 * @param page
	 * @param sql
	 * @return 分页脚本
	 */
	public String getPageSql(Page<?> page,String sql);
}
