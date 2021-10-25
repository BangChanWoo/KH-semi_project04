package main.service;

import java.sql.Connection;
import java.util.ArrayList;

import getProLike.vo.GetProLikeVo;
import main.dao.MainDao;
import product_post.vo.ProductPost;
import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class MainService {
	public ArrayList<Recipe> recipeList() {
		ArrayList<Recipe> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new MainDao().recipeList(conn);
		JdbcTemplate.close(conn);
		return volist;
	}
	public int getRecipeCount(String searchField) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new MainDao().getRecipeCount(conn, searchField);
			
		return result;
	}
	public ArrayList<Recipe> searchRecipe(int start , int end, String searchField) {
		ArrayList<Recipe> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new MainDao().searchRecipe(conn, start, end, searchField);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<ProductPost> productList() {
		ArrayList<ProductPost> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new MainDao().productList(conn);
		JdbcTemplate.close(conn);
		return volist;
	}
	public int getProductCount(String searchField) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new MainDao().getProductCount(conn, searchField);
			
		return result;
	}
	public ArrayList<ProductPost> searchProduct(int start , int end, String searchField) {
		ArrayList<ProductPost> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new MainDao().searchProduct(conn, start, end, searchField);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<GetProLikeVo> popularProduct() {
		ArrayList<GetProLikeVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new MainDao().popularProduct(conn);
		JdbcTemplate.close(conn);
		return volist;
	}
}