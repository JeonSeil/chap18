package chap18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Exam2.java를 FileReader,FileWriter클래스를 이용하여 구현하기.  
 */
public class Exam3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("원본 파일 이름을 입력하세요.");
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
			System.out.println("복사할 파일이 존재 하지 않습니다. 다시 입력해 주세요.");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
