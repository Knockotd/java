package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BroadcastSend {

	public static void main(String[] args) {
		try {
			
			//보내는 애도 어쨌든 소켓이 필요하다.
			//UDP 전송을 위한 소켓 생성
			DatagramSocket ds = new DatagramSocket();
			//스캐너 이용해서 닉네임 입력
			Scanner sc = new Scanner(System.in);
			System.out.println("닉네임 입력 : ");
			String nick = sc.nextLine();
			String msg = nick + ("님이 전송할 준비가 되었습니다.");
			//닉네임 전송
			//전송할 때는 무조건 DatagramPacket
			DatagramPacket dp = new DatagramPacket(
					msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
			ds.send(dp);
			while(true) {
				System.out.println("메시지: ");
				msg = sc.nextLine();
				msg = nick + ":" + msg;
				//전송할 때는 무조건 DatagramPacket
				dp = new DatagramPacket(
						msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
				ds.send(dp);
			}
		}catch(Exception e) {System.out.println(e.getMessage());}
	}

}
