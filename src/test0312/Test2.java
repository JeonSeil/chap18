package test0312;

import java.io.File;

/*
C:\Windows ������ ������ ����ϱ�

[���]
   ���� ���� ���� : 89 
   ���� ���� ���� : 45 
   ���� ������ �� ũ�� : 15,638,717 byte */
public class Test2 {
	public static void main(String[] args) {
		String filepath = "C:/Windows";
		File f1 = new File(filepath);
		String[] list = f1.list(); //���� ����, ������ �̸��� �迭�� ����
		int dcnt=0,fcnt=0,sum=0;
		for(String f : list) {
			File f2 = new File(filepath,f);
			if(f2.isDirectory()) dcnt++;
			else {
				sum += f2.length();
				fcnt++;
			}
		}
		System.out.println("���� ���� ���� : " + dcnt);
		System.out.println("���� ���� ���� : " + fcnt);
		System.out.println("���� ������ �� ũ�� : " + String.format("%,d", sum) +"byte");
	}
}
