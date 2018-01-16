package com.scs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scs.dao.DeleteCourse;
import com.scs.dao.GetStudentCourse;
import com.scs.dao.impl.DeleteCourseImpl;
import com.scs.dao.impl.GetStudentCourseImpl;
import com.scs.model.Student;

public class DeleteCourseServlet  extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
HttpSession session=req.getSession();
Student s=(Student)session.getAttribute("student");
int studentid=s.getId();
//����ط�������λ�ȡָ���γ̵�id�Ǹ����Ⱑ����������
int courseid=Integer.parseInt(req.getParameter("id"));
List courselist=null;
System.out.println(courseid);
DeleteCourse dc=new DeleteCourseImpl();
try {
	dc.deleteCourse(studentid, courseid);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	//֮���ǻ�ȡ���ݿ��е���Ϣ
	GetStudentCourse gsc=new GetStudentCourseImpl();
	try {
	 courselist=gsc.getStudentCourse(studentid);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	req.setAttribute("courselist", courselist);
	req.getRequestDispatcher("studentcourseteacherclassroom.jsp").forward(req, resp);

}
}
