//ms949
package bytestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringBuilderMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// �Ʊ�� InputStream����.
			br = new BufferedReader(new FileReader("C:\\Users\\503-26\\Desktop\\����.txt"));
			// �� ������ �����͸� �̾���� StringBuilder����
			StringBuilder sb = new StringBuilder();
			while (true) {
				// �� ���� �б�
				String line = br.readLine();
				// ���� �����Ͱ� ������ ����
				if (line == null)
					break;
				sb.append(line);
			}

			// ���� ������ String�� �����ϱ�
			String content = sb.toString();
			// �޸� ������ ���ؼ�.
			sb = null;
			System.out.println(content);
		} catch (Exception e) {
			System.out.println("����: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
