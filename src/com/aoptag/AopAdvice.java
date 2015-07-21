package com.aoptag;

import org.aspectj.lang.JoinPoint;

public class AopAdvice {

	public void adviceTest(JoinPoint jointPoint){
		System.out.println("测试aop标签："+jointPoint.getSignature().getName());  
	}
}
