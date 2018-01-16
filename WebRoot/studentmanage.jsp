<%@ page language="java" import="java.util.*" import="com.scs.model.Student" import="com.scs.model.Course" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css">

  </head>
  
  <body>
  <h1>学生选课系统</h1>
  <fieldset style="width:500">
  <%Student student=(Student)session.getAttribute("student"); %>
  <legend><%=student.getUsername() %>用户欢迎您</legend>
  <form action="SelectCourseMessageServlet">
  <table width="400">
  <tr>
  <td height="80px" ><a href="SelectPersonMessageServlet">查看个人信息</a></td>
  <td height="80px"></td>
  <td height="80px"></td>
  </tr>
  <tr>
  <td height="80px"><a href="RepairPersonMessageServlet">修改个人信息</a></td>
  <td height="80px"></td>
  <td height="80px"></td>
  </tr>
   <tr>
  <td height="80px">选择课程</td>
  <td height="80px">
  <select name="coursename">
  <option selected>&nbsp;&nbsp;&nbsp;请选择课程</option>
  <%List<Course>list=(List<Course>)session.getAttribute("listCourse");%>
  <%for(Course c:list){%>
  <option value="<%=c.getCname()%>"><%=c.getCname()%></option>
  <% }%>
  </select>
  </td>
  <td height="80px"><input type="submit" value="选中课程"></td>
  </tr>
  <tr>
  <td height="80px"><a href="StudentCourseTeacherClassroomServlet">查询所选课程</a></td>
  <td height="80px"></td>
  <td height="80px"></td>
  </tr>
  </table>
  </form>
  </fieldset>
  </body>
</html>
