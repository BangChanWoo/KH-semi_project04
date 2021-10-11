package frequency.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import frequency.vo.FrequencyQuestion;
import riceThief.common.JdbcTemplate;

public class FrequencyDao {
	
	public FrequencyQuestion FQuestionlist(Connection conn, int fqno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		FrequencyQuestion fq = new FrequencyQuestion();
		
		String fquestionView = "";
		
		
		try {  
			ps = conn.prepareStatement(fquestionView);
			ps.setInt(1, fqno);
			rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					fq.setF_question_num(rs.getInt("f_question_num"));
					fq.setUid(rs.getString("uid"));
					fq.setF_question_title(rs.getString("f_question_title"));
					fq.setF_question_content(rs.getString("f_question_content"));	
					fq.setF_question_cate(rs.getString("f_question_cate"));	
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return fq;
	}
	public FrequencyQuestion viewFQuestion(int fqno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		FrequencyQuestion fq = new FrequencyQuestion();
		String fquestionView = "";
		
		try {
			ps = con.prepareStatement(fquestionView);
			ps.setInt(1, fqno);
			rs = ps.executeQuery();
			if(rs!=null &rs.next()) {
				
				fq.setF_question_num(rs.getInt("f_question_num"));
				fq.setUid(rs.getString("uid"));
				fq.setF_question_title(rs.getString("f_question_title"));
				fq.setF_question_content(rs.getString("f_question_content"));	
				fq.setF_question_cate(rs.getString("f_question_cate"));	
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("자주묻는질문 글보기 데이터 처리중 오류발생");
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return fq;
	}
	public int updateF_Question(Connection con, String FquestionVo) {
		int result = 0;
		String fquestionUpdate = "";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(fquestionUpdate);
//TODO
//			ps.setInt(1, FquestionVo.getF_question_num());
//			ps.setString(2, FquestionVo.getF_question_title());
//			ps.setString(3, FquestionVo.getStringFquestion_content());
//			ps.setString(4, FquestionVo.getF_Question_cate());
			
			result = ps.executeUpdate();
			JdbcTemplate.close(ps);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	public int deleteF_Question(Connection con, int f_question_num) {
		int result = -1;
		PreparedStatement ps = null;
		String fquestionDelete = "";
		
		try {
			ps = con.prepareStatement(fquestionDelete);
			ps.setInt(1, f_question_num);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}
	
}
