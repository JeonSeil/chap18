package network;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL 클래스 : URL 정보 관리하는 클래스. URL 형식 중점적으로 관리함.
 */
public class URLEx1 {
	public static void main(String[] args) throws MalformedURLException {
		URL url1 = null, url2 = null;
		url1 = new URL("http://www.goodee.co.kr:3000/index.jsp");
		url2 = new URL("file","",-1,"aaa.txt");
		System.out.println
		   ("protocol : " + url1.getProtocol() + "," + url2.getProtocol());
		System.out.println
		   ("host : " + url1.getHost() + "," + url2.getHost());
		System.out.println
		   ("port : " + url1.getPort() + "," + url2.getPort());
		System.out.println
		   ("file : " + url1.getFile() + "," + url2.getFile());
		System.out.println ("url : " + url1 + "," + url2);
	}
}
