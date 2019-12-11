package Work;

//2.在一个集合中存储了无序并且重复的字符串，定义一个方法，
//让其有序（字典排序）还不能去除重复的元素输出。
//字符串：str = “aaa bbb ccc abc ddd aaa aaa abc gh sudo”
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
		System.out.println("排序前:" + list);
		paiXu(list);
		System.out.println("排序后:" + list);

	}

	public static void paiXu(List<String> list) {
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num = s1.compareTo(s2); // 比较内容这主要条件
				return num == 0 ? 1 : num; // 保留重复
			}
		});
		ts.addAll(list);
		list.clear();
		list.addAll(ts);
	}

}
