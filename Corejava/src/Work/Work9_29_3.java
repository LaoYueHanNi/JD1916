package Work;

import java.io.*;
//3.ʵ�ֵ�¼ע�Ṧ��
//ע��ʱ����user.txt�����û�����Ϣ
//��¼ʱȥ��֤�û��Ƿ���Ե�¼
import java.util.*;

public class Work9_29_3 {
	private static String ID;
	private static String PassWord;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileReader fr=null;
		FileWriter fw = null;
		try {
			fr=new FileReader("src/Work/user.txt");
			fw=new FileWriter("src/Work/user.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (;;) {
			System.out.println("ע������y,��¼����n");
			String s=sc.nextLine();
			if(s.equals("y")) {
				System.out.println("������׼��ʹ�õ��û���");
				ID=sc.nextLine();
				System.out.println("������׼��������");
				PassWord=sc.nextLine();
				try {
					fw.write(ID+" "+PassWord);
					fw.write("\r\n");
					fw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(s.equals("n")) {
				String str=null;
				BufferedReader read=new BufferedReader(fr);
				System.out.println("�����˺�");
				String name=sc.nextLine();
				System.out.println("��������");
				String pass=sc.nextLine();
				try {
					boolean isLoad=false;
					while((str=read.readLine())!=null) {
						if(str.equals(name+" "+pass)) {
							System.out.println("��¼�ɹ�");
							isLoad=true;
							break;
						}
					}
					if(!isLoad) {
						System.out.println("��½ʧ��");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			else {
				System.out.println("��������");
			}
		}
	}
}
