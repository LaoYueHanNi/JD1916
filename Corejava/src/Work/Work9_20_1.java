package Work;

//1.��ȡ10��1-20֮����������Ҫ�����ظ�
//1.��������
//2.���������
//3.�ж��Ƿ��ظ�
//4.��ӵ����ϵ���
import java.util.*;

public class Work9_20_1 {
	Random random = new Random();// �����������������������Ķ���

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();// �������ϣ�����ΪInteger
		boolean isRepeat = false;// �����ж��Ƿ��ظ��Ĳ���ֵ����Ĭ��false
		while (list.size() < 10) {
			// ʹ��while�����Ƽ��������������10��
			int num = suiJi();// �������������
			for (int i = 0; i < list.size(); i++) {
				// forѭ���ж����ɵ����Ƿ�ͱ����е�����ͬ
				if (num == list.get(i)) {
					// �����ͬ�������Ϊtrue
					isRepeat = true;
				}
			}
			if (isRepeat == false) {
				// Ϊfalse����ֵ
				list.add(num);
			}
			// ʹ����ֵ��λΪfalse
			isRepeat = false;
		}
		// ��������б�
		for (int index = 0; index < list.size(); index++) {
			System.out.print(list.get(index) + ",");
		}
		// ֱ���������
		// System.out.println(list+" ");
	}

	public static int suiJi() {
		// ����nextInt�������������
		return new Work9_20_1().random.nextInt(20) + 1;
	}
}
