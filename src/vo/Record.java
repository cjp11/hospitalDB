package vo;

public class Record {
	private String rno;
	private String pno;
	private String wno;
	private java.sql.Date hosdate;
	private java.sql.Date dischargedate;
	
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public java.sql.Date getHosdate() {
		return hosdate;
	}
	public void setHosdate(java.sql.Date hosdate) {
		this.hosdate = hosdate;
	}
	public java.sql.Date getDischargedate() {
		return dischargedate;
	}
	public void setDischargedate(java.sql.Date dischargedate) {
		this.dischargedate = dischargedate;
	}
	@Override
	public String toString() {
		return "Record [rno=" + rno + ", pno=" + pno + ", wno=" + wno + ", hosdate=" + hosdate + ", dischargedate="
				+ dischargedate + "]";
	}
	
	
}
