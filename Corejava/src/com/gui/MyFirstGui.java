package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFirstGui {
	private JFrame frame;
	private Container contentPane;
	// ��ť���
	private JButton calBtn, clearBtn, exitBtn;
	// �����ı���
	private JTextField num1Txt, num2Txt, num3Txt;
	// �ı���ʾ��
	private JLabel addLbl, equalsLbl;

	// ��ʼ������
	public MyFirstGui() {
		frame = new JFrame();
		// ���ô�С
		frame.setSize(456, 200);
		// ��������
		frame.setLocation(200, 200);
		// ���õ���رհ�ť���ѳ���һ���˳�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���
		frame.setTitle("��Լ���ݼ�����");
		// ��ȡ��������
		contentPane = frame.getContentPane();
		// ���������ı�����ɫ
		Color c = new Color(250, 125, 22);
		contentPane.setBackground(c); 
		initGUI();
	}

	// �������ʼ��,���������ӵ�������
	public void initGUI() {
		// ���������Ĳ��ֹ�����
		contentPane.setLayout(new FlowLayout());
		// �������
		calBtn = new JButton("����");
		clearBtn = new JButton("���");
		exitBtn = new JButton("�˳�");
		num1Txt = new JTextField(10);
		num2Txt = new JTextField(10);
		num3Txt = new JTextField(10);
		addLbl = new JLabel("+");
		equalsLbl = new JLabel("=");
		
		num1Txt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//�ڶ���������ȡ����
				num2Txt.requestFocus();
			}
		});
		
		//��num1Txt��num2Txt��Ӽ����¼�
		KeyListener listener=new MyKeyListener();
		 num1Txt.addKeyListener(listener);
		 num2Txt.addKeyListener(listener);
		
		
		// ���������Ķ��뷽ʽ
		num1Txt.setHorizontalAlignment(JTextField.RIGHT);
		num2Txt.setHorizontalAlignment(JTextField.RIGHT);
		num3Txt.setHorizontalAlignment(JTextField.RIGHT);
		// ������������ܱ༭
		num3Txt.setEditable(false);

		// ������������
		contentPane.add(num1Txt);
		contentPane.add(addLbl);
		contentPane.add(num2Txt);
		contentPane.add(equalsLbl);
		contentPane.add(num3Txt);
		contentPane.add(calBtn);
		contentPane.add(clearBtn);
		contentPane.add(exitBtn);

		// ���������¼�������
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
		// ���ÿ�ʼ��ʾ
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new MyFirstGui().go();
	}

	//�ڲ���
	class MyKeyListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			//��ȡ���¼���unicode��
			int code=e.getKeyChar();
			//System.out.println(code);
			if(code>57||code<48) {
				//��ֹ����
				e.consume();
			}
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

	}
}
