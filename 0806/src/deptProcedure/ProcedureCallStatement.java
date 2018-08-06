package deptProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureCallStatement {

	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			//데이터베이스 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			/*
			//실행할 Statement 객체 만들기
			cs = con.prepareCall("{call insertDeptProc(?,?,?)}");
			//물음표에 실제 값 바인딩
			cs.setInt(1, 13);
			cs.setString(2, "비서");
			cs.setString(3, "충남");
			
			//삽입 구문 실행
			int r = cs.executeUpdate();
			if(r > 0) {
				System.out.println("삽입 쉉공 ㅅㅁㅅ");
			}else {
				System.out.println("삽입 쉴패 ㅠ_ㅠ");
			}
			*/
			
			//실행할 Statement 객체 만들기
			cs = con.prepareCall("{call deletDeptProc(?)}");
			//물음표에 실제 값 바인딩
			cs.setInt(1, 13);
			//삽입 구문 실행
			int r = cs.executeUpdate();
			if(r > 0) {
				System.out.println("삭제 쉉공!");
			}else {
				System.out.println("삭제 쉴패 ㅠㅠ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();//오류구문을 역추적해주는 코드
		}finally {
				try {
					if(con != null)
						con.close();
					if(cs != null)
						cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}
