package question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import question.vo.Question;
import riceThief.common.JdbcTemplate;

public class QuestionDao {
	public QuestionDao() {}
	

	public int getQuestionCount(Connection conn, int catenum) {
		int result = 0;
		String countAllQuery = "select count(que_no) from Question";
		String countCateQuery = "select count(que_no) from Question where que_cate_no like ?";
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
	
	public ArrayList<Question> questionList(Connection conn, int start , int end, int catenum) {
		ArrayList<Question> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAllQuery = "";
		
		String selectCateQuery = "";
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
			
			volist = new ArrayList<Question>();
			while(rs.next()) {
				Question vo = new Question();
				vo.setque_no(rs.getInt("que_no"));
				vo.setque_img(rs.getString("que_img"));
				vo.setque_title(rs.getString("que_title"));
				vo.setque_content(rs.getString("que_content"));
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
	public int queDelete(Connection conn, int qno, String id) {
		int result = -1;
		PreparedStatement ps = null;
	
		String deleteQuery = "delete from Question where que_no like ? and id like ?";
		try {
			ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, qno);
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
	
	public int queRead(Connection conn, int qno, String id) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String viewQueQuery = "select count(que_no) from Question where que_no like ? and id like ?";
		try {
			ps = conn.prepareStatement(viewQueQuery);
			ps.setInt(1, qno);
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

}
