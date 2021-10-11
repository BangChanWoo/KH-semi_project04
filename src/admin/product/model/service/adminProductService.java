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
		return result;
	}
	
}
