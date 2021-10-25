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
import user.vo.User;


/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		
		String id = (String)request.getSession().getAttribute("sessionID");
		String getpcList = request.getParameter("pcList");
		String[] pcList = getpcList.split(",");

		ArrayList<CartDetailVo> pcVoList = new ProductOrderService().getPurchaseList(id, pcList);
		User uVo = new ProductOrderService().getUserInfo(id);

		request.setAttribute("pcVoList", pcVoList);
		request.setAttribute("uVo", uVo);
		request.getRequestDispatcher("./WEB-INF/view/purchase.jsp").forward(request, response);
	}
}
