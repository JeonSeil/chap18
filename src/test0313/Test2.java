package test0313;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2.
 콘솔에서 파일명과 숫자를 입력받아서 해당 파일을 입력된 숫자만큼만
 출력하는 프로그램 작성하기. Scanner 사용 불가
 [결과]
 출력할 파일명 입력
  src/chap18/InputStreamEx1.java
 출력할 라인수 입력
 1

[결과]
1 :package chap18; */
public class Test2 {
	public static void main(String[] args) throws IOException {
		System.out.println("출력할 파일명 입력");
		BufferedReader stdin = new BufferedReader
				          (new InputStreamReader(System.in));
		String filename = stdin.readLine();
		System.out.println("출력할 라인수 입력 ");
		int line = Integer.parseInt(stdin.readLine());
		BufferedReader fbr = new BufferedReader(new FileReader(filename));
		String msg = null; //파일의 내용 한줄을 저장
		int prt = 0;       //출력라인.
		while((msg = fbr.readLine()) != null) {
			if(line <= prt) break;
			prt++;
			System.out.println(prt + ":" + msg);
		}		
	}
}