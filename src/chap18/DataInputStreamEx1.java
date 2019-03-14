package chap18;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * DataInputStream 예제
 *   1. 보조 스트림
 *   2. 기본형으로 읽기 가능
 *   3. DataOutputStream 으로 저장된 내용을 읽을 수 있다.
 */
public class DataInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("data.ser");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
	}
}
