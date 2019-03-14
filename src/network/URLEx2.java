package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://gdu.co.kr");
		int len;
		byte buf[] = new byte[1024];
		InputStream is = url.openStream();
		while((len=is.read(buf)) != -1) {
			System.out.println(new String(buf,0,len,"UTF-8"));
		}
	}
}
