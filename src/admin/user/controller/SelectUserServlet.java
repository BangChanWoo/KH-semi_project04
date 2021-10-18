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
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//임시
		
		
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
		
		// 사용자 검색
		
//		System.out.println("-----------------------------------"+search_id);
//		ArrayList<User> volist3 = new adminUserService().adminUserList(search_id);
		
		
		int genderCount = new adminUserService().getGenderCount();
		System.out.println("남성 수 : " + genderCount);
		
		System.out.println(startRnum);
		System.out.println(endRnum);
		String uid="admin";
		ArrayList<User> volist = new adminUserService().adminUserList(startRnum,endRnum);
		
		ArrayList<User> volist3 = new adminUserService().getUserId();
		
		ArrayList<User> volist1 = new adminUserService().adminUserList(uid);
		ArrayList<User> volist2 = new adminUserService().getUserAge();
		int age1 = 0;
		int age2 = 0;
		int age3 = 0;
		int age4 = 0;
		int age5 = 0;
		int age6 = 0;
		int age0 = 0;
		int age11 = 0;
		int age22 = 0;
		int age33 = 0;
		int age44 = 0;
		int age55 = 0;
		int age66 = 0;
		int age00 = 0;
		if (volist2 != null) {
			System.out.println("null아님 select");
			for (User vo : volist2) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(vo.getAge());
				for (int a : list) {
					if (a >= 10 && a <= 19) {
						age1+=1;
						break;
					} else if (a >= 20 && a <= 29) {
						age2 ++;
						break;
					} else if (a >= 30 && a <= 39) {
						age3 ++;
						break;
					} else if (a >= 40 && a <= 49) {
						age4++;
						break;
					} else if (a >= 50 && a <= 59) {
						age5++;
						break;
					} else if (a >= 60 && a <= 69) {
						age6++;
						break;
					} else {
						age0++;
						break;
					}
				}
				
			}
			age11=age1;
			age22=age2;
			age33=age3;
			age44=age4;
			age55=age5;
			age66=age6;
			age00=age0;
		}
		
		//TODO
		//if() {}
		
//		String a = (String) request.getAttribute("a");
//		if(a == null) {
//			System.out.println("ㄴㄴㄴㄴ");
//		}
//		else {
//			System.out.println("00000");
//			PrintWriter out = response.getWriter();
//			
//			response.setContentType("text/html; charset=utf-8");
//			
//			out.println("<script language='javascript'>");
//			out.println("alert('없다없다요');");
//			out.println("</script>");
//			out.flush();
//		}
		
	
		request.setAttribute("adminUserList", volist);
		request.setAttribute("adminUserList1", volist1);
//		request.setAttribute("adminUserList3", volist3);
		//request.setAttribute("getUserAge", volist2);
		request.setAttribute("getUserId", volist3);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("bCount", bCount);
		request.setAttribute("genderCount", genderCount);
		
		//age넘겨주는것
		request.setAttribute("age11", age11);
		request.setAttribute("age22", age22);
		request.setAttribute("age33", age33);
		request.setAttribute("age44", age44);
		request.setAttribute("age55", age55);
		request.setAttribute("age66", age66);
		request.setAttribute("age00", age00);
		request.getRequestDispatcher("./WEB-INF/view/adminMemberManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
