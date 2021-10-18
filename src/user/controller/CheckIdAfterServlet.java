package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class CheckIdAfter
 */
@WebServlet("/checkidafter")
public class CheckIdAfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdAfterServlet() {
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
		
		String uname=request.getParameter("uname");
		String phone=request.getParameter("phone");
		
		
		User u=new UserService().findId(uname, phone);
		request.setAttribute("vo", u);
		if(u!=null) {
		request.getRequestDispatcher("/WEB-INF/view/findIdAfter.jsp").forward(request, response);
//			response.sendRedirect("/WEB-INF/view/CheckIdAfter.jsp"); 
			
		}else {
			request.getRequestDispatcher("/WEB-INF/view/findId.jsp").forward(request, response);
		}
	}

}
