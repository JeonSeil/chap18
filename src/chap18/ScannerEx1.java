package chap18;

import java.util.Scanner;

/*
 * Scanner ����
 *   String ��  �Է¹޾� ����ϱ�
 */
public class ScannerEx1 {
	public static void main(String[] args) {
		String str = "Java and   Jsp and  Spring and HTML and JavaScript";
		Scanner scan = new Scanner(str);
		//  \\s* : ���Խ�. \\s* : ���� 0�� �̻�.
		scan.useDelimiter("\\s*and\\s*"); //���ڿ� �и�
		while(scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
