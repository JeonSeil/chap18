package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("out.txt");
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('A');fos.write('B');fos.write('C');
		fos.write('가');fos.write('나');fos.write('다');
		byte[] buf = "\n반갑습니다. 바이트형 출력스트림 예제 입니다.".getBytes();
		fos.write(buf);
		fos.flush();
	}
}
