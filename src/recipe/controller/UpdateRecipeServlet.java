package recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ingredient.vo.Ingredient;
import recipe.model.service.RecipeService;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
import user.vo.User;

/**
 * Servlet implementation class UpdateRecipeServlet
 */
@WebServlet("/updaterecipe")
public class UpdateRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecipeServlet() {
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
		
		User LoginInfo = (User)request.getSession().getAttribute("LoginInfo");
		String id = null;
		if(LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		//로그인 기능 완료되면 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(id == null) {
			id = "admin";
		}
		
		//사진 업로드 설정
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		
		//enctype="multipart/form-data" 로 전송되었는지 확인
		if(!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("view/error/Error.jsp");
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		MultipartRequest multi = new MultipartRequest(request, // request 객체
			uploadPath, // 서버 상 업로드 될 디렉토리
			uploadSizeLimit, // 업로드 파일 크기 제한
			encType, // 인코딩 방법
			new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);
		
		String writer = multi.getParameter("writer");
		String rno = multi.getParameter("rno");
		int rnoInt = 0;
		if(rno != null) {
			rnoInt = Integer.parseInt(rno);  //눌려진 페이지
		}
		
		//레시피
		String uploadTitleImg = multi.getFilesystemName("uploadTitleImg");
		if(uploadTitleImg == null) {
			uploadTitleImg = multi.getParameter("defaultTitleImg");
		}else {
			uploadTitleImg = "upload/" + uploadTitleImg;
		}
		String recipeTitle = multi.getParameter("recipeTitle");
		String recipeIntro = multi.getParameter("recipeIntro");
		String recipeVideo = multi.getParameter("recipeVideo");
		String cateListStr = multi.getParameter("cateList");
		int cateList = 0;
		if(cateListStr != null) {
			cateList = Integer.parseInt(cateListStr);
		}
		String servingList = multi.getParameter("servingList");
		String timeList = multi.getParameter("timeList");
		String levelList = multi.getParameter("levelList");
		String recipeTip = multi.getParameter("recipeTip");
		
		Recipe recipeVo = new Recipe(rnoInt, id, uploadTitleImg, recipeTitle, recipeIntro, recipeTip, servingList, timeList, levelList, recipeVideo, cateList);
		
		//재료
		ArrayList<Ingredient> IngreList = new ArrayList<Ingredient>();
		String ingreName = null;
		String ingreUnit = null;
				
		String ingreCount = multi.getParameter("ingreCount");
		int ingreCnt = 0;
		if(ingreCount != null) {
			ingreCnt = Integer.parseInt(ingreCount);
		}
		for(int i = 1; i <= ingreCnt; i++) {
			Ingredient ingreVo = new Ingredient(ingreName, ingreUnit);
			String ingreId = multi.getParameter("ingreId_"+ i);
			int ingreIdInt = 0;
			if(ingreId != null) {
				ingreIdInt = Integer.parseInt(ingreId);
			}
			ingreVo.setIngre_no(ingreIdInt);
			ingreVo.setIngre_name(multi.getParameter("recipeIngre_"+ i));
			ingreVo.setIngre_unit(multi.getParameter("recipeIngreUnit_"+ i));
			IngreList.add(ingreVo);
		}
				
		//순서
		ArrayList<RecipeSteps> stepList = new ArrayList<RecipeSteps>();
		String stepContent = null;
		String stepImg = null;
				
		String stepCount = multi.getParameter("stepCount");
		int stepCnt = 0;
		if(stepCount != null) {
			stepCnt = Integer.parseInt(stepCount);
		}
		for(int i = 1; i <= stepCnt; i++) {
			RecipeSteps stepVo = new RecipeSteps(stepContent, stepImg);
			String stepId = multi.getParameter("stepId_"+ i);
			int stepIdInt = 0;
			if(stepId != null) {
				stepIdInt = Integer.parseInt(stepId);
			}
			stepVo.setStep_no(stepIdInt);
			stepVo.setStep_content(multi.getParameter("recipeContent_"+ i));
			
			String uploadStepImg = multi.getFilesystemName("uploadStepImg_"+ i);
			if(uploadStepImg == null) {
				stepVo.setStep_img(multi.getParameter("defaultStepImg_"+ i));
			}else {
				stepVo.setStep_img("upload/" + uploadStepImg);
			}
			
			stepList.add(stepVo);
		}
		
		int result = 0;
		if(writer == id || id.equals("admin")) {
			result = new RecipeService().updateRecipe(recipeVo, IngreList, stepList);
		}
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			request.setAttribute("func", "recipeUpdate");
			request.setAttribute("msg", "변경 성공");
			request.setAttribute("rno", rno);
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}else {
			request.setAttribute("func", "recipeUpdate");
			request.setAttribute("msg", "변경 실패");
			request.setAttribute("rno", rno);
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}

}
