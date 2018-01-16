package com.scs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scs.dao.StudentLogin;
import com.scs.dao.impl.StudentLoginImpl;
import com.scs.model.Student;

public class SelectPersonMessageServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
{
	//这个地方的session是同一个session,共有一个sessionID
	RequestDispatcher dispatcher=req.getRequestDispatcher("studentpersonmessage.jsp");   //这个地方如何在相同的jsp页面显示不同的内容？
	dispatcher.forward(req,resp);	
}
}
