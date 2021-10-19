package admin.sal.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import admin.sal.model.dao.adminSalDao;
import admin.sal.vo.sale;
import riceThief.common.JdbcTemplate;

public class adminSalService {
	public ArrayList<sale> salList(char order_status){
		ArrayList<sale> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new adminSalDao().salList(conn, order_status);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int getSalCount(char order_status) {
		int result=0;
		Connection conn = JdbcTemplate.getConnection();
		result = new adminSalDao().getSalCount(conn, order_status);
		JdbcTemplate.close(conn);
		return result;
	}
}
