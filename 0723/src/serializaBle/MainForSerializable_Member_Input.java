package serializaBle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class MainForSerializable_Member_Input {

	public static void main(String[] args) {
		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
				ObjectInputStream ois = null;
				try {
					//파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
					ois = new ObjectInputStream(new FileInputStream("./ObjectOutputStream.txt"));
					
					//read로 읽어올 대 object 타입으로 리턴하기 때문에
					//강제 형 변환을 해서 원래의 자료형으로
					//되돌려서 사용해야 합니다.
					Serializable_Member member = (Serializable_Member) ois.readObject();
					System.out.println(member.getPhone());
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(ois != null) {
						ois.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}

}
