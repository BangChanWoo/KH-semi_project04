package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class updateCommentViewServlet
 */
@WebServlet("/commentupdateget")
public class updateCommentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCommentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);
		}
		String comnoStr = request.getParameter("comno");
		int comno = 0;
		if(comnoStr != null) {
			comno = Integer.parseInt(comnoStr);
		}
		//게시글 한개 정보
		Comment vo  = new CommentService().commentUpdateGet(comno);
		
		request.setAttribute("rno", rno);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("./WEB-INF/view/commentUpdate.jsp").forward(request, response);
	}
}
