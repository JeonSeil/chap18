package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ObjectOutputStream 예제
 *  - 객체를 외부로 전송할 수 있는 스트림.
 *  - 전송되는 객체는 반드시 Serializable 인터페이스를 구현해야 한다.
 *  - 객체를 외부로 전송하는 기능을 직렬화 라고 한다.
 *  - 전송된 객체는 ObjectInputStream 스트림으로 readObject()메서드로 읽을 수 있다.
 */
class Customer implements Serializable{
	private String name;
	private int age;
	//transient : jumin 변수의 값은 직렬화에서 제외시킴.
	private transient String jumin;
	public Customer(String name,int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age 
				    + ", jumin=" + jumin + "]";
	}	
}
public class ObjectOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream
				  (new FileOutputStream("object.ser"));
		Customer c1 = new Customer("홍길동",20,"1234");
		Customer c2 = new Customer("김삿갓",30,"5678");
		oos.writeObject(c1);
		oos.writeObject(c2);
		System.out.println("고객 1 :" + c1);
		System.out.println("고객 2 :" + c2);
	}
}

