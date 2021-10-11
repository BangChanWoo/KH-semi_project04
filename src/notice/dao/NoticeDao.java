package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import notice.vo.Notice;
import riceThief.common.JdbcTemplate;

public class NoticeDao {

	
	
	public Notice Noticelist(Connection con, int nno) {
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Notice vo = new Notice();
		 
		
		 String noticeListView = "select * from notice where notice_num like? ";
		 
		
		try {

			pstmt = con.prepareStatement(noticeListView);
			pstmt.setInt(1, nno);
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					
					
					vo.setUid(rs.getString("uid"));
					vo.setNotice_num(rs.getInt("notice_num"));
					vo.setNotice_title(rs.getString("notice_title"));
					vo.setNotice_time(rs.getDate("notice_time"));			
				}
			
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}
	
	public Notice viewNotice(int nno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Notice vo = new Notice();
		String noticeView = " select no, title, content, "
				+ "to_char(startDate,'yyyy.mm.dd') startDate, "
				+ "to_char(endDate,'yyyy.mm.dd') endDate, "
				+ "to_char(writeDate,'yyyy.mm.dd') writeDate, "
				+ "to_char(updateDate,'yyyy.mm.dd') updateDate, "
		+ "from image where no=?";
		
		try {
			pstmt = con.prepareStatement(noticeView);
			pstmt.setInt(1,nno);
			rs = pstmt.executeQuery();
			if(rs!=null&rs.next()) {
	
				
				vo.setUid(rs.getString("uid"));
				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_time(rs.getDate("notice_time"));
				vo.setNotice_content(rs.getString("notice_content"));
				vo.setNotice_video(rs.getString("notice_video"));
				vo.setNotice_img(rs.getString("notice_img"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지 글보기 데이터 처리중 db오류 발생");
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}
	
	
	
	public ArrayList<Notice> noticeList(Connection con, int nno) {
		ArrayList<Notice> volist = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		
		String noticeWrite = " insert into notice(notice_num, notice_title, notice_time, notice_content, notice_video, notice_image) values (notice_seq.nextval,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(noticeWrite);
			pstmt.setInt(1,nno);
			rs = pstmt.executeQuery();
			
			volist = new ArrayList<Notice>();
				
			
			while(rs.next()) {
			Notice vo = new Notice();
			
			vo.setNotice_num(rs.getInt("notice_num"));
			vo.setNotice_title(rs.getString("notice_title"));
			vo.setNotice_time(rs.getDate("notice_time"));
			vo.setNotice_content(rs.getString("notice_content"));
			vo.setNotice_video(rs.getString("notice_video"));
			vo.setNotice_img(rs.getString("notice_img"));
			volist.add(vo);
			}
			
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지 글쓰기 데이터 처리중 db오류 발생");
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return volist;
		
	}
	
	public int updateNotice(Connection con, Notice NoticeVo) {
		int result = 0;
		String updateNotice = " ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(updateNotice);
			pstmt.setInt(1, NoticeVo.getNotice_num());
			pstmt.setString(2, NoticeVo.getNotice_title());			
			pstmt.setString(3, NoticeVo.getNotice_content());
			pstmt.setDate(4, NoticeVo.getNotice_time());
			pstmt.setString(5, NoticeVo.getNotice_img());
			pstmt.setString(6, NoticeVo.getNotice_video());
			
			result = pstmt.executeUpdate();
			JdbcTemplate.close(pstmt);
			System.out.println("NOTICEDAO.update() :글수정");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지 글쓰기 데이터 처리중 db오류 발생");
			
		}finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteNotice(Connection con, int nno){
		int result = 0;
		PreparedStatement pstmt = null;
		String DeleteNotice = "delete from Notice where notice_num like ?";
		
		try {
			pstmt=con.prepareStatement(DeleteNotice);
			pstmt.setInt(1,nno);
			result = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지글삭제 처리중 db오류 발생");
			
		}finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
		
}
