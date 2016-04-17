package com.kechengpai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kechengpai.bean.User;
import com.kechengpai.model.UserModel;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); // html

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String school = request.getParameter("school");
		String name = request.getParameter("name");
		String typeStr = request.getParameter("type");
		String number = request.getParameter("number");
		
		UserModel model = new UserModel();

		int type = Integer.parseInt(typeStr);
		
		User user = new User(account, password, school, name, type,
				Integer.parseInt(number));

		int i = model.register(user);

		// 获取返回给客户端的writer
		PrintWriter out = null;
		try {
			out = response.getWriter();

			out.print(i);

		} catch (Exception e) {

		} finally {
			out.close();
		}
	}
}
