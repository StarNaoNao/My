package com.myIbatis.test.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myIbatis.test.service.ServiceTest;

@Controller
@RequestMapping("controllertest")
public class ControllerTest {

	@Autowired
	ServiceTest serviceTest;
	
	@RequestMapping("hello")
	public String hello(){
		
		String name = serviceTest.getName("1");
		System.out.println("调用hello: "+name);
		return "1";
	}
}
