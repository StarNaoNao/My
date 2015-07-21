package com.myIbatis.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.myIbatis.test.util.PropertyConfigurer1;

/**
 * 
 * @author 肖星 2014-9-19
 *         controller下没有指定名称的RequestMapping，在访问这里的方法时，直接调用下面这个"toMains"即可
 */
@Controller
public class ToMain {

	@RequestMapping("toMains")
	public String toMain() {
		String jdbcname = PropertyConfigurer1.getValue("jdbc.url");
		System.out.println("ToMain中的代码得到：" + jdbcname);
		return "index";
	}
}
