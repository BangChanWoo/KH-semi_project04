package user.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.UserDao;
import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class JoinUserServlet
 */
@WebServlet("/joinuser")
public class JoinUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("./WEB-INF/view/insertJoin.jsp").forward(request, response);
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uid=request.getParameter("id");
		String pw=request.getParameter("pw");
		String uname=request.getParameter("uname");
		String nickname=request.getParameter("nickname");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String ageStr=request.getParameter("age");
		int age = 0;
//		String join_date=request.getParameter("join_date");
		String pointStr=request.getParameter("point");
		int point=0;
//		String type=request.getParameter("type");
		
//		System.out.println("swGo 3 : " + type);
//		try {
//			age = Integer.parseInt(ageStr);
//			point= Integer.parseInt(pointStr);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		(String uid,String pw,String uname,String nickname,int age,char gender,String email,String phone,String address,Date join_date,int point,char type) 
		User uservo=new User(uid, pw, uname, nickname, age, gender.charAt(0), email, phone, address, point);
		
		
		int result=new UserService().insertUser(uservo);
		
		if(result>0) {
			request.setAttribute("result",result);
			HttpSession session=request.getSession();
			session.setAttribute("sessionID", uid);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.forward(request, response);
//			response.sendRedirect("main");
		}else {
			request.setAttribute("result", result);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/insertJoin.jsp");
			rd.forward(request, response);	
		}
		
		
		
	}

}
