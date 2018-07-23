package bytestream;

public class NameAgeHigth {

	private String name;
	private int age;
	private double hight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "NameAgeHigth [name=" + name + ", age=" + age + ", hight=" + hight + "]";
	}

}
