package com.zhaoci.share.utils.json;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 全局Json对象映射
 */
@Component
public class GlobalObjectMapper extends ObjectMapper {
	public GlobalObjectMapper() {
		//添加空值全局Json序列化器
		NullValueJsonSerializer nullValueJsonSerializer = new NullValueJsonSerializer();
		this.getSerializerProvider().setNullValueSerializer(nullValueJsonSerializer);		
	}
}
