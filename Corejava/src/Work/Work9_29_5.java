package Work;
//5.�ļ�grade.txt�������ı�
//1108-Ů-Eve-09-99
//1109-��-Adam-09-98
//1109-��-Alex-09-90
//1110-Ů-Andy-09-89
//1111-��-Frank-09-79
//���������༶�е���߷ֺ���ͷ�
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
