package streamAPIEx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("떡볶이");
		list.add("카레덮밥");
		list.add("평양냉면");
		list.add("버섯전골");
		list.add("떡볶이");
		list.add("매운갈비찜");
		list.add("갈비탕");
		list.add("알탕");
		list.add("삼겹살");
		list.add("곱창");
		list.add("삼겹살");
		list.add("라멘");
		list.add("평양냉면");
		list.add("소고기 타다키");
		list.add("고로케");
		list.add("갈비탕");
		list.add("라볶이");
		list.add("라면");
		//ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		
		//스트림 변환
		Stream<String> stream = list.stream();
		//모든데이터를 출력
		//stream.forEach(food -> {System.out.println(food);});
		//중복을 제거
		//stream.distinct().skip(2).limit(3).forEach(food -> {System.out.println(food);});
	
		
		//라로 시작하는 데이터만 찾아서 출력
		//return 문장 하나 밖에 없을 때는 return 이라는 단어를 생략가능
		//수행되는 코드가 한 줄 일 때는 {} 생략 가능
		//stream.filter(food ->food.startsWith("라")).forEach(food ->System.out.println(food));
		stream.filter(food ->food.length() == 3).distinct().forEach(food ->System.out.println(food));
	}

}
