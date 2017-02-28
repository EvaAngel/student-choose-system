package com.scs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.GetStudentCourse;
import com.scs.model.Course;

public class GetStudentCourseImpl implements GetStudentCourse {

	public List<Course> getStudentCourse(int studentId) throws SQLException {
		PreparedStatement stat=null;
		List<Course> courselist=new ArrayList<Course>();
		String sql="select b.id,b.cname,b.bookname from student_course as a,course as b where a.course_id=b.id and a.student_id=?";
		stat=ConnectionMySql.connectSql(sql);
		stat.setInt(1, studentId);
		ResultSet rs=stat.executeQuery();
		while(rs.next())
		{
			//这个二表查询我竟然一次成功了
			Course c=new Course();
			int courseid=rs.getInt("b.id");
			String cname=rs.getString("b.cname");
			String bookname=rs.getString("b.bookname");
			c.setId(courseid);
			c.setCname(cname);
			c.setBookname(bookname);
		    courselist.add(c);
		}
		rs.close();
		ConnectionMySql.closeConnection();
		return courselist;
	}

}
