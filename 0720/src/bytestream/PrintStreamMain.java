package bytestream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			//기록하고 싶은 파일을 만들기
			ps = new PrintStream(new FileOutputStream("C:\\Users\\503-26\\Desktop\\data.txt",true));
			ps.println("순풍산부인과 완전 재밌다!!");
			ps.println("특히 미달이의 방학숙제 편이 정말 재밌다.");
			ps.println("노래자랑 편은 오늘 집에 가서 볼 것이다.");
			
			ps.flush();
			
		} catch (Exception e) {
			System.out.println("파일 쓰기에서 예외 발생:" + e.getMessage());
		} finally {
			if(ps != null)
			ps.close(); //경고만 생기지만 null일 수도 있어서 생기는 것이다.
		}
	}

}
