package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

//예외 정보를 File에 저장하기
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		firstMethod();
	}
	private static void firstMethod() {
		secondMethod();
	}
	//FileOutputStream(파일명,true)
	// 파일명의 파일이 존재 : 원래 파일 수정됨
	//                  기존 파일의 내용을 가지고, 새로운 내용을 추가
	// 파일명의 파일이 없음 : 파일 생성하여 내용을 저장됨
	//  
	private static void secondMethod() {
		try {
			throw new Exception("파일에 예외 메시지 저장하기");
		} catch(Exception e) {
			e.printStackTrace(); //표준오류스트림(System.err) 출력, 화면 출력
			try {
				FileOutputStream fos = new FileOutputStream("err.log",true);
				fos.write(e.getMessage().getBytes());  //fos 파일로 오류메시지 출력하기
				e.printStackTrace(new PrintStream(fos)); //fos 파일로 결과를 출력
				fos.write("\n\n".getBytes());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
