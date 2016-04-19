package com.kechengpai.model;

import com.alibaba.fastjson.JSON;
import com.kechengpai.bean.Course;
import com.kechengpai.bean.User;
import com.kechengpai.jdbc.jdbc;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseModel {

	static Connection con = null;

	public CourseModel() {
		super();
		this.con = jdbc.getConn();
	}

	public static String queryCourseList(String account, int type) {
		int i = -1;
		String sql = null;
		if (type == 1) {
			sql = "select c_id,name,teacher,code,numbers from course where account=?";
		} else {
			sql = "select c_id,name,teacher,code,numbers from course as a,student_course as b"
					+ " where account=? and a.c_id=b.c_id";
		}

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			List<Course> courses = new ArrayList<Course>();
			while (rs.next()) {
				Course course = new Course(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
				courses.add(course);
			}
			return JSON.toJSONString(courses);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "-1";
	}
}
