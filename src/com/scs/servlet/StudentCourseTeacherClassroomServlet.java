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
	//����ط���Ҫ���ǲ�ѯ����
	HttpSession session=req.getSession();
	//��Ҫ�ȴ����ݿ���ȡ����session��ȡ��
	Student student=(Student) session.getAttribute("student");
	int studentid=student.getId();
	GetStudentCourse gsc=new GetStudentCourseImpl();
	try {
		//��ȡѧ���γ���Ϣ
		courselist=gsc.getStudentCourse(studentid);
		//��ȡ�γ����ڽ���
	} catch (SQLException e) {
		System.out.println("��ѯ�γ���Ϣʧ��");
	}
	//System.out.println(courselist.get(1).getId());
	req.setAttribute("courselist", courselist);
	RequestDispatcher dispatcher=req.getRequestDispatcher("studentcourseteacherclassroom.jsp");
	dispatcher.forward(req,resp);
}
}
