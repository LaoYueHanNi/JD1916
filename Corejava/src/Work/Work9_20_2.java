package Work;

//2.��һ�������д洢���������ظ����ַ���������һ��������
//���������ֵ����򣩻�����ȥ���ظ���Ԫ�������
//�ַ�����str = ��aaa bbb ccc abc ddd aaa aaa abc gh sudo��
import java.util.*;

public class Work9_20_2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("bbb");
		list.add("ccc");
		list.add("abc");
		list.add("ddd");
		list.add("aaa");
		list.add("aaa");
		list.add("abc");
		list.add("gh");
		list.add("sudo");
		System.out.println("����ǰ:" + list);
		paiXu(list);
		System.out.println("�����:" + list);

	}

	public static void paiXu(List<String> list) {
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num = s1.compareTo(s2); // �Ƚ���������Ҫ����
				return num == 0 ? 1 : num; // �����ظ�
			}
		});
		ts.addAll(list);
		list.clear();
		list.addAll(ts);
	}

}
