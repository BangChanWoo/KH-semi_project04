package comment.vo;

import java.sql.Date;

public class Comment {
	private int comment_no;
	private int recipe_no; //레시피 게시글 번호
	private String uid; //작성자
	private int com_level;
	private int com_origin;
	private Date savedate; //작성 날짜
	private String com_content; //댓글 내용

	public Comment(){}
	public Comment(int comment_no, int recipe_no,String uid, int com_level, int com_origin, Date savedate,String com_content) {
		this.comment_no = comment_no;
		this.recipe_no = recipe_no;
		this.uid = uid;
		this.com_level = com_level;
		this.com_origin = com_origin;
		this.savedate = savedate;
		this.com_content = com_content;
	}
	public Comment(int recipe_no,String uid, int com_level, int com_origin, String com_content) {
		this.recipe_no = recipe_no;
		this.uid = uid;
		this.com_level = com_level;
		this.com_origin = com_origin;
		this.com_content = com_content;
	}
	public Comment(int comment_no, String com_content) {
		this.comment_no = comment_no;
		this.com_content = com_content;
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
	public Date getSavedate() {
		return savedate;
	}
	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getCom_level() {
		return com_level;
	}
	public void setCom_level(int com_level) {
		this.com_level = com_level;
	}
	public int getCom_origin() {
		return com_origin;
	}
	public void setCom_origin(int com_origin) {
		this.com_origin = com_origin;
	}
	@Override
	public String toString() {
		return "Comment [recipe_no=" + recipe_no + ", uid=" + uid + ", savedate=" + savedate + ", com_content="
				+ com_content + "]";
	}
}
