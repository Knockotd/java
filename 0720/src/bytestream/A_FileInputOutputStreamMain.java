package bytestream;

import java.io.*;

public class A_FileInputOutputStreamMain {

	public static void main(String[] args) {
		// try-catch-finally: 는 각각의 블럭 따서 변수선언은 트라이 위에서 하고 파이널에서 닫는다
		// 파일에 바이트 단위로 기록할 수 있는 스트림 변수 생성
		FileOutputStream fos = null;
		try {
			// 예외가 발생할 가능성이 있는 구문

			// 현재 프로젝트 디렉토리에 파일을 생성 ./->현재 디렉토리
			fos = new FileOutputStream("./anjeundeun.txt", true);// true를 쓰면 이어서 쓰는 거고
			// 안 쓰면 항상 처음부터 써지기 때문에 이전에 쓰여있던 내용은 삭제되고 새로운 내용만 기록이 됩니다.
			// 이어서 쓰게 하고 싶으면 true를 써주면 됩니다.

			// 파일에 1바이트 기록
			// fos.write(98);

			// 파일에 바이트 배열을 기록
			// byte [] ar = {97,98,99,100,101};
			// fos.write(ar);

			// 문자열을 바이트 배열로 변환해서 기록
			// getBytes 이용 - 중요!
			String str = "안녕하세용!";
			fos.write(str.getBytes());

			// 버퍼의 내용을 비우기
			fos.flush();

		} catch (Exception e) {

			// 예외가 발생했을 때 수행할 구문

			System.out.println("파일 입출력 예외:" + e.getMessage());
			// 현재 날짜와 시간 그리고 예외 내용을 로깅합니다.
			// 파일에 기록하거나 네트워크를 통해서 서버에 전달합니다.
		} finally {
			// 예외 발생 여부에 상관없이 수행할 구문
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./anjeundeun.txt");
			/*// 1byte 읽어오기
			int r = fis.read();
			System.out.println(r);*/
			
		/*	//4byte 읽어오기
			byte [] b = new byte[4];
			fis.read(b);
			System.out.println(b);*/
			
			//4byte씩 전체 읽어오기
			//read에 바이트 배열을 대입하면 읽은 개수를 리턴.
			//0보다 작거나 같은 값을 리턴하면 읽을 데이터가 없는 것.
			while(true) {
				byte [] b = new byte[1024];
				int r = fis.read(b);
				//배열은 toString이 재정의 되어 있지 않아서 해시코드가 출력.
				//System.out.println(b);
				
				//코드를 각각 출력
				//for(byte imsi : b) {System.out.println(imsi);}
				
				//문자열로 출력
				System.out.println(new String(b));
				
			if(r <=0 ){break;}	
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 예외:" + e.getMessage());
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
