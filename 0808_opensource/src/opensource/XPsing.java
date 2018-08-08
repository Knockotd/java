package opensource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPsing {

	public static void main(String[] args) {
		// !--다운로드 받을 문자열을 저장할 변수
		Thread th = new Thread() {
			public void run() {
		// !--스레드로 수행할 내용 *웹이 나오면 무조건 try catch가 있다고 봐야 함.
				try {
		// !--다운로드 받을 URL을 생성
					URL url = new URL(
							"http://www.mfds.go.kr/www/rss/brd.do?brdId=ntc0021");
		// !--URL 연결 객체 생성
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
		// !--옵션 설정
			// 캐시설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부를 설정
					con.setUseCaches(false);
			// 얼마동안 접속을 시도해 볼 것인지를 설정
					con.setConnectTimeout(30000);
		// !--문자열을 읽기 위한 스트림 생성
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		// !--줄 단위로 데이터를 읽어서 sb에 추가
					StringBuilder sb = new StringBuilder();
					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						}
						sb.append(line);
					}
		// !--sb 내용을 xml에 대입
					String xml = sb.toString();
					System.out.println(xml);
					//xml 문자열을 파싱할 수 있는 객체를 생성
					DocumentBuilderFactory factory = 
						DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = 
						factory.newDocumentBuilder();
					//파싱할 문자열을 스트림으로 변환
					InputStream is = 
						new ByteArrayInputStream(xml.getBytes());
					//문자열을 파싱 수행 - org.w3c.dom
					Document doc = builder.parse(is);
					//루트 찾기
					Element root = doc.getDocumentElement();
					System.out.println(root);
					
					//title 태그 전부 찾기
					NodeList list = 
						root.getElementsByTagName("title");
					NodeList list1 = 
							root.getElementsByTagName("content:encoded");
					//System.out.println(list);
					
					int i=0;
					while(i < list.getLength()) {
						//데이터의 개수가 안 맞을 때 출력을 같이 시키면 Nullpoint 예외가 발생할 수 있다.
						//그럴 때는 개수를 세어서 아래와 같이 두번째 데이터가 같이 시작하기 전을 따로 빼어서 코드를 짜고
						//else로 같이 시작하도록 해주면 된다.
						if(i == 0) {
							Node item = list.item(i);
							Node child = item.getFirstChild();
							String title = child.getNodeValue();
							//첫번째 자식을 찾는 이유는 부모는 첫째만 찾기 때문에 첫째가 아닌 형제들을 찾을 수 있는 첫째가 있어야 하기 때문다.
							//그리고 Node에서 getFirstName()을 해서 나오는 값은 자바가 임의로 넣어둔 값이다.
							//쓸 일이 거의 없고 그냥 구분을 위해서 넣어둔 값이다.
							System.out.println("<<<"+title+">>>");
						}
						else {
						Node item = list.item(i);
						Node item1 = list1.item(i-1);
						//첫번째 자식 찾기
						Node child = item.getFirstChild();
						Node child1 = item1.getFirstChild();
						//데이터 찾기
						String title = child.getNodeValue();
						String title1 = child1.getNodeValue();
						System.out.println(title + " : " + title1);
						}
						i = i + 1;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			}
		};
		th.start();
	}

}
