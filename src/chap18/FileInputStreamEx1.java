package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * InputStream �����͸� �б� ���
 * int  read()            : 1byte �� �о ����
 * int  read(byte[] buf)  : buf�� ���̸�ŭ �����͸� �о �����ʹ� buf ����. ���� ����Ʈ���� ���� 
 * int  read(byte[] buf,int start,int len)  : 
 *                     buf�� start�ε��� ���� len��ŭ �����͸� �о �����ʹ� buf ����. ���� ����Ʈ���� ���� 
 */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap18/InputStreamEx1.java");
//		int data = 0;
//		while((data = fis.read()) != -1) {
//			System.out.print((char)data);
//		}
		//fis.available() : �б� ���� ����Ʈ ����
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
