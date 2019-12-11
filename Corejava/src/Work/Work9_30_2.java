package Work;

//.统计文本中字符出现的次数,将结果写在count.txt中
import java.io.*;
import java.util.*;

public class Work9_30_2 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String line;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		try {
			fr = new FileReader("src/com/briup/IO/a.txt");
			fw = new FileWriter("src/com/briup/IO/e.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				char[] c = line.toCharArray();
				for (char temp : c) {
					if (map.get(temp) != null) {
						int sum = map.get(temp);
						map.put(temp, ++sum);
					}else
						map.put(temp,1);
				}
			}
			fr.close();
			BufferedWriter bw=new BufferedWriter(fw);
			for(Map.Entry<Character, Integer> entry:map.entrySet()) {
				bw.write(entry.getKey()+" "+entry.getValue()+"\r\n");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
