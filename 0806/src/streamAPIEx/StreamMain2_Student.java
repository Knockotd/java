package streamAPIEx;

public class StreamMain2_Student {

	public static void main(String[] args) {
		StudentVOclass student = new StudentVOclass();
		student.setName("안정은");
		student.setGender("여자");
		student.setAge(26);
		student.setScore(100);
		student.setSubject("식품영양학과");
		
		StudentVOclass student1 = new StudentVOclass("안정은","여자",100,26,"식품영양학과");
		
		System.out.println(student);
		System.out.println(student1);
	}

}
