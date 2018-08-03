package studentsGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_testImpl implements DAO_test {
	
	//모든 메소드에서 공통으로 사용할 변수
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//데이터베이스 연결을 수행해주는 메소드
	private void connect() {
	try{
	//데이터베이스 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//데이터베이스 연결
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	}catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
	}
	
	//데이터베이스 자원을 해제해주는 메소드
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
			}catch(Exception e) {}
	}
	
	
	//가장 큰 num을 찾아오는 메소드
	private int getMaxnum() {
		//여기서만 사용하는 것이니 private로 설정
		//sql: select max(num) from students
		int result = 0; //무의미한 값 처음에 넣기(초기화)
		try {
			//데이터베이스 연결하는 메소드
			connect();
			//가장 큰 글번호를 찾아오는 SQL 실행 객체 만들기
			ps = con.prepareStatement("select max(num) from students");
			//sql 실행
			rs = ps.executeQuery();
			//결과 읽기
			while(rs.next()) {
				//select 절의 첫번째 컬럼의 값을 정수로 읽어서 result에 저장
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

	@Override
	//데이터를 삽입하는 메소드
	public boolean insertTest(DTO_test dto) {
		
		boolean result = false;
		
		try {
			//가장 큰 번호 찾아오는 SQL을 실행
			int maxNum = getMaxnum();
			//데이터베이스 연결 메소드
			connect();
			
			//SQL 실행 객체 만들기
			ps = con.prepareStatement("insert into students(num, name, part, phone, emergency, birthday) values(?,?,?,?,?,?)");
			
			//물음표에 값을 바인딩
			//가장 큰 번호 + 1로 설정 -- maxNum 변수를 따로 만든 이유는
			//getMaxnum() 메소드 안에 close();메소드가 있어서 connet()가 강제로 닫혀버리므로
			//변수에 결과를 저장해서 가져온다.
			//묶기 전에는 지역변수라서 getMaxnum()에 영향이 오지 않았지만 con, ps, rs를 전역변수로 묶으면서
			//connet()와 close()의 con, ps, rs가 같은 변수가 되었기 때문에 영향이 온다.
			ps.setInt(1, maxNum + 1);
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPart());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEmergency());
			ps.setDate(6, dto.getBirthday());
			
			//select를 제외한 구문은 executeupdate로 실행
			//실행 결과를 영향받은 행의 개수를 정수로 리턴.
			int r = ps.executeUpdate();
			if(r == 1) {
				result = true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
				close();
		}
		return result;
	}

	@Override
	public boolean updateTest(DTO_test dto) {
		boolean result = false;
		/**/
		
		connect();
		
		try {
			//SQL 생성
			ps = con.prepareStatement(
				//코드가 너무 길어질 때에는
				//작업 단위로 ""로 나누어서 +로 묶어주어도 됩니다.
				//예약어는 띄어쓰기로 구분되므로 마지막을 제외한 ""의 각 끝에
				//띄어쓰기를 꼭 붙여야 합니다.
				"update students "
				+"set name=?, part=?, phone=?, emergency=?, birthday=? "
				+"where num = ?");
			
			//물음표에 실제 데이터를 바인딩
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPart());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getEmergency());
			ps.setDate(5, dto.getBirthday());
			ps.setInt(6, dto.getNum());
			
			//SQL을 실행
			int r = ps.executeUpdate();
			
			//결과를 사용 -- 한번 수정하면  1개의 행이 바뀌므로. r>0로도 많이 씀.
			if(r == 1) { // if(r > 0){
				result = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			//데이터베이스 연결 해제
			close();
		}
		
		/**/
		return result;
	}

	@Override
	public boolean deleteTest(int num) {
		boolean result = false;
		/**/
		
		connect();
		try {
			//SQL 명령어
			ps = con.prepareStatement(
					"delete from students "
					+"where num=?");
			
			//? 바인딩
			//매개변수에 들어 와야 사용이 가능합니다.
			//이 메소드의 매개변수는 int num 이므로 dto.getNum()은 안됩니다.
			ps.setInt(1, num);
			//명령어 실행
			int r = ps.executeUpdate();
			if(r > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		
		/**/
		return result;
	}

	@Override
	public List<DTO_test> allreadTest() {
		//읽어온 데이터를 저장하기 위한 리스트 생성
		List<DTO_test> list = new ArrayList<DTO_test>();
		connect();
		try {
		//students 테이블에 있는 전체 데이터를 가져오는 SQL 실행 객체를 생성합니다.
			ps = con.prepareStatement("select num, name, part, phone, emergency, birthday from students");
			
			//select 구문 실행
			rs = ps.executeQuery();
			//반복문을 이용해서 데이터를 읽어서 List에 저장
			
			while(rs.next()) {
				//하나의 행을 읽어서 DTO에 저장
				//반복문을 빠져나가면 연결이 끊기고 새로운 객체가 생성됨.
				DTO_test dto = new DTO_test();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPart(rs.getString("part"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmergency(rs.getString("emergency"));
				dto.setBirthday(rs.getDate("birthday"));
				//읽은 데이터를 리스트에 저장
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		close();
		
		return list;
	}
//name 컬럼에 매개변수로 주어진 데이터가 포함된 데이터를 조회
	@Override
	public List<DTO_test> readTest(String name) {
		List<DTO_test> list = new ArrayList<DTO_test>();
		connect();
		try {
			//students 테이블의 name 컬럼에 name의 값이 포함된 데이터를 조회하는 SQL만들기
			
		ps = con.prepareStatement("select * from students where upper(name) like ?");
		//물음표에 데이터 바이딩 하기
		ps.setString(1, "%" + name + "%");
		//SQL 실행하기
		rs = ps.executeQuery();
		//데이터를 읽어서 list에 저장하기
		while(rs.next()) {
			
			DTO_test dto = new DTO_test();
			
			dto.setNum(rs.getInt("num"));
			dto.setName(rs.getString("name"));
			dto.setPart(rs.getString("part"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmergency(rs.getString("emergency"));
			dto.setBirthday(rs.getDate("birthday"));
			
			list.add(dto);
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		close();
		return list;
	}

}
