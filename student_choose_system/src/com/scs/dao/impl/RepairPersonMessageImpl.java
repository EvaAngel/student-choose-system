package com.scs.dao.impl;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.RepairPersonMessage;
import com.scs.model.Student;

public class RepairPersonMessageImpl implements RepairPersonMessage {
//实现指定id的用户信息修改
	public void repairPersonMessage(int id, Student student) throws SQLException {
		System.out.println(id+student.getPassword()+student.getAge()+student.getSex()+student.getAddress()+student.getTele());
		String sql ="update student set password=?,age=?,address=?,tele=? where id=?";
    	PreparedStatement stat=(PreparedStatement) ConnectionMySql.connectSql(sql);
    	System.out.println("成功1");
    	stat.setString(1, student.getPassword());
    	System.out.println("成功2");
    	stat.setInt(2, student.getAge());
    	System.out.println("成功3");
    	stat.setString(3, student.getAddress());  //插入地址也出现乱码？？？？？？也是醉了
    	System.out.println("成功5");
    	stat.setInt(4,student.getTele());
    	System.out.println("成功6");
    	stat.setInt(5, id);
    	System.out.println("成功7");
    	int i=stat.executeUpdate();
    	System.out.println(i);
    	ConnectionMySql.closeConnection();
	}

}
