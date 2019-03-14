package chap18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

/* 문제 :
 * src/chap18 폴더의 .java 파일 중 InputStream 관련 모든 소스를 
 * InputStream예제.txt 파일로 생성하기
 * 
 * InputStream 관련 모든 소스 : XXXInputStreamXXX.java
 * 
 * 1. f1 =File("src/chap18") 설정
 * 2. f1의 하위 폴더,파일를 받아서, 그 중 파일이면서, 파일의 이름에 InputStream 값이 존재하면
 *    FileInputStream 으로 설정.
 * 3. FileInputStream Vector에 저장 => SequenceInputStream 객체로 연결하기.
 * 4. SequenceInputStream 읽어서 "InputStream예제.txt" 파일로 생성하기
 */
public class Exam4 {
	public static void main(String[] args) throws IOException {
		Vector<InputStream> v = new Vector<InputStream>();
		String filepath = "src/chap18";
		File f1 = new File(filepath);
		String[] list = f1.list(); //하위 폴더, 파일의 이름을 배열로 리턴
		for(String f : list) {
			File f2 = new File(filepath,f);
			if(f2.isFile() && f.contains("InputStream") &&f.contains(".java")){
			   v.add(new FileInputStream(f2));
			}
		}
		SequenceInputStream st = new SequenceInputStream(v.elements());
		FileOutputStream fos = new FileOutputStream("InputStream예제.txt");
		int len;
		byte[] buf = new byte[1024];
		while((len=st.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
	}
}