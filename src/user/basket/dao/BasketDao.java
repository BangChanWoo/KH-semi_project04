package user.basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cartDetail.vo.CartDetailVo;
import getBasket.vo.GetBasketVo;
import riceThief.common.JdbcTemplate;

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
			//-1
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
		ResultSet rs = null;
		String dupidInsert ="select * from cart"
				+ " where pro_no like ? and id like ? and select_option_no like ?";
		
		String basketInsert = "insert into cart"
					+ " values(cart_no.NEXTVAL, ?, ?, sysdate, ?, ?)";
		try {
			for(GetBasketVo bVo :bkList) {
				ps = conn.prepareStatement(dupidInsert);
				ps.setString(1, id);
				ps.setString(2, id);
				ps.setString(3, id);
				rs = ps.executeQuery();
				
				//여기서 같은 번호, 옵션번호, 아이디 가진 상품들은 갯수만 추가.. 그리고 10개 이하로 구매하세용 관리자 문의
				
				
				ps = conn.prepareStatement(basketInsert);
				ps.setString(1, bVo.getId());
				ps.setInt(2, Integer.parseInt(bVo.getProNo()));
				ps.setInt(3, Integer.parseInt(bVo.getCnt()));
				ps.setInt(4, Integer.parseInt(bVo.getOption()));
				result = ps.executeUpdate();
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
}