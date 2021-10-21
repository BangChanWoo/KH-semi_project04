package product_order_detail.vo;

public class ProductOrderDetailVo {
	private int pro_no;
	private String pro_img;
	private String pro_title;
	private String order_date;
	private int pro_price;
	private int order_count;
	private char order_state;
	public ProductOrderDetailVo() {}
	
	public ProductOrderDetailVo(int pro_no, String pro_img, String pro_title, String order_date, int pro_price, int order_count, char order_state) {
		this.pro_no = pro_no;
		this.pro_img = pro_img;
		this.pro_title = pro_title;
		this.order_date = order_date;
		this.pro_price = pro_price;
		this.order_count = order_count;
		this.order_state = order_state;
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

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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

	public char getOrder_state() {
		return order_state;
	}

	public void setOrder_state(char order_state) {
		this.order_state = order_state;
	}

	@Override
	public String toString() {
		return "ProductOrderDetailVo [pro_no=" + pro_no + ", pro_img=" + pro_img + ", pro_title=" + pro_title
				+ ", order_date=" + order_date + ", pro_price=" + pro_price + ", order_count=" + order_count
				+ ", order_state=" + order_state + "]";
	}
}
