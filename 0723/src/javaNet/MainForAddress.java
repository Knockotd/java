package javaNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainForAddress {

	public static void main(String[] args) {
		try {
			
			  //주소 정보 1개 가져오기
			InetAddress addr = InetAddress.getByName("www.google.com");
			  System.out.println(addr);
			  
			 //주소 정보 모두 가져오기
			System.out.println("===============");
			InetAddress ar[] = InetAddress.getAllByName("www.naver.com");
			for (InetAddress imsi : ar) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
