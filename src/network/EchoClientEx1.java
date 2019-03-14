package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ���� Ŭ���̾�Ʈ ���α׷�.
 */
public class EchoClientEx1 {
	public static void main(String[] args) 
			           throws UnknownHostException, IOException {
		//stdin : Ű���� �Է� 
		BufferedReader stdin = new BufferedReader
				           (new InputStreamReader(System.in));
		//new Socket(IP�ּ�,��Ʈ)
		Socket client = new Socket("192.168.0.164",8000);
		//Socket���� ���� IO��Ʈ�� ��ü�� �Ҵ�
		//in : client.getInputStream() => �Է½�Ʈ��
		//     ������ �����͸� �Է¹޴� ��ü
		//out : client.getOutputStream() => ��½�Ʈ��
		//     ������ �����͸� ����ϴ� ��ü
		BufferedReader in = new BufferedReader
				        (new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		
		System.out.println("local ip:" + client.getLocalAddress());
		System.out.println("local port:" + client.getLocalPort());
		System.out.println("server ip:" + client.getInetAddress());
		System.out.println("server port:" + client.getPort());
		System.out.println("�޼����� �Է��ϼ���");
		String input;
		while((input = stdin.readLine()) != null) {
			if(input.equals("bye")) break;
			//Ű���忡�� �Էµ� ������ ������ ����
			out.println(input);
			out.flush();
			//in.readLine() : �������� ������ ������ ����
			System.out.println("server echo:" + in.readLine());
			System.out.println("�޼����� �Է��ϼ���");
		}
		out.close(); in.close(); 
		stdin.close(); client.close();
	}
}
