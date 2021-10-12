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
	public int loginUser(String uid,String pw,String nickname) {
		int result=-1;
	Connection conn=getConnection();
	result=new UserDao().loginUser(conn,uid,pw,nickname);
	if(result > 0) {
		commit(conn); 
	}else {
		rollback(conn);
	}
	close(conn);
	return result;
	}
	public User dupIdCheck(String uid) {
		Connection conn=getConnection();
		 User u=new UserDao().dupIdCheck(conn, uid);
		 close(conn);
		 return u;
	}
	public User findId(String name,String phone) {
		Connection conn=getConnection();
		User u=new UserDao().findId(conn,name,phone);
		close(conn);
		return u;
	}
	
}
