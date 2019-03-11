package chap18;

import java.io.File;

/*
 * File 클래스 예제
 *    - 파일 및 폴더의 정보를 관리하는 클래스 
 *       => 파일의 내용은  저장또는 수정, 삭제 불가능. => 입출력 스트림을 사용해야 함
 *    - 존재하지 않아도 관리는 가능함.
 */
public class FileEx1 {
	public static void main(String[] args) {
		String filePath = "c:\\";
		File f1 = new File(filePath);// c:\ 폴더정보
		String files[] = f1.list(); //  c:\ 하위파일,폴더 이름 목록
		for(String f : files) {
			File f2 = new File(filePath,f); //상위폴더,파일(폴더)명
			if(f2.isDirectory()) //디렉토리?
				System.out.printf("%s : 디렉토리\n",f); //f : 폴더 명
			else if(f2.isFile()){ //파일?
				System.out.printf("%s : 파일(%,d 바이트)\n",f,f2.length());
			}
		}
	}
}
