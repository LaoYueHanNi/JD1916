package Myself;
import javax.swing.*;
import java.awt.*;
public class MyMousePlay {
	private JFrame frame;
	private Container contentPane;
	private JComboBox<String> box;
	private JLabel time,timevalue,cent,centvalue;
	private JButton startBtn;
	private JPanel northPanel,centerPanel;
	
	public MyMousePlay() {
		frame=new JFrame();
		//�����С
		//����λ��
		frame.setBounds(500, 500, 200, 200);
		frame.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frame.getWidth())/2,
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frame.getHeight())/2);
		//���ñ���
		frame.setTitle("��Լ���ݴ����");
		//�ر�Ӧ�ó���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	public void initGUI() {
		contentPane.setLayout(new FlowLayout());
		box.addItem("�߼�");
		box.addItem("�ͼ�");
		box.addItem("�м�");
		//JComboBox();������
		//�Ա�ǩ���г�ʼ��
		time=new JLabel("time:");
		timevalue=new JLabel("15");
		cent=new JLabel("cent:");
		centvalue=new JLabel("0");
		//�Կ�ʼ��ť���г�ʼ��
		startBtn=new JButton("start");
		
		//�������,ѡ�񲼾ֹ�����,
		northPanel=new JPanel();
		northPanel.add(box);
		northPanel.add(time);
		northPanel.add(timevalue);
		northPanel.add(cent);
		northPanel.add(centvalue);
		northPanel.add(startBtn);
		frame.add(northPanel,BorderLayout.NORTH);
		frame.setLayout(new GridLayout(3, 3));
		
		//���
	}
	public void go() {
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new MyMousePlay().go();
	}
	
}	
