package network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 간단한 웹서버 만들기
 * 이미지 파일도 처리하도록 
 */
public class SimpleWebServer2 {
	public static void main(String[] args) {
		try {
			ServerSocket server =new ServerSocket(8080);
			while(true) {
			   System.out.println("클라이언트 접속 대기");
			   Socket client = server.accept();
			   System.out.println("스레드 생성");
			   HttpThread ht =   new HttpThread(client);
			   ht.start();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static class HttpThread extends Thread {
		private Socket client;
		//br : 클라이언트 메시지 읽기 위한 입력스트림
		BufferedReader br;
		//os : 클라이언트 메시지 출력하기 위한 출력 스트림
		OutputStream os;	
		HttpThread(Socket client) {
			this.client = client;
			try {
				br = new BufferedReader
					(new InputStreamReader
					(client.getInputStream()));
				os = client.getOutputStream();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	public void run() {
		//fbr : 요청파일을 읽기 위한 입력스트림
		FileInputStream fbr = null;
		try {
			String line = br.readLine();
			//line : GET /favicon.ico HTTP/1.1
			System.out.println("Http Header :"+line);
			int start = line.indexOf("/") + 1;
			int end = line.lastIndexOf("HTTP")-1;
			//fileName : 브라우저의 요청 파일
			String fileName=
					     line.substring(start,end);
			if(fileName.equals(""))
				fileName="index.html";
			System.out.println
						("사용자 요청 파일:"+fileName);
			fbr = new FileInputStream(fileName);
			
			int fileLine = 0;
			byte[] buf = new byte[1024]; 
			while((fileLine = fbr.read(buf))!= -1 ){
				os.write(buf,0,fileLine);
				os.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fbr != null) fbr.close();
				if(br != null) br.close();
				if(os != null) os.close();
				
				if(client != null) client.close();
			} catch(IOException e) {}
		}
	}
  }
}
