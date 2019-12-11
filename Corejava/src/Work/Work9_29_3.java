package Work;

import java.io.*;
//3.实现登录注册功能
//注册时候用user.txt保存用户的信息
//登录时去验证用户是否可以登录
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
			System.out.println("注册输入y,登录输入n");
			String s=sc.nextLine();
			if(s.equals("y")) {
				System.out.println("输入您准备使用的用户名");
				ID=sc.nextLine();
				System.out.println("输入您准备的密码");
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
				System.out.println("输入账号");
				String name=sc.nextLine();
				System.out.println("输入密码");
				String pass=sc.nextLine();
				try {
					boolean isLoad=false;
					while((str=read.readLine())!=null) {
						if(str.equals(name+" "+pass)) {
							System.out.println("登录成功");
							isLoad=true;
							break;
						}
					}
					if(!isLoad) {
						System.out.println("登陆失败");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			else {
				System.out.println("重新输入");
			}
		}
	}
}
