package Myself;

public class Test22 {
    public static int[] twoSum(int[] nums, int target) {
        int a = 0;
        int b=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    a=i;
                    b=j;
                }
            }
        }
        int[] towsum= {nums[a],nums[b]};
        System.out.println("["+a+","+b+"]");
		return towsum;
        
    }
    public static void main(String[] args){
        int[] nums={2,7,11,15};
        int target=9;
        twoSum(nums,target);
    }
}
