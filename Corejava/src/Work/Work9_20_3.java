package Work;

import java.util.*;

public class Work9_20_3 {
	public static void main(String[] args) {
		// 创建map存放有标号的公交站名
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "浦东软件园");
		map.put(2, "中创软件");
		map.put(3, "创业大厦");
		map.put(4, "托普学院");
		map.put(5, "阳澄湖庄");
		map.put(6, "湖滨路大禹路");
		map.put(7, "文豪花园");
		map.put(8, "蟹市场");
		map.put(9, "湖滨路迎宾路");
		map.put(10, "玫瑰园");
		map.put(11, "城北西路湖亭路");
		map.put(12, "葡萄研究所");
		map.put(13, "望河桥");
		map.put(14, "黄泥山村");
		map.put(15, "登云学院 ");
		map.put(16, "马鞍山路思常路");
		map.put(17, "森林公园");
		map.put(18, "森林半岛");
		map.put(19, "马鞍山路鹿城路 ");
		map.put(20, "长虹大桥");
		// 定义两个值,后期存放公交站的标号
		int start = 0;
		int end = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入起始站:");
		String strStart = scanner.nextLine();
		// 判断起始站的标号并存放
		for (int key = 1; key <= map.size(); key++) {
			String s = map.get(key);
			if (strStart.equals(s)) {
				start = key;
				break;
			}
		}
		// 判断是否进行下一步
		if (start == 0) {
			System.out.println("你上错车了");
		} else {
			// 进入到达站的判断
			System.out.println("请输入到达站:");
			String strEnd = scanner.nextLine();
			for (int key = 1; key <= map.size(); key++) {
				String t = map.get(key);
				if (strEnd.equals(t)) {
					end = key;
					break;
				}
			}
			// 判断是否进入下一步
			if (end == 0) {
				System.out.println("你上错车了");
			} else {
				// 计算差几站
				int a = Math.abs(start - end);
				// 判断车费
				if (a <= 4) {
					System.out.println("从" + strStart + "到" + strEnd + "过" + a + "站,收费" + 1 + "元");
				}
				if (a > 4 && a <= 8) {
					System.out.println("从" + strStart + "到" + strEnd + "过" + a + "站,收费" + 2 + "元");
				}
				if (a > 8 && a <= 12) {
					System.out.println("从" + strStart + "到" + strEnd + "过" + a + "站,收费" + 3 + "元");
				}
				if (a > 12 && a <= 16) {
					System.out.println("从" + strStart + "到" + strEnd + "过" + a + "站,收费" + 4 + "元");
				}
				if (a > 16) {
					System.out.println("从" + strStart + "到" + strEnd + "过" + a + "站,收费" + (a - 16 + 4) + "元");
				}
			}
		}
	}

}
