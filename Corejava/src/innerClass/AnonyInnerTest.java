package innerClass;
//测试匿名内部类
interface Food{
	public void eat();
}

public class AnonyInnerTest {
	public static void print(Food food)
	{
		food.eat();
	}
	public static void main(String[] args) {
		print(new Food(){
			public void eat() {
				System.out.println("吃苹果");
			}
		});//匿名内部类
	}
}
