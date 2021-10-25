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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			
			
//			String notice_num = request.getParameter("notice_num");
//			String notice_title = request.getParameter("notice_title");
//			String notice_content = request.getParameter("notice_content");
//			String notice_time = request.getParameter("notice_time");
			
			String rnoStr = request.getParameter("rno");
			int rno = 0;
			if(rnoStr != null) {
				rno = Integer.parseInt(rnoStr);
			}
			
			Notice vo = new Notice();
			int result = new NoticeService().insertNotice(vo);
			if(result > 0) {
				request.setAttribute("func", "noticeInsert");
				request.setAttribute("msg","게시글 작성을 성공했습니다");
				request.getRequestDispatcher("./WEB-INF/view/adminWriteNotice.jsp").forward(request, response);
			request.setAttribute("rno", rno);
			request.getRequestDispatcher("./WEB-INF/view/adminWriteNotice.jsp").forward(request, response);
			}
    } 	

			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

}
