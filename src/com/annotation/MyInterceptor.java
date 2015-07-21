package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
// 使用注解方式的AOP
public class MyInterceptor {

	@Before(value = "@annotation(com.annotation.AnnotationTest)")
	public void befroe() {
		System.out.println("before");
	}

	@After(value = "@annotation(com.annotation.AnnotationTest)")
	public void after() {
		System.out.println("after");
	}

	// value处如果使用的是直接指定到某个方法，而不是注解，可以这么写：("execution(* com.bird.service.impl.PersonServiceBean.*(..))")  
	@Around(value = "@annotation(com.annotation.AnnotationTest)")
	public Object aroundDo(ProceedingJoinPoint pjp) {
		MethodSignature joinPointObject = (MethodSignature) pjp.getSignature();  
        Method method = joinPointObject.getMethod();
        System.out.println(method.getName());
        System.out.println(method.getAnnotations());
		
        AnnotationTest update = findAnnotation(method, AnnotationTest.class);
        System.out.println(update.hello());
        System.out.println(update.loginin());
        System.out.println(update.logout());

        Object object = null;
		try {
			object = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}//执行该方法  
        System.out.println("退出方法");  
        return object;  
	}
	
	/**
	 * 根据注解类型，查找注解信息
	 * @param <T>
	 * @param ae
	 * @param annotationType
	 * @return
	 */
	private <T extends Annotation> T findAnnotation(AnnotatedElement ae, Class<T> annotationType) {
		T ann = ae.getAnnotation(annotationType);
		if (ann == null) {
			for (Annotation metaAnn : ae.getAnnotations()) {
				ann = metaAnn.annotationType().getAnnotation(annotationType);
				if (ann != null) {
					break;
				}
			}
		}
		return ann;
	}
}
