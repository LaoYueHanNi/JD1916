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
		JLabel userNameLbl = new JLabel("用户名");
		p1.add(userNameLbl);
		p1.add(userNameText);
		userNameText.addActionListener(this);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		userPwdText = new JTextField(10);
		JLabel userPwdLbl = new JLabel("密码");
		p2.add(userPwdLbl);
		p2.add(userPwdText);
		userPwdText.addActionListener(this);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		userAgeText = new JTextField(10);
		JLabel userAgeLbl = new JLabel("年龄");
		p3.add(userAgeLbl);
		p3.add(userAgeText);
		userAgeText.addActionListener(this);

		JPanel p = new JPanel(new GridLayout(3, 1));
		p.add(p1);
		p.add(p2);
		p.add(p3);
		contentPane.add(p);

		JPanel np = new JPanel(new BorderLayout());
		okBtn = new JButton("注册");
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
			// 检查用户名输入的字符是否是无效字符(如空格，空字符串等)
			name = userNameText.getText().trim();
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "名字不能为空");
				return;
			}
			userPwdText.requestFocus();
		}
		if (e.getSource() == userPwdText) {
			// 检查密码是否空
			pwd = userNameText.getText().trim();
			if (pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			userAgeText.requestFocus();
		}
		if (e.getSource() == userAgeText || e.getSource() == okBtn) {

			// 检查密码输入的字符是否是无效字符，如果
			// 不是无效字符到数据库验证，登录成功提示，登录失败提示

//			new Land().go();
//			frame.dispose();
			// 1)获取界面的信息(用户名,密码,年龄)
			name = userNameText.getText().trim();
			pwd = userPwdText.getText().trim();
			age = userAgeText.getText().trim();
			if (name.equals("") || pwd.equals("") || age.equals("")) {
				JOptionPane.showMessageDialog(null, "名字,密码,年龄都不能为空");
				return;
			}
			// 密码只能式6到10个字符
			// 年龄只能输入数字,20-60

			// 2)创建成teacher对象
			Teacher t = new Teacher();
			t.setName(name);
			t.setAge(Integer.parseInt(age));
			t.setPwd(pwd);
			// 3)调用service层的register()方法
			ITeacherService service = new TeacherServiceImpl();
			try {
				service.register(t);
				JOptionPane.showMessageDialog(null, "注册成功,请登录");

			} catch (TeacherException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());

			}
		}
	}

}