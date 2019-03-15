package test0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * EchoServerEx2.java Thread를 Runnble방식으로 변경하기
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			System.out.println("클라이언트 접속 대기 중");
			Socket client = server.accept();
			new Thread(new EchoServerRunnable(client)).start();
		}
	}

	static class EchoServerRunnable implements Runnable {
		Socket client;
		PrintWriter out;
		BufferedReader in;

		EchoServerRunnable(Socket client) {
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
