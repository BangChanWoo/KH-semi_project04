package admin.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.product.model.service.adminProductService;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;
import user.vo.User;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/view/productUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		User LoginInfo = (User) request.getSession().getAttribute("LoginInfo");
		String id = null;
		if (LoginInfo != null) {
			id = LoginInfo.getUid();
		}
		// 로그인 기능 완료되면 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (id == null) {
			id = "admin";
		}

		// 사진 업로드 설정
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		if (!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("view/error/Error.jsp");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		MultipartRequest multi = new MultipartRequest(request, // request 객체
				uploadPath, // 서버 상 업로드 될 디렉토리
				uploadSizeLimit, // 업로드 파일 크기 제한
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);

		String writer = multi.getParameter("writer");
		String pro_no = multi.getParameter("pro_no");
		int pnoInt = 0;
		if (pro_no != null) {
			pnoInt = Integer.parseInt(pro_no); // 눌려진 페이지
		}

		String uploadTitleImg = multi.getFilesystemName("uploadTitleImg");
		if (uploadTitleImg == null) {
			uploadTitleImg = multi.getParameter("defaultTitleImg");
		} else {
			uploadTitleImg = "upload/" + uploadTitleImg;
		}
		String productTitle = multi.getParameter("productTitle");
		//String productIntro = multi.getParameter("productIntro");
		String cateListStr = multi.getParameter("cateList");
		int cateList = 0;
		if (cateListStr != null) {
			cateList = Integer.parseInt(cateListStr);
		}
		String feeTextStr = multi.getParameter("feeText");
		int feeText = 0;
		if (feeTextStr != null) {
			feeText = Integer.parseInt(feeTextStr);
		}
		String productStockStr= multi.getParameter("productStock");
		int productStock = 0;
		if(productStockStr != null) {
			productStock = Integer.parseInt(productStockStr);
		}
		String productOptionPriceStr = multi.getParameter("productOptionPrice");

		int productOptionPrice = 0;
		if (productOptionPriceStr != null) {
			productOptionPrice = Integer.parseInt(productOptionPriceStr);
		}

		ProductPost productVo = new ProductPost(pnoInt,cateList, productTitle, uploadTitleImg, productOptionPrice, feeText, productStock);

		// 상품 옵션
		ArrayList<ProductOption> ProductOption = new ArrayList<ProductOption>();
		String optionName = null;

		String optionCountStr = multi.getParameter("optionCount");
		int optionCount = 0;
		if (optionCountStr != null) {
			optionCount = Integer.parseInt(optionCountStr);
		}
		for (int i = 1; i <= optionCount; i++) {
			System.out.println("옵션의 총 개수:" +  optionCount);
			ProductOption optionVo = new ProductOption(optionName);
			String proOptNameId = multi.getParameter("proOptNameId_"+i);
			int proOptNameIdInt=0;
			if(proOptNameId != null) {
				proOptNameIdInt = Integer.parseInt(proOptNameId);
				System.out.println("옵션 몇개간져오는지 확인"+proOptNameIdInt);
			}
			optionVo.setPro_option_no(proOptNameIdInt);
			optionVo.setPro_option_content(multi.getParameter("productOptionName_" + i));
			
			ProductOption.add(optionVo);
			System.out.println("productOptionName_" + i);
			System.out.println("옵션" + optionVo);
		}

		ArrayList<ProductImg> ProductImg = new ArrayList<ProductImg>();
		String stepImg = null;

		String stepCount = multi.getParameter("stepCount");
		int stepCnt = 0;
		if (stepCount != null) {
			stepCnt = Integer.parseInt(stepCount);
		}
		for (int i = 1; i <= stepCnt; i++) {
			ProductImg imgVo = new ProductImg(stepImg);
			String stepId = multi.getParameter("stepId_"+ i);
			int stepIdInt = 0;
			if(stepId != null) {
				stepIdInt = Integer.parseInt(stepId);
			}
			imgVo.setPro_content_no(stepIdInt);
			imgVo.setPro_content_img("upload/" + multi.getFilesystemName("uploadStepImg_" + i));
			String uploadStemImg=multi.getFilesystemName("uploadStepImg_" + i);
			if(uploadStemImg == null) {
				imgVo.setPro_content_img(multi.getParameter("defaultStepImg_"+i));
			}else {
				imgVo.setPro_content_img("upload/" + uploadStemImg);
			}
			ProductImg.add(imgVo);
			System.out.println("이미지" + imgVo);
		}
	
		int result = 0;
		if(writer == id || id.equals("admin")) {
			result = new adminProductService().updateProduct(productVo, ProductOption, ProductImg);
		}
		//후에 지울것
		else {
			result = new adminProductService().updateProduct(productVo, ProductOption, ProductImg);
		}
		
		if(result > 0) {
			request.setAttribute("msg", "변경 성공");
			//request.getRequestDispatcher("productboard?rno="+pro_no).forward(request, response);
			request.getRequestDispatcher("adminMainServlet").forward(request, response);
		}else {
			request.setAttribute("msg", "변경 실패");
			//request.getRequestDispatcher("productboard?rno="+pro_no).forward(request, response);
			request.getRequestDispatcher("adminMainServlet").forward(request, response);
		}
	}

}
