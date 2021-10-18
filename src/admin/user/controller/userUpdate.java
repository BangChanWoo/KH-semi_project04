package admin.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.user.model.service.adminUserService;

/**
 * Servlet implementation class userUpdate
 */
@WebServlet("/userUpdate")
public class userUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("./WEB-INF/view/userInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("수정 진입");

		String uid = request.getParameter("id");
		String pw = request.getParameter("pw");
		String uname = request.getParameter("uname");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		char gender = request.getParameter("gender").charAt(0);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int point = Integer.parseInt(request.getParameter("point"));
		char kind = request.getParameter("type").charAt(0);

		int result = new adminUserService().updateUser(pw, uname, nickname, age, gender, email, phone, address, point, kind, uid);
		System.out.println(result + "------------------------------------------------------------------");
		if (result == 1) {
			request.setAttribute("msg", "회원 수정 성공");
			request.getRequestDispatcher("SelectUserServlet").forward(request, response);
		} else {
			request.setAttribute("msg", "회원 수정 실패");
			request.getRequestDispatcher("SelectUserServlet").forward(request, response);
		}
	}

}
