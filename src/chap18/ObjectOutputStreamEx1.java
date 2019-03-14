package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ObjectOutputStream ����
 *  - ��ü�� �ܺη� ������ �� �ִ� ��Ʈ��.
 *  - ���۵Ǵ� ��ü�� �ݵ�� Serializable �������̽��� �����ؾ� �Ѵ�.
 *  - ��ü�� �ܺη� �����ϴ� ����� ����ȭ ��� �Ѵ�.
 *  - ���۵� ��ü�� ObjectInputStream ��Ʈ������ readObject()�޼���� ���� �� �ִ�.
 */
class Customer implements Serializable{
	private String name;
	private int age;
	//transient : jumin ������ ���� ����ȭ���� ���ܽ�Ŵ.
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
		Customer c1 = new Customer("ȫ�浿",20,"1234");
		Customer c2 = new Customer("���",30,"5678");
		oos.writeObject(c1);
		oos.writeObject(c2);
		System.out.println("�� 1 :" + c1);
		System.out.println("�� 2 :" + c2);
	}
}

