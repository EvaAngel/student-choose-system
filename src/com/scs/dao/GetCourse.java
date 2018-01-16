package com.scs.dao;

import java.sql.SQLException;
import java.util.List;

import com.scs.model.Course;

public interface GetCourse {
	public List<Course> selectCourse() throws SQLException;
}
