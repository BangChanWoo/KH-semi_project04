package product_order.service;

import java.sql.Connection;
import java.util.ArrayList;

import product_order.dao.ProductOrderDao;
import product_order.vo.ProductOrder;
import product_order_detail.vo.ProductOrderDetailVo;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

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
}