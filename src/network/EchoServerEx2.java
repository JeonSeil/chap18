package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��Ƽ ECHO ���� �����ϱ�
 * �ϳ��� ������ �������� Ŭ���̾�Ʈ�� ����ϱ�.
 */
public class EchoServerEx2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			System.out.println("Ŭ���̾�Ʈ ���� ��� ��");
			Socket client = server.accept();
			new EchoServerThread(client).start();
		}
	}

	static class EchoServerThread extends Thread {
		Socket client;
		PrintWriter out;
		BufferedReader in;

		EchoServerThread(Socket client) {
			this.client = client;
			try {
				out = new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("server ip :" + client.getLocalAddress());
			System.out.println("server port :" + client.getLocalPort());
			System.out.println("client ip :" + client.getInetAddress());
			System.out.println("client port :" + client.getPort());
		}

		public void run() {
			String input;
			try {
				while ((input = in.readLine()) != null) {
					System.out.println("client msg:" + input);
					out.println(input);
					out.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
					client.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
