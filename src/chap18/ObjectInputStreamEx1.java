package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * ObjectInputStream 예제
 * - 외부에서 전송된 객체를 읽을 수 있는 스트림. -> readObject() 메서드를 이용함.
 * - Object readObject() 임. 형변환하여 원래 객체의 자료형의 참조변수로 참조해야 한다. 
 */
public class ObjectInputStreamEx1 {
	public static void main(String[] args) 
			                throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream
		                         (new FileInputStream("object.ser"));
		Object o = ois.readObject();
		Customer c1 = (Customer)o;
//		Customer c1 = (Customer)ois.readObject();  //read하여 객체화시킴
		Customer c2 = (Customer)ois.readObject();
		System.out.println(o);
		System.out.println(c2);
	}
}
