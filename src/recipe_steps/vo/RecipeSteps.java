package recipe_steps.vo;

public class RecipeSteps {
	private int step_no; //레시피 순서 번호
	private String step_content; //레시피 순서 내용
	private String step_img; //레시피 순서 이미지
	private int recipe_no; //레시피 게시글 번호
	private String uid; //작성자

	public RecipeSteps() {

	}

	public RecipeSteps(int step_no,String step_content,String step_img,int recipe_no,String uid) {
		this.step_no=step_no;
		this.step_content=step_content;
		this.step_img=step_img;
		this.recipe_no=recipe_no;
		this.uid=uid;
	}

	public int getStep_no() {
		return step_no;
	}

	public void setStep_no(int step_no) {
		this.step_no = step_no;
	}

	public String getStep_content() {
		return step_content;
	}

	public void setStep_content(String step_content) {
		this.step_content = step_content;
	}

	public String getStep_img() {
		return step_img;
	}

	public void setStep_img(String step_img) {
		this.step_img = step_img;
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
		return "RecipeSteps [step_no=" + step_no + ", step_content=" + step_content + ", step_img=" + step_img
				+ ", recipe_no=" + recipe_no + ", uid=" + uid + "]";
	}
	
}
