package product.service;

import java.sql.Connection;
import java.util.ArrayList;

import product.dao.ProductDao;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
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
	
	public ProductPost productDetailList(int rno) {
		Connection conn = JdbcTemplate.getConnection();
		ProductPost vo = new ProductPost();
		vo = new ProductDao().productDetailList(conn, rno);
		JdbcTemplate.close(conn);
		return vo;
	}	
	
	public ArrayList<ProductOption> optionList(int rno){
		ArrayList<ProductOption> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductDao().optionList(conn, rno);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<ProductImg> proImgList(int rno){
		ArrayList<ProductImg> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductDao().proImgList(conn, rno);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	//like read
	public int likeRead(int rno, String id) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductDao().likeRead(conn, rno, id);
		JdbcTemplate.close(conn);
		return result;
	}
	//like create
	public int likeCreate(int rno, String id) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductDao().likeCreate(conn, rno, id);
		JdbcTemplate.close(conn);
		return result;
	}
	//like delete
	public int likeDelete(int rno, String id) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		result = new ProductDao().likeDelete(conn, rno, id);
		JdbcTemplate.close(conn);
		return result;
	}
	//관심 recipe
	public ArrayList<ProductPost> interProduct(int rno, String id) {
		ArrayList<ProductPost> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductDao().interProList(conn, rno, id);
		JdbcTemplate.close(conn);
		return volist;
	}
}