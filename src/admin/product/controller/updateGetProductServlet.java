package admin.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.model.service.adminProductService;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;

/**
 * Servlet implementation class updateGetProductServlet
 */
@WebServlet("/updateGetProductServlet")
public class updateGetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGetProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pro_noStr = request.getParameter("pro_no");
		// 후에 지울 것-----------------------------------------------
		int pro_no = 21;
//		if(pro_noStr != null) {
//			pro_no = Integer.parseInt(pro_noStr);
//		}
		ProductPost vo = new adminProductService().productDetailList(pro_no);
		
		ArrayList<ProductOption> ProductOption = new adminProductService().ProductOption(pro_no);
		
		ArrayList<ProductImg> ProductImg = new adminProductService().ProductImg(pro_no);
		
//		if(ProductOption != null) {
//			for(ProductOption vo1 : ProductOption) {
//				System.out.println(vo1.getPro_option_content());
//				System.out.println(vo1.getPro_option_no());
//				int iCnt = 0;
//				for(iCnt = 0; iCnt<productOptionList.size(); iCnt++) {
//						System.out.println("--------------for문 확인"+iCnt);
//						System.out.println(vo1.getPro_option_content());
//						System.out.println(vo1.getPro_option_no());
//					}
//				System.out.println("jsp에서는 왜 안돌아가니"+productOptionList.get(1).getPro_option_content());
//				System.out.println("상품옵션 리스트 사이즈"+ProductOption.size());
//			}
//		}
//		if(ProductImg != null) {
//			for(ProductImg vo2 : ProductImg) {
//				System.out.println(vo2.getPro_content_no());
//				System.out.println(vo2.getPro_content_img());
//			}
//			System.out.println("상품이미지 리스트 사이즈"+ProductImg.size());
//		}else {
//			System.out.println("불러오기실패");
//		}
//		if(vo != null) {
//			System.out.println(vo.getPro_cate_no());
//			System.out.println(vo.getPro_title());
//			System.out.println(vo.getPro_img());
//		}
		
		int optCount=0;
		optCount= new adminProductService().getProductOptionCount(pro_no);
		int imgCount=0;
		imgCount= new adminProductService().getProductImgCount(pro_no);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("pro_no", pro_no);
		request.setAttribute("optCount", optCount);
		request.setAttribute("imgCount", imgCount);
		request.setAttribute("ProductOption", ProductOption);
		request.setAttribute("ProductImg", ProductImg);
		request.getRequestDispatcher("./WEB-INF/view/productUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
