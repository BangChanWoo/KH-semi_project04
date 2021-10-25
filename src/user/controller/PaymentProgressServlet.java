package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartDetail.vo.CartDetailVo;
import product_order.service.ProductOrderService;

/**
 * Servlet implementation class PaymentProgressServlet
 */
@WebServlet("/payprogress")
public class PaymentProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentProgressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String info = request.getParameter("info");
		String ordername = request.getParameter("ordername");
		String orderphone = request.getParameter("orderphone");
		String orderEmail = request.getParameter("orderEmail");

		int result1 = new ProductOrderService().insertUserOrder(address, name, phone, id);
		
		String eachCnoStr = null;
		ArrayList<Integer> cno = new ArrayList<Integer>();
		ArrayList<Integer> pro_no = new ArrayList<Integer>();
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		String pn_size_str = request.getParameter("pn_size");
		if(pn_size_str != null) {
			int pn_size = Integer.parseInt(pn_size_str);
			for(int i=0; i<pn_size;i++) {
				eachCnoStr = request.getParameter("cno_"+i);
				System.out.println("eachCnoStr: "+eachCnoStr);
				if(!eachCnoStr.equals("0")) {
					int eachCno = Integer.parseInt(eachCnoStr);
					cno.add(eachCno);
					System.out.println("진입");
				}else {
					String eachProNoStr = request.getParameter("prono_"+i);
					if(eachProNoStr != null) {
						int eachProNo = Integer.parseInt(eachProNoStr);
						pro_no.add(eachProNo);
					}
					String eachCntStr = request.getParameter("cnt_"+i);
					if(eachCntStr != null) {
						int eachCnt = Integer.parseInt(eachCntStr);
						cnt.add(eachCnt);
					}
					String eachPriceStr = request.getParameter("pp_"+i);
					if(eachPriceStr != null) {
						int eachPrice = Integer.parseInt(eachPriceStr);
						price.add(eachPrice);
					}
				}
			}
		}
		System.out.println("eachCnoStr: "+eachCnoStr);
		System.out.println("pro_no: "+pro_no);
		System.out.println("cnt: "+cnt);
		System.out.println("price: "+price);
		if(eachCnoStr.equals("0")) {
			//바로구매
			int result2 = new ProductOrderService().insertBkProductOrder(pro_no, cnt, price);
		}else {
			//장바구니구매
			int result2 = new ProductOrderService().insertProductOrder(cno);
		}
		
		//request.getRequestDispatcher("orderdetailview").forward(request, response);
		response.sendRedirect("orderdetailview");
	}
}
