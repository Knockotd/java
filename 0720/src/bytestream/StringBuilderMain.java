//ms949
package bytestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringBuilderMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 아까는 InputStream을씀.
			br = new BufferedReader(new FileReader("C:\\Users\\503-26\\Desktop\\정리.txt"));
			// 줄 단위로 데이터를 이어붙일 StringBuilder생성
			StringBuilder sb = new StringBuilder();
			while (true) {
				// 한 줄을 읽기
				String line = br.readLine();
				// 읽은 데이터가 없으면 종료
				if (line == null)
					break;
				sb.append(line);
			}

			// 읽은 내용을 String에 저장하기
			String content = sb.toString();
			// 메모리 정리를 위해서.
			sb = null;
			System.out.println(content);
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
