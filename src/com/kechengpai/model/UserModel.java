package com.kechengpai.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kechengpai.bean.Student;
import com.kechengpai.bean.Teacher;
import com.kechengpai.bean.User;
import com.kechengpai.jdbc.jdbc;
import com.mysql.jdbc.PreparedStatement;

public class UserModel {

	Connection con = null;

	public UserModel() {
		super();
		this.con = jdbc.getConn();
	}

	/**
	 * 用户登录
	 * 
	 * @param account
	 * @param password
	 * @param type
	 * @return
	 */
	public int Login(String account, String password, int type) {
		String sql = null;
		if (type == 1) {

			sql = "select * from student where account= ? and password=?";

		} else if (type == 0) {
			sql = "select * from teacher where account= ? and password=?";
		}

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public int register(User user) {
		String sql = null;

		// 检验账号是否唯一
		if (Login(user.getAccount(), user.getPassword(), user.getType()) == 1) {
			return 0;
		}

		if (user.getType() == 0) {
			sql = "insert into teacher (account,password,school,name,type) values (?,?,?,?,?) ";

		} else if (user.getType() == 1) {
			sql = "insert into student (account,password,school,name,type,number) values (?,?,?,?,?,?) ";
		}
		PreparedStatement pstmt;

		System.out.println("user.getType()=" + user.getType());
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql); // 实例化预处理
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSchool());
			pstmt.setString(4, user.getName());
			pstmt.setInt(5, user.getType());
			if (user.getType() == 1) {
				Student student = (Student) user;
				pstmt.setInt(6, student.getNumber());
			}

			int i = pstmt.executeUpdate(); // 执行语句
			pstmt.close();
			con.close();// 关闭资源,防止溢出
			return i;
		} catch (SQLException e) {
		}
		return -1;
	}
}
