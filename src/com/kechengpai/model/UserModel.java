package com.kechengpai.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSON;

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
	public String Login(String account, String password) {
		String sql = null;

		sql = "select * from user where account= ? and password=?";

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));

				return com.alibaba.fastjson.JSON.toJSONString(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "-1";
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public int register(User user) {
		String sql = null;

		sql = "insert into user (account,password,school,name,type,number) values (?,?,?,?,?,?) ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql); // 实例化预处理
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSchool());
			pstmt.setString(4, user.getName());
			pstmt.setInt(5, user.getType());
			pstmt.setInt(6, user.getNumber());

			int i = pstmt.executeUpdate(); // 执行语句

			pstmt.close();
			if (i >= 0) {
				return user.getType();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return -1;
	}

	public String updateUserInfo(String account, String columnName,
			String columnValue) {
		String sql = "update user set " + columnName + "=?"
				+ " where account=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			if ( columnName.equals("number")) {

				pstmt.setInt(1, Integer.parseInt(columnValue));
			} else {
				pstmt.setString(1, columnValue);
			}

			pstmt.setString(2, account);
			int i = pstmt.executeUpdate();
			pstmt.close();
			return columnName;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "-1";

	}
	/**
	 * 检查账号是否唯一
	 * 
	 * @param account
	 * @param type
	 * @return
	 */
	// private String checkAccount(String account) {
	// String sql = null;
	//
	// sql = "select * from user where account= ? ";
	//
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) con.prepareStatement(sql);
	// pstmt.setString(1, account);
	// ResultSet rs = pstmt.executeQuery();
	// while (rs.next()) {
	// return rs.getString(1);
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return "-1";
	// }
}
