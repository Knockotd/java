package serializaBle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainForSerializble_Member_Output {

	public static void main(String[] args) {
		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
		ObjectOutputStream oos = null;
		try {
			//파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			oos = new ObjectOutputStream(new FileOutputStream("./ObjectOutputStream.txt"));
			
			Serializable_Member member = new Serializable_Member();
			member.setName("안정은");
			member.setPw("0000");
			member.setPhone("01052888888");
			
			//객체를 파일에 기록
			oos.writeObject(member);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(oos != null) {
				oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
