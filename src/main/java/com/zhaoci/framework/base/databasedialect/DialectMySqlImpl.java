package com.zhaoci.framework.base.databasedialect;

import com.zhaoci.framework.base.page.Page;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */ 
public class DialectMySqlImpl implements IDialect {

	/**
	 * 获取Mysql数据库的分页查询语句
	 * 
	 * @param page
	 *            分页对象
	 * @param sql
	 *            原sql语句
	 * @return Mysql数据库分页语句
	 */
	@Override
	public String getPageSql(Page<?> page, String sql) {
		//计算第一条记录的位置，Mysql中记录的位置是从0开始的。  
		long offset = (page.getCurrentPage() - 1) * page.getPageSize(); 
		return sql+" limit "+offset+","+page.getPageSize();
	}

}
