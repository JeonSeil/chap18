package chap18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

/* ���� :
 * src/chap18 ������ .java ���� �� InputStream ���� ��� �ҽ��� 
 * InputStream����.txt ���Ϸ� �����ϱ�
 * 
 * InputStream ���� ��� �ҽ� : XXXInputStreamXXX.java
 * 
 * 1. f1 =File("src/chap18") ����
 * 2. f1�� ���� ����,���ϸ� �޾Ƽ�, �� �� �����̸鼭, ������ �̸��� InputStream ���� �����ϸ�
 *    FileInputStream ���� ����.
 * 3. FileInputStream Vector�� ���� => SequenceInputStream ��ü�� �����ϱ�.
 * 4. SequenceInputStream �о "InputStream����.txt" ���Ϸ� �����ϱ�
 */
public class Exam4 {
	public static void main(String[] args) throws IOException {
		Vector<InputStream> v = new Vector<InputStream>();
		String filepath = "src/chap18";
		File f1 = new File(filepath);
		String[] list = f1.list(); //���� ����, ������ �̸��� �迭�� ����
		for(String f : list) {
			File f2 = new File(filepath,f);
			if(f2.isFile() && f.contains("InputStream") &&f.contains(".java")){
			   v.add(new FileInputStream(f2));
			}
		}
		SequenceInputStream st = new SequenceInputStream(v.elements());
		FileOutputStream fos = new FileOutputStream("InputStream����.txt");
		int len;
		byte[] buf = new byte[1024];
		while((len=st.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
	}
}