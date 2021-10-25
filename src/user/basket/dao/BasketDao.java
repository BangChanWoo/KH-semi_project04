package user.basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cartDetail.vo.CartDetailVo;
import getBasket.vo.GetBasketVo;
import riceThief.common.JdbcTemplate;
import user.vo.User;

public class BasketDao {
	public int getBasketCount(Connection conn, String id) {
		int result = 0;
		String countAllQuery = "select count(cart_no) from cart where id like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countAllQuery);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public ArrayList<CartDetailVo> basketList(Connection conn, String id) {
		ArrayList<CartDetailVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select rownum rnum, t1.*"
				+ " from (select pp.pro_no, c.cart_no, pp.pro_title, pp.pro_img, pp.pro_price, po.pro_option_content, c.pro_count, pp.pro_delivery_fee"
				+ " from cart c join product_post pp"
				+ " on c.pro_no = pp.pro_no"
				+ " join product_option po"
				+ " on c.select_option_no = po.pro_option_no"
				+ " where id like ?"
				+ " order by c.store_date desc) t1";
		
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			volist = new ArrayList<CartDetailVo>();
			while(rs.next()) {
				CartDetailVo vo = new CartDetailVo();
				vo.setCart_no(rs.getInt("cart_no"));
				vo.setPro_no(rs.getInt("pro_no"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_title(rs.getString("pro_title"));
				vo.setPro_price(rs.getInt("pro_price"));
				vo.setPro_option(rs.getString("pro_option_content"));
				vo.setOption_cnt(rs.getInt("pro_count"));
				vo.setPro_delivery_fee(rs.getInt("pro_delivery_fee"));
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
	public int insertBasket(Connection conn, String id, ArrayList<GetBasketVo> bkList) {
		int result = -1;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String dupidInsert ="select * from cart"
				+ " where pro_no like ? and id like ? and select_option_no like ?";
		
		String basketInsert = "insert into cart"
					+ " values(cart_no.NEXTVAL, ?, ?, sysdate, ?, ?)";
		
		String updateCnt = "update cart set pro_count = pro_count+?"
				+ " where pro_no like ? and id like ? and select_option_no like ?";
		try {
			for(GetBasketVo bVo :bkList) {
				ps = conn.prepareStatement(dupidInsert);
				ps.setInt(1, Integer.parseInt(bVo.getProNo()));
				ps.setString(2, id);
				ps.setInt(3, Integer.parseInt(bVo.getOption()));
				rs = ps.executeQuery();
				
				if(rs.next()) {
					ps2 = conn.prepareStatement(updateCnt);
					ps2.setInt(1, Integer.parseInt(bVo.getCnt()));
					ps2.setInt(2, Integer.parseInt(bVo.getProNo()));
					ps2.setString(3, id);
					ps2.setInt(4, Integer.parseInt(bVo.getOption()));
					result = ps2.executeUpdate();
				}else {
					ps2 = conn.prepareStatement(basketInsert);
					ps2.setString(1, bVo.getId());
					ps2.setInt(2, Integer.parseInt(bVo.getProNo()));
					ps2.setInt(3, Integer.parseInt(bVo.getCnt()));
					ps2.setInt(4, Integer.parseInt(bVo.getOption()));
					result = ps2.executeUpdate();
				}
				
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public int plusCnt(Connection conn, String id, int cno) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String cntplus = "update cart set pro_count = pro_count+1"
				+ " where cart_no like ? and id like ?";
		
		try {
			ps = conn.prepareStatement(cntplus);
			ps.setInt(1, cno);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public int minusCnt(Connection conn, String id, int cno) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String cntplus = "update cart set pro_count = pro_count-1"
				+ " where cart_no like ? and id like ?";
		
		try {
			ps = conn.prepareStatement(cntplus);
			ps.setInt(1, cno);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public int deleteBk(Connection conn, int cno, String id) {
		int result = -1;
		PreparedStatement ps = null;
	
		String deleteBkquery = "delete from cart where cart_no like ? and id like ?";
		try {
			ps = conn.prepareStatement(deleteBkquery);
			ps.setInt(1, cno);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
}