package com.scs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.StudentLogin;
import com.scs.model.Student;

public class StudentLoginImpl implements StudentLogin
{
	public List<Student> selectStudent() throws SQLException
	{
		List<Student> list=new ArrayList<Student>();
		Statement stat=null;
		ResultSet rs=null;
	    stat=ConnectionMySql.connectSql("");
		try
		{
			System.out.println("数据库连接成功");
			 rs=stat.executeQuery("select * from student");
		}
		catch (SQLException e)
		{
			System.out.println("查询失败");
		}
		
		try
		{
			while(rs.next())
			{
				Student s=new Student();
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				int age=rs.getInt("age");
				String sex=rs.getString("sex");
				Date zhucetime=rs.getDate("zhucetime");
				String address=rs.getString("address");
				int tele=rs.getInt("tele");
				Date lastrepairtime=rs.getDate("lastrepairtime");
				s.setId(id);
				s.setUsername(username);
				s.setPassword(password);
				s.setSex(sex);
				s.setAge(age);
				s.setAddress(address);
				s.setLastrepairtime(lastrepairtime);
				s.setTele(tele);
				s.setZhucetime(zhucetime);
				list.add(s);
			}
		}
		catch (SQLException e)
		{
			System.out.println("输出失败");
		}
		finally
		{
			rs.close();
			ConnectionMySql.closeConnection();
			
		}
		return list;
	}

	public Student selectStudent(int id) throws SQLException
	{
		Student student=new Student();
		Statement stat=null;
		ResultSet rs=null;
	    stat=ConnectionMySql.connectSql("");
		try
		{
			System.out.println("数据库连接成功");
			 rs=stat.executeQuery("select * from student"); //这个地方怎么书写sql语句使得变量id可以传进来
		}
		catch (SQLException e)
		{
			System.out.println("查询失败");
		}
		
		try
		{
			while(rs.next())
			{
				if(id==rs.getInt("id"))
				{
					student.setId(id);
					student.setUsername(rs.getString("username"));
					student.setPassword(rs.getString("password"));
					student.setAge(rs.getInt("age"));
					student.setSex(rs.getString("sex")); //这个地方有错误，后面的都不会执行
					student.setZhucetime(rs.getDate("zhucetime"));
					student.setTele(rs.getInt("tele"));
					student.setAddress(rs.getString("address"));
					student.setLastrepairtime(rs.getDate("lastrepairtime")); //数据类型的使用转换
					//尤其是具体时间类型的（mysql与java类型的一一对应，hibernate）
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println("输出失败");
		}
		finally
		{
			rs.close();
			ConnectionMySql.closeConnection();
			
		}
		return student;
	}

	

}
