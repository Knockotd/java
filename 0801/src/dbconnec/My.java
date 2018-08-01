package dbconnec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class My {

	public static void main(String[] args) {
		
		//1. 정수를 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 부서번호(정수): ");
		int deptno = sc.nextInt();
		//System.out.println("부서번호:"+deptno);
		sc.close();
		//2. 입력받은 데이터를 가지고 테이터베이스에 삭제하기
		//필요한 변수 선언
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//드라이ㅓ 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이버베이스연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			//autocommit 해제
			con.setAutoCommit(false);
			
			//SQL 실행객체 생성
			String psline = "delete from dept where deptno = ?";
			//?가 있을 때
			ps = con.prepareStatement(psline);
			ps.setInt(1, deptno);
			//SQL 실행
			// 실행하고 나면 영향받은 행의 개수를 리턴한다.
			//조건에 맞는 데이터가 없으면 실패하는게 아니고 삭제하는 행의 개수가 0읻.
			//실패하면 예외가 발생하므로catch한다.
			int r = ps.executeUpdate();
			if(r>0) {System.out.println("삭제 성공");
			//작업에 성공하면 commit을 호출
			con.commit();
			}else {
			System.out.println("조건에 맞는 데이터가 없습니다.");
			}
		} catch (Exception e) {
			//작업도중 예외가 발생한 경우 rollback을 호출
			try{con.rollback();}catch(Exception e1) {}
			//예외의 내용 출력
			System.out.println(e.getMessage());
			//예외 발생한 지점 역추적
			e.printStackTrace();
		}finally {
		}
		
		
	}

}
