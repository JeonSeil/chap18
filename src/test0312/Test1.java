package test0312;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * ���ϸ��� �Է¹޾Ƽ� �ش� �����ϸ�  �Էµ� ���ϸ��� Ȯ���ڸ� .line ������ ������Ϸ� 
 * �Էµ� ������ ������ .line ���Ͽ� �����ϱ�. �� �����Ҷ� ���μ��� �߰��ϱ�.
 * 
 * ���������̸��� �Է��ϼ���
 * aaa.txt
 * 
 * aaa.line ������ ����.

 * aaa.line ������ ����
 * 1:�ȳ��ϼ���
 * 2:�ݰ����ϴ�.
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� �̸��� �Է��ϼ���.");
		String input = scan.nextLine();
		try {
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			int idx = input.lastIndexOf(".");
			String newfile = input.substring(0, idx) + ".line";
			FileWriter fw = new FileWriter(newfile);
			int line=0;
			String data= null;
			while ((data = br.readLine()) != null) {
				fw.write(++line+":"+data + "\n");
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("������ ������ ���� ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
