package admin.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import user.vo.User;
import riceThief.common.JdbcTemplate;
public class adminUserDao {

	public ArrayList<User> adminUserList(Connection conn,String uid){
		ArrayList<User> volist = null;
		
		String sql="select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rset = pstmt.executeQuery();
			
			volist = new ArrayList<User>();
			
			while(rset.next()) {
				User vo = new User();
				vo.setUid(rset.getString("id"));
				vo.setPw(rset.getString("pw"));
				vo.setUname(rset.getString("uname"));
				vo.setNickname(rset.getString("nickname"));
				vo.setAge(rset.getInt("age"));
				vo.setGender(rset.getString("gender").charAt(0));
				vo.setEmail(rset.getString("email"));
				vo.setPhone(rset.getString("phone"));
				vo.setAddress(rset.getString("address"));
				vo.setJoin_date(rset.getDate("join_date"));
				vo.setPoint(rset.getInt("point"));
				vo.setType(rset.getString("kind").charAt(0));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		
		
		return volist;
	}

	public ArrayList<User> adminUserList(Connection conn, int start, int end){
		ArrayList<User> volist = null;
		
//		String sql="select rownum r, id, uname from member where rownum between ? and ?";
		String sql="select rnum, id, uname "
				+ "from (select rownum as rnum, id, uname "
				+ "from (select rownum as rnum, id, uname from member order by join_date))"
				+ "where rnum between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			volist = new ArrayList<User>();
			
			while(rset.next()) {
				User vo = new User();
				
				vo.setUid(rset.getString("id"));
				vo.setUname(rset.getString("uname"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		
		return volist;
	}

	public int getUserCount(Connection conn) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "select count(rownum) from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
				System.out.println("test3 : "+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	
	public int getGenderCount(Connection conn) {
		// TODO Auto-generated method stub
		int men = 0;
		String sql = "select count(decode(gender,'M',1)) from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				men = rset.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}

		System.out.println("testtest1 : "+men);
		return men;
	}
	
}
