package user.dao;

import java.sql.Connection;
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
	
	public User login(Connection conn,String id,String pw) {
		User u=null;
		
		String sql="select pw from member where id=? and pw=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			 pstmt.setString(2, pw); 
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				u=new User();
				u.setUid(rs.getString("id"));
				u.setPw(rs.getString("pw"));
				}
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	
}