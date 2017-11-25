package com.zhaoci.framework.base.databasedialect;

import org.apache.commons.lang.StringUtils;

/**
 * @author fanfuchen
 * @date 2016-1-2
 * 
 */ 
public class DialectFactory {

	public static enum DatabaseType {
		MYSQL(DialectMySqlImpl.class), ORACLE(DialectOracleImpl.class);

		private Class<?> clazz;

		private DatabaseType(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getClazz() {
			return clazz;
		}

	}

	public static IDialect factory(String databaseType) {

		try {
			// 验证配置
			if (StringUtils.isEmpty(databaseType))
				throw new IllegalArgumentException("databaseType property is not found!");

			// 根据dialect获取DialectType
			DatabaseType dbType = DatabaseType.valueOf(databaseType.toUpperCase());
			if (dbType == null)
				throw new IllegalArgumentException("databaseType configuration error!");
			Class<?> clazz = dbType.getClazz();
			IDialect instance = (IDialect) clazz.newInstance();
			return instance;
		} catch (InstantiationException e) {
			throw new IllegalArgumentException("dialect configuration error!");
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("dialect configuration error!");
		}
	}
}
