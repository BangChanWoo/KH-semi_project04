package getBasket.vo;

public class GetBasketVo {
	private String option;
	private String cnt;
	private String proNo;
	private String id;
	
	public GetBasketVo() {}
	public GetBasketVo(String option, String cnt, String proNo, String id) {
		super();
		this.option = option;
		this.cnt = cnt;
		this.proNo = proNo;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "GetBasketVo [option=" + option + ", cnt=" + cnt + ", proNo=" + proNo + ", id=" + id + "]";
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}