package test0313;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2.
 �ֿܼ��� ���ϸ�� ���ڸ� �Է¹޾Ƽ� �ش� ������ �Էµ� ���ڸ�ŭ��
 ����ϴ� ���α׷� �ۼ��ϱ�. Scanner ��� �Ұ�
 [���]
 ����� ���ϸ� �Է�
  src/chap18/InputStreamEx1.java
 ����� ���μ� �Է�
 1

[���]
1 :package chap18; */
public class Test2 {
	public static void main(String[] args) throws IOException {
		System.out.println("����� ���ϸ� �Է�");
		BufferedReader stdin = new BufferedReader
				          (new InputStreamReader(System.in));
		String filename = stdin.readLine();
		System.out.println("����� ���μ� �Է� ");
		int line = Integer.parseInt(stdin.readLine());
		BufferedReader fbr = new BufferedReader(new FileReader(filename));
		String msg = null; //������ ���� ������ ����
		int prt = 0;       //��¶���.
		while((msg = fbr.readLine()) != null) {
			if(line <= prt) break;
			prt++;
			System.out.println(prt + ":" + msg);
		}		
	}
}