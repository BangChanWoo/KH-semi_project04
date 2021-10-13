package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import comment.vo.Comment;
import ingredient.vo.Ingredient;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
import riceThief.common.JdbcTemplate;

public class CommentDao {
	public CommentDao() {}
	
	public int insertComment(Connection conn, Comment vo) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String commentInsert = "insert into recipe_comment(comment_no, recipe_no, id, com_content)"
					+ " values(comment_no.NEXTVAL, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(commentInsert);
			ps.setInt(1, vo.getRecipe_no());
			ps.setString(2, vo.getUid());
			ps.setString(3, vo.getCom_content());
			result = ps.executeUpdate();
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
	public int getCommentCount(Connection conn, int rno) {
		int result = 0;
		String countAllQuery = "select count(comment_no) from recipe_comment where recipe_no like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countAllQuery);
			ps.setInt(1, rno);
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
	public ArrayList<Comment> commentList(Connection conn, int rno, int start, int end) {
		ArrayList<Comment> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllquery = "select t3.*"
				+ " from (select rownum r, t2.* from (select t1.* from recipe_comment t1 where recipe_no like ? order by comment_no desc) t2) t3"
				+ " where t3.r between ? and ?";
		try {
			ps = conn.prepareStatement(selectAllquery);
			ps.setInt(1, rno);
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			
			volist = new ArrayList<Comment>();
			while(rs.next()) {
				Comment vo = new Comment();
				vo.setComment_no(rs.getInt("comment_no"));
				vo.setRecipe_no(rs.getInt("recipe_no"));
				vo.setUid(rs.getString("id"));
				vo.setSavedate(rs.getDate("com_date"));
				vo.setCom_content(rs.getString("com_content"));
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
