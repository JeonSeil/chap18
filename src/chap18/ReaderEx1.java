package chap18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/*
 *  new  InputStreamReader(InputStream )
 *  
 *  InputStreamReader�� Reader�� ���� Ŭ������.
 */
public class ReaderEx1 {
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		int data=0;
		while((data=in.read()) != -1) {  //2byte�� �б�
			System.out.print((char)data);
		}
	}
}
