package admin.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product_img.vo.ProductImg;
import product_option.vo.ProductOption;
import product_post.vo.ProductPost;
import riceThief.common.JdbcTemplate;

public class adminProductDao {
//	public int insertProduct(Connection conn, int pro_cate_no, String pro_title, String pro_image, int pro_price, int pro_delivery, int pro_stock) {
//		int result=0;
//		return result;
//	}
	
	
	public int insertProduct(Connection conn, ProductPost productVo, ArrayList<ProductOption> ProductOption, ArrayList<ProductImg> ProductImg) {
		int result=-1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String productInsert="insert into productpost values(pro_no.NEXTVAL,?,?,?,?,?,?,sysdate)";
		String optionInsert="insert into product_option values(pro_option_no.NEXTVAL,?,pro_no.CURRVAL)";
		String imgInsert="insert into product_img values(pro_content_no.NEXTVAL,pro_no.CURRVAL, ?)";
		try {
			pstmt=conn.prepareStatement(productInsert);
			pstmt.setInt(1, productVo.getPro_cate_no());
			pstmt.setString(2, productVo.getPro_title());
			pstmt.setString(3, productVo.getPro_img());
			pstmt.setInt(4, productVo.getPro_pirce());
			pstmt.setInt(5, productVo.getPro_delivery_fee());
			pstmt.setInt(6, productVo.getPro_stock());
			result = pstmt.executeUpdate();
			JdbcTemplate.close(pstmt);
			
			for(int i=0; i<ProductOption.size();i++) {
				pstmt = conn.prepareStatement(optionInsert);
				pstmt.setString(1,ProductOption.get(i).getPro_option_content());
				result = pstmt.executeUpdate();
			}
			JdbcTemplate.close(pstmt);
			
			for(int i=0; i<ProductImg.size();i++) {
				pstmt = conn.prepareStatement(imgInsert);
				pstmt.setString(1,ProductImg.get(i).getPro_content_img());
				result = pstmt.executeUpdate();
			}
			JdbcTemplate.close(pstmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
}
