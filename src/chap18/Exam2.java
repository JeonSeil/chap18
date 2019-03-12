package chap18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 파일명을 입력받아서 해당 존재하면  입력된 파일명의 확장자를 .bak 파일을 출력파일로 하여 
 * 입력된 파일의 내용을 .bak 파일에 복사하기
 * 
 * 원본파일이름을 입력하세요
 * aaa.txt
 * 
 * aaa.bak 파일이 생성.

 * aaa.bak 파일의 내용
 * 안녕하세요
 * 반갑습니다.
 */
public class Exam2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("원본 파일 이름을 입력하세요.");
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
