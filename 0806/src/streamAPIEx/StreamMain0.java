package streamAPIEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain0 {

	public static void main(String[] args) {
		//문자열 배열을 생성
		String [] ar = {"카드캡터채리","원피스","명탐정코난","천사소녀네티"};
		
		//문자열 리스트를 생성
		List<String> list = new ArrayList<>();
		list.add("나루토");
		list.add("심슨네 가족들");
		list.add("천재소년 지미");
		list.add("스폰지밥");
		
		//문자열 배열을 가지고 스트림 만들기
		Stream<String> stream = Arrays.stream(ar);
		//작업 수행
		stream.forEach(cartoon ->{System.out.println(cartoon);});
		
		//List를 가지고 스트림 만들기
		stream = list.stream();
		stream.forEach(cartoon -> {System.out.println(cartoon);});
	}

}
