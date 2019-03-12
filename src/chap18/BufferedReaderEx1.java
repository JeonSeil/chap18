package chap18;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ������Ʈ�� : �ٸ� ��Ʈ���� �����Ͽ� ����� �߰��� �� �ִ� ��Ʈ��.
 * BufferedReader : ���۸� �߰��Ͽ� ������ ����� �� �ִ� ��Ʈ��.
 *  => readLine() �޼��带 �̿��Ͽ� ���پ� ���� �� �ִ� ����� �����Ѵ�.
 *  new BufferedReader(Reader)
 */
public class BufferedReaderEx1 {
	public static void main(String[] args) throws IOException {
		//Ű���忡�� ���پ� �Է¹ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileOutputStream fos = new FileOutputStream("buffered.txt");
		String data = null;
		while((data = br.readLine()) != null) {
			System.out.println(data);
			fos.write((data+"\n").getBytes());
		}
	}
}