package opensource;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParsing {

	public static void main(String[] args) {
	//!--다운로드 받을 문자열을 저장할 변수
		Thread th = new Thread() {
			public void run() {
	//!--스레드로 수행할 내용 *웹이 나오면 무조건 try catch가 있다고 봐야 함.
				try {
	String json = URLConnectionOutline_JSONParsingClass.URLCOL();
	//!--JSON 문자열 파싱
					JSONObject main = new JSONObject(json);
					//System.out.println(main);
	//!--channel 키의 데이터를 JSONObject 타입으로 가져오기
					JSONObject channel = main.getJSONObject("channel");
					//System.out.println(channel);
	//!--channel 에서 item 키의 값을 배열로 가져오기
					JSONArray item = channel.getJSONArray("item");
					//System.out.println(item);
	//!--item 배열을 순회
					int i = 0;
					while(i<item.length()) {
						
						
						
						JSONObject book = item.getJSONObject(i);
						System.out.println(book);
						String author = book.getString("author");
						System.out.println(author);
						String category = book.getString("category");
						System.out.println(category);
						i = i + 1;
						
						
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
		};
		th.start();
	}

}
