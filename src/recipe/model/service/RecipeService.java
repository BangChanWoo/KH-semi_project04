package recipe.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import recipe.model.dao.RecipeDao;
import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class RecipeService {
	public int getRecipeCount(int catenum) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new RecipeDao().getRecipeCount(conn, catenum);
			
		return result;
	}
	public ArrayList<Recipe> recipeList(int start , int end, int catenum) {
		ArrayList<Recipe> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new RecipeDao().recipeList(conn, start, end, catenum);
		JdbcTemplate.close(conn);
		return volist;
	}
}