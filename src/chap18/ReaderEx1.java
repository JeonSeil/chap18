package chap18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/*
 *  new  InputStreamReader(InputStream )
 *  
 *  InputStreamReader는 Reader의 하위 클래스임.
 */
public class ReaderEx1 {
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		int data=0;
		while((data=in.read()) != -1) {  //2byte씩 읽기
			System.out.print((char)data);
		}
	}
}
