package product.service;

import java.sql.Connection;
import java.util.ArrayList;

import product.dao.ProductDao;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class ProductService {

	//create
	/*public int insertProduct(ProductPost productVo, ArrayList<ProductOption> optionList, ArrayList<ProductImg> proImgList) {
		int result =-1;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new ProductDao().insertProduct(conn, productVo, optionList, proImgList);
				
		JdbcTemplate.close(conn);
		return result;	
	}*/
	
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
	//recommend product  (메인페이지에 추천상품 - 미완성)

	/*public ArrayList<ProductPost> recommendProduct() {
		ArrayList<ProductPost> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new ProductDao().recommendProduct(conn);
		JdbcTemplate.close(conn);
		return volist; 
	}*/
	
}