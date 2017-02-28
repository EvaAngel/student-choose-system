package com.scs.dao.impl;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.scs.chijiuhua.ConnectionMySql;
import com.scs.dao.DeleteCourse;
import com.scs.model.Course;
import com.scs.model.Student;

public class DeleteCourseImpl implements DeleteCourse {
//ʵ�ֵĹ����Ҹ����ض��û�ɾ�������ѡ�γ���Ϣ��ɾ������student_course������ݡ�
	public void deleteCourse(int studentid, int courseid)
			throws SQLException {
 String sql="delete from student_course where student_id=? and course_id=?";
 PreparedStatement stat=(PreparedStatement)ConnectionMySql.connectSql(sql);
 stat.setInt(1, studentid);
 stat.setInt(2, courseid);
 stat.executeUpdate();
	}

}
