import java.sql.Connection;
import java.sql.DriverManager;

public class Data {

	public static void main(String[] args) {
		// 사용하고자 하는 드라이버 클래스를 로드
		// 데이터베이스 종류에 따라 다름
		// 데이터베이스 연결 변수 선언
		// 반드시 close()를 호출해야 하므로 finally에서 close()를 호출
		// finally 에서 호출하려면 밖에서 만들어야 합니다.
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
