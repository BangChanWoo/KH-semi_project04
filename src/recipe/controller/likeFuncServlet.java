package recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.model.service.RecipeService;
import user.vo.User;

/**
 * Servlet implementation class likeFuncServlet
 */
@WebServlet("/likeornot")
public class likeFuncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likeFuncServlet() {
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
		//이 servlet은 레시피 보관 화면을 보여줌
		
		User LoginInfo = (User)request.getSession().getAttribute("LoginInfo");
		String id = null;
		if(LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		//로그인 기능 완료되면 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(id == null) {
			id = "kyy806";
		}
		
		String rno = request.getParameter("rno");
		int rnoInt = 0;
		if(rno != null) {
			rnoInt = Integer.parseInt(rno);  //눌려진 페이지
		}
		
		String like = request.getParameter("like");
		int result = 0;
		if(like == null) {
			result = new RecipeService().likeCreate(rnoInt, id);
		}else if(like.equals("yes")){
			result = new RecipeService().likeDelete(rnoInt, id);
		}
		response.sendRedirect("selectrecipe?rno="+rnoInt);
	}
}
