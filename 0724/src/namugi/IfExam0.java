package namugi;

import java.util.Scanner;

public class IfExam0 {

	public static void main(String[] args) {
		//int su = 정수
		//su가 짝수이면 짝수 아니면 홀수
		//int score = 정수
		//90이상이면 수, 80이상이면 우, 70이상이면 미, 60이상이면 양, 그 이외는 가
		int su = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수인 아무 수를 적어주세요: ");
		try{
			su = Integer.parseInt(sc.nextLine());
		}catch(Exception e){
				System.out.println(e.getMessage());
			}
		if(su % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
		System.out.println("점수를 적어주세요: ");
		int score = Integer.parseInt(sc.nextLine());
		sc.close();
		
		if(score >=90 && score < 100) {
			System.out.println("수");
		}else if(score >= 80 && score < 90) {
			System.out.println("우");
		}else if(score >=70 && score < 80) {
			System.out.println("미");
		}else if(score >=60 && score < 70) {
			System.out.println("양");
		}else {
			System.out.println("미");
		}
		
	}

}
