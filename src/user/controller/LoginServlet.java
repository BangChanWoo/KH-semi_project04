package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uid = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String url="";

		User u = new UserService().loginUser(uid, pw);

		if (u != null) {
			request.setAttribute("u", u);
			HttpSession session=request.getSession();
			session.setAttribute("sessionID", uid);
			RequestDispatcher rd = request.getRequestDispatcher("riceThief_header.jsp");
			rd.forward(request, response);
//			response.sendRedirect("main.jsp"); 
			
			 
		}else {
			
		}

	}
}
