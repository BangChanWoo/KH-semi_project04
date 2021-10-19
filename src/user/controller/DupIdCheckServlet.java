package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class DupIdCheckServlet
 */
@WebServlet("/dupidcheck")
public class DupIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String uid=request.getParameter("uid");
		UserService uservice=new UserService();
		User u=uservice.dupIdCheck(uid);
		
		if(uid.equals(u.getUid())) {
			out.print("true");
		}else {
			out.print("false");
		}
		
		
//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/insertJoin.jsp");
//		rd.forward(request, response);
	}
	

}
