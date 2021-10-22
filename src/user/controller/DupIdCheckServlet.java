package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("./WEB-INF/view/insertJoin.jsp").forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		int a=0;
		int b=0;
		String uid=request.getParameter("uid");
		//String uid="asd";
		UserService uservice=new UserService();
		ArrayList<User> idList=uservice.dupIdCheck();
		System.out.println("중복 체크 부분"+uid);
		System.out.println("중복 체크 부분"+idList);
		if(idList != null) {
			for(User vo : idList) {
				System.out.println(vo.getUid());
				if(vo.getUid().equals(uid)) {
					System.out.println("중복");
					a++;
				}
				else {
					System.out.println("중복아님");
					b++;
				}
			}
			System.out.println(a);
			System.out.println(b);
			if(a>0) {
				out.print("true");
				System.out.println("중복임");
			}
			else {
				out.print("false");
				System.out.println("중복아님");
			}
		}

//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/insertJoin.jsp");
//		rd.forward(request, response);
	}
	

}
