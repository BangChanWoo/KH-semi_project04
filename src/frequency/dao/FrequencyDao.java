package frequency.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import frequency.vo.Fquestion;
import riceThief.common.JdbcTemplate;

public class FrequencyDao {
	public FrequencyDao() {}
	
	public int insertFquestion(Connection conn, int fquestionVo) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String FQuestionInsert = "insert into fquestion"
					+ " values(fquestion_no.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(FQuestionInsert);
			ps.setInt(1, rs.getInt("fquestion_no"));
			ps.setString(2, rs.getString("Uid"));
			ps.setString(3, rs.getString("fquestion_title"));
			ps.setString(4, rs.getString("getfquestion_content"));
			ps.setString(5, rs.getString("getfquestion_cate"));
			
			result = ps.executeUpdate();
		} catch (Exception e) {
		
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		
		}
		return result;
	}
			
		
	
	public int getFquestionCount(Connection conn, int catenum) {
		int result = 0;
		String countAllQuery = "select count(Fquestion_no) from Fquestion";
		String countCateQuery = "select count(Fquestion_no) from Fquestion where fquestion_cate_no like ?";
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
			
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public ArrayList<Fquestion> fquestionList(Connection conn, int start , int end, int catenum) {
		ArrayList<Fquestion> volist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//TODO
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
			
			volist = new ArrayList<Fquestion>();
			while(rs.next()) {
				
				Fquestion vo = new Fquestion();
				vo.setfquestion_no(rs.getInt("fquestion_no"));
				vo.setfquestion_content(rs.getString("fquestion_content"));
				vo.setfquestion_title(rs.getString("fquestion_title"));
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
	public int updateFquestion(Connection conn, Fquestion fquestionVo) {
		int result = -1;
		String updateQuery = "update Fquestion set fquestion_title = ?, fquestion_content = ?, fquestion_cate_no = ? where fquestion_no like ?";
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateQuery);
			ps.setString(1, rs.getString("frequestion_title"));
			ps.setString(2, rs.getString("frequestion_content"));		
			ps.setInt(3, rs.getInt("frequestion_cate_no"));
			ps.setInt(4, rs.getInt("frequestion_no"));
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);		
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	
	public int deleteFquestion(Connection conn, int fqno) {
		int result = -1;
		String deleteQuery = "delete from Fquestion where fquestion_no like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, fqno);
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	
	
	
}
