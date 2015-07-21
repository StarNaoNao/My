package com.aoptag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 使用AOP标签完成面向切面编程。
 * 这里使用aop标签是指，在AopTag.xml文件中配置<aop:config>里的内容，完成对切点的制定与操作
 */
public class TestMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new FileSystemXmlApplicationContext("resource/AopTag.xml");
		IHello helloSpeaker = (IHello)ctx.getBean("helloImpl");  
        try {
			helloSpeaker.hello("aaaaaaaaaaaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}  
        helloSpeaker.helloAaa("bbbbbbbbbbbbbbb");  
        helloSpeaker.helloBbb("ccccccccccccccc");
	}

}
