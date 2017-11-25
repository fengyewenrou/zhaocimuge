package com.zhaoci.share.utils.json;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.zhaoci.share.utils.DateUtil;

/**
 * 日期Json序列化器，此序列化器适用yyyy-MM-dd格式
 */
public class DateJsonSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeString(DateUtil.date2str(date, DateUtil.DATE_FORMAT));
	}
}
