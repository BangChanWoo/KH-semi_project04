package getProLike.vo;

public class GetProLikeVo {
	private int pro_no;
	private String pro_img;
	private String pro_title;
	private int cnt;
	public GetProLikeVo() {};
	public GetProLikeVo(int pro_no, String pro_img, String pro_title, int cnt) {
		super();
		this.pro_no = pro_no;
		this.pro_img = pro_img;
		this.pro_title = pro_title;
		this.cnt = cnt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "GetProLikeVo [pro_no=" + pro_no + ", pro_img=" + pro_img + ", pro_title=" + pro_title + ", cnt=" + cnt
				+ "]";
	}
}
