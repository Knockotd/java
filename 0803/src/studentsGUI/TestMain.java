package studentsGUI;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		//인터페이스나 클래스를 상속한 경우에는
		//상위 인터페이스나 클래스 이름으로 변수를 만들고
		//하위 클래스의 인스턴스를 생성해서 대입합니다.
		//그래서 자료형과 뒤의 생성자 이름이 다를 수 있습니다.
		DAO_test dao = new DAO_testImpl();
		DTO_test dto = new DTO_test();
		
		
		
		
		//dto.setNum(11);
		/*dto.setName("유승호");
		//dto.setPart("");
		dto.setPhone("01034345656");
		dto.setEmergency("01033334444");
		//현재 시간을 저장한 캘린더 생성
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1993);
		cal.set(Calendar.MONTH, 7); //하나적은 달
		cal.set(Calendar.DAY_OF_MONTH, 17);
		Date birthDay = new Date(cal.getTimeInMillis());
		dto.setBirthday(birthDay);*/
		
		
		/*//데이터를 삽입하는 메소드 호출
		boolean result = dao.insertTest(dto);
		if(result == true) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}*/
		
		
		/*//데이터를 수정하는 메소드 호출
		 * boolean r = dao.updateTest(dto);
		if(r == true) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
			System.out.println("예외를 확인");
		}*/
		
		/*//데이터를 삭제하는 메소드 호출
		 * boolean r = dao.deleteTest(dto.getNum());
		if(r == true) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
				System.out.println("예외를 확인");
			}*/
		List<DTO_test> list0 = dao.allreadTest();
		/*//모든 데이터를 조회하는 구문
		for(DTO_test dto1 : list0) {
			System.out.println(dto1);
			}*/
		
		
		
		//name에 name 이 들어간 데이터 조회하는 구문
		String name;
		name = "이";
		List<DTO_test> list1 = dao.readTest(name);
		
		for(DTO_test dto1 : list1) {
			System.out.println(dto1);
			}
		
	}

}
