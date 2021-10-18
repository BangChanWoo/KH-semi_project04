package admin.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.user.model.dao.adminUserDao;
import admin.user.model.service.adminUserService;

/**
 * Servlet implementation class userDelete
 */
@WebServlet("/userDelete")
public class userDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("삭제진입");
		String uid = request.getParameter("id");
		System.out.println(uid);
		int result= new adminUserService().deleteUser(uid);
		if(result==1) {
			request.setAttribute("msg", "회원 삭제 성공");
			request.getRequestDispatcher("SelectUserServlet").forward(request, response);
		}
		else {
			System.out.println("삭제 실패"+result);
			request.setAttribute("msg", "회원 삭제 실패");
			request.getRequestDispatcher("SelectUserServlet").forward(request, response);
		}
		//request.getRequestDispatcher("./WEB-INF/view/adminUserDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
