package admin.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.model.service.adminProductService;
import user.vo.User;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
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
		String pro_no = request.getParameter("pro_no");
		int pro_noInt = 0;
		if(pro_no != null) {
			pro_noInt = Integer.parseInt(pro_no);  //눌려진 페이지
		}
		User LoginInfo = (User)request.getSession().getAttribute("LoginInfo");
		String id = null;
		if(LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		System.out.println(pro_noInt);
		//로그인 기능 완료되면 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(id == null) {
			id = "admin";
		}
		int result = 0;
		if(writer == id || id.equals("admin")) {
			result = new adminProductService().deleteProduct(pro_noInt);
		}
		if(result > 0) {
			//request.setAttribute("msg", "레시피 게시글 삭제에 성공했습니다.");
			request.getRequestDispatcher("adminMainServlet").forward(request, response);
		}else {
			request.setAttribute("msg", "레시피 게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("adminMainServlet").forward(request, response);
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
