package dbconnec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class My2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			ps = con.prepareStatement("select * from dept");
			rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.print(rs.getInt("deptno")+":");
				System.out.print(rs.getString("dname")+":");
				System.out.print(rs.getString("loc")+"\n");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
			if(con != null) con.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
			}catch(Exception e) {}
		}
	}

}
