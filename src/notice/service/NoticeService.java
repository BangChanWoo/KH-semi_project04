package notice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import notice.vo.Notice;
import notice.dao.NoticeDao;
import riceThief.common.JdbcTemplate;

public class NoticeService {
	public int updateNotice(Notice NoticeVo) {
		int result =-1;
		Connection con = JdbcTemplate.getConnection();
			
		result = new NoticeDao().updateNotice(con, NoticeVo);				
		JdbcTemplate.close(con);
		return result;
	}
	
	public Notice Noticelist(int nno) {
		Connection con = JdbcTemplate.getConnection();
		Notice vo = new Notice();
		vo = new NoticeDao().Noticelist(con, nno);
		JdbcTemplate.close(con);
		return vo;
		
	}
	public Notice viewNotice(int nno) {
		Connection con = JdbcTemplate.getConnection();
		 Notice vo = new Notice();
		 vo = new NoticeDao().viewNotice(nno);
		 JdbcTemplate.close(con);
		return vo;
		 
}
	public int deleteNotice(int nno) {
		int result = -1;
		Connection con = JdbcTemplate.getConnection();
		result = new NoticeDao().deleteNotice(con, nno);
		JdbcTemplate.close(con);
		return result;
		
	}
}
