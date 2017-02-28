package com.scs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.InsertStudentCourse;

public class InsertStudentCourseImpl implements InsertStudentCourse{

public void insertStudentAndCourse(int studentId,int courseId) throws SQLException 
{
	PreparedStatement stat=null;
	System.out.println(studentId+" "+courseId);
	String sql="insert into student_course values (?,?)";
    stat= (PreparedStatement) ConnectionMySql.connectSql(sql);
	stat.setInt(1, studentId);
	stat.setInt(2,courseId);
	stat.executeUpdate();  //加这一句才表示插入成功了
	System.out.println("插入成功");
			
	stat.close();
	ConnectionMySql.closeConnection();
	
	
}
}
