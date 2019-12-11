  package Work;

//2.停车场有进场和出场的功能
//1. 进场时：采用键盘录入的方式，录入汽车的品牌、颜色、车牌号。
//把品牌、颜色、车牌号，以及进场时间写入car.txt文件中。
//
//2. 出场时：键盘录入车牌号，去文件中查找该车的进场时间，并计算停车时间。
//
//3. 30分钟内免费，过后每小时3元，超过一小时安一小时计算。 
// 
//创建一个停车场类,用来记录汽车的 品牌,颜色,车牌号,以及 进场时间
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Work9_29_2 {
	public static void main(String[] args) throws IOException {
		ArrayList<CarPark> arrayList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("请输进场还是出场,输入y or n\n输入0退出");
			String inpuStr = sc.nextLine();
			if (inpuStr.equals("y")) {
				// 进场
				ruChang();
			} else if (inpuStr.equals("n")) {
				// 出场
				chuChang();
			} else if (inpuStr.equals("0")) {
				System.exit(0);
			} else
				System.out.println("输入不正确!,请重新输入");

		}

	}

	private static void chuChang() throws IOException {
		/* 出场时：键盘录入车牌号，去文件中查找该车的进场时间，并计算停车时间。 */
		ArrayList<CarPark> arrayList = new ArrayList<>();
		File file = new File("src/Work/car.txt");
		FileReader fr = new FileReader(file);
		StringBuilder sb = new StringBuilder();
		int len;
		char arr[] = new char[1024];
		while ((len = fr.read(arr)) != -1) {
			sb.append(arr, 0, len);
		}
		System.out.println(sb);
		// System.out
		// .println("测试代码 等待删除");
		// 切割每一行
		String[] sp1 = sb.toString().split("\r\n");
		for (String line : sp1) {
			String[] array = line.split(",");
			CarPark tc = new CarPark(array[0], array[1], array[2], array[3]);
			arrayList.add(tc);
		}
		// 请求输入比对
		System.out.println("请输入你的车牌号");
		Scanner sc = new Scanner(System.in);
		String inputSring = sc.nextLine();
		String Time = "";
		String nowTime = "";
		/* 出场时：键盘录入车牌号，去文件中查找该车的进场时间，并计算停车时间。 */
		for (CarPark tcs : arrayList) {
			if (tcs.getCarNum().equals(inputSring)) {
				nowTime = System.currentTimeMillis() + "";
				Time = tcs.getTime();
			}
		}
		long realTime = (Long.parseLong(nowTime) - Long.parseLong(Time)) / 1000 / 60;
		/* 30分钟内免费，过后每小时3元，超过一小时安一小时计算。 */
		// System.out.println("realTime = "+realTime);
		getPrice(realTime);
		fr.close();
	}

	/*
	 * 计算价格
	 */
	private static void getPrice(long realTime) {
		if (realTime <= 30) {
			System.out.println("30分钟以内免费!,您停车了" + realTime + "分钟");
		} else if (realTime > 30 && realTime < 60) {
			System.out.println("30-60收费3元,您停车了" + realTime + "分钟");
		} else {
			long count = realTime / 60 + 1;
			System.out.println("超过一小时每小时3元收费:" + count * 3 + "元,您停车了" + realTime + "分钟");
		}
	}

	private static void ruChang() throws IOException {
		/*
		 * 1. 进场时：采用键盘录入的方式，录入汽车的品牌、颜色、车牌号。 把品牌、颜色、车牌号，以及进场时间写入car.txt文件中。
		 */
		Scanner sc = new Scanner(System.in);

		CarPark tc = new CarPark();
		System.out.println("请输入汽车的品牌");
		tc.setBrand(sc.nextLine());
		System.out.println("请输入汽车的颜色");
		tc.setColor(sc.nextLine());
		System.out.println("请输入汽车的车牌号");
		tc.setCarNum(sc.nextLine());
		// 获取系统时间
		long nowTime = System.currentTimeMillis();
		tc.setTime(nowTime + "");
		// 写入文件
		File file = new File("C:\\ideaProjects\\job-code\\day09\\src\\老王的题\\car.txt");
		// 写入
		FileWriter wf = new FileWriter(file, true);
		StringBuilder sb = new StringBuilder();
		sb.append(tc.getBrand()).append(",").append(tc.getColor()).append(",").append(tc.getCarNum()).append(",")
				.append(tc.getTime()).append("\r\n");
		wf.write(sb.toString());
		wf.close();
		System.out.println("写入成功!");
	}
}

class CarPark {
	private String brand;
	private String color;
	private String carNum;
	private String time;
	
	public CarPark() {
		
	}
	public CarPark(String brand, String color, String carNum, String time) {
		super();
		this.brand = brand;
		this.color = color;
		this.carNum = carNum;
		this.time = time;
	}
	
	public String toString() {
		return "CarPark{" + "brand='" + brand + '\'' + "," + " color='" + color + '\'' + ", carNum='" + carNum + '\''
				+ ", time='" + time + '\'' + '}';

	}

	public String getBrand() {
		return brand;
	}

	public void setTime(double d) {
		// TODO Auto-generated method stub

	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String d) {
		this.time = d;
	}
}