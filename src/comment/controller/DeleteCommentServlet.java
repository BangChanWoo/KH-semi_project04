package comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import recipe.model.service.RecipeService;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deletecomment")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
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
		
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);  //눌려진 페이지
		}
		
		String comnoStr = request.getParameter("comno");
		int comno = 0;
		if(comnoStr != null) {
			comno = Integer.parseInt(comnoStr);  //눌려진 페이지
		}
		
		int result = new CommentService().deleteComment(comno);
		
		if(result > 0) {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "commentDelete");
			request.setAttribute("msg", "댓글 삭제 성공");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}else {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "commentDelete");
			request.setAttribute("msg", "댓글 삭제 실패");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
