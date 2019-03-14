package chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamEx2 {
	public static void main(String[] args) throws IOException {
		FileInputStream f1 = new FileInputStream("src/chap18/InputStreamEx1.java");
		FileInputStream f2 = new FileInputStream("src/chap18/ReaderEx1.java");
		FileInputStream f3 = new FileInputStream("err.log");
		int len = 0;
		byte[] buf = new byte[1024];
		Vector<InputStream> v = new Vector<InputStream>();
		v.add(f1);v.add(f2);v.add(f3);
		SequenceInputStream st = new SequenceInputStream(v.elements());
		while((len=st.read(buf)) != -1) {
			System.out.print(new String(buf,0,len));
		}
	}
}
