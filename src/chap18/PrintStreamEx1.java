package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * PrintStream 예제 => 보조 스트림.
 *  1. OutputStream의 하위 클래스.
 *  2. write() 메서드의 기능을 향상 시킨 print,println,printf 메서드를 추가함.
 *     모든 자료형을 출력가능
 *     예외처리를 안해도 됨.
 *     
 * 표준출력(System.out),표준오류(System.err) 객체의 자료형.    
 */
class Print {
	int x;
	public String toString() {
		return "x="+x;
	}
}
public class PrintStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("print.txt");
		PrintStream ps = new PrintStream(fos);
		ps.println("홍길동");
		ps.println(1234);
		ps.println(true);
		ps.println('a');
		ps.println(new Print());
		ps.flush();
        //print2.txt 파일에 바로 저장가능. 
		PrintStream ps2 = new PrintStream("print2.txt");
		ps2.println("홍길동");
		ps2.println(1234);
		ps2.println(true);
		ps2.flush();
	}
}
