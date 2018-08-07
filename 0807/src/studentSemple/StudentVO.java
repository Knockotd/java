package studentSemple;

public class StudentVO {
	//테이블의 각 컬럼의 값들을 저장하기 위해서 변수 생성
	private String num;
	private String name;
	private String clasS;
	private int score;
	private int age;
	private String gender;
	
	
	//인스턴스 생성을 할 때 데이터를 바로 대입해서 생성하면
	//메소드 호출횟수를 줄일 수 있기 때문에 상위 클래스의 생성자 생성
	public StudentVO() {
		super();
	}
	//인스턴스 변수를 private으로 생성했기 때문에
	//인스턴스가 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
	public StudentVO(String num, String name, String clasS, int score, int age, String gender) {
		super();
		this.num = num;
		this.name = name;
		this.clasS = clasS;
		this.score = score;
		this.age = age;
		this.gender = gender;
	}
	
	//데이터 입력, 출력을 위한 getter, setter
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasS() {
		return clasS;
	}

	public void setClasS(String clasS) {
		this.clasS = clasS;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//데이터를 빠르게 확인하기 위한 toString - 디버깅이라고 한다.
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", clasS=" + clasS + ", score=" + score + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	
}
