package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import user.vo.User;

public class UserDao {

	public UserDao() {
		
	}
	public int insertUser(Connection conn,User vo) {
		 int result= -1;
		 String sql="insert into member(id,pw,uname,nickname,age,gender,email,phone,address,join_data,point,kind) values(?,?,?,?,?,?,?,?,?,?,0,'U')";
		 try {
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1,vo.getUid());
			 pstmt.setString(2,vo.getPw());
			 pstmt.setString(3,vo.getUname());
			 pstmt.setString(4,vo.getNickname());
			 pstmt.setInt(5,vo.getAge());
			 pstmt.setLong(6,vo.getGender());
			 pstmt.setString(7,vo.getEmail());
			 pstmt.setString(8,vo.getPhone());
			 pstmt.setString(9,vo.getAddress());
			 pstmt.setDate(10,vo.getJoin_date());
			 result=pstmt.executeUpdate();
		 }catch(Exception e){
			 e.printStackTrace();	
		 }
		 return result;
	}
	
}