package question.vo;

import java.sql.Date;

public class Question {
	private int question_num; // 게시글 번호
	private String uid; // 작성자
	private String question_title; //제목
	private String question_content; //제목
	private String question_img; //내용
	private String question_top_cate; //사진
	private String question_under_cate; //상위 카테고리
	private Date question_time; //하위 카테고리
	private String answer_state; //작성 시간
	private String answer_content; //답변 내용
	private String answer_img; //답변 사진

	public Question(int question_num, String uid, String question_title, String question_content, String question_img,
			String question_top_cate, String question_under_cate, Date question_time, String answer_state,
			String answer_content, String answer_img) {
		this.question_num = question_num;
		this.uid = uid;
		this.question_title = question_title;
		this.question_content = question_content;
		this.question_img = question_img;
		this.question_top_cate = question_top_cate;
		this.question_under_cate = question_under_cate;
		this.question_time = question_time;
		this.answer_state = answer_state;
		this.answer_content = answer_content;
		this.answer_img = answer_img;
	}

	public int getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}

	public String getQuestion_img() {
		return question_img;
	}

	public void setQuestion_img(String question_img) {
		this.question_img = question_img;
	}

	public String getQuestion_top_cate() {
		return question_top_cate;
	}

	public void setQuestion_top_cate(String question_top_cate) {
		this.question_top_cate = question_top_cate;
	}

	public String getQuestion_under_cate() {
		return question_under_cate;
	}

	public void setQuestion_under_cate(String question_under_cate) {
		this.question_under_cate = question_under_cate;
	}

	public Date getQuestion_time() {
		return question_time;
	}

	public void setQuestion_time(Date question_time) {
		this.question_time = question_time;
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
		return "Question [question_num=" + question_num + ", uid=" + uid + ", question_title=" + question_title
				+ ", question_content=" + question_content + ", question_img=" + question_img + ", question_top_cate="
				+ question_top_cate + ", question_under_cate=" + question_under_cate + ", question_time="
				+ question_time + ", answer_state=" + answer_state + ", answer_content=" + answer_content
				+ ", answer_img=" + answer_img + "]";
	}

}
