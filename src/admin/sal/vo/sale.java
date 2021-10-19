package admin.sal.vo;

import java.sql.Date;

public class sale {
	private String order_date; //주문날짜
	private int pro_no; //상품 번호
	private String receiver_name; //수령자 이름
	private int pro_price; //상품 가격
	private int order_count; //수량
	private char order_status; //처리상태
	public sale() {
		
	}
	public sale(String order_date, int pro_no, String receiver_name, int pro_price, int order_count, char order_status) {
		this.order_date = order_date;
		this.pro_no = pro_no;
		this.receiver_name = receiver_name;
		this.pro_price = pro_price;
		this.order_count = order_count;
		this.order_status = order_status;
	}
	

	
	@Override
	public String toString() {
		return "sale [order_date=" + order_date + ", pro_no=" + pro_no + ", receiver_name=" + receiver_name
				+ ", pro_price=" + pro_price + ", order_count=" + order_count + ", order_status=" + order_status + "]";
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
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
