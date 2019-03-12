package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * InputStream 데이터를 읽기 기능
 * int  read()            : 1byte 를 읽어서 리턴
 * int  read(byte[] buf)  : buf의 길이만큼 데이터를 읽어서 데이터는 buf 저장. 읽은 바이트수를 리턴 
 * int  read(byte[] buf,int start,int len)  : 
 *                     buf의 start인덱스 부터 len만큼 데이터를 읽어서 데이터는 buf 저장. 읽은 바이트수를 리턴 
 */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap18/InputStreamEx1.java");
//		int data = 0;
//		while((data = fis.read()) != -1) {
//			System.out.print((char)data);
//		}
		//fis.available() : 읽기 가능 바이트 리턴
		int len = 0;
		byte[] buf = new byte[fis.available()];
//		while((len=fis.read(buf)) != -1) {
//			System.out.print(new String(buf,0,len));
//		}
		while((len=fis.read(buf,0,buf.length)) != -1) {
		    System.out.print(new String(buf,0,len));
	    }
	}
}
