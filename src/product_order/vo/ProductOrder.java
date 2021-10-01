package product_order.vo;

public class ProductOrder {
	private int order_detail_num; //주문상세번호
	private int order_count; //수량
	private char order_status; //처리상태
	private int order_no; //주문 번호
	private int pro_no; //상품 번호

	public ProductOrder() {
	
	}
	public ProductOrder(int order_detail_num,int order_count,char order_status,int order_no,int pro_no) {
		this.order_detail_num=order_detail_num;
		this.order_count=order_count;
		this.order_status=order_status;
		this.order_no=order_no;
		this.pro_no=pro_no;
	}
	public int getOrder_detail_num() {
		return order_detail_num;
	}
	public void setOrder_detail_num(int order_detail_num) {
		this.order_detail_num = order_detail_num;
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
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	@Override
	public String toString() {
		return "ProductOrder [order_detail_num=" + order_detail_num + ", order_count=" + order_count + ", order_status="
				+ order_status + ", order_no=" + order_no + ", pro_no=" + pro_no + "]";
	}

}
