package bytestream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedInputStream bis = null;
		try {
			// 사진 파일 읽는 것. bis = new BufferedInputStream(new FileInputStream("C:\\Users\\503-26\\Downloads\\1.jpg"));
			bis = new BufferedInputStream(new FileInputStream("./anjeundeun.txt"));
			//사진을 숫자로 읽고, 문자로 읽는 것은 우리가 알아볼 수 없는 문자와 숫자들이 나옵니다.
			//하지만 텍스트 파일 같은 것을 읽을 때는 숫자와 문자로 이루어져있고 변환도 가능하므로 우리가 알아들 수 있는 문자와 숫자로 보여지는 것이 맞습니다.
			while(true) {
				byte [] b = new byte[1024];
				int r = bis.read(b);
				/*for(byte temp : b) {
					System.out.println(temp);
				}*/
				System.out.println(new String(b));
				if(r<=0) {break;} //다 읽어 들이겠다는 뜻이다. 0보다 작거나 같으면 값이 없는거니가 반복문을 빠져나감.
			}
		} catch (Exception e) {
			System.out.println("예외 발생:" + e.getMessage());
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
