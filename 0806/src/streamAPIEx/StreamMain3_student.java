package streamAPIEx;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain3_student {

	public static void main(String[] args) {
		//Student 클래스의 인스턴스의 배열
		StudentVOclass [] ar = new StudentVOclass[5];
		// = [null, null, null, null, null] -> 주소를 넣을 수 있는 공간이 생김. 하나씩 집어 넣어야 함.
		//ar[0].getAge(); NullPointException
		
		ar[0] = new StudentVOclass("안정은", "여자", 100, 26, "식품영양학과");
		ar[1] = new StudentVOclass("안예은", "여자", 98, 27, "유아교육과");
		ar[2] = new StudentVOclass("안춘길", "남자", 89, 25, "시각디자인과");
		ar[3] = new StudentVOclass("안춘승", "남자", 87, 28, "한국음악과");
		ar[4] = new StudentVOclass("안은철", "남자", 97, 27, "토목건축학과");
		
		//성별이 남자인 데이터만 출력
		Stream<StudentVOclass> stream = Arrays.stream(ar);
		stream.filter(student -> student.getGender().equals("남자")).forEach(student -> System.out.println(student));
		
		System.out.println("\n==================\n");
		
		//성별이 여자이고 나이가 27이상인 데이터
		Stream<StudentVOclass> stream1 = Arrays.stream(ar);
		stream1.filter(student1 -> student1.getGender().equals("여자") && student1.getAge() >=27).forEach(student1 -> System.out.println(student1));
		
		System.out.println("\n==================\n");
		
		//student를 score로 변경
		Stream<StudentVOclass> stream2 = Arrays.stream(ar);
		stream2.mapToInt(StudentVOclass::getScore).forEach(student -> System.out.println(student));
		
		System.out.println("\n==================\n");
		
		int [] array = {30, 20, 31, 78, 12};
		
		IntStream stream3 = Arrays.stream(array);
		stream3.sorted().forEach(su -> System.out.println(su));
		
		System.out.println("\n==================\n");
		
		//문자열 배열을 정렬해서 출력
		String [] stringArray = {"hello","good morning","nice day","hi","have a niceday"};
		Stream<String> stream4 = Arrays.stream(stringArray);
		//오름차순
		stream4.sorted().forEach(hi ->System.out.println(hi));
		System.out.println("\n==================\n");
		//내림차순
		Stream<String> stream5 = Arrays.stream(stringArray);
		stream5.sorted((n1, n2)->n2.compareTo(n1)).forEach(hi->System.out.println(hi));
		System.out.println("\n==================\n");
		
		//위의 ar 배열 오름차순
		Stream<StudentVOclass> stream6 = Arrays.stream(ar);
		stream6.sorted((n1, n2)->n1.getAge()-n2.getAge()).forEach(hi->System.out.println(hi));
		System.out.println("\n==================\n");
		Stream<StudentVOclass> stream7 = Arrays.stream(ar);
		stream7.sorted((n1, n2)->n1.getName().compareTo(n2.getName())).forEach(hi->System.out.println(hi));

		
	}

}
