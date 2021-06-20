package vo;

public class PatWaRecord {
	private String pno;
	private String pname;
	private String wno;
	private char wname;
	private int ho;
	private int capacity;
	private int wpay;
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public char getWname() {
		return wname;
	}
	public void setWname(char wname) {
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
		return "PatWaRecord [pno=" + pno + ", pname=" + pname + ", wno=" + wno + ", wname=" + wname + ", ho=" + ho
				+ ", capacity=" + capacity + ", wpay=" + wpay + "]";
	}
	
}
