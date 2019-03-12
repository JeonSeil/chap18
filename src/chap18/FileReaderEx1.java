package chap18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Reader�� �б� ���
 * int  read() : 1char�� �����͸� �о� ���� 
 * int  read(char[] buf)  : buf�� ���̸�ŭ �����͸� �о �����ʹ� buf ����. ���� ���ڼ��� ���� 
 * int  read(char[] buf,int start,int len)  : 
 *                    buf�� start�ε��� ���� len��ŭ �����͸� �о �����ʹ� buf ����. ���� ���ڼ��� ���� 
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
