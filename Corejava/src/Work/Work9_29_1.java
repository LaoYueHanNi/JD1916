package Work;

import java.util.*;
import java.io.*;

//1.创建一个list集合,list里保存了汽车的信息.将这些汽车信息写到car.txt
//汽车有耗油量
//	品牌
//	颜色
//	重量
//	型号
public class Work9_29_1 {
	
	public static void main(String[] args) throws IOException {
		List<Car> list =new ArrayList<Car>();
		list.add(new Car("6.0L","audi","白色","2t","a7"));
		list.add(new Car("7.0L","audi","白色","1.5t","a3"));
		list.add(new Car("6.0L","audi","白色","2t","a6"));
		list.add(new Car("6.0L","audi","黑色","2.2t","a8"));
		list.add(new Car("6.0L","大奔","白色","2t","a7"));
		FileWriter fw=null;
		
		try {
			fw=new FileWriter("src/Work/car.txt");
			for(int i=0;i<list.size();i++) {
				fw.write(list.get(i).toString());
				fw.write("\r\n");
				
				
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fw.close();
		}
	}
}
class Car{
	private String oil;
	private String type;
	private String color;
	private String weight;
	private String model;
	public Car(String oil, String type, String color, String weight, String model) {
		super();
		this.oil = oil;
		this.type = type;
		this.color = color;
		this.weight = weight;
		this.model = model;
	}
	public String toString() {
		return "oil:"+oil+" "+"type:"+type+" "+"color:"+color+" "+"weight:"+weight+" "+"model:"+model;
	}
	
}
