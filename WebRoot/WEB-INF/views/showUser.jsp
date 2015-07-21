<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	<!--  
	.styles li {
		font-size: large;
		height: 25px;
		list-style-type: none;
	
	}
	-->
	</style>
	
	<script type="text/javascript" src="ui/jquery-1.7.1.min.js"></script>
  </head>
  
  <body>
   <div>
   ${user.name},${user.id}
	<ul>
		<c:forEach items="${users}" var="lp">
		<li style="list-style-type:none;float:left;">${lp.name}</li>
		<li style="list-style-type:none;float:left;">&nbsp;&nbsp;</li>
		<li style="list-style-type:none;float:left;">${lp.sex}</li>
		<li style="list-style-type:none;float:left;">&nbsp;&nbsp;</li>
		<li style="list-style-type:none;float:left;">${lp.age}</li>
		<li style="list-style-type:none;">&nbsp;&nbsp;</li>
		</c:forEach>
	</ul>
   </div>
  </body>
</html>
