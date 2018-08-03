package studentsGUI;
import java.util.List;

public interface DAO_test {
	//데이터를 삽입하는 메소드 - 모든 데이터를 주어야 합니다.
	public boolean insertTest (DTO_test dto);
	
	//수정하는 메소드
	public boolean updateTest (DTO_test dto);
	
	//데이터를 삭제하는 메소드 - primary key만 주고 삭제하면 됩니다.
	public boolean deleteTest (int num);
	
	//데이터 전체를 읽어오는 메소드 - 데이터 전체를 부를 때는 데이터가 0개 이상이므로 List로 리턴하고, 읽어올 컬럼들을 저장할 DTO클래스나 Map으로 제너릭을 적용하면 됩니다.
	public List<DTO_test> allreadTest ();

	//이름을 가지고 조회하는 메소드 - 번호로 검색할 때는 중복 값이 없어서 List를 지운다?
	public List<DTO_test> readTest (String name);
}
