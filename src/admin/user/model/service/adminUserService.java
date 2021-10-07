package admin.user.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import admin.user.model.dao.adminUserDao;
import riceThief.common.JdbcTemplate;
import user.vo.User;

public class adminUserService {
	public ArrayList<User> adminUserList(String uid) {
		ArrayList<User> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new adminUserDao().adminUserList(conn, uid);
		JdbcTemplate.close(conn);
//		System.out.println();
		return volist;
	}
	public ArrayList<User> adminUserList(int start, int end) {
		ArrayList<User> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		System.out.println(start);
		System.out.println(end);
		volist = new adminUserDao().adminUserList(conn, start, end);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<User> getUserAge() { //나이 갖고오기
		ArrayList<User> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new adminUserDao().getUserAge(conn);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int getUserCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new adminUserDao().getUserCount(conn);
		JdbcTemplate.close(conn);
		System.out.println("test2 : "+result);
		return result;
	}
	
	public int getGenderCount() {
		int men = 0;
		Connection conn = JdbcTemplate.getConnection();
		men = new adminUserDao().getGenderCount(conn);
		JdbcTemplate.close(conn);
//		System.out.println("test2 : "+result);
		System.out.println("남성수2 : "+men);
		return men;
	}
	public int updateUser(String pw, String uname, String nickname, int age, char gender, String email, String phone, String address, int point, char kind, String id) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new adminUserDao().updateUser(conn, pw, uname, nickname, age,gender,email,phone,address,point,kind,id);
		JdbcTemplate.close(conn);
		return result;
	}
	public int deleteUser(String id) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result= new adminUserDao().deleteUser(conn, id);
		JdbcTemplate.close(conn);
		return result;
	}
}
