package file;

import java.io.File;
import java.sql.Date;

public class FileMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\503-26\\eclipse\\jee-photon\\eclipse\\eclipse.exe");
		//파일의 존재여부
		System.out.println("파일 존재 여부: "+f.exists());
		//파일의 크기
		long size = f.length();
		System.out.println("파일의 크기: "+size/1024+"Kb");
		
		//파일의 최후수정시간
		Date date = new Date(f.lastModified());
		System.out.println("마지막 수정 날짜시간: "+date);
		
		File ff = new File("C:\\Users\\503-26\\Downloads\\15.액션토끼 졸귀.jpg");
		String parent = ff.getParent();
		String fileName = ff.getName();
		
		//fileName에서 15.을 제거한 부분을 가져오기
		//.의 위치를 찾아서 . 이후의 문자열 가져오기
		int idx = fileName.indexOf('.');
		//못찾으면 음수를 리턴합니다.
		System.out.println(idx);
		
		//.이 존재 한다면: 위치를 찾는 메소드는 찾고자 하는 데이터가 없으면 음수를 리턴합니다.
		if(idx>=0) {//찾았다라는 뜻
			//문자열을 위치를 가지고 자르는 메소드
			//substring : ()에 해당하는 부분부터 끝까지 잘라서 그 값을 반환.
			//(시작,끝) substring의 괄호에 이렇게 넣으면 끝의 위치는 하나 작은 값까지 반환한다.
			fileName = fileName.substring(idx+1);
			//기호를 가지고 자르는 것은 split
		}
		System.out.println(fileName);
		
		
		
		File fff = new File("C:\\\\Users\\\\503-26\\\\Downloads\\\\15.액션토끼 졸귀.jpg");
		String fffName = fff.getName();
		//존재 여부
		boolean fffbeing = fff.exists();
		
		//크기
		double fffsize = fff.length();
		
		//수정날짜
		long fffdate = fff.lastModified();
		
		System.out.println("파일 존재여부: " + fffbeing + ", 파일 이름: " + fffName + ", 파일 크기: " + fffsize + ", 파일 수정 날짜: "+ fffdate);
		
		fffsize = (fffsize/1024.0/1024.0)*1000;
		float fffSize = (int) (fffsize*0.001);  
		
		Date fffDate = new Date(fffdate);
		System.out.println("파일 크기: "+fffSize+"Mb"+", 파일 마지막 수정일: "+fffDate);
	}

}
