package recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.model.service.RecipeService;
import user.vo.User;

/**
 * Servlet implementation class DeleteRecipeServlet
 */
@WebServlet("/deleterecipe")
public class DeleteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecipeServlet() {
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
		
		int result = new RecipeService().deleteRecipe(rno);
		
		if(result > 0) {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "recipeDelete");
			request.setAttribute("msg", "레시피 게시글 삭제를 성공했습니다.");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}else {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "recipeDelete");
			request.setAttribute("msg", "레시피 게시글 삭제를 실패했습니다.");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}
}
