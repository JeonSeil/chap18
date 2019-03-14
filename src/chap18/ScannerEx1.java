package chap18;

import java.util.Scanner;

/*
 * Scanner 예제
 *   String 을  입력받아 사용하기
 */
public class ScannerEx1 {
	public static void main(String[] args) {
		String str = "Java and   Jsp and  Spring and HTML and JavaScript";
		Scanner scan = new Scanner(str);
		//  \\s* : 정규식. \\s* : 공백 0개 이상.
		scan.useDelimiter("\\s*and\\s*"); //문자열 분리
		while(scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
