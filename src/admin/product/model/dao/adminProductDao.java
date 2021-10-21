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
		
		String productInsert="insert into product_post values(pro_no.NEXTVAL,?,?,?,sysdate,?,?,?)";
		String optionInsert="insert into product_option values(pro_option_no.NEXTVAL,?,pro_no.CURRVAL)";
		String imgInsert="insert into product_img values(pro_content_no.NEXTVAL,pro_no.CURRVAL,?)";
		try {
			pstmt=conn.prepareStatement(productInsert);
			
			pstmt.setString(1, productVo.getPro_img());
			pstmt.setString(2, productVo.getPro_title());
			pstmt.setInt(3, productVo.getPro_price());
			pstmt.setInt(4, productVo.getPro_stock());
			pstmt.setInt(5, productVo.getPro_delivery_fee());
			pstmt.setInt(6, productVo.getPro_cate_no());
			
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
	
	public int updateProduct(Connection conn, ProductPost productVo, ArrayList<ProductOption> ProductOption, ArrayList<ProductImg> ProductImg) {
		int result=-1;
		String updateProduct ="update product_post set pro_cate_no=?, pro_title=?, pro_img=?, pro_price=?, pro_delivery_fee=?, pro_stock=?  where pro_no like ? ";
		String updateOption = "update product_option set pro_option_content=? where pro_no like ? and pro_option_no like ?";
		String updateImg="update product_img set pro_content_img=? where pro_no like ? and pro_content_no like ?";
		
		// 3번째 pro_no
		String optionInsert="insert into product_option values(pro_option_no.NEXTVAL,?, ?)"; 
		String imgInsert="insert into product_img values(pro_content_no.NEXTVAL,?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(updateProduct);
			pstmt.setInt(1, productVo.getPro_cate_no());
			pstmt.setString(2, productVo.getPro_title());
			pstmt.setString(3, productVo.getPro_img());
			pstmt.setInt(4, productVo.getPro_price());
			pstmt.setInt(5, productVo.getPro_delivery_fee());
			pstmt.setInt(6, productVo.getPro_stock());
			pstmt.setInt(7, productVo.getPro_no());
			result = pstmt.executeUpdate();
			JdbcTemplate.close(pstmt);
			
			// 옵션
			for(int i=0; i<ProductOption.size(); i++) {
				if (ProductOption.get(i).getPro_option_no() != 0) {
					System.out.println("된다."); 
					pstmt = conn.prepareStatement(updateOption);
					pstmt.setString(1, ProductOption.get(i).getPro_option_content());
					pstmt.setInt(2, productVo.getPro_no());
					pstmt.setInt(3, ProductOption.get(i).getPro_option_no());
					result = pstmt.executeUpdate();
					JdbcTemplate.close(pstmt);
					
				}
				else {
					System.out.println("안된다");
					pstmt = conn.prepareStatement(optionInsert);
					pstmt.setString(1,ProductOption.get(i).getPro_option_content());
					pstmt.setInt(2, productVo.getPro_no());
					result=pstmt.executeUpdate();
					JdbcTemplate.close(pstmt);
				}
			}
			
			//상세정보 사진
			for(int i=0; i<ProductImg.size();i++) {
				if(ProductImg.get(i).getPro_content_no() != 0) {
					pstmt = conn.prepareStatement(updateImg);
					pstmt.setString(1,ProductImg.get(i).getPro_content_img());
					pstmt.setInt(2, productVo.getPro_no());
					pstmt.setInt(3, ProductImg.get(i).getPro_content_no());
					result=pstmt.executeUpdate();
					JdbcTemplate.close(pstmt);
				}
				else {
					pstmt = conn.prepareStatement(imgInsert);
					pstmt.setInt(1, productVo.getPro_no());
					pstmt.setString(2,ProductImg.get(i).getPro_content_img());
					
					result = pstmt.executeUpdate();
					JdbcTemplate.close(pstmt);
				}
			}
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public ProductPost productDetailList(Connection conn, int pro_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProductPost vo = new ProductPost();
		String query="select * from product_post where pro_no like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pro_no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				vo.setPro_cate_no(rset.getInt("pro_cate_no"));
				vo.setPro_title(rset.getString("pro_title"));
				vo.setPro_img(rset.getString("pro_img"));
				vo.setPro_price(rset.getInt("pro_price"));
				vo.setPro_delivery_fee(rset.getInt("pro_delivery_fee"));
				vo.setPro_stock(rset.getInt("pro_stock"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB오류"+e.getMessage());
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}
	public ArrayList<ProductOption> ProductOption(Connection conn, int pro_no){
		ArrayList<ProductOption> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String selectIngreQuery = "select pro_option_no, pro_option_content from product_option where pro_no like ? order by pro_option_no";
		
		try {
			pstmt = conn.prepareStatement(selectIngreQuery);
			pstmt.setInt(1, pro_no);
			rset = pstmt.executeQuery();
			
			volist = new ArrayList<ProductOption>();
			while(rset.next()) {
				ProductOption vo = new ProductOption();
				vo.setPro_option_no(rset.getInt("pro_option_no"));
				vo.setPro_option_content(rset.getString("pro_option_content"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB오류"+e.getMessage());
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}
	public ArrayList<ProductImg> ProductImg(Connection conn, int pro_no){
		ArrayList<ProductImg> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String selectIngreQuery = "select pro_content_no, pro_content_img from product_img where pro_no like ? order by pro_content_no";
		
		try {
			pstmt = conn.prepareStatement(selectIngreQuery);
			pstmt.setInt(1, pro_no);
			rset = pstmt.executeQuery();
			
			volist = new ArrayList<ProductImg>();
			while(rset.next()) {
				ProductImg vo = new ProductImg();
				vo.setPro_content_no(rset.getInt("pro_content_no"));
				vo.setPro_content_img(rset.getString("pro_content_img"));
				volist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB오류"+e.getMessage());
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}
	
	public int getProductOptionCount(Connection conn, int pro_no) {
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String Query = "select count(pro_option_no) from product_option where pro_no like ?";
		//System.out.println("여긴돼?");
		try {
			//System.out.println("제발제발제발"+pro_no);
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, pro_no);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
				//System.out.println("test3 : "+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
			//System.out.println("끝");
		}
		
		return result;
	}
	public int getProductImgCount(Connection conn, int pro_no) {
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String Query = "select count(pro_content_no) from product_img where pro_no like ?";
		//System.out.println("여긴돼?");
		try {
			//System.out.println("제발제발제발"+pro_no);
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, pro_no);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
				//System.out.println("test3 : "+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("오류");
		}finally {
			JdbcTemplate.close(rset);
			JdbcTemplate.close(pstmt);
			//System.out.println("끝");
		}
		
		return result;
	}
	public int deleteProduct(Connection conn, int pro_no) {
		int result=0;
		String deleteProductQuery="delete from product_post where pro_no like ?";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(deleteProductQuery);
			pstmt.setInt(1, pro_no);
			result=pstmt.executeUpdate();
			JdbcTemplate.close(pstmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			//System.out.println("끝");
		}
		return result;
	}
}
