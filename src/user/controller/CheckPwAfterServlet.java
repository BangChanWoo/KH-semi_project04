package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class CheckPwAfterServlet
 */
@WebServlet("/checkpwafter")
public class CheckPwAfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPwAfterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String phone=request.getParameter("phone");
		
		
		User u=new UserService().findPw(uid,uname,phone);
		request.setAttribute("vo", u);
		if(u!=null) {
		request.getRequestDispatcher("/WEB-INF/view/findPwAfter.jsp").forward(request, response);
//			response.sendRedirect("/WEB-INF/view/CheckIdAfter.jsp"); 
			
		}else {
			request.getRequestDispatcher("/WEB-INF/view/findPw.jsp").forward(request, response);
		}
	}
}
