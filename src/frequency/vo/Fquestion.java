package frequency.vo;

public class Fquestion {
	private int fquestion_no; //게시글 번호
	private String uid; //아이디
	private String fquestion_title; //제목
	private String fquestion_content; //내용
	private String fquestion_cate_no; //카테고리
	
	public Fquestion() {
	}
	
	public Fquestion(int fquestion_no,String uid,String fquestion_title,String fquestion_content,String fquestion_cate_no) {
		this.fquestion_no=fquestion_no;
		this.uid=uid;
		this.fquestion_title=fquestion_title;
		this.fquestion_content=fquestion_content;
		this.fquestion_cate_no=fquestion_cate_no;
	}

	public int getfquestion_no() {
		return fquestion_no;
	}

	public void setfquestion_no(int fquestion_no) {
		this.fquestion_no = fquestion_no;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getfquestion_title() {
		return fquestion_title;
	}

	public void setfquestion_title(String fquestion_title) {
		this.fquestion_title = fquestion_title;
	}

	public String getfquestion_content() {
		return fquestion_content;
	}

	public void setfquestion_content(String fquestion_content) {
		this.fquestion_content = fquestion_content;
	}

	public String getfquestion_cate_no() {
		return fquestion_cate_no;
	}

	public void setfquestion_cate_no(String fquestion_cate_no) {
		this.fquestion_cate_no = fquestion_cate_no;
	}

	@Override
	public String toString() {
		return "FrequencyQuestion [fquestion_no=" + fquestion_no + ", uid=" + uid + ", fquestion_title="
				+ fquestion_title + ", fquestion_content=" + fquestion_content + ", fquestion_cate_no="
				+ fquestion_cate_no + "]";
	}
	
}
