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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String msg = request.getParameter("msg");

		request.setAttribute("msg", msg);
		request.getRequestDispatcher("./WEB-INF/view/login.jsp").forward(request, response);

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
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");

		int result = new UserService().loginUser(uid, pw);

		if (result == 1) {
			request.setAttribute("result", result);
			User vo = new UserService().getNick(uid);

			HttpSession session = request.getSession();
			session.setAttribute("sessionID", uid);
			session.setAttribute("sessionNickname", vo.getNickname());
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("main");// 이거 변경
			rd.forward(request, response);
//	         response.sendRedirect("/WEB-INF/view/main.jsp"); 
		} else if(result==2) {
			User vo = new UserService().getNick(uid);

			HttpSession session = request.getSession();
			session.setAttribute("sessionID", uid);
			session.setAttribute("sessionNickname", vo.getNickname());
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("adminMainServlet");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("result1", "로그인 실패했습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.forward(request, response);
		}
	}
}
