package Work;
//5.文件grade.txt有如下文本
//1108-女-Eve-09-99
//1109-男-Adam-09-98
//1109-男-Alex-09-90
//1110-女-Andy-09-89
//1111-男-Frank-09-79
//请求出这个班级中的最高分和最低分
import java.io.*;
public class Work9_29_5 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("src/Work/grade.txt");
			BufferedInputStream read=new BufferedInputStream(fis);
			byte[] buff=new byte[512];
			int len=-1;
			while((len=read.read(buff))!=-1) {
				System.out.println(new String(buff,0,len));
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
