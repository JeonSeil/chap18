package chap18;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 보조스트림 : 다른 스트림을 연결하여 기능을 추가할 수 있는 스트림.
 * BufferedReader : 버퍼를 추가하여 성능을 향상할 수 있는 스트림.
 *  => readLine() 메서드를 이용하여 한줄씩 읽을 수 있는 기능을 포함한다.
 *  new BufferedReader(Reader)
 */
public class BufferedReaderEx1 {
	public static void main(String[] args) throws IOException {
		//키보드에서 한줄씩 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileOutputStream fos = new FileOutputStream("buffered.txt");
		String data = null;
		while((data = br.readLine()) != null) {
			System.out.println(data);
			fos.write((data+"\n").getBytes());
		}
	}
}