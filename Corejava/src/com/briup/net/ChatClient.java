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

	private JTextArea sendArea;//要发送信息的内容区域
	private JTextArea contentArea;//聊天记录的内容区域
	private Container contentPane;
	private String name;//当前用户名
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//连接服务器端
		Socket socket=new Socket("127.0.0.1",6755);
		new ChatClient("欧阳",socket).go();;
		
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
		
		//启动子线程,接受服务器端发送的数据
		new ClientThread().start();
		
	}
	public void initGUI(){
		this.setSize(300,400);
		this.setTitle("我的聊天室");
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
		//创建一个分割窗口
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT,logPanel,sendPanel);
		splitPane.setDividerLocation(250);
		contentPane.add(splitPane,BorderLayout.CENTER);
		
		//下面的
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPane.add(jp,BorderLayout.SOUTH);
		
		JLabel nameLbl = new JLabel("用户名："+this.name+" ");
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
	//发送数据
	public void send (){
		//获取发送的数据
		String msg=sendArea.getText();
		pw.println(name+"说:"+msg);
		pw.flush();
		sendArea.setText("");//清理输入框
	}
	class ClientThread extends Thread{
		public void run() {
			try {
				String msg=null;
				while((msg=br.readLine())!=null){
					//追加组件
					contentArea.append(msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}