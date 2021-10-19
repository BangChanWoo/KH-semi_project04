package frequency.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import frequency.service.FrequencyService;
import recipe.model.service.RecipeService;
import recipe.model.vo.Recipe;

/**
 * Servlet implementation class InsertFquestionServlet
 */
@WebServlet("/InsertFquestionServlet")
public class InsertFquestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFquestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");
		
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
		
		//TODO
		String uploadTitleImg = "upload/" + multi.getFilesystemName("uploadTitle");
		String fquestionTitle = multi.getParameter("fquestionTitle");
		String fquestionContent = multi.getParameter("fquestionContent");
		String cateListStr = multi.getParameter("cateList");
		int cateList = 0;
		if(cateListStr != null) {
			cateList = Integer.parseInt(cateListStr);
		}
	
		//TODO
//		FQuestion fquestionVo = new FQuestion(id, fquestionTitle, fquestionContent, cateList);
			
//		int result = new FrequencyService().insertFquestion(fquestionVo);
//		if(result > 0) {
//			request.setAttribute("func", "fquestionInsert");
//			request.setAttribute("msg", "자주묻는질문 작성을 성공했습니다.");
//			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
//		}else {
//			request.setAttribute("func", "fquestionInsert");
//			request.setAttribute("msg", "자주묻는질문 작성을 실패했습니다.");
//			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
//		}
//	
//		}

	}
	}
