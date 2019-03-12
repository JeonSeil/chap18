package chap18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * ���ϸ��� �Է¹޾Ƽ� �ش� �����ϸ�  �Էµ� ���ϸ��� Ȯ���ڸ� .bak ������ ������Ϸ� �Ͽ� 
 * �Էµ� ������ ������ .bak ���Ͽ� �����ϱ�
 * 
 * ���������̸��� �Է��ϼ���
 * aaa.txt
 * 
 * aaa.bak ������ ����.

 * aaa.bak ������ ����
 * �ȳ��ϼ���
 * �ݰ����ϴ�.
 */
public class Exam2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� �̸��� �Է��ϼ���.");
		String input = scan.nextLine();
		try {
			FileInputStream fis = new FileInputStream(input);
			int len =0;
			int idx = input.lastIndexOf(".");
			String newfile = input.substring(0,idx)+".bak";
			FileOutputStream fos = new FileOutputStream(newfile);
			byte buf[] = new byte[fis.available()];
			while((len=fis.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
