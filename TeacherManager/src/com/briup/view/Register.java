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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.briup.bean.Teacher;
import com.briup.exception.TeacherException;
import com.briup.service.ITeacherService;
import com.briup.service.TeacherServiceImpl;

public class Register implements ActionListener {

	private JFrame frame;
	private Container contentPane;

	private JTextField userNameText;
	private JTextField userPwdText;
	private JTextField userAgeText;
	private JButton okBtn;

	public Register() {
		frame = new JFrame("test");
		frame.setBounds(350, 300, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		initGUI();
	}

	public void initGUI() {
		contentPane.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		userNameText = new JTextField(10);
		JLabel userNameLbl = new JLabel("�û���");
		p1.add(userNameLbl);
		p1.add(userNameText);
		userNameText.addActionListener(this);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		userPwdText = new JTextField(10);
		JLabel userPwdLbl = new JLabel("����");
		p2.add(userPwdLbl);
		p2.add(userPwdText);
		userPwdText.addActionListener(this);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		userAgeText = new JTextField(10);
		JLabel userAgeLbl = new JLabel("����");
		p3.add(userAgeLbl);
		p3.add(userAgeText);
		userAgeText.addActionListener(this);

		JPanel p = new JPanel(new GridLayout(3, 1));
		p.add(p1);
		p.add(p2);
		p.add(p3);
		contentPane.add(p);

		JPanel np = new JPanel(new BorderLayout());
		okBtn = new JButton("ע��");
		np.add(okBtn);
		contentPane.add(np, BorderLayout.SOUTH);
		addBtnListener(okBtn);
	}

	public void go() {
		frame.setVisible(true);
	}

	public void addBtnListener(JButton... btns) {
		for (JButton btn : btns)
			btn.addActionListener(this);
	}

	public static void main(String[] args) {
		(new Register()).go();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = null;
		String pwd = null;
		String age = null;
		if (e.getSource() == userNameText) {
			// ����û���������ַ��Ƿ�����Ч�ַ�(��ո񣬿��ַ�����)
			name = userNameText.getText().trim();
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "���ֲ���Ϊ��");
				return;
			}
			userPwdText.requestFocus();
		}
		if (e.getSource() == userPwdText) {
			// ��������Ƿ��
			pwd = userNameText.getText().trim();
			if (pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
				return;
			}
			userAgeText.requestFocus();
		}
		if (e.getSource() == userAgeText || e.getSource() == okBtn) {

			// �������������ַ��Ƿ�����Ч�ַ������
			// ������Ч�ַ������ݿ���֤����¼�ɹ���ʾ����¼ʧ����ʾ

//			new Land().go();
//			frame.dispose();
			// 1)��ȡ�������Ϣ(�û���,����,����)
			name = userNameText.getText().trim();
			pwd = userPwdText.getText().trim();
			age = userAgeText.getText().trim();
			if (name.equals("") || pwd.equals("") || age.equals("")) {
				JOptionPane.showMessageDialog(null, "����,����,���䶼����Ϊ��");
				return;
			}
			// ����ֻ��ʽ6��10���ַ�
			// ����ֻ����������,20-60

			// 2)������teacher����
			Teacher t = new Teacher();
			t.setName(name);
			t.setAge(Integer.parseInt(age));
			t.setPwd(pwd);
			// 3)����service���register()����
			ITeacherService service = new TeacherServiceImpl();
			try {
				service.register(t);
				JOptionPane.showMessageDialog(null, "ע��ɹ�,���¼");

			} catch (TeacherException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());

			}
		}
	}

}