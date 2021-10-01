package interset_recipe.vo;

import java.sql.Date;

public class IntersetRecipe {
	private int key; // 관심상품번호
	private String uid; // 아이디
	private Date savedate; // 저장날짜
	private int recipe_no; // 레시피 게시글 번호

	public IntersetRecipe() {

	}

	public IntersetRecipe(int key,String uid,Date savedate,int recipe_no) {
		this.key=key;
		this.uid=uid;
		this.savedate=savedate;
		this.recipe_no=recipe_no;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getSavedate() {
		return savedate;
	}

	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}

	public int getRecipe_no() {
		return recipe_no;
	}

	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}

	@Override
	public String toString() {
		return "IntersetRecipe [key=" + key + ", uid=" + uid + ", savedate=" + savedate + ", recipe_no=" + recipe_no
				+ "]";
	}
	
}
