package bytestream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("./character.txt");
			fw.write("운동을 합시다.");
			fw.write("스피닝을 빼먹지 않고 갑니다.\n");
			fw.write("학원이 늦게 끝나도 갈 수 있다면 꼭 갑니다.");
			//남은 버퍼 출력
			fw.flush();
			
		} catch (Exception e) {
			System.out.println("파일롸이터 오류 발생:"+e.getMessage());
		} finally {
			try {
				//아무것도 없는데 close로 닫으면 오류발생할 수 있다.
				if (fw != null) 
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
