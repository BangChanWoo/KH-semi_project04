package admin.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.NoticeService;
import notice.vo.Notice;
import notice.dao.NoticeDao;


/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insertnotice")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
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
		
		
		String notice_num = request.getParameter("notice_num");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		String notice_time = request.getParameter("notice_time");
		
//		String notice_numStr = request.getParameter("notice_num");
//		if(notice_numStr != null) {
//			notice_num = Integer.parseInt(notice_numStr);
//		}
//		System.out.println("notice_num:"+ notice_num);
//		Notice vo = new Notice(notice_num);
//		
//		request.setAttribute("nno", nno);
//		request.getRequestDispatcher("./WEB-INF/view/writenotice.jsp").forward(request, response);
//		int result = new NoticeService().insertNotice(noticevo);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
