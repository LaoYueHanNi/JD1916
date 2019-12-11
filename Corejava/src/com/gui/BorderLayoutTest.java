package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutTest extends JFrame{

	private Container contentPane;
	private JButton northBtn,southBtn,eastBtn,westBtn;
	private JButton[] btns=new JButton[100];
	
	public BorderLayoutTest() {
		setSize(500,400);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("测试");
		contentPane=getContentPane();
		initGUI();
	}
	public void initGUI() {
		setLayout(new BorderLayout());
		southBtn=new JButton("南");
		eastBtn=new JButton("东");
		westBtn=new JButton("西");
		northBtn=new JButton("北");
		
		JPanel centerPanel=new JPanel();
		for(int i=0;i<100;i++) {
			btns[i]=new JButton(i+"");
			centerPanel.add(btns[i]);
		}
		contentPane.add(centerPanel);
		contentPane.add(eastBtn,BorderLayout.EAST);
		contentPane.add(northBtn,BorderLayout.NORTH);
		contentPane.add(southBtn,BorderLayout.SOUTH);
		contentPane.add(westBtn,BorderLayout.WEST);
		
		
		//给组件添加事件监听器
		//westBtn.addActionListener(this);
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest().go();
	}
	public void actionPerformed(ActionEvent e){
		//获取事件源
		JButton btn =(JButton)e.getSource();
		if(btn==westBtn) {
			new MyFirstGui().go();
			this.dispose();//关闭当前界面
		}else if(btn==southBtn) {
			
		}else if(btn==northBtn) {
			
		}else if(btn==eastBtn) {
			
		}
	}
}
