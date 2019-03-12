package chap18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Exam2.java�� FileReader,FileWriterŬ������ �̿��Ͽ� �����ϱ�.  
 */
public class Exam3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� �̸��� �Է��ϼ���.");
		String input = scan.nextLine();
		try {
			FileReader fr = new FileReader(input);
			int len =0;
			int idx = input.lastIndexOf(".");
			String newfile = input.substring(0,idx)+".bak";
			FileWriter fw = new FileWriter(newfile);
			char buf[] = new char[1024];
			while((len=fr.read(buf))!=-1) {
				fw.write(buf,0,len);
			}
			fw.flush();
		} catch(FileNotFoundException e) {
			System.out.println("������ ������ ���� ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
