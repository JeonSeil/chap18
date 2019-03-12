package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * ȭ�鿡�� ���ϸ��� �Է¹ް�,������ �Է¹޾� �Է¹��� ���Ͽ� �Էµ� ���� �����ϱ�.
 * exit �� �ԷµǸ� ���� �Է� �����ϱ�
 * 
 * [���]
 * ���ϸ��� �Է��ϼ��� 
 * aaa.txt
 * ������ ������ �Է��ϼ���
 * �ȳ��ϼ���
 * �ݰ����ϴ�.
 * exit
 * 
 * aaa.txt ������ ����
 * �ȳ��ϼ���
 * �ݰ����ϴ�.
 */
public class Exam1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��ϼ���");
		String filename = scan.nextLine();
		System.out.println("������ ������ �Է��ϼ���");
		//FileOutputStream Ŭ���� �̿� ���
/*		
		FileOutputStream fos = new FileOutputStream(filename);
		while(true) {
			String data = scan.nextLine(); 
			if(data.equals("exit")) {
				break;
			}
			byte[] buf = (data+"\n").getBytes();
			fos.write(buf);
		}
		fos.flush();
		fos.close();
*/		
		//FileWriter Ŭ���� �̿� ���
		FileWriter fw = new FileWriter(filename);
		while(true) {
			String data = scan.nextLine();
			if(data.equals("exit")) break;
			fw.write(data+"\n");
		}
		fw.flush();
		fw.close();
	}
}
