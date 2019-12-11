package innerClass;
 //同时找出数组中的最大值和最小值
public class MaxOrMinTest {
	class MaxMin{
		private int max;
		private int min;
		public MaxMin(int max,int min) {
			this.max=max;
			this.min=min;
		}
		public int getMax() {
			return max;
		}
		public int getMin() {
			return min;
		}
	}
	//同时返回最大和最小值
	public MaxMin getMaxOrMin(int[] arr1) {
		int max=arr1[0];
		int min=arr1[0];
		for(int i=1;i<arr1.length;i++) {
			if(max<arr1[i])max=arr1[i];
			if(min>arr1[i])min=arr1[i];
		}
		return new MaxMin(max,min);
	}
	public static void main(String[] args) {
		int[] arr1= {32,33,54,22,14,3}; 
		MaxOrMinTest t=new MaxOrMinTest();
		MaxMin mm=t.getMaxOrMin(arr1);
		System.out.println("Max:"+mm.getMax());
		System.out.println("Min:"+mm.getMin());
	}
}
