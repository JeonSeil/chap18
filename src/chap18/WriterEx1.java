package chap18;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriterEx1 {
	public static void main(String[] args) throws IOException {
		Writer out = new OutputStreamWriter(System.out);
		out.write('1');out.write('2');out.write('3');
		out.write('A');out.write('B');out.write('C');
		out.write('가');out.write('나');out.write('다');
		out.flush(); //버퍼의 내용을 목적지로 강제 전송함.
	}
}
