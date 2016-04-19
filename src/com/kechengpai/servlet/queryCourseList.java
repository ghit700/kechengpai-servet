package com.kechengpai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kechengpai.model.CourseModel;
import com.kechengpai.model.UserModel;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class queryCourseList
 */
@WebServlet("/queryCourseList")
public class queryCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public queryCourseList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String type = request.getParameter("type");

		CourseModel model = new CourseModel();
		String result = model.queryCourseList(account, Integer.parseInt(type));
		// 获取返回给客户端的writer
		PrintWriter out = null;
		try {
			out = response.getWriter();

			out.print(result);

		} catch (Exception e) {

		} finally {
			out.close();

		}
	}

}
