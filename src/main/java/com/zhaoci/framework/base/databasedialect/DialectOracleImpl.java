package com.zhaoci.framework.base.databasedialect;

import com.zhaoci.framework.base.page.Page;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */ 
public class DialectOracleImpl implements IDialect {

	/**
	 * 获取Oracle数据库的分页查询语句
	 * 
	 * @param page
	 *            分页对象
	 * @param sql
	 *            原sql语句
	 * @return Oracle数据库分页语句
	 */
	@Override
	public String getPageSql(Page<?> page, String sql) {
		// 计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
		long offset = (page.getCurrentPage() - 1) * page.getPageSize() + 1;
		String pageSql = "select * from (select t.*, rownum r from (" + sql
				+ ") t where rownum < " + (offset + page.getPageSize())
				+ ") where r >= " + offset;
		return pageSql;
	}

}
