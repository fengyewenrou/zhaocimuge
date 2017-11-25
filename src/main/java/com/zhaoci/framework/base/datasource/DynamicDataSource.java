package com.zhaoci.framework.base.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源抽象实现类(获取数据源对应的key) 
 * @author fanfuchen
 * @date 2016-1-2
 */ 
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getDataSourceKey();
	}
}
