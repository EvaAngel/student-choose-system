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
			System.out.println("���ݿ����ӳɹ�");
			 rs=stat.executeQuery("select * from student");
		}
		catch (SQLException e)
		{
			System.out.println("��ѯʧ��");
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
			System.out.println("���ʧ��");
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
			System.out.println("���ݿ����ӳɹ�");
			 rs=stat.executeQuery("select * from student"); //����ط���ô��дsql���ʹ�ñ���id���Դ�����
		}
		catch (SQLException e)
		{
			System.out.println("��ѯʧ��");
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
					student.setSex(rs.getString("sex")); //����ط��д��󣬺���Ķ�����ִ��
					student.setZhucetime(rs.getDate("zhucetime"));
					student.setTele(rs.getInt("tele"));
					student.setAddress(rs.getString("address"));
					student.setLastrepairtime(rs.getDate("lastrepairtime")); //�������͵�ʹ��ת��
					//�����Ǿ���ʱ�����͵ģ�mysql��java���͵�һһ��Ӧ��hibernate��
				}
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
		return student;
	}

	

}
