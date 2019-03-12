package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 파일명을 입력받고,내용을 입력받아 입력받은 파일에 입력된 내용 저장하기.
 * exit 가 입력되면 내용 입력 종료하기
 * 
 * [결과]
 * 파일명을 입력하세요 
 * aaa.txt
 * 저장할 내용을 입력하세요
 * 안녕하세요
 * 반갑습니다.
 * exit
 * 
 * aaa.txt 파일의 내용
 * 안녕하세요
 * 반갑습니다.
 */
public class Exam1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String filename = scan.nextLine();
		System.out.println("저장할 내용을 입력하세요");
		//FileOutputStream 클래스 이용 방법
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
		//FileWriter 클래스 이용 방법
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
