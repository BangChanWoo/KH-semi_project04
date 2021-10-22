package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class ProductDao {

	public ProductDao() {}
	
	public int getProductCount(Connection conn, int catenum) {
		int result = 0;
		String countAllQuery = "select count(pro_no) from product_post";
		String countCateQuery = "select count(pro_no) from product_post where pro_cate_no like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(catenum == 0) {
				ps = conn.prepareStatement(countAllQuery);
			}else {
				ps = conn.prepareStatement(countCateQuery);
				ps.setInt(1, catenum);
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

	public ArrayList<ProductPost> productList(Connection conn, int start , int end, int catenum) {
		ArrayList<ProductPost> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select t2.pro_no, t2.pro_img, t2.pro_title, t2.pro_price"
				+ " from (select ROWNUM r, t1.* from product_post t1 order by pro_no desc) t2"
				+ " where t2.r between ? and ?";
		
		String selectCateQuery = "select t2.pro_no, t2.pro_img, t2.pro_title, t2.pro_price"
				+ " from (select ROWNUM r, t1.* from product_post t1 where t1.pro_cate_no like ? order by pro_no desc) t2"
				+ " where t2.r between ? and ?";
		try {
			if(catenum == 0) {
				ps = conn.prepareStatement(selectAllQuery);
				ps.setInt(1, start);
				ps.setInt(2, end);
			}else {
				ps = conn.prepareStatement(selectCateQuery);
				ps.setInt(1, catenum);
				ps.setInt(2, start);
				ps.setInt(3, end);
			}
			rs = ps.executeQuery();
			
			volist = new ArrayList<ProductPost>();
			while(rs.next()) {
				ProductPost vo = new ProductPost();
				vo.setPro_no(rs.getInt("pro_no"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_title(rs.getString("pro_title"));
				vo.setPro_price(rs.getInt("pro_price"));
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

	public ArrayList<ProductOption> optionList(Connection conn, int rno){
		ArrayList<ProductOption> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectIngreQuery = "select pro_option_no, pro_option_content from product_option where pro_no like ? order by pro_option_no";
		try {
			ps = conn.prepareStatement(selectIngreQuery);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			volist = new ArrayList<ProductOption>();
			while(rs.next()) {
				ProductOption vo = new ProductOption();
				vo.setPro_option_no(rs.getInt("pro_option_no"));
				vo.setPro_option_content(rs.getString("pro_option_content"));
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
	
	public ArrayList<ProductImg> proImgList(Connection conn, int rno){
		ArrayList<ProductImg> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectIngreQuery = "select pro_content_no, pro_content_img from product_img where pro_no like ? order by pro_content_no";
		try {
			ps = conn.prepareStatement(selectIngreQuery);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			volist = new ArrayList<ProductImg>();
			while(rs.next()) {
				ProductImg vo = new ProductImg();
				vo.setPro_content_no(rs.getInt("pro_content_no"));
				vo.setPro_content_img(rs.getString("pro_content_img"));
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
		
	public ProductPost productDetailList(Connection conn, int rno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductPost vo = new ProductPost();
		String query = "select * from product_post where pro_no like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo.setPro_no(rs.getInt("pro_no"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_title(rs.getString("pro_title"));
				vo.setPro_price(rs.getInt("pro_price"));
				vo.setPro_cate_no(rs.getInt("pro_cate_no"));
				vo.setPro_delivery_fee(rs.getInt("pro_delivery_fee"));
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
	
	//like read
		public int likeRead(Connection conn, int rno, String id) {
			int result = -1;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String likeInsertQuery = "select count(inter_no) from interest_product where pro_no like ? and id like ?";
			try {
				ps = conn.prepareStatement(likeInsertQuery);
				ps.setInt(1, rno);
				ps.setString(2, id);
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
		//like create
		public int likeCreate(Connection conn, int rno, String id) {
			int result = -1;
			PreparedStatement ps = null;
		
			String likeInsertQuery = "insert into interest_product values(inter_pro_no.NEXTVAL, ?, ?, sysdate)";
			try {
				ps = conn.prepareStatement(likeInsertQuery);
				ps.setString(1, id);
				ps.setInt(2, rno);
				result = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("연결 실패");
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(ps);
			}
			return result;
		}
		//like delete
		public int likeDelete(Connection conn, int rno, String id) {
			int result = -1;
			PreparedStatement ps = null;
		
			String likeDeleteQuery = "delete from interest_product where pro_no like ? and id like ?";
			try {
				ps = conn.prepareStatement(likeDeleteQuery);
				ps.setInt(1, rno);
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
		public ArrayList<ProductPost> interProList(Connection conn, int rno, String id){
			ArrayList<ProductPost> volist = null;
			Statement st = null;
			ResultSet rs = null;
			
			PreparedStatement ps = null;
			
			String recommendQuery ="select * from (select rownum rnum, t1.cnt, t1.pro_title, t1.pro_no, t1.pro_img, t1.pro_price, t1.inter_pro_date" + 
					" from (select count(ir.inter_pro_no) cnt, r.pro_title, r.pro_no, r.pro_img, ir.inter_pro_date" + 
					" from product_post r join interest_product ir" + 
					" on r.pro_no = ir.pro_no" + 
					" where ir.id like ?" +
					" group by r.pro_title, r.pro_no, r.pro_price, r.pro_img, ir.inter_pro_date" + 
					" order by ir.inter_pro_date desc) t1) t2" + 
					" where t2.rnum between 1 and 10";
			
			try {
				ps = conn.prepareStatement(recommendQuery);
					ps.setString(1, id);			
				rs = ps.executeQuery();			
				volist = new ArrayList<ProductPost>();

				while(rs.next()) {
					ProductPost vo = new ProductPost();
					vo.setPro_no(rs.getInt("pro_no"));
					vo.setPro_img(rs.getString("pro_img"));
					vo.setPro_price(rs.getInt("pro_price"));
					vo.setPro_title(rs.getString("pro_title"));
					volist.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				JdbcTemplate.close(ps);
			}
			return volist;		
		}
}
