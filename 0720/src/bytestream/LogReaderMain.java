package bytestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LogReaderMain {

	public static void main(String[] args) {
		BufferedReader brr = null;
		try {
			brr = new BufferedReader(new FileReader("C:\\Users\\503-26\\Desktop\\access_log.txt"));
			//������ �����Ǹ� �ߺ� ������� �����ϱ� ���� �ڷᱸ��
			ArrayList<String> iplist = new ArrayList<>();//�ߺ�������� ����
			Set<String> s = new HashSet<String>();
			while(true) {
				String line = brr.readLine();
				//System.out.println(line);
				//���� ������ ������ ����
				if(line == null) break;
				//�������� ����
				String [] ar = line.split(" ");
				s.add(ar[0]);
						iplist.add(ar[0]);
				//		System.out.println(iplist);
			}
		/*	for(String imsi : iplist) {
				System.out.println(imsi);
			}*/
			for(String temp : s) {
				System.out.println(temp);
			}
			System.out.println(iplist);
		}catch(Exception e) {
		System.out.println("����: " + e.getMessage());	
		}finally {
			try {
				if(brr != null)
				brr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
