package admin.sal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.sal.vo.sale;
import riceThief.common.JdbcTemplate;

public class adminSalDao {
	public ArrayList<sale> salList(Connection conn, char order_status){
		ArrayList<sale> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select u.order_date as o1, p.pro_no as o2, u.id as o3, p.pro_price as o4, p.order_count as o5, p.order_status as o6, p.order_detail_no as o7 " + 
				" from user_order u join product_order p " + 
				" on u.order_no = p.order_no " + 
				" and p.order_status=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,String.valueOf(order_status));
			rset = pstmt.executeQuery();
			
			volist = new ArrayList<sale>();
			
			while(rset.next()) {
				sale vo = new sale();
				vo.setOrder_date(rset.getString("o1"));
				vo.setPro_no(rset.getInt("o2"));
				vo.setId(rset.getString("o3"));
				vo.setPro_price(rset.getInt("o4"));
				vo.setOrder_count(rset.getInt("o5"));
				vo.setOrder_status(rset.getString("o6").charAt(0));
				vo.setOrder_detail_no(rset.getInt("o7"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return volist;
	}
	
	public int getSalCount(Connection conn, char order_status) {
		int result=0;
		String query = "select count(p.order_status) as o6 " + 
				" from user_order u left outer join product_order p " + 
				" on u.order_no = p.order_no " + 
				" and p.order_status=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,String.valueOf(order_status));
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
				System.out.println("test3 : "+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	public int updateOrder(Connection conn, int order_detail_no) {
		int result=-1;
		String sql="update product_order set order_status='Y' where order_detail_no=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("DAO 에서 받은 order_detail_no 값 : "+ order_detail_no);
			pstmt.setInt(1, order_detail_no);
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("수정 성공");
				result=1;
				JdbcTemplate.close(pstmt);
			} else {
				System.out.println("수정 실패");
				result=0;
				JdbcTemplate.close(pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
