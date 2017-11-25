package com.zhaoci.framework.mybatis.pagination;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhaoci.framework.base.databasedialect.DialectFactory;
import com.zhaoci.framework.base.page.Page;

/** 
 * 
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 
 * 利用拦截器实现Mybatis分页的原理： 
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句是在 
 * Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler
 * 对象的prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把sql语句改成对应的 
 * 分页查询sql语句，之后再调用StatementHandler对象的prepare方法，即调用invocation.proceed()。 
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的sql语句后，把它改为对应的统计语句再利用 
 * Mybatis封装好的参数和设置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。 
 * 
 * @author fanfuchen
 * @date 2016-1-2
 */
@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}) })
public class MyBatisPageInterceptor implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(MyBatisPageInterceptor.class);
	/**
	 * 数据库类型，不同的数据库有不同的分页方法
	 */
	private String databaseType;
	
	/**
	 * 拦截后要执行的方法 
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，  
		//BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，  
		//SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是处理CallableStatement的。 
		//Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，而在RoutingStatementHandler里面拥有一个StatementHandler类型的delegate属性，  
		//RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、PreparedStatementHandler或CallableStatementHandler， 
		//在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。  
		//我们在PageInterceptor类上已经用@Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候  
		//是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。 
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		
		//通过反射获取到当前RoutingStatementHandler对象的delegate属性  
	    StatementHandler delegate = (StatementHandler)ReflectUtils.getFieldValue(handler, "delegate");
	    
	    //获取到当前StatementHandler的 boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了  
	    //RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。  
	    BoundSql boundSql = delegate.getBoundSql();  
	    //logger.info(boundSql.getSql());
	    //拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象  
	    Object obj = boundSql.getParameterObject(); 
	    
	    //这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。  
	    if (obj instanceof Page<?>) {  
	    	logger.info("查询分页被拦截..........................");
	    	Page<?> page = (Page<?>) obj;  
	    	
	    	//通过反射获取delegate父类BaseStatementHandler的mappedStatement属性  
	    	MappedStatement mappedStatement = (MappedStatement)ReflectUtils.getFieldValue(delegate, "mappedStatement");  
	    	
	    	//拦截到的prepare方法参数是一个Connection对象  
	    	Connection connection = (Connection)invocation.getArgs()[0];  
	    	
	    	//获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句  
	    	String sql = boundSql.getSql();  
	    	
	    	//给当前的page参数对象设置总记录数  
	    	this.setTotalRecord(page, mappedStatement, connection); 
	    	
	    	//获取分页Sql语句  
	    	String pageSql = DialectFactory.factory(this.databaseType).getPageSql(page, sql);
	    	
	    	//利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句  
	    	ReflectUtils.setFieldValue(boundSql, "sql", pageSql);  
	    }  
	    return invocation.proceed();  
	}
	
	/**
	 * 给当前的参数对象page设置总记录数 
	 * @param page Mapper映射语句对应的参数对象
	 * @param mappedStatement Mapper映射语句 
	 * @param connection 当前的数据库连接
	 */
	private void setTotalRecord(Page<?> page,  
	           MappedStatement mappedStatement, Connection connection) { 
		//获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。  
	    //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。  
		BoundSql boundSql = mappedStatement.getBoundSql(page);  
		
	    //获取到我们自己写在Mapper映射语句中对应的Sql语句  
	    String sql = boundSql.getSql();  
	    
	    //通过查询Sql语句获取到对应的计算总记录数的sql语句  
	    String countSql;// = "select count(*) from ("+sql+") T";
		try {
			countSql = totalCountParsesql(sql);
		} catch (JSQLParserException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
	    
	    //通过BoundSql获取对应的参数映射  
	    List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
	    
	    //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。  
	    BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);  
	    
	    //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象  
	    ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);  
	    
	    //通过connection建立一个countSql对应的PreparedStatement对象。  
	    PreparedStatement pstmt = null;  
	    ResultSet rs = null;  
	    try {  
	    	pstmt = connection.prepareStatement(countSql);  
	        //通过parameterHandler给PreparedStatement对象设置参数  
	        parameterHandler.setParameters(pstmt);  
	        //之后就是执行获取总记录数的Sql语句和获取结果了。  
	        rs = pstmt.executeQuery();  
	        if (rs.next()) {  
	            //给当前的参数page对象设置总记录数  
	            page.setTotalCount(rs.getInt(1));  
	        }  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/**
	 * 拦截器对应的封装原始对象的方法
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);  
	}

	/**
	 * 设置注册拦截器时设定的属性
	 */
	@Override
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType"); 
	}


    public String totalCountParsesql(String statement) throws JSQLParserException {
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(statement));
        StringBuilder totalCountSql = null;
        if(select.getSelectBody() instanceof PlainSelect){
        	totalCountSql = new StringBuilder("select count(");
	        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
	        if(plainSelect.getDistinct()!=null){
	        	totalCountSql.append(plainSelect.getDistinct());
	        }else {
	        	totalCountSql.append("*");
	        }
	        totalCountSql.append(") from ");
	        
	        totalCountSql.append(plainSelect.getFromItem());
	        if(plainSelect.getJoins()!=null){
	        	if(plainSelect.getJoins().get(0).isSimple()){
	        		totalCountSql.append(",");
	        	}else {
	        		totalCountSql.append(" ");
	        	}
	        	for(Join join:plainSelect.getJoins()){
	        		/*StringBuilder builder = new StringBuilder();
	        		builder.append("isCross=").append(join.isCross());
	        		builder.append(";isFull=").append(join.isFull());
	        		builder.append(";isInner=").append(join.isInner());
	        		builder.append(";isLeft=").append(join.isLeft());
	        		builder.append(";isNatural=").append(join.isNatural());
	        		builder.append(";isOuter=").append(join.isOuter());
	        		builder.append(";isRight=").append(join.isRight());
	        		builder.append(";isSimple=").append(join.isSimple());
	        		System.out.println(builder);*/
	        		totalCountSql.append(join).append(join.isSimple()?",":" ");
	        	}	    
		        totalCountSql.delete(totalCountSql.length()-1, totalCountSql.length()) 	;
	        }
	        
	        if(plainSelect.getWhere()!=null){
	        	totalCountSql.append(" where ").append(plainSelect.getWhere());
	        }
	        
	        if(plainSelect.getGroupByColumnReferences()!=null){
	        	totalCountSql.append(" GROUP BY ");
	        	for(Expression expression:plainSelect.getGroupByColumnReferences()){
	        		totalCountSql.append(expression).append(",");
	        	}
	        	totalCountSql.delete(totalCountSql.length()-1, totalCountSql.length()) 	;
	        }
	        
	        if(plainSelect.getHaving()!=null){
	        	totalCountSql.append(" HAVING ").append(plainSelect.getHaving());
	        }
        }
        return totalCountSql.toString();
    }
	/**
	 * 
	 * 利用反射进行操作的一个工具类 
	 *
	 */
	private static class ReflectUtils {
		
		/**
		 * 利用反射获取指定对象里面的指定属性
		 * @param obj 目标对象 
		 * @param fieldName 目标属性 
		 * @return 目标字段
		 */
		public static Field getField(Object obj,String fieldName){
			Field field = null;
			for(Class<?> clazz=obj.getClass();clazz!=Object.class;
					clazz=clazz.getSuperclass()){
				try {
					field = clazz.getDeclaredField(fieldName);
					break;
				} catch (NoSuchFieldException e) {
					//这里不用做处理(无需打印错误信息)，子类没有该字段，则可能对应的父类有，如果都没有就返回null。
					//e.printStackTrace();
				}
			}
			return field;
		}
		
		/**
		 * 利用反射设置指定对象的指定属性为指定的值
		 * @param obj 目标对象
		 * @param name 目标属性
		 * @param value 目标值 
		 */
		public static void setFieldValue(Object obj,String name,String value){
			Field field = getField(obj,name);
			if(null!=field){
				field.setAccessible(true);
				try {
					field.set(obj,value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * 利用反射获取指定对象的指定属性
		 * @param obj  目标对象
		 * @param name  目标属性 
		 * @return 目标属性的值
		 */
		public static Object getFieldValue(Object obj,String name){
			Object value=null;
			Field field = getField(obj,name);
			if(null!=field){
				field.setAccessible(true);
				try {
					value = field.get(obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			return value;
		}
	}
}

