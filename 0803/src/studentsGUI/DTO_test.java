package studentsGUI;
import java.sql.Date;

public class DTO_test {
	private int num;
	private String name;
	private String part;
	private String phone;
	private String emergency;
	private Date birthday;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	@Override
	public String toString() {
		return "test_DTO [num=" + num + ", name=" + name + ", part=" + part + ", phone=" + phone + ", emergency="
				+ emergency + ", birthday=" + birthday + "]";
	}
}
