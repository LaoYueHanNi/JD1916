package Work;

//1.���ı���ת,��һ�е����һ��,���һ�е���һ��
import java.io.*;
import java.util.*;

public class Work9_30_1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new FileReader("src/com/briup/IO/a.txt"));
		
		ArrayList<String> list =new ArrayList<>();
		String line;
		while ((line=br.readLine()) !=null) {
		list.add(line);
		
	}
	br.close();
	BufferedWriter bw =new BufferedWriter(new FileWriter("src/com/briup/IO/b.txt"));
		
	for (int i = list.size()-1; i >=0 ; i--) {
		bw.write(list.get(i));
		bw.newLine();
	}
	bw.close();
	}
}