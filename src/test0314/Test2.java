package test0314;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
      SimpleWebServerEx1.java의 스레드를 Runnable 구현 방식으로 수정하기
 */
public class Test2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		while(true) {
			System.out.println("클라이언트 접속 대기");
			Socket client = server.accept();
			HttpRunnable ht = new HttpRunnable(client);
			new Thread(ht).start();
		}
	}
	static class HttpRunnable implements Runnable{
		private Socket client;
		BufferedReader br;
		PrintWriter pw;
		HttpRunnable(Socket client) {
			this.client = client;
			try {
				br = new BufferedReader
						(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			} catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("server ip :" + client.getLocalAddress());
			System.out.println("server port :" + client.getLocalPort());
			System.out.println("client ip :" + client.getInetAddress());
			System.out.println("client port :" + client.getPort());
		}
		public void run() {
			BufferedReader fbr = null;
			try {
				//line : 브라우저가 전송한 데이터
				//line = "GET / HTTP/1.1"
				//        GET /index.html HTTP/1.1
				String line = br.readLine();
				System.out.println("Http Header :" + line);
				int start = line.indexOf("/") + 1;
				int end = line.lastIndexOf("HTTP") -1;
				String filename = line.substring(start,end);
				if(filename.equals(""))	filename = "index.html";
				
				fbr = new BufferedReader(new FileReader(filename));
				String fline = null;
				while((fline = fbr.readLine()) != null) {
					pw.println(fline);
					pw.flush();
				}
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(fbr != null) fbr.close();
					if(br != null) br.close();
					if(pw != null) pw.close();
					if(client != null) client.close();
				}catch(IOException e) {}
			}
		}
	}
}
