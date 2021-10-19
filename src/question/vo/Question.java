package question.vo;

import java.sql.Date;

public class Question {
	private int que_no; // 게시글 번호
	private String uid; // 작성자
	private String que_title; //제목
	private String que_content; //내용
	private String que_img; //사진
	private String que_top_cate; //상위 카테고리
	private String que_under_cate; //하위 카테고리
	private Date que_time; //작성시간
	private String answer_state; //답변 제목
	private String answer_content; //답변 내용
	private String answer_img; //답변 사진
	
	public Question() {
	
	}

	public Question(int que_no, String uid, String que_title, String que_content, String que_img,
			String que_top_cate, String que_under_cate, Date que_time, String answer_state,
			String answer_content, String answer_img) {
		this.que_no = que_no;
		this.uid = uid;
		this.que_title = que_title;
		this.que_content = que_content;
		this.que_img = que_img;
		this.que_top_cate = que_top_cate;
		this.que_under_cate = que_under_cate;
		this.que_time = que_time;
		this.answer_state = answer_state;
		this.answer_content = answer_content;
		this.answer_img = answer_img;
	}

	public int getque_no() {
		return que_no;
	}

	public void setque_no(int que_no) {
		this.que_no = que_no;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getque_title() {
		return que_title;
	}

	public void setque_title(String que_title) {
		this.que_title = que_title;
	}

	public String getque_content() {
		return que_content;
	}

	public void setque_content(String que_content) {
		this.que_content = que_content;
	}

	public String getque_img() {
		return que_img;
	}

	public void setque_img(String que_img) {
		this.que_img = que_img;
	}

	public String getque_top_cate() {
		return que_top_cate;
	}

	public void setque_top_cate(String que_top_cate) {
		this.que_top_cate = que_top_cate;
	}

	public String getque_under_cate() {
		return que_under_cate;
	}

	public void setque_under_cate(String que_under_cate) {
		this.que_under_cate = que_under_cate;
	}

	public Date getque_time() {
		return que_time;
	}

	public void setque_time(Date que_time) {
		this.que_time = que_time;
	}

	public String getAnswer_state() {
		return answer_state;
	}

	public void setAnswer_state(String answer_state) {
		this.answer_state = answer_state;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public String getAnswer_img() {
		return answer_img;
	}

	public void setAnswer_img(String answer_img) {
		this.answer_img = answer_img;
	}

	@Override
	public String toString() {
		return "que [que_no=" + que_no + ", uid=" + uid + ", que_title=" + que_title
				+ ", que_content=" + que_content + ", que_img=" + que_img + ", que_top_cate="
				+ que_top_cate + ", que_under_cate=" + que_under_cate + ", que_time="
				+ que_time + ", answer_state=" + answer_state + ", answer_content=" + answer_content
				+ ", answer_img=" + answer_img + "]";
	}

}