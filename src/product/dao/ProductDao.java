package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class ProductDao {

	public ProductDao() {}

	public int getProductCount(Connection conn, int catenum) {
		int result = 0;
		String countAllQuery = "select count(pro_no) from productpost";
		String countCateQuery = "select count(pro_no) from productpost where pro_cate_no like ?";
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
		String selectAllQuery = "select t2.pro_no, t2.pro_img, t2.pro_title"
				+ " from (select ROWNUM r, t1.* from productpost t1 order by pro_no desc) t2"
				+ " where t2.r between ? and ?";
		
		String selectCateQuery = "select t2.pro_no, t2.rec_img, t2.rec_title"
				+ " from (select ROWNUM r, t1.* from productpost t1 where t1.pro_cate_no like ? order by pro_no desc) t2"
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

	
	// 더 작업해야하는 것 : 상품 상세설명, 후기
	
	/*public Recipe recipeDetailList(Connection conn, int rno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Recipe vo = new Recipe();
		String query = "select * from recipe where recipe_no like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setUid(rs.getString("id"));
				vo.setRec_img(rs.getString("rec_img"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setRec_summary(rs.getString("rec_summary"));
				vo.setRec_tip(rs.getString("rec_tip"));
				vo.setInfo_serving(rs.getString("info_serving"));
				vo.setInfo_time(rs.getString("info_time"));
				vo.setInfo_level(rs.getString("info_level"));
				vo.setRec_video(rs.getString("rec_video"));
				vo.setRec_cate_no(rs.getInt("rec_cate_no"));
				vo.setRec_write_date(rs.getDate("rec_write_date"));
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
	
	*/


}
