package bytestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LogReaderMain {

	public static void main(String[] args) {
		BufferedReader brr = null;
		try {
			brr = new BufferedReader(new FileReader("C:\\Users\\503-26\\Desktop\\access_log.txt"));
			// 접속한 아이피를 중복 상관없이 저장하기 위한 자료구조
			ArrayList<String> iplist = new ArrayList<>();// 중복상관없이 저장
			Set<String> s = new HashSet<String>();
			while (true) {
				String line = brr.readLine();
				// System.out.println(line);
				// 읽은 데이터 없으면 종료
				if (line == null)
					break;
				// 공백으로 분할
				String[] ar = line.split(" ");
				s.add(ar[0]);
				iplist.add(ar[0]);
				// System.out.println(iplist);
			}
			/*
			 * for(String imsi : iplist) { System.out.println(imsi); }
			 */
			for (String temp : s) {
				System.out.println(temp);
			}
			System.out.println(iplist);
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		} finally {
			try {
				if (brr != null)
					brr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
