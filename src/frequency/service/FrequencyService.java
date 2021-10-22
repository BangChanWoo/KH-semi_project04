package frequency.service;

import java.sql.Connection;
import java.util.ArrayList;

import frequency.dao.FrequencyDao;
import frequency.vo.Fquestion;
import riceThief.common.JdbcTemplate;

public class FrequencyService {
	public int insertFquestion(Fquestion FquestionVo) {
		int result =-1;
		Connection conn = JdbcTemplate.getConnection();
			
//		result = new FrequencyDao().insertFquestion(conn, int fquestionVo);
				
		JdbcTemplate.close(conn);
		return result;	
	}
	public int getFquestionCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new FrequencyDao().getFquestionCount(conn);
			
		return result;
	}
	public ArrayList<Fquestion> FquestionList(int start , int end) {
		ArrayList<Fquestion> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new FrequencyDao().fquestionList(conn, start, end);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public Fquestion fquestionDetailList(int fno) {
		Connection conn = JdbcTemplate.getConnection();
		Fquestion vo = new Fquestion();
		vo = new FrequencyDao().fquestionDetailList(conn, fno);
		JdbcTemplate.close(conn);
		return vo;
	}

	//update
	public int updateFquestion(Fquestion FquestionVo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new FrequencyDao().updateFquestion(conn, FquestionVo);
		JdbcTemplate.close(conn);
		return result;
	}
	//delete
	public int deleteFquestion(int fqno) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new FrequencyDao().deleteFquestion(conn, fqno);
		JdbcTemplate.close(conn);
		return result;
	}
}