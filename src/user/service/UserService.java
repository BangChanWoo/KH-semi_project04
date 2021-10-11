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
	public int loginUser(String uid,String pw) {
		int result=-1;
	Connection conn=getConnection();
	result=new UserDao().loginUser(conn, uid, pw);
	if(result > 0) {
		commit(conn); 
	}else {
		rollback(conn);
	}
	close(conn);
	return result;
	}
	
	
	
}
