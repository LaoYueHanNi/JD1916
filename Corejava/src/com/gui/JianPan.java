package com.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;

public class JianPan {
	private JFrame frame;
	private Container contentPane;
	private JTextField CeTxt;
	
	public JianPan(){
		frame=new JFrame();
		frame.setSize(400,400);
		frame.setLocation(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("º¸≈Ã≤‚ ‘");
		contentPane=frame.getContentPane();
		initGUI();
	}
	public void initGUI() {
		contentPane.setLayout(new FlowLayout());
		
		CeTxt=new JTextField(10);
		
		KeyListener listener=new MyKeyListener();
		CeTxt.addKeyListener(listener);
		CeTxt.setHorizontalAlignment(JTextField.LEFT);
		contentPane.add(CeTxt);
	}
	
	class MyKeyListener implements KeyListener{
		
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			int code =e.getKeyChar();
			Calendar now=Calendar.getInstance();
			System.out.println(code+"Time:"+now.get(Calendar.HOUR_OF_DAY)+"-"+now.get(Calendar.MINUTE)+"-"+now.get(Calendar.SECOND));
			
			
		}

		public void keyReleased(KeyEvent e) {
			
		}
		
	}
	public void go() {
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new JianPan().go();
	}
	
}
