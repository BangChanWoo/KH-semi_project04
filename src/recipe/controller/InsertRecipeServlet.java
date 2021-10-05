package recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ingredient.vo.Ingredient;
import recipe.model.service.RecipeService;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
import user.vo.User;

/**
 * Servlet implementation class InsertRecipeServlet
 */
@WebServlet("/insertrecipe.kh")
public class InsertRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRecipeServlet() {
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
			rno = Integer.parseInt(rnoStr);
		}
		//레시피
		//사진 경로 어떻게 가져오지
		String dropTitleLabel = request.getParameter("dropTitleLabel");
		String recipeTitle = request.getParameter("recipeTitle");
		String recipeIntro = request.getParameter("recipeIntro");
		String recipeVideo = request.getParameter("recipeVideo");
		String cateListStr = request.getParameter("cateList");
		int cateList = 0;
		if(cateListStr != null) {
			cateList = Integer.parseInt(cateListStr);
		}
		String servingList = request.getParameter("servingList");
		String timeList = request.getParameter("timeList");
		String levelList = request.getParameter("levelList");
		String recipeTip = request.getParameter("recipeTip");
		
//		//재료
//		for(int i = 0; i < ; i++) {
//			String ingreName = request.getParameter("recipeIngre_"+ i +");
//		}
		String ingreName = request.getParameter("recipeIngre_1");
		String ingreUnit = request.getParameter("recipeIngreUnit_1");
		
		//순서
		String stepContent = request.getParameter("recipeContent_1");
		String stepImg = request.getParameter("stepImg_1");
		
		User memberLoginInfo = (User)request.getSession().getAttribute("memberLoginInfo");
		String id = null;
		if(memberLoginInfo != null) {
			id = memberLoginInfo.getUid();
		}
		//잠깐 쓰자
		if(id == null) {
			id = "admin";
		}
		
		Recipe recipeVo = new Recipe(id, dropTitleLabel, recipeTitle, recipeIntro, recipeTip, servingList, timeList, levelList, recipeVideo, cateList);
		Ingredient ingreVo = new Ingredient(ingreName, ingreUnit);
		RecipeSteps stepVo = new RecipeSteps(stepContent, stepImg);
		int result = new RecipeService().insertRecipe(recipeVo, ingreVo, stepVo);
		if(result > 0) {
			request.getRequestDispatcher("./recipedetail?rno="+rno).forward(request, response);
		}else {
			request.setAttribute("msg", "레시피 게시글 작성 실패");
			request.getRequestDispatcher("boardlist").forward(request, response);
		}
		
		
		//request.setAttribute("rno", rno);
		//request.getRequestDispatcher("./recipedetail?rno="+rno).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
