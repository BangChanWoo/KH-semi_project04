package product_option.vo;

public class ProductOption {
	private int pro_option_no; //상품 옵션 번호
	private int pro_no; //상품 번호
	private String pro_option_content; //상품 옵션 내용

	public ProductOption() {
		
	}
public ProductOption(int pro_option_no,int pro_no,String pro_option_content) {
		this.pro_option_no=pro_option_no;
		this.pro_no=pro_no;
		this.pro_option_content=pro_option_content;
	}
public ProductOption(String pro_option_content) {
	this.pro_option_content=pro_option_content;
}
public int getPro_option_no() {
	return pro_option_no;
}
public void setPro_option_no(int pro_option_no) {
	this.pro_option_no = pro_option_no;
}
public int getPro_no() {
	return pro_no;
}
public void setPro_no(int pro_no) {
	this.pro_no = pro_no;
}
public String getPro_option_content() {
	return pro_option_content;
}
public void setPro_option_content(String pro_option_content) {
	this.pro_option_content = pro_option_content;
}
@Override
public String toString() {
	return "ProductOption [pro_option_no=" + pro_option_no + ", pro_no=" + pro_no + ", pro_option_content="
			+ pro_option_content + "]";
}
	

}
