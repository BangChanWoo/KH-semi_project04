package frequency.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frequency.service.FrequencyService;
import frequency.vo.Fquestion;

/**
 * Servlet implementation class FrequencyView
 */
@WebServlet("/fquestiondetail")
public class FquestionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FquestionViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int f_question_num =1;
		
		String f_question_numStr = request.getParameter("f_question_num");
		if(f_question_numStr != null) {
			f_question_num = Integer.parseInt(f_question_numStr);
		}
		System.out.println("f_question_num:"+f_question_num);
		
		Fquestion vo = new FrequencyService().fquestionDetailList(f_question_num);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("f_question_num", f_question_num);
		request.getRequestDispatcher("./WEB-INF/view/fquestion_detail.jsp").forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
