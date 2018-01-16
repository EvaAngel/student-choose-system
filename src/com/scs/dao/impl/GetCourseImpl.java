package com.scs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.GetCourse;
import com.scs.model.Course;

public class GetCourseImpl implements GetCourse//��״̬������õ�
{
	public List<Course> selectCourse() throws SQLException {
		    List<Course> listCourse=new ArrayList<Course>();
			Statement stat=null;
			ResultSet rs=null;
		    stat=ConnectionMySql.connectSql("");
			try
			{
				System.out.println("���ݿ����ӳɹ�");
				 rs=stat.executeQuery("select * from course");
			}
			catch (SQLException e)
			{
				System.out.println("��ѯʧ��");
			}
			
			try
			{
				while(rs.next())
				{
					Course course=new Course();
					int id=rs.getInt("id");
					String cname=rs.getString("cname");
					String bookname=rs.getString("bookname");
					course.setId(id);
					course.setCname(cname);
					course.setBookname(bookname);
					listCourse.add(course);
				}
			}
			catch (SQLException e)
			{
				System.out.println("���ʧ��");
			}
			finally
			{
				rs.close();
				ConnectionMySql.closeConnection();
				
			}
			
			return listCourse;
	}

}
