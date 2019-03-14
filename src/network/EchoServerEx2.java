package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 멀티 ECHO 서버 구현하기
 * 하나의 서버가 여러개의 클라이언트와 통신하기.
 */
public class EchoServerEx2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			System.out.println("클라이언트 접속 대기 중");
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
