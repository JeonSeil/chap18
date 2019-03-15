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
 * ��Ƽ ä�� Ŭ���̾�Ʈ ���α׷�.
 * GUI ȯ�� : AWT �ڹ� API ����Ͽ� �ڵ���.
 * 
 * Frame : ������â.
 * ActionListener : Action �̺�Ʈ ó�� ���� �������̽�
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
	GUIChatClientEx1() { //������
		super("ä�����α׷�����");
	    c1 = new CardLayout();
	    setLayout(c1);
	    Panel connect = new  Panel();
	    connect.setLayout(new BorderLayout());
	    connect.add("North",new Label("ä������ȭ��",Label.CENTER));
		
	    Panel conn_sub = new Panel();
	    conn_sub.setLayout(new GridLayout(10,1));
	    conn_sub.add(new Label("���� IP",Label.CENTER));
	    tfip = new TextField("127.0.0.1",15);
	    conn_sub.add(tfip);
	    conn_sub.add(new Label("����� ID",Label.CENTER));
	    tfname = new TextField("ȫ�浿",15);
	    conn_sub.add(tfname);
	    connect.add("Center",conn_sub);
	    btnconnect = new Button("��������");
	    connect.add("South",btnconnect);
	    //��ưŬ���� �߻��Ǵ� �̺�Ʈ(ActionEvent) ó��
	    //ActionEvent�� ���� ������ : ActionListener
	    // ActionListener�� ����ϱ� ���ؼ��� ActionListener Ÿ���� �������̽� ��ü�� �����
	    btnconnect.addActionListener(this);
	    
	    Panel chat = new Panel();
	    chat.setLayout(new BorderLayout());
	    chat.add("North",new Label("ä�� ver1.0"));
	    talist = new TextArea();
	    chat.add("Center",talist);
	    
	    Panel chat_sub = new Panel();
	    tfinput = new TextField("",25);
	    btnexit = new Button("����");
	    btnsend = new Button("����");
	    
	    chat_sub.add(tfinput);
	    chat_sub.add(btnexit);
	    chat_sub.add(btnsend);
	    //TextField ��ü���� enterŰ�� �ԷµǸ� ActionEvent�� �߻���
	    tfinput.addActionListener(this);
	    btnexit.addActionListener(this);
	    btnsend.addActionListener(this);
	    
	    chat.add("South",chat_sub);
	    add(connect,"����â");
	    add(chat,"ä��â");
	    c1.show(this, "����â");
	    setSize(500,500);
	    setVisible(true);
	    
	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		System.exit(0);
	    	}
	    });
	}
	//�̺�Ʈ �ڵ鷯.
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj = e.getSource(); //�̺�Ʈ �߻� ������Ʈ. �̺�Ʈ �ҽ�
			if(obj == btnconnect) init();
			else if (obj == btnexit) System.exit(0);
			else { //tfInput ��ü�� EnterŰ�� �Է� �Ǵ� btnsend ��ư�� Ŭ���Ȱ��
				String sendData = tfinput.getText();
				oos.writeObject(sendData); //������ ����
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
			oos.writeObject(userid); //userid���� ������ ����
			oos.flush();
			ReceiveDataThread rt = new ReceiveDataThread();
			rt.setDaemon(true);
			rt.start();
			
			c1.show(this, "ä��â");
			setTitle(userid + "ä��â"); //�������� title ����
			tfinput.requestFocus(); //tfinput ������Ʈ�� Ŀ�� �̵�
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//�������� ���ŵ� �����͸� talist ������Ʈ�� ���� �߰��ϱ�.
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