package studentSemple;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParellelMain {

	//!--1초 대기하는 메소드
	public static void yam(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		int [] ar = {144, 877, 256, 784, 667, 100, 345, 286, 380, 223};
		
		//!--일반 스트림으로 yam 작업을 수행
		IntStream stream = Arrays.stream(ar);
		long start = System.currentTimeMillis();
				stream.forEach(work-> yam(work));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		//!--병렬 스트림으로 yam 작업을 수행
		stream = Arrays.stream(ar);
		start = System.currentTimeMillis();
				stream.parallel().forEach(work-> yam(work));
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}

}
