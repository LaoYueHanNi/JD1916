package com.briup.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Land implements ActionListener{
	
	
	private JFrame frame;
	private Container contentPane;
		
	private JTextField userNameText;
	private JTextField userPwdText;
	private JButton okBtn;
		
		
	public Land(){
		frame = new JFrame("test");
		frame.setBounds(350, 300, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane=frame.getContentPane();
		initGUI();
	}
		
	public void initGUI(){
		contentPane.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		userNameText=new JTextField(10);
		JLabel userNameLbl=new JLabel("userName");
		p1.add(userNameLbl);
		p1.add(userNameText);
		userNameText.addActionListener(this);
			
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		userPwdText=new JTextField(10);
		JLabel userPwdLbl=new JLabel("userPwd");
		p2.add(userPwdLbl);
		p2.add(userPwdText);
		userPwdText.addActionListener(this);
			
		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(p1);
		p.add(p2);
		contentPane.add(p);
			
		JPanel np=new JPanel(new BorderLayout());
		okBtn = new JButton("登录");
		np.add(okBtn);
		contentPane.add(np,BorderLayout.SOUTH);
		addBtnListener(okBtn);
	}
	public void go(){
		frame.setVisible(true);
	}
		
		
	public void addBtnListener(JButton...btns){
		for(JButton btn:btns)
			btn.addActionListener(this);
	}
		
	public static void main(String[] args) {
		(new Land()).go();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userNameText){
			//检查用户名输入的字符是否是无效字符(如空格，空字符串等)
			userPwdText.requestFocus();
		}
		if(e.getSource()==userPwdText||e.getSource()==okBtn){
			//检查密码输入的字符是否是无效字符，如果
			//不是无效字符到数据库验证，登录成功提示，登录失败提示
			String name=userNameText.getText().trim();
			String pwd=userPwdText.getText().trim();
		}
	}

}