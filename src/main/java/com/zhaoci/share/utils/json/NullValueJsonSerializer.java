package com.zhaoci.share.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 空值Json序列化器
 */
public class NullValueJsonSerializer extends JsonSerializer<Object> {
	@Override
	public void serialize(Object object, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeString("");
	}
}
