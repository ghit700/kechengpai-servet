package com.kechengpai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	private static Connection conn;

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kechengpai"; // 数据库名,一般为test
		String username = "root";
		String password = "123456"; // 你的密码
		conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
			System.out.println("您已经连接成功");
			return conn;

		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			System.out.println("您连接失败");
		}
		return null;
	}

	public static void main(String[] args) {
		getConn();
	}
}
