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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="ui/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		function testIframe(){
			var src = "${ctx}/myibatis/totestIframe.html";
			$("#rgt").attr("src", src);
		}
	
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
  <form action="${ctx}/myibatis/showData.html" method="post"> 
 	<div>
    <input type="text" id="text" name="text"/>
    <input type="submit" id="button" name="button"/>
	<input type="button" onclick="testIframe();" value="Iframe测试">
	<a href="javascript:void(0)" onclick="testAjax()">ajax测试</a>    
 	</div>
 	<!-- 使用iframe，一旦点击上面的按钮，会自动调用js，在iframe中添加src，添加之后页面会自动加载iframe，如果src对应的是页面，也会加载 -->
 	<iframe id="rgt" frameborder="0" src="" style="width:100%;height:200px;margin-top:2px"></iframe>
  </form>
  <a href="${ctx }/myibatis/toUpload.html">跳转到上传文件页面</a>
  
  <!-- 注意servlet路径，可以复制web.xml中servlet-mapping的url-pattern值 -->
  <a href="${ctx }/servlet/FilterServlet_Test">Filter测试</a>  
  </body>
</html>
