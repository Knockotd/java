package dbconnec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class My3 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			ps = con.prepareStatement("select deptno, dname, loc from dept");
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("jdeptno", rs.getInt("deptno"));
				map.put("jdname", rs.getString("dname"));
				map.put("jloc", rs.getString("loc"));
				
				list.add(map);
			}
			
			System.out.printf("부서번호");
			
			
		}catch(Exception e){}
		
	}

}
