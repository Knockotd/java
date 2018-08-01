import java.util.Scanner;

public class Datefor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("년도:");
		int year = sc.nextInt();
		System.out.println("월:");
		int month = sc.nextInt();
		
		int cnt = 0;
		int i = 1;
		while(i<year) {
			if(i%4==0 && i%100 !=0 || i%400==0) {
				cnt=cnt+366;
			}else {
				cnt=cnt+365;
			}
			i=i+1;
		}
		System.out.println( cnt %7 );
		sc.close();
	}

}
