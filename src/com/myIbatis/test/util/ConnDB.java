package com.myIbatis.test.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnDB {

	public static Connection conn = null;

	public Connection getConn() {

		// 使用JNDI方式配置数据源连接池
		try {
			Context ctx = null;
			ctx = new InitialContext();
			// //下面配完之后，在Tomcat的conf/context.xml文件正配置
			// <Resource name="jdbc/bdfw" auth="Container"
			// type="javax.sql.DataSource"
			// url="jdbc:oracle:thin:@192.168.0.174:1521:xe"
			// driverClassName="oracle.jdbc.driver.OracleDriver" maxIdle="10"
			// maxActive="50"
			// username="activemq" password="activemq"
			// factory="org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory"/>
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/bdfw");
			return ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
