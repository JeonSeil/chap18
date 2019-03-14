package test0312;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * 파일명을 입력받아서 해당 존재하면  입력된 파일명의 확장자를 .line 파일을 출력파일로 
 * 입력된 파일의 내용을 .line 파일에 복사하기. 단 복사할때 라인수를 추가하기.
 * 
 * 원본파일이름을 입력하세요
 * aaa.txt
 * 
 * aaa.line 파일이 생성.

 * aaa.line 파일의 내용
 * 1:안녕하세요
 * 2:반갑습니다.
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("원본 파일 이름을 입력하세요.");
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
			System.out.println("복사할 파일이 존재 하지 않습니다. 다시 입력해 주세요.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
