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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("수정 진입");
				
		String uid = request.getParameter("id");
		String pw = request.getParameter("pw");
		String uname = request.getParameter("uname");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		//
		System.out.println(age);
		char gender = request.getParameter("gender").charAt(0);
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int point =Integer.parseInt(request.getParameter("point"));
		char kind = request.getParameter("type").charAt(0);
		
		
		System.out.println("잘 갖고오는지 확인------");
		System.out.println(pw);
		System.out.println(uname);
		System.out.println(nickname);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(point);
		System.out.println(kind);
		
		System.out.println(uid);
		
		System.out.println("끝");
		int result = new adminUserService().updateUser(pw, uname, nickname, age, gender, email,  phone, address, point, kind, uid);
		if(result==1) {
			System.out.println("수정성공");
		}
		else {
			System.out.println("444망");
		}
		request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
