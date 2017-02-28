package com.scs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scs.dao.GetCourse;
import com.scs.dao.StudentLogin;
import com.scs.dao.impl.GetCourseImpl;
import com.scs.dao.impl.StudentLoginImpl;
import com.scs.model.Course;
import com.scs.model.Student;

public class StudentLoginServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
{
	List<Student> list=new ArrayList<Student>();
	List<Course>  listCourse=null;
	HttpSession session=req.getSession();
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	//完成匹配的业务逻辑
	StudentLogin sl=new StudentLoginImpl();
	GetCourse gc=new GetCourseImpl();
	try
	{
		list=sl.selectStudent();
		listCourse=gc.selectCourse();
	}
	catch (SQLException e)
	{
		System.out.println("查找失败");
	}
	session.setAttribute("listCourse",listCourse);
	//判断
	for(Student l:list){
	if(l.getUsername().equals(username)&&l.getPassword().equals(password))
	{
		session.setAttribute("student", l);
		RequestDispatcher dispatcher=req.getRequestDispatcher("studentmanage.jsp");
		dispatcher.forward(req,resp);
		return;  //这个地方必须加return，表示停止
	}
	}
	RequestDispatcher dispatcher=req.getRequestDispatcher("studentlogin.jsp");
	dispatcher.forward(req,resp);
}
}
