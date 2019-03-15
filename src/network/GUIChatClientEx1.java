package network;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * 멀티 채팅 클라이언트 프로그램.
 * GUI 환경 : AWT 자바 API 사용하여 코딩함.
 * 
 * Frame : 윈도우창.
 * ActionListener : Action 이벤트 처리 관련 인터페이스
 */
public class GUIChatClientEx1 extends Frame implements ActionListener{
	CardLayout c1;
	String userid;
	Button btnexit,btnsend,btnconnect;
	TextArea talist;
	TextField tfip,tfname,tfinput;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public static void main(String[] args) {
		new GUIChatClientEx1();
	}
	GUIChatClientEx1() { //생성자
		super("채팅프로그램예제");
	    c1 = new CardLayout();
	    setLayout(c1);
	    Panel connect = new  Panel();
	    connect.setLayout(new BorderLayout());
	    connect.add("North",new Label("채팅접속화면",Label.CENTER));
		
	    Panel conn_sub = new Panel();
	    conn_sub.setLayout(new GridLayout(10,1));
	    conn_sub.add(new Label("서버 IP",Label.CENTER));
	    tfip = new TextField("127.0.0.1",15);
	    conn_sub.add(tfip);
	    conn_sub.add(new Label("사용자 ID",Label.CENTER));
	    tfname = new TextField("홍길동",15);
	    conn_sub.add(tfname);
	    connect.add("Center",conn_sub);
	    btnconnect = new Button("서버접속");
	    connect.add("South",btnconnect);
	    //버튼클릭시 발생되는 이벤트(ActionEvent) 처리
	    //ActionEvent의 관리 리스너 : ActionListener
	    // ActionListener에 등록하기 위해서는 ActionListener 타입의 인터페이스 객체로 등록함
	    btnconnect.addActionListener(this);
	    
	    Panel chat = new Panel();
	    chat.setLayout(new BorderLayout());
	    chat.add("North",new Label("채팅 ver1.0"));
	    talist = new TextArea();
	    chat.add("Center",talist);
	    
	    Panel chat_sub = new Panel();
	    tfinput = new TextField("",25);
	    btnexit = new Button("종료");
	    btnsend = new Button("전송");
	    
	    chat_sub.add(tfinput);
	    chat_sub.add(btnexit);
	    chat_sub.add(btnsend);
	    //TextField 객체에서 enter키가 입력되면 ActionEvent가 발생됨
	    tfinput.addActionListener(this);
	    btnexit.addActionListener(this);
	    btnsend.addActionListener(this);
	    
	    chat.add("South",chat_sub);
	    add(connect,"접속창");
	    add(chat,"채팅창");
	    c1.show(this, "접속창");
	    setSize(500,500);
	    setVisible(true);
	    
	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		System.exit(0);
	    	}
	    });
	}
	//이벤트 핸들러.
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj = e.getSource(); //이벤트 발생 컴포넌트. 이벤트 소스
			if(obj == btnconnect) init();
			else if (obj == btnexit) System.exit(0);
			else { //tfInput 객체에 Enter키가 입력 또는 btnsend 버튼이 클릭된경우
				String sendData = tfinput.getText();
				oos.writeObject(sendData); //서버에 전송
				oos.flush();
				tfinput.setText("");
				tfinput.requestFocus();
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	private void init() {
		try {
			String ip = tfip.getText();
			Socket client = new Socket(ip,6000);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			userid = tfname.getText();
			oos.writeObject(userid); //userid값을 서버에 전송
			oos.flush();
			ReceiveDataThread rt = new ReceiveDataThread();
			rt.setDaemon(true);
			rt.start();
			
			c1.show(this, "채팅창");
			setTitle(userid + "채팅창"); //윈도우의 title 변경
			tfinput.requestFocus(); //tfinput 컴포넌트의 커서 이동
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//서버에서 수신된 데이터를 talist 컴포넌트에 내용 추가하기.
	class ReceiveDataThread extends Thread {
		String rcvData;
		public void run() {
			try {
				while(true) {
					rcvData = (String)ois.readObject();
					talist.append(rcvData+"\n");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}