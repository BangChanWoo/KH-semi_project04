package user.basket.controller;

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
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import getBasket.vo.GetBasketVo;
import user.basket.service.BasketService;

/**
 * Servlet implementation class PlusOptionCntServlet
 */
@WebServlet("/plus.do")
public class PlusOptionCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusOptionCntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");
		String cnoStr = request.getParameter("cno");
		int cno = 0;
		if(cnoStr != null) {
			cno = Integer.parseInt(cnoStr);
		}
		int result = new BasketService().plusCnt(id, cno);
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		if(result > 0) {
			String gsonStr = gson.toJson("success");
			out.append(gsonStr);
		}
		out.flush();
		out.close();
	}

}
