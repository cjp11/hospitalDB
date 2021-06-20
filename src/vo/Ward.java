package vo;

public class Ward {
	private String wno;
	private String wname;
	private int ho;
	private int capacity;
	private int wpay;
	
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public int getHo() {
		return ho;
	}
	public void setHo(int ho) {
		this.ho = ho;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getWpay() {
		return wpay;
	}
	public void setWpay(int wpay) {
		this.wpay = wpay;
	}
	@Override
	public String toString() {
		return "Ward [wno=" + wno + ", wname=" + wname + ", ho=" + ho + ", capacity=" + capacity + ", wpay=" + wpay
				+ "]";
	}
	
	
}
