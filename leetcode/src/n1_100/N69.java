package n1_100;
/*实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。*/

public class N69 {
	public static void main(String[] args) {
		N69 n69=new N69();
		System.out.println(n69.mySqrt(2147483647));
	}
	public int mySqrt(int x) {
		if(x==0)return 0;
        int left = 1;
        int right = x;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(x/mid>=mid && x/(mid+1)<(mid+1)){
                return mid;
            }
            if(x/mid>=mid)left = mid;
            if(x/mid<mid)right = mid;
        }
        return -1;
	}
}
