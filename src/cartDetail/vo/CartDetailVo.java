package cartDetail.vo;

public class CartDetailVo {
	private int cart_no;
	private int pro_no;
	private String pro_img;
	private String pro_title;
	private int pro_price;
	private String pro_option;
	private int option_cnt;
	private int pro_delivery_fee;
	
	public CartDetailVo() {}
	public CartDetailVo(int cart_no, int pro_no, String pro_img, String pro_title, int pro_price, String pro_option, int option_cnt, int pro_delivery_fee) {
		this.cart_no = cart_no;
		this.pro_no = pro_no;
		this.pro_img = pro_img;
		this.pro_title = pro_title;
		this.pro_price = pro_price;
		this.pro_option = pro_option;
		this.option_cnt = option_cnt;
		this.pro_delivery_fee = pro_delivery_fee;
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
	public String getPro_option() {
		return pro_option;
	}
	public void setPro_option(String pro_option) {
		this.pro_option = pro_option;
	}
	public int getOption_cnt() {
		return option_cnt;
	}
	public void setOption_cnt(int option_cnt) {
		this.option_cnt = option_cnt;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getPro_delivery_fee() {
		return pro_delivery_fee;
	}
	public void setPro_delivery_fee(int pro_delivery_fee) {
		this.pro_delivery_fee = pro_delivery_fee;
	}
	@Override
	public String toString() {
		return "CartDetailVo [cart_no=" + cart_no + ", pro_no=" + pro_no + ", pro_img=" + pro_img + ", pro_title="
				+ pro_title + ", pro_price=" + pro_price + ", pro_option=" + pro_option + ", option_cnt=" + option_cnt
				+ ", pro_delivery_fee=" + pro_delivery_fee + "]";
	}
}
