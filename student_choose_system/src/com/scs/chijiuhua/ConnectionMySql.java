package com.scs.chijiuhua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ConnectionMySql
{
  static Connection conn=null;
  static PreparedStatement stat=null;
  public static PreparedStatement connectSql(String sql)
  {
  try
  {
	  System.out.println("�������ݿ�");
	  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuxin?autoReconnect=true&useSSL=false","root","717823");
	  stat=conn.prepareStatement(sql);
  }
  catch(Exception e)
  {
	  System.out.println("���ݿ�����ʧ��");
  }
  System.out.println("���ӳɹ�");
  return stat;	
}
  public static void closeConnection() throws SQLException
  {
	  stat.close();
	  conn.close();
  }
}