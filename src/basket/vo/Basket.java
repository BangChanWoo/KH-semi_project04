package basket.vo;

import java.sql.Date;

public class Basket {
	private int cart_no; //장바구니 번호
	private String uid; //아이디
	private int pro_no; //상품 번호
	private Date sotre_date; //저장 날짜
	private int pro_count; //수량

	public Basket() {

	}

	public Basket(int cart_no,String uid,int pro_no,Date sotre_date,int pro_count) {
		this.cart_no=cart_no;
		this.uid=uid;
		this.pro_no=pro_no;
		this.sotre_date=sotre_date;
		this.pro_count=pro_count;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
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

	public Date getSotre_date() {
		return sotre_date;
	}

	public void setSotre_date(Date sotre_date) {
		this.sotre_date = sotre_date;
	}

	public int getPro_count() {
		return pro_count;
	}

	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}

	@Override
	public String toString() {
		return "Basket [cart_no=" + cart_no + ", uid=" + uid + ", pro_no=" + pro_no + ", sotre_date=" + sotre_date
				+ ", pro_count=" + pro_count + "]";
	}
	
}
