package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress Ŭ���� : IP �ּҸ� �����ϴ� Ŭ����
 *  1. �������� ���������� default => �����ڴ� ��ü ���� �Ұ�.
 *  2. static �޼��� ����
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("getByName() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress ip = InetAddress.getByName("www.daum.net");
		System.out.println("hostname:" + ip.getHostName());
		System.out.println("ip address:" + ip.getHostAddress());
		//byte ������ ��ȸ�ϱ�
		byte[] ipAddr = ip.getAddress();
		for(byte b : ipAddr) {
			System.out.print(((b<0)?b+256:b) + ".");
		}
		System.out.println();
		
		System.out.println("getAllByName() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress ips[] = InetAddress.getAllByName("www.daum.net");
		for(InetAddress i : ips) {
			System.out.println("IP :" + i);
		}

		System.out.println
		   ("�ڽ��� ��ǻ�� �ּ�:getLocalHost() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("�� ��ǻ�� IP :" + local);

		System.out.println("getByAddress() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress ip2 = InetAddress.getByAddress(ip.getAddress());
		System.out.println(ip2);
	}
}
