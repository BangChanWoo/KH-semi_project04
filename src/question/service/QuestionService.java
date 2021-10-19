package question.service;

import java.sql.Connection;
import java.util.ArrayList;

import question.dao.QuestionDao;
import question.vo.Question;
import riceThief.common.JdbcTemplate;

public class QuestionService {
	public ArrayList<Question> QuestionList(int start , int end, int catenum) {
		ArrayList<Question> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new QuestionDao().questionList(conn, start, end, catenum);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int questionRead(int qno, String id) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new QuestionDao().queRead(conn, qno, id);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int questionDelete(int qno, String id) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new QuestionDao().queDelete(conn, qno, id);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int getQuestionCount(int catenum) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new QuestionDao().getQuestionCount(conn, catenum);
			
		return result;
	}

}
