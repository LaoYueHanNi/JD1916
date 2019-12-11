package com.gui;

import java.awt.*;

import javax.swing.JFrame;

public class PanelTest {
	public static void main(String[] args) {
		JFrame frame=new JFrame("≤‚ ‘");
		Panel panel=new Panel();
		
		panel.add(new TextField(20));
		panel.add(new Button("µ„Œ“"));
		frame.add(panel);
		frame.setBounds(30, 30, 250, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
