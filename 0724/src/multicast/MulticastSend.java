//ms949

package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {

	public static void main(String[] args) {
		try {
			//보내는 멀티캐스 소켓을 생성
			//포트번호가 없습니다.
			MulticastSocket ms = new MulticastSocket();
			//문자열을 입력받기 위한 스캐너 만들기
			Scanner sc = new Scanner(System.in);
			//닉네임 설정하기
			System.out.print("닉네임 입력: ");
			String nick = sc.nextLine();
			
			String str = nick + "님이 입장하셨습니다.";
			//보내는 패킷 만들기 - 내용, 길이, 받을곳의 주소, 포트 번호
			DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
			//데이터 전송
			ms.send(dp);
			
			
			//계속 메시지 주고받기
			while(true) {
				System.out.print("메시지(종료는 end):");
				String msg = sc.nextLine();
				if(msg.equals("end")) {
					msg = nick + "님이 퇴장하셨습니다.";
					//보내는 패킷 만들기 - 내용, 길이, 받을곳의 주소, 포트 번호
					dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
					//데이터 전송
					ms.send(dp);
					//소켓과 스캐너 닫기
					ms.close();
					sc.close();
					break;
					//if문에 break나 return이 있으면 끝난다는 거니까 else쓰지 않아도 됩니다.
				}else {
					//메시지 만들기
					msg = nick + ":" + msg;
					//보내는 패킷 만들기 - 내용, 길이, 받을곳의 주소, 포트 번호
					dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("230.100.50.5"), 9999);
					//데이터 전송
					ms.send(dp);
				}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
