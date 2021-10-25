package recipe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.Comment;
import ingredient.vo.Ingredient;
import recipe.model.service.RecipeService;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
import user.vo.User;

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
		
		String msg = (String)request.getAttribute("msg");
		String msgTxt = null;
		if(msg == null) {
			msgTxt = null;
		}
		else if(msg.equals("cancle")) {
			msgTxt = "게시글 수정을 취소하였습니다.";
		}else {
			msgTxt = msg;
		}
		
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);
		}
		String id = (String)request.getSession().getAttribute("sessionID");
		System.out.println("받아온 아이디 : " + id);
		
		
		
		System.out.println("rno 값 : " + rno);
		String rec_title = request.getParameter("recipe_name");
		System.out.println("가져온 recipe 이름 : " + rec_title);
		Recipe vo1  = new RecipeService().recipeTitleList(rec_title);
		System.out.println("레시피 이름으로 가져온 해당 레시피 번호 : "+vo1.getRecipe_no());
		
		
		if(id==null) {
			System.out.println(rno+"로그아웃 된 상황");
			//게시글 한개 정보
			Recipe vo  = new RecipeService().recipeDetailList(rno);
			
			//재료 리스트
			ArrayList<Ingredient> ingreList = new RecipeService().ingreList(rno);
			
			//순서 리스트
			ArrayList<RecipeSteps> stepList = new RecipeService().stepList(rno);
			//게시글에 달린 댓글 list
					final int PAGE_SIZE = 5;  //한페이지당 글 수 
					final int PAGE_BLOCK = 3;  //한화면에 나타날 페이지 링크 수
					int rCount = 0;  //총 글수
					int pageCount = 0;  //총페이지 수 
					int startPage = 1;  //화면에 나타날 시작페이지
					int endPage = 1;  //화면에 나타날 마지막페이지
					int currentPage =1;  //눌려진 페이지
					int startRnum = 1; //화면에 나타날 글 번호
					int endRnum = 1; //화면에 나타날 글 번호

					String pageNum = request.getParameter("pagenum");
					if(pageNum != null) {
						currentPage = Integer.parseInt(pageNum);
					}
					rCount = new CommentService().getCommentCount(rno);

					pageCount = (rCount/PAGE_SIZE) + (rCount%PAGE_SIZE == 0 ? 0 : 1);

					startRnum = (currentPage - 1) * PAGE_SIZE + 1;
					endRnum = startRnum + PAGE_SIZE -1;
					if(endRnum > rCount) {
						endRnum = rCount;
					}

					if(currentPage%PAGE_BLOCK == 0) {
						startPage = (currentPage/PAGE_BLOCK - 1) *PAGE_BLOCK + 1;
					}else {
						startPage = (currentPage/PAGE_BLOCK) *PAGE_BLOCK + 1;
					}

					endPage = startPage + PAGE_BLOCK - 1;
					if(endPage > pageCount) {
						endPage = pageCount;
					}

					ArrayList<Comment> commentList = new CommentService().commentList(rno, startRnum, endRnum);
			
			
			
			request.setAttribute("vo", vo);
			request.setAttribute("rno", rno);
			request.setAttribute("ingreList", ingreList);
			request.setAttribute("stepList", stepList);
			request.setAttribute("msg", msgTxt);
			request.setAttribute("commentList", commentList);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("./WEB-INF/view/recipeDetail.jsp").forward(request, response);
		}
		else if(id.equals("admin") && rno != 0) {
			int result = new RecipeService().likeRead(rno, id);
			//게시글 한개 정보
			Recipe vo  = new RecipeService().recipeDetailList(rno);
			
			//재료 리스트
			ArrayList<Ingredient> ingreList = new RecipeService().ingreList(rno);
			
			//순서 리스트
			ArrayList<RecipeSteps> stepList = new RecipeService().stepList(rno);
			//게시글에 달린 댓글 list
					final int PAGE_SIZE = 5;  //한페이지당 글 수 
					final int PAGE_BLOCK = 3;  //한화면에 나타날 페이지 링크 수
					int rCount = 0;  //총 글수
					int pageCount = 0;  //총페이지 수 
					int startPage = 1;  //화면에 나타날 시작페이지
					int endPage = 1;  //화면에 나타날 마지막페이지
					int currentPage =1;  //눌려진 페이지
					int startRnum = 1; //화면에 나타날 글 번호
					int endRnum = 1; //화면에 나타날 글 번호

					String pageNum = request.getParameter("pagenum");
					if(pageNum != null) {
						currentPage = Integer.parseInt(pageNum);
					}
					rCount = new CommentService().getCommentCount(rno);

					pageCount = (rCount/PAGE_SIZE) + (rCount%PAGE_SIZE == 0 ? 0 : 1);

					startRnum = (currentPage - 1) * PAGE_SIZE + 1;
					endRnum = startRnum + PAGE_SIZE -1;
					if(endRnum > rCount) {
						endRnum = rCount;
					}

					if(currentPage%PAGE_BLOCK == 0) {
						startPage = (currentPage/PAGE_BLOCK - 1) *PAGE_BLOCK + 1;
					}else {
						startPage = (currentPage/PAGE_BLOCK) *PAGE_BLOCK + 1;
					}

					endPage = startPage + PAGE_BLOCK - 1;
					if(endPage > pageCount) {
						endPage = pageCount;
					}

					ArrayList<Comment> commentList = new CommentService().commentList(rno, startRnum, endRnum);
			
			if(result > 0) {
				request.setAttribute("like", "yes");
			}else {
				request.setAttribute("like", null);
			}
			request.setAttribute("vo", vo);
			request.setAttribute("rno", rno);
			request.setAttribute("ingreList", ingreList);
			request.setAttribute("stepList", stepList);
			request.setAttribute("msg", msgTxt);
			request.setAttribute("commentList", commentList);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("./WEB-INF/view/adminRecipeDetail.jsp").forward(request, response);
		}
		else if(id.equals("admin") && vo1.getRecipe_no() != 0) {
			System.out.println("else if 문 진입");
			rno = vo1.getRecipe_no();
			int result = new RecipeService().likeRead(rno, id);
			//게시글 한개 정보
			Recipe vo  = new RecipeService().recipeDetailList(rno);
			
			//재료 리스트
			ArrayList<Ingredient> ingreList = new RecipeService().ingreList(rno);
			
			//순서 리스트
			ArrayList<RecipeSteps> stepList = new RecipeService().stepList(rno);
			//게시글에 달린 댓글 list
					final int PAGE_SIZE = 5;  //한페이지당 글 수 
					final int PAGE_BLOCK = 3;  //한화면에 나타날 페이지 링크 수
					int rCount = 0;  //총 글수
					int pageCount = 0;  //총페이지 수 
					int startPage = 1;  //화면에 나타날 시작페이지
					int endPage = 1;  //화면에 나타날 마지막페이지
					int currentPage =1;  //눌려진 페이지
					int startRnum = 1; //화면에 나타날 글 번호
					int endRnum = 1; //화면에 나타날 글 번호

					String pageNum = request.getParameter("pagenum");
					if(pageNum != null) {
						currentPage = Integer.parseInt(pageNum);
					}
					rCount = new CommentService().getCommentCount(rno);

					pageCount = (rCount/PAGE_SIZE) + (rCount%PAGE_SIZE == 0 ? 0 : 1);

					startRnum = (currentPage - 1) * PAGE_SIZE + 1;
					endRnum = startRnum + PAGE_SIZE -1;
					if(endRnum > rCount) {
						endRnum = rCount;
					}

					if(currentPage%PAGE_BLOCK == 0) {
						startPage = (currentPage/PAGE_BLOCK - 1) *PAGE_BLOCK + 1;
					}else {
						startPage = (currentPage/PAGE_BLOCK) *PAGE_BLOCK + 1;
					}

					endPage = startPage + PAGE_BLOCK - 1;
					if(endPage > pageCount) {
						endPage = pageCount;
					}

					ArrayList<Comment> commentList = new CommentService().commentList(rno, startRnum, endRnum);
			
			if(result > 0) {
				request.setAttribute("like", "yes");
			}else {
				request.setAttribute("like", null);
			}
			request.setAttribute("vo", vo);
			request.setAttribute("rno", rno);
			request.setAttribute("ingreList", ingreList);
			request.setAttribute("stepList", stepList);
			request.setAttribute("msg", msgTxt);
			request.setAttribute("commentList", commentList);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("./WEB-INF/view/adminRecipeDetail.jsp").forward(request, response);
			
		}
		else if(id.equals("admin") && vo1.getRecipe_no() == 0){
			request.setAttribute("result33", "검색값없음");
			request.getRequestDispatcher("./adminRecipeList").forward(request, response);
		}
		else {
			int result = new RecipeService().likeRead(rno, id);
			//게시글 한개 정보
			Recipe vo  = new RecipeService().recipeDetailList(rno);
			
			//재료 리스트
			ArrayList<Ingredient> ingreList = new RecipeService().ingreList(rno);
			
			//순서 리스트
			ArrayList<RecipeSteps> stepList = new RecipeService().stepList(rno);
			//게시글에 달린 댓글 list
					final int PAGE_SIZE = 5;  //한페이지당 글 수 
					final int PAGE_BLOCK = 3;  //한화면에 나타날 페이지 링크 수
					int rCount = 0;  //총 글수
					int pageCount = 0;  //총페이지 수 
					int startPage = 1;  //화면에 나타날 시작페이지
					int endPage = 1;  //화면에 나타날 마지막페이지
					int currentPage =1;  //눌려진 페이지
					int startRnum = 1; //화면에 나타날 글 번호
					int endRnum = 1; //화면에 나타날 글 번호

					String pageNum = request.getParameter("pagenum");
					if(pageNum != null) {
						currentPage = Integer.parseInt(pageNum);
					}
					rCount = new CommentService().getCommentCount(rno);

					pageCount = (rCount/PAGE_SIZE) + (rCount%PAGE_SIZE == 0 ? 0 : 1);

					startRnum = (currentPage - 1) * PAGE_SIZE + 1;
					endRnum = startRnum + PAGE_SIZE -1;
					if(endRnum > rCount) {
						endRnum = rCount;
					}

					if(currentPage%PAGE_BLOCK == 0) {
						startPage = (currentPage/PAGE_BLOCK - 1) *PAGE_BLOCK + 1;
					}else {
						startPage = (currentPage/PAGE_BLOCK) *PAGE_BLOCK + 1;
					}

					endPage = startPage + PAGE_BLOCK - 1;
					if(endPage > pageCount) {
						endPage = pageCount;
					}

					ArrayList<Comment> commentList = new CommentService().commentList(rno, startRnum, endRnum);
			
			if(result > 0) {
				request.setAttribute("like", "yes");
			}else {
				request.setAttribute("like", null);
			}
			
			request.setAttribute("vo", vo);
			request.setAttribute("rno", rno);
			request.setAttribute("ingreList", ingreList);
			request.setAttribute("stepList", stepList);
			request.setAttribute("msg", msgTxt);
			request.setAttribute("commentList", commentList);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("./WEB-INF/view/recipeDetail.jsp").forward(request, response);
		}
		
	}
}