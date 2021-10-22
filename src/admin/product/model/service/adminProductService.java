package admin.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import admin.product.model.dao.adminProductDao;
import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class adminProductService {
//	public int insertProduct(int pro_cate_no, String pro_title, String pro_image, int pro_price, int pro_delivery, int pro_stock) {
//		int result=0;
//		Connection conn = JdbcTemplate.getConnection();
//		
//		result= new adminProductDao().insertProduct(conn, pro_cate_no, pro_title, pro_image, pro_price, pro_delivery, pro_stock);
//		JdbcTemplate.close(conn);
//		return result;
//	}
//	public int insertProductImg() {
//		int result=0;
//		Connection conn = JdbcTemplate.getConnection();
//		
//		result= new adminProductDao().insertProduct(conn, );
//		JdbcTemplate.close(conn);
//		return result;
//	}
	public int insertProduct(ProductPost productVo, ArrayList<ProductOption> ProductOption, ArrayList<ProductImg> ProductImg) {
		int result=-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new adminProductDao().insertProduct(conn, productVo, ProductOption, ProductImg);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int updateProduct(ProductPost productVo, ArrayList<ProductOption> ProductOption, ArrayList<ProductImg> ProductImg) {
		int result=-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new adminProductDao().updateProduct(conn, productVo, ProductOption, ProductImg);
		JdbcTemplate.close(conn);
		return result;
	}
	public ProductPost productDetailList(int pro_no){
		ProductPost vo = new ProductPost();
		Connection conn = JdbcTemplate.getConnection();
		vo = new adminProductDao().productDetailList(conn, pro_no);
		JdbcTemplate.close(conn);
		return vo;
	}
	
	public ProductPost productTitleList(String pro_title){
		ProductPost vo = new ProductPost();
		Connection conn = JdbcTemplate.getConnection();
		vo = new adminProductDao().productTitleList(conn, pro_title);
		JdbcTemplate.close(conn);
		return vo;
	}
	public int deleteProduct(int pro_no) {
		int result=-1;
		Connection conn = JdbcTemplate.getConnection();
		result = new adminProductDao().deleteProduct(conn, pro_no);
		JdbcTemplate.close(conn);
		return result;
	}
	public ArrayList<ProductOption> ProductOption(int pro_no){
		ArrayList<ProductOption> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new adminProductDao().ProductOption(conn, pro_no);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<ProductImg> ProductImg(int pro_no){
		ArrayList<ProductImg> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new adminProductDao().ProductImg(conn, pro_no);
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int getProductOptionCount(int pro_no) {
		int optCount = 0;
		Connection conn = JdbcTemplate.getConnection();
		optCount = new adminProductDao().getProductOptionCount(conn, pro_no);
		JdbcTemplate.close(conn);
//		System.out.println("test2 : "+result);
		//System.out.println("옵션 수 " + optCount);
		return optCount;
	}
	public int getProductImgCount(int pro_no) {
		int optCount = 0;
		Connection conn = JdbcTemplate.getConnection();
		optCount = new adminProductDao().getProductImgCount(conn, pro_no);
		JdbcTemplate.close(conn);
//		System.out.println("test2 : "+result);
		//System.out.println("이미지 수 " + optCount);
		return optCount;
	}
	
}
