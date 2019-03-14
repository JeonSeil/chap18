package test0312;

import java.io.File;

/*
C:\Windows 폴더의 정보를 출력하기

[결과]
   하위 폴더 갯수 : 89 
   하위 파일 갯수 : 45 
   하위 파일의 총 크기 : 15,638,717 byte */
public class Test2 {
	public static void main(String[] args) {
		String filepath = "C:/Windows";
		File f1 = new File(filepath);
		String[] list = f1.list(); //하위 폴더, 파일의 이름을 배열로 리턴
		int dcnt=0,fcnt=0,sum=0;
		for(String f : list) {
			File f2 = new File(filepath,f);
			if(f2.isDirectory()) dcnt++;
			else {
				sum += f2.length();
				fcnt++;
			}
		}
		System.out.println("하위 폴더 갯수 : " + dcnt);
		System.out.println("하위 파일 갯수 : " + fcnt);
		System.out.println("하위 파일의 총 크기 : " + String.format("%,d", sum) +"byte");
	}
}
