package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFirstGui {
	private JFrame frame;
	private Container contentPane;
	// 按钮组件
	private JButton calBtn, clearBtn, exitBtn;
	// 单行文本域
	private JTextField num1Txt, num2Txt, num3Txt;
	// 文本显示框
	private JLabel addLbl, equalsLbl;

	// 初始化容器
	public MyFirstGui() {
		frame = new JFrame();
		// 设置大小
		frame.setSize(456, 200);
		// 设置坐标
		frame.setLocation(200, 200);
		// 设置点击关闭按钮并把程序一并退出
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置标题
		frame.setTitle("老约翰妮计算器");
		// 获取桌布对象
		contentPane = frame.getContentPane();
		// 设置容器的背景颜色
		Color c = new Color(250, 125, 22);
		contentPane.setBackground(c); 
		initGUI();
	}

	// 对组件初始化,并把组件添加到容器中
	public void initGUI() {
		// 设置容器的布局管理器
		contentPane.setLayout(new FlowLayout());
		// 创建组件
		calBtn = new JButton("计算");
		clearBtn = new JButton("清除");
		exitBtn = new JButton("退出");
		num1Txt = new JTextField(10);
		num2Txt = new JTextField(10);
		num3Txt = new JTextField(10);
		addLbl = new JLabel("+");
		equalsLbl = new JLabel("=");
		
		num1Txt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//第二个输入框获取焦点
				num2Txt.requestFocus();
			}
		});
		
		//给num1Txt和num2Txt添加键盘事件
		KeyListener listener=new MyKeyListener();
		 num1Txt.addKeyListener(listener);
		 num2Txt.addKeyListener(listener);
		
		
		// 设置输入框的对齐方式
		num1Txt.setHorizontalAlignment(JTextField.RIGHT);
		num2Txt.setHorizontalAlignment(JTextField.RIGHT);
		num3Txt.setHorizontalAlignment(JTextField.RIGHT);
		// 第三个输入框不能编辑
		num3Txt.setEditable(false);

		// 添加组件到容器
		contentPane.add(num1Txt);
		contentPane.add(addLbl);
		contentPane.add(num2Txt);
		contentPane.add(equalsLbl);
		contentPane.add(num3Txt);
		contentPane.add(calBtn);
		contentPane.add(clearBtn);
		contentPane.add(exitBtn);

		// 给组件添加事件监听器
		calBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num1 = num1Txt.getText();
				String num2 = num2Txt.getText();

				int num3 = Integer.parseInt(num1) + Integer.parseInt(num2);
				num3Txt.setText(num3 + "");
			}
		});

		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1Txt.setText(null);
				num2Txt.setText(null);
				num3Txt.setText(null);
			}
		});

		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void go() {
		// 设置开始显示
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new MyFirstGui().go();
	}

	//内部类
	class MyKeyListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			//获取按下键的unicode码
			int code=e.getKeyChar();
			//System.out.println(code);
			if(code>57||code<48) {
				//阻止输入
				e.consume();
			}
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

	}
}
