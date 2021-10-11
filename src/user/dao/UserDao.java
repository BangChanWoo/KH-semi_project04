package user.dao;

import java.sql.Connection;
import static riceThief.common.JdbcTemplate.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.vo.User;

public class UserDao {

	public UserDao() {
		
	}
	public int insertUser(Connection conn,User vo) {
		 int result= -1;
		 String sql="insert into member(id,pw,uname,nickname,age,gender,email,phone,address,join_date,point,kind) values(?,?,?,?,?,?,?,?,?,sysdate,0,'U')";
		 try {
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1,vo.getUid());
			 pstmt.setString(2,vo.getPw());
			 pstmt.setString(3,vo.getUname());
			 pstmt.setString(4,vo.getNickname());
			 pstmt.setInt(5,vo.getAge());
			 pstmt.setString(6, String.valueOf(vo.getGender()));
			 pstmt.setString(7,vo.getEmail());
			 pstmt.setString(8,vo.getPhone());
			 pstmt.setString(9,vo.getAddress());
			 result=pstmt.executeUpdate();
		 }catch(Exception e){
			 e.printStackTrace();	
		 }
		 return result;
	}
	
	public int loginUser(Connection conn,String uid,String pw) {
		int result=-1;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM TEST_MEMBER WHERE ID = ? AND PASSWD = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("uid").equals(uid) && rs.getString("pw").equals(pw)) {
					return 1;
				}else {
					return 0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int dupIdCheck(Connection conn,String uid) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) from user where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
}