//MS949
package bytestream;

import java.io.BufferedReader;
import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		//Ű����κ��� �Է¹޴� Scanner �ν��Ͻ� �����
		Scanner sc = new Scanner(System.in);
		System.out.print("����");
		int x = sc.nextInt();
		System.out.println(x);
		
		System.out.println("�̸�:");
		String name = sc.nextLine();
		System.out.println(name);
		
		// �̷��� �� ���, �ι�°�� �̸��� �Է��� �ƿ� �� �ȴ�.
		// �̸��� ���� �Է� ������ �ٲٸ� ���� �����Ѵ�.
		// nextLine():Enter���� �Է�
		// next():Enter,Tab,������� �Է�
		// nextInt():Enter������ �Է� & Enter�� �����ִ� ����.
		//-> ���� nextInt()���� �ް� ������ sc.nextLine()�� 2�� ����(c���� fflush()�� �Ἥ �ذ��Ѵ�. �ڹٴ� Ű���� �Է��� �ڵ鸵�� �� ���� ������. c���� �ڵ鸵 �����ϴϱ�) ���� ���� ���� ���͸� �Է¹ް��ϰ� �ٽ� �Է��� ���� �� �ִ�.
		//-> ������ ��Ʈ������ �޾Ƽ� ��Ʈ�� ����ȯ.
		
		// BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); //System.in=Ű����κ��� ����.
		// String ? = r.readLine(); //readLine():�� �� �б� �̱� ������ ���� ���� ������ �Ͼ ���� ����. ���ͱ��� �޾ƿ´ٴ� �Ҹ��ϱ�.
		
		
		sc.close();
	}

}
