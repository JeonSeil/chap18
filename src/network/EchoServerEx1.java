package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���� ���� ���α׷�
 */
public class EchoServerEx1 {
	public static void main(String[] args) throws IOException {
        //8000�� ��Ʈ binding �ϰ� ��� ����.
		//binding : OS�κ��� ��Ʈ�� �Ҵ� �޴±��.
		ServerSocket server = new ServerSocket(8000);
		System.out.println("Ŭ���̾�Ʈ ���� ��� ��");
		//Ŭ���̾�Ʈ ���� �����
		//client : Ŭ���̾�Ʈ�� ������ Socket ��ü
		Socket client = server.accept();
		System.out.println("server ip :" +  client.getLocalAddress());
		System.out.println("server port :" +  client.getLocalPort());
		System.out.println("client ip :" +  client.getInetAddress());
		System.out.println("client port :" +  client.getPort());
		//out : client.getOutputStream() : Ŭ���̾�Ʈ�� �����͸� ���� ��ü
		//in : client.getInputStream() : Ŭ���̾�Ʈ�� ���� �����͸� ���� ��ü 
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		BufferedReader in = new BufferedReader
				        (new InputStreamReader(client.getInputStream()));
		String input;
		while((input=in.readLine()) != null) {
			System.out.println("client msg:" + input);
			out.println(input);
			out.flush();
		}
		in.close(); out.close(); client.close(); server.close();
	}
}
