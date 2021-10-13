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
	
		String commentInsert = "insert into recipe_comment(comment_no, recipe_no, id, com_level, com_origin, com_content)"
					+ " values(comment_no.NEXTVAL, ?, ?, ?, comment_no.currval, ?)";
		String recommentInsert = "insert into recipe_comment(comment_no, recipe_no, id, com_level, com_origin, com_content)"
				+ " values(comment_no.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			if(vo.getCom_origin() == 0) {
				ps = conn.prepareStatement(commentInsert);
				ps.setInt(1, vo.getRecipe_no());
				ps.setString(2, vo.getUid());
				ps.setInt(3, vo.getCom_level());
				ps.setString(4, vo.getCom_content());
			}else {
				ps = conn.prepareStatement(recommentInsert);
				ps.setInt(1, vo.getRecipe_no());
				ps.setString(2, vo.getUid());
				ps.setInt(3, vo.getCom_level());
				ps.setInt(4, vo.getCom_origin());
				ps.setString(5, vo.getCom_content());
			}
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
				+ " from (select rownum r, t2.* from (select t1.* from recipe_comment t1 where recipe_no like ? order by com_origin desc, com_level asc) t2) t3"
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
				vo.setCom_level(rs.getInt("com_level"));
				vo.setCom_origin(rs.getInt("com_origin"));
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
	//update
	public int updateComment(Connection conn, Comment vo) {
		int result = -1;
		String updateQuery = "update recipe_comment set com_content = ? where comment_no like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateQuery);
			ps.setString(1, vo.getCom_content());
			ps.setInt(2, vo.getComment_no());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	//delete
	public int deleteComment(Connection conn, int comno) {
		int result = -1;
		String deleteQuery = "delete from recipe_comment where comment_no like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, comno);
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
