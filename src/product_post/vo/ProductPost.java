package product_post.vo;

import java.sql.Date;

public class ProductPost {
	private int pro_no; //상품 번호
	private String pro_img; //대표사진
	private String pro_title; //제목
	private int pro_price; //가격
	private Date pro_date; //등록 날짜
	private int pro_stock; //수량
	private int pro_delivery_fee; //배송비
	private int pro_cate_no; //카테고리 번호

	public ProductPost() {
		
	}
public ProductPost(int pro_no,String pro_img,String pro_title,int pro_price,Date pro_date,int pro_stock,int pro_delivery_fee,int pro_cate_no) {
		this.pro_no=pro_no;
		this.pro_img=pro_img;
		this.pro_title=pro_title;
		this.pro_price=pro_price;
		this.pro_date=pro_date;
		this.pro_stock=pro_stock;
		this.pro_delivery_fee=pro_delivery_fee;
		this.pro_cate_no=pro_cate_no;
	}
//상품등록
public ProductPost(String pro_img, String pro_title, int pro_price, int pro_stock, int pro_delivery_fee, int pro_cate_no) {
	this.pro_cate_no=pro_cate_no;
	this.pro_title=pro_title;
	this.pro_img=pro_img;
	this.pro_price=pro_price;
	this.pro_delivery_fee=pro_delivery_fee;
	this.pro_stock=pro_stock;
}
//상품 업데이트
public ProductPost(int pro_no, int pro_cate_no, String pro_title, String pro_img, int pro_price, int pro_delivery_fee, int pro_stock) {
	this.pro_no=pro_no;
	this.pro_cate_no=pro_cate_no;
	this.pro_title=pro_title;
	this.pro_img=pro_img;
	this.pro_price=pro_price;
	this.pro_delivery_fee=pro_delivery_fee;
	this.pro_stock=pro_stock;
}
public int getPro_no() {
	return pro_no;
}
public void setPro_no(int pro_no) {
	this.pro_no = pro_no;
}
public String getPro_img() {
	return pro_img;
}
public void setPro_img(String pro_img) {
	this.pro_img = pro_img;
}
public String getPro_title() {
	return pro_title;
}
public void setPro_title(String pro_title) {
	this.pro_title = pro_title;
}
public int getPro_price() {
	return pro_price;
}
public void setPro_price(int pro_price) {
	this.pro_price = pro_price;
}
public Date getPro_date() {
	return pro_date;
}
public void setPro_date(Date pro_date) {
	this.pro_date = pro_date;
}
public int getPro_stock() {
	return pro_stock;
}
public void setPro_stock(int pro_stock) {
	this.pro_stock = pro_stock;
}
public int getPro_delivery_fee() {
	return pro_delivery_fee;
}
public void setPro_delivery_fee(int pro_delivery_fee) {
	this.pro_delivery_fee = pro_delivery_fee;
}
public int getPro_cate_no() {
	return pro_cate_no;
}
public void setPro_cate_no(int pro_cate_no) {
	this.pro_cate_no = pro_cate_no;
}

@Override
public String toString() {
	return "ProductPost [pro_no=" + pro_no + ", pro_img=" + pro_img + ", pro_title=" + pro_title + ", pro_price="
			+ pro_price + ", pro_date=" + pro_date + ", pro_stock=" + pro_stock + ", pro_delivery_fee="
			+ pro_delivery_fee + ", pro_cate_no=" + pro_cate_no + "]";
}

}
