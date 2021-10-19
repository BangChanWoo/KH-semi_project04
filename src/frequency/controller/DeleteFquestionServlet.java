package frequency.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frequency.service.FrequencyService;


/**
 * Servlet implementation class DeleteFquestionServlet
 */
@WebServlet("/DeleteFquestionServlet")
public class DeleteFquestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFquestionServlet() {
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
		
		String fqnoStr = request.getParameter("rno");
		int fqno = 0;
		if(fqnoStr != null) {
			fqno = Integer.parseInt(fqnoStr);  //눌려진 페이지
		}
		
		int result = new FrequencyService().deleteFquestion(fqno);
		
		if(result > 0) {
			request.setAttribute("fqno", fqno);
			request.setAttribute("func", "deleteFQuestion");
			request.setAttribute("msg", "자주묻는질문 삭제를 성공했습니다.");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}else {
			request.setAttribute("rno", fqno);
			request.setAttribute("func", "deleteFQuestion");
			request.setAttribute("msg", "자주묻는질문 삭제를 실패했습니다.");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}

	}
}
