package exam;

import java.util.ArrayList;
import java.util.List;

//1.��10000��99999�ֵ������У��ҵ�AABCC(��11233)���͵��������֡�
public class N1 {

	public List<Integer> getNum() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (i != j && i != k & j != k)
						list.add(i * 10000 + i * 1000 + j * 100 + k * 10 + k);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(new N1().getNum().size());
	}
}
