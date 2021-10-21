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
			rno = Integer.parseInt(rnoStr);  //������ ������
		}
		
		String comnoStr = request.getParameter("comno");
		int comno = 0;
		if(comnoStr != null) {
			comno = Integer.parseInt(comnoStr);  //������ ������
		}
		
		int result = new CommentService().deleteComment(comno);
		
		if(result > 0) {
			response.sendRedirect("selectrecipe?rno="+rno);
		}else {
			response.sendRedirect("selectrecipe?rno="+rno);
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
