package studentSemple;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();
		
		
		/*
		System.out.println(list);
		for(StudentVO vo : list) {
	//!--출력하는 메소드에 인스턴스이름을 대입하면 toString의 결과
		System.out.println(vo);
		*/
		
	//!--stream 생성
		Stream<StudentVO> stream = list.stream();
	//!--데이터를 2개 건너띄고 3개 출력
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
	//!--남자인 데이터만 출력
		//stream.filter(data -> data.getGender().equals("남자")).forEach(data -> System.out.println(data));
	
	//!--데이터 정렬하기 - score
	//!--숫자
		//stream.sorted((n1, n2)->n1.getScore() - n2.getScore()).forEach(data->System.out.println(data));
	//!--문자 compareTo()의 괄호 안에 비교하려는 값을 넣기.
		//stream.sorted((n1, n2)->n1.getName().compareTo(n2.getName())).forEach(data->System.out.println(data));
	//!--기본적으로는 오름차순이고, 내림차순으로 바꾸고 싶다면 n1과 n2의 위치만 바꾸면 된다.	
		
	//!--남자 중에 성적 순으로 나열
		//stream.filter(data->data.getGender().equals("남자")).sorted((n1, n2)->n1.getScore()-n2.getScore()).forEach(data->System.out.println(data));
		
	//!--최종 처리 메소드 : 마지막에 써서 결과를 리턴 받음! 중간 중간에 중간 처리 메소드를 넣을 수 있고 끝에는 최종 처리 메소드로 끝내서 결과를 받으면 됨.
		//long cont = stream.filter(data->data.getGender().equals("남자")).count();
		//System.out.println(cont);
		
	//!--Optional로 묶여 있으면 null이 올 수 없다.
		//null일 때 어떻게 반환하거나 어떻게 바꾸어라 하는 것이니까.
		//그래서 nall이 올 수 있도록 Optional 랩핑을 벗기기 위해서
		//get()을 사용한다.
		//아래의 두 경우는 같은 값을 지닌다. get()을 사용하지 않으면 Optional로 묶여서 null을 가질 수 없다.
		//Optional로 리턴되는 데이터는 한 번 더 가공을 해야 합니다.
		/*StudentVO vo = stream.findFirst().get();
		System.out.println(vo);*/
		
		/*Optional<StudentVO> bo = stream.findFirst();
		 System.out.println(bo.get());*/
		
	//!--score의 합계 구하기
		//숫자 데이터가 아니면 바로 합계를 구할 수 없기 때문에
		//map 메소드를 이용해서 숫자 데이터로 변경 후 합계를 구해야 합니다.
		/*int sum = stream.mapToInt(StudentVO::getScore).sum();
		System.out.println(sum);*/
		
	//!--age의 평균 구하기
		/*double age = stream.mapToInt(StudentVO::getAge).average().getAsDouble();
		System.out.println(age);*/
		
	//!--성별이 남자인 데이터의 평균 점수를 구하는데 소수 1째 자리 에서 반올림해서 정수 부분만 출력
		/*double avg = stream.filter(data->data.getGender().equals("남자")).mapToInt(StudentVO::getScore).average().getAsDouble();
		int avgInt = (int)(avg + 0.5);
		System.out.println(avg);
		System.out.println("남자의 평균 점수는 : "+avgInt);*/
		
	//!--성별이 여자인 데이터만 가지고 List를 생성
		/*List<StudentVO> list2 = stream.filter(data->data.getGender().equals("여자")).collect(Collectors.toList());
		for(StudentVO temp : list2) {
			System.out.println(temp);
		}*/
		
	//!--이름과 점수만을 갖는 Map으로 생성
		/*Map<String, Integer> map = stream.collect(Collectors.toMap(StudentVO::getName, StudentVO::getScore));
		System.out.println(map);*/
		/*Map<String, Integer> map = stream.collect(Collectors.toMap(StudentVO::getName, data->data.getScore()));
		System.out.println(map);*/
		
	//!--성별이 남자이고 score가 90이상인 데이터의 list를 생성해서 출력
		/*List <StudentVO> list3 = stream.filter(data->data.getGender().equals("남자") && data.getScore() >= 90).collect(Collectors.toList());
		for(StudentVO comp : list3) {
			System.out.println(comp);
		}*/
	
	//!--groupingBy에 작성한 함수의 결과를 key로 하고
		//원래 데이터의 List를 값으로 해서 Map으로 리턴합니다.
		//아래의 경우 <gender의 자료형, StudentVO의 List>
		/*Map<String, List<StudentVO>> map =
				stream.collect(Collectors.groupingBy(StudentVO::getGender));
		System.out.println(map);*/

		/*Map<String, IntSummaryStatistics> map =
				stream.collect(Collectors.groupingBy(StudentVO::getGender,
						Collectors.summarizingInt(StudentVO::getScore)));
		System.out.println(map);*/
		
	//!--gender 별로 score의 합계를 정수로 출력
		Map<String, Integer> map =
				stream.collect(Collectors.groupingBy(StudentVO::getGender,
						Collectors.summingInt(StudentVO::getScore)));
		System.out.println(map);
		
	//!--Map의 데이터 전부 출력하기
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key+":"+ map.get(key));
		}
	}
	}


