package product_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product_order.vo.ProductOrder;
import riceThief.common.JdbcTemplate;

public class ProductOrderDao {
	public int getOrderCount(Connection conn, int state) {
		int result = 0;
		String countAllQuery = "select count(order_detail_no) from product_order";
		String countReadyQuery = "select count(order_detail_no) from product_order where order_status like 'N'";
		String countCompleteQuery = "select count(order_detail_no) from product_order where order_status like 'Y'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(state == 0) {
				ps = conn.prepareStatement(countAllQuery);
			}else if(state == 1) {
				ps = conn.prepareStatement(countReadyQuery);
			}else if(state == 2) {
				ps = conn.prepareStatement(countCompleteQuery);
			}
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			//-1
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public ArrayList<ProductOrder> orderList(Connection conn, int start , int end, int state) {
		ArrayList<ProductOrder> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select t1.* from (select rownum r, po.*"
				+ " from product_order po"
				+ " order by po.order_detail_no desc) t1"
				+ " where t1.r between ? and ?";
		
		String selectReadyQuery = "select t1.* from (select rownum r, po.*"
				+ " from product_order po"
				+ " where order_status like 'N'"
				+ " order by po.order_detail_no desc) t1"
				+ " where t1.r between ? and ?";
		
		String selectCompleteQuery = "select t1.* from (select rownum r, po.*"
				+ " from product_order po"
				+ " where order_status like 'Y'"
				+ " order by po.order_detail_no desc) t1"
				+ " where t1.r between ? and ?";
		try {
			if(state == 0) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println(state);
			}else if(state == 1){
				ps = conn.prepareStatement(selectReadyQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println(state);
			}else if(state == 2) {
				ps = conn.prepareStatement(selectCompleteQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println(state);
			}
			rs = ps.executeQuery();
			
			volist = new ArrayList<ProductOrder>();
			while(rs.next()) {
				ProductOrder vo = new ProductOrder();
				vo.setOrder_detail_num(rs.getInt("order_detail_no"));
				vo.setOrder_count(rs.getInt("order_count"));
				vo.setOrder_status(rs.getString("order_status").charAt(0));
				vo.setPro_no(rs.getInt("pro_no"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return volist;
	}
}