package studentSemple;

import java.util.Scanner;

public class ClassAfter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("10번 외치고 싶은 말을 써주세요: ");
		String msg = sc.nextLine(); 
		int n = 10;
		T.f1(msg,n);
		
		T p = new T();
		n = p.sum(n);
		System.out.println("외친 횟수만큼의 팩토리얼을 더해서 출력합니다.");
		System.out.println(n);
		
	}

}
