package admin.sal.vo;

import java.sql.Date;

public class sale {
	private String order_date; //주문날짜
	private int pro_no; //상품 번호
	private String id; //수령자 이름
	private int pro_price; //상품 가격
	private int order_count; //수량
	private char order_status; //처리상태
	private int order_detail_no;
	public sale() {
		
	}
	public sale(String order_date, int pro_no, String id, int pro_price, int order_count, char order_status, int order_detail_no) {
		this.order_date = order_date;
		this.pro_no = pro_no;
		this.id = id;
		this.pro_price = pro_price;
		this.order_count = order_count;
		this.order_status = order_status;
		this.order_detail_no = order_detail_no;
	}
	

	
	
	
	@Override
	public String toString() {
		return "sale [order_date=" + order_date + ", pro_no=" + pro_no + ", id=" + id + ", pro_price=" + pro_price
				+ ", order_count=" + order_count + ", order_status=" + order_status + ", order_detail_no=" + order_detail_no + "]";
	}
	
	public int getOrder_detail_no() {
		return order_detail_no;
	}
	public void setOrder_detail_no(int order_detail_no) {
		this.order_detail_no = order_detail_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public char getOrder_status() {
		return order_status;
	}
	public void setOrder_status(char order_status) {
		this.order_status = order_status;
	}
}
