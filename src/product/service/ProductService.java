package product.service;

import java.sql.Connection;
import java.util.ArrayList;

import product.dao.ProductDao;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class ProductService {

	public int getProductCount(int catenum) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new ProductDao().getProductCount(conn, catenum);
			
		return result;
	}
	public ArrayList<ProductPost> productList(int start , int end, int catenum) {
		ArrayList<ProductPost> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductDao().productList(conn, start, end, catenum);
		JdbcTemplate.close(conn);
		return volist;
	}

	// 상품 상세설명 작업 중인 내용
	
/*	public ProductPost productDetailList(int rno) {
		Connection conn = JdbcTemplate.getConnection();
		ProductPost vo = new ProductPost();
		vo = new ProductDao().productDetailList(conn, rno);
		JdbcTemplate.close(conn);
		return vo;
	} 
	
	*/

}
