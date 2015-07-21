package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopAnnotationTest {

	/**
	 * AOP注解的示例,使用自定义注解,并将AOP的切入点指定为这些自定义注解。
	 * 参看框架中Cacheable.java  MethodCacheIntercept.java DmfyService.java
	 */
	public static void main(String[] args) {

		// 创建Spring容器
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"resource/context/spring-annotation.xml");
		// 获取代理对象
		Student p = (Student) ctx.getBean("student");
		
		//注意，person类中的方法都有override注解，包含此注解的方法无法通过getAnnotation来获取注解参数。原因不详
		//上方的student类则可以正常获取注解信息
//		Person p = (Person) ctx.getBean("person");
		// 执行info方法
		p.info();
		System.out.println("===========================================");
		// 执行run方法
//		p.run();

	}

}
