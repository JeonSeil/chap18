package chap18;

import java.io.IOException;
import java.io.InputStream;
/*
 * IO��Ʈ�� : �������̵����. �ܹ����̴�. ����(���۰� ����) 
 * 
 *    �Է�  ����Ʈ : 1byte���� read()           InputStream
 *        ����    : 2byte(1 char)���� read()   Reader
 *    ��� ����Ʈ :  1byte���� write()          OutputStream > PrintStream
 *        ����   : 2byte(1 char)���� write()   Writer
 *        
 *    InputStream�� Reader ��ü�� ��ȯ : InputStreamReader
 *    OutputStream�� Writer ��ü�� ��ȯ : OutputStreamWriter    
 *    
 *   �ڹٰ� �������ִ� ǥ������� ��ü 
 *    ǥ���Է°�ü : InputStream System.in
 *    ǥ����°�ü : PrintStream System.out
 *    ǥ�ؿ�����ü : PrintStream System.err
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
