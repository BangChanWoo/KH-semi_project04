package product_order.service;

import java.sql.Connection;
import java.util.ArrayList;

import product_order.dao.ProductOrderDao;
import product_order.vo.ProductOrder;
import riceThief.common.JdbcTemplate;

public class ProductOrderService {
	public int getOrderCount(int catenum) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductOrderDao().getOrderCount(conn, catenum);
		return result;
	}
	public ArrayList<ProductOrder> orderList(int start , int end, int state) {
		ArrayList<ProductOrder> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductOrderDao().orderList(conn, start, end, state);
		JdbcTemplate.close(conn);
		return volist;
	}
}