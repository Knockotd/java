package dbconnec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatasaveDTO {

	public static void main(String[] args) {
		// 데이터베이스에서 데이터 읽기를 위한 변수
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 읽어온 데이터 저장을 위한 자료구조 행<열>
		ArrayList<Dtoclass> list = new ArrayList<>();
		try {
			// 1. 데이터베이스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 접속
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// 3. sql 실행 객체 생성
			ps = con.prepareStatement("select * from dept");
			// 4. ?가 없다면, select 하는 sql 실행을 위한 객체 생성
			rs = ps.executeQuery();
			// 5. 행단위로 전체 데이터 읽기
			while (rs.next()) {
				//하나의 행을 저장할 DTO 클래스 객체 생성
				Dtoclass dto = new Dtoclass();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				// 읽은 하나의 행을 리스트에 저장
				list.add(dto);
			}
			System.out.printf("%-10s", "부서번호");
			System.out.printf("%-20s", "부서이름");
			System.out.printf("%-30s", "부서위치");
			System.out.println();

			for (Dtoclass dto : list) {
				System.out.printf("%-10s", dto.getDeptno());
				System.out.printf("%-20s", dto.getDname());
				System.out.printf("%-30s", dto.getLoc());
				System.out.println();
			}

		} catch (Exception e) {
			// 예외 내용을 출력
			System.out.println(e.getMessage());
			// 예외 내용을 추적
			e.printStackTrace();
		} finally {
			// 사용을 다한 경우 닫기
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}
	}

}
