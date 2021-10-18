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
	
	public ArrayList<User> getUserAge(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<User> volist = null;
		String sql = "select age from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<User>();
			while(rset.next()) {
				User vo = new User();
				vo.setAge(rset.getInt("age"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<User> getUserId(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<User> volist = null;
		String sql = "select uid from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<User>();
			while(rset.next()) {
				User vo = new User();
				vo.setUid(rset.getString("uid"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}
	

	public ArrayList<User> adminUserList(Connection conn, int start, int end){
		ArrayList<User> volist = null;
		
//		String sql="select rownum r, id, uname from member where rownum between ? and ?";
		String sql="select rnum, id, uname, join_date "
				+ "from (select rownum as rnum, id, uname, join_date "
				+ "from (select rownum as rnum, id, uname, join_date from member order by join_date))"
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
				vo.setJoin_date(rset.getDate("join_date"));
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
	
	public int updateUser(Connection conn, String pw, String uname, String nickname, int age, char gender, String email, String phone, String address, int point, char kind, String id) {
		int result= -1;
		String sql = "update member set pw=?,uname=?,nickname=?,age=?,gender=?,email=?,phone=?,address=?,point=?,kind=? where id = ? ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, uname);
			pstmt.setString(3, nickname);
			pstmt.setInt(4, age);
			pstmt.setString(5, String.valueOf(gender));
			pstmt.setString(6, email);
			pstmt.setString(7, phone);
			pstmt.setString(8, address);
			pstmt.setInt(9, point);
			pstmt.setString(10, String.valueOf(kind));
			pstmt.setString(11, id);
			
			result = pstmt.executeUpdate();
			JdbcTemplate.close(pstmt);
			if(result > 0) {
				System.out.println("수정 성공");
				result=1;
				JdbcTemplate.close(pstmt);
			} else {
				System.out.println("수정 실패");
				result=0;
				JdbcTemplate.close(pstmt);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(Connection conn, String id) {
		System.out.println("삭제진입3");
		System.out.println(id);
		int result= -1;
		String sql = "delete from member where id=?";
		PreparedStatement pstmt=null;
		try {
			System.out.println("삭제진입4");
			pstmt = conn.prepareStatement(sql);
			System.out.println("삭제진입5");
			pstmt.setString(1,id);
			System.out.println("삭제진입6");
			result = pstmt.executeUpdate(); 
			System.out.println("삭제진입7");
			JdbcTemplate.close(pstmt);// 위 연결된 곳으로 insert/delete/update query 문을 날려줌
			if(result > 0) {
				System.out.println("삭제 성공");
				result=1;
				JdbcTemplate.close(pstmt);
			} else {
				System.out.println("삭제 실패");
				result=0;
				JdbcTemplate.close(pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
