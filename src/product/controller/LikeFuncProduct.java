package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.service.ProductService;

/**
 * Servlet implementation class LikeProduct
 */
@WebServlet("/prolikeornot")
public class LikeFuncProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeFuncProduct() {
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
		
		String id = (String)request.getSession().getAttribute("sessionID");
		
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			rno = Integer.parseInt(rnoStr);
		}
		
		String like = request.getParameter("like");
		int result = 0;
		if(like == null) {
			result = new ProductService().likeCreate(rno, id);
		}else if(like.equals("yes")){
			result = new ProductService().likeDelete(rno, id);
		}
		response.sendRedirect("selectproduct?rno="+rno);
	}

}
