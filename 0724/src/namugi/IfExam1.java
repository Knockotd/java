package namugi;

import java.util.Scanner;

public class IfExam1 {

	public static void main(String[] args) {
		// int sender = 1;
		// sender가 1이면 남자, 2이면 여자, 나머지는 중성
		// switch로 해결
		int sender = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("1~3 사이의 수를 입력해주세요 :");
				sender = Integer.parseInt(sc.nextLine());
				if (sender < 1 || sender > 3) {
					System.out.println("1~3 사이의 수가 아닙니다. 다시 입력해주세요.");
					continue;
				} else {
					int x = 0;
					switch (sender) {
					case 1:
						x = 1;
						System.out.println("남자");
						break;
					case 2:
						x = 1;
						System.out.println("여자");
						break;
					case 3:
						x = 1;
						System.out.println("중성");
						break;
					}
					if (x == 1) {
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
