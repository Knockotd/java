package urlclass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLFileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//다운로드 받을 주소만들기
			String addr = "http://img.khan.co.kr/lady/201602/20160229170513_1_qhrja1.jpg";
			//addr 에서 마지막 // 이후의 문자열을 가져오기
			//1. 마지막 /의 위치 찾기
			int idx = addr.lastIndexOf('/');
			//2. addr에서 idx+1번째 글자부터 가져오기
			String filename = addr.substring(idx+1);
			//System.out.println(filename);
			
			//filename을 이용해서 저장할 파일 경로 만들기
			String filepath = "./" + filename; //"경로"를 입력하는 것이다.
			//파일이 존재하는지 확인
			if((new File(filename)).exists()) {
				System.out.println("이미 파일이 존재합니다.");
			}else {
				//System.out.println("파일이 존재하지 않습니다.");
				//다운로드는 스레드로 생성
				//스레드 객체 생성
				Thread th = new Thread() {
					public void run() {
						try {
						//addr(주소)로 다운로드 받을 url만들기
						URL url = new URL(addr);
						//연결 객체 생성
						HttpURLConnection con = (HttpURLConnection)url.openConnection();
						//옵션설정
						con.setConnectTimeout(20000);//너무 느릴 때
						con.setUseCaches(false);
						//바이트 단위로 다운로드 받기 위한 스트림 생성
						BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
						//다운로드 받은 내용을 기록할 스트림
						PrintStream ps = new PrintStream(filepath);
						while(true) {
							//1024 바이트 단위로 데이터 읽기
							byte [] b = new byte[1024];
							int r = bis.read(b);
							//읽은 데이터가 없으면 읽기 중단
							if(r <= 0) {
								break;
							}
							//읽은 데이터를 ps를 이용해서 기록
							ps.write(b, 0, r);
						}
						//전부 기록했으면 정리
						ps.close();
						bis.close();
						con.disconnect();
						
						}catch(Exception e) {
							System.out.println(e.getLocalizedMessage());
						}
					}
				};
				//스레드 시작
				th.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
