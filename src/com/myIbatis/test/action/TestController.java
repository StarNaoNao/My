/**
 * 
 */
package com.myIbatis.test.action;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author donglujie
 * @创建日期 2015-6-23
 */
@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("/totest")
	public String totest(Model model, HttpServletRequest request) {
		return "test/test";
	}

	
	@RequestMapping("toajax")
	public @ResponseBody int toajax(HttpServletRequest request) {
		System.out.println("-------------------");
		return 3;
	}
}
