package user.dao;

import java.sql.Connection;
import static riceThief.common.JdbcTemplate.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import user.vo.User;

public class UserDao {

	public UserDao() {

	}

	public int insertUser(Connection conn, User vo) {
		int result = -1;
		String sql = "insert into member(id,pw,uname,nickname,age,gender,email,phone,address,join_date,point,kind) values(?,?,?,?,?,?,?,?,?,sysdate,0,'U')";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getUname());
			pstmt.setString(4, vo.getNickname());
			pstmt.setInt(5, vo.getAge());
			pstmt.setString(6, String.valueOf(vo.getGender()));
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getPhone());
			pstmt.setString(9, vo.getAddress());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public User getNick(Connection conn, String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User vo = null;
		String query = "select nickname from member where id like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();

			vo = new User();
			if (rs.next()) {
				vo.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			close(rs);
			close(ps);
		}
		return vo;
	}

	public int loginUser(Connection conn, String uid, String pw) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ? and pw = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1; // 로그인 성공하면 1, 못찾으면 -1
				if(uid.equals("admin") && pw.equals("admin")) {
					result=2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	

	public User dupIdCheck(Connection conn, String uid) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getString("uid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}

	public User findId(Connection conn, String uname, String phone) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from member where uname=? and  phone=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			u = new User();
			if (rs.next()) {
				u.setUid(rs.getString("uid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}
	public User findPw(Connection conn,String uid,String uname,String phone) {
		User u=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pw from member where id=? and uname=? and  phone=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, uname);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			u = new User();
			if (rs.next()) {
				u.setPw(rs.getString("pw"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}

	public int deleteUser(Connection conn, String uid) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateUser(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "update member set pw=?,uname=?,nickname=?,email=?,phone=?,address=?,age=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getPw());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getNickname());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getPhone());
			pstmt.setString(6, u.getAddress());
			pstmt.setInt(7, u.getAge());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public User getUserInfo(Connection conn, String uid) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getString("id"));
				u.setPw(rs.getString("pw"));
				u.setUname(rs.getString("uname"));
				u.setNickname(rs.getString("nickname"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setAddress(rs.getString("address"));
				//char형 String 변환.;;;;;
				u.setAge(rs.getInt("age"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("getUserInfo() 결과 :"+u);
		return u;
	}
}