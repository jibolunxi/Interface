<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Share</title>
    <meta http-equiv="Content-Type" content="text/html" charset=UTF-8 >
	<meta http-equiv="pragma" content="no-cache" >
	<meta http-equiv="cache-control" content="no-cache" >
	<meta http-equiv="expires" content="0" >    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" >
	<meta http-equiv="description" content="This is my page" >
	<link rel="stylesheet" type="text/css" href="styles.css" >
  </head>
  
  <body>
     <form action="getShare" method="get">
     	<input type="submit" value="点击获取JSON数据"/>
     </form>
  </body>
</html>