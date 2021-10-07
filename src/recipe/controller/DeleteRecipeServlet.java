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
		
		String writer = request.getParameter("writer");
		String rno = request.getParameter("rno");
		int rnoInt = 0;
		if(rno != null) {
			rnoInt = Integer.parseInt(rno);  //눌려진 페이지
		}
		User LoginInfo = (User)request.getSession().getAttribute("LoginInfo");
		String id = null;
		if(LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		System.out.println(rnoInt);
		//로그인 기능 완료되면 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(id == null) {
			id = "admin";
		}
		
		int result = 0;
		if(writer == id || id.equals("admin")) {
			result = new RecipeService().deleteRecipe(rnoInt);
		}
		
		if(result > 0) {
			//request.setAttribute("msg", "레시피 게시글 삭제에 성공했습니다.");
			request.getRequestDispatcher("main?msg=레시피 게시글 삭제에 성공했습니다.").forward(request, response);
		}else {
			request.setAttribute("msg", "레시피 게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("recipedetail?rno="+rno).forward(request, response);
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
