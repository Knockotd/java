package dbconnec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Insert {
     public static void main(String[] args) {
         
         //데이터베이스 연결 변수
         Connection con = null;
         //SQL 실행 변수
         PreparedStatement pstmt = null;
         try {
              con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
              //SQL 실행 객체를 생성 sql을 매개변수로 해서 생성
              //pstmt = con.prepareStatement("insert into dept(deptno, dname, loc) values(70,'영업','부산')");
              //pstmt = con.prepareStatement("delete from dept where deptno =70");
              pstmt = con.prepareStatement("update dept set dname = '마케팅' where deptno = 50");
              //SQL을 실행 - select을 제외한 구문 실행
              //r에 저장되는 값은 영향받은 행의 개수
              int r = pstmt.executeUpdate();
              //성공여부를 출력
              if(r > 0) {
                   System.out.println("수정 성공");
              }
              System.out.println("데이터베이스 연결 성공");
         }catch(Exception e) {
              System.out.println(e.getMessage());
              }
     finally {
         try {
              if(pstmt != null) pstmt.close();
              if(con != null) con.close();
         }catch(Exception e){}
     }
}
}