package recipe.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ingredient.vo.Ingredient;
import recipe.model.dao.RecipeDao;
import recipe.model.vo.Recipe;
import recipe_steps.vo.RecipeSteps;
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
	public Recipe recipeDetailList(int rno) {
		Connection conn = JdbcTemplate.getConnection();
		Recipe vo = new Recipe();
		vo = new RecipeDao().recipeDetailList(conn, rno);
		JdbcTemplate.close(conn);
		return vo;
	}
	public ArrayList<Ingredient> ingreList(int rno){
		ArrayList<Ingredient> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new RecipeDao().ingreList(conn, rno);
		JdbcTemplate.close(conn);
		return volist;
	}
	public ArrayList<RecipeSteps> stepList(int rno){
		ArrayList<RecipeSteps> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = new RecipeDao().stepList(conn, rno);
		JdbcTemplate.close(conn);
		return volist;
	}
}