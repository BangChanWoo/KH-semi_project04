package recipe.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ingredient.vo.Ingredient;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
import riceThief.common.JdbcTemplate;

public class RecipeDao {
	public RecipeDao() {}
	
	public int insertRecipe(Connection conn, Recipe recipeVo, ArrayList<Ingredient> IngreList, ArrayList<RecipeSteps> stepList) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String recipeInsert = "insert into recipe"
					+ " values(recipe_no.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		String ingreInsert = "insert into ingredient"
				+ " values(ingre_no.NEXTVAL, ?, ?, recipe_no.CURRVAL)";
		String stepInsert = "insert into recipe_steps"
				+ " values(step_no.NEXTVAL, ?, ?, recipe_no.CURRVAL)";
		try {
			//레시피
			ps = conn.prepareStatement(recipeInsert);
			ps.setString(1, recipeVo.getUid());
			ps.setString(2, recipeVo.getRec_img());
			ps.setString(3, recipeVo.getRec_title());
			ps.setString(4, recipeVo.getRec_summary());
			ps.setString(5, recipeVo.getRec_tip());
			ps.setString(6, recipeVo.getInfo_serving());
			ps.setString(7, recipeVo.getInfo_time());
			ps.setString(8, recipeVo.getInfo_level());
			ps.setString(9, recipeVo.getRec_video());
			ps.setInt(10, recipeVo.getRec_cate_no());
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			//재료
			for(int i=0; i<IngreList.size(); i++) {
				ps = conn.prepareStatement(ingreInsert);
				ps.setString(1, IngreList.get(i).getIngre_name());
				ps.setString(2, IngreList.get(i).getIngre_unit());
				result = ps.executeUpdate();
			}
			
			JdbcTemplate.close(ps);
			
			//순서
			for(int i=0; i<stepList.size(); i++) {
				ps = conn.prepareStatement(stepInsert);
				ps.setString(1, stepList.get(i).getStep_content());
				ps.setString(2, stepList.get(i).getStep_img());
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
	public int getRecipeCount(Connection conn, int catenum) {
		int result = 0;
		String countAllQuery = "select count(recipe_no) from recipe";
		String countCateQuery = "select count(recipe_no) from recipe where rec_cate_no like ?";
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
	public ArrayList<Recipe> recipeList(Connection conn, int start , int end, int catenum) {
		ArrayList<Recipe> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "select * from (select rownum rnum, t1.cnt, t1.rec_title, t1.recipe_no, t1.rec_img, t1.rec_write_date"
				+ " from (select count(ir.inter_no) cnt, r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " from recipe r left join interest_recipe ir"
				+ " on r.recipe_no = ir.recipe_no"
				+ " group by r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " order by cnt desc, r.rec_write_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
		
		String selectCateQuery = "select * from (select rownum rnum, t1.cnt, t1.rec_title, t1.recipe_no, t1.rec_img, t1.rec_write_date"
				+ " from (select count(ir.inter_no) cnt, r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " from recipe r left join interest_recipe ir"
				+ " on r.recipe_no = ir.recipe_no"
				+ " where r.rec_cate_no like ?"
				+ " group by r.rec_title, r.recipe_no, r.rec_img, r.rec_write_date"
				+ " order by cnt desc, r.rec_write_date desc) t1)t2"
				+ " where t2.rnum between ? and ?";
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
	public Recipe recipeDetailList(Connection conn, int rno) {
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
	public ArrayList<Ingredient> ingreList(Connection conn, int rno){
		ArrayList<Ingredient> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectIngreQuery = "select ingre_no, ingre_name, ingre_unit from ingredient where recipe_no like ? order by ingre_no";
		try {
			ps = conn.prepareStatement(selectIngreQuery);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			volist = new ArrayList<Ingredient>();
			while(rs.next()) {
				Ingredient vo = new Ingredient();
				vo.setIngre_no(rs.getInt("ingre_no"));
				vo.setIngre_name(rs.getString("ingre_name"));
				vo.setIngre_unit(rs.getString("ingre_unit"));
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
	public ArrayList<RecipeSteps> stepList(Connection conn, int rno){
		ArrayList<RecipeSteps> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectStepQuery = "select step_no, step_content, step_img from recipe_steps where recipe_no like ? order by step_no";
		try {
			ps = conn.prepareStatement(selectStepQuery);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			
			volist = new ArrayList<RecipeSteps>();
			while(rs.next()) {
				RecipeSteps vo = new RecipeSteps();
				vo.setStep_no(rs.getInt("step_no"));
				vo.setStep_content(rs.getString("step_content"));
				vo.setStep_img(rs.getString("step_img"));
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
	//update
	public int updateRecipe(Connection conn, Recipe recipeVo, ArrayList<Ingredient> IngreList, ArrayList<RecipeSteps> stepList) {
		int result = -1;
		String updateQuery = "update recipe set rec_title = ?, rec_img = ?, rec_summary = ?, rec_tip = ?,"
				+ " info_serving = ?, info_time = ?, info_level = ?, rec_video = ?, rec_cate_no = ? where recipe_no like ?";
		String updateIngreQuery = "update ingredient set ingre_name = ?, ingre_unit = ? where recipe_no like ? and ingre_no like ?";
		String updateStepQuery = "update recipe_steps set step_content = ?, step_img = ? where recipe_no like ? and step_no like ?";
		
		String ingreInsert = "insert into ingredient"
				+ " values(ingre_no.NEXTVAL, ?, ?, ?)";
		String stepInsert = "insert into recipe_steps"
				+ " values(step_no.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateQuery);
			ps.setString(1, recipeVo.getRec_title());
			ps.setString(2, recipeVo.getRec_img());
			ps.setString(3, recipeVo.getRec_summary());
			ps.setString(4, recipeVo.getRec_tip());
			ps.setString(5, recipeVo.getInfo_serving());
			ps.setString(6, recipeVo.getInfo_time());
			ps.setString(7, recipeVo.getInfo_level());
			ps.setString(8, recipeVo.getRec_video());
			ps.setInt(9, recipeVo.getRec_cate_no());
			ps.setInt(10, recipeVo.getRecipe_no());
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			//재료
			for(int i=0; i<IngreList.size(); i++) {
				if(IngreList.get(i).getIngre_no() != 0) {
					//기존거 update
					ps = conn.prepareStatement(updateIngreQuery);
					ps.setString(1, IngreList.get(i).getIngre_name());
					ps.setString(2, IngreList.get(i).getIngre_unit());
					ps.setInt(3, recipeVo.getRecipe_no());
					ps.setInt(4, IngreList.get(i).getIngre_no());
					result = ps.executeUpdate();
					JdbcTemplate.close(ps);
				}else {
					//새로 insert
					ps = conn.prepareStatement(ingreInsert);
					ps.setString(1, IngreList.get(i).getIngre_name());
					ps.setString(2, IngreList.get(i).getIngre_unit());
					ps.setInt(3, recipeVo.getRecipe_no());
					result = ps.executeUpdate();
					JdbcTemplate.close(ps);
				}
			}
			
			JdbcTemplate.close(ps);
			
			//순서
			for(int i=0; i<stepList.size(); i++) {
				if(stepList.get(i).getStep_no() != 0) {
					//기존거 update
					ps = conn.prepareStatement(updateStepQuery);
					ps.setString(1, stepList.get(i).getStep_content());
					ps.setString(2, stepList.get(i).getStep_img());
					ps.setInt(3, recipeVo.getRecipe_no());
					ps.setInt(4, stepList.get(i).getStep_no());
					result = ps.executeUpdate();
					JdbcTemplate.close(ps);
				}else {
					//새로 insert
					ps = conn.prepareStatement(stepInsert);
					ps.setString(1, stepList.get(i).getStep_content());
					ps.setString(2, stepList.get(i).getStep_img());
					ps.setInt(3, recipeVo.getRecipe_no());
					result = ps.executeUpdate();
					JdbcTemplate.close(ps);
				}
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	//delete
	public int deleteRecipe(Connection conn, int rno) {
		int result = -1;
		String deleteLikeQuery = "delete from interest_recipe where recipe_no like ?";
		String deleteStepQuery = "delete from recipe_steps where recipe_no like ?";
		String deleteIngreQuery = "delete from ingredient where recipe_no like ?";
		String deleteQuery = "delete from recipe where recipe_no like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(deleteLikeQuery);
			ps.setInt(1, rno);
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			ps = conn.prepareStatement(deleteStepQuery);
			ps.setInt(1, rno);
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			ps = conn.prepareStatement(deleteIngreQuery);
			ps.setInt(1, rno);
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, rno);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	//like read
	public int likeRead(Connection conn, int rno, String id) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String likeInsertQuery = "select count(inter_no) from interest_recipe where recipe_no like ? and id like ?";
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
	
		String likeInsertQuery = "insert into interest_recipe values(inter_no.NEXTVAL, ?, sysdate, ?)";
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
	
		String likeDeleteQuery = "delete from interest_recipe where recipe_no like ? and id like ?";
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
	//main page
	public ArrayList<Recipe> recommendRecipe(Connection conn) {
		ArrayList<Recipe> volist = null;
		Statement st = null;
		ResultSet rs = null;
		String recommendQuery = "select * from (select rownum rnum, t1.cnt, t1.rec_title, t1.recipe_no, t1.rec_img"
				+ " from (select count(ir.inter_no) cnt, r.rec_title, r.recipe_no, r.rec_img"
				+ " from recipe r left join interest_recipe ir"
				+ " on r.recipe_no = ir.recipe_no"
				+ " group by r.rec_title, r.recipe_no, r.rec_img"
				+ " order by cnt desc) t1)t2"
				+ " where t2.rnum between 1 and 5";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(recommendQuery);
			
			volist = new ArrayList<Recipe>();
			while(rs.next()) {
				Recipe vo = new Recipe();
				vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setRec_img(rs.getString("rec_img"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setLikeCnt(rs.getInt("cnt"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(st);
		}
		return volist;
	}
}