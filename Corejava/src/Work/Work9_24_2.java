package Work;
//����¼��һ��ѧ���ɼ�������ɼ�����[0,100],����ɼ���

//�����׳��쳣������ʾ�ɼ�������[0,100]��

import java.util.Scanner;

public class Work9_24_2 {
	public static void main(String[] args) throws Exception {
		System.out.println("����һ��ѧ���ɼ�,Ӧ��0��100֮��");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a>=0&&a<=100) {
			System.out.println("�ɼ�Ϊ:"+a);
		}
		else {
			throw new Exception("�ɼ�������[0,100]");
		}
		
		
	}
}
