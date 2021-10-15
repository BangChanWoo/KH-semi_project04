package main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.MainService;
import product_post.vo.ProductPost;
import recipe.model.vo.Recipe;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		String searchField = request.getParameter("searchField");
		if(searchField == null) {
			ArrayList<Recipe> recipeList = new MainService().recipeList();
			ArrayList<ProductPost> productList = new MainService().productList();
			
			String check = request.getParameter("check");
			request.setAttribute("check", check);
			request.setAttribute("r_startPage", 0);
			request.setAttribute("r_endPage", 0);
			request.setAttribute("r_pageCount", 0);
			request.setAttribute("p_startPage", 0);
			request.setAttribute("p_endPage", 0);
			request.setAttribute("p_pageCount", 0);
			request.setAttribute("recipeRecommendList", recipeList);
			request.setAttribute("productRecommendList", productList);
		}else {
			//레시피
			final int r_PAGE_SIZE = 20;  //한페이지당 글 수 
			final int r_PAGE_BLOCK = 5;  //한화면에 나타날 페이지 링크 수
			int r_rCount = 0;  //총 글수
			int r_pageCount = 0;  //총페이지 수 
			int r_startPage = 1;  //화면에 나타날 시작페이지
			int r_endPage = 1;  //화면에 나타날 마지막페이지
			int r_currentPage =1;  //눌려진 페이지
			int r_startRnum = 1; //화면에 나타날 글 번호
			int r_endRnum = 1; //화면에 나타날 글 번호
			
			String r_pageNum = request.getParameter("r_pagenum");
			if(r_pageNum != null) {
				r_currentPage = Integer.parseInt(r_pageNum);
			}
			r_rCount = new MainService().getRecipeCount(searchField);
			
			r_pageCount = (r_rCount/r_PAGE_SIZE) + (r_rCount%r_PAGE_SIZE == 0 ? 0 : 1);

			r_startRnum = (r_currentPage - 1) * r_PAGE_SIZE + 1;
			r_endRnum = r_startRnum + r_PAGE_SIZE -1;
			if(r_endRnum > r_rCount) {
				r_endRnum = r_rCount;
			}
			
			if(r_currentPage%r_PAGE_BLOCK == 0) {
				r_startPage = (r_currentPage/r_PAGE_BLOCK - 1) *r_PAGE_BLOCK + 1;
			}else {
				r_startPage = (r_currentPage/r_PAGE_BLOCK) *r_PAGE_BLOCK + 1;
			}
			
			r_endPage = r_startPage + r_PAGE_BLOCK - 1;
			if(r_endPage > r_pageCount) {
				r_endPage = r_pageCount;
			}
			
			//상품
			final int p_PAGE_SIZE = 20;  //한페이지당 글 수 
			final int p_PAGE_BLOCK = 5;  //한화면에 나타날 페이지 링크 수
			int p_rCount = 0;  //총 글수
			int p_pageCount = 0;  //총페이지 수 
			int p_startPage = 1;  //화면에 나타날 시작페이지
			int p_endPage = 1;  //화면에 나타날 마지막페이지
			int p_currentPage =1;  //눌려진 페이지
			int p_startRnum = 1; //화면에 나타날 글 번호
			int p_endRnum = 1; //화면에 나타날 글 번호
			
			String p_pageNum = request.getParameter("p_pagenum");
			if(p_pageNum != null) {
				p_currentPage = Integer.parseInt(p_pageNum);
			}
			p_rCount = new MainService().getProductCount(searchField);
			
			p_pageCount = (p_rCount/p_PAGE_SIZE) + (p_rCount%p_PAGE_SIZE == 0 ? 0 : 1);

			p_startRnum = (p_currentPage - 1) * p_PAGE_SIZE + 1;
			p_endRnum = p_startRnum + p_PAGE_SIZE -1;
			if(p_endRnum > p_rCount) {
				p_endRnum = p_rCount;
			}
			
			if(p_currentPage%p_PAGE_BLOCK == 0) {
				p_startPage = (p_currentPage/p_PAGE_BLOCK - 1) *p_PAGE_BLOCK + 1;
			}else {
				p_startPage = (p_currentPage/p_PAGE_BLOCK) *p_PAGE_BLOCK + 1;
			}
			
			p_endPage = p_startPage + p_PAGE_BLOCK - 1;
			if(p_endPage > p_pageCount) {
				p_endPage = p_pageCount;
			}
			
			ArrayList<Recipe> recipeList = new MainService().searchRecipe(r_startRnum, r_endRnum, searchField);
			ArrayList<ProductPost> productList = new MainService().searchProduct(p_startRnum, p_endRnum, searchField);
			
			String check = request.getParameter("check");
			request.setAttribute("check", check);
			request.setAttribute("r_startPage", r_startPage);
			request.setAttribute("r_endPage", r_endPage);
			request.setAttribute("r_pageCount", r_pageCount);
			request.setAttribute("p_startPage", p_startPage);
			request.setAttribute("p_endPage", p_endPage);
			request.setAttribute("p_pageCount", p_pageCount);
			request.setAttribute("searchField", searchField);
			request.setAttribute("recipeSearchList", recipeList);
			request.setAttribute("productSearchList", productList);
		}
		request.getRequestDispatcher("./WEB-INF/view/search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
