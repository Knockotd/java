import java.util.Date;

public class DTO {
	private int num;
	private String name;
	private int score;
	private Date bir = null;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	
	
	
	
	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	@Override
	public String toString() {
		
		
		
		return "DTO [num=" + num + ", name=" + name + ", score=" + score + ", bir=" + bir + "]";
	}
}
