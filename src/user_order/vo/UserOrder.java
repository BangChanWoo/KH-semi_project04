package user_order.vo;

import java.sql.Date;

public class UserOrder {
	private int order_no; //주문번호
	private Date order_date; //주문날짜
	private String address; //배송지주소
	private String receiver_name; //수령자 이름
	private  String receiver_phone; //수령자 전화번호
	private String uid; //아이디

	public UserOrder() {

	}

	public UserOrder(int order_no,Date order_date,String address,String receiver_name,String receiver_phone,String uid) {
		this.order_no=order_no;
		this.order_date=order_date;
		this.address=address;
		this.receiver_name=receiver_name;
		this.receiver_phone=receiver_phone;
		this.uid=uid;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "UserOrder [order_no=" + order_no + ", order_date=" + order_date + ", address=" + address
				+ ", receiver_name=" + receiver_name + ", receiver_phone=" + receiver_phone + ", uid=" + uid + "]";
	}
	

}
