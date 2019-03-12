package chap18;

import java.io.IOException;
import java.io.InputStream;
/*
 * IO스트림 : 데이터이동통로. 단방향이다. 지연(버퍼가 존재) 
 * 
 *    입력  바이트 : 1byte단위 read()           InputStream
 *        문자    : 2byte(1 char)단위 read()   Reader
 *    출력 바이트 :  1byte단위 write()          OutputStream > PrintStream
 *        문자   : 2byte(1 char)단위 write()   Writer
 *        
 *    InputStream을 Reader 객체로 변환 : InputStreamReader
 *    OutputStream을 Writer 객체로 변환 : OutputStreamWriter    
 *    
 *   자바가 제공해주는 표준입출력 객체 
 *    표준입력객체 : InputStream System.in
 *    표준출력객체 : PrintStream System.out
 *    표준오류객체 : PrintStream System.err
 */
public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int data = 0;
		while((data=in.read()) != -1) { //ctrl+z
			System.out.print((char)data);
		}
	}
}
