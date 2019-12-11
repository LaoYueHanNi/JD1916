package com.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseTest extends JFrame{
	private JFrame frame;
	private Container contentPane;
	public MouseTest() {
		frame=new JFrame();
		frame.setSize(200,200);
		frame.setLocation(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("≤‚ ‘");
		
		
		contentPane=frame.getContentPane();
		initGUI();
	}
	public void  initGUI() {
		contentPane.setLayout(new FlowLayout());
		contentPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ss");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
	}
	public void go() {
		frame.setVisible(true);
	
	}
	public static void main(String[] args) {
		new MouseTest().go();
	}
}
