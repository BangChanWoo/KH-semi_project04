package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import getProLike.vo.GetProLikeVo;
import product_post.vo.ProductPost;
import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class MainDao {
	public ArrayList<Recipe> recipeList(Connection conn) {
		ArrayList<Recipe> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.cnt, t1.rec_title, t1.recipe_no, t1.rec_img, t1.rec_write_date"
				+ " from (select count(ir.inter_no) cnt, r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " from recipe r left join interest_recipe ir"
				+ " on r.recipe_no = ir.recipe_no"
				+ " group by r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " order by cnt desc, r.rec_write_date desc) t1)t2"
				+ " where t2.rnum between 1 and 20";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			rs = ps.executeQuery();
			
			volist = new ArrayList<Recipe>();
			while(rs.next()) {
				Recipe vo = new Recipe();
				vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setRec_img(rs.getString("rec_img"));
				vo.setRec_title(rs.getString("rec_title"));
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
	public int getRecipeCount(Connection conn, String searchField) {
		int result = 0;
		String countQuery = "select count(recipe_no) from recipe where rec_title like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countQuery);
			ps.setString(1, "%"+searchField+"%");
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
	public ArrayList<Recipe> searchRecipe(Connection conn, int start , int end, String searchField) {
		ArrayList<Recipe> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.cnt, t1.rec_title, t1.recipe_no, t1.rec_img, t1.rec_write_date"
				+ " from (select count(ir.inter_no) cnt, r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " from recipe r left join interest_recipe ir"
				+ " on r.recipe_no = ir.recipe_no"
				+ " where r.rec_title like ?"
				+ " group by r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " order by cnt desc, r.rec_write_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setString(1, "%"+searchField+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			
			volist = new ArrayList<Recipe>();
			while(rs.next()) {
				Recipe vo = new Recipe();
				vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setRec_img(rs.getString("rec_img"));
				vo.setRec_title(rs.getString("rec_title"));
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
	public ArrayList<ProductPost> productList(Connection conn) {
		ArrayList<ProductPost> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select count(ip.pro_no) cnt, ip.pro_no, pp.pro_title, pp.pro_img"
				+ " from interest_product ip right join product_post pp"
				+ " on ip.pro_no = pp.pro_no"
				+ " group by ip.pro_no, pp.pro_title, pp.pro_img, pp.pro_date"
				+ " order by cnt desc, pp.pro_date) t1)t2"
				+ " where t2.rnum between 1 and 20";
		try {
			ps = conn.prepareStatement(selectAllQuery);
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
	public int getProductCount(Connection conn, String searchField) {
		int result = 0;
		String countQuery = "select count(pro_no) from product_post where pro_title like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countQuery);
			ps.setString(1, "%"+searchField+"%");
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
	public ArrayList<ProductPost> searchProduct(Connection conn, int start , int end, String searchField) {
		ArrayList<ProductPost> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select count(ip.pro_no) cnt, ip.pro_no, pp.pro_title, pp.pro_img"
				+ " from interest_product ip right join product_post pp"
				+ " on ip.pro_no = pp.pro_no"
				+ " where pp.pro_title like ?"
				+ " group by ip.pro_no, pp.pro_title, pp.pro_img"
				+ " order by cnt desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setString(1, "%"+searchField+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
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
	public ArrayList<GetProLikeVo> popularProduct(Connection conn) {
		ArrayList<GetProLikeVo> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.*"
				+ " from (select count(ip.pro_no) cnt, ip.pro_no, pp.pro_title, pp.pro_img"
				+ " from interest_product ip join product_post pp"
				+ " on ip.pro_no = pp.pro_no"
				+ " group by ip.pro_no, pp.pro_title, pp.pro_img"
				+ " order by cnt desc) t1)t2"
				+ " where t2.rnum between 1 and 4";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			rs = ps.executeQuery();
			
			volist = new ArrayList<GetProLikeVo>();
			while(rs.next()) {
				GetProLikeVo vo = new GetProLikeVo();
				vo.setPro_no(rs.getInt("pro_no"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_title(rs.getString("pro_title"));
				vo.setCnt(rs.getInt("cnt"));
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