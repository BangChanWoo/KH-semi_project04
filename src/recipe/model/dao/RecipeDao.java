package recipe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class RecipeDao {
	public RecipeDao() {}
	public int getRecipeCount(Connection conn) {
		int result = 0;
		String countQuery = "select count(recipe_no) from recipe";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countQuery);
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
	public ArrayList<Recipe> recipeList(Connection conn, int start , int end) {
		ArrayList<Recipe> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select t2.recipe_no, t2.rec_img, t2.rec_title from (select ROWNUM r, t1.* from recipe t1 order by recipe_no desc) t2 where t2.r between ? and ?";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setInt(1, start);
			ps.setInt(2, end);
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
	public ArrayList<Recipe> recipeDetailList(Connection conn, int rno) {
		ArrayList<Recipe> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "";
		try {
			ps = conn.prepareStatement(selectAllQuery);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			volist = new ArrayList<Recipe>();
			while(rs.next()) {
				Recipe vo = new Recipe();
					vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setUid(rs.getString("uid"));
				vo.setRec_img(rs.getString("rec_img"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setRec_summary(rs.getString("rs_summary"));
				vo.setRec_tip(rs.getString("rec_tip"));
				vo.setInfo_serving(rs.getString("info_serving"));
				vo.setInfo_time(rs.getString("info_time"));
				vo.setInfo_level(rs.getString("info_level"));
				vo.setRec_video(rs.getString("rec_video"));
				vo.setRec_cate_no(rs.getInt("rec_cate_no"));
				vo.setRec_write_date(rs.getDate("rec_write_date"));
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