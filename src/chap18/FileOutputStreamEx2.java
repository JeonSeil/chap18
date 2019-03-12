package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

//���� ������ File�� �����ϱ�
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		firstMethod();
	}
	private static void firstMethod() {
		secondMethod();
	}
	//FileOutputStream(���ϸ�,true)
	// ���ϸ��� ������ ���� : ���� ���� ������
	//                  ���� ������ ������ ������, ���ο� ������ �߰�
	// ���ϸ��� ������ ���� : ���� �����Ͽ� ������ �����
	//  
	private static void secondMethod() {
		try {
			throw new Exception("���Ͽ� ���� �޽��� �����ϱ�");
		} catch(Exception e) {
			e.printStackTrace(); //ǥ�ؿ�����Ʈ��(System.err) ���, ȭ�� ���
			try {
				FileOutputStream fos = new FileOutputStream("err.log",true);
				fos.write(e.getMessage().getBytes());  //fos ���Ϸ� �����޽��� ����ϱ�
				e.printStackTrace(new PrintStream(fos)); //fos ���Ϸ� ����� ���
				fos.write("\n\n".getBytes());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
