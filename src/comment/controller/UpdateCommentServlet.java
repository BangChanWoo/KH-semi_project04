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
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updatecomment")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);
		}
		System.out.println(rno);
		String comnoStr = request.getParameter("comno");
		int comno = 0;
		if(comnoStr != null) {
			comno = Integer.parseInt(comnoStr);
		}
		String commentInput = request.getParameter("commentInput");
		
		Comment vo = new Comment(comno, commentInput);
		int result = new CommentService().updateComment(vo);
		
		if(result > 0) {
			request.setAttribute("func", "commentUpdate");
			request.setAttribute("msg", "변경 성공");
			request.setAttribute("rno", rno);
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}else {
			request.setAttribute("func", "commentUpdate");
			request.setAttribute("msg", "변경 실패");
			request.setAttribute("rno", rno);
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}
}
