package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target({ ElementType.METHOD, ElementType.TYPE })   用来声明注解可以被添加在哪些类型的元素上，如类型、方法和域等
//@Retention(RetentionPolicy.RUNTIME)   声明注解的保留策略，有CLASS、RUNTIME和SOURCE这三种，分别表示注解保存在类文件、JVM运行时刻和源代码中
//@Inherited   被注解的类会自动继承
//@Documented   表明这个注解应该被 javadoc工具记录

@Target({ ElementType.METHOD, ElementType.TYPE })  
@Retention(RetentionPolicy.RUNTIME) 
@Inherited  
@Documented  
public @interface AnnotationTest {
	//@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
	//方法的名称就是参数的名称，返回值类型就是参数的类型。可以通过default来声明参数的默认值

	String loginin();

	String logout();
	
	String hello() default "bad";
}
