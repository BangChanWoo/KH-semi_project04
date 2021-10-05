package admin.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.user.model.dao.adminUserDao;
import admin.user.model.service.adminUserService;
import user.vo.User;


/**
 * Servlet implementation class SelectMemberServlet
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//PrintWriter out = response.getWriter();
		
		
		final int PAGE_SIZE = 5;   // 한 페이지 당 글수
		final int PAGE_BLOCK = 3;   // 한 화면에 나타날 페이지 링크 수
		int bCount = 0;   // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1;   // 화면에 나타날 시작페이지
		int endPage = 1;   // 화면에 나타날 마지막페이지
		int currentPage = 1;
		int startRnum = 1;   // 화면에 글
		int endRnum = 1;  // 화면에 글
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum != null) {   // 눌려진 페이지가 있음.
			currentPage = Integer.parseInt(pageNum); // 눌려진 페이지
		}
		bCount = new adminUserService().getUserCount();
		System.out.println("test : "+bCount);
		
		
		// 총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당글수로 나눈 나머지가 0이 아니라면 페이지개수를 1 증가)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		//rownum 조건 계산
		startRnum = (currentPage-1) * PAGE_SIZE   + 1;   // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE -1; 
		if(endRnum > bCount) endRnum=bCount;
		
		if(currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1)  * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK)  * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1; 
		if(endPage > pageCount) endPage=pageCount;
		
		int genderCount = new adminUserService().getGenderCount();
		System.out.println("남성 수 : " + genderCount);
		
		System.out.println(startRnum);
		System.out.println(endRnum);
		String uid="admin";
		ArrayList<User> volist = new adminUserService().adminUserList(startRnum,endRnum);
		
		
		ArrayList<User> volist1 = new adminUserService().adminUserList(uid);
		
		
		//TODO
		request.setAttribute("adminUserList", volist);
		request.setAttribute("adminUserList1", volist1);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("bCount", bCount);
		request.setAttribute("genderCount", genderCount);
		
		request.getRequestDispatcher("/adminMemberManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
