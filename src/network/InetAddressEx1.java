package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress 클래스 : IP 주소를 관리하는 클래스
 *  1. 생성자의 접근제어자 default => 개발자는 객체 생성 불가.
 *  2. static 메서드 제공
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("getByName() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress ip = InetAddress.getByName("www.daum.net");
		System.out.println("hostname:" + ip.getHostName());
		System.out.println("ip address:" + ip.getHostAddress());
		//byte 형으로 조회하기
		byte[] ipAddr = ip.getAddress();
		for(byte b : ipAddr) {
			System.out.print(((b<0)?b+256:b) + ".");
		}
		System.out.println();
		
		System.out.println("getAllByName() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress ips[] = InetAddress.getAllByName("www.daum.net");
		for(InetAddress i : ips) {
			System.out.println("IP :" + i);
		}

		System.out.println
		   ("자신의 컴퓨터 주소:getLocalHost() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터 IP :" + local);

		System.out.println("getByAddress() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress ip2 = InetAddress.getByAddress(ip.getAddress());
		System.out.println(ip2);
	}
}
