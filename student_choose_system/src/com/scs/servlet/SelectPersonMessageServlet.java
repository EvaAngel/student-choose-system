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
	//����ط���session��ͬһ��session,����һ��sessionID
	RequestDispatcher dispatcher=req.getRequestDispatcher("studentpersonmessage.jsp");   //����ط��������ͬ��jspҳ����ʾ��ͬ�����ݣ�
	dispatcher.forward(req,resp);	
}
}
