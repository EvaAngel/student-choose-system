package com.scs.dao;

import java.sql.SQLException;
import java.util.List;

import com.scs.model.Course;
import com.scs.model.Student;

public interface StudentLogin
{
public List<Student> selectStudent() throws SQLException;
public Student selectStudent(int id) throws SQLException;
}
