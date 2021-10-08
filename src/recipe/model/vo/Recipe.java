package recipe.model.vo;

import java.sql.Date;

public class Recipe {
	private int recipe_no;       // 레시피 게시글 번호
	private String uid;          // 작성자
	private String rec_img;      // 대표사진
	private String rec_title;    // 제목
	private String rec_summary;  // 소개
	private String rec_tip;      // 팁
	private String info_serving;    // 양
	private String info_time;       // 조리시간
	private String info_level;      // 난이도
	private String rec_video;    // 동영상
	private int rec_cate_no;  // 카테고리 번호
	private Date rec_write_date; // 작성시간

	public Recipe() {}
	//read
	public Recipe(int recipe_no, String uid, String rec_img, String rec_title, String rec_summary, String rec_tip,
			String info_serving, String info_time, String info_level,String rec_video,int rec_cate_no,Date rec_write_date) {
		this.recipe_no=recipe_no;
		this.uid=uid;
		this.rec_img=rec_img;
		this.rec_title=rec_title;
		this.rec_summary=rec_summary;
		this.rec_tip=rec_tip;
		this.info_serving=info_serving;
		this.info_time=info_time;
		this.info_level=info_level;
		this.rec_video=rec_video;
		this.rec_cate_no=rec_cate_no;
		this.rec_write_date=rec_write_date;
	}
	//update
	public Recipe(int recipe_no, String uid, String rec_img, String rec_title, String rec_summary, String rec_tip,
			String info_serving, String info_time, String info_level,String rec_video,int rec_cate_no) {
		this.recipe_no=recipe_no;
		this.uid=uid;
		this.rec_img=rec_img;
		this.rec_title=rec_title;
		this.rec_summary=rec_summary;
		this.rec_tip=rec_tip;
		this.info_serving=info_serving;
		this.info_time=info_time;
		this.info_level=info_level;
		this.rec_video=rec_video;
		this.rec_cate_no=rec_cate_no;
	}
	//create
	public Recipe(String uid, String rec_img, String rec_title, String rec_summary, String rec_tip,
			String info_serving, String info_time, String info_level,String rec_video,int rec_cate_no) {
		this.uid=uid;
		this.rec_img=rec_img;
		this.rec_title=rec_title;
		this.rec_summary=rec_summary;
		this.rec_tip=rec_tip;
		this.info_serving=info_serving;
		this.info_time=info_time;
		this.info_level=info_level;
		this.rec_video=rec_video;
		this.rec_cate_no=rec_cate_no;
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

	public String getRec_img() {
		return rec_img;
	}

	public void setRec_img(String rec_img) {
		this.rec_img = rec_img;
	}

	public String getRec_title() {
		return rec_title;
	}

	public void setRec_title(String rec_title) {
		this.rec_title = rec_title;
	}

	public String getRec_summary() {
		return rec_summary;
	}

	public void setRec_summary(String rec_summary) {
		this.rec_summary = rec_summary;
	}

	public String getRec_tip() {
		return rec_tip;
	}

	public void setRec_tip(String rec_tip) {
		this.rec_tip = rec_tip;
	}

	public String getInfo_serving() {
		return info_serving;
	}

	public void setInfo_serving(String info_serving) {
		this.info_serving = info_serving;
	}

	public String getInfo_time() {
		return info_time;
	}

	public void setInfo_time(String info_time) {
		this.info_time = info_time;
	}

	public String getInfo_level() {
		return info_level;
	}

	public void setInfo_level(String info_level) {
		this.info_level = info_level;
	}

	public String getRec_video() {
		return rec_video;
	}

	public void setRec_video(String rec_video) {
		this.rec_video = rec_video;
	}

	public int getRec_cate_no() {
		return rec_cate_no;
	}

	public void setRec_cate_no(int rec_cate_no) {
		this.rec_cate_no = rec_cate_no;
	}

	public Date getRec_write_date() {
		return rec_write_date;
	}

	public void setRec_write_date(Date rec_write_date) {
		this.rec_write_date = rec_write_date;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_no=" + recipe_no + ", uid=" + uid + ", rec_img=" + rec_img + ", rec_title=" + rec_title
				+ ", rec_summary=" + rec_summary + ", rec_tip=" + rec_tip + ", info_serving=" + info_serving
				+ ", info_time=" + info_time + ", info_level=" + info_level + ", rec_video=" + rec_video
				+ ", rec_cate_no=" + rec_cate_no + ", rec_write_date=" + rec_write_date + "]";
	}
	
}
