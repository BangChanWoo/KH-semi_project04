package frequency.vo;

public class FrequencyQuestion {
	private int f_question_num; //게시글 번호
	private String uid; //아이디
	private String f_question_title; //제목
	private String f_question_content; //내용
	private String f_question_cate; //카테고리
	
	public FrequencyQuestion() {
	}
	
	public FrequencyQuestion(int f_question_num,String uid,String f_question_title,String f_question_content,String f_question_cate) {
		this.f_question_num=f_question_num;
		this.uid=uid;
		this.f_question_title=f_question_title;
		this.f_question_content=f_question_content;
		this.f_question_cate=f_question_cate;
	}

	public int getF_question_num() {
		return f_question_num;
	}

	public void setF_question_num(int f_question_num) {
		this.f_question_num = f_question_num;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getF_question_title() {
		return f_question_title;
	}

	public void setF_question_title(String f_question_title) {
		this.f_question_title = f_question_title;
	}

	public String getF_question_content() {
		return f_question_content;
	}

	public void setF_question_content(String f_question_content) {
		this.f_question_content = f_question_content;
	}

	public String getF_question_cate() {
		return f_question_cate;
	}

	public void setF_question_cate(String f_question_cate) {
		this.f_question_cate = f_question_cate;
	}

	@Override
	public String toString() {
		return "FrequencyQuestion [f_question_num=" + f_question_num + ", uid=" + uid + ", f_question_title="
				+ f_question_title + ", f_question_content=" + f_question_content + ", f_question_cate="
				+ f_question_cate + "]";
	}
	
}
