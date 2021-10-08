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
 * Servlet implementation class SelectRecipeServlet
 */
@WebServlet("/selectrecipe")
public class SelectRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRecipeServlet() {
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
		
		String msg = request.getParameter("msg");
		String msgTxt = null;
		if(msg == null) {
			msgTxt = null;
		}
		else if(msg.equals("cancle")) {
			msgTxt = "게시글 수정을 취소하였습니다.";
		}
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
		
		//게시글에 달린 댓글 list
		//ArrayList<Recipe> commentList = new RecipeService().commentList(rno);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("rno", rno);
		request.setAttribute("ingreList", ingreList);
		request.setAttribute("stepList", stepList);
		request.setAttribute("msg", msgTxt);
		//request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("./WEB-INF/view/recipeDetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
