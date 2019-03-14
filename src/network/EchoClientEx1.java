package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 에코 클라이언트 프로그램.
 */
public class EchoClientEx1 {
	public static void main(String[] args) 
			           throws UnknownHostException, IOException {
		//stdin : 키보드 입력 
		BufferedReader stdin = new BufferedReader
				           (new InputStreamReader(System.in));
		//new Socket(IP주소,포트)
		Socket client = new Socket("192.168.0.164",8000);
		//Socket으로 부터 IO스트림 객체를 할당
		//in : client.getInputStream() => 입력스트림
		//     서버의 데이터를 입력받는 객체
		//out : client.getOutputStream() => 출력스트림
		//     서버로 데이터를 출력하는 객체
		BufferedReader in = new BufferedReader
				        (new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		
		System.out.println("local ip:" + client.getLocalAddress());
		System.out.println("local port:" + client.getLocalPort());
		System.out.println("server ip:" + client.getInetAddress());
		System.out.println("server port:" + client.getPort());
		System.out.println("메세지를 입력하세요");
		String input;
		while((input = stdin.readLine()) != null) {
			if(input.equals("bye")) break;
			//키보드에서 입력된 내용을 서버로 전송
			out.println(input);
			out.flush();
			//in.readLine() : 서버에서 보내준 내용을 수신
			System.out.println("server echo:" + in.readLine());
			System.out.println("메세지를 입력하세요");
		}
		out.close(); in.close(); 
		stdin.close(); client.close();
	}
}
