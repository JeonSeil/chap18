package chap18;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
 * File 클래스의 주요 메서드 예제
 */
public class FileEx2 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("c:/temp1");
		//f1.getAbsolutePath()  : 파일의 절대 경로
		//f1.mkdir() : 폴더 생성. 성공:true, 실패:false
		System.out.printf("%s 폴더 생성 :%b\n",f1.getAbsolutePath(),f1.mkdir());
		File f2 = new File("c:/temp1/test.txt");
		//f2.createNewFile() : 파일 생성. 
		System.out.printf("%s 파일 생성 :%b\n",f2.getAbsolutePath(),f2.createNewFile());
		//f2.getName() : 파일 이름 리턴
		//f2.length() : 파일의 크기 리턴
		System.out.printf("파일 이름:%s, 파일크기:%,d byte\n",f2.getName(),f2.length());
		
		File f3 = new File("c:/temp1/test2.txt");
		//f2.renameTo(f3) :  f2(test.txt)파일을 f3(test2.txt)파일로 이름 변경
		System.out.printf("%s->%s 이름변경:%b\n",f2.getName(),f3.getName(),f2.renameTo(f3));
		//long f3.lastModified() : 1970년 이후부터 최종 파일 수정까지의 시간을 밀리초로 리턴
		System.out.printf("%s 파일 최종 수정 일시:%s\n",
				             f3.getName(),new Date(f3.lastModified()));
		System.out.printf("%s 파일 삭제:%b\n", f3.getName(),f3.delete());
		
		
	}
}
