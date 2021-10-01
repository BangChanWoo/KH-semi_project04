package ingredient.vo;

public class Ingredient {
	private int ingre_no; // 재료 번호
	private String ingre_name; // 재료명
	private String ingre_unit; // 재료양
	private int recipe_no; // 레시피 게시글 번호
	private String uid; // 아이디

	public Ingredient() {

	}

	public Ingredient(int ingre_no,String ingre_name,String ingre_unit,int recipe_no,String uid) {
		this.ingre_no=ingre_no;
		this.ingre_name=ingre_name;
		this.ingre_unit=ingre_unit;
		this.recipe_no=recipe_no;
		this.uid=uid;
	}

	public int getIngre_no() {
		return ingre_no;
	}

	public void setIngre_no(int ingre_no) {
		this.ingre_no = ingre_no;
	}

	public String getIngre_name() {
		return ingre_name;
	}

	public void setIngre_name(String ingre_name) {
		this.ingre_name = ingre_name;
	}

	public String getIngre_unit() {
		return ingre_unit;
	}

	public void setIngre_unit(String ingre_unit) {
		this.ingre_unit = ingre_unit;
	}

	public int getRecipe_no() {
		return recipe_no;
	}

	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Ingredient [ingre_no=" + ingre_no + ", ingre_name=" + ingre_name + ", ingre_unit=" + ingre_unit
				+ ", recipe_no=" + recipe_no + ", uid=" + uid + "]";
	}
	
}
