
package bytestream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			
			fr = new FileReader("C:\\Users\\503-26\\Desktop\\정리2.txt");
			
			
			char [] buf = new char[10];
			//배열을 반복문 밖에 만들고 반복문을 돌릴 때 남는 공간이 생길 수 있습니다.(배열 공간이 안 남으면 상관없지만.)
			//배열을 어떻게든 출력하려고 하다보니 겹쳐져서 이상하게 출력되는 것입니다.
			//해결방법 : 배열을 반복문 안에 만들면 남는 공간이 반복문을 빠져나가면서 사라집니다.
			//해결방법2 : 출력할 때 범위를 정해서 출력하면 남는 공간은 애써 출력하려고 하지 않으니 이상한 현상이 사라집니다.
			
			while(true) {
			//buf의 크기만큼 읽어서 buf에 저장하고
				//읽은 개수를 r에 저장
				int r = fr.read(buf);
			System.out.println(buf);
			
			//
			/*for(char ch : buf) {
				System.out.println(ch);
			}*/
			
				if(r <= 0) break;
				//배열에서 0번째 부터 r만큼 만
				//문자열로 변환해서 출력
				//System.out.println(new String(buf, 0, r));
			}
			
		} catch (Exception e) {
			System.out.println("파일리더 오류 발생:"+e.getMessage());
		} finally {
			try {
				//아무것도 없는데 close로 닫으면 오류발생할 수 있다.
				if (fr != null) 
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
