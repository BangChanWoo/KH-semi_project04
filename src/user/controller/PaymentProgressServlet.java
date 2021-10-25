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
		
		ArrayList<Integer> pno = new ArrayList<Integer>();
		String pn_size_str = request.getParameter("pn_size");
		if(pn_size_str != null) {
			int pn_size = Integer.parseInt(pn_size_str);
			for(int i=0; i<pn_size;i++) {
				String eachPnoStr = request.getParameter("cno_"+i);
				if(eachPnoStr != null) {
					int eachPno = Integer.parseInt(eachPnoStr);
					pno.add(eachPno);
					System.out.println(eachPno);
				}
			}
		}
		
		int result2 = new ProductOrderService().insertProductOrder(pno);
		
		//request.getRequestDispatcher("orderdetailview").forward(request, response);
		response.sendRedirect("orderdetailview");
	}
}
