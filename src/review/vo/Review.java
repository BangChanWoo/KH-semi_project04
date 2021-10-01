package review.vo;

import java.sql.Date;

public class Review {
	private int pro_no; //상품 번호
	private String rev_content; //리뷰내용
	private Date rev_date; //리뷰 작성 날짜
	private String uid; //아이디

	public Review() {
		
	}
public Review(int pro_no,String rev_content,Date rev_date,String uid) {
		this.pro_no=pro_no;
		this.rev_content=rev_content;
		this.rev_date=rev_date;
		this.uid=uid;
	}
public int getPro_no() {
	return pro_no;
}
public void setPro_no(int pro_no) {
	this.pro_no = pro_no;
}
public String getRev_content() {
	return rev_content;
}
public void setRev_content(String rev_content) {
	this.rev_content = rev_content;
}
public Date getRev_date() {
	return rev_date;
}
public void setRev_date(Date rev_date) {
	this.rev_date = rev_date;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
@Override
public String toString() {
	return "Review [pro_no=" + pro_no + ", rev_content=" + rev_content + ", rev_date=" + rev_date + ", uid=" + uid
			+ "]";
}


}
