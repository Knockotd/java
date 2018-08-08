package mail_test;

import org.apache.commons.mail.SimpleEmail;

public class MailSend {

	public static void main(String[] args) {
		try {
			//텍스트 메일을 보낼 수 있는 클래스의 객체 만들기
			SimpleEmail email = new SimpleEmail();
			
			//서버 설정
			email.setAuthentication("knock_otd999", "!tosemdnl0893");
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			//메일 보안 설정 옵션 : 메일이 암호화 되서 전송됨
			email.setTLS(true);
			email.setSSL(true);
			email.setFrom("knock_otd999@naver.com", "관리자");
			email.setCharset("utf-8");
			
			//받는 설정
			email.addTo("anjeundeun@gmail.com");
			email.setSubject("메일 보내기 연습");
			email.setMsg("정말로 메일이 갈까?");
			
			//보내기
			email.send();
			System.out.println("메일 보내기 성공");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
