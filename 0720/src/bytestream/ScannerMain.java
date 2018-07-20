//MS949
package bytestream;

import java.io.BufferedReader;
import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		//키보드로부터 입력받는 Scanner 인스턴스 만들기
		Scanner sc = new Scanner(System.in);
		System.out.print("정수");
		int x = sc.nextInt();
		System.out.println(x);
		
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println(name);
		
		// 이렇게 쓸 경우, 두번째의 이름은 입력이 아예 안 된다.
		// 이름과 정수 입력 순서를 바꾸면 정상 동작한다.
		// nextLine():Enter까지 입력
		// next():Enter,Tab,공백까지 입력
		// nextInt():Enter전까지 입력 & Enter는 남아있는 상태.
		//-> 굳이 nextInt()으로 받고 싶으면 sc.nextLine()을 2번 쓰면(c언어는 fflush()를 써서 해결한다. 자바는 키보드 입력을 핸들링할 수 없기 때문에. c언어는 핸들링 가능하니까) 숫자 썼을 때의 엔터를 입력받고하고 다시 입력을 받을 수 있다.
		//-> 권장은 스트링으로 받아서 인트로 형변환.
		
		// BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); //System.in=키보드로부터 받음.
		// String ? = r.readLine(); //readLine():한 줄 읽기 이기 때문에 위와 같은 문제가 일어날 일이 없다. 엔터까지 받아온다는 소리니까.
		
		
		sc.close();
	}

}
