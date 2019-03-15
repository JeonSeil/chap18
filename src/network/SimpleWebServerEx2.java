package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import network.SimpleWebServerEx1.HttpThread;

/*
 * ������ ������ �����ϱ�
 * �̹��� ���ϵ� ��µǵ��� SimpleWebServerEx1.java ������ �ҽ�
 */
public class SimpleWebServerEx2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		while (true) {
			System.out.println("Ŭ���̾�Ʈ ���� ���");
			Socket client = server.accept();
			HttpThread ht = new HttpThread(client);// 1 thread = 1 ������(Ŭ���̾�Ʈ)
			ht.start();
		}
	}
	static class HttpThread extends Thread {
		private Socket client;
		BufferedInputStream bis;
		BufferedOutputStream bos;

		HttpThread(Socket client) {
			this.client = client;
			try {
				bis = new BufferedInputStream(client.getInputStream());
				bos = new BufferedOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("server ip :" + client.getLocalAddress());
			System.out.println("server port :" + client.getLocalPort());
			System.out.println("client ip :" + client.getInetAddress());
			System.out.println("client port :" + client.getPort());
		}

		public void run() {
			FileInputStream fis = null;
			try {
				byte[] buf = new byte[8096];
				int len = bis.read(buf);
				String line = new String(buf,0,len);
				System.out.println("Http Header :" + line);
				int start = line.indexOf("/") + 1;
				int end = line.lastIndexOf("HTTP") - 1;
				String filename = line.substring(start, end);
				if (filename.equals(""))
					filename = "index.html";
				fis = new FileInputStream(filename);
				while ((len = fis.read(buf)) != -1) {
					bos.write(buf,0,len);
					bos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fis != null)
						fis.close();
					if (bis != null)
						bis.close();
					if (bos != null)
					    bos.close();
					if (client != null)
						client.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
