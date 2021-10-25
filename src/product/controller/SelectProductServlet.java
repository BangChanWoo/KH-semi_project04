package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import product.service.ProductService;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;


/**
* Servlet implementation class SelectProductServlet
*/

@WebServlet("/selectproduct")
public class SelectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);
		}
		String id = (String)request.getSession().getAttribute("sessionID");
				
		int result = new ProductService().likeRead(rno, id);			
			if(result > 0) {
			request.setAttribute("like", "yes");
			}else {
			request.setAttribute("like", null);
			}
		
		//게시글 한개 정보
		ProductPost vo  = new ProductService().productDetailList(rno);
		
		//상품 옵션 리스트
		ArrayList<ProductOption> optionList = new ProductService().optionList(rno);
		
		//상품 상세설명 리스트
		ArrayList<ProductImg> proImgList = new ProductService().proImgList(rno);
		
				
		request.setAttribute("vo", vo);
		request.setAttribute("rno", rno);
		request.setAttribute("optionList", optionList);
		request.setAttribute("proImgList", proImgList);
		request.getRequestDispatcher("./WEB-INF/view/productDetail.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
