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
		setTitle("����");
		contentPane=getContentPane();
		initGUI();
	}
	public void initGUI() {
		setLayout(new BorderLayout());
		southBtn=new JButton("��");
		eastBtn=new JButton("��");
		westBtn=new JButton("��");
		northBtn=new JButton("��");
		
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
		
		
		//���������¼�������
		//westBtn.addActionListener(this);
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest().go();
	}
	public void actionPerformed(ActionEvent e){
		//��ȡ�¼�Դ
		JButton btn =(JButton)e.getSource();
		if(btn==westBtn) {
			new MyFirstGui().go();
			this.dispose();//�رյ�ǰ����
		}else if(btn==southBtn) {
			
		}else if(btn==northBtn) {
			
		}else if(btn==eastBtn) {
			
		}
	}
}
