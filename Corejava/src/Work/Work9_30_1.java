package Work;

//1.将文本反转,第一行到最后一行,最后一行到第一行
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