package domain;

public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private String regdate;
	private String madeby;
	
	// 기본 생성자
	public ProductVO() {}
	
	// 상품 등록
	public ProductVO(String pname, int price, String madeby) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}
	
	// 상품 리스트
	public ProductVO(int pno, String pname, String regdate) {
		this.pno = pno;
		this.pname = pname;
		this.regdate = regdate;
	}
	
	// 상품 상세 페이지
	public ProductVO(int pno, String pname, int price, String regdate, String madeby) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.regdate = regdate;
		this.madeby = madeby;
	}
	
	// 상품 수정
	public ProductVO(int pno, String pname, int price, String madeby) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}

	// getter
	public int getPno() {
		return pno;
	}

	public String getPname() {
		return pname;
	}

	public int getPrice() {
		return price;
	}

	public String getRegdate() {
		return regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	// setter
	public void setPno(int pno) {
		this.pno = pno;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}	
}
