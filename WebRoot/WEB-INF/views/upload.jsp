<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传,下载</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
	<script type="text/javascript" src="js/jquery126.js"></script>
	<script type="text/javascript">
	/*
		$(function(){
			$("#myButton").click(function(){
				$("#show").html("");
				$(this).attr("disabled",true);
				$("#form3").submit();
				setTimeout("showProgress()",500);
			});
		});
		
		function showProgress(){
			$.getJSON("SeeProgressServlet",function(json){
				$("#show").html("上传进度："+(json.PBytesRead/json.PContentLength)*100+"%");
				if(json.PBytesRead == json.PContentLength){
					$("#show").html($("#show").html()+"上传结束~");
					$("#myButton").attr("disabled",false);
				}else{
					setTimeout("showProgress()",500);
				}
			});
		}
	*/	
	</script>
  </head>
  
  <body>
  	<!--<h2>查看文件上传的请求正文</h2>
	<form id="form1" method="POST" enctype="multipart/form-data" action="SeeRequestContentServlet">
		<input type="text" name="myText" value="test" /><br/>
		<input type="file" name="myFile"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	
	--><h2>使用fileupload组件实现文件上传</h2>
	<form id="form2" method="POST" enctype="multipart/form-data" action="${ctx }/myibatis/upload.html">
		<input type="text" name="myText" value="test" /><br/>
		<input type="file" name="myFile"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	
	<!--<h2>文件上传显示进度</h2>
	<iframe id='target_upload' name='target_upload' src='' style='display: none'></iframe>
	<form id="form3" method="POST" enctype="multipart/form-data" action="AJAXFileUploadServlet" target="target_upload">
		<input type="file" name="myFile"/><br/>
		<input type="button" value="提交" id="myButton"/><br/>
	</form>
	--><div id="show"></div>
	
	<h2>文件下载</h2>
	<form id="form4" method="POST" action="${ctx }/myibatis/download.html">
		请输入文件名：<input type="text" name="fileName"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>
  </body>
</html>
