package opensource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HPasing {

	public static void main(String[] args) {
		// !--다운로드 받을 문자열을 저장할 변수
		Thread th = new Thread() {
			public void run() {
				// !--스레드로 수행할 내용 *웹이 나오면 무조건 try catch가 있다고 봐야 함.
				try {
					// !--다운로드 받을 URL을 생성
					URL url = new URL(
							"https://www.youtube.com/");
					// !--URL 연결 객체 생성
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					// !--옵션 설정
					// 캐시설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부를 설정
					con.setUseCaches(false);
					// 얼마동안 접속을 시도해 볼 것인지를 설정(이건 꼭 만들어야 한다 안그럼 무한대기를 할 수도 있다)
					con.setConnectTimeout(30000);
					// !--문자열을 읽기 위한 스트림 생성
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					// !--줄 단위로 데이터를 읽어서 sb에 추가
					// 다운로드 받는 문자열을 중간 저장할 인스턴스를 생성
					//String에 바로 추가하면 메모리 낭비가 발생합니다.
					//String은 자기 자신에게 추가할 수 없기 때문에
					//기존 내용을 복사해서 추가하기 때문에
					StringBuilder sb = new StringBuilder();
					while (true) {
						//한줄을 읽기
						String line = br.readLine();
						//읽은 게 없으면 종료
						if (line == null) {
							break;
						}
						sb.append(line + "\n");
					}
					// !--sb 내용을 json에 대입
					//다 읽은 데이터는 String으로 변환
					String html = sb.toString();
					//데이터 청소
					sb = null;

					System.out.println(html);
					
					/////////////////////////////////////
					//HTML 루트를 찾아줍니다.
					Document doc = Jsoup.parse(html);
					//태그 전체를 가져옵니다.
					Elements elements = doc.getElementsByTag("span");
					
					//Elements elements = doc.getElementsByClass("style-scope ytd-shelf-renderer");
					int i = 0;
					while(i<elements.size()) {
						//데이터 1개 가져오기
						Element element = elements.get(i);
						//태그 안의 내용 출력하기
						System.out.println(element.text());
						i=i+1;
					}
					
					/*Element element = doc.getElementById("title");
					System.out.println(element.text());
					*/
					
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			}
		};
		th.start();

	}

}
