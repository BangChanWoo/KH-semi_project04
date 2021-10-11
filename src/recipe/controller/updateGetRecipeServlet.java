package recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ingredient.vo.Ingredient;
import recipe.model.service.RecipeService;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;

/**
 * Servlet implementation class updateGetRecipeServlet
 */
@WebServlet("/updateget")
public class updateGetRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGetRecipeServlet() {
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
		//게시글 한개 정보
		Recipe vo  = new RecipeService().recipeDetailList(rno);
		
		//재료 리스트
		ArrayList<Ingredient> ingreList = new RecipeService().ingreList(rno);
		
		//순서 리스트
		ArrayList<RecipeSteps> stepList = new RecipeService().stepList(rno);
		
		request.setAttribute("vo", vo);
		request.setAttribute("rno", rno);
		request.setAttribute("ingreList", ingreList);
		request.setAttribute("stepList", stepList);
		request.getRequestDispatcher("./WEB-INF/view/recipeUpdate.jsp").forward(request, response);
	}
}
