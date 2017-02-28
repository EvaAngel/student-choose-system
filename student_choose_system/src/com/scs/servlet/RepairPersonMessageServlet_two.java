package com.scs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scs.dao.RepairPersonMessage;
import com.scs.dao.impl.RepairPersonMessageImpl;
import com.scs.model.Student;

public class RepairPersonMessageServlet_two extends HttpServlet {
//此servlet完成学生信息的修改工作即可
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	//通过session获得放入session中的用户名：
	HttpSession session=req.getSession();
	Student yonghu=(Student)session.getAttribute("student");
	int id=yonghu.getId();
	Student s=new Student();
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	int age=Integer.parseInt(req.getParameter("age"));
	String sex=req.getParameter("sex");
	int tele=Integer.parseInt(req.getParameter("tele"));
	String address=req.getParameter("address");
	s.setUsername(username);
	s.setPassword(password);
	s.setAge(age);
	s.setAddress(address);
	s.setTele(tele);
	s.setSex(sex);
	RepairPersonMessage rpm=new RepairPersonMessageImpl();
	try {
		rpm.repairPersonMessage(id, s);
	} catch (SQLException e) {
    e.printStackTrace();
	}
	req.getRequestDispatcher("repairpersonmessage_two.jsp").forward(req, resp);
	}
}
