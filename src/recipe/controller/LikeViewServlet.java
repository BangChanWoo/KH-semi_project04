package recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LikeViewServlet
 */
@WebServlet("/likeview")
public class LikeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeViewServlet() {
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
		//이 servlet은 레시피 보관 화면을 보여줌
		
		String rno = request.getParameter("rno");
		int rnoInt = 0;
		if(rno != null) {
			rnoInt = Integer.parseInt(rno);  //눌려진 페이지
		}
		
		request.setAttribute("like", "yes");
		request.getRequestDispatcher("./WEB-INF/view/likeRecipe.jsp").forward(request, response);
	
	}

	
}
