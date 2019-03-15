package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/*
 * 멀티 채팅 서버 프로그램
 */
public class ChatServerEx1 {
	static HashMap<String,ObjectOutputStream> hm =
			new HashMap<String,ObjectOutputStream>(); 
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6000);
		while(true) {
		    System.out.println("클라이언트 접속 대기중");
		    Socket client = server.accept();
		    ChatServerThread ct=new ChatServerThread(client);
		    ct.start();
		}
	}
	static class ChatServerThread extends Thread{
		Socket client;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		String userid;
		ChatServerThread(Socket client) {
			this.client = client;
			try {
				ois = new ObjectInputStream(client.getInputStream());
				oos = new ObjectOutputStream(client.getOutputStream());
				userid = (String)ois.readObject(); //홍길동
				System.out.println(userid + " 접속함");
				synchronized(hm) {
					hm.put(userid, oos);
				}
				broadcast(userid + "님이 입장하셨습니다.");
			} catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public void run() {
			String rcvData;
			try {
				while(true) {
					rcvData = (String)ois.readObject();
					if(rcvData.equals("/bye")) break;
					// /to userid 내용
					else if(rcvData.startsWith("/to")) //귀속말
						sendMsg(rcvData);
					else broadcast(userid + ":" + rcvData);
				}
			}catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				broadcast(userid + "님이 퇴장 하셨습니다.");
				hm.remove(userid);
				try {
					if(client != null) client.close();
				}catch(IOException e) {}
			}
		}
		private void broadcast(String msg) {
			try {
				for(ObjectOutputStream o : hm.values()) {
					o.writeObject(msg);
					o.flush();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		private void sendMsg(String rcvData) {
			//rcvData : /to userid 내용
			int begin = rcvData.indexOf(" ") + 1;
			int end = rcvData.indexOf(" ",begin);
			if(end != -1) {
				String id = rcvData.substring(begin,end);//상대 사용자id
				String msg = rcvData.substring(end+1);
				ObjectOutputStream oos = hm.get(id);
				ObjectOutputStream oos2 =hm.get(userid);
				if(oos != null) {
					try {
						oos.writeObject(userid + "님의 귀속말:" + msg);
						oos.flush();
						oos2.writeObject(id + "님에게 귀속말 전송완료:" + msg);
						oos2.flush();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
