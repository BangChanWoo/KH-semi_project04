package product_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product_order.vo.ProductOrder;
import product_order_detail.vo.ProductOrderDetailVo;
import product_post.vo.ProductPost;
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
	public ArrayList<ProductOrderDetailVo> orderList(Connection conn, int start , int end, int state) {
		ArrayList<ProductOrderDetailVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " order by uo.order_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		
		String selectReadyQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " where po.order_status like 'N'"
				+ " order by uo.order_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		
		String selectCompleteQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " where po.order_status like 'Y'"
				+ " order by uo.order_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		try {
			if(state == 0) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
			}else if(state == 1){
				ps = conn.prepareStatement(selectReadyQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
			}else if(state == 2) {
				ps = conn.prepareStatement(selectCompleteQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
			}
			rs = ps.executeQuery();
			
			volist = new ArrayList<ProductOrderDetailVo>();
			while(rs.next()) {
				ProductOrderDetailVo vo = new ProductOrderDetailVo();
				vo.setPro_no(rs.getInt("pro_no"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_title(rs.getString("pro_title"));
				vo.setOrder_date(rs.getString("order_date"));
				vo.setPro_price(rs.getInt("pro_price"));
				vo.setOrder_count(rs.getInt("order_count"));
				vo.setOrder_state(rs.getString("order_status").charAt(0));
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