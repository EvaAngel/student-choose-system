<%@ page language="java" import="java.util.*" import="com.scs.model.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repairpersonmessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css">

  </head>
  <body>
  <% 
    Student student =(Student)session.getAttribute("student");
    %>
   <h1>学生选课系统</h1>
   <form action="RepairPersonMessageServlet_two">
  <fieldset style="width:500">
  <legend><%=student.getUsername() %>用户欢迎您</legend>
  <table width="400">
  <tr>
  <td height="50px">用户名：</td>
  <td height="50px"><%=student.getUsername()%></td>
  </tr>
  <tr>
  <td height="50px">密码：</td>
  <td height="50px"><input type="text" value="<%=student.getPassword() %>" name="password"></td>
  </tr>
  <tr>
  <td height="50px">年龄：</td>
  <td height="50px"><input type="text" value="<%=student.getAge() %>" name="age"></td>
  </tr>
  <tr>
  <td height="50px">性别：</td>
  <td height="50px"><%=student.getSex() %></td>
  </tr>
  <tr>
  <td height="50px">电话：：</td>
  <td height="50px"><input type="text" value="<%=student.getTele() %>" name="tele"></td>
  </tr>
  <tr>
  <td height="50px">地址：</td>
  <td height="50px"><input type="text" value="<%=student.getAddress() %>" name="address"></td>
  </tr>
  <tr>
  <td height="50px">注册时间：</td>
  <td height="50px"><%=student.getZhucetime() %></td>
  </tr>
  <tr>
  <td height="50px">修改时间：</td>
  <td height="50px"><%=student.getLastrepairtime() %></td>
  </tr>
  <tr>
  <td height="50px"><input type="reset" value="重置"></td>
  <td height="50px"><input type="submit" value="提交"></td>
  </tr>
  </table>
  </fieldset>
  </form>
  </body>
</html>
