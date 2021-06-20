package vo;

public class Patient {
	private String pno;
	private String pname;
	private int age;
	private String sex;
	
	public Patient() {} 	// DAO���� �⺻ �����ڸ� ����ϹǷ� �������. 
	
	public Patient(String pno, String pname, int age, String sex) {
		this.pno = pno;
		this.pname = pname;
		this.age = age;
		this.sex = sex;
	}
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getName() {
		return pname;
	}
	public void setName(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Patient [pno=" + pno + ", pname=" + pname + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
