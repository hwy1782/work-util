package com.test.hsf.inferface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;

/**
 * @author E-mail: hwy1782@gmail.com
 * @date  : 2013-2-25 上午10:22:45
 * 
 */
public class HsfConfigLoader{

	static ClassPathXmlApplicationContext ctx = null;
	
	static {
		HSFEasyStarter.start("d:/hsf/release", "");// 在用到consumer bean前启动hsf
		String springResourcePath = "spring-hsf-uic-consumer.xml";
		ctx = new ClassPathXmlApplicationContext(springResourcePath);
	}

}
