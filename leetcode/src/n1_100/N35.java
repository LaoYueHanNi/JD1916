package n1_100;

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。*/
public class N35 {
	//修改过的二分 找到得话就返回下标,找不到就返回left得值,因为二分法最后一步要么是left+1.或者是right-1,left总是比right大1
	//所以目标值应该在right和left之间,所以下标应该是left得值
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
 
	public static void main(String[] args) {
		int[] nums = { 5};
		int target = 5;
		System.out.println(new N35().searchInsert(nums, target));
	}
}
