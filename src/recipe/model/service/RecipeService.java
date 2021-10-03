package recipe.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import recipe.model.dao.RecipeDao;
import recipe.model.vo.Recipe;
import riceThief.common.JdbcTemplate;

public class RecipeService {
	public int getRecipeCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
			
		result = new RecipeDao().getRecipeCount(conn);
			
		return result;
	}
	public ArrayList<Recipe> recipeList(int start , int end) {
		ArrayList<Recipe> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new RecipeDao().recipeList(conn, start, end);
		JdbcTemplate.close(conn);
		return volist;
	}
}