package question.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.model.service.adminProductService;
import user.vo.User;

/**
 * Servlet implementation class DeleteQuestionServlet
 */
@WebServlet("/DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionServlet() {
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
		String que_no = request.getParameter("que_no");
		int que_noInt = 0;
		if(que_no != null) {
			que_noInt = Integer.parseInt(que_no); 
		}
		User LoginInfo = (User)request.getSession().getAttribute("LoginInfo");
		String id = null;
		if(LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		System.out.println(que_noInt);
		
		if(id == null) {
			id = "admin";
		}
		int result = 0;
		if(writer == id || id.equals("admin")) {
			//TODO
//			result = new adminQuestionService().deleteQuestion(que_noInt);
		}
		if(result > 0) {
			//request.setAttribute("msg", "������ �Խñ� ������ �����߽��ϴ�.");
			System.out.println("���� ����");
			request.getRequestDispatcher("adminMainServlet").forward(request, response);
		}else {
			request.setAttribute("msg", "������ �Խñ� ������ �����߽��ϴ�.");
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
