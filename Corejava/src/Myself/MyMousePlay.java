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
		//窗体大小
		//窗体位置
		frame.setBounds(500, 500, 200, 200);
		frame.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frame.getWidth())/2,
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frame.getHeight())/2);
		//设置标题
		frame.setTitle("老约翰妮打地鼠");
		//关闭应用程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	public void initGUI() {
		contentPane.setLayout(new FlowLayout());
		box.addItem("高级");
		box.addItem("低级");
		box.addItem("中级");
		//JComboBox();下拉框
		//对标签进行初始化
		time=new JLabel("time:");
		timevalue=new JLabel("15");
		cent=new JLabel("cent:");
		centvalue=new JLabel("0");
		//对开始按钮进行初始化
		startBtn=new JButton("start");
		
		//创建面板,选择布局管理器,
		northPanel=new JPanel();
		northPanel.add(box);
		northPanel.add(time);
		northPanel.add(timevalue);
		northPanel.add(cent);
		northPanel.add(centvalue);
		northPanel.add(startBtn);
		frame.add(northPanel,BorderLayout.NORTH);
		frame.setLayout(new GridLayout(3, 3));
		
		//添加
	}
	public void go() {
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new MyMousePlay().go();
	}
	
}	
