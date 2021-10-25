package product_order.service;

import java.sql.Connection;
import java.util.ArrayList;

import cartDetail.vo.CartDetailVo;
import getBasket.vo.GetBasketVo;
import product_order.dao.ProductOrderDao;
import product_order.vo.ProductOrder;
import product_order_detail.vo.ProductOrderDetailVo;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;
import user.basket.dao.BasketDao;
import user.vo.User;

public class ProductOrderService {
	public int getOrderCount(int catenum, String id) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductOrderDao().getOrderCount(conn, catenum, id);
		return result;
	}
	public ArrayList<ProductOrderDetailVo> orderList(int start , int end, int state, String id) {
		ArrayList<ProductOrderDetailVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductOrderDao().orderList(conn, start, end, state, id);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<CartDetailVo> getPurchaseList(String id, String[] pcList) {
		ArrayList<CartDetailVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductOrderDao().getPurchaseList(conn, id, pcList);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<CartDetailVo> getBkPurchaseList(ArrayList<GetBasketVo> bkList) {
		ArrayList<CartDetailVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductOrderDao().getBkPurchaseList(conn, bkList);
		JdbcTemplate.close(conn);
		return volist;
	}
	public User getUserInfo(String id) {
		User vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new ProductOrderDao().getUserInfo(conn, id);
		JdbcTemplate.close(conn);
		return vo;
	}
	public int insertUserOrder(String address, String name, String phone, String id) {
		int result =-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductOrderDao().insertUserOrder(conn, address, name, phone, id);
		JdbcTemplate.close(conn);
		return result;	
	}
	public int insertProductOrder(ArrayList<Integer> pno) {
		int result =-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductOrderDao().insertProductOrder(conn, pno);
		JdbcTemplate.close(conn);
		return result;	
	}
}