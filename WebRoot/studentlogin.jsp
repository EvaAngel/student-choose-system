<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentlogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css">

  </head>
  
  <body>
  <h1>学生选课系统</h1>
  <form action="StudentLoginServlet">
  <table>
  <tr>
  <td>用户名：</td>
  <td><input type="text" name="username"></td>
  </tr>
  <tr>
  <td>密&nbsp;码：</td>
  <td><input type="password" name="password"></td>
  </tr>
  <tr>
  <td><input type="submit" value="登录"></td>
  <td><input type="button" value="注册"></td>
  </tr>
  </table>
  </form>
  </body>
</html>
