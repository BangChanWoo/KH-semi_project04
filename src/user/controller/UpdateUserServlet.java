package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateuser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User u;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
		String uid = (String)request.getSession().getAttribute("sessionID");
		User vo = new UserService().getUserInfo(uid);
		request.setAttribute("user", vo);
		request.getRequestDispatcher("/WEB-INF/view/UpdateUser.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		String uname = request.getParameter("uname");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address=request.getParameter("address");
		int age =Integer.parseInt(request.getParameter("age"));

		User uservo = new User(uid, pw,uname,nickname,email,phone,address,age);
		int result = new UserService().updateUser(uservo);
		 
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionNickname", nickname);
			request.getSession().setAttribute("sessionID",uid);
//			response.sendRedirect("main");
			request.getRequestDispatcher("main").forward(request,response);
		} else {
			request.setAttribute("msg", "정보변경실패");
			request.getRequestDispatcher("WEB-INF/view/UpdateUser.jsp");
		}

	}
}
