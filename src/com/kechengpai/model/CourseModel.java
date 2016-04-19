package com.kechengpai.model;

import com.kechengpai.jdbc.jdbc;
import java.sql.Connection;

public class CourseModel {

	Connection con = null;

	public CourseModel() {
		super();
		this.con = jdbc.getConn();
	}

}
