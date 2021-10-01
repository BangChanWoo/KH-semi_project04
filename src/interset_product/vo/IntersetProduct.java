package interset_product.vo;

import java.sql.Date;

public class IntersetProduct {
	private int key; //관심상품번호
	private String uid; //아이디
	private int pro_no; //상품 번호
	private Date savedate;  //저장 날짜

	public IntersetProduct() {
		
	}
public IntersetProduct(int key,String uid,int pro_no,Date savedate) {
		this.key=key;
		this.uid=uid;
		this.pro_no=pro_no;
		this.savedate=savedate;
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
public int getPro_no() {
	return pro_no;
}
public void setPro_no(int pro_no) {
	this.pro_no = pro_no;
}
public Date getSavedate() {
	return savedate;
}
public void setSavedate(Date savedate) {
	this.savedate = savedate;
}
@Override
public String toString() {
	return "IntersetProduct [key=" + key + ", uid=" + uid + ", pro_no=" + pro_no + ", savedate=" + savedate + "]";
}

}
