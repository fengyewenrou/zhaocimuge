package com.kaiser.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TempTest {
	private static final Logger logger = Logger.getLogger(TempTest.class);
	
	@Test
	public void test2(){
		logger.info("start.....................");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext.xml" });
		System.out.println(ctx);
	}

	@Test
	public void test() {
		logger.info("start.....................");
		int endTime = Integer.valueOf("18");
		int beginTime=Integer.valueOf("08");
		if(beginTime<=endTime){
			for (int i =beginTime ; i <= endTime; i++) {
				//map.put(i, chargeUnit);
				System.out.println(i+"--------");
			}
		}else {
			for (int i =beginTime ; i >= endTime; i--) {
				//map.put(i, chargeUnit);
				System.out.println(i+"--------");
			} 
		}
		
		Date date = new Date();
		//date.setTime(1451531157000L);
		date.setTime(1451543754000L);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		System.out.println(sdf2.format(date));
		Date temp = new Date();
		try {
			temp = sdf2.parse(sdf2.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double c = (date.getTime() % 3600000) / 3600000.0;
		long back = (date.getTime() - temp.getTime()) / 3600000;
		if (c > (1 - 15 / 60.0)) {
			System.out.println( (back + 1));
		} else {
			System.out.println( back);
		}
		//System.out.println(sdf2.format(date));
		//double price = 20d;
	}

}
