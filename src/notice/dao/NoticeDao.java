package notice.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import notice.vo.Notice;
import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class NoticeDao {
	public NoticeDao() {
	}

	public ArrayList<Notice> noticeList(Connection conn, int start, int end) {
		ArrayList<Notice> volist = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String noticeListQuery = "select * from (select rownum as rnum, t1.* "
				+ " from (select * from notice order by notice_num desc) t1 )"
				+ " where rnum between ? and ?";
		System.out.println(start);
		System.out.println(end);
		try {
			ps = conn.prepareStatement(noticeListQuery);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();

			volist = new ArrayList<Notice>();
			while (rs.next()) {
				Notice vo = new Notice();

				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_time(rs.getDate("notice_time"));
				vo.setNotice_content(rs.getString("notice_content"));

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

	public int getNoticeCount(Connection conn) {
		int result = 0;
		String countAllQuery = "select count(notice_num) from notice";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(countAllQuery);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getNoticeCount query 실패");
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(ps);
		}
		return result;
	}

	public Notice noticeDetailList(Connection con, int nno) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Notice vo = new Notice();
		String noticeDlistQuery = "select * from notice where notice_num like? ";

		try {

			ps = con.prepareStatement(noticeDlistQuery);
			ps.setInt(1, nno);
			rs = ps.executeQuery();

			while (rs.next()) {
				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setUid(rs.getString("id"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_time(rs.getDate("notice_time"));
				vo.setNotice_content(rs.getString("notice_content"));
				vo.setNotice_cate_no(rs.getString("notice_cate_no"));
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

// TODO : 관리자모드에서 다시해야함	
	public Notice viewNotice(int nno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Notice vo = new Notice();
		String noticeView = " select no, title, content, " + "to_char(startDate,'yyyy.mm.dd') startDate, "
				+ "to_char(endDate,'yyyy.mm.dd') endDate, " + "to_char(writeDate,'yyyy.mm.dd') writeDate, "
				+ "to_char(updateDate,'yyyy.mm.dd') updateDate, " + "from image where no=?";

		try {
			pstmt = con.prepareStatement(noticeView);
			pstmt.setInt(1, nno);
			rs = pstmt.executeQuery();
			if (rs != null & rs.next()) {

				vo.setUid(rs.getString("uid"));
				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_time(rs.getDate("notice_time"));
				vo.setNotice_content(rs.getString("notice_content"));
				vo.setNotice_video(rs.getString("notice_video"));
				vo.setNotice_img(rs.getString("notice_img"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지 글보기 데이터 처리중 db오류 발생");

		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}

	public int insertNotice(Connection conn, Notice vo) {
		int result = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String noticeInsert = "insert into notice values(?, ?, ?, ?, sysdate)";

		try {
			ps = conn.prepareStatement(noticeInsert);
			ps.setInt(1, vo.getNotice_num());
			ps.setString(2, vo.getNotice_title());
			ps.setString(3, vo.getNotice_content());
			ps.setDate(4, vo.getNotice_time());
		

			result = ps.executeUpdate();
			System.out.println("NOTICEDAO.update() :글수정");

		} catch (Exception e) {
			System.out.println("공지 글쓰기 데이터 처리중 db오류 발생");
			e.printStackTrace();

		} finally {
			JdbcTemplate.close(ps);
			JdbcTemplate.close(rs);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int nno) {
		int result = 0;
		PreparedStatement ps = null;
		String DeleteNotice = "delete from Notice where notice_num like ?";

		try {
			ps = conn.prepareStatement(DeleteNotice);
			ps.setInt(1, nno);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지글삭제 처리중 db오류 발생");

		} finally {
			JdbcTemplate.close(ps);
		}
		return result;
	}

}
