package com.scs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scs.dao.InsertStudentCourse;
import com.scs.dao.impl.GetStudentCourseImpl;
import com.scs.dao.impl.InsertStudentCourseImpl;
import com.scs.model.Course;
import com.scs.model.Student;

public class SelectCourseMessageServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
{
	System.out.println("提交选课系统成功");
	//此servlet实现将学生id与课程id插入course_student表的功能
	//这个地方感觉可以传map
	String cname=req.getParameter("coursename");
	System.out.println(cname);
	HttpSession session=req.getSession();
	Student student=(Student)session.getAttribute("student");
	@SuppressWarnings("unchecked")
	List<Course> course=(List<Course>)session.getAttribute("listCourse");
	for(Course c:course)
	{
		if(c.getCname().equals(cname))
		{
			session.setAttribute("course", c);
		}
	}
	Course course2=(Course)session.getAttribute("course");
	System.out.println(course2.getId());
	System.out.println(student.getId());
	
	
	try {
		if(new GetStudentCourseImpl().getStudentCourse(student.getId()).size()<4)
		{
		InsertStudentCourse isc=new InsertStudentCourseImpl();
		isc.insertStudentAndCourse(student.getId(), course2.getId());
		RequestDispatcher dispatcher=req.getRequestDispatcher("choosedcourse.jsp");
		dispatcher.forward(req,resp);
		}
		else
		{
			PrintWriter out=resp.getWriter();
			out.println("<script language='javascript'>alert('always choosed three courses!');window.location='studentmanage.jsp'</script>");
		}
	} catch (Exception e) {
		System.out.println("插入学生课程表失败");
		RequestDispatcher dispatcher=req.getRequestDispatcher("errorcourse.jsp");
		dispatcher.forward(req,resp);
	}
	//后面将session存入表中即可
	
}
}
