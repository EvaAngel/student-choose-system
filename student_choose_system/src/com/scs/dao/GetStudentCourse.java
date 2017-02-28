package com.scs.dao;

import java.sql.SQLException;
import java.util.List;

import com.scs.model.Course;

public interface GetStudentCourse  {
public List<Course> getStudentCourse(int studentId) throws SQLException;
}
