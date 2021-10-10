package user.service;

import java.sql.Connection;
import static riceThief.common.JdbcTemplate.*;

import user.dao.UserDao;
import user.vo.User;


public class UserService {
	public UserService(){
		
	}
	public int insertUser(User vo) {
		int result=-1;
		Connection conn=getConnection();
		result=new UserDao().insertUser(conn,vo);
		if(result > 0) {
			commit(conn); 
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public User loginUser(String id,String pw) {
	
		Connection conn=getConnection();
		User u=new UserDao().loginUser(conn, id, pw);
		
		close(conn);
		return u;
		
	}
	public int dupIdCheck(String uid) {
		int result=0;
		Connection conn=getConnection();
		result=new UserDao().dupIdCheck(conn,uid);
		return result;
	}
	
	
}
