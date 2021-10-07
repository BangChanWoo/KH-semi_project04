package admin.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.user.model.service.adminUserService;
import user.vo.User;

/**
 * Servlet implementation class userInfo
 */
@WebServlet("/userInfo")
public class userInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("asdasd");
		String uid = request.getParameter("id");
		System.out.println("요청한 입력 데이터 : id = " + uid);
		
//		String pw=request.getParameter("pw"); 
//		String uname=request.getParameter("uname");  
//		String nickname=request.getParameter("nickname"); 
//		int age=Integer.parseInt(request.getParameter("age"));
//		String gender=request.getParameter("gender");  
//		String phone=request.getParameter("phone"); 
//		String address=request.getParameter("address"); 
//		int point=Integer.parseInt(request.getParameter("point"));
//		String kind=request.getParameter("kind"); 
		
		
		ArrayList<User> volist1 = new adminUserService().adminUserList(uid);
//		int result=0;
//		
//		result = new adminUserService().updateUser(pw, uname, nickname, age, gender, phone, address, point, kind, uid);
		
		
		
		
		
//		if(volist1 != null) {
//			System.out.println("null아님");
//			for (User vo : volist1) {
//				System.out.println(vo.getUid());
//				System.out.println(vo.getPw());
//				System.out.println(vo.getUname());
//				System.out.println(vo.getJoin_date());
//				}
//			}
		
		
		
		request.setAttribute("adminUserList1", volist1);
		request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
