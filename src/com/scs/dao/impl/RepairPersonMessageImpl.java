package com.scs.dao.impl;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.RepairPersonMessage;
import com.scs.model.Student;

public class RepairPersonMessageImpl implements RepairPersonMessage {
//ʵ��ָ��id���û���Ϣ�޸�
	public void repairPersonMessage(int id, Student student) throws SQLException {
		System.out.println(id+student.getPassword()+student.getAge()+student.getSex()+student.getAddress()+student.getTele());
		String sql ="update student set password=?,age=?,address=?,tele=? where id=?";
    	PreparedStatement stat=(PreparedStatement) ConnectionMySql.connectSql(sql);
    	System.out.println("�ɹ�1");
    	stat.setString(1, student.getPassword());
    	System.out.println("�ɹ�2");
    	stat.setInt(2, student.getAge());
    	System.out.println("�ɹ�3");
    	stat.setString(3, student.getAddress());  //�����ַҲ�������룿����������Ҳ������
    	System.out.println("�ɹ�5");
    	stat.setInt(4,student.getTele());
    	System.out.println("�ɹ�6");
    	stat.setInt(5, id);
    	System.out.println("�ɹ�7");
    	int i=stat.executeUpdate();
    	System.out.println(i);
    	ConnectionMySql.closeConnection();
	}

}
