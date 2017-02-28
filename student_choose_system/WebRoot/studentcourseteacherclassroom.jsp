<%@ page language="java" import="java.util.*" import="com.scs.model.Student" import="com.scs.model.Course" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentcourseteacherclassroom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css">

  </head>
  
  <body>
  <h1>学生选课系统</h1>
  <fieldset style="width:600">
  <%Student student=(Student)session.getAttribute("student"); %>
  <legend><%=student.getUsername() %>用户欢迎您</legend>
  <form>
  <table width="500px">
  <tr>
  <td height="80px"><font color="blue" size="5">课程名</font></td>
  <td height="80px"><font color="blue" size="5">所在教室</font></td>
  <td height="80px"><font color="blue" size="5">授课老师</font></td>
   <td height="80px"><font color="blue" size="5">删除课程</font></td>
  </tr>
  <% List<Course> courselist=(List<Course>)request.getAttribute("courselist");
  
  for(int i=0;i<courselist.size();i++)
  {
	 
	  %>
	<tr>
  <td height="40px"><%=courselist.get(i).getCname()%></td>
  <td height="40px">所在教室</td>
  <td height="40px">授课老师</td>
  <td height="40px"><a href="DeleteCourseServlet?id=<%=courselist.get(i).getId()%>">删除课程</a></td>
  </tr>  
	  <%
  }
	  %>
  
  </table>
  </form>
  </fieldset>
  </body>
</html>
