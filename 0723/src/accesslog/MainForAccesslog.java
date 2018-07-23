package accesslog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainForAccesslog {

	public static void main(String[] args) {
		//로그파일을 읽어서 아이피 별 접속횟수 출력하기
		//<--작업 순서도-->
		//1. 로그 파일을 읽을 수 있는 스트림을 생성한다.
		//->로그 파일은 문자열이 기록된 파일이므로 CharacterStream을 이용해야 합니다.
		//->읽을 대는 네이티브 메소드 호출횟수를 줄이기 위해서 버퍼를 사용해서 읽고 쓰는 것이 좋습니다.
		//->BufferedReader를 이용해서 읽는 것이 좋습니다.
		
		//줄단위로 읽어 올 수 있는 메소드가 있는 BufferedReader
		BufferedReader bfr = null;
		
				try {
					bfr = new BufferedReader(new FileReader("C:\\Users\\503-26\\Desktop\\access_log.txt"));
					ArrayList dataLine = new ArrayList();
					HashMap<String, Integer> map = new HashMap<>(); 
					//5.HashMap을 이용해서 접속할 아이피 별 트래픽 합계 출력
					HashMap<String, Integer> traffic = new HashMap<>();
					while(true) {
						String oneLine = bfr.readLine();
						if(oneLine == null) break;
						//공백 단위로 저장
						String [] ar = oneLine.split(" ");
						//ip 출력
						//System.out.println(ar[0]);
						//4.아이피로 저장된 데이터를 가져오기
						Integer count = map.get(ar[0]);
						System.out.println(count);
						//저장된 데이터가 없으면 1을 저장하기
						if(count == null) {
							map.put(ar[0],1);
						}else {
							map.put(ar[0],count+1);
						}
						//이쪽이 잘 못 됨.
						Integer traf = traffic.get(ar[0]);
						System.out.println(traf);
						if(traf == null) {
							if(!ar[0].equals("-") && ar[0].equals("\"-\"")) {
								traffic.put(ar[0], Integer.parseInt(ar[9]));
							}
						}else {
							if(!ar[0].equals("-") && ar[0].equals("\"-\"")) {
								traffic.put(ar[0],traf+Integer.parseInt(ar[9]));
							}
						}
						//맵의 모든 데이터 출력
						Set<String> keyset = map.keySet();
						for(String key : keyset) {
							System.out.println(key);
						}
						
						Set<String> trafset = traffic.keySet();
						for(String trafsum : trafset) {
							System.out.println(trafsum);
						}
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}finally {
						try {
							if(bfr != null)
							bfr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
	}

}
