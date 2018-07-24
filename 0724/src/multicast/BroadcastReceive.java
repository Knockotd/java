package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastReceive {

	public static void main(String[] args) {
		try {
			//�����͸� ���۹ް� �ٶ��� ������ �� �־�� �ϰ� �޴� ���� ��Ʈ��ȣ���� �� �־�� �մϴ�.
			//UDP�� TCP���� ���̰� ���� ���Դϴ�.
			//�̹����� UDP�� �̿��մϴ�.
			DatagramSocket ds = new DatagramSocket(7777);
			System.out.println("���� ��� ��...");
			
			//�޽����� ��� �ް� �ʹٸ�.
			while(true) {
				//�޽����� ������ �迭�� ����
				byte [] b =new byte[512]; //ũ��� �ƹ����Գ� ���ص� ������ �� ¦������ �մϴ�.
				//�޽����� ������ DatagramPacket ����
				DatagramPacket dp = new DatagramPacket(b, 512);
				//������ �ޱ�
				ds.receive(dp);
				//������ �б�
				String msg = new String(b); //dp.getdata
				//512����Ʈ�� �ȵ� �� ������ �����ϱ� ���ؼ� trim()�� ȣ��
				System.out.println(msg.trim());
				
				
				
				
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
