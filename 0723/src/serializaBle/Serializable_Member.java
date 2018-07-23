package serializaBle;

import java.io.Serializable;

public class Serializable_Member implements Serializable{
	
	//이 클래스 내부에서만 사용할 private 변수's
	private String name;
	private transient String pw;
	private String phone;
	
	//입출력을 위한 getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//결과 출력을 위한 toString
	@Override
	public String toString() {
		return "Serializable_Member [name=" + name + ", pw=" + pw + ", phone=" + phone + "]";
	}
	
	
	
}
