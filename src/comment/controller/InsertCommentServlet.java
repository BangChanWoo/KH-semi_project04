package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.Comment;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/insertcomment")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String levelStr = request.getParameter("level");
		int level = 0;
		if(levelStr != null) {
			level = Integer.parseInt(levelStr);
		}
		String originStr = request.getParameter("origin");
		int origin = 0;
		if(originStr != null) {
			origin = Integer.parseInt(originStr);
		}

		String commentInput = request.getParameter("commentInput");

		String id = (String)request.getSession().getAttribute("sessionID");

		Comment vo = new Comment(rno, id, level, origin, commentInput);
		int result = new CommentService().insertComment(vo);

		if(result > 0) {
			response.sendRedirect("selectrecipe?rno="+rno);
		}else {
			response.sendRedirect("selectrecipe?rno="+rno);
		}
	}

}
