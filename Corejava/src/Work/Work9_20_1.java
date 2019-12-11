package Work;

//1.获取10个1-20之间的随机数，要求不能重复
//1.创建集合
//2.生成随机数
//3.判断是否重复
//4.添加到集合当中
import java.util.*;

public class Work9_20_1 {
	Random random = new Random();// 创造出用来调用随机数方法的对象

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();// 创建集合，泛型为Integer
		boolean isRepeat = false;// 创建判断是否重复的布尔值，，默认false
		while (list.size() < 10) {
			// 使用while来控制加入的数量不超过10个
			int num = suiJi();// 调用随机数方法
			for (int i = 0; i < list.size(); i++) {
				// for循环判断生成的数是否和本来有的数相同
				if (num == list.get(i)) {
					// 如果相同，则令布尔为true
					isRepeat = true;
				}
			}
			if (isRepeat == false) {
				// 为false加入值
				list.add(num);
			}
			// 使布尔值复位为false
			isRepeat = false;
		}
		// 遍历输出列表
		for (int index = 0; index < list.size(); index++) {
			System.out.print(list.get(index) + ",");
		}
		// 直接输出集合
		// System.out.println(list+" ");
	}

	public static int suiJi() {
		// 调用nextInt方法生成随机数
		return new Work9_20_1().random.nextInt(20) + 1;
	}
}
