package product_img.vo;

public class ProductImg {
	private int pro_content_no; //상품 게시글 이미지 번호
	private int pro_no; //상품 번호
	private String pro_content_img; //상품 상세정보 이미지 경로

	public ProductImg() {
		
	}
public ProductImg(int pro_content_no,int pro_no,String pro_content_img) {
		this.pro_content_no=pro_content_no;
		this.pro_no=pro_no;
		this.pro_content_img=pro_content_img;
	}
public ProductImg(String pro_content_img) {
	this.pro_content_img=pro_content_img;
}
public int getPro_content_no() {
	return pro_content_no;
}
public void setPro_content_no(int pro_content_no) {
	this.pro_content_no = pro_content_no;
}
public int getPro_no() {
	return pro_no;
}
public void setPro_no(int pro_no) {
	this.pro_no = pro_no;
}
public String getPro_content_img() {
	return pro_content_img;
}
public void setPro_content_img(String pro_content_img) {
	this.pro_content_img = pro_content_img;
}
@Override
public String toString() {
	return "ProductImg [pro_content_no=" + pro_content_no + ", pro_no=" + pro_no + ", pro_content_img="
			+ pro_content_img + "]";
}

}
