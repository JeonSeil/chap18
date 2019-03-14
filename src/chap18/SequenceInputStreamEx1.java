package chap18;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/*
 * SequenceInputStream 예제
 *   여러개의 InputStream을 모아서 하나의 InputStream으로 리턴. 
 *   연결스트림.
 */
public class SequenceInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		byte[] arr1 = {1,2,3,4,5};
		byte[] arr2 = {6,7,8,9,10};
		ByteArrayInputStream stream1 = new ByteArrayInputStream(arr1);
		ByteArrayInputStream stream2 = new ByteArrayInputStream(arr2);
		SequenceInputStream in = new SequenceInputStream(stream1,stream2);
		int data;
//		System.out.println("stream1의 내용");
//		while((data = stream1.read()) != -1) {
//			System.out.println((byte)data);
//		}
//		System.out.println("stream2의 내용");
//		while((data = stream2.read()) != -1) {
//			System.out.println((byte)data);
//		}
		System.out.println("연결 스트림 in 의 내용");
		while((data = in.read()) != -1) {
			System.out.println((byte)data);
		}
	}
}
