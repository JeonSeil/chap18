package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx2 {
	public static void main(String[] args) 
			             throws IOException, ClassNotFoundException{
		ObjectInputStream ois=
				  new ObjectInputStream(new FileInputStream("object2.ser"));
		System.out.println("사용자 1 : " + ois.readObject());
		System.out.println("사용자 2 : " + ois.readObject());
	}
}
