package com.gui;

import java.awt.*;

import javax.swing.*;

public class GridLayoutTest extends JFrame{
	private Container contentPane;
	private JTextField numTxt;
	private JButton[] btns=new JButton[10];
	private JButton clearBtn,addBtn,minBtn,mulBtn,divBtn,equalsBtn;
	public GridLayoutTest() {
		setSize(300,200);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ceshi");
		contentPane=getContentPane();
		setResizable(false);
		initGUI();
		
	}
	public void initGUI() {
		numTxt=new JTextField(10);
		numTxt.setEditable(false);
		numTxt.setHorizontalAlignment(JTextField.RIGHT);
		numTxt.setText("0");
		numTxt.setBackground(Color.blue);
		Font font =new Font("¿¬Ìå",Font.BOLD,25);
		contentPane.add(numTxt,BorderLayout.NORTH);
		clearBtn=new JButton("clear");
		addBtn=new JButton("add");
		minBtn=new JButton("¼õ");
		mulBtn=new JButton("³Ë");
		divBtn=new JButton("³ý");
		equalsBtn=new JButton("ºÍ");
		
		JPanel jp=new JPanel();
		contentPane.add(jp);
		for(int i=0;i<10;i++) {
			btns[i]=new JButton(i+"");
			jp.add(btns[i]);
		}
		jp.add(clearBtn);
		jp.add(addBtn);
		jp.add(minBtn);
		jp.add(mulBtn);
		jp.add(divBtn);
		jp.add(equalsBtn);
	}
	public void go() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutTest().go();
	}
	
}
