package user.basket.service;

import java.sql.Connection;
import java.util.ArrayList;

import cartDetail.vo.CartDetailVo;
import getBasket.vo.GetBasketVo;
import riceThief.common.JdbcTemplate;
import user.basket.dao.BasketDao;

public class BasketService {
	public int getBasketCount(String id) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new BasketDao().getBasketCount(conn, id);
		return result;
	}
	public ArrayList<CartDetailVo> basketList(String id) {
		ArrayList<CartDetailVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new BasketDao().basketList(conn, id);
		JdbcTemplate.close(conn);
		return volist;
	}
	public int insertBasket(String id, ArrayList<GetBasketVo> bkList) {
		int result =-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new BasketDao().insertBasket(conn, id, bkList);
		JdbcTemplate.close(conn);
		return result;	
	}
}