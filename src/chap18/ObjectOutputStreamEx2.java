package chap18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserInfo {
	protected String name;
	protected String password;
	public UserInfo() {}
	public UserInfo(String name,String password) {
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", password=" + password;
	}	
}
class UserInfo2 extends UserInfo implements Serializable {
	private int age;
	public UserInfo2(String name,String password,int age) {
		super(name,password);
		this.age = age;
	}
	@Override
	public String toString() {
		return super.toString() + ", age=" + age + "]";
	}
	//ObjectOutputStream�� writeObject�޼��忡�� ������ name,password�� 
	// ����ȭ �Ѵ�.
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	//ObjectInputStream�� readObject�޼��忡�� ������ name,password�� 
	// ������ȭ �Ѵ�.
	private void readObject(ObjectInputStream in) 
			                   throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
}
public class ObjectOutputStreamEx2 {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream
				 (new FileOutputStream("object2.ser"));
		UserInfo2 u1 = new UserInfo2("ȫ�浿","1234",20);
		UserInfo2 u2 = new UserInfo2("���","5678",30);
		oos.writeObject(u1);
		oos.writeObject(u2);
		System.out.println("����� 1 : " + u1);
		System.out.println("����� 2 : " + u2);
	}
}
