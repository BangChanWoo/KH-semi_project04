package user.service;

import java.sql.Connection;
import java.util.ArrayList;

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
	public User getNick(String id) {
	      Connection conn = getConnection();
	      User vo = new UserDao().getNick(conn, id);
	      close(conn);
	      return vo;
	   }
	  
	public int loginUser(String uid,String pw) {
		int result=-1;
	Connection conn=getConnection();
	result=new UserDao().loginUser(conn,uid,pw);
	if(result > 0) {
		commit(conn); 
	}else {
		rollback(conn);
	}
	close(conn);
	return result;
	}
	
	public ArrayList<User> dupIdCheck() {
		ArrayList<User> idList=null;
		Connection conn=getConnection();
		idList=new UserDao().dupIdCheck(conn);
		close(conn);
		return idList;
	}
	public User findId(String uname,String phone) {
		Connection conn=getConnection();
		User u=new UserDao().findId(conn,uname,phone);
		close(conn);
		return u;
	}
	public User findPw(String uid,String uname,String phone) {
		Connection conn=getConnection();
		User u=new UserDao().findPw(conn,uid,uname,phone);
		close(conn);
		return u;
	}
	public int deleteUser(String uid) {
		Connection conn=getConnection();
		int result=new UserDao().deleteUser(conn, uid);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	public int updateUser(User u) {
		Connection conn=getConnection();
		UserDao dao=new UserDao();
		int result=dao.updateUser(conn,u);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	public User getUserInfo(String uid) {
		Connection conn=getConnection();
		UserDao dao=new UserDao();
		User vo=dao.getUserInfo(conn,uid);
		return vo;
	}
	public int userOut(String id) {
		Connection conn=getConnection();
		UserDao dao=new UserDao();
		int result=dao.userOut(conn,id);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
}
