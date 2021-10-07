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
	
	public User loginUser(Connection conn,String id,String pw) {
		User u=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select *from member where memeber where id=? and pw=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs=pstmt.executeQuery();
				
//				  
//				
//				NICKNAME  NOT NULL VARCHAR2(30)  
//				AGE       NOT NULL NUMBER        
//				GENDER    NOT NULL CHAR(1)       
//				EMAIL     NOT NULL VARCHAR2(50)  
//				PHONE     NOT NULL VARCHAR2(40)  
//				ADDRESS   NOT NULL VARCHAR2(200) 
//				JOIN_DATE NOT NULL DATE          
//				POINT              NUMBER        
//				KIND      NOT NULL CHAR(1) 
				if(rs.next()) {
					u=new User();
					u.setUid(rs.getString("id"));
					u.setPw(rs.getString("pw"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
		return u;
	}
	
	
	
}