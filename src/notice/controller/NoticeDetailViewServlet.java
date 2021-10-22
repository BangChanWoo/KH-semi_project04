package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.NoticeService;
import notice.vo.Notice;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/userdetailnotice")
public class NoticeDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int notice_num =1;  //눌려진 페이지
		
		String notice_numStr = request.getParameter("notice_num");
		if(notice_numStr != null) {
			notice_num = Integer.parseInt(notice_numStr);
		}
		System.out.println("notice_num:"+ notice_num);
		
		Notice vo = new NoticeService().noticeDetailList(notice_num);

		System.out.println("noticeList:"+ vo);
		
		request.setAttribute("vo", vo);	
		request.setAttribute("notice_num", notice_num);	
		request.getRequestDispatcher("./WEB-INF/view/notice_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
