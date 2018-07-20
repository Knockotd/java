package bytestream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NameAgeHigthMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//키보드로부터 줄 단위로 입력을 받을 수 있는 클래스의
//참조형 변수 선언
//finall절에서 close를 할 수 있도록 try 밖에서
//변수를 선언합니다.

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름: ");
			//문자열 한 줄을 입력받음
			String name = br.readLine();
			System.out.print("나이: ");
			String age = br.readLine();
			System.out.print("키: ");
			String higth = br.readLine();
			
			//3개의 데이터를 하나로 저장하기 위한 인스턴스 새성
			
			NameAgeHigth nah = new NameAgeHigth();
			
			nah.setName(name);
			nah.setAge(Integer.parseInt(age));
			nah.setHight(Double.parseDouble(higth));
			
			
			//Map을 이용하여 저장하는 방법.
			Map<String, Object> map = new HashMap<>();
			map.put("이름", name);
			map.put("나이", Integer.parseInt(age));
			map.put("키", Double.parseDouble(higth));
			
			//출력할 때는 VO클래스나 MAP이 별 차이가 없습니ㅏㄷ.
			//toString 정의 했음.
			System.out.println(nah);
			//Map에 toSting이 있음.
			System.out.println(map);
			
			// map은 자동완성이 안 보이기 때문에 데이터 이름 찾기가 힘듭니다.
			//사용할 때는 조금 다릅니다. 예를 들어 나이를 1씩 더한다고 합시다.(아래 아래 코드)
			nah.getAge();
			map.get("age");
			
			//Map에서는 데이터를 가져와서 사용할 때 강제 형변환을 해야 합니다.
			int r = nah.getAge()+1;
			r = (Integer)map.get("age") + 1;
			
		} catch (Exception e) {
			System.out.println("버퍼리더 오류발생: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
