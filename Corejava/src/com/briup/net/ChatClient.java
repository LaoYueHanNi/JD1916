package com.briup.net;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ChatClient extends JFrame {

	private JTextArea sendArea;//Ҫ������Ϣ����������
	private JTextArea contentArea;//�����¼����������
	private Container contentPane;
	private String name;//��ǰ�û���
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//���ӷ�������
		Socket socket=new Socket("127.0.0.1",6755);
		new ChatClient("ŷ��",socket).go();;
		
	}
	public ChatClient(String name,Socket socket){
		this.socket=socket;
		try {
			pw=new PrintWriter(socket.getOutputStream());
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGUI();
		
		//�������߳�,���ܷ������˷��͵�����
		new ClientThread().start();
		
	}
	public void initGUI(){
		this.setSize(300,400);
		this.setTitle("�ҵ�������");
		contentPane = getContentPane();
		int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((x-this.getWidth())/2, (y-this.getHeight())/2);
		this.setResizable(false);
		
		contentArea = new JTextArea();
	//	contentArea.setLineWrap(true);
		contentArea.setEditable(false);
		JScrollPane logPanel = new JScrollPane(contentArea,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sendArea = new  JTextArea();
	//	sendArea.setLineWrap(true);
		sendArea.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 send();
				 }
			 }
		});
		JScrollPane sendPanel = new JScrollPane(sendArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//����һ���ָ��
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT,logPanel,sendPanel);
		splitPane.setDividerLocation(250);
		contentPane.add(splitPane,BorderLayout.CENTER);
		
		//�����
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPane.add(jp,BorderLayout.SOUTH);
		
		JLabel nameLbl = new JLabel("�û�����"+this.name+" ");
		jp.add(nameLbl);
		
		JButton resetBtn = new JButton("close");
		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		jp.add(resetBtn);
		
		JButton sendBtn = new JButton("send");
		jp.add(sendBtn);
		sendBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				send();
			}
		});
	}

	public void go(){
		this.setVisible(true);
	}
	//��������
	public void send (){
		//��ȡ���͵�����
		String msg=sendArea.getText();
		pw.println(name+"˵:"+msg);
		pw.flush();
		sendArea.setText("");//���������
	}
	class ClientThread extends Thread{
		public void run() {
			try {
				String msg=null;
				while((msg=br.readLine())!=null){
					//׷�����
					contentArea.append(msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}