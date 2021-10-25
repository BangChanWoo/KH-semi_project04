package product_order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cartDetail.vo.CartDetailVo;
import getBasket.vo.GetBasketVo;
import product_order.vo.ProductOrder;
import product_order_detail.vo.ProductOrderDetailVo;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;
import user.vo.User;

public class ProductOrderDao {
	public int getOrderCount(Connection conn, int state, String id) {
		int result = 0;
		String countAllQuery = "select count(order_detail_no) from product_order po join user_order uo"
				+ " on po.order_no = uo.order_no where uo.id like ?";
		String countReadyQuery = "select count(order_detail_no) from product_order po join user_order uo"
				+ " on po.order_no = uo.order_no where uo.id like ? and order_status like 'N'";
		String countCompleteQuery = "select count(order_detail_no) from product_order po join user_order uo"
				+ " on po.order_no = uo.order_no where uo.id like ? and order_status like 'Y'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(state == 0) {
				ps = conn.prepareStatement(countAllQuery);
				ps.setString(1, id);
			}else if(state == 1) {
				ps = conn.prepareStatement(countReadyQuery);
				ps.setString(1, id);
			}else if(state == 2) {
				ps = conn.prepareStatement(countCompleteQuery);
				ps.setString(1, id);
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
	public ArrayList<ProductOrderDetailVo> orderList(Connection conn, int start , int end, int state, String id) {
		ArrayList<ProductOrderDetailVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " where uo.id like ?"
				+ " order by po.order_detail_no desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		
		String selectReadyQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " where po.order_status like 'N' and uo.id like ?"
				+ " order by po.order_detail_no desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		
		String selectCompleteQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select pp.pro_no, po.order_detail_no, pp.pro_title, pp.pro_img, uo.order_date, po.pro_price, po.order_count, po.order_status"
				+ " from product_post pp join product_order po"
				+ " on pp.pro_no = po.pro_no"
				+ " join user_order uo"
				+ " on po.order_no = uo.order_no"
				+ " where po.order_status like 'Y' and uo.id like ?"
				+ " order by po.order_detail_no desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		try {
			if(state == 0) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setString(1, id);
				ps.setInt(2, start);
				ps.setInt(3, end);
			}else if(state == 1){
				ps = conn.prepareStatement(selectReadyQuery);
				ps.setString(1, id);
				ps.setInt(2, start);
				ps.setInt(3, end);
			}else if(state == 2) {
				ps = conn.prepareStatement(selectCompleteQuery);
				ps.setString(1, id);
				ps.setInt(2, start);
				ps.setInt(3, end);
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
	public ArrayList<CartDetailVo> getPurchaseList(Connection conn, String id, String[] pcList) {
		ArrayList<CartDetailVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select pp.pro_no, c.cart_no, pp.pro_title, pp.pro_img, pp.pro_price, po.pro_option_content, c.pro_count, pp.pro_delivery_fee"
				+ " from cart c join product_post pp"
				+ " on c.pro_no = pp.pro_no"
				+ " join product_option po"
				+ " on c.select_option_no = po.pro_option_no"
				+ " where id like ? and cart_no like ?";
		
		try {
			volist = new ArrayList<CartDetailVo>();
			for(int i=0; i<pcList.length; i++) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setString(1, id);
				ps.setInt(2, Integer.parseInt(pcList[i]));
				rs = ps.executeQuery();
				
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
	public ArrayList<CartDetailVo> getBkPurchaseList(Connection conn, ArrayList<GetBasketVo> bkList) {
		ArrayList<CartDetailVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select pp.pro_title, pp.pro_img, po.pro_option_content, pp.pro_price, pp.pro_delivery_fee"
				+ " from product_post pp join product_option po"
				+ " on pp.pro_no = po.pro_no"
				+ " where po.pro_no like ? and po.pro_option_no like ?";
		
		try {
			volist = new ArrayList<CartDetailVo>();
			for(GetBasketVo bVo : bkList) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setInt(1, Integer.parseInt(bVo.getProNo()));
				ps.setInt(2, Integer.parseInt(bVo.getOption()));
				rs = ps.executeQuery();
				
				while(rs.next()) {
					CartDetailVo vo = new CartDetailVo();
					vo.setPro_no(Integer.parseInt(bVo.getProNo()));
					vo.setPro_img(rs.getString("pro_img"));
					vo.setPro_title(rs.getString("pro_title"));
					vo.setPro_price(rs.getInt("pro_price"));
					vo.setPro_option(rs.getString("pro_option_content"));
					vo.setOption_cnt(Integer.parseInt(bVo.getCnt()));
					vo.setPro_delivery_fee(rs.getInt("pro_delivery_fee"));
					volist.add(vo);
				}
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
	public User getUserInfo(Connection conn, String id) {
		User vo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from member where id like ?";
		
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			vo = new User();
			while(rs.next()) {
				vo.setUname(rs.getString("uname"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return vo;
	}
	public int insertUserOrder(Connection conn, String address, String name, String phone, String id) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String insertUser ="insert into user_order values(order_no.nextval, sysdate, ?, ?, ? ,?)";
		
		try {
			ps = conn.prepareStatement(insertUser);
			ps.setString(1, address);
			ps.setString(2, name);
			ps.setString(3, phone);
			ps.setString(4, id);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public int insertProductOrder(Connection conn, ArrayList<Integer> pno) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String getQuery = "select c.pro_no, pp.pro_price, c.pro_count from product_post pp join cart c on pp.pro_no = c.pro_no where c.cart_no like ?";
		String insertPro ="insert into product_order values(order_detail_no.nextval, ?, 'N', order_no.currval, ?, ?)";
		ArrayList<CartDetailVo> pvoList = new ArrayList<CartDetailVo>();
		try {
			for(int i: pno) {
				ps = conn.prepareStatement(getQuery);
				ps.setInt(1, i);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					CartDetailVo vo = new CartDetailVo();
					vo.setPro_no(rs.getInt("pro_no"));
					vo.setPro_price(rs.getInt("pro_price"));
					vo.setOption_cnt(rs.getInt("pro_count"));
					pvoList.add(vo);
				}
				JdbcTemplate.close(ps);
			}
			System.out.println(pvoList.size());
			for(CartDetailVo cVo: pvoList) {
				ps = conn.prepareStatement(insertPro);
				ps.setInt(1, cVo.getOption_cnt());
				ps.setInt(2, cVo.getPro_no());
				ps.setInt(3, cVo.getPro_price());
				rs = ps.executeQuery();
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
	public int insertBkProductOrder(Connection conn, ArrayList<Integer> pro_no, ArrayList<Integer> cnt, ArrayList<Integer> price) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String insertPro ="insert into product_order values(order_detail_no.nextval, ?, 'N', order_no.currval, ?, ?)";
		try {
			for(int i=0; i<pro_no.size(); i++) {
				ps = conn.prepareStatement(insertPro);
				System.out.println(cnt.get(i));
				ps.setInt(1, cnt.get(i));
				ps.setInt(2, pro_no.get(i));
				ps.setInt(3, price.get(i));
				rs = ps.executeQuery();
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
}