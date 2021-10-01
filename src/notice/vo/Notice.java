package notice.vo;

import java.sql.Date;

public class Notice {
	private int notice_num; //공지사항 번호
	private String uid; //작성자
	private String notice_title; //제목
	private String notice_content; //내용
	private String notice_video; //동영상
	private String notice_img; //사진
	private Date notice_time; //작성시간
	
	public Notice() {
	}
	public Notice(int notice_num,String uid,String notice_title,String notice_content,String notice_video,String notice_img,Date notice_time) {
		this.notice_num=notice_num;
		this.uid=uid;
		this.notice_title=notice_title;
		this. notice_content= notice_content;
		this.notice_video=notice_video;
		this.notice_img=notice_img;
		this.notice_time=notice_time;
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_video() {
		return notice_video;
	}
	public void setNotice_video(String notice_video) {
		this.notice_video = notice_video;
	}
	public String getNotice_img() {
		return notice_img;
	}
	public void setNotice_img(String notice_img) {
		this.notice_img = notice_img;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	@Override
	public String toString() {
		return "Notice [notice_num=" + notice_num + ", uid=" + uid + ", notice_title=" + notice_title
				+ ", notice_content=" + notice_content + ", notice_video=" + notice_video + ", notice_img=" + notice_img
				+ ", notice_time=" + notice_time + "]";
	}
	
}
