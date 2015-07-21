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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="ui/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
	function testAjax(){
		var i = 0;
		$.ajax({
	    	type : 'post',
	    	async:false,//默认是true，异步
	    	url:"${ctx}/test/toajax.do",
	    	success:function(data){
	    		alert("----------------"+data);
	    		i = i + data;
	    	}
	   });
	   alert(i);
	}
	</script>
  </head>
  
  <body>
   <a href="javascript:void(0)" onclick="testAjax()">ajax测试</a>
  </body>
</html>
