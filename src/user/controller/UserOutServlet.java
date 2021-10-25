package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserService;

/**
 * Servlet implementation class UserOutServlet
 */
@WebServlet("/userout")
public class UserOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");

		int result = new UserService().userOut(id);
		
		if(result > 0) {
			HttpSession session = request.getSession(false);
				if(session!=null) {
			session.invalidate();
			}
			response.sendRedirect("main");
		}else {
			response.sendRedirect("WEB-INF/view/UpdateUser.jsp");
		}
	}
}
