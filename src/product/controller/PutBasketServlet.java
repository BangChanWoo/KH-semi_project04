package product.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import getBasket.vo.GetBasketVo;
import user.basket.service.BasketService;

/**
 * Servlet implementation class PutBasketServlet
 */
@WebServlet("/putbasket.do")
public class PutBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");
		
		BufferedReader br = request.getReader();
		String reqData = br.readLine();
		Gson gson = new Gson();
		ArrayList<GetBasketVo> bkList = gson.fromJson(reqData.toString(), new TypeToken<ArrayList<GetBasketVo>>(){}.getType());
		
		int result = new BasketService().insertBasket(id, bkList);
		
		PrintWriter out = response.getWriter();
		String gsonStr = gson.toJson(result);
		out.append(gsonStr);
		out.flush();
		out.close();
	}
}
