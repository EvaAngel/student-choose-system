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

import com.scs.dao.GetStudentCourse;
import com.scs.dao.impl.GetStudentCourseImpl;
import com.scs.model.Course;
import com.scs.model.Student;

public class StudentCourseTeacherClassroomServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	List<Course> courselist=new ArrayList<Course>();
	//这个地方需要的是查询而已
	HttpSession session=req.getSession();
	//需要先从数据库中取而非session中取。
	Student student=(Student) session.getAttribute("student");
	int studentid=student.getId();
	GetStudentCourse gsc=new GetStudentCourseImpl();
	try {
		//获取学生课程信息
		courselist=gsc.getStudentCourse(studentid);
		//获取课程所在教室
	} catch (SQLException e) {
		System.out.println("查询课程信息失败");
	}
	//System.out.println(courselist.get(1).getId());
	req.setAttribute("courselist", courselist);
	RequestDispatcher dispatcher=req.getRequestDispatcher("studentcourseteacherclassroom.jsp");
	dispatcher.forward(req,resp);
}
}
