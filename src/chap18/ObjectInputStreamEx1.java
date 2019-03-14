package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * ObjectInputStream ����
 * - �ܺο��� ���۵� ��ü�� ���� �� �ִ� ��Ʈ��. -> readObject() �޼��带 �̿���.
 * - Object readObject() ��. ����ȯ�Ͽ� ���� ��ü�� �ڷ����� ���������� �����ؾ� �Ѵ�. 
 */
public class ObjectInputStreamEx1 {
	public static void main(String[] args) 
			                throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream
		                         (new FileInputStream("object.ser"));
		Object o = ois.readObject();
		Customer c1 = (Customer)o;
//		Customer c1 = (Customer)ois.readObject();  //read�Ͽ� ��üȭ��Ŵ
		Customer c2 = (Customer)ois.readObject();
		System.out.println(o);
		System.out.println(c2);
	}
}
