package exam;

public class N4 {
	public String  getFourNums(int nums) {
		long start = System.currentTimeMillis();
		String resStr="";
		int Fn_1=0,Fn=1,result = 0;
		if(nums==0)  result = 0;
		if(nums==1) 	result = 0;
		else {
			for(int i =2 ;i<=nums;i++) {
				result = Fn_1+Fn;
				Fn_1=Fn;
				Fn=result;
			}
		}
		for(int j = 0;j<4;j++) {
			if(result==0)break;
			int temp = result-result/10*10;
			resStr=temp+resStr;
			result =result/10;
		}
		long end = System.currentTimeMillis();
		return resStr+","+(end-start);
	}
	public static void main(String[] args) {
		System.out.println(new N4().getFourNums(999));
	}
}
