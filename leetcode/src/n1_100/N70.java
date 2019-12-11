package n1_100;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//注意：给定 n 是一个正整数。
public class N70 {
	
	public int climbStairs(int n) {
         int step_1 = 1;//一层需要一步
         int step_2 = 2;//两层需要两步
         int result = 0;//结果
         if(n==1)return step_1;
         if(n==2)return step_2;
         for(int i =3;i<=n;i++) {
        	 //累加,n层台阶需要的步数是n-1层和n-2层台阶需要步数的和
        	 result=step_1+step_2;//n层需要的
        	 //赋值
        	 step_1=step_2;
        	 step_2=result;
         }
		return result;
    }
}
