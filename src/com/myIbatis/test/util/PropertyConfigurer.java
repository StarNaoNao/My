package com.myIbatis.test.util;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 类描述：读取系统配置文件，并提供相应的配置项读取接口
 * 
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	private static PropertyConfigurer instance = new PropertyConfigurer();
	private static Properties properties;

	private PropertyConfigurer() {
		super();
	}

	/**
	 * 单例的PropertyConfigurer实现
	 * 
	 * @return PropertyConfigurer实例
	 */
	public static PropertyConfigurer getInstance() {
		return instance;
	}

	/**
	 * 获取配置项目的值
	 * 
	 * @param key
	 *            配置项名称
	 * @return 配置项值
	 */
	public static String getValue(String key) {
		System.out.println("getValue~~~~~~~~~~~~~~~~~~~~~~~");
		String value = null;
		try {
			if (properties == null) {
				properties = instance.mergeProperties();
			}
			value = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 获取配置项的值,配置项不存在时返回默认值
	 * 
	 * @param key
	 *            配置项名称
	 * @param defaultValue
	 *            默认值
	 * @return 配置项值
	 */
	public static String getValue(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}

	/**
	 * 获取整形的配置数据
	 * 
	 * @param key
	 *            配置项名称
	 * @return 转化为int类型的配置项值
	 */
	public static int getIntValue(String key) {
		String value = getValue(key);
		int iV = 0;
		if (value != null && value.matches("^\\d+$")) {
			iV = Integer.parseInt(value);
		}
		return iV;
	}

	/**
	 * 获取整形的配置数据
	 * 
	 * @param key
	 *            配置项名称
	 * @param defaultValue
	 *            默认值
	 * @return 转化为int类型的配置项值
	 */
	public static int getIntValue(String key, int defaultValue) {
		String value = getValue(key);
		int iV = 0;
		if (value != null && value.matches("^\\d+$")) {
			iV = Integer.parseInt(value);
		} else {
			iV = defaultValue;
		}
		return iV;
	}

	/**
	 * 返回布尔型的配置项
	 * 
	 * @param key
	 *            配置项名称
	 * @return 转化为布尔型的配置项值 (?i)忽略大小写
	 */
	public static boolean getBooleanValue(String key) {
		String value = getValue(key);
		boolean bV = false;
		if (value != null && value.matches("(?i)^(true|false)$")) {
			bV = Boolean.parseBoolean(value);
		}
		return bV;
	}

	/**
	 * 返回布尔型的配置项
	 * 
	 * @param key
	 *            配置项名称
	 * @param defaultValue
	 *            默认值
	 * @return 转化为布尔型的配置项值 (?i)忽略大小写
	 */
	public static boolean getBooleanValue(String key, boolean defaultValue) {
		String value = getValue(key);
		boolean bV = false;
		if (value != null && value.matches("(?i)^(true|false)$")) {
			bV = Boolean.parseBoolean(value);
		} else {
			bV = defaultValue;
		}
		return bV;
	}

	/**
	 * 重加载配置信息
	 */
	public static void reload() {
		try {
			properties = instance.mergeProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * Pattern p = Pattern.compile("\\d+"); Matcher m =
		 * p.matcher("fcatf44ddfdfcatrrr7888rcat00"); while(m.find())
		 * System.out.println(m.group());
		 */

		// 生成Pattern对象并且编译一个简单的正则表达式"Kelvin"
		Pattern p = Pattern.compile("Kelvin");
		// 用Pattern类的matcher()方法生成一个Matcher对象
		Matcher m = p
				.matcher("dddKelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		// 使用find()方法查找第一个匹配的对象
		boolean result = m.find();
		System.out.println(result);
		// 使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
		while (result) {
			i++;
			m.appendReplacement(sb, "Kevin");
			System.out.println("第" + i + "次匹配后sb的内容是：" + sb);
			// 继续查找下一个匹配对象
			result = m.find();
		}
		// 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里；
		m.appendTail(sb);
		System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString());
	}

}
