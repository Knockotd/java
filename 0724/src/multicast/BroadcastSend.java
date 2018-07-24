package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BroadcastSend {

	public static void main(String[] args) {
		try {
			
			//������ �ֵ� ��·�� ������ �ʿ��ϴ�.
			//UDP ������ ���� ���� ����
			DatagramSocket ds = new DatagramSocket();
			//��ĳ�� �̿��ؼ� �г��� �Է�
			Scanner sc = new Scanner(System.in);
			System.out.println("�г��� �Է� : ");
			String nick = sc.nextLine();
			String msg = nick + ("���� ������ �غ� �Ǿ����ϴ�.");
			//�г��� ����
			//������ ���� ������ DatagramPacket
			DatagramPacket dp = new DatagramPacket(
					msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
			ds.send(dp);
			while(true) {
				System.out.println("�޽���: ");
				msg = sc.nextLine();
				msg = nick + ":" + msg;
				//������ ���� ������ DatagramPacket
				dp = new DatagramPacket(
						msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
				ds.send(dp);
			}
		}catch(Exception e) {System.out.println(e.getMessage());}
	}

}
