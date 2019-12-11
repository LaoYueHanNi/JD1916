package Work;
import java.io.*;
import java.util.*;

public class Load {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("先注册,输入用户名");
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/Work/user.txt"));
			BufferedReader br=new BufferedReader(new FileReader("sec/Work/user.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> map=new HashMap<>(); 
	}
}
