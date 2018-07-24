package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastReceive {

	public static void main(String[] args) {
		try {
			//데이터를 전송받고 줄때는 소켓이 꼭 있어야 하고 받는 쪽은 포트번호까지 꼭 있어야 합니다.
			//UDP냐 TCP냐의 차이가 있을 뿐입니다.
			//이번에는 UDP를 이용합니다.
			DatagramSocket ds = new DatagramSocket(7777);
			System.out.println("서버 대기 중...");
			
			//메시지를 계속 받고 싶다면.
			while(true) {
				//메시지를 저장할 배열을 생성
				byte [] b =new byte[512]; //크기는 아무렇게나 정해도 되지만 꼭 짝수여야 합니다.
				//메시지를 저장할 DatagramPacket 생성
				DatagramPacket dp = new DatagramPacket(b, 512);
				//데이터 받기
				ds.receive(dp);
				//데이터 읽기
				String msg = new String(b); //dp.getdata
				//512바이트가 안될 때 공백을 제거하기 위해서 trim()을 호출
				System.out.println(msg.trim());
				
				
				
				
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
