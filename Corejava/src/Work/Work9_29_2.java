  package Work;

//2.ͣ�����н����ͳ����Ĺ���
//1. ����ʱ�����ü���¼��ķ�ʽ��¼��������Ʒ�ơ���ɫ�����ƺš�
//��Ʒ�ơ���ɫ�����ƺţ��Լ�����ʱ��д��car.txt�ļ��С�
//
//2. ����ʱ������¼�복�ƺţ�ȥ�ļ��в��Ҹó��Ľ���ʱ�䣬������ͣ��ʱ�䡣
//
//3. 30��������ѣ�����ÿСʱ3Ԫ������һСʱ��һСʱ���㡣 
// 
//����һ��ͣ������,������¼������ Ʒ��,��ɫ,���ƺ�,�Լ� ����ʱ��
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Work9_29_2 {
	public static void main(String[] args) throws IOException {
		ArrayList<CarPark> arrayList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("����������ǳ���,����y or n\n����0�˳�");
			String inpuStr = sc.nextLine();
			if (inpuStr.equals("y")) {
				// ����
				ruChang();
			} else if (inpuStr.equals("n")) {
				// ����
				chuChang();
			} else if (inpuStr.equals("0")) {
				System.exit(0);
			} else
				System.out.println("���벻��ȷ!,����������");

		}

	}

	private static void chuChang() throws IOException {
		/* ����ʱ������¼�복�ƺţ�ȥ�ļ��в��Ҹó��Ľ���ʱ�䣬������ͣ��ʱ�䡣 */
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
		// .println("���Դ��� �ȴ�ɾ��");
		// �и�ÿһ��
		String[] sp1 = sb.toString().split("\r\n");
		for (String line : sp1) {
			String[] array = line.split(",");
			CarPark tc = new CarPark(array[0], array[1], array[2], array[3]);
			arrayList.add(tc);
		}
		// ��������ȶ�
		System.out.println("��������ĳ��ƺ�");
		Scanner sc = new Scanner(System.in);
		String inputSring = sc.nextLine();
		String Time = "";
		String nowTime = "";
		/* ����ʱ������¼�복�ƺţ�ȥ�ļ��в��Ҹó��Ľ���ʱ�䣬������ͣ��ʱ�䡣 */
		for (CarPark tcs : arrayList) {
			if (tcs.getCarNum().equals(inputSring)) {
				nowTime = System.currentTimeMillis() + "";
				Time = tcs.getTime();
			}
		}
		long realTime = (Long.parseLong(nowTime) - Long.parseLong(Time)) / 1000 / 60;
		/* 30��������ѣ�����ÿСʱ3Ԫ������һСʱ��һСʱ���㡣 */
		// System.out.println("realTime = "+realTime);
		getPrice(realTime);
		fr.close();
	}

	/*
	 * ����۸�
	 */
	private static void getPrice(long realTime) {
		if (realTime <= 30) {
			System.out.println("30�����������!,��ͣ����" + realTime + "����");
		} else if (realTime > 30 && realTime < 60) {
			System.out.println("30-60�շ�3Ԫ,��ͣ����" + realTime + "����");
		} else {
			long count = realTime / 60 + 1;
			System.out.println("����һСʱÿСʱ3Ԫ�շ�:" + count * 3 + "Ԫ,��ͣ����" + realTime + "����");
		}
	}

	private static void ruChang() throws IOException {
		/*
		 * 1. ����ʱ�����ü���¼��ķ�ʽ��¼��������Ʒ�ơ���ɫ�����ƺš� ��Ʒ�ơ���ɫ�����ƺţ��Լ�����ʱ��д��car.txt�ļ��С�
		 */
		Scanner sc = new Scanner(System.in);

		CarPark tc = new CarPark();
		System.out.println("������������Ʒ��");
		tc.setBrand(sc.nextLine());
		System.out.println("��������������ɫ");
		tc.setColor(sc.nextLine());
		System.out.println("�����������ĳ��ƺ�");
		tc.setCarNum(sc.nextLine());
		// ��ȡϵͳʱ��
		long nowTime = System.currentTimeMillis();
		tc.setTime(nowTime + "");
		// д���ļ�
		File file = new File("C:\\ideaProjects\\job-code\\day09\\src\\��������\\car.txt");
		// д��
		FileWriter wf = new FileWriter(file, true);
		StringBuilder sb = new StringBuilder();
		sb.append(tc.getBrand()).append(",").append(tc.getColor()).append(",").append(tc.getCarNum()).append(",")
				.append(tc.getTime()).append("\r\n");
		wf.write(sb.toString());
		wf.close();
		System.out.println("д��ɹ�!");
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