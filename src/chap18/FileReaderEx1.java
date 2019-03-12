package chap18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Reader의 읽기 기능
 * int  read() : 1char의 데이터를 읽어 리턴 
 * int  read(char[] buf)  : buf의 길이만큼 데이터를 읽어서 데이터는 buf 저장. 읽은 문자수를 리턴 
 * int  read(char[] buf,int start,int len)  : 
 *                    buf의 start인덱스 부터 len만큼 데이터를 읽어서 데이터는 buf 저장. 읽은 문자수를 리턴 
 */
public class FileReaderEx1 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/chap18/ReaderEx1.java");
//		int data;
//		while((data=fr.read()) != -1) {
//			System.out.print((char)data);
//		}
		int len;
		char[] buf = new char[1024];
//		while((len = fr.read(buf)) != -1) {
//			System.out.print(new String(buf,0,len));
//		}
		while((len = fr.read(buf,0,buf.length)) != -1) {
		    System.out.print(new String(buf,0,len));
	    }
	}
}
